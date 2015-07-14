package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.ai;

public class ah implements SafeParcelable {
   public static final Creator CREATOR = new ai();
   private final int CK;
   private final String VF;

   ah(int var1, String var2) {
      this.CK = var1;
      this.VF = var2;
   }

   public ah(String var1) {
      this(3, var1);
   }

   public int describeContents() {
      return 0;
   }

   public String getDeviceAddress() {
      return this.VF;
   }

   int getVersionCode() {
      return this.CK;
   }

   public String toString() {
      return String.format("UnclaimBleDeviceRequest{%s}", new Object[]{this.VF});
   }

   public void writeToParcel(Parcel var1, int var2) {
      ai.a(this, var1, var2);
   }
}
