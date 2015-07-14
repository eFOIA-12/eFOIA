package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.CreateFileRequest;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class k implements Creator {
   static void a(CreateFileRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Parcelable)var0.Pz, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (Parcelable)var0.Px, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (Parcelable)var0.Pr, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (Integer)var0.Py, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, var0.PA);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, (String)var0.Oy, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 8, var0.PB);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 9, var0.PC);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public CreateFileRequest ah(Parcel var1) {
      int var2 = 0;
      String var8 = null;
      int var5 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var3 = 0;
      boolean var7 = false;
      Integer var9 = null;
      Contents var10 = null;
      MetadataBundle var11 = null;
      DriveId var12 = null;
      int var4 = 0;

      while(var1.dataPosition() < var5) {
         int var6 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var6)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 2:
            var12 = (DriveId)com.google.android.gms.common.internal.safeparcel.a.a(var1, var6, DriveId.CREATOR);
            break;
         case 3:
            var11 = (MetadataBundle)com.google.android.gms.common.internal.safeparcel.a.a(var1, var6, MetadataBundle.CREATOR);
            break;
         case 4:
            var10 = (Contents)com.google.android.gms.common.internal.safeparcel.a.a(var1, var6, Contents.CREATOR);
            break;
         case 5:
            var9 = com.google.android.gms.common.internal.safeparcel.a.h(var1, var6);
            break;
         case 6:
            var7 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var6);
            break;
         case 7:
            var8 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var6);
            break;
         case 8:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 9:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var6);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var5, var1);
      } else {
         return new CreateFileRequest(var4, var12, var11, var10, var9, var7, var8, var3, var2);
      }
   }

   public CreateFileRequest[] bs(int var1) {
      return new CreateFileRequest[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.ah(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.bs(var1);
   }
}
