package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.multiplayer.ParticipantResult;

public class ParticipantResultCreator implements Creator {
   public static final int CONTENT_DESCRIPTION = 0;

   static void a(ParticipantResult var0, Parcel var1, int var2) {
      var2 = b.H(var1);
      b.a(var1, 1, (String)var0.getParticipantId(), false);
      b.c(var1, 1000, var0.getVersionCode());
      b.c(var1, 2, var0.getResult());
      b.c(var1, 3, var0.getPlacing());
      b.H(var1, var2);
   }

   public ParticipantResult createFromParcel(Parcel var1) {
      int var4 = 0;
      int var5 = a.G(var1);
      String var7 = null;
      int var3 = 0;
      int var2 = 0;

      while(var1.dataPosition() < var5) {
         int var6 = a.F(var1);
         switch(a.aH(var6)) {
         case 1:
            var7 = a.o(var1, var6);
            break;
         case 2:
            var3 = a.g(var1, var6);
            break;
         case 3:
            var4 = a.g(var1, var6);
            break;
         case 1000:
            var2 = a.g(var1, var6);
            break;
         default:
            a.b(var1, var6);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new a.a("Overread allowed size end=" + var5, var1);
      } else {
         return new ParticipantResult(var2, var7, var3, var4);
      }
   }

   public ParticipantResult[] newArray(int var1) {
      return new ParticipantResult[var1];
   }
}
