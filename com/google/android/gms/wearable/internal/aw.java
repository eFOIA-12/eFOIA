package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.ax;
import java.util.List;

public class aw implements SafeParcelable {
   public static final Creator CREATOR = new ax();
   public final long ayc;
   public final List aye;
   public final int statusCode;
   public final int versionCode;

   aw(int var1, int var2, long var3, List var5) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.ayc = var3;
      this.aye = var5;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      ax.a(this, var1, var2);
   }
}
