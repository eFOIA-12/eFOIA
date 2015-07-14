package com.google.android.gms.wallet;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.pv;
import com.google.android.gms.internal.qg;
import com.google.android.gms.internal.qh;
import com.google.android.gms.internal.qj;
import com.google.android.gms.internal.qk;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.wobs.r;
import java.util.Locale;

public final class Wallet {
   public static final Api API;
   private static final Api.c DQ = new Api.c();
   private static final Api.b DR = new Api.b() {
      public qh a(Context var1, Looper var2, jg var3, Wallet.WalletOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         jx.b(var1 instanceof Activity, "An Activity must be used for Wallet APIs");
         Activity var7 = (Activity)var1;
         if(var4 == null) {
            var4 = new Wallet.WalletOptions(null);
         }

         return new qh(var7, var2, var5, var6, var4.environment, var3.getAccountName(), var4.theme);
      }

      public int getPriority() {
         return Integer.MAX_VALUE;
      }
   };
   public static final Payments Payments;
   public static final r avT;
   public static final pv avU;

   static {
      API = new Api(DR, DQ, new Scope[0]);
      Payments = new qg();
      avT = new qk();
      avU = new qj();
   }

   @Deprecated
   public static void changeMaskedWallet(GoogleApiClient var0, String var1, String var2, int var3) {
      Payments.changeMaskedWallet(var0, var1, var2, var3);
   }

   @Deprecated
   public static void checkForPreAuthorization(GoogleApiClient var0, int var1) {
      Payments.checkForPreAuthorization(var0, var1);
   }

   @Deprecated
   public static void loadFullWallet(GoogleApiClient var0, FullWalletRequest var1, int var2) {
      Payments.loadFullWallet(var0, var1, var2);
   }

   @Deprecated
   public static void loadMaskedWallet(GoogleApiClient var0, MaskedWalletRequest var1, int var2) {
      Payments.loadMaskedWallet(var0, var1, var2);
   }

   @Deprecated
   public static void notifyTransactionStatus(GoogleApiClient var0, NotifyTransactionStatusRequest var1) {
      Payments.notifyTransactionStatus(var0, var1);
   }

   public static final class WalletOptions implements Api.HasOptions {
      public final int environment;
      public final int theme;

      private WalletOptions() {
         this(new Wallet.Builder());
      }

      // $FF: synthetic method
      WalletOptions(Object var1) {
         this();
      }

      private WalletOptions(Wallet.Builder var1) {
         this.environment = var1.avV;
         this.theme = var1.mTheme;
      }

      // $FF: synthetic method
      WalletOptions(Wallet.Builder var1, Object var2) {
         this(var1);
      }
   }

   public static final class Builder {
      private int avV = 0;
      private int mTheme = 0;

      public Wallet.WalletOptions build() {
         return new Wallet.WalletOptions(this, null);
      }

      public Wallet.Builder setEnvironment(int var1) {
         if(var1 != 0 && var1 != 2 && var1 != 1) {
            throw new IllegalArgumentException(String.format(Locale.US, "Invalid environment value %d", new Object[]{Integer.valueOf(var1)}));
         } else {
            this.avV = var1;
            return this;
         }
      }

      public Wallet.Builder setTheme(int var1) {
         if(var1 != 0 && var1 != 1) {
            throw new IllegalArgumentException(String.format(Locale.US, "Invalid theme value %d", new Object[]{Integer.valueOf(var1)}));
         } else {
            this.mTheme = var1;
            return this;
         }
      }
   }

   public abstract static class a extends BaseImplementation.a {
      public a(GoogleApiClient var1) {
         super(Wallet.DQ, var1);
      }
   }

   public abstract static class b extends Wallet.a {
      public b(GoogleApiClient var1) {
         super(var1);
      }

      protected Status b(Status var1) {
         return var1;
      }

      // $FF: synthetic method
      protected Result c(Status var1) {
         return this.b(var1);
      }
   }
}
