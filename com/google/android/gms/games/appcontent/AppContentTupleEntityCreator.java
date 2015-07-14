package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.appcontent.AppContentTupleEntity;

public class AppContentTupleEntityCreator implements Creator {
   static void a(AppContentTupleEntity var0, Parcel var1, int var2) {
      var2 = b.H(var1);
      b.a(var1, 1, (String)var0.getName(), false);
      b.c(var1, 1000, var0.getVersionCode());
      b.a(var1, 2, (String)var0.getValue(), false);
      b.H(var1, var2);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.cs(var1);
   }

   public AppContentTupleEntity cs(Parcel var1) {
      String var6 = null;
      int var3 = a.G(var1);
      int var2 = 0;
      String var5 = null;

      while(var1.dataPosition() < var3) {
         int var4 = a.F(var1);
         switch(a.aH(var4)) {
         case 1:
            var5 = a.o(var1, var4);
            break;
         case 2:
            var6 = a.o(var1, var4);
            break;
         case 1000:
            var2 = a.g(var1, var4);
            break;
         default:
            a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new a.a("Overread allowed size end=" + var3, var1);
      } else {
         return new AppContentTupleEntity(var2, var5, var6);
      }
   }

   public AppContentTupleEntity[] dN(int var1) {
      return new AppContentTupleEntity[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.dN(var1);
   }
}
