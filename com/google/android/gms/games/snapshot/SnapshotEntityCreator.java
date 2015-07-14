package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;

public class SnapshotEntityCreator implements Creator {
   public static final int CONTENT_DESCRIPTION = 0;

   static void a(SnapshotEntity var0, Parcel var1, int var2) {
      int var3 = b.H(var1);
      b.a(var1, 1, (Parcelable)var0.getMetadata(), var2, false);
      b.c(var1, 1000, var0.getVersionCode());
      b.a(var1, 3, (Parcelable)var0.getSnapshotContents(), var2, false);
      b.H(var1, var3);
   }

   public SnapshotEntity createFromParcel(Parcel var1) {
      SnapshotContentsEntity var5 = null;
      int var3 = a.G(var1);
      int var2 = 0;
      SnapshotMetadataEntity var6 = null;

      while(var1.dataPosition() < var3) {
         int var4 = a.F(var1);
         switch(a.aH(var4)) {
         case 1:
            var6 = (SnapshotMetadataEntity)a.a(var1, var4, SnapshotMetadataEntity.CREATOR);
            break;
         case 3:
            var5 = (SnapshotContentsEntity)a.a(var1, var4, SnapshotContentsEntity.CREATOR);
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
         return new SnapshotEntity(var2, var6, var5);
      }
   }

   public SnapshotEntity[] newArray(int var1) {
      return new SnapshotEntity[var1];
   }
}
