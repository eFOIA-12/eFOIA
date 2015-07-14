package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.appcontent.AppContentActionEntity;
import com.google.android.gms.games.appcontent.AppContentConditionEntity;
import java.util.ArrayList;

public class AppContentActionEntityCreator implements Creator {
   static void a(AppContentActionEntity var0, Parcel var1, int var2) {
      var2 = b.H(var1);
      b.c(var1, 1, var0.kH(), false);
      b.c(var1, 1000, var0.getVersionCode());
      b.a(var1, 2, (String)var0.kI(), false);
      b.a(var1, 3, (Bundle)var0.getExtras(), false);
      b.a(var1, 4, (String)var0.getLabel(), false);
      b.a(var1, 5, (String)var0.kJ(), false);
      b.a(var1, 6, (String)var0.getType(), false);
      b.H(var1, var2);
   }

   public AppContentActionEntity cn(Parcel var1) {
      String var5 = null;
      int var3 = a.G(var1);
      int var2 = 0;
      String var6 = null;
      String var7 = null;
      Bundle var8 = null;
      String var9 = null;
      ArrayList var10 = null;

      while(var1.dataPosition() < var3) {
         int var4 = a.F(var1);
         switch(a.aH(var4)) {
         case 1:
            var10 = a.c(var1, var4, AppContentConditionEntity.CREATOR);
            break;
         case 2:
            var9 = a.o(var1, var4);
            break;
         case 3:
            var8 = a.q(var1, var4);
            break;
         case 4:
            var7 = a.o(var1, var4);
            break;
         case 5:
            var6 = a.o(var1, var4);
            break;
         case 6:
            var5 = a.o(var1, var4);
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
         return new AppContentActionEntity(var2, var10, var9, var8, var7, var6, var5);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.cn(var1);
   }

   public AppContentActionEntity[] dI(int var1) {
      return new AppContentActionEntity[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.dI(var1);
   }
}
