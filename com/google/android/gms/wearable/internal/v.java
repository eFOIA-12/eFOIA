package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.w;
import java.util.List;

public class v implements SafeParcelable {
   public static final Creator CREATOR = new w();
   public final List axL;
   public final int statusCode;
   public final int versionCode;

   v(int var1, int var2, List var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.axL = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      w.a(this, var1, var2);
   }
}
