package com.google.android.gms.games.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.internal.ConnectionInfo;

public class ConnectionInfoCreator implements Creator {
   static void a(ConnectionInfo var0, Parcel var1, int var2) {
      var2 = b.H(var1);
      b.a(var1, 1, (String)var0.le(), false);
      b.c(var1, 1000, var0.getVersionCode());
      b.c(var1, 2, var0.lf());
      b.H(var1, var2);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.ct(var1);
   }

   public ConnectionInfo ct(Parcel var1) {
      int var3 = 0;
      int var4 = a.G(var1);
      String var6 = null;
      int var2 = 0;

      while(var1.dataPosition() < var4) {
         int var5 = a.F(var1);
         switch(a.aH(var5)) {
         case 1:
            var6 = a.o(var1, var5);
            break;
         case 2:
            var3 = a.g(var1, var5);
            break;
         case 1000:
            var2 = a.g(var1, var5);
            break;
         default:
            a.b(var1, var5);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new a.a("Overread allowed size end=" + var4, var1);
      } else {
         return new ConnectionInfo(var2, var6, var3);
      }
   }

   public ConnectionInfo[] dR(int var1) {
      return new ConnectionInfo[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.dR(var1);
   }
}
