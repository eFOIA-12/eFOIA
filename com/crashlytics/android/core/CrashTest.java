package com.crashlytics.android.core;

import android.os.AsyncTask;
import io.fabric.sdk.android.Fabric;

public class CrashTest {
   private void privateMethodThatThrowsException(String var1) {
      throw new RuntimeException(var1);
   }

   public void crashAsyncTask(final long var1) {
      (new AsyncTask() {
         protected Void doInBackground(Void... var1x) {
            try {
               Thread.sleep(var1);
            } catch (InterruptedException var2) {
               ;
            }

            CrashTest.this.throwRuntimeException("Background thread crash");
            return null;
         }
      }).execute(new Void[]{(Void)null});
   }

   public void indexOutOfBounds() {
      int var1 = (new int[2])[10];
      Fabric.getLogger().d("Fabric", "Out of bounds value: " + var1);
   }

   public int stackOverflow() {
      return this.stackOverflow() + (int)Math.random();
   }

   public void throwFiveChainedExceptions() {
      try {
         this.privateMethodThatThrowsException("1");
      } catch (Exception var5) {
         Exception var1 = var5;

         try {
            throw new RuntimeException("2", var1);
         } catch (Exception var4) {
            var1 = var4;

            try {
               throw new RuntimeException("3", var1);
            } catch (Exception var3) {
               var1 = var3;

               try {
                  throw new RuntimeException("4", var1);
               } catch (Exception var2) {
                  throw new RuntimeException("5", var2);
               }
            }
         }
      }
   }

   public void throwRuntimeException(String var1) {
      throw new RuntimeException(var1);
   }
}
