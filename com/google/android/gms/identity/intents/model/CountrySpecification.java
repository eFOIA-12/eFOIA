package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.a;

public class CountrySpecification implements SafeParcelable {
   public static final Creator CREATOR = new a();
   private final int CK;
   String vk;

   CountrySpecification(int var1, String var2) {
      this.CK = var1;
      this.vk = var2;
   }

   public CountrySpecification(String var1) {
      this.CK = 1;
      this.vk = var1;
   }

   public int describeContents() {
      return 0;
   }

   public String getCountryCode() {
      return this.vk;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public void writeToParcel(Parcel var1, int var2) {
      a.a(this, var1, var2);
   }
}
