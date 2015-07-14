package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.jg;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Api {
   private final Api.b Jm;
   private final Api.c Jn;
   private final ArrayList Jo;

   public Api(Api.b var1, Api.c var2, Scope... var3) {
      this.Jm = var1;
      this.Jn = var2;
      this.Jo = new ArrayList(Arrays.asList(var3));
   }

   public Api.b gx() {
      return this.Jm;
   }

   public List gy() {
      return this.Jo;
   }

   public Api.c gz() {
      return this.Jn;
   }

   public interface ApiOptions {
   }

   public interface HasOptions extends Api.ApiOptions {
   }

   public static final class NoOptions implements Api.NotRequiredOptions {
   }

   public interface NotRequiredOptions extends Api.ApiOptions {
   }

   public interface Optional extends Api.HasOptions, Api.NotRequiredOptions {
   }

   public interface a {
      void connect();

      void disconnect();

      boolean isConnected();
   }

   public interface b {
      Api.a a(Context var1, Looper var2, jg var3, Object var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6);

      int getPriority();
   }

   public static final class c {
   }
}
