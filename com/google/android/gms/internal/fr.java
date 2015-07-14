package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.bj;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.fh;
import com.google.android.gms.internal.fj;
import com.google.android.gms.internal.fv;
import com.google.android.gms.internal.ge;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

@ey
public final class fr {
   private static final SimpleDateFormat uD = new SimpleDateFormat("yyyyMMdd");

   public static fj a(Context param0, fh param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   public static String a(fh param0, fv param1, Location param2, String param3, String param4, String param5) {
      // $FF: Couldn't be decompiled
   }

   private static void a(HashMap var0, Location var1) {
      HashMap var9 = new HashMap();
      float var2 = var1.getAccuracy();
      long var3 = var1.getTime();
      long var5 = (long)(var1.getLatitude() * 1.0E7D);
      long var7 = (long)(var1.getLongitude() * 1.0E7D);
      var9.put("radius", Float.valueOf(var2 * 1000.0F));
      var9.put("lat", Long.valueOf(var5));
      var9.put("long", Long.valueOf(var7));
      var9.put("time", Long.valueOf(var3 * 1000L));
      var0.put("uule", var9);
   }

   private static void a(HashMap var0, av var1) {
      String var2 = ge.dr();
      if(var2 != null) {
         var0.put("abf", var2);
      }

      if(var1.od != -1L) {
         var0.put("cust_age", uD.format(new Date(var1.od)));
      }

      if(var1.extras != null) {
         var0.put("extras", var1.extras);
      }

      if(var1.oe != -1) {
         var0.put("cust_gender", Integer.valueOf(var1.oe));
      }

      if(var1.of != null) {
         var0.put("kw", var1.of);
      }

      if(var1.oh != -1) {
         var0.put("tag_for_child_directed_treatment", Integer.valueOf(var1.oh));
      }

      if(var1.og) {
         var0.put("adtest", "on");
      }

      if(var1.versionCode >= 2) {
         if(var1.oi) {
            var0.put("d_imp_hdr", Integer.valueOf(1));
         }

         if(!TextUtils.isEmpty(var1.oj)) {
            var0.put("ppid", var1.oj);
         }

         if(var1.ok != null) {
            a(var0, var1.ok);
         }
      }

      if(var1.versionCode >= 3 && var1.om != null) {
         var0.put("url", var1.om);
      }

   }

   private static void a(HashMap var0, bj var1) {
      Object var3 = null;
      if(Color.alpha(var1.oQ) != 0) {
         var0.put("acolor", u(var1.oQ));
      }

      if(Color.alpha(var1.backgroundColor) != 0) {
         var0.put("bgcolor", u(var1.backgroundColor));
      }

      if(Color.alpha(var1.oR) != 0 && Color.alpha(var1.oS) != 0) {
         var0.put("gradientto", u(var1.oR));
         var0.put("gradientfrom", u(var1.oS));
      }

      if(Color.alpha(var1.oT) != 0) {
         var0.put("bcolor", u(var1.oT));
      }

      var0.put("bthick", Integer.toString(var1.oU));
      String var2;
      switch(var1.oV) {
      case 0:
         var2 = "none";
         break;
      case 1:
         var2 = "dashed";
         break;
      case 2:
         var2 = "dotted";
         break;
      case 3:
         var2 = "solid";
         break;
      default:
         var2 = null;
      }

      if(var2 != null) {
         var0.put("btype", var2);
      }

      switch(var1.oW) {
      case 0:
         var2 = "light";
         break;
      case 1:
         var2 = "medium";
         break;
      case 2:
         var2 = "dark";
         break;
      default:
         var2 = (String)var3;
      }

      if(var2 != null) {
         var0.put("callbuttoncolor", var2);
      }

      if(var1.oX != null) {
         var0.put("channel", var1.oX);
      }

      if(Color.alpha(var1.oY) != 0) {
         var0.put("dcolor", u(var1.oY));
      }

      if(var1.oZ != null) {
         var0.put("font", var1.oZ);
      }

      if(Color.alpha(var1.pa) != 0) {
         var0.put("hcolor", u(var1.pa));
      }

      var0.put("headersize", Integer.toString(var1.pb));
      if(var1.pc != null) {
         var0.put("q", var1.pc);
      }

   }

   private static void a(HashMap var0, fv var1) {
      var0.put("am", Integer.valueOf(var1.vg));
      var0.put("cog", u(var1.vh));
      var0.put("coh", u(var1.vi));
      if(!TextUtils.isEmpty(var1.vj)) {
         var0.put("carrier", var1.vj);
      }

      var0.put("gl", var1.vk);
      if(var1.vl) {
         var0.put("simulator", Integer.valueOf(1));
      }

      var0.put("ma", u(var1.vm));
      var0.put("sp", u(var1.vn));
      var0.put("hl", var1.vo);
      if(!TextUtils.isEmpty(var1.vp)) {
         var0.put("mv", var1.vp);
      }

      var0.put("muv", Integer.valueOf(var1.vq));
      if(var1.vr != -2) {
         var0.put("cnt", Integer.valueOf(var1.vr));
      }

      var0.put("gnt", Integer.valueOf(var1.vs));
      var0.put("pt", Integer.valueOf(var1.vt));
      var0.put("rm", Integer.valueOf(var1.vu));
      var0.put("riv", Integer.valueOf(var1.vv));
      var0.put("u_sd", Float.valueOf(var1.vw));
      var0.put("sh", Integer.valueOf(var1.vy));
      var0.put("sw", Integer.valueOf(var1.vx));
      Bundle var2 = new Bundle();
      var2.putInt("active_network_state", var1.vC);
      var2.putBoolean("active_network_metered", var1.vB);
      var0.put("connectivity", var2);
      var2 = new Bundle();
      var2.putBoolean("is_charging", var1.vA);
      var2.putDouble("battery_level", var1.vz);
      var0.put("battery", var2);
   }

   private static Integer u(boolean var0) {
      byte var1;
      if(var0) {
         var1 = 1;
      } else {
         var1 = 0;
      }

      return Integer.valueOf(var1);
   }

   private static String u(int var0) {
      return String.format(Locale.US, "#%06x", new Object[]{Integer.valueOf(16777215 & var0)});
   }
}
