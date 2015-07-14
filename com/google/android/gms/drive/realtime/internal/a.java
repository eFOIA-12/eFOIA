package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest;

public class a implements Creator {
   static void a(BeginCompoundOperationRequest var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, var0.SF);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String)var0.mName, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, var0.SG);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public BeginCompoundOperationRequest bc(Parcel var1) {
      boolean var5 = false;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      String var7 = null;
      boolean var6 = true;
      int var2 = 0;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4);
            break;
         case 3:
            var7 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 4:
            var6 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new BeginCompoundOperationRequest(var2, var5, var7, var6);
      }
   }

   public BeginCompoundOperationRequest[] cr(int var1) {
      return new BeginCompoundOperationRequest[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.bc(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.cr(var1);
   }
}
