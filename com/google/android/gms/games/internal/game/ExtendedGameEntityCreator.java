package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.game.ExtendedGameEntity;
import com.google.android.gms.games.internal.game.GameBadgeEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import java.util.ArrayList;

public class ExtendedGameEntityCreator implements Creator {
   static void a(ExtendedGameEntity var0, Parcel var1, int var2) {
      int var3 = b.H(var1);
      b.a(var1, 1, (Parcelable)var0.mi(), var2, false);
      b.c(var1, 1000, var0.getVersionCode());
      b.c(var1, 2, var0.lZ());
      b.a(var1, 3, var0.ma());
      b.c(var1, 4, var0.mb());
      b.a(var1, 5, var0.mc());
      b.a(var1, 6, var0.md());
      b.a(var1, 7, (String)var0.me(), false);
      b.a(var1, 8, var0.mf());
      b.a(var1, 9, (String)var0.mg(), false);
      b.c(var1, 10, var0.lY(), false);
      b.a(var1, 11, (Parcelable)var0.mh(), var2, false);
      b.H(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.cu(var1);
   }

   public ExtendedGameEntity cu(Parcel var1) {
      int var5 = a.G(var1);
      int var4 = 0;
      GameEntity var18 = null;
      int var3 = 0;
      boolean var7 = false;
      int var2 = 0;
      long var12 = 0L;
      long var10 = 0L;
      String var17 = null;
      long var8 = 0L;
      String var16 = null;
      ArrayList var15 = null;
      SnapshotMetadataEntity var14 = null;

      while(var1.dataPosition() < var5) {
         int var6 = a.F(var1);
         switch(a.aH(var6)) {
         case 1:
            var18 = (GameEntity)a.a(var1, var6, GameEntity.CREATOR);
            break;
         case 2:
            var3 = a.g(var1, var6);
            break;
         case 3:
            var7 = a.c(var1, var6);
            break;
         case 4:
            var2 = a.g(var1, var6);
            break;
         case 5:
            var12 = a.i(var1, var6);
            break;
         case 6:
            var10 = a.i(var1, var6);
            break;
         case 7:
            var17 = a.o(var1, var6);
            break;
         case 8:
            var8 = a.i(var1, var6);
            break;
         case 9:
            var16 = a.o(var1, var6);
            break;
         case 10:
            var15 = a.c(var1, var6, GameBadgeEntity.CREATOR);
            break;
         case 11:
            var14 = (SnapshotMetadataEntity)a.a(var1, var6, SnapshotMetadataEntity.CREATOR);
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
         return new ExtendedGameEntity(var4, var18, var3, var7, var2, var12, var10, var17, var8, var16, var15, var14);
      }
   }

   public ExtendedGameEntity[] eb(int var1) {
      return new ExtendedGameEntity[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.eb(var1);
   }
}
