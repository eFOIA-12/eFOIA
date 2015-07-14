package com.crashlytics.android.core;

import android.content.Context;
import com.crashlytics.android.core.ByteString;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.QueueFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

class LogFileManager {
   static final int MAX_LOG_SIZE = 65536;
   private final Context context;
   private final File filesDir;
   private QueueFile logFile;

   public LogFileManager(Context var1, File var2) {
      this(var1, var2, (QueueFile)null);
   }

   LogFileManager(Context var1, File var2, QueueFile var3) {
      this.context = var1;
      this.filesDir = var2;
      this.logFile = var3;
   }

   private boolean initLogFile() {
      if(!CommonUtils.getBooleanResourceValue(this.context, "com.crashlytics.CollectCustomLogs", true)) {
         Fabric.getLogger().d("Fabric", "Preferences requested no custom logs. Aborting log file creation.");
         return false;
      } else {
         CommonUtils.closeOrLog(this.logFile, "Could not close log file: " + this.logFile);
         File var2 = null;

         Exception var1;
         label21: {
            File var7;
            try {
               String var6 = "crashlytics-userlog-" + UUID.randomUUID().toString() + ".temp";
               var7 = new File(this.filesDir, var6);
            } catch (Exception var5) {
               var1 = var5;
               break label21;
            }

            try {
               this.logFile = new QueueFile(var7);
               var7.delete();
               return true;
            } catch (Exception var4) {
               var2 = var7;
               var1 = var4;
            }
         }

         Fabric.getLogger().e("Fabric", "Could not create log file: " + var2, var1);
         return false;
      }
   }

   void closeLogFile() {
      CommonUtils.closeOrLog(this.logFile, "There was a problem closing the Crashlytics log file.");
      this.logFile = null;
   }

   void doWriteToLog(int param1, long param2, String param4) {
      // $FF: Couldn't be decompiled
   }

   ByteString getByteStringForLog() {
      if(this.logFile == null) {
         return null;
      } else {
         final int[] var1 = new int[]{0};
         final byte[] var2 = new byte[this.logFile.usedBytes()];

         try {
            this.logFile.forEach(new QueueFile.ElementReader() {
               public void read(InputStream var1x, int var2x) throws IOException {
                  boolean var5 = false;

                  int[] var3;
                  try {
                     var5 = true;
                     var1x.read(var2, var1[0], var2x);
                     var3 = var1;
                     var5 = false;
                  } finally {
                     if(var5) {
                        var1x.close();
                     }
                  }

                  var3[0] += var2x;
                  var1x.close();
               }
            });
         } catch (IOException var4) {
            Fabric.getLogger().e("Fabric", "A problem occurred while reading the Crashlytics log file.", var4);
         }

         return ByteString.copyFrom(var2, 0, var1[0]);
      }
   }

   public void writeToLog(long var1, String var3) {
      if(this.logFile == null) {
         this.initLogFile();
      }

      this.doWriteToLog(65536, var1, var3);
   }
}
