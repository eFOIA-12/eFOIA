package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.CustomProperty;

public class c implements Creator {
   static void a(CustomProperty var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Parcelable)var0.Rg, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String)var0.mValue, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public CustomProperty aO(Parcel var1) {
      String var5 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      CustomPropertyKey var6 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         case 2:
            var6 = (CustomPropertyKey)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, CustomPropertyKey.CREATOR);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new CustomProperty(var2, var6, var5);
      }
   }

   public CustomProperty[] cd(int var1) {
      return new CustomProperty[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.aO(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.cd(var1);
   }
}
