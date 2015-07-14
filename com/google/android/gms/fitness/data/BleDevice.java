package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.c;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.ls;
import java.util.Collections;
import java.util.List;

public class BleDevice implements SafeParcelable {
   public static final Creator CREATOR = new c();
   private final int CK;
   private final String TW;
   private final List TX;
   private final List TY;
   private final String mName;

   BleDevice(int var1, String var2, String var3, List var4, List var5) {
      this.CK = var1;
      this.TW = var2;
      this.mName = var3;
      this.TX = Collections.unmodifiableList(var4);
      this.TY = Collections.unmodifiableList(var5);
   }

   private boolean a(BleDevice var1) {
      return this.mName.equals(var1.mName) && this.TW.equals(var1.TW) && ls.a(var1.TX, this.TX) && ls.a(this.TY, var1.TY);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof BleDevice && this.a((BleDevice)var1);
   }

   public String getAddress() {
      return this.TW;
   }

   public List getDataTypes() {
      return this.TY;
   }

   public String getName() {
      return this.mName;
   }

   public List getSupportedProfiles() {
      return this.TX;
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.mName, this.TW, this.TX, this.TY});
   }

   public String toString() {
      return jv.h(this).a("name", this.mName).a("address", this.TW).a("dataTypes", this.TY).a("supportedProfiles", this.TX).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      c.a(this, var1, var2);
   }
}
