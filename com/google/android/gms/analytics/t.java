package com.google.android.gms.analytics;

import android.os.Build.VERSION;
import com.google.android.gms.analytics.ae;
import java.io.File;

public class t {
   public static boolean ag(String var0) {
      if(version() < 9) {
         return false;
      } else {
         File var1 = new File(var0);
         var1.setReadable(false, false);
         var1.setWritable(false, false);
         var1.setReadable(true, true);
         var1.setWritable(true, true);
         return true;
      }
   }

   public static int version() {
      try {
         int var0 = Integer.parseInt(VERSION.SDK);
         return var0;
      } catch (NumberFormatException var2) {
         ae.T("Invalid version number: " + VERSION.SDK);
         return 0;
      }
   }
}
