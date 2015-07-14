package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.ga;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.gs;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.LinkedList;

@ey
public class ex implements UncaughtExceptionHandler {
   private Context mContext;
   private UncaughtExceptionHandler tf;
   private UncaughtExceptionHandler tg;
   private gs th;

   public ex(Context var1, gs var2, UncaughtExceptionHandler var3, UncaughtExceptionHandler var4) {
      this.tf = var3;
      this.tg = var4;
      this.mContext = var1;
      this.th = var2;
   }

   public static ex a(Context var0, Thread var1, gs var2) {
      if(var0 != null && var1 != null && var2 != null) {
         ga.bN();
         if(!k(var0)) {
            return null;
         } else {
            UncaughtExceptionHandler var3 = var1.getUncaughtExceptionHandler();
            ex var5 = new ex(var0, var2, var3, Thread.getDefaultUncaughtExceptionHandler());
            if(var3 != null && var3 instanceof ex) {
               return (ex)var3;
            } else {
               try {
                  var1.setUncaughtExceptionHandler(var5);
                  return var5;
               } catch (SecurityException var4) {
                  gr.c("Fail to set UncaughtExceptionHandler.", var4);
                  return null;
               }
            }
         }
      } else {
         return null;
      }
   }

   private String cD() {
      String var1 = Build.MANUFACTURER;
      String var2 = Build.MODEL;
      return var2.startsWith(var1)?var2:var1 + " " + var2;
   }

   private Throwable d(Throwable var1) {
      Bundle var5 = ga.bN();
      if(var5 != null && var5.getBoolean("gads:sdk_crash_report_full_stacktrace", false)) {
         return var1;
      } else {
         LinkedList var10;
         for(var10 = new LinkedList(); var1 != null; var1 = var1.getCause()) {
            var10.push(var1);
         }

         var1 = null;

         while(!var10.isEmpty()) {
            Throwable var7 = (Throwable)var10.pop();
            StackTraceElement[] var8 = var7.getStackTrace();
            ArrayList var6 = new ArrayList();
            var6.add(new StackTraceElement(var7.getClass().getName(), "<filtered>", "<filtered>", 1));
            int var4 = var8.length;
            int var2 = 0;

            boolean var3;
            for(var3 = false; var2 < var4; ++var2) {
               StackTraceElement var9 = var8[var2];
               if(this.G(var9.getClassName())) {
                  var6.add(var9);
                  var3 = true;
               } else if(this.H(var9.getClassName())) {
                  var6.add(var9);
               } else {
                  var6.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
               }
            }

            if(var3) {
               if(var1 == null) {
                  var1 = new Throwable(var7.getMessage());
               } else {
                  var1 = new Throwable(var7.getMessage(), var1);
               }

               var1.setStackTrace((StackTraceElement[])var6.toArray(new StackTraceElement[0]));
            }
         }

         return var1;
      }
   }

   private static boolean k(Context var0) {
      Bundle var1 = ga.bN();
      return var1 != null && var1.getBoolean("gads:sdk_crash_report_enabled", false);
   }

   protected boolean G(String var1) {
      if(TextUtils.isEmpty(var1)) {
         return false;
      } else if(var1.startsWith("com.google.android.gms.ads")) {
         return true;
      } else if(var1.startsWith("com.google.ads")) {
         return true;
      } else {
         try {
            boolean var2 = Class.forName(var1).isAnnotationPresent(ey.class);
            return var2;
         } catch (Exception var4) {
            gr.a("Fail to check class type for class " + var1, var4);
            return false;
         }
      }
   }

   protected boolean H(String var1) {
      return !TextUtils.isEmpty(var1) && (var1.startsWith("android.") || var1.startsWith("java."));
   }

   protected boolean a(Throwable var1) {
      boolean var6 = true;
      if(var1 == null) {
         return false;
      } else {
         boolean var3 = false;

         boolean var4;
         for(var4 = false; var1 != null; var1 = var1.getCause()) {
            StackTraceElement[] var7 = var1.getStackTrace();
            int var5 = var7.length;

            for(int var2 = 0; var2 < var5; ++var2) {
               StackTraceElement var8 = var7[var2];
               if(this.G(var8.getClassName())) {
                  var4 = true;
               }

               if(this.getClass().getName().equals(var8.getClassName())) {
                  var3 = true;
               }
            }
         }

         if(!var4 || var3) {
            var6 = false;
         }

         return var6;
      }
   }

   public void b(Throwable var1) {
      if(k(this.mContext)) {
         var1 = this.d(var1);
         if(var1 != null) {
            ArrayList var2 = new ArrayList();
            var2.add(this.c(var1));
            gi.a(this.mContext, this.th.wS, var2, ga.dn());
            return;
         }
      }

   }

   protected String c(Throwable var1) {
      StringWriter var2 = new StringWriter();
      var1.printStackTrace(new PrintWriter(var2));
      return (new Builder()).scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", VERSION.RELEASE).appendQueryParameter("api", String.valueOf(VERSION.SDK_INT)).appendQueryParameter("device", this.cD()).appendQueryParameter("js", this.th.wS).appendQueryParameter("appid", this.mContext.getApplicationContext().getPackageName()).appendQueryParameter("stacktrace", var2.toString()).toString();
   }

   public void uncaughtException(Thread var1, Throwable var2) {
      if(this.a(var2)) {
         this.b(var2);
         if(Looper.getMainLooper().getThread() != var1) {
            return;
         }
      }

      if(this.tf != null) {
         this.tf.uncaughtException(var1, var2);
      } else if(this.tg != null) {
         this.tg.uncaughtException(var1, var2);
      }
   }
}
