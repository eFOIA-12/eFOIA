package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.PlayerLevel;
import com.google.android.gms.games.PlayerLevelInfo;

public class PlayerLevelInfoCreator implements Creator {
   public static final int CONTENT_DESCRIPTION = 0;

   static void a(PlayerLevelInfo var0, Parcel var1, int var2) {
      int var3 = b.H(var1);
      b.a(var1, 1, var0.getCurrentXpTotal());
      b.c(var1, 1000, var0.getVersionCode());
      b.a(var1, 2, var0.getLastLevelUpTimestamp());
      b.a(var1, 3, (Parcelable)var0.getCurrentLevel(), var2, false);
      b.a(var1, 4, (Parcelable)var0.getNextLevel(), var2, false);
      b.H(var1, var3);
   }

   public PlayerLevelInfo createFromParcel(Parcel var1) {
      long var5 = 0L;
      PlayerLevel var9 = null;
      int var3 = a.G(var1);
      int var2 = 0;
      PlayerLevel var10 = null;
      long var7 = 0L;

      while(var1.dataPosition() < var3) {
         int var4 = a.F(var1);
         switch(a.aH(var4)) {
         case 1:
            var7 = a.i(var1, var4);
            break;
         case 2:
            var5 = a.i(var1, var4);
            break;
         case 3:
            var10 = (PlayerLevel)a.a(var1, var4, PlayerLevel.CREATOR);
            break;
         case 4:
            var9 = (PlayerLevel)a.a(var1, var4, PlayerLevel.CREATOR);
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
         return new PlayerLevelInfo(var2, var7, var5, var10, var9);
      }
   }

   public PlayerLevelInfo[] newArray(int var1) {
      return new PlayerLevelInfo[var1];
   }
}
