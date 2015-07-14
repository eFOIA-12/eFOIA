package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hr;
import java.util.ArrayList;

public class hn implements Creator {
   static void a(hl.b var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 1, (Parcelable)var0.Dd, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 2, var0.De, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public hl.b[] O(int var1) {
      return new hl.b[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.q(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.O(var1);
   }

   public hl.b q(Parcel var1) {
      ArrayList var5 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      Status var6 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var6 = (Status)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, Status.CREATOR);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4, hr.CREATOR);
            break;
         case 1000:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new hl.b(var2, var6, var5);
      }
   }
}
