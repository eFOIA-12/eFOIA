package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.UserMetadata;

public class h implements Creator {
   static void a(UserMetadata var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.OR, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String)var0.OS, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (String)var0.OT, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, var0.OU);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (String)var0.OV, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public UserMetadata W(Parcel var1) {
      boolean var5 = false;
      String var6 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      String var7 = null;
      String var8 = null;
      String var9 = null;
      int var2 = 0;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         case 2:
            var9 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 3:
            var8 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 4:
            var7 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 5:
            var5 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4);
            break;
         case 6:
            var6 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new UserMetadata(var2, var9, var8, var7, var5, var6);
      }
   }

   public UserMetadata[] be(int var1) {
      return new UserMetadata[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.W(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.be(var1);
   }
}
