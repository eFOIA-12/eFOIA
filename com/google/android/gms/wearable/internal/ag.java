package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.internal.az;
import com.google.android.gms.wearable.internal.ba;
import com.google.android.gms.wearable.internal.bb;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

abstract class ag {
   private final HashMap agU = new HashMap();

   abstract bb a(Object var1, IntentFilter[] var2);

   public void a(ba param1, BaseImplementation.b param2, Object param3) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   public void a(ba param1, BaseImplementation.b param2, Object param3, IntentFilter[] param4) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   public void b(ba param1) {
      // $FF: Couldn't be decompiled
   }

   public void ca(IBinder param1) {
      // $FF: Couldn't be decompiled
   }

   private static class a extends az.a {
      private WeakReference axP;
      private WeakReference axQ;

      a(Map var1, Object var2, BaseImplementation.b var3) {
         super(var3);
         this.axP = new WeakReference(var1);
         this.axQ = new WeakReference(var2);
      }

      public void a(Status param1) {
         // $FF: Couldn't be decompiled
      }
   }

   static final class b extends ag {
      bb a(DataApi.DataListener var1, IntentFilter[] var2) {
         return bb.b(var1, var2);
      }
   }

   static final class c extends ag {
      bb a(MessageApi.MessageListener var1, IntentFilter[] var2) {
         return bb.b(var1, var2);
      }
   }

   static final class d extends ag {
      bb a(NodeApi.NodeListener var1, IntentFilter[] var2) {
         return bb.a(var1);
      }
   }

   private static class e extends az.a {
      private WeakReference axP;
      private WeakReference axQ;

      e(Map var1, Object var2, BaseImplementation.b var3) {
         super(var3);
         this.axP = new WeakReference(var1);
         this.axQ = new WeakReference(var2);
      }

      public void a(Status param1) {
         // $FF: Couldn't be decompiled
      }
   }
}
