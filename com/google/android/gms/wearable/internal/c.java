package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.wearable.internal.b;

public class c implements Creator {
   static void a(b var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (IBinder)var0.rm(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (Parcelable[])var0.axw, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.eo(var1);
   }

   public b eo(Parcel var1) {
      IntentFilter[] var6 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      IBinder var5 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.a.p(var1, var4);
            break;
         case 3:
            var6 = (IntentFilter[])com.google.android.gms.common.internal.safeparcel.a.b(var1, var4, IntentFilter.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new b(var2, var5, var6);
      }
   }

   public b[] gx(int var1) {
      return new b[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.gx(var1);
   }
}
