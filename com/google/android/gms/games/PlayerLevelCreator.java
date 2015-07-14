package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.PlayerLevel;

public class PlayerLevelCreator implements Creator {
   public static final int CONTENT_DESCRIPTION = 0;

   static void a(PlayerLevel var0, Parcel var1, int var2) {
      var2 = b.H(var1);
      b.c(var1, 1, var0.getLevelNumber());
      b.c(var1, 1000, var0.getVersionCode());
      b.a(var1, 2, var0.getMinXp());
      b.a(var1, 3, var0.getMaxXp());
      b.H(var1, var2);
   }

   public PlayerLevel createFromParcel(Parcel var1) {
      long var6 = 0L;
      int var2 = 0;
      int var4 = a.G(var1);
      long var8 = 0L;
      int var3 = 0;

      while(var1.dataPosition() < var4) {
         int var5 = a.F(var1);
         switch(a.aH(var5)) {
         case 1:
            var2 = a.g(var1, var5);
            break;
         case 2:
            var8 = a.i(var1, var5);
            break;
         case 3:
            var6 = a.i(var1, var5);
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
         return new PlayerLevel(var3, var2, var8, var6);
      }
   }

   public PlayerLevel[] newArray(int var1) {
      return new PlayerLevel[var1];
   }
}
