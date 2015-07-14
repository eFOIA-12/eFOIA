package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.wearable.Asset;

public class a implements Creator {
   static void a(Asset var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (byte[])var0.getData(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String)var0.getDigest(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (Parcelable)var0.axb, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (Parcelable)var0.uri, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.el(var1);
   }

   public Asset el(Parcel var1) {
      Uri var5 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      ParcelFileDescriptor var6 = null;
      String var7 = null;
      byte[] var8 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         case 2:
            var8 = com.google.android.gms.common.internal.safeparcel.a.r(var1, var4);
            break;
         case 3:
            var7 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 4:
            var6 = (ParcelFileDescriptor)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, ParcelFileDescriptor.CREATOR);
            break;
         case 5:
            var5 = (Uri)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, Uri.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new Asset(var2, var8, var7, var6, var5);
      }
   }

   public Asset[] gu(int var1) {
      return new Asset[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.gu(var1);
   }
}
