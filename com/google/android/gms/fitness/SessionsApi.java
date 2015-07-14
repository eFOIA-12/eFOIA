package com.google.android.gms.fitness;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.internal.jx;

public interface SessionsApi {
   PendingResult insertSession(GoogleApiClient var1, SessionInsertRequest var2);

   PendingResult readSession(GoogleApiClient var1, SessionReadRequest var2);

   PendingResult registerForSessions(GoogleApiClient var1, PendingIntent var2);

   PendingResult startSession(GoogleApiClient var1, Session var2);

   PendingResult stopSession(GoogleApiClient var1, String var2);

   PendingResult unregisterForSessions(GoogleApiClient var1, PendingIntent var2);

   public static class ViewIntentBuilder {
      private String TP;
      private Session TQ;
      private boolean TR = false;
      private final Context mContext;

      public ViewIntentBuilder(Context var1) {
         this.mContext = var1;
      }

      private Intent i(Intent var1) {
         if(this.TP != null) {
            Intent var2 = (new Intent(var1)).setPackage(this.TP);
            ResolveInfo var3 = this.mContext.getPackageManager().resolveActivity(var2, 0);
            if(var3 != null) {
               String var4 = var3.activityInfo.name;
               var2.setComponent(new ComponentName(this.TP, var4));
               return var2;
            }
         }

         return var1;
      }

      public Intent build() {
         boolean var1;
         if(this.TQ != null) {
            var1 = true;
         } else {
            var1 = false;
         }

         jx.a(var1, "Session must be set");
         Intent var2 = new Intent("vnd.google.fitness.VIEW");
         var2.setType(Session.getMimeType(this.TQ.getActivity()));
         c.a((SafeParcelable)this.TQ, (Intent)var2, (String)"vnd.google.fitness.session");
         if(!this.TR) {
            this.TP = this.TQ.getAppPackageName();
         }

         return this.i(var2);
      }

      public SessionsApi.ViewIntentBuilder setPreferredApplication(String var1) {
         this.TP = var1;
         this.TR = true;
         return this;
      }

      public SessionsApi.ViewIntentBuilder setSession(Session var1) {
         this.TQ = var1;
         return this;
      }
   }
}
