package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public class InvitationEntityCreator implements Creator {
   static void a(InvitationEntity var0, Parcel var1, int var2) {
      int var3 = b.H(var1);
      b.a(var1, 1, (Parcelable)var0.getGame(), var2, false);
      b.c(var1, 1000, var0.getVersionCode());
      b.a(var1, 2, (String)var0.getInvitationId(), false);
      b.a(var1, 3, var0.getCreationTimestamp());
      b.c(var1, 4, var0.getInvitationType());
      b.a(var1, 5, (Parcelable)var0.getInviter(), var2, false);
      b.c(var1, 6, var0.getParticipants(), false);
      b.c(var1, 7, var0.getVariant());
      b.c(var1, 8, var0.getAvailableAutoMatchSlots());
      b.H(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.cz(var1);
   }

   public InvitationEntity cz(Parcel var1) {
      ArrayList var10 = null;
      int var2 = 0;
      int var6 = a.G(var1);
      long var8 = 0L;
      int var3 = 0;
      ParticipantEntity var11 = null;
      int var4 = 0;
      String var12 = null;
      GameEntity var13 = null;
      int var5 = 0;

      while(var1.dataPosition() < var6) {
         int var7 = a.F(var1);
         switch(a.aH(var7)) {
         case 1:
            var13 = (GameEntity)a.a(var1, var7, GameEntity.CREATOR);
            break;
         case 2:
            var12 = a.o(var1, var7);
            break;
         case 3:
            var8 = a.i(var1, var7);
            break;
         case 4:
            var4 = a.g(var1, var7);
            break;
         case 5:
            var11 = (ParticipantEntity)a.a(var1, var7, ParticipantEntity.CREATOR);
            break;
         case 6:
            var10 = a.c(var1, var7, ParticipantEntity.CREATOR);
            break;
         case 7:
            var3 = a.g(var1, var7);
            break;
         case 8:
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
         return new InvitationEntity(var5, var13, var12, var8, var4, var11, var10, var3, var2);
      }
   }

   public InvitationEntity[] el(int var1) {
      return new InvitationEntity[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.el(var1);
   }
}
