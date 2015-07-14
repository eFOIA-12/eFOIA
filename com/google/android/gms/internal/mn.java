package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;
import com.google.android.gms.internal.lu;
import com.google.android.gms.internal.mb;
import com.google.android.gms.internal.mc;
import com.google.android.gms.internal.md;

public class mn implements SessionsApi {
   private PendingResult a(final GoogleApiClient var1, final String var2, final String var3) {
      return var1.b(new lu.a(var1) {
         protected SessionStopResult A(Status var1) {
            return SessionStopResult.H(var1);
         }

         protected void a(lu var1) throws RemoteException {
            mn.b var2x = new mn.b(this, null);
            String var3x = var1.getContext().getPackageName();
            var1.jM().a((com.google.android.gms.fitness.request.y)(new com.google.android.gms.fitness.request.y()).bx(var2).by(var3).kl(), (mc)var2x, var3x);
         }

         // $FF: synthetic method
         protected Result c(Status var1) {
            return this.A(var1);
         }
      });
   }

   public PendingResult insertSession(final GoogleApiClient var1, final SessionInsertRequest var2) {
      return var1.a((BaseImplementation.a)(new lu.c(var1) {
         protected void a(lu var1) throws RemoteException {
            lu.b var2x = new lu.b(this);
            String var3 = var1.getContext().getPackageName();
            var1.jM().a((SessionInsertRequest)var2, (md)var2x, var3);
         }
      }));
   }

   public PendingResult readSession(final GoogleApiClient var1, final SessionReadRequest var2) {
      return var1.a((BaseImplementation.a)(new lu.a(var1) {
         protected SessionReadResult B(Status var1) {
            return SessionReadResult.G(var1);
         }

         protected void a(lu var1) throws RemoteException {
            mn.a var2x = new mn.a(this, null);
            String var3 = var1.getContext().getPackageName();
            var1.jM().a((SessionReadRequest)var2, (mb)var2x, var3);
         }

         // $FF: synthetic method
         protected Result c(Status var1) {
            return this.B(var1);
         }
      }));
   }

   public PendingResult registerForSessions(final GoogleApiClient var1, final PendingIntent var2) {
      return var1.b(new lu.c(var1) {
         protected void a(lu var1) throws RemoteException {
            lu.b var2x = new lu.b(this);
            com.google.android.gms.fitness.request.u var3 = new com.google.android.gms.fitness.request.u(var2);
            String var4 = var1.getContext().getPackageName();
            var1.jM().a((com.google.android.gms.fitness.request.u)var3, (md)var2x, var4);
         }
      });
   }

   public PendingResult startSession(final GoogleApiClient var1, final Session var2) {
      return var1.b(new lu.c(var1) {
         protected void a(lu var1) throws RemoteException {
            lu.b var2x = new lu.b(this);
            String var3 = var1.getContext().getPackageName();
            var1.jM().a((com.google.android.gms.fitness.request.w)(new com.google.android.gms.fitness.request.w()).b(var2).kk(), (md)var2x, var3);
         }
      });
   }

   public PendingResult stopSession(GoogleApiClient var1, String var2) {
      return this.a(var1, (String)null, var2);
   }

   public PendingResult unregisterForSessions(final GoogleApiClient var1, final PendingIntent var2) {
      return var1.b(new lu.c(var1) {
         protected void a(lu var1) throws RemoteException {
            lu.b var2x = new lu.b(this);
            com.google.android.gms.fitness.request.aa var3 = new com.google.android.gms.fitness.request.aa(var2);
            String var4 = var1.getContext().getPackageName();
            var1.jM().a((com.google.android.gms.fitness.request.aa)var3, (md)var2x, var4);
         }
      });
   }

   private static class a extends mb.a {
      private final BaseImplementation.b Ea;

      private a(BaseImplementation.b var1) {
         this.Ea = var1;
      }

      // $FF: synthetic method
      a(BaseImplementation.b var1, Object var2) {
         this(var1);
      }

      public void a(SessionReadResult var1) throws RemoteException {
         this.Ea.b(var1);
      }
   }

   private static class b extends mc.a {
      private final BaseImplementation.b Ea;

      private b(BaseImplementation.b var1) {
         this.Ea = var1;
      }

      // $FF: synthetic method
      b(BaseImplementation.b var1, Object var2) {
         this(var1);
      }

      public void a(SessionStopResult var1) {
         this.Ea.b(var1);
      }
   }
}
