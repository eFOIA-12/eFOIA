package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.a;

public class BeginCompoundOperationRequest implements SafeParcelable {
   public static final Creator CREATOR = new a();
   final int CK;
   final boolean SF;
   final boolean SG;
   final String mName;

   BeginCompoundOperationRequest(int var1, boolean var2, String var3, boolean var4) {
      this.CK = var1;
      this.SF = var2;
      this.mName = var3;
      this.SG = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      a.a(this, var1, var2);
   }
}
