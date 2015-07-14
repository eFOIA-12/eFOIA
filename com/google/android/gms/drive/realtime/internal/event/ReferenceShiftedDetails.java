package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.d;

public class ReferenceShiftedDetails implements SafeParcelable {
   public static final Creator CREATOR = new d();
   final int CK;
   final String Te;
   final String Tf;
   final int Tg;
   final int Th;

   ReferenceShiftedDetails(int var1, String var2, String var3, int var4, int var5) {
      this.CK = var1;
      this.Te = var2;
      this.Tf = var3;
      this.Tg = var4;
      this.Th = var5;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      d.a(this, var1, var2);
   }
}
