package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class GoogleCloudMessaging {
   public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
   public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
   public static final String MESSAGE_TYPE_DELETED = "deleted_messages";
   public static final String MESSAGE_TYPE_MESSAGE = "gcm";
   public static final String MESSAGE_TYPE_SEND_ERROR = "send_error";
   static GoogleCloudMessaging afo;
   private PendingIntent afp;
   final BlockingQueue afq = new LinkedBlockingQueue();
   private Handler afr = new Handler(Looper.getMainLooper()) {
      public void handleMessage(Message var1) {
         Intent var2 = (Intent)var1.obj;
         GoogleCloudMessaging.this.afq.add(var2);
      }
   };
   private Messenger afs;
   private Context lM;

   public GoogleCloudMessaging() {
      this.afs = new Messenger(this.afr);
   }

   private void a(String var1, String var2, long var3, int var5, Bundle var6) throws IOException {
      if(Looper.getMainLooper() == Looper.myLooper()) {
         throw new IOException("MAIN_THREAD");
      } else if(var1 == null) {
         throw new IllegalArgumentException("Missing \'to\'");
      } else {
         Intent var7 = new Intent("com.google.android.gcm.intent.SEND");
         var7.putExtras(var6);
         this.j(var7);
         var7.setPackage("com.google.android.gms");
         var7.putExtra("google.to", var1);
         var7.putExtra("google.message_id", var2);
         var7.putExtra("google.ttl", Long.toString(var3));
         var7.putExtra("google.delay", Integer.toString(var5));
         this.lM.sendOrderedBroadcast(var7, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
      }
   }

   private void e(String... var1) {
      String var3 = this.f(var1);
      Intent var2 = new Intent("com.google.android.c2dm.intent.REGISTER");
      var2.setPackage("com.google.android.gms");
      var2.putExtra("google.messenger", this.afs);
      this.j(var2);
      var2.putExtra("sender", var3);
      this.lM.startService(var2);
   }

   public static GoogleCloudMessaging getInstance(Context var0) {
      synchronized(GoogleCloudMessaging.class){}

      GoogleCloudMessaging var3;
      try {
         if(afo == null) {
            afo = new GoogleCloudMessaging();
            afo.lM = var0.getApplicationContext();
         }

         var3 = afo;
      } finally {
         ;
      }

      return var3;
   }

   private void mU() {
      Intent var1 = new Intent("com.google.android.c2dm.intent.UNREGISTER");
      var1.setPackage("com.google.android.gms");
      this.afq.clear();
      var1.putExtra("google.messenger", this.afs);
      this.j(var1);
      this.lM.startService(var1);
   }

   public void close() {
      this.mV();
   }

   String f(String... var1) {
      if(var1 != null && var1.length != 0) {
         StringBuilder var3 = new StringBuilder(var1[0]);

         for(int var2 = 1; var2 < var1.length; ++var2) {
            var3.append(',').append(var1[var2]);
         }

         return var3.toString();
      } else {
         throw new IllegalArgumentException("No senderIds");
      }
   }

   public String getMessageType(Intent var1) {
      String var3;
      if(!"com.google.android.c2dm.intent.RECEIVE".equals(var1.getAction())) {
         var3 = null;
      } else {
         String var2 = var1.getStringExtra("message_type");
         var3 = var2;
         if(var2 == null) {
            return "gcm";
         }
      }

      return var3;
   }

   void j(Intent var1) {
      synchronized(this){}

      try {
         if(this.afp == null) {
            Intent var2 = new Intent();
            var2.setPackage("com.google.example.invalidpackage");
            this.afp = PendingIntent.getBroadcast(this.lM, 0, var2, 0);
         }

         var1.putExtra("app", this.afp);
      } finally {
         ;
      }

   }

   void mV() {
      synchronized(this){}

      try {
         if(this.afp != null) {
            this.afp.cancel();
            this.afp = null;
         }
      } finally {
         ;
      }

   }

   public String register(String... param1) throws IOException {
      // $FF: Couldn't be decompiled
   }

   public void send(String var1, String var2, long var3, Bundle var5) throws IOException {
      this.a(var1, var2, var3, -1, var5);
   }

   public void send(String var1, String var2, Bundle var3) throws IOException {
      this.send(var1, var2, -1L, var3);
   }

   public void unregister() throws IOException {
      // $FF: Couldn't be decompiled
   }
}
