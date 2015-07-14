package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jt;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.oq;
import com.google.android.gms.internal.or;
import com.google.android.gms.internal.os;
import com.google.android.gms.internal.ou;
import com.google.android.gms.internal.ov;

public class ox extends jl {
   private final String CS;
   private final ou anm;
   private final os ann;
   private boolean ano;
   private final Object mH;

   public ox(Context var1, ou var2) {
      super(var1, var2, var2, new String[0]);
      this.CS = var1.getPackageName();
      this.anm = (ou)jx.i(var2);
      this.anm.a(this);
      this.ann = new os();
      this.mH = new Object();
      this.ano = true;
   }

   private void c(ov var1, or var2) {
      this.ann.a(var1, var2);
   }

   private void d(ov var1, or var2) {
      try {
         this.or();
         ((oq)this.hw()).a(this.CS, var1, var2);
      } catch (RemoteException var4) {
         Log.e("PlayLoggerImpl", "Couldn\'t send log event.  Will try caching.");
         this.c(var1, var2);
      } catch (IllegalStateException var5) {
         Log.e("PlayLoggerImpl", "Service was disconnected.  Will try caching.");
         this.c(var1, var2);
      }
   }

   private void or() {
      // $FF: Couldn't be decompiled
   }

   void U(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   protected void a(jt var1, jl.e var2) throws RemoteException {
      Bundle var3 = new Bundle();
      var1.f(var2, 6587000, this.getContext().getPackageName(), var3);
   }

   public void b(ov param1, or param2) {
      // $FF: Couldn't be decompiled
   }

   protected oq bJ(IBinder var1) {
      return oq.a.bI(var1);
   }

   protected String bK() {
      return "com.google.android.gms.playlog.service.START";
   }

   protected String bL() {
      return "com.google.android.gms.playlog.internal.IPlayLogService";
   }

   // $FF: synthetic method
   protected IInterface l(IBinder var1) {
      return this.bJ(var1);
   }

   public void start() {
      // $FF: Couldn't be decompiled
   }

   public void stop() {
      // $FF: Couldn't be decompiled
   }
}
