package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;

public class a implements Creator {
   static void a(Contents var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Parcelable)var0.LG, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 3, var0.ve);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 4, var0.Oi);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (Parcelable)var0.Oj, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, var0.Ok);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public Contents R(Parcel var1) {
      DriveId var8 = null;
      boolean var7 = false;
      int var5 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      int var3 = 0;
      ParcelFileDescriptor var9 = null;
      int var4 = 0;

      while(var1.dataPosition() < var5) {
         int var6 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var6)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 2:
            var9 = (ParcelFileDescriptor)com.google.android.gms.common.internal.safeparcel.a.a(var1, var6, ParcelFileDescriptor.CREATOR);
            break;
         case 3:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 4:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 5:
            var8 = (DriveId)com.google.android.gms.common.internal.safeparcel.a.a(var1, var6, DriveId.CREATOR);
            break;
         case 6:
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var6);
            break;
         case 7:
            var7 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var6);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var5, var1);
      } else {
         return new Contents(var4, var9, var3, var2, var8, var7);
      }
   }

   public Contents[] aX(int var1) {
      return new Contents[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.R(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.aX(var1);
   }
}
