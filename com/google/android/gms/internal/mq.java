package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.mr;
import java.util.Collections;
import java.util.List;

public class mq implements SafeParcelable {
   public static final Creator CREATOR = new mr();
   private final int CK;
   private final List TY;

   mq(int var1, List var2) {
      this.CK = var1;
      this.TY = var2;
   }

   public int describeContents() {
      return 0;
   }

   public List getDataTypes() {
      return Collections.unmodifiableList(this.TY);
   }

   int getVersionCode() {
      return this.CK;
   }

   public String toString() {
      return jv.h(this).a("dataTypes", this.TY).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      mr.a(this, var1, var2);
   }
}
