package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.appcontent.AppContentActionEntity;
import com.google.android.gms.games.appcontent.AppContentCardEntity;
import com.google.android.gms.games.appcontent.AppContentSectionEntity;
import java.util.ArrayList;

public class AppContentSectionEntityCreator implements Creator {
   static void a(AppContentSectionEntity var0, Parcel var1, int var2) {
      int var3 = b.H(var1);
      b.c(var1, 1, var0.getActions(), false);
      b.c(var1, 1000, var0.getVersionCode());
      b.a(var1, 2, (Parcelable)var0.kY(), var2, false);
      b.c(var1, 3, var0.kZ(), false);
      b.a(var1, 4, (String)var0.kI(), false);
      b.a(var1, 5, (Bundle)var0.kP(), false);
      b.a(var1, 6, (String)var0.kQ(), false);
      b.a(var1, 7, (String)var0.getTitle(), false);
      b.a(var1, 8, (String)var0.getType(), false);
      b.H(var1, var3);
   }

   public AppContentSectionEntity cr(Parcel var1) {
      String var5 = null;
      int var3 = a.G(var1);
      int var2 = 0;
      String var6 = null;
      String var7 = null;
      Bundle var8 = null;
      String var9 = null;
      ArrayList var10 = null;
      Uri var11 = null;
      ArrayList var12 = null;

      while(var1.dataPosition() < var3) {
         int var4 = a.F(var1);
         switch(a.aH(var4)) {
         case 1:
            var12 = a.c(var1, var4, AppContentActionEntity.CREATOR);
            break;
         case 2:
            var11 = (Uri)a.a(var1, var4, Uri.CREATOR);
            break;
         case 3:
            var10 = a.c(var1, var4, AppContentCardEntity.CREATOR);
            break;
         case 4:
            var9 = a.o(var1, var4);
            break;
         case 5:
            var8 = a.q(var1, var4);
            break;
         case 6:
            var7 = a.o(var1, var4);
            break;
         case 7:
            var6 = a.o(var1, var4);
            break;
         case 8:
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
         return new AppContentSectionEntity(var2, var12, var11, var10, var9, var8, var7, var6, var5);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.cr(var1);
   }

   public AppContentSectionEntity[] dM(int var1) {
      return new AppContentSectionEntity[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.dM(var1);
   }
}
