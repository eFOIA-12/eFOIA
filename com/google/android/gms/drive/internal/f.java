package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class f implements Creator {
   static void a(CloseContentsAndUpdateMetadataRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Parcelable)var0.Pp, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (Parcelable)var0.Pq, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (Parcelable)var0.Pr, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, var0.Oz);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (String)var0.Oy, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 7, var0.Ps);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public CloseContentsAndUpdateMetadataRequest ad(Parcel var1) {
      int var2 = 0;
      String var7 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      boolean var6 = false;
      Contents var8 = null;
      MetadataBundle var9 = null;
      DriveId var10 = null;
      int var3 = 0;

      while(var1.dataPosition() < var4) {
         int var5 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var5)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 2:
            var10 = (DriveId)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, DriveId.CREATOR);
            break;
         case 3:
            var9 = (MetadataBundle)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, MetadataBundle.CREATOR);
            break;
         case 4:
            var8 = (Contents)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, Contents.CREATOR);
            break;
         case 5:
            var6 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var5);
            break;
         case 6:
            var7 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 7:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var5);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var4, var1);
      } else {
         return new CloseContentsAndUpdateMetadataRequest(var3, var10, var9, var8, var6, var7, var2);
      }
   }

   public CloseContentsAndUpdateMetadataRequest[] bn(int var1) {
      return new CloseContentsAndUpdateMetadataRequest[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.ad(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.bn(var1);
   }
}
