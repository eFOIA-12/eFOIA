package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.RemoveEventListenerRequest;

public class bc implements Creator {
   static void a(RemoveEventListenerRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Parcelable)var0.Oj, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 3, var0.Pm);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public RemoveEventListenerRequest aG(Parcel var1) {
      int var2 = 0;
      int var4 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      DriveId var6 = null;
      int var3 = 0;

      while(var1.dataPosition() < var4) {
         int var5 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var5)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 2:
            var6 = (DriveId)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, DriveId.CREATOR);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var5);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var4, var1);
      } else {
         return new RemoveEventListenerRequest(var3, var6, var2);
      }
   }

   public RemoveEventListenerRequest[] bV(int var1) {
      return new RemoveEventListenerRequest[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.aG(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.bV(var1);
   }
}
