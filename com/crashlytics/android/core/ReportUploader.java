package com.crashlytics.android.core;

import com.crashlytics.android.core.CrashlyticsCore;
import com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler;
import com.crashlytics.android.core.CreateReportSpiCall;
import com.crashlytics.android.core.Report;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.common.BackgroundPriorityRunnable;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class ReportUploader {
   private static final String CLS_FILE_EXT = ".cls";
   static final Map HEADER_INVALID_CLS_FILE = Collections.singletonMap("X-CRASHLYTICS-INVALID-SESSION", "1");
   private static final short[] RETRY_INTERVALS = new short[]{(short)10, (short)20, (short)30, (short)60, (short)120, (short)300};
   private static final FilenameFilter crashFileFilter = new FilenameFilter() {
      public boolean accept(File var1, String var2) {
         return var2.endsWith(".cls") && !var2.contains("Session");
      }
   };
   private final CreateReportSpiCall createReportCall;
   private final Object fileAccessLock = new Object();
   private Thread uploadThread;

   public ReportUploader(CreateReportSpiCall var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("createReportCall must not be null.");
      } else {
         this.createReportCall = var1;
      }
   }

   List findReports() {
      // $FF: Couldn't be decompiled
   }

   boolean forceUpload(Report param1) {
      // $FF: Couldn't be decompiled
   }

   boolean isUploading() {
      return this.uploadThread != null;
   }

   public void uploadReports() {
      this.uploadReports(0.0F);
   }

   public void uploadReports(float var1) {
      synchronized(this){}

      try {
         if(this.uploadThread == null) {
            this.uploadThread = new Thread(new ReportUploader.Worker(var1), "Crashlytics Report Uploader");
            this.uploadThread.start();
         }
      } finally {
         ;
      }

   }

   private class Worker extends BackgroundPriorityRunnable {
      private final float delay;

      Worker(float var2) {
         this.delay = var2;
      }

      private void attemptUploadWithRetry() {
         Fabric.getLogger().d("Fabric", "Starting report processing in " + this.delay + " second(s)...");
         if(this.delay > 0.0F) {
            try {
               Thread.sleep((long)(this.delay * 1000.0F));
            } catch (InterruptedException var8) {
               Thread.currentThread().interrupt();
               return;
            }
         }

         CrashlyticsCore var5 = CrashlyticsCore.getInstance();
         CrashlyticsUncaughtExceptionHandler var6 = var5.getHandler();
         List var4 = ReportUploader.this.findReports();
         if(!var6.isHandlingException()) {
            Iterator var9;
            if(!var4.isEmpty() && !var5.canSendWithUserApproval()) {
               Fabric.getLogger().d("Fabric", "User declined to send. Removing " + var4.size() + " Report(s).");
               var9 = var4.iterator();

               while(var9.hasNext()) {
                  ((Report)var9.next()).remove();
               }
            } else {
               int var1 = 0;

               while(!var4.isEmpty() && !CrashlyticsCore.getInstance().getHandler().isHandlingException()) {
                  Fabric.getLogger().d("Fabric", "Attempting to send " + var4.size() + " report(s)");
                  var9 = var4.iterator();

                  while(var9.hasNext()) {
                     Report var10 = (Report)var9.next();
                     ReportUploader.this.forceUpload(var10);
                  }

                  List var11 = ReportUploader.this.findReports();
                  var4 = var11;
                  if(!var11.isEmpty()) {
                     long var2 = (long)ReportUploader.RETRY_INTERVALS[Math.min(var1, ReportUploader.RETRY_INTERVALS.length - 1)];
                     Fabric.getLogger().d("Fabric", "Report submisson: scheduling delayed retry in " + var2 + " seconds");

                     try {
                        Thread.sleep(1000L * var2);
                     } catch (InterruptedException var7) {
                        Thread.currentThread().interrupt();
                        return;
                     }

                     ++var1;
                     var4 = var11;
                  }
               }
            }
         }

      }

      public void onRun() {
         try {
            this.attemptUploadWithRetry();
         } catch (Exception var2) {
            Fabric.getLogger().e("Fabric", "An unexpected error occurred while attempting to upload crash reports.", var2);
         }

         ReportUploader.this.uploadThread = null;
      }
   }
}
