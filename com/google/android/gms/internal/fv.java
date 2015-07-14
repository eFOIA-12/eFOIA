package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.gq;
import java.util.Locale;

@ey
public final class fv {
   public final boolean vA;
   public final boolean vB;
   public final int vC;
   public final int vg;
   public final boolean vh;
   public final boolean vi;
   public final String vj;
   public final String vk;
   public final boolean vl;
   public final boolean vm;
   public final boolean vn;
   public final String vo;
   public final String vp;
   public final int vq;
   public final int vr;
   public final int vs;
   public final int vt;
   public final int vu;
   public final int vv;
   public final float vw;
   public final int vx;
   public final int vy;
   public final double vz;

   public fv(Context var1) {
      boolean var6 = true;
      super();
      AudioManager var7 = (AudioManager)var1.getSystemService("audio");
      ConnectivityManager var8 = (ConnectivityManager)var1.getSystemService("connectivity");
      DisplayMetrics var9 = var1.getResources().getDisplayMetrics();
      Locale var10 = Locale.getDefault();
      PackageManager var11 = var1.getPackageManager();
      TelephonyManager var12 = (TelephonyManager)var1.getSystemService("phone");
      Intent var13 = var1.registerReceiver((BroadcastReceiver)null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      this.vg = var7.getMode();
      boolean var5;
      if(a(var11, "geo:0,0?q=donuts") != null) {
         var5 = true;
      } else {
         var5 = false;
      }

      this.vh = var5;
      if(a(var11, "http://www.google.com") != null) {
         var5 = true;
      } else {
         var5 = false;
      }

      this.vi = var5;
      this.vj = var12.getNetworkOperator();
      this.vk = var10.getCountry();
      this.vl = gq.dA();
      this.vm = var7.isMusicActive();
      this.vn = var7.isSpeakerphoneOn();
      this.vo = var10.getLanguage();
      this.vp = a(var11);
      this.vq = var7.getStreamVolume(3);
      this.vr = a(var1, var8, var11);
      this.vs = var12.getNetworkType();
      this.vt = var12.getPhoneType();
      this.vu = var7.getRingerMode();
      this.vv = var7.getStreamVolume(2);
      this.vw = var9.density;
      this.vx = var9.widthPixels;
      this.vy = var9.heightPixels;
      if(var13 != null) {
         int var2 = var13.getIntExtra("status", -1);
         int var3 = var13.getIntExtra("level", -1);
         int var4 = var13.getIntExtra("scale", -1);
         this.vz = (double)((float)var3 / (float)var4);
         var5 = var6;
         if(var2 != 2) {
            if(var2 == 5) {
               var5 = var6;
            } else {
               var5 = false;
            }
         }

         this.vA = var5;
      } else {
         this.vz = -1.0D;
         this.vA = false;
      }

      if(VERSION.SDK_INT >= 16) {
         this.vB = var8.isActiveNetworkMetered();
         if(var8.getActiveNetworkInfo() != null) {
            this.vC = var8.getActiveNetworkInfo().getDetailedState().ordinal();
         } else {
            this.vC = -1;
         }
      } else {
         this.vB = false;
         this.vC = -1;
      }
   }

   private static int a(Context var0, ConnectivityManager var1, PackageManager var2) {
      int var3 = -2;
      if(gi.a(var2, var0.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
         NetworkInfo var4 = var1.getActiveNetworkInfo();
         if(var4 == null) {
            return -1;
         }

         var3 = var4.getType();
      }

      return var3;
   }

   private static ResolveInfo a(PackageManager var0, String var1) {
      return var0.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(var1)), 65536);
   }

   private static String a(PackageManager param0) {
      // $FF: Couldn't be decompiled
   }
}
