package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.RemoteException;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.hc;
import com.google.android.gms.internal.hr;
import com.google.android.gms.internal.ht;
import com.google.android.gms.internal.hu;
import com.google.android.gms.internal.hw;
import com.google.android.gms.internal.hx;
import com.google.android.gms.internal.hy;
import java.util.Iterator;
import java.util.List;

public final class hz implements AppIndexApi, ht {
   public static Intent a(String var0, Uri var1) {
      b(var0, var1);
      List var5 = var1.getPathSegments();
      String var3 = (String)var5.get(0);
      Builder var4 = new Builder();
      var4.scheme(var3);
      if(var5.size() > 1) {
         var4.authority((String)var5.get(1));

         for(int var2 = 2; var2 < var5.size(); ++var2) {
            var4.appendPath((String)var5.get(var2));
         }
      }

      var4.encodedQuery(var1.getEncodedQuery());
      var4.encodedFragment(var1.getEncodedFragment());
      return new Intent("android.intent.action.VIEW", var4.build());
   }

   private static void b(String var0, Uri var1) {
      if(!"android-app".equals(var1.getScheme())) {
         throw new IllegalArgumentException("AppIndex: The URI scheme must be \'android-app\' and follow the format (android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + var1);
      } else {
         String var2 = var1.getHost();
         if(var0 != null && !var0.equals(var2)) {
            throw new IllegalArgumentException("AppIndex: The URI host must match the package name and follow the format (android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + var1);
         } else {
            List var3 = var1.getPathSegments();
            if(var3.isEmpty() || ((String)var3.get(0)).isEmpty()) {
               throw new IllegalArgumentException("AppIndex: The app URI scheme must exist and follow the format android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + var1);
            }
         }
      }
   }

   public static void c(List var0) {
      if(var0 != null) {
         Iterator var1 = var0.iterator();

         while(var1.hasNext()) {
            b((String)null, ((AppIndexApi.AppIndexingLink)var1.next()).appIndexingUrl);
         }
      }

   }

   public PendingResult a(final GoogleApiClient var1, final hr... var2) {
      return var1.a((BaseImplementation.a)(new hz.c(var1) {
         // $FF: synthetic field
         final String DB;

         {
            this.DB = var3;
         }

         protected void a(hu var1) throws RemoteException {
            var1.a(new hz.d(this), this.DB, var2);
         }
      }));
   }

   public AppIndexApi.ActionResult action(GoogleApiClient var1, Action var2) {
      String var5 = ((hx)var1.a(hc.CG)).getContext().getPackageName();
      long var3 = System.currentTimeMillis();
      String var6 = String.valueOf(var3);
      return new hz.a(this, this.a(var1, new hr[]{hy.a(var2, var6, var3, var5, 0)}), var2, var6);
   }

   public PendingResult view(GoogleApiClient var1, Activity var2, Intent var3, String var4, Uri var5, List var6) {
      String var7 = ((hx)var1.a(hc.CG)).getContext().getPackageName();
      c(var6);
      return this.a(var1, new hr[]{new hr(var7, var3, var4, var5, (String)null, var6)});
   }

   public PendingResult view(GoogleApiClient var1, Activity var2, Uri var3, String var4, Uri var5, List var6) {
      String var7 = ((hx)var1.a(hc.CG)).getContext().getPackageName();
      b(var7, var3);
      return this.view(var1, var2, a(var7, var3), var4, var5, var6);
   }

   public PendingResult viewEnd(GoogleApiClient var1, Activity var2, Intent var3) {
      return this.a(var1, new hr[]{new hr(hr.a(((hx)var1.a(hc.CG)).getContext().getPackageName(), var3), System.currentTimeMillis(), 3)});
   }

   public PendingResult viewEnd(GoogleApiClient var1, Activity var2, Uri var3) {
      return this.viewEnd(var1, var2, a(((hx)var1.a(hc.CG)).getContext().getPackageName(), var3));
   }

   private static final class a implements AppIndexApi.ActionResult {
      private hz DE;
      private PendingResult DF;
      private Action DG;
      private String DH;

      a(hz var1, PendingResult var2, Action var3, String var4) {
         this.DE = var1;
         this.DF = var2;
         this.DG = var3;
         this.DH = var4;
      }

      public PendingResult end(GoogleApiClient var1) {
         String var4 = ((hx)var1.a(hc.CG)).getContext().getPackageName();
         long var2 = System.currentTimeMillis();
         hr var5 = hy.a(this.DG, this.DH, var2, var4, 3);
         return this.DE.a(var1, new hr[]{var5});
      }

      public PendingResult getPendingResult() {
         return this.DF;
      }
   }

   private abstract static class b extends BaseImplementation.a {
      public b(GoogleApiClient var1) {
         super(hc.CG, var1);
      }

      protected abstract void a(hu var1) throws RemoteException;

      protected final void a(hx var1) throws RemoteException {
         this.a(var1.fH());
      }
   }

   private abstract static class c extends hz.b {
      c(GoogleApiClient var1) {
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

   private static final class d extends hw {
      public d(BaseImplementation.b var1) {
         super(var1);
      }

      public void a(Status var1) {
         this.DA.b(var1);
      }
   }
}
