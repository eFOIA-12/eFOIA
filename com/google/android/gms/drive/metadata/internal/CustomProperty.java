package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.c;
import com.google.android.gms.internal.jx;

public class CustomProperty implements SafeParcelable {
   public static final Creator CREATOR = new c();
   final int CK;
   final CustomPropertyKey Rg;
   final String mValue;

   CustomProperty(int var1, CustomPropertyKey var2, String var3) {
      this.CK = var1;
      jx.b((Object)var2, "key");
      this.Rg = var2;
      this.mValue = var3;
   }

   public CustomProperty(CustomPropertyKey var1, String var2) {
      this(1, var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public String getValue() {
      return this.mValue;
   }

   public CustomPropertyKey iX() {
      return this.Rg;
   }

   public void writeToParcel(Parcel var1, int var2) {
      c.a(this, var1, var2);
   }
}
