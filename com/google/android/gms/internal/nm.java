package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.nd;
import com.google.android.gms.internal.nl;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

public class nm implements Creator {
   static void a(nl var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 1, (Parcelable)var0.We, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, var0.ahh);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, var0.ahi);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, var0.ahj);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 5, var0.ahk, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (String)var0.mTag, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public nl cM(Parcel var1) {
      String var8 = null;
      boolean var5 = true;
      boolean var7 = false;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      Object var9 = nl.ahg;
      boolean var6 = true;
      LocationRequest var10 = null;
      int var2 = 0;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var10 = (LocationRequest)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, LocationRequest.CREATOR);
            break;
         case 2:
            var7 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4);
            break;
         case 3:
            var6 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4);
            break;
         case 4:
            var5 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4);
            break;
         case 5:
            var9 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4, nd.CREATOR);
            break;
         case 6:
            var8 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 1000:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new nl(var2, var10, var7, var6, var5, (List)var9, var8);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.cM(var1);
   }

   public nl[] eG(int var1) {
      return new nl[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.eG(var1);
   }
}
