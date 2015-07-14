package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.AppStateManager;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.ia;
import com.google.android.gms.internal.id;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jt;
import com.google.android.gms.internal.jx;

public final class ib extends jl {
   private final String DZ;

   public ib(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4, String var5, String[] var6) {
      super(var1, var2, var3, var4, var6);
      this.DZ = (String)jx.i(var5);
   }

   protected id H(IBinder var1) {
      return id.a.J(var1);
   }

   public void a(BaseImplementation.b var1) {
      try {
         ((id)this.hw()).a(new ib.c(var1));
      } catch (RemoteException var2) {
         Log.w("AppStateClient", "service died");
      }
   }

   public void a(BaseImplementation.b var1, int var2) {
      try {
         ((id)this.hw()).b(new ib.a(var1), var2);
      } catch (RemoteException var3) {
         Log.w("AppStateClient", "service died");
      }
   }

   public void a(BaseImplementation.b var1, int var2, String var3, byte[] var4) {
      try {
         ((id)this.hw()).a(new ib.e(var1), var2, var3, var4);
      } catch (RemoteException var5) {
         Log.w("AppStateClient", "service died");
      }
   }

   public void a(BaseImplementation.b param1, int param2, byte[] param3) {
      // $FF: Couldn't be decompiled
   }

   protected void a(jt var1, jl.e var2) throws RemoteException {
      var1.a(var2, 6587000, this.getContext().getPackageName(), (String)this.DZ, (String[])this.hv());
   }

   public void b(BaseImplementation.b var1) {
      try {
         ((id)this.hw()).b(new ib.g(var1));
      } catch (RemoteException var2) {
         Log.w("AppStateClient", "service died");
      }
   }

   public void b(BaseImplementation.b var1, int var2) {
      try {
         ((id)this.hw()).a(new ib.e(var1), var2);
      } catch (RemoteException var3) {
         Log.w("AppStateClient", "service died");
      }
   }

   protected String bK() {
      return "com.google.android.gms.appstate.service.START";
   }

   protected String bL() {
      return "com.google.android.gms.appstate.internal.IAppStateService";
   }

   protected void c(String... var1) {
      int var2 = 0;

      boolean var3;
      for(var3 = false; var2 < var1.length; ++var2) {
         if(var1[var2].equals("https://www.googleapis.com/auth/appstate")) {
            var3 = true;
         }
      }

      jx.a(var3, String.format("App State APIs requires %s to function.", new Object[]{"https://www.googleapis.com/auth/appstate"}));
   }

   public int fL() {
      try {
         int var1 = ((id)this.hw()).fL();
         return var1;
      } catch (RemoteException var3) {
         Log.w("AppStateClient", "service died");
         return 2;
      }
   }

   public int fM() {
      try {
         int var1 = ((id)this.hw()).fM();
         return var1;
      } catch (RemoteException var3) {
         Log.w("AppStateClient", "service died");
         return 2;
      }
   }

   // $FF: synthetic method
   protected IInterface l(IBinder var1) {
      return this.H(var1);
   }

   private static final class a extends ia {
      private final BaseImplementation.b Ea;

      public a(BaseImplementation.b var1) {
         this.Ea = (BaseImplementation.b)jx.b((Object)var1, "Result holder must not be null");
      }

      public void e(int var1, int var2) {
         Status var3 = new Status(var1);
         this.Ea.b(new ib.b(var3, var2));
      }
   }

   private static final class b implements AppStateManager.StateDeletedResult {
      private final Status Eb;
      private final int Ec;

      public b(Status var1, int var2) {
         this.Eb = var1;
         this.Ec = var2;
      }

      public int getStateKey() {
         return this.Ec;
      }

      public Status getStatus() {
         return this.Eb;
      }
   }

   private static final class c extends ia {
      private final BaseImplementation.b Ea;

      public c(BaseImplementation.b var1) {
         this.Ea = (BaseImplementation.b)jx.b((Object)var1, "Result holder must not be null");
      }

      public void a(DataHolder var1) {
         this.Ea.b(new ib.d(var1));
      }
   }

   private static final class d extends com.google.android.gms.common.api.b implements AppStateManager.StateListResult {
      private final AppStateBuffer Ed;

      public d(DataHolder var1) {
         super(var1);
         this.Ed = new AppStateBuffer(var1);
      }

      public AppStateBuffer getStateBuffer() {
         return this.Ed;
      }
   }

   private static final class e extends ia {
      private final BaseImplementation.b Ea;

      public e(BaseImplementation.b var1) {
         this.Ea = (BaseImplementation.b)jx.b((Object)var1, "Result holder must not be null");
      }

      public void a(int var1, DataHolder var2) {
         this.Ea.b(new ib.f(var1, var2));
      }
   }

   private static final class f extends com.google.android.gms.common.api.b implements AppStateManager.StateConflictResult, AppStateManager.StateLoadedResult, AppStateManager.StateResult {
      private final int Ec;
      private final AppStateBuffer Ed;

      public f(int var1, DataHolder var2) {
         super(var2);
         this.Ec = var1;
         this.Ed = new AppStateBuffer(var2);
      }

      private boolean fN() {
         return this.Eb.getStatusCode() == 2000;
      }

      public AppStateManager.StateConflictResult getConflictResult() {
         return this.fN()?this:null;
      }

      public AppStateManager.StateLoadedResult getLoadedResult() {
         ib.f var1 = this;
         if(this.fN()) {
            var1 = null;
         }

         return var1;
      }

      public byte[] getLocalData() {
         return this.Ed.getCount() == 0?null:this.Ed.get(0).getLocalData();
      }

      public String getResolvedVersion() {
         return this.Ed.getCount() == 0?null:this.Ed.get(0).getConflictVersion();
      }

      public byte[] getServerData() {
         return this.Ed.getCount() == 0?null:this.Ed.get(0).getConflictData();
      }

      public int getStateKey() {
         return this.Ec;
      }

      public void release() {
         this.Ed.release();
      }
   }

   private static final class g extends ia {
      private final BaseImplementation.b Ea;

      public g(BaseImplementation.b var1) {
         this.Ea = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void fK() {
         Status var1 = new Status(0);
         this.Ea.b(var1);
      }
   }
}
