package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gr;

@ey
public class gb {
   private final Object mH = new Object();
   private final String vZ;
   private int wm = 0;
   private long wn = -1L;
   private long wo = -1L;
   private int wp = 0;
   private int wq = -1;

   public gb(String var1) {
      this.vZ = var1;
   }

   public static boolean m(Context var0) {
      int var1 = var0.getResources().getIdentifier("Theme.Translucent", "style", "android");
      if(var1 == 0) {
         gr.U("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
         return false;
      } else {
         ComponentName var2 = new ComponentName(var0.getPackageName(), "com.google.android.gms.ads.AdActivity");

         try {
            if(var1 == var0.getPackageManager().getActivityInfo(var2, 0).theme) {
               return true;
            } else {
               gr.U("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
               return false;
            }
         } catch (NameNotFoundException var3) {
            gr.W("Fail to fetch AdActivity theme");
            gr.U("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
         }
      }
   }

   public Bundle b(Context param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   public void b(av param1, long param2) {
      // $FF: Couldn't be decompiled
   }

   public void cW() {
      // $FF: Couldn't be decompiled
   }

   public void cX() {
      // $FF: Couldn't be decompiled
   }

   public long dq() {
      return this.wo;
   }
}
