package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.oj;
import com.google.android.gms.internal.ok;
import com.google.android.gms.internal.om;
import com.google.android.gms.internal.on;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;

public class ol implements PanoramaApi {
   private static void a(Context var0, Uri var1) {
      var0.revokeUriPermission(var1, 1);
   }

   private static void a(final Context var0, ok var1, final oj var2, final Uri var3, Bundle var4) throws RemoteException {
      var0.grantUriPermission("com.google.android.gms", var3, 1);
      oj.a var7 = new oj.a() {
         public void a(int var1, Bundle var2x, int var3x, Intent var4) throws RemoteException {
            ol.a(var0, var3);
            var2.a(var1, var2x, var3x, var4);
         }
      };

      try {
         var1.a(var7, var3, var4, true);
      } catch (RemoteException var5) {
         a(var0, var3);
         throw var5;
      } catch (RuntimeException var6) {
         a(var0, var3);
         throw var6;
      }
   }

   public PendingResult loadPanoramaInfo(final GoogleApiClient var1, final Uri var2) {
      return var1.a((BaseImplementation.a)(new ol.a(var1) {
         protected void a(Context var1, ok var2x) throws RemoteException {
            var2x.a(new ol.b(this), var2, (Bundle)null, false);
         }
      }));
   }

   public PendingResult loadPanoramaInfoAndGrantAccess(final GoogleApiClient var1, final Uri var2) {
      return var1.a((BaseImplementation.a)(new ol.a(var1) {
         protected void a(Context var1, ok var2x) throws RemoteException {
            ol.a(var1, var2x, new ol.b(this), var2, (Bundle)null);
         }
      }));
   }

   private abstract static class a extends ol.c {
      public a(GoogleApiClient var1) {
         super(var1);
      }

      protected PanoramaApi.PanoramaResult ay(Status var1) {
         return new on(var1, (Intent)null);
      }

      // $FF: synthetic method
      protected Result c(Status var1) {
         return this.ay(var1);
      }
   }

   private static final class b extends oj.a {
      private final BaseImplementation.b Ea;

      public b(BaseImplementation.b var1) {
         this.Ea = var1;
      }

      public void a(int var1, Bundle var2, int var3, Intent var4) {
         PendingIntent var5;
         if(var2 != null) {
            var5 = (PendingIntent)var2.getParcelable("pendingIntent");
         } else {
            var5 = null;
         }

         Status var6 = new Status(var1, (String)null, var5);
         this.Ea.b(new on(var6, var4));
      }
   }

   private abstract static class c extends BaseImplementation.a {
      protected c(GoogleApiClient var1) {
         super(Panorama.DQ, var1);
      }

      protected abstract void a(Context var1, ok var2) throws RemoteException;

      protected final void a(om var1) throws RemoteException {
         this.a(var1.getContext(), (ok)var1.hw());
      }
   }
}
