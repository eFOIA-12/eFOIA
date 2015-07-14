package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;

public class GameRequestEntityCreator implements Creator {
   public static final int CONTENT_DESCRIPTION = 0;

   static void a(GameRequestEntity var0, Parcel var1, int var2) {
      int var3 = b.H(var1);
      b.a(var1, 1, (Parcelable)var0.getGame(), var2, false);
      b.c(var1, 1000, var0.getVersionCode());
      b.a(var1, 2, (Parcelable)var0.getSender(), var2, false);
      b.a(var1, 3, (byte[])var0.getData(), false);
      b.a(var1, 4, (String)var0.getRequestId(), false);
      b.c(var1, 5, var0.getRecipients(), false);
      b.c(var1, 7, var0.getType());
      b.a(var1, 9, var0.getCreationTimestamp());
      b.a(var1, 10, var0.getExpirationTimestamp());
      b.a(var1, 11, (Bundle)var0.mS(), false);
      b.c(var1, 12, var0.getStatus());
      b.H(var1, var3);
   }

   public GameRequestEntity createFromParcel(Parcel var1) {
      int var5 = a.G(var1);
      int var4 = 0;
      GameEntity var16 = null;
      PlayerEntity var15 = null;
      byte[] var14 = null;
      String var13 = null;
      ArrayList var12 = null;
      int var3 = 0;
      long var9 = 0L;
      long var7 = 0L;
      Bundle var11 = null;
      int var2 = 0;

      while(var1.dataPosition() < var5) {
         int var6 = a.F(var1);
         switch(a.aH(var6)) {
         case 1:
            var16 = (GameEntity)a.a(var1, var6, GameEntity.CREATOR);
            break;
         case 2:
            var15 = (PlayerEntity)a.a(var1, var6, PlayerEntity.CREATOR);
            break;
         case 3:
            var14 = a.r(var1, var6);
            break;
         case 4:
            var13 = a.o(var1, var6);
            break;
         case 5:
            var12 = a.c(var1, var6, PlayerEntity.CREATOR);
            break;
         case 7:
            var3 = a.g(var1, var6);
            break;
         case 9:
            var9 = a.i(var1, var6);
            break;
         case 10:
            var7 = a.i(var1, var6);
            break;
         case 11:
            var11 = a.q(var1, var6);
            break;
         case 12:
            var2 = a.g(var1, var6);
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
         return new GameRequestEntity(var4, var16, var15, var14, var13, var12, var3, var9, var7, var11, var2);
      }
   }

   public GameRequestEntity[] newArray(int var1) {
      return new GameRequestEntity[var1];
   }
}
