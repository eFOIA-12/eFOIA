package com.crashlytics.android.core;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;

final class Utils {
   public static void capFileCount(File var0, FilenameFilter var1, int var2, Comparator var3) {
      File[] var7 = var0.listFiles(var1);
      if(var7 != null && var7.length > var2) {
         Arrays.sort(var7, var3);
         int var5 = var7.length;
         int var6 = var7.length;

         for(int var4 = 0; var4 < var6; ++var4) {
            File var8 = var7[var4];
            if(var5 <= var2) {
               break;
            }

            var8.delete();
            --var5;
         }
      }

   }
}
