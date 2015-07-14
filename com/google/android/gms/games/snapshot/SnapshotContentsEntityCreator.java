package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;

public class SnapshotContentsEntityCreator implements Creator {
   static void a(SnapshotContentsEntity var0, Parcel var1, int var2) {
      int var3 = b.H(var1);
      b.a(var1, 1, (Parcelable)var0.ir(), var2, false);
      b.c(var1, 1000, var0.getVersionCode());
      b.H(var1, var3);
   }

   public SnapshotContentsEntity cD(Parcel var1) {
      int var3 = a.G(var1);
      int var2 = 0;
      Contents var5 = null;

      while(var1.dataPosition() < var3) {
         int var4 = a.F(var1);
         switch(a.aH(var4)) {
         case 1:
            var5 = (Contents)a.a(var1, var4, Contents.CREATOR);
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
         return new SnapshotContentsEntity(var2, var5);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.cD(var1);
   }

   public SnapshotContentsEntity[] eq(int var1) {
      return new SnapshotContentsEntity[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.eq(var1);
   }
}
