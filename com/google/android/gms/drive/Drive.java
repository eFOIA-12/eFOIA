package com.google.android.gms.drive;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DrivePreferencesApi;
import com.google.android.gms.drive.b;
import com.google.android.gms.drive.e;
import com.google.android.gms.drive.internal.p;
import com.google.android.gms.drive.internal.r;
import com.google.android.gms.drive.internal.u;
import com.google.android.gms.drive.internal.x;
import com.google.android.gms.drive.internal.z;
import com.google.android.gms.internal.jg;
import java.util.List;

public final class Drive {
   public static final Api API;
   public static final Api.c DQ = new Api.c();
   public static final DriveApi DriveApi;
   public static final DrivePreferencesApi DrivePreferencesApi;
   public static final Scope Oo = new Scope("https://www.googleapis.com/auth/drive");
   public static final Scope Op = new Scope("https://www.googleapis.com/auth/drive.apps");
   public static final Api Oq;
   public static final b Or;
   public static final e Os;
   public static final Scope SCOPE_APPFOLDER = new Scope("https://www.googleapis.com/auth/drive.appdata");
   public static final Scope SCOPE_FILE = new Scope("https://www.googleapis.com/auth/drive.file");

   static {
      API = new Api(new Drive.a() {
         protected Bundle a(Api.NoOptions var1) {
            return new Bundle();
         }
      }, DQ, new Scope[0]);
      Oq = new Api(new Drive.a() {
         protected Bundle a(Drive.b var1) {
            return var1 == null?new Bundle():var1.iq();
         }
      }, DQ, new Scope[0]);
      DriveApi = new p();
      Or = new u();
      Os = new z();
      DrivePreferencesApi = new x();
   }

   public abstract static class a implements Api.b {
      protected abstract Bundle a(Api.ApiOptions var1);

      public r a(Context var1, Looper var2, jg var3, Api.ApiOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         List var7 = var3.ho();
         return new r(var1, var2, var3, var5, var6, (String[])var7.toArray(new String[var7.size()]), this.a(var4));
      }

      public int getPriority() {
         return Integer.MAX_VALUE;
      }
   }

   public static class b implements Api.Optional {
      private final Bundle DJ;

      private b() {
         this(new Bundle());
      }

      private b(Bundle var1) {
         this.DJ = var1;
      }

      public Bundle iq() {
         return this.DJ;
      }
   }
}
