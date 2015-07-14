package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;

public class SnapshotMetadataChangeCreator implements Creator {
   static void a(SnapshotMetadataChangeEntity var0, Parcel var1, int var2) {
      int var3 = b.H(var1);
      b.a(var1, 1, (String)var0.getDescription(), false);
      b.c(var1, 1000, var0.getVersionCode());
      b.a(var1, 2, (Long)var0.getPlayedTimeMillis(), false);
      b.a(var1, 4, (Parcelable)var0.getCoverImageUri(), var2, false);
      b.a(var1, 5, (Parcelable)var0.mT(), var2, false);
      b.H(var1, var3);
   }

   public SnapshotMetadataChangeEntity cE(Parcel var1) {
      Uri var5 = null;
      int var3 = a.G(var1);
      int var2 = 0;
      com.google.android.gms.common.data.a var6 = null;
      Long var7 = null;
      String var8 = null;

      while(var1.dataPosition() < var3) {
         int var4 = a.F(var1);
         switch(a.aH(var4)) {
         case 1:
            var8 = a.o(var1, var4);
            break;
         case 2:
            var7 = a.j(var1, var4);
            break;
         case 4:
            var5 = (Uri)a.a(var1, var4, Uri.CREATOR);
            break;
         case 5:
            var6 = (com.google.android.gms.common.data.a)a.a(var1, var4, com.google.android.gms.common.data.a.CREATOR);
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
         return new SnapshotMetadataChangeEntity(var2, var8, var7, var6, var5);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.cE(var1);
   }

   public SnapshotMetadataChangeEntity[] er(int var1) {
      return new SnapshotMetadataChangeEntity[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.er(var1);
   }
}
