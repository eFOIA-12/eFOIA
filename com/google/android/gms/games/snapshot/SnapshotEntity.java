package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntityCreator;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.internal.jv;

public final class SnapshotEntity implements SafeParcelable, Snapshot {
   public static final SnapshotEntityCreator CREATOR = new SnapshotEntityCreator();
   private final int CK;
   private final SnapshotMetadataEntity aeZ;
   private final SnapshotContentsEntity afa;

   SnapshotEntity(int var1, SnapshotMetadata var2, SnapshotContentsEntity var3) {
      this.CK = var1;
      this.aeZ = new SnapshotMetadataEntity(var2);
      this.afa = var3;
   }

   public SnapshotEntity(SnapshotMetadata var1, SnapshotContentsEntity var2) {
      this(2, var1, var2);
   }

   static boolean a(Snapshot var0, Object var1) {
      boolean var3 = true;
      boolean var2;
      if(!(var1 instanceof Snapshot)) {
         var2 = false;
      } else {
         var2 = var3;
         if(var0 != var1) {
            Snapshot var4 = (Snapshot)var1;
            if(jv.equal(var4.getMetadata(), var0.getMetadata())) {
               var2 = var3;
               if(jv.equal(var4.getSnapshotContents(), var0.getSnapshotContents())) {
                  return var2;
               }
            }

            return false;
         }
      }

      return var2;
   }

   static int b(Snapshot var0) {
      return jv.hashCode(new Object[]{var0.getMetadata(), var0.getSnapshotContents()});
   }

   static String c(Snapshot var0) {
      jv.a var2 = jv.h(var0).a("Metadata", var0.getMetadata());
      boolean var1;
      if(var0.getSnapshotContents() != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var2.a("HasContents", Boolean.valueOf(var1)).toString();
   }

   private boolean isClosed() {
      return this.afa.isClosed();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return a(this, var1);
   }

   public Snapshot freeze() {
      return this;
   }

   public SnapshotMetadata getMetadata() {
      return this.aeZ;
   }

   public SnapshotContents getSnapshotContents() {
      return this.isClosed()?null:this.afa;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return b(this);
   }

   public boolean isDataValid() {
      return true;
   }

   public String toString() {
      return c(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      SnapshotEntityCreator.a(this, var1, var2);
   }
}
