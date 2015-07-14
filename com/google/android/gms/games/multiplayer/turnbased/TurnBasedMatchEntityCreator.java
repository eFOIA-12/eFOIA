package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchEntity;
import java.util.ArrayList;

public class TurnBasedMatchEntityCreator implements Creator {
   public static final int CONTENT_DESCRIPTION = 0;

   static void a(TurnBasedMatchEntity var0, Parcel var1, int var2) {
      int var3 = b.H(var1);
      b.a(var1, 1, (Parcelable)var0.getGame(), var2, false);
      b.a(var1, 2, (String)var0.getMatchId(), false);
      b.a(var1, 3, (String)var0.getCreatorId(), false);
      b.a(var1, 4, var0.getCreationTimestamp());
      b.a(var1, 5, (String)var0.getLastUpdaterId(), false);
      b.a(var1, 6, var0.getLastUpdatedTimestamp());
      b.a(var1, 7, (String)var0.getPendingParticipantId(), false);
      b.c(var1, 8, var0.getStatus());
      b.c(var1, 10, var0.getVariant());
      b.c(var1, 11, var0.getVersion());
      b.a(var1, 12, (byte[])var0.getData(), false);
      b.c(var1, 13, var0.getParticipants(), false);
      b.a(var1, 14, (String)var0.getRematchId(), false);
      b.a(var1, 15, (byte[])var0.getPreviousMatchData(), false);
      b.a(var1, 17, (Bundle)var0.getAutoMatchCriteria(), false);
      b.c(var1, 16, var0.getMatchNumber());
      b.c(var1, 1000, var0.getVersionCode());
      b.a(var1, 19, var0.isLocallyModified());
      b.c(var1, 18, var0.getTurnStatus());
      b.a(var1, 21, (String)var0.getDescriptionParticipantId(), false);
      b.a(var1, 20, (String)var0.getDescription(), false);
      b.H(var1, var3);
   }

   public TurnBasedMatchEntity createFromParcel(Parcel var1) {
      int var8 = a.G(var1);
      int var7 = 0;
      GameEntity var26 = null;
      String var25 = null;
      String var24 = null;
      long var12 = 0L;
      String var23 = null;
      long var10 = 0L;
      String var22 = null;
      int var6 = 0;
      int var5 = 0;
      int var4 = 0;
      byte[] var21 = null;
      ArrayList var20 = null;
      String var19 = null;
      byte[] var18 = null;
      int var3 = 0;
      Bundle var17 = null;
      int var2 = 0;
      boolean var14 = false;
      String var16 = null;
      String var15 = null;

      while(var1.dataPosition() < var8) {
         int var9 = a.F(var1);
         switch(a.aH(var9)) {
         case 1:
            var26 = (GameEntity)a.a(var1, var9, GameEntity.CREATOR);
            break;
         case 2:
            var25 = a.o(var1, var9);
            break;
         case 3:
            var24 = a.o(var1, var9);
            break;
         case 4:
            var12 = a.i(var1, var9);
            break;
         case 5:
            var23 = a.o(var1, var9);
            break;
         case 6:
            var10 = a.i(var1, var9);
            break;
         case 7:
            var22 = a.o(var1, var9);
            break;
         case 8:
            var6 = a.g(var1, var9);
            break;
         case 10:
            var5 = a.g(var1, var9);
            break;
         case 11:
            var4 = a.g(var1, var9);
            break;
         case 12:
            var21 = a.r(var1, var9);
            break;
         case 13:
            var20 = a.c(var1, var9, ParticipantEntity.CREATOR);
            break;
         case 14:
            var19 = a.o(var1, var9);
            break;
         case 15:
            var18 = a.r(var1, var9);
            break;
         case 16:
            var3 = a.g(var1, var9);
            break;
         case 17:
            var17 = a.q(var1, var9);
            break;
         case 18:
            var2 = a.g(var1, var9);
            break;
         case 19:
            var14 = a.c(var1, var9);
            break;
         case 20:
            var16 = a.o(var1, var9);
            break;
         case 21:
            var15 = a.o(var1, var9);
            break;
         case 1000:
            var7 = a.g(var1, var9);
            break;
         default:
            a.b(var1, var9);
         }
      }

      if(var1.dataPosition() != var8) {
         throw new a.a("Overread allowed size end=" + var8, var1);
      } else {
         return new TurnBasedMatchEntity(var7, var26, var25, var24, var12, var23, var10, var22, var6, var5, var4, var21, var20, var19, var18, var3, var17, var2, var14, var16, var15);
      }
   }

   public TurnBasedMatchEntity[] newArray(int var1) {
      return new TurnBasedMatchEntity[var1];
   }
}
