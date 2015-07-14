package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import java.util.ArrayList;

public class RoomEntityCreator implements Creator {
   static void a(RoomEntity var0, Parcel var1, int var2) {
      var2 = b.H(var1);
      b.a(var1, 1, (String)var0.getRoomId(), false);
      b.c(var1, 1000, var0.getVersionCode());
      b.a(var1, 2, (String)var0.getCreatorId(), false);
      b.a(var1, 3, var0.getCreationTimestamp());
      b.c(var1, 4, var0.getStatus());
      b.a(var1, 5, (String)var0.getDescription(), false);
      b.c(var1, 6, var0.getVariant());
      b.a(var1, 7, (Bundle)var0.getAutoMatchCriteria(), false);
      b.c(var1, 8, var0.getParticipants(), false);
      b.c(var1, 9, var0.getAutoMatchWaitEstimateSeconds());
      b.H(var1, var2);
   }

   public RoomEntity cC(Parcel var1) {
      int var2 = 0;
      ArrayList var10 = null;
      int var6 = a.G(var1);
      long var8 = 0L;
      Bundle var11 = null;
      int var3 = 0;
      String var12 = null;
      int var4 = 0;
      String var13 = null;
      String var14 = null;
      int var5 = 0;

      while(var1.dataPosition() < var6) {
         int var7 = a.F(var1);
         switch(a.aH(var7)) {
         case 1:
            var14 = a.o(var1, var7);
            break;
         case 2:
            var13 = a.o(var1, var7);
            break;
         case 3:
            var8 = a.i(var1, var7);
            break;
         case 4:
            var4 = a.g(var1, var7);
            break;
         case 5:
            var12 = a.o(var1, var7);
            break;
         case 6:
            var3 = a.g(var1, var7);
            break;
         case 7:
            var11 = a.q(var1, var7);
            break;
         case 8:
            var10 = a.c(var1, var7, ParticipantEntity.CREATOR);
            break;
         case 9:
            var2 = a.g(var1, var7);
            break;
         case 1000:
            var5 = a.g(var1, var7);
            break;
         default:
            a.b(var1, var7);
         }
      }

      if(var1.dataPosition() != var6) {
         throw new a.a("Overread allowed size end=" + var6, var1);
      } else {
         return new RoomEntity(var5, var14, var13, var8, var4, var12, var3, var11, var10, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.cC(var1);
   }

   public RoomEntity[] eo(int var1) {
      return new RoomEntity[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.eo(var1);
   }
}
