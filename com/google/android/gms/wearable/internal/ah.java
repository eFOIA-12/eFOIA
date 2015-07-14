package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.internal.ba;
import com.google.android.gms.wearable.internal.d;

public final class ah implements MessageApi {
   private PendingResult a(GoogleApiClient var1, MessageApi.MessageListener var2, IntentFilter[] var3) {
      return var1.a((BaseImplementation.a)(new ah.a(var1, var2, var3, null)));
   }

   public PendingResult addListener(GoogleApiClient var1, MessageApi.MessageListener var2) {
      return this.a(var1, var2, (IntentFilter[])null);
   }

   public PendingResult removeListener(final GoogleApiClient var1, final MessageApi.MessageListener var2) {
      return var1.a((BaseImplementation.a)(new d(var1) {
         protected void a(ba var1) throws RemoteException {
            var1.a((BaseImplementation.b)this, (MessageApi.MessageListener)var2);
         }

         public Status b(Status var1) {
            return var1;
         }

         // $FF: synthetic method
         public Result c(Status var1) {
            return this.b(var1);
         }
      }));
   }

   public PendingResult sendMessage(final GoogleApiClient var1, final String var2, final String var3, final byte[] var4) {
      return var1.a((BaseImplementation.a)(new d(var1) {
         protected void a(ba var1) throws RemoteException {
            var1.a(this, var2, var3, var4);
         }

         protected MessageApi.SendMessageResult aI(Status var1) {
            return new ah.b(var1, -1);
         }

         // $FF: synthetic method
         protected Result c(Status var1) {
            return this.aI(var1);
         }
      }));
   }

   private static final class a extends d {
      private IntentFilter[] axD;
      private MessageApi.MessageListener axV;

      private a(GoogleApiClient var1, MessageApi.MessageListener var2, IntentFilter[] var3) {
         super(var1);
         this.axV = var2;
         this.axD = var3;
      }

      // $FF: synthetic method
      a(GoogleApiClient var1, MessageApi.MessageListener var2, IntentFilter[] var3, Object var4) {
         this(var1, var2, var3);
      }

      protected void a(ba var1) throws RemoteException {
         var1.a(this, (MessageApi.MessageListener)this.axV, this.axD);
         this.axV = null;
         this.axD = null;
      }

      public Status b(Status var1) {
         this.axV = null;
         this.axD = null;
         return var1;
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.b(var1);
      }
   }

   public static class b implements MessageApi.SendMessageResult {
      private final Status Eb;
      private final int ve;

      public b(Status var1, int var2) {
         this.Eb = var1;
         this.ve = var2;
      }

      public int getRequestId() {
         return this.ve;
      }

      public Status getStatus() {
         return this.Eb;
      }
   }
}
