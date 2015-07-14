package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.bf;
import java.util.List;

public class SetResourceParentsRequest implements SafeParcelable {
   public static final Creator CREATOR = new bf();
   final int CK;
   final DriveId QW;
   final List QX;

   SetResourceParentsRequest(int var1, DriveId var2, List var3) {
      this.CK = var1;
      this.QW = var2;
      this.QX = var3;
   }

   public SetResourceParentsRequest(DriveId var1, List var2) {
      this(1, var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      bf.a(this, var1, var2);
   }
}
