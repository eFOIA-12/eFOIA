package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.wearable.internal.al;

public class am implements Creator {
   static void a(al var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.getId(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String)var0.getDisplayName(), false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.ez(var1);
   }

   public al ez(Parcel var1) {
      String var6 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      String var5 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 3:
            var6 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new al(var2, var5, var6);
      }
   }

   public al[] gI(int var1) {
      return new al[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.gI(var1);
   }
}
