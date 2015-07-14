package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.oa;
import com.google.android.gms.internal.oc;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class od implements Creator {
   static void a(oc var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 1, (String)var0.getName(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Parcelable)var0.nx(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String)var0.getAddress(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 4, var0.ny(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (String)var0.getPhoneNumber(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (String)var0.nz(), false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public oc cU(Parcel var1) {
      String var5 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      String var6 = null;
      ArrayList var7 = null;
      String var8 = null;
      LatLng var9 = null;
      String var10 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var10 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 2:
            var9 = (LatLng)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, LatLng.CREATOR);
            break;
         case 3:
            var8 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 4:
            var7 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4, oa.CREATOR);
            break;
         case 5:
            var6 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 6:
            var5 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
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
         return new oc(var2, var10, var9, var8, var7, var6, var5);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.cU(var1);
   }

   public oc[] eQ(int var1) {
      return new oc[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.eQ(var1);
   }
}
