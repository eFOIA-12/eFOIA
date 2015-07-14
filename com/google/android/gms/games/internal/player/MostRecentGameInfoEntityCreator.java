package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

public class MostRecentGameInfoEntityCreator implements Creator {
   static void a(MostRecentGameInfoEntity var0, Parcel var1, int var2) {
      int var3 = b.H(var1);
      b.a(var1, 1, (String)var0.mw(), false);
      b.c(var1, 1000, var0.getVersionCode());
      b.a(var1, 2, (String)var0.mx(), false);
      b.a(var1, 3, var0.my());
      b.a(var1, 4, (Parcelable)var0.mz(), var2, false);
      b.a(var1, 5, (Parcelable)var0.mA(), var2, false);
      b.a(var1, 6, (Parcelable)var0.mB(), var2, false);
      b.H(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.cx(var1);
   }

   public MostRecentGameInfoEntity cx(Parcel var1) {
      Uri var7 = null;
      int var3 = a.G(var1);
      int var2 = 0;
      long var5 = 0L;
      Uri var8 = null;
      Uri var9 = null;
      String var10 = null;
      String var11 = null;

      while(var1.dataPosition() < var3) {
         int var4 = a.F(var1);
         switch(a.aH(var4)) {
         case 1:
            var11 = a.o(var1, var4);
            break;
         case 2:
            var10 = a.o(var1, var4);
            break;
         case 3:
            var5 = a.i(var1, var4);
            break;
         case 4:
            var9 = (Uri)a.a(var1, var4, Uri.CREATOR);
            break;
         case 5:
            var8 = (Uri)a.a(var1, var4, Uri.CREATOR);
            break;
         case 6:
            var7 = (Uri)a.a(var1, var4, Uri.CREATOR);
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
         return new MostRecentGameInfoEntity(var2, var11, var10, var5, var9, var8, var7);
      }
   }

   public MostRecentGameInfoEntity[] ei(int var1) {
      return new MostRecentGameInfoEntity[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.ei(var1);
   }
}
