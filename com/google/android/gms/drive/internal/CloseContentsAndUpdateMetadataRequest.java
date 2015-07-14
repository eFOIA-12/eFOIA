package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.internal.f;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CloseContentsAndUpdateMetadataRequest implements SafeParcelable {
   public static final Creator CREATOR = new f();
   final int CK;
   final String Oy;
   final boolean Oz;
   final DriveId Pp;
   final MetadataBundle Pq;
   final Contents Pr;
   final int Ps;

   CloseContentsAndUpdateMetadataRequest(int var1, DriveId var2, MetadataBundle var3, Contents var4, boolean var5, String var6, int var7) {
      this.CK = var1;
      this.Pp = var2;
      this.Pq = var3;
      this.Pr = var4;
      this.Oz = var5;
      this.Oy = var6;
      this.Ps = var7;
   }

   public CloseContentsAndUpdateMetadataRequest(DriveId var1, MetadataBundle var2, Contents var3, ExecutionOptions var4) {
      this(1, var1, var2, var3, var4.iw(), var4.iv(), var4.ix());
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      f.a(this, var1, var2);
   }
}
