package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.ar;

public class OnListEntriesResponse extends com.google.android.gms.drive.i implements SafeParcelable {
   public static final Creator CREATOR = new ar();
   final int CK;
   final boolean PJ;
   final DataHolder QQ;

   OnListEntriesResponse(int var1, DataHolder var2, boolean var3) {
      this.CK = var1;
      this.QQ = var2;
      this.PJ = var3;
   }

   protected void I(Parcel var1, int var2) {
      ar.a(this, var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public DataHolder iR() {
      return this.QQ;
   }

   public boolean iS() {
      return this.PJ;
   }
}
