package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.internal.g;

public class CloseContentsRequest implements SafeParcelable {
   public static final Creator CREATOR = new g();
   final int CK;
   final Contents Pr;
   final Boolean Pt;

   CloseContentsRequest(int var1, Contents var2, Boolean var3) {
      this.CK = var1;
      this.Pr = var2;
      this.Pt = var3;
   }

   public CloseContentsRequest(Contents var1, boolean var2) {
      this(1, var1, Boolean.valueOf(var2));
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      g.a(this, var1, var2);
   }
}
