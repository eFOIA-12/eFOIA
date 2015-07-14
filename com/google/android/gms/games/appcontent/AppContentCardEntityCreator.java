package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.appcontent.AppContentActionEntity;
import com.google.android.gms.games.appcontent.AppContentAnnotationEntity;
import com.google.android.gms.games.appcontent.AppContentCardEntity;
import com.google.android.gms.games.appcontent.AppContentConditionEntity;
import java.util.ArrayList;

public class AppContentCardEntityCreator implements Creator {
   static void a(AppContentCardEntity var0, Parcel var1, int var2) {
      int var3 = b.H(var1);
      b.c(var1, 1, var0.getActions(), false);
      b.c(var1, 1000, var0.getVersionCode());
      b.c(var1, 2, var0.kN(), false);
      b.c(var1, 3, var0.kH(), false);
      b.a(var1, 4, (String)var0.kI(), false);
      b.c(var1, 5, var0.kO());
      b.a(var1, 6, (String)var0.getDescription(), false);
      b.a(var1, 7, (Bundle)var0.kP(), false);
      b.a(var1, 8, (Parcelable)var0.getIconImageUri(), var2, false);
      b.a(var1, 9, (Parcelable)var0.kL(), var2, false);
      b.a(var1, 10, (String)var0.kQ(), false);
      b.a(var1, 11, (String)var0.getTitle(), false);
      b.c(var1, 12, var0.kR());
      b.a(var1, 13, (String)var0.getType(), false);
      b.H(var1, var3);
   }

   public AppContentCardEntity cp(Parcel var1) {
      int var5 = a.G(var1);
      int var4 = 0;
      ArrayList var17 = null;
      ArrayList var16 = null;
      ArrayList var15 = null;
      String var14 = null;
      int var3 = 0;
      String var13 = null;
      Bundle var12 = null;
      Uri var11 = null;
      Uri var10 = null;
      String var9 = null;
      String var8 = null;
      int var2 = 0;
      String var7 = null;

      while(var1.dataPosition() < var5) {
         int var6 = a.F(var1);
         switch(a.aH(var6)) {
         case 1:
            var17 = a.c(var1, var6, AppContentActionEntity.CREATOR);
            break;
         case 2:
            var16 = a.c(var1, var6, AppContentAnnotationEntity.CREATOR);
            break;
         case 3:
            var15 = a.c(var1, var6, AppContentConditionEntity.CREATOR);
            break;
         case 4:
            var14 = a.o(var1, var6);
            break;
         case 5:
            var3 = a.g(var1, var6);
            break;
         case 6:
            var13 = a.o(var1, var6);
            break;
         case 7:
            var12 = a.q(var1, var6);
            break;
         case 8:
            var11 = (Uri)a.a(var1, var6, Uri.CREATOR);
            break;
         case 9:
            var10 = (Uri)a.a(var1, var6, Uri.CREATOR);
            break;
         case 10:
            var9 = a.o(var1, var6);
            break;
         case 11:
            var8 = a.o(var1, var6);
            break;
         case 12:
            var2 = a.g(var1, var6);
            break;
         case 13:
            var7 = a.o(var1, var6);
            break;
         case 1000:
            var4 = a.g(var1, var6);
            break;
         default:
            a.b(var1, var6);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new a.a("Overread allowed size end=" + var5, var1);
      } else {
         return new AppContentCardEntity(var4, var17, var16, var15, var14, var3, var13, var12, var11, var10, var9, var8, var2, var7);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.cp(var1);
   }

   public AppContentCardEntity[] dK(int var1) {
      return new AppContentCardEntity[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.dK(var1);
   }
}
