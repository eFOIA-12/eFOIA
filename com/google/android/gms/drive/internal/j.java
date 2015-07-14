package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.CreateFileIntentSenderRequest;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class j implements Creator {
   static void a(CreateFileIntentSenderRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Parcelable)var0.Px, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 3, var0.ve);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (String)var0.OH, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (Parcelable)var0.OJ, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (Integer)var0.Py, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public CreateFileIntentSenderRequest ag(Parcel var1) {
      int var2 = 0;
      Integer var6 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      DriveId var7 = null;
      String var8 = null;
      MetadataBundle var9 = null;
      int var3 = 0;

      while(var1.dataPosition() < var4) {
         int var5 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var5)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 2:
            var9 = (MetadataBundle)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, MetadataBundle.CREATOR);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 4:
            var8 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 5:
            var7 = (DriveId)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, DriveId.CREATOR);
            break;
         case 6:
            var6 = com.google.android.gms.common.internal.safeparcel.a.h(var1, var5);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var5);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var4, var1);
      } else {
         return new CreateFileIntentSenderRequest(var3, var9, var2, var8, var7, var6);
      }
   }

   public CreateFileIntentSenderRequest[] br(int var1) {
      return new CreateFileIntentSenderRequest[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.ag(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.br(var1);
   }
}
