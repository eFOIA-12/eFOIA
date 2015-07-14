package com.google.android.gms.fitness.data;

import android.os.RemoteException;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.k;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.internal.jx;
import java.util.HashMap;
import java.util.Map;

public class l extends k.a {
   private final OnDataPointListener UF;

   private l(OnDataPointListener var1) {
      this.UF = (OnDataPointListener)jx.i(var1);
   }

   // $FF: synthetic method
   l(OnDataPointListener var1, Object var2) {
      this(var1);
   }

   public void c(DataPoint var1) throws RemoteException {
      this.UF.onDataPoint(var1);
   }

   public static class a {
      private static final l.a UG = new l.a();
      private final Map UH = new HashMap();

      public static l.a jG() {
         return UG;
      }

      public l a(OnDataPointListener param1) {
         // $FF: Couldn't be decompiled
      }

      public l b(OnDataPointListener param1) {
         // $FF: Couldn't be decompiled
      }

      public l c(OnDataPointListener param1) {
         // $FF: Couldn't be decompiled
      }
   }
}
