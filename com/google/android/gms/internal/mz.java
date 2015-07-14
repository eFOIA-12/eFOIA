package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.na;
import com.google.android.gms.internal.np;

public class mz {
   private final String DZ;
   private final np Ee;
   private final String JK;
   private na agz;
   private final Context mContext;

   private mz(Context var1, String var2, String var3, np var4) {
      this.mContext = var1;
      this.DZ = var2;
      this.Ee = var4;
      this.agz = null;
      this.JK = var3;
   }

   public static mz a(Context var0, String var1, String var2, np var3) {
      return new mz(var0, var1, var2, var3);
   }
}
