package com.google.android.gms.games.achievement;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.achievement.AchievementEntity;

public class AchievementEntityCreator implements Creator {
   public static final int CONTENT_DESCRIPTION = 0;

   static void a(AchievementEntity var0, Parcel var1, int var2) {
      int var3 = b.H(var1);
      b.a(var1, 1, (String)var0.getAchievementId(), false);
      b.c(var1, 2, var0.getType());
      b.a(var1, 3, (String)var0.getName(), false);
      b.a(var1, 4, (String)var0.getDescription(), false);
      b.a(var1, 5, (Parcelable)var0.getUnlockedImageUri(), var2, false);
      b.a(var1, 6, (String)var0.getUnlockedImageUrl(), false);
      b.a(var1, 7, (Parcelable)var0.getRevealedImageUri(), var2, false);
      b.a(var1, 8, (String)var0.getRevealedImageUrl(), false);
      b.c(var1, 9, var0.getTotalSteps());
      b.a(var1, 10, (String)var0.getFormattedTotalSteps(), false);
      b.a(var1, 11, (Parcelable)var0.getPlayer(), var2, false);
      b.c(var1, 12, var0.getState());
      b.c(var1, 13, var0.getCurrentSteps());
      b.a(var1, 14, (String)var0.getFormattedCurrentSteps(), false);
      b.a(var1, 15, var0.getLastUpdatedTimestamp());
      b.a(var1, 16, var0.getXpValue());
      b.c(var1, 1000, var0.getVersionCode());
      b.H(var1, var3);
   }

   public AchievementEntity createFromParcel(Parcel var1) {
      int var7 = a.G(var1);
      int var6 = 0;
      String var22 = null;
      int var5 = 0;
      String var21 = null;
      String var20 = null;
      Uri var19 = null;
      String var18 = null;
      Uri var17 = null;
      String var16 = null;
      int var4 = 0;
      String var15 = null;
      PlayerEntity var14 = null;
      int var3 = 0;
      int var2 = 0;
      String var13 = null;
      long var11 = 0L;
      long var9 = 0L;

      while(var1.dataPosition() < var7) {
         int var8 = a.F(var1);
         switch(a.aH(var8)) {
         case 1:
            var22 = a.o(var1, var8);
            break;
         case 2:
            var5 = a.g(var1, var8);
            break;
         case 3:
            var21 = a.o(var1, var8);
            break;
         case 4:
            var20 = a.o(var1, var8);
            break;
         case 5:
            var19 = (Uri)a.a(var1, var8, Uri.CREATOR);
            break;
         case 6:
            var18 = a.o(var1, var8);
            break;
         case 7:
            var17 = (Uri)a.a(var1, var8, Uri.CREATOR);
            break;
         case 8:
            var16 = a.o(var1, var8);
            break;
         case 9:
            var4 = a.g(var1, var8);
            break;
         case 10:
            var15 = a.o(var1, var8);
            break;
         case 11:
            var14 = (PlayerEntity)a.a(var1, var8, PlayerEntity.CREATOR);
            break;
         case 12:
            var3 = a.g(var1, var8);
            break;
         case 13:
            var2 = a.g(var1, var8);
            break;
         case 14:
            var13 = a.o(var1, var8);
            break;
         case 15:
            var11 = a.i(var1, var8);
            break;
         case 16:
            var9 = a.i(var1, var8);
            break;
         case 1000:
            var6 = a.g(var1, var8);
            break;
         default:
            a.b(var1, var8);
         }
      }

      if(var1.dataPosition() != var7) {
         throw new a.a("Overread allowed size end=" + var7, var1);
      } else {
         return new AchievementEntity(var6, var22, var5, var21, var20, var19, var18, var17, var16, var4, var15, var14, var3, var2, var13, var11, var9);
      }
   }

   public AchievementEntity[] newArray(int var1) {
      return new AchievementEntity[var1];
   }
}
