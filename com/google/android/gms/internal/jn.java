package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Handler.Callback;
import com.google.android.gms.internal.jl;
import java.util.HashMap;
import java.util.HashSet;

public final class jn implements Callback {
   private static final Object Nd = new Object();
   private static jn Ne;
   private final HashMap Nf;
   private final Handler mHandler;
   private final Context mO;

   private jn(Context var1) {
      this.mHandler = new Handler(var1.getMainLooper(), this);
      this.Nf = new HashMap();
      this.mO = var1.getApplicationContext();
   }

   public static jn J(Context param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   static HashMap a(jn var0) {
      return var0.Nf;
   }

   public boolean a(String param1, jl.f param2) {
      // $FF: Couldn't be decompiled
   }

   public void b(String param1, jl.f param2) {
      // $FF: Couldn't be decompiled
   }

   public boolean handleMessage(Message param1) {
      // $FF: Couldn't be decompiled
   }

   final class a {
      private final String Ng;
      private final jn.a Nh;
      private final HashSet Ni;
      private boolean Nj;
      private IBinder Nk;
      private ComponentName Nl;
      private int mState;

      public a(String var2) {
         this.Ng = var2;
         this.Nh = new jn.a();
         this.Ni = new HashSet();
         this.mState = 2;
      }

      // $FF: synthetic method
      static int a(jn.a var0, int var1) {
         var0.mState = var1;
         return var1;
      }

      // $FF: synthetic method
      static ComponentName a(jn.a var0, ComponentName var1) {
         var0.Nl = var1;
         return var1;
      }

      // $FF: synthetic method
      static IBinder a(jn.a var0, IBinder var1) {
         var0.Nk = var1;
         return var1;
      }

      // $FF: synthetic method
      static HashSet a(jn.a var0) {
         return var0.Ni;
      }

      public void a(jl.f var1) {
         this.Ni.add(var1);
      }

      public void b(jl.f var1) {
         this.Ni.remove(var1);
      }

      public boolean c(jl.f var1) {
         return this.Ni.contains(var1);
      }

      public IBinder getBinder() {
         return this.Nk;
      }

      public ComponentName getComponentName() {
         return this.Nl;
      }

      public int getState() {
         return this.mState;
      }

      public void hA() {
         Intent var1 = (new Intent(this.Ng)).setPackage("com.google.android.gms");
         this.Nj = jn.this.mO.bindService(var1, this.Nh, 129);
         if(this.Nj) {
            this.mState = 3;
         } else {
            jn.this.mO.unbindService(this.Nh);
         }
      }

      public void hB() {
         jn.this.mO.unbindService(this.Nh);
         this.Nj = false;
         this.mState = 2;
      }

      public String hC() {
         return this.Ng;
      }

      public boolean hD() {
         return this.Ni.isEmpty();
      }

      public boolean isBound() {
         return this.Nj;
      }
   }

   public class a implements ServiceConnection {
      public void onServiceConnected(ComponentName param1, IBinder param2) {
         // $FF: Couldn't be decompiled
      }

      public void onServiceDisconnected(ComponentName param1) {
         // $FF: Couldn't be decompiled
      }
   }
}
