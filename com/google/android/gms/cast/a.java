package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.images.WebImage;
import java.util.ArrayList;

public class a implements Creator {
   static void a(ApplicationMetadata var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.getApplicationId(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String)var0.getName(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 4, var0.getImages(), false);
      com.google.android.gms.common.internal.safeparcel.b.b(var1, 5, var0.Fq, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (String)var0.getSenderAppIdentifier(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, (Parcelable)var0.fP(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public ApplicationMetadata[] V(int var1) {
      return new ApplicationMetadata[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.u(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.V(var1);
   }

   public ApplicationMetadata u(Parcel var1) {
      Uri var5 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      String var6 = null;
      ArrayList var7 = null;
      ArrayList var8 = null;
      String var9 = null;
      String var10 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         case 2:
            var10 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 3:
            var9 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 4:
            var8 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4, WebImage.CREATOR);
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.a.C(var1, var4);
            break;
         case 6:
            var6 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 7:
            var5 = (Uri)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, Uri.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new ApplicationMetadata(var2, var10, var9, var8, var7, var6, var5);
      }
   }
}
