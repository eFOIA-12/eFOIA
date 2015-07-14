package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.c;

public class b implements SafeParcelable {
   public static final Creator CREATOR = new c();
   private final int CK;
   private final String VF;
   private final BleDevice VG;

   b(int var1, String var2, BleDevice var3) {
      this.CK = var1;
      this.VF = var2;
      this.VG = var3;
   }

   public b(BleDevice var1) {
      this(2, var1.getAddress(), var1);
   }

   public b(String var1) {
      this(2, var1, (BleDevice)null);
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

   public BleDevice jQ() {
      return this.VG;
   }

   public String toString() {
      return String.format("ClaimBleDeviceRequest{%s %s}", new Object[]{this.VF, this.VG});
   }

   public void writeToParcel(Parcel var1, int var2) {
      c.a(this, var1, var2);
   }
}
