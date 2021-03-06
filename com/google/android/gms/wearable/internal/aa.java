package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.wearable.internal.z;

public class aa implements Creator {
   static void a(z var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 2, var0.statusCode);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (Parcelable)var0.axN, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.ew(var1);
   }

   public z ew(Parcel var1) {
      int var3 = 0;
      int var4 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      ParcelFileDescriptor var6 = null;
      int var2 = 0;

      while(var1.dataPosition() < var4) {
         int var5 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var5)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 2:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 3:
            var6 = (ParcelFileDescriptor)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, ParcelFileDescriptor.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var5);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var4, var1);
      } else {
         return new z(var2, var3, var6);
      }
   }

   public z[] gF(int var1) {
      return new z[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.gF(var1);
   }
}
