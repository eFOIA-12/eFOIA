package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.nb;
import com.google.android.gms.internal.nk;
import com.google.android.gms.location.ActivityRecognitionApi;

public class ActivityRecognition {
   public static final Api API;
   public static ActivityRecognitionApi ActivityRecognitionApi;
   public static final String CLIENT_NAME = "activity_recognition";
   private static final Api.c DQ = new Api.c();
   private static final Api.b DR = new Api.b() {
      // $FF: synthetic method
      public Api.a a(Context var1, Looper var2, jg var3, Object var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return this.e(var1, var2, var3, (Api.NoOptions)var4, var5, var6);
      }

      public nk e(Context var1, Looper var2, jg var3, Api.NoOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return new nk(var1, var2, var1.getPackageName(), var5, var6, "activity_recognition");
      }

      public int getPriority() {
         return Integer.MAX_VALUE;
      }
   };

   static {
      API = new Api(DR, DQ, new Scope[0]);
      ActivityRecognitionApi = new nb();
   }

   public abstract static class a extends BaseImplementation.a {
      public a(GoogleApiClient var1) {
         super(ActivityRecognition.DQ, var1);
      }
   }
}
