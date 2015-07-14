package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.d;
import java.util.List;

public class CancelPendingActionsRequest implements SafeParcelable {
   public static final Creator CREATOR = new d();
   final int CK;
   final List Pb;

   CancelPendingActionsRequest(int var1, List var2) {
      this.CK = var1;
      this.Pb = var2;
   }

   public CancelPendingActionsRequest(List var1) {
      this(1, var1);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      d.a(this, var1, var2);
   }
}
