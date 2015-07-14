package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.result.a;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BleDevicesResult implements Result, SafeParcelable {
   public static final Creator CREATOR = new a();
   private final int CK;
   private final Status Eb;
   private final List Wq;

   BleDevicesResult(int var1, List var2, Status var3) {
      this.CK = var1;
      this.Wq = Collections.unmodifiableList(var2);
      this.Eb = var3;
   }

   public BleDevicesResult(List var1, Status var2) {
      this.CK = 3;
      this.Wq = Collections.unmodifiableList(var1);
      this.Eb = var2;
   }

   public static BleDevicesResult C(Status var0) {
      return new BleDevicesResult(Collections.emptyList(), var0);
   }

   private boolean b(BleDevicesResult var1) {
      return this.Eb.equals(var1.Eb) && jv.equal(this.Wq, var1.Wq);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof BleDevicesResult && this.b((BleDevicesResult)var1);
   }

   public List getClaimedBleDevices() {
      return this.Wq;
   }

   public List getClaimedBleDevices(DataType var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = this.Wq.iterator();

      while(var3.hasNext()) {
         BleDevice var4 = (BleDevice)var3.next();
         if(var4.getDataTypes().contains(var1)) {
            var2.add(var4);
         }
      }

      return Collections.unmodifiableList(var2);
   }

   public Status getStatus() {
      return this.Eb;
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.Eb, this.Wq});
   }

   public String toString() {
      return jv.h(this).a("status", this.Eb).a("bleDevices", this.Wq).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      a.a(this, var1, var2);
   }
}
