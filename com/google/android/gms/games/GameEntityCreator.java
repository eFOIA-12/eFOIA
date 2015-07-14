package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.GameEntity;

public class GameEntityCreator implements Creator {
   static void a(GameEntity var0, Parcel var1, int var2) {
      int var3 = b.H(var1);
      b.a(var1, 1, (String)var0.getApplicationId(), false);
      b.a(var1, 2, (String)var0.getDisplayName(), false);
      b.a(var1, 3, (String)var0.getPrimaryCategory(), false);
      b.a(var1, 4, (String)var0.getSecondaryCategory(), false);
      b.a(var1, 5, (String)var0.getDescription(), false);
      b.a(var1, 6, (String)var0.getDeveloperName(), false);
      b.a(var1, 7, (Parcelable)var0.getIconImageUri(), var2, false);
      b.a(var1, 8, (Parcelable)var0.getHiResImageUri(), var2, false);
      b.a(var1, 9, (Parcelable)var0.getFeaturedImageUri(), var2, false);
      b.a(var1, 10, var0.ky());
      b.a(var1, 11, var0.kA());
      b.a(var1, 12, (String)var0.kB(), false);
      b.c(var1, 13, var0.kC());
      b.c(var1, 14, var0.getAchievementTotalCount());
      b.c(var1, 15, var0.getLeaderboardCount());
      b.a(var1, 17, var0.isTurnBasedMultiplayerEnabled());
      b.a(var1, 16, var0.isRealTimeMultiplayerEnabled());
      b.c(var1, 1000, var0.getVersionCode());
      b.a(var1, 19, (String)var0.getHiResImageUrl(), false);
      b.a(var1, 18, (String)var0.getIconImageUrl(), false);
      b.a(var1, 21, var0.isMuted());
      b.a(var1, 20, (String)var0.getFeaturedImageUrl(), false);
      b.a(var1, 23, var0.areSnapshotsEnabled());
      b.a(var1, 22, var0.kz());
      b.a(var1, 24, (String)var0.getThemeColor(), false);
      b.H(var1, var3);
   }

   public GameEntity cl(Parcel var1) {
      int var6 = a.G(var1);
      int var5 = 0;
      String var28 = null;
      String var27 = null;
      String var26 = null;
      String var25 = null;
      String var24 = null;
      String var23 = null;
      Uri var22 = null;
      Uri var21 = null;
      Uri var20 = null;
      boolean var14 = false;
      boolean var13 = false;
      String var19 = null;
      int var4 = 0;
      int var3 = 0;
      int var2 = 0;
      boolean var12 = false;
      boolean var11 = false;
      String var18 = null;
      String var17 = null;
      String var16 = null;
      boolean var10 = false;
      boolean var9 = false;
      boolean var8 = false;
      String var15 = null;

      while(var1.dataPosition() < var6) {
         int var7 = a.F(var1);
         switch(a.aH(var7)) {
         case 1:
            var28 = a.o(var1, var7);
            break;
         case 2:
            var27 = a.o(var1, var7);
            break;
         case 3:
            var26 = a.o(var1, var7);
            break;
         case 4:
            var25 = a.o(var1, var7);
            break;
         case 5:
            var24 = a.o(var1, var7);
            break;
         case 6:
            var23 = a.o(var1, var7);
            break;
         case 7:
            var22 = (Uri)a.a(var1, var7, Uri.CREATOR);
            break;
         case 8:
            var21 = (Uri)a.a(var1, var7, Uri.CREATOR);
            break;
         case 9:
            var20 = (Uri)a.a(var1, var7, Uri.CREATOR);
            break;
         case 10:
            var14 = a.c(var1, var7);
            break;
         case 11:
            var13 = a.c(var1, var7);
            break;
         case 12:
            var19 = a.o(var1, var7);
            break;
         case 13:
            var4 = a.g(var1, var7);
            break;
         case 14:
            var3 = a.g(var1, var7);
            break;
         case 15:
            var2 = a.g(var1, var7);
            break;
         case 16:
            var12 = a.c(var1, var7);
            break;
         case 17:
            var11 = a.c(var1, var7);
            break;
         case 18:
            var18 = a.o(var1, var7);
            break;
         case 19:
            var17 = a.o(var1, var7);
            break;
         case 20:
            var16 = a.o(var1, var7);
            break;
         case 21:
            var10 = a.c(var1, var7);
            break;
         case 22:
            var9 = a.c(var1, var7);
            break;
         case 23:
            var8 = a.c(var1, var7);
            break;
         case 24:
            var15 = a.o(var1, var7);
            break;
         case 1000:
            var5 = a.g(var1, var7);
            break;
         default:
            a.b(var1, var7);
         }
      }

      if(var1.dataPosition() != var6) {
         throw new a.a("Overread allowed size end=" + var6, var1);
      } else {
         return new GameEntity(var5, var28, var27, var26, var25, var24, var23, var22, var21, var20, var14, var13, var19, var4, var3, var2, var12, var11, var18, var17, var16, var10, var9, var8, var15);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.cl(var1);
   }

   public GameEntity[] dG(int var1) {
      return new GameEntity[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.dG(var1);
   }
}
