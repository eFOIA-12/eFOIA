package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.wearable.c;

public class d implements Creator {
   static void a(c var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.getName(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String)var0.getAddress(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 4, var0.getType());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 5, var0.getRole());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, var0.isEnabled());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, var0.isConnected());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, (String)var0.rj(), false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.em(var1);
   }

   public c em(Parcel var1) {
      String var9 = null;
      boolean var7 = false;
      int var5 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      boolean var8 = false;
      int var2 = 0;
      int var3 = 0;
      String var10 = null;
      String var11 = null;
      int var4 = 0;

      while(var1.dataPosition() < var5) {
         int var6 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var6)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 2:
            var11 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var6);
            break;
         case 3:
            var10 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var6);
            break;
         case 4:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 5:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 6:
            var8 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var6);
            break;
         case 7:
            var7 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var6);
            break;
         case 8:
            var9 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var6);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var6);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var5, var1);
      } else {
         return new c(var4, var11, var10, var3, var2, var8, var7, var9);
      }
   }

   public c[] gv(int var1) {
      return new c[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.gv(var1);
   }
}
