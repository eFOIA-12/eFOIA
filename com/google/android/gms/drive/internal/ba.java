package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;

public class ba implements Creator {
   static void a(OpenFileIntentSenderRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.OH, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String[])var0.OI, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (Parcelable)var0.OJ, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public OpenFileIntentSenderRequest aE(Parcel var1) {
      DriveId var7 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      String[] var6 = null;
      String var5 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 3:
            var6 = com.google.android.gms.common.internal.safeparcel.a.A(var1, var4);
            break;
         case 4:
            var7 = (DriveId)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, DriveId.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new OpenFileIntentSenderRequest(var2, var5, var6, var7);
      }
   }

   public OpenFileIntentSenderRequest[] bT(int var1) {
      return new OpenFileIntentSenderRequest[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.aE(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.bT(var1);
   }
}
