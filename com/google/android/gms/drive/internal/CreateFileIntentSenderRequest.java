package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.j;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFileIntentSenderRequest implements SafeParcelable {
   public static final Creator CREATOR = new j();
   final int CK;
   final String OH;
   final DriveId OJ;
   final MetadataBundle Px;
   final Integer Py;
   final int ve;

   CreateFileIntentSenderRequest(int var1, MetadataBundle var2, int var3, String var4, DriveId var5, Integer var6) {
      this.CK = var1;
      this.Px = var2;
      this.ve = var3;
      this.OH = var4;
      this.OJ = var5;
      this.Py = var6;
   }

   public CreateFileIntentSenderRequest(MetadataBundle var1, int var2, String var3, DriveId var4, int var5) {
      this(1, var1, var2, var3, var4, Integer.valueOf(var5));
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      j.a(this, var1, var2);
   }
}
