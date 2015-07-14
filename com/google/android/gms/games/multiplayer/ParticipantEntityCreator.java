package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;

public class ParticipantEntityCreator implements Creator {
   static void a(ParticipantEntity var0, Parcel var1, int var2) {
      int var3 = b.H(var1);
      b.a(var1, 1, (String)var0.getParticipantId(), false);
      b.c(var1, 1000, var0.getVersionCode());
      b.a(var1, 2, (String)var0.getDisplayName(), false);
      b.a(var1, 3, (Parcelable)var0.getIconImageUri(), var2, false);
      b.a(var1, 4, (Parcelable)var0.getHiResImageUri(), var2, false);
      b.c(var1, 5, var0.getStatus());
      b.a(var1, 6, (String)var0.le(), false);
      b.a(var1, 7, var0.isConnectedToRoom());
      b.a(var1, 8, (Parcelable)var0.getPlayer(), var2, false);
      b.c(var1, 9, var0.getCapabilities());
      b.a(var1, 10, (Parcelable)var0.getResult(), var2, false);
      b.a(var1, 11, (String)var0.getIconImageUrl(), false);
      b.a(var1, 12, (String)var0.getHiResImageUrl(), false);
      b.H(var1, var3);
   }

   public ParticipantEntity cA(Parcel var1) {
      int var5 = a.G(var1);
      int var4 = 0;
      String var16 = null;
      String var15 = null;
      Uri var14 = null;
      Uri var13 = null;
      int var3 = 0;
      String var12 = null;
      boolean var7 = false;
      PlayerEntity var11 = null;
      int var2 = 0;
      ParticipantResult var10 = null;
      String var9 = null;
      String var8 = null;

      while(var1.dataPosition() < var5) {
         int var6 = a.F(var1);
         switch(a.aH(var6)) {
         case 1:
            var16 = a.o(var1, var6);
            break;
         case 2:
            var15 = a.o(var1, var6);
            break;
         case 3:
            var14 = (Uri)a.a(var1, var6, Uri.CREATOR);
            break;
         case 4:
            var13 = (Uri)a.a(var1, var6, Uri.CREATOR);
            break;
         case 5:
            var3 = a.g(var1, var6);
            break;
         case 6:
            var12 = a.o(var1, var6);
            break;
         case 7:
            var7 = a.c(var1, var6);
            break;
         case 8:
            var11 = (PlayerEntity)a.a(var1, var6, PlayerEntity.CREATOR);
            break;
         case 9:
            var2 = a.g(var1, var6);
            break;
         case 10:
            var10 = (ParticipantResult)a.a(var1, var6, ParticipantResult.CREATOR);
            break;
         case 11:
            var9 = a.o(var1, var6);
            break;
         case 12:
            var8 = a.o(var1, var6);
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
         return new ParticipantEntity(var4, var16, var15, var14, var13, var3, var12, var7, var11, var2, var10, var9, var8);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.cA(var1);
   }

   public ParticipantEntity[] em(int var1) {
      return new ParticipantEntity[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.em(var1);
   }
}
