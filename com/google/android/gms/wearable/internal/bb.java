package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.internal.ae;
import com.google.android.gms.wearable.internal.ai;
import com.google.android.gms.wearable.internal.al;

public class bb extends ae.a {
   private final IntentFilter[] axD;
   private DataApi.DataListener ayl;
   private MessageApi.MessageListener aym;
   private NodeApi.NodeListener ayn;

   private bb(DataApi.DataListener var1, MessageApi.MessageListener var2, NodeApi.NodeListener var3, IntentFilter[] var4) {
      this.ayl = var1;
      this.aym = var2;
      this.ayn = var3;
      this.axD = var4;
   }

   public static bb a(NodeApi.NodeListener var0) {
      return new bb((DataApi.DataListener)null, (MessageApi.MessageListener)null, var0, (IntentFilter[])null);
   }

   public static bb b(DataApi.DataListener var0, IntentFilter[] var1) {
      return new bb(var0, (MessageApi.MessageListener)null, (NodeApi.NodeListener)null, var1);
   }

   public static bb b(MessageApi.MessageListener var0, IntentFilter[] var1) {
      return new bb((DataApi.DataListener)null, var0, (NodeApi.NodeListener)null, var1);
   }

   public void a(ai var1) {
      if(this.aym != null) {
         this.aym.onMessageReceived(var1);
      }

   }

   public void a(al var1) {
      if(this.ayn != null) {
         this.ayn.onPeerConnected(var1);
      }

   }

   public void aa(DataHolder var1) {
      if(this.ayl != null) {
         try {
            this.ayl.onDataChanged(new DataEventBuffer(var1));
         } finally {
            var1.close();
         }

      } else {
         var1.close();
      }
   }

   public void b(al var1) {
      if(this.ayn != null) {
         this.ayn.onPeerDisconnected(var1);
      }

   }

   public void clear() {
      this.ayl = null;
      this.aym = null;
      this.ayn = null;
   }

   public IntentFilter[] rs() {
      return this.axD;
   }
}
