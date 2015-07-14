package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.q;

public class ParcelableIndexReference implements SafeParcelable {
   public static final Creator CREATOR = new q();
   final int CK;
   final String SM;
   final boolean SN;
   final int mIndex;

   ParcelableIndexReference(int var1, String var2, int var3, boolean var4) {
      this.CK = var1;
      this.SM = var2;
      this.mIndex = var3;
      this.SN = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      q.a(this, var1, var2);
   }
}
