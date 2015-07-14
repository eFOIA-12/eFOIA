package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.iy;

@ey
public final class bn {
   public static iy ph = a("gads:sdk_core_location", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html");
   public static iy pi = a("gads:sdk_core_experiment_id", (String)null);
   public static iy pj = c("gads:sdk_crash_report_enabled", false);
   public static iy pk = c("gads:sdk_crash_report_full_stacktrace", false);
   public static iy pl = c("gads:block_autoclicks", false);
   public static iy pm = a("gads:block_autoclicks_experiment_id", (String)null);
   public static iy pn;
   public static iy po;
   public static iy pp;
   public static iy pq;
   public static iy pr;
   public static iy ps;
   public static iy pt;
   public static iy pu;
   private static final Bundle pv = new Bundle();
   private static boolean pw = false;

   static {
      pw = true;
      pp = c("gads:enable_content_fetching", false);
      pq = a("gads:content_length_weight", 1);
      pr = a("gads:content_age_weight", 1);
      ps = a("gads:min_content_len", 11);
      pt = a("gads:fingerprint_number", 10);
      pu = a("gads:sleep_sec", 10);
      pn = c("gads:spam_app_context:enabled", false);
      po = a("gads:spam_app_context:experiment_id", (String)null);
   }

   private static iy a(String var0, int var1) {
      pv.putInt(var0, var1);
      return iy.a(var0, Integer.valueOf(var1));
   }

   private static iy a(String var0, String var1) {
      pv.putString(var0, var1);
      return iy.l(var0, var1);
   }

   public static Bundle by() {
      return pv;
   }

   private static iy c(String var0, boolean var1) {
      pv.putBoolean(var0, var1);
      return iy.h(var0, var1);
   }
}
