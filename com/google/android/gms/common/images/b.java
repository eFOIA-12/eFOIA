package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;

public class b implements Creator {
   static void a(WebImage var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Parcelable)var0.getUrl(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 3, var0.getWidth());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 4, var0.getHeight());
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public WebImage C(Parcel var1) {
      int var2 = 0;
      int var5 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      Uri var7 = null;
      int var3 = 0;
      int var4 = 0;

      while(var1.dataPosition() < var5) {
         int var6 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var6)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 2:
            var7 = (Uri)com.google.android.gms.common.internal.safeparcel.a.a(var1, var6, Uri.CREATOR);
            break;
         case 3:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 4:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var6);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var5, var1);
      } else {
         return new WebImage(var4, var7, var3, var2);
      }
   }

   public WebImage[] aA(int var1) {
      return new WebImage[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.C(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.aA(var1);
   }
}
