package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntityCreator;
import com.google.android.gms.internal.jx;
import java.io.IOException;

public final class SnapshotContentsEntity implements SafeParcelable, SnapshotContents {
   public static final SnapshotContentsEntityCreator CREATOR = new SnapshotContentsEntityCreator();
   private static final Object aeY = new Object();
   private final int CK;
   private Contents PW;

   SnapshotContentsEntity(int var1, Contents var2) {
      this.CK = var1;
      this.PW = var2;
   }

   public SnapshotContentsEntity(Contents var1) {
      this(1, var1);
   }

   private boolean a(int param1, byte[] param2, int param3, int param4, boolean param5) {
      // $FF: Couldn't be decompiled
   }

   public void close() {
      this.PW = null;
   }

   public int describeContents() {
      return 0;
   }

   public ParcelFileDescriptor getParcelFileDescriptor() {
      boolean var1;
      if(!this.isClosed()) {
         var1 = true;
      } else {
         var1 = false;
      }

      jx.a(var1, "Cannot mutate closed contents!");
      return this.PW.getParcelFileDescriptor();
   }

   public int getVersionCode() {
      return this.CK;
   }

   public Contents ir() {
      return this.PW;
   }

   public boolean isClosed() {
      return this.PW == null;
   }

   public boolean modifyBytes(int var1, byte[] var2, int var3, int var4) {
      return this.a(var1, var2, var3, var2.length, false);
   }

   public byte[] readFully() throws IOException {
      // $FF: Couldn't be decompiled
   }

   public boolean writeBytes(byte[] var1) {
      return this.a(0, var1, 0, var1.length, true);
   }

   public void writeToParcel(Parcel var1, int var2) {
      SnapshotContentsEntityCreator.a(this, var1, var2);
   }
}
