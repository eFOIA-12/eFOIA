package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;

public class f implements Creator {
   static void a(DataHolder var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 1, (String[])var0.gY(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Parcelable[])var0.gZ(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 3, var0.getStatusCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (Bundle)var0.gV(), false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public DataHolder B(Parcel var1) {
      int var2 = 0;
      Bundle var6 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      CursorWindow[] var7 = null;
      String[] var8 = null;
      int var3 = 0;

      while(var1.dataPosition() < var4) {
         int var5 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var5)) {
         case 1:
            var8 = com.google.android.gms.common.internal.safeparcel.a.A(var1, var5);
            break;
         case 2:
            var7 = (CursorWindow[])com.google.android.gms.common.internal.safeparcel.a.b(var1, var5, CursorWindow.CREATOR);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 4:
            var6 = com.google.android.gms.common.internal.safeparcel.a.q(var1, var5);
            break;
         case 1000:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var5);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var4, var1);
      } else {
         DataHolder var9 = new DataHolder(var3, var8, var7, var2, var6);
         var9.gX();
         return var9;
      }
   }

   public DataHolder[] aw(int var1) {
      return new DataHolder[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.B(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.aw(var1);
   }
}
