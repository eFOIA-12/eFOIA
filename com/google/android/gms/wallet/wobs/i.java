package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.wallet.wobs.f;
import com.google.android.gms.wallet.wobs.g;
import com.google.android.gms.wallet.wobs.l;

public class i implements Creator {
   static void a(f var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.label, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (Parcelable)var0.awM, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (String)var0.type, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (Parcelable)var0.avm, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.eg(var1);
   }

   public f eg(Parcel var1) {
      l var5 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      String var6 = null;
      g var7 = null;
      String var8 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         case 2:
            var8 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 3:
            var7 = (g)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, g.CREATOR);
            break;
         case 4:
            var6 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 5:
            var5 = (l)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, l.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new f(var2, var8, var7, var6, var5);
      }
   }

   public f[] gp(int var1) {
      return new f[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.gp(var1);
   }
}
