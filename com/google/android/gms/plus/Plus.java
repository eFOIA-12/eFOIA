package com.google.android.gms.plus;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.oy;
import com.google.android.gms.internal.oz;
import com.google.android.gms.internal.pa;
import com.google.android.gms.internal.pb;
import com.google.android.gms.internal.pc;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.a;
import com.google.android.gms.plus.b;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.e;
import com.google.android.gms.plus.internal.h;
import java.util.HashSet;
import java.util.Set;

public final class Plus {
   public static final Api API;
   public static final Account AccountApi;
   public static final Api.c DQ = new Api.c();
   static final Api.b DR = new Api.b() {
      public e a(Context var1, Looper var2, jg var3, Plus.PlusOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         Plus.PlusOptions var7 = var4;
         if(var4 == null) {
            var7 = new Plus.PlusOptions(null);
         }

         String var12 = var3.hm();
         String[] var11 = var3.hp();
         String[] var13 = (String[])var7.ans.toArray(new String[0]);
         String var8 = var1.getPackageName();
         String var9 = var1.getPackageName();
         PlusCommonExtras var10 = new PlusCommonExtras();
         return new e(var1, var2, var5, var6, new h(var12, var11, var13, new String[0], var8, var9, (String)null, var10));
      }

      public int getPriority() {
         return 2;
      }
   };
   public static final Moments MomentsApi;
   public static final People PeopleApi;
   public static final Scope SCOPE_PLUS_LOGIN;
   public static final Scope SCOPE_PLUS_PROFILE;
   public static final b anp;
   public static final a anq;

   static {
      API = new Api(DR, DQ, new Scope[0]);
      SCOPE_PLUS_LOGIN = new Scope("https://www.googleapis.com/auth/plus.login");
      SCOPE_PLUS_PROFILE = new Scope("https://www.googleapis.com/auth/plus.me");
      MomentsApi = new pb();
      PeopleApi = new pc();
      AccountApi = new oy();
      anp = new pa();
      anq = new oz();
   }

   public static e a(GoogleApiClient var0, Api.c var1) {
      boolean var3 = true;
      boolean var2;
      if(var0 != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      jx.b(var2, "GoogleApiClient parameter is required.");
      jx.a(var0.isConnected(), "GoogleApiClient must be connected.");
      e var4 = (e)var0.a(var1);
      if(var4 != null) {
         var2 = var3;
      } else {
         var2 = false;
      }

      jx.a(var2, "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
      return var4;
   }

   public static final class PlusOptions implements Api.Optional {
      final String anr;
      final Set ans;

      private PlusOptions() {
         this.anr = null;
         this.ans = new HashSet();
      }

      // $FF: synthetic method
      PlusOptions(Object var1) {
         this();
      }

      private PlusOptions(Plus.Builder var1) {
         this.anr = var1.anr;
         this.ans = var1.ans;
      }

      // $FF: synthetic method
      PlusOptions(Plus.Builder var1, Object var2) {
         this(var1);
      }

      public static Plus.Builder builder() {
         return new Plus.Builder();
      }
   }

   public static final class Builder {
      String anr;
      final Set ans = new HashSet();

      public Plus.Builder addActivityTypes(String... var1) {
         jx.b((Object)var1, "activityTypes may not be null.");

         for(int var2 = 0; var2 < var1.length; ++var2) {
            this.ans.add(var1[var2]);
         }

         return this;
      }

      public Plus.PlusOptions build() {
         return new Plus.PlusOptions(this, null);
      }

      public Plus.Builder setServerClientId(String var1) {
         this.anr = var1;
         return this;
      }
   }

   public abstract static class a extends BaseImplementation.a {
      public a(GoogleApiClient var1) {
         super(Plus.DQ, var1);
      }
   }
}
