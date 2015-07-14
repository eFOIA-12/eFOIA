package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.ExceptionParser;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.StandardExceptionParser;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.ae;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;

public class ExceptionReporter implements UncaughtExceptionHandler {
   private final Context mContext;
   private final UncaughtExceptionHandler yN;
   private final Tracker yO;
   private ExceptionParser yP;
   private GoogleAnalytics yQ;

   public ExceptionReporter(Tracker var1, UncaughtExceptionHandler var2, Context var3) {
      if(var1 == null) {
         throw new NullPointerException("tracker cannot be null");
      } else if(var3 == null) {
         throw new NullPointerException("context cannot be null");
      } else {
         this.yN = var2;
         this.yO = var1;
         this.yP = new StandardExceptionParser(var3, new ArrayList());
         this.mContext = var3.getApplicationContext();
         StringBuilder var5 = (new StringBuilder()).append("ExceptionReporter created, original handler is ");
         String var4;
         if(var2 == null) {
            var4 = "null";
         } else {
            var4 = var2.getClass().getName();
         }

         ae.V(var5.append(var4).toString());
      }
   }

   GoogleAnalytics es() {
      if(this.yQ == null) {
         this.yQ = GoogleAnalytics.getInstance(this.mContext);
      }

      return this.yQ;
   }

   UncaughtExceptionHandler et() {
      return this.yN;
   }

   public ExceptionParser getExceptionParser() {
      return this.yP;
   }

   public void setExceptionParser(ExceptionParser var1) {
      this.yP = var1;
   }

   public void uncaughtException(Thread var1, Throwable var2) {
      String var3 = "UncaughtException";
      if(this.yP != null) {
         if(var1 != null) {
            var3 = var1.getName();
         } else {
            var3 = null;
         }

         var3 = this.yP.getDescription(var3, var2);
      }

      ae.V("Tracking Exception: " + var3);
      this.yO.send((new HitBuilders.ExceptionBuilder()).setDescription(var3).setFatal(true).build());
      GoogleAnalytics var4 = this.es();
      var4.dispatchLocalHits();
      var4.dY();
      if(this.yN != null) {
         ae.V("Passing exception to original handler.");
         this.yN.uncaughtException(var1, var2);
      }

   }
}
