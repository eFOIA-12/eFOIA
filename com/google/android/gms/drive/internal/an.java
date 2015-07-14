package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.internal.OnDownloadProgressResponse;

public class an implements Creator {
   static void a(OnDownloadProgressResponse var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, var0.QL);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, var0.QM);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public OnDownloadProgressResponse as(Parcel var1) {
      long var5 = 0L;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      long var7 = 0L;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         case 2:
            var7 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var4);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var4);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new OnDownloadProgressResponse(var2, var7, var5);
      }
   }

   public OnDownloadProgressResponse[] bH(int var1) {
      return new OnDownloadProgressResponse[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.as(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.bH(var1);
   }
}
