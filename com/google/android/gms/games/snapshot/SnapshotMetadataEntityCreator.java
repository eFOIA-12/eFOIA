package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;

public class SnapshotMetadataEntityCreator implements Creator {
   public static final int CONTENT_DESCRIPTION = 0;

   static void a(SnapshotMetadataEntity var0, Parcel var1, int var2) {
      int var3 = b.H(var1);
      b.a(var1, 1, (Parcelable)var0.getGame(), var2, false);
      b.c(var1, 1000, var0.getVersionCode());
      b.a(var1, 2, (Parcelable)var0.getOwner(), var2, false);
      b.a(var1, 3, (String)var0.getSnapshotId(), false);
      b.a(var1, 5, (Parcelable)var0.getCoverImageUri(), var2, false);
      b.a(var1, 6, (String)var0.getCoverImageUrl(), false);
      b.a(var1, 7, (String)var0.getTitle(), false);
      b.a(var1, 8, (String)var0.getDescription(), false);
      b.a(var1, 9, var0.getLastModifiedTimestamp());
      b.a(var1, 10, var0.getPlayedTime());
      b.a(var1, 11, var0.getCoverImageAspectRatio());
      b.a(var1, 12, (String)var0.getUniqueName(), false);
      b.a(var1, 13, var0.hasChangePending());
      b.H(var1, var3);
   }

   public SnapshotMetadataEntity createFromParcel(Parcel var1) {
      int var4 = a.G(var1);
      int var3 = 0;
      GameEntity var18 = null;
      PlayerEntity var17 = null;
      String var16 = null;
      Uri var15 = null;
      String var14 = null;
      String var13 = null;
      String var12 = null;
      long var8 = 0L;
      long var6 = 0L;
      float var2 = 0.0F;
      String var11 = null;
      boolean var10 = false;

      while(var1.dataPosition() < var4) {
         int var5 = a.F(var1);
         switch(a.aH(var5)) {
         case 1:
            var18 = (GameEntity)a.a(var1, var5, GameEntity.CREATOR);
            break;
         case 2:
            var17 = (PlayerEntity)a.a(var1, var5, PlayerEntity.CREATOR);
            break;
         case 3:
            var16 = a.o(var1, var5);
            break;
         case 5:
            var15 = (Uri)a.a(var1, var5, Uri.CREATOR);
            break;
         case 6:
            var14 = a.o(var1, var5);
            break;
         case 7:
            var13 = a.o(var1, var5);
            break;
         case 8:
            var12 = a.o(var1, var5);
            break;
         case 9:
            var8 = a.i(var1, var5);
            break;
         case 10:
            var6 = a.i(var1, var5);
            break;
         case 11:
            var2 = a.l(var1, var5);
            break;
         case 12:
            var11 = a.o(var1, var5);
            break;
         case 13:
            var10 = a.c(var1, var5);
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
         return new SnapshotMetadataEntity(var3, var18, var17, var16, var15, var14, var13, var12, var8, var6, var2, var11, var10);
      }
   }

   public SnapshotMetadataEntity[] newArray(int var1) {
      return new SnapshotMetadataEntity[var1];
   }
}
