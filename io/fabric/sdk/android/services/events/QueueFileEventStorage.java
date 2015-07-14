package io.fabric.sdk.android.services.events;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.QueueFile;
import io.fabric.sdk.android.services.events.EventsStorage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class QueueFileEventStorage implements EventsStorage {
   private final Context context;
   private QueueFile queueFile;
   private File targetDirectory;
   private final String targetDirectoryName;
   private final File workingDirectory;
   private final File workingFile;

   public QueueFileEventStorage(Context var1, File var2, String var3, String var4) throws IOException {
      this.context = var1;
      this.workingDirectory = var2;
      this.targetDirectoryName = var4;
      this.workingFile = new File(this.workingDirectory, var3);
      this.queueFile = new QueueFile(this.workingFile);
      this.createTargetDirectory();
   }

   private void createTargetDirectory() {
      this.targetDirectory = new File(this.workingDirectory, this.targetDirectoryName);
      if(!this.targetDirectory.exists()) {
         this.targetDirectory.mkdirs();
      }

   }

   private void move(File param1, File param2) throws IOException {
      // $FF: Couldn't be decompiled
   }

   public void add(byte[] var1) throws IOException {
      this.queueFile.add(var1);
   }

   public boolean canWorkingFileStore(int var1, int var2) {
      return this.queueFile.hasSpaceFor(var1, var2);
   }

   public void deleteFilesInRollOverDirectory(List var1) {
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         File var2 = (File)var3.next();
         CommonUtils.logControlled(this.context, String.format("deleting sent analytics file %s", new Object[]{var2.getName()}));
         var2.delete();
      }

   }

   public void deleteWorkingFile() {
      try {
         this.queueFile.close();
      } catch (IOException var2) {
         ;
      }

      this.workingFile.delete();
   }

   public List getAllFilesInRollOverDirectory() {
      return Arrays.asList(this.targetDirectory.listFiles());
   }

   public List getBatchOfFilesToSend(int var1) {
      ArrayList var4 = new ArrayList();
      File[] var5 = this.targetDirectory.listFiles();
      int var3 = var5.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         var4.add(var5[var2]);
         if(var4.size() >= var1) {
            break;
         }
      }

      return var4;
   }

   public OutputStream getMoveOutputStream(File var1) throws IOException {
      return new FileOutputStream(var1);
   }

   public File getRollOverDirectory() {
      return this.targetDirectory;
   }

   public File getWorkingDirectory() {
      return this.workingDirectory;
   }

   public int getWorkingFileUsedSizeInBytes() {
      return this.queueFile.usedBytes();
   }

   public boolean isWorkingFileEmpty() {
      return this.queueFile.isEmpty();
   }

   public void rollOver(String var1) throws IOException {
      this.queueFile.close();
      this.move(this.workingFile, new File(this.targetDirectory, var1));
      this.queueFile = new QueueFile(this.workingFile);
   }
}
