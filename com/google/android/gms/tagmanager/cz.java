package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

class cz {
   static void a(Context var0, String var1, String var2, String var3) {
      Editor var4 = var0.getSharedPreferences(var1, 0).edit();
      var4.putString(var2, var3);
      a(var4);
   }

   static void a(final Editor var0) {
      if(VERSION.SDK_INT >= 9) {
         var0.apply();
      } else {
         (new Thread(new Runnable() {
            public void run() {
               var0.commit();
            }
         })).start();
      }
   }
}
