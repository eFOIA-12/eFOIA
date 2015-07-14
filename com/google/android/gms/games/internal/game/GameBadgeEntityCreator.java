package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.internal.game.GameBadgeEntity;

public class GameBadgeEntityCreator implements Creator {
   static void a(GameBadgeEntity var0, Parcel var1, int var2) {
      int var3 = b.H(var1);
      b.c(var1, 1, var0.getType());
      b.c(var1, 1000, var0.getVersionCode());
      b.a(var1, 2, (String)var0.getTitle(), false);
      b.a(var1, 3, (String)var0.getDescription(), false);
      b.a(var1, 4, (Parcelable)var0.getIconImageUri(), var2, false);
      b.H(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.cv(var1);
   }

   public GameBadgeEntity cv(Parcel var1) {
      int var2 = 0;
      Uri var6 = null;
      int var4 = a.G(var1);
      String var7 = null;
      String var8 = null;
      int var3 = 0;

      while(var1.dataPosition() < var4) {
         int var5 = a.F(var1);
         switch(a.aH(var5)) {
         case 1:
            var2 = a.g(var1, var5);
            break;
         case 2:
            var8 = a.o(var1, var5);
            break;
         case 3:
            var7 = a.o(var1, var5);
            break;
         case 4:
            var6 = (Uri)a.a(var1, var5, Uri.CREATOR);
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
         return new GameBadgeEntity(var3, var2, var8, var7, var6);
      }
   }

   public GameBadgeEntity[] ed(int var1) {
      return new GameBadgeEntity[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.ed(var1);
   }
}
