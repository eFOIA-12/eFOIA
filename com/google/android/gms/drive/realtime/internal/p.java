package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.realtime.internal.ParcelableCollaborator;

public class p implements Creator {
   static void a(ParcelableCollaborator var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, var0.SH);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, var0.SI);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (String)var0.vZ, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (String)var0.SJ, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (String)var0.OS, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, (String)var0.SK, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, (String)var0.SL, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public ParcelableCollaborator be(Parcel var1) {
      boolean var5 = false;
      String var7 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      String var8 = null;
      String var9 = null;
      String var10 = null;
      String var11 = null;
      boolean var6 = false;
      int var2 = 0;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         case 2:
            var6 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4);
            break;
         case 4:
            var11 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 5:
            var10 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 6:
            var9 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 7:
            var8 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 8:
            var7 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new ParcelableCollaborator(var2, var6, var5, var11, var10, var9, var8, var7);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.be(var1);
   }

   public ParcelableCollaborator[] cu(int var1) {
      return new ParcelableCollaborator[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.cu(var1);
   }
}
