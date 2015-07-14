package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.jg;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.b;
import com.google.android.gms.wearable.f;
import com.google.android.gms.wearable.internal.ah;
import com.google.android.gms.wearable.internal.ak;
import com.google.android.gms.wearable.internal.ay;
import com.google.android.gms.wearable.internal.ba;

public class Wearable {
   public static final Api API;
   public static final Api.c DQ = new Api.c();
   private static final Api.b DR = new Api.b() {
      public ba a(Context var1, Looper var2, jg var3, Wearable.WearableOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         if(var4 == null) {
            new Wearable.WearableOptions(new Wearable.Builder(), null);
         }

         return new ba(var1, var2, var5, var6);
      }

      public int getPriority() {
         return Integer.MAX_VALUE;
      }
   };
   public static final DataApi DataApi = new com.google.android.gms.wearable.internal.f();
   public static final MessageApi MessageApi = new ah();
   public static final NodeApi NodeApi = new ak();
   public static final b axl = new com.google.android.gms.wearable.internal.e();
   public static final f axm = new ay();

   static {
      API = new Api(DR, DQ, new Scope[0]);
   }

   public static final class WearableOptions implements Api.Optional {
      private WearableOptions(Wearable.Builder var1) {
      }

      // $FF: synthetic method
      WearableOptions(Wearable.Builder var1, Object var2) {
         this(var1);
      }
   }

   public static class Builder {
      public Wearable.WearableOptions build() {
         return new Wearable.WearableOptions(this, null);
      }
   }
}
