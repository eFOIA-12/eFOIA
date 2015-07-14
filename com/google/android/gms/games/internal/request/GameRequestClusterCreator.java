package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.internal.request.GameRequestCluster;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;

public class GameRequestClusterCreator implements Creator {
   static void a(GameRequestCluster var0, Parcel var1, int var2) {
      var2 = b.H(var1);
      b.c(var1, 1, var0.mD(), false);
      b.c(var1, 1000, var0.getVersionCode());
      b.H(var1, var2);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.cy(var1);
   }

   public GameRequestCluster cy(Parcel var1) {
      int var3 = a.G(var1);
      int var2 = 0;
      ArrayList var5 = null;

      while(var1.dataPosition() < var3) {
         int var4 = a.F(var1);
         switch(a.aH(var4)) {
         case 1:
            var5 = a.c(var1, var4, GameRequestEntity.CREATOR);
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
         return new GameRequestCluster(var2, var5);
      }
   }

   public GameRequestCluster[] ej(int var1) {
      return new GameRequestCluster[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.ej(var1);
   }
}
