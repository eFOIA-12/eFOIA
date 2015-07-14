package io.fabric.sdk.android.services.events;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import io.fabric.sdk.android.services.events.EventTransform;
import io.fabric.sdk.android.services.events.EventsStorage;
import io.fabric.sdk.android.services.events.EventsStorageListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class EventsFilesManager {
   public static final int MAX_FILES_IN_BATCH = 1;
   public static final int MAX_FILES_TO_KEEP = 100;
   public static final String ROLL_OVER_FILE_NAME_SEPARATOR = "_";
   protected final Context context;
   protected final CurrentTimeProvider currentTimeProvider;
   private final int defaultMaxFilesToKeep;
   protected final EventsStorage eventStorage;
   protected volatile long lastRollOverTime;
   protected final List rollOverListeners = new CopyOnWriteArrayList();
   protected final EventTransform transform;

   public EventsFilesManager(Context var1, EventTransform var2, CurrentTimeProvider var3, EventsStorage var4, int var5) throws IOException {
      this.context = var1.getApplicationContext();
      this.transform = var2;
      this.eventStorage = var4;
      this.currentTimeProvider = var3;
      this.lastRollOverTime = this.currentTimeProvider.getCurrentTimeMillis();
      this.defaultMaxFilesToKeep = var5;
   }

   private void rollFileOverIfNeeded(int var1) throws IOException {
      if(!this.eventStorage.canWorkingFileStore(var1, this.getMaxByteSizePerFile())) {
         String var2 = String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", new Object[]{Integer.valueOf(this.eventStorage.getWorkingFileUsedSizeInBytes()), Integer.valueOf(var1), Integer.valueOf(this.getMaxByteSizePerFile())});
         CommonUtils.logControlled(this.context, 4, "Fabric", var2);
         this.rollFileOver();
      }

   }

   private void triggerRollOverOnListeners(String var1) {
      Iterator var2 = this.rollOverListeners.iterator();

      while(var2.hasNext()) {
         EventsStorageListener var3 = (EventsStorageListener)var2.next();

         try {
            var3.onRollOver(var1);
         } catch (Exception var4) {
            CommonUtils.logControlledError(this.context, "One of the roll over listeners threw an exception", var4);
         }
      }

   }

   public void deleteAllEventsFiles() {
      this.eventStorage.deleteFilesInRollOverDirectory(this.eventStorage.getAllFilesInRollOverDirectory());
      this.eventStorage.deleteWorkingFile();
   }

   public void deleteOldestInRollOverIfOverMax() {
      List var4 = this.eventStorage.getAllFilesInRollOverDirectory();
      int var1 = this.getMaxFilesToKeep();
      if(var4.size() > var1) {
         int var2 = var4.size() - var1;
         CommonUtils.logControlled(this.context, String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", new Object[]{Integer.valueOf(var4.size()), Integer.valueOf(var1), Integer.valueOf(var2)}));
         TreeSet var3 = new TreeSet(new Comparator() {
            public int compare(EventsFilesManager.FileWithTimestamp var1, EventsFilesManager.FileWithTimestamp var2) {
               return (int)(var1.timestamp - var2.timestamp);
            }
         });
         Iterator var7 = var4.iterator();

         while(var7.hasNext()) {
            File var5 = (File)var7.next();
            var3.add(new EventsFilesManager.FileWithTimestamp(var5, this.parseCreationTimestampFromFileName(var5.getName())));
         }

         ArrayList var8 = new ArrayList();
         Iterator var6 = var3.iterator();

         while(var6.hasNext()) {
            var8.add(((EventsFilesManager.FileWithTimestamp)var6.next()).file);
            if(var8.size() == var2) {
               break;
            }
         }

         this.eventStorage.deleteFilesInRollOverDirectory(var8);
      }
   }

   public void deleteSentFiles(List var1) {
      this.eventStorage.deleteFilesInRollOverDirectory(var1);
   }

   protected abstract String generateUniqueRollOverFileName();

   public List getBatchOfFilesToSend() {
      return this.eventStorage.getBatchOfFilesToSend(1);
   }

   public long getLastRollOverTime() {
      return this.lastRollOverTime;
   }

   protected int getMaxByteSizePerFile() {
      return 8000;
   }

   protected int getMaxFilesToKeep() {
      return this.defaultMaxFilesToKeep;
   }

   public long parseCreationTimestampFromFileName(String var1) {
      String[] var5 = var1.split("_");
      if(var5.length != 3) {
         return 0L;
      } else {
         try {
            long var2 = Long.valueOf(var5[2]).longValue();
            return var2;
         } catch (NumberFormatException var4) {
            return 0L;
         }
      }
   }

   public void registerRollOverListener(EventsStorageListener var1) {
      if(var1 != null) {
         this.rollOverListeners.add(var1);
      }

   }

   public boolean rollFileOver() throws IOException {
      boolean var1 = false;
      String var2 = null;
      if(!this.eventStorage.isWorkingFileEmpty()) {
         var2 = this.generateUniqueRollOverFileName();
         this.eventStorage.rollOver(var2);
         CommonUtils.logControlled(this.context, 4, "Fabric", String.format(Locale.US, "generated new file %s", new Object[]{var2}));
         this.lastRollOverTime = this.currentTimeProvider.getCurrentTimeMillis();
         var1 = true;
      }

      this.triggerRollOverOnListeners(var2);
      return var1;
   }

   public void writeEvent(Object var1) throws IOException {
      byte[] var2 = this.transform.toBytes(var1);
      this.rollFileOverIfNeeded(var2.length);
      this.eventStorage.add(var2);
   }

   static class FileWithTimestamp {
      final File file;
      final long timestamp;

      public FileWithTimestamp(File var1, long var2) {
         this.file = var1;
         this.timestamp = var2;
      }
   }
}
