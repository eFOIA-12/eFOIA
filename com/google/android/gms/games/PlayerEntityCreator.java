package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.PlayerLevelInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

public class PlayerEntityCreator implements Creator {
   static void a(PlayerEntity var0, Parcel var1, int var2) {
      int var3 = b.H(var1);
      b.a(var1, 1, (String)var0.getPlayerId(), false);
      b.a(var1, 2, (String)var0.getDisplayName(), false);
      b.a(var1, 3, (Parcelable)var0.getIconImageUri(), var2, false);
      b.a(var1, 4, (Parcelable)var0.getHiResImageUri(), var2, false);
      b.a(var1, 5, var0.getRetrievedTimestamp());
      b.c(var1, 6, var0.kE());
      b.a(var1, 7, var0.getLastPlayedWithTimestamp());
      b.a(var1, 8, (String)var0.getIconImageUrl(), false);
      b.a(var1, 9, (String)var0.getHiResImageUrl(), false);
      b.a(var1, 14, (String)var0.getTitle(), false);
      b.a(var1, 15, (Parcelable)var0.kF(), var2, false);
      b.a(var1, 16, (Parcelable)var0.getLevelInfo(), var2, false);
      b.c(var1, 1000, var0.getVersionCode());
      b.a(var1, 18, var0.isProfileVisible());
      b.H(var1, var3);
   }

   public PlayerEntity cm(Parcel var1) {
      int var4 = a.G(var1);
      int var3 = 0;
      String var19 = null;
      String var18 = null;
      Uri var17 = null;
      Uri var16 = null;
      long var8 = 0L;
      int var2 = 0;
      long var6 = 0L;
      String var15 = null;
      String var14 = null;
      String var13 = null;
      MostRecentGameInfoEntity var12 = null;
      PlayerLevelInfo var11 = null;
      boolean var10 = false;

      while(var1.dataPosition() < var4) {
         int var5 = a.F(var1);
         switch(a.aH(var5)) {
         case 1:
            var19 = a.o(var1, var5);
            break;
         case 2:
            var18 = a.o(var1, var5);
            break;
         case 3:
            var17 = (Uri)a.a(var1, var5, Uri.CREATOR);
            break;
         case 4:
            var16 = (Uri)a.a(var1, var5, Uri.CREATOR);
            break;
         case 5:
            var8 = a.i(var1, var5);
            break;
         case 6:
            var2 = a.g(var1, var5);
            break;
         case 7:
            var6 = a.i(var1, var5);
            break;
         case 8:
            var15 = a.o(var1, var5);
            break;
         case 9:
            var14 = a.o(var1, var5);
            break;
         case 14:
            var13 = a.o(var1, var5);
            break;
         case 15:
            var12 = (MostRecentGameInfoEntity)a.a(var1, var5, MostRecentGameInfoEntity.CREATOR);
            break;
         case 16:
            var11 = (PlayerLevelInfo)a.a(var1, var5, PlayerLevelInfo.CREATOR);
            break;
         case 18:
            var10 = a.c(var1, var5);
            break;
         case 1000:
            var3 = a.g(var1, var5);
            break;
         default:
            a.b(var1, var5);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new a.a("Overread allowed size end=" + var4, var1);
      } else {
         return new PlayerEntity(var3, var19, var18, var17, var16, var8, var2, var6, var15, var14, var13, var12, var11, var10);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.cm(var1);
   }

   public PlayerEntity[] dH(int var1) {
      return new PlayerEntity[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.dH(var1);
   }
}
