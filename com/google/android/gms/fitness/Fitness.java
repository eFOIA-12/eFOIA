package com.google.android.gms.fitness;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Build.VERSION;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.ConfigApi;
import com.google.android.gms.fitness.HistoryApi;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.a;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.lu;
import com.google.android.gms.internal.lv;
import com.google.android.gms.internal.mf;
import com.google.android.gms.internal.mh;
import com.google.android.gms.internal.mi;
import com.google.android.gms.internal.mj;
import com.google.android.gms.internal.mk;
import com.google.android.gms.internal.ml;
import com.google.android.gms.internal.mm;
import com.google.android.gms.internal.mn;
import com.google.android.gms.internal.mo;
import java.util.concurrent.TimeUnit;

public class Fitness {
   public static final String ACTION_TRACK = "vnd.google.fitness.TRACK";
   public static final String ACTION_VIEW = "vnd.google.fitness.VIEW";
   public static final String ACTION_VIEW_GOAL = "vnd.google.fitness.VIEW_GOAL";
   public static final Api API;
   public static final BleApi BleApi;
   public static final ConfigApi ConfigApi;
   public static final Api.c DQ = new Api.c();
   private static final Api.b DR = new Api.b() {
      // $FF: synthetic method
      public Api.a a(Context var1, Looper var2, jg var3, Object var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return this.d(var1, var2, var3, (Api.NoOptions)var4, var5, var6);
      }

      public lu d(Context var1, Looper var2, jg var3, Api.NoOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         String[] var7 = a.e(var3.ho());
         return new lv(var1, var2, var5, var6, var3.hm(), var7);
      }

      public int getPriority() {
         return Integer.MAX_VALUE;
      }
   };
   public static final String EXTRA_END_TIME = "vnd.google.fitness.end_time";
   public static final String EXTRA_START_TIME = "vnd.google.fitness.start_time";
   public static final HistoryApi HistoryApi;
   public static final RecordingApi RecordingApi;
   public static final Scope SCOPE_ACTIVITY_READ;
   public static final Scope SCOPE_ACTIVITY_READ_WRITE;
   public static final Scope SCOPE_BODY_READ;
   public static final Scope SCOPE_BODY_READ_WRITE;
   public static final Scope SCOPE_LOCATION_READ;
   public static final Scope SCOPE_LOCATION_READ_WRITE;
   public static final SensorsApi SensorsApi;
   public static final SessionsApi SessionsApi;
   public static final mf TK;

   static {
      API = new Api(DR, DQ, new Scope[0]);
      SensorsApi = new mm();
      RecordingApi = new ml();
      SessionsApi = new mn();
      HistoryApi = new mj();
      ConfigApi = new mi();
      BleApi = jj();
      TK = new mk();
      SCOPE_ACTIVITY_READ = new Scope("https://www.googleapis.com/auth/fitness.activity.read");
      SCOPE_ACTIVITY_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.activity.write");
      SCOPE_LOCATION_READ = new Scope("https://www.googleapis.com/auth/fitness.location.read");
      SCOPE_LOCATION_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.location.write");
      SCOPE_BODY_READ = new Scope("https://www.googleapis.com/auth/fitness.body.read");
      SCOPE_BODY_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.body.write");
   }

   public static long getEndTime(Intent var0, TimeUnit var1) {
      long var2 = var0.getLongExtra("vnd.google.fitness.end_time", -1L);
      return var2 == -1L?-1L:var1.convert(var2, TimeUnit.MILLISECONDS);
   }

   public static long getStartTime(Intent var0, TimeUnit var1) {
      long var2 = var0.getLongExtra("vnd.google.fitness.start_time", -1L);
      return var2 == -1L?-1L:var1.convert(var2, TimeUnit.MILLISECONDS);
   }

   private static BleApi jj() {
      return (BleApi)(VERSION.SDK_INT >= 18?new mh():new mo());
   }
}
