package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.LaunchOptions;

public class c implements Creator {
   static void a(LaunchOptions var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, var0.getRelaunchIfRunning());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String)var0.getLanguage(), false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public LaunchOptions[] aa(int var1) {
      return new LaunchOptions[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.w(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.aa(var1);
   }

   public LaunchOptions w(Parcel var1) {
      boolean var5 = false;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      String var6 = null;
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
            var6 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new LaunchOptions(var2, var5, var6);
      }
   }
}
