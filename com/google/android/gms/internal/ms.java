package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.internal.mt;

public class ms implements SafeParcelable {
   public static final Creator CREATOR = new mt();
   private final int CK;
   private final DataSource TN;

   ms(int var1, DataSource var2) {
      this.CK = var1;
      this.TN = var2;
   }

   public int describeContents() {
      return 0;
   }

   public DataSource getDataSource() {
      return this.TN;
   }

   int getVersionCode() {
      return this.CK;
   }

   public String toString() {
      return String.format("ApplicationUnregistrationRequest{%s}", new Object[]{this.TN});
   }

   public void writeToParcel(Parcel var1, int var2) {
      mt.a(this, var1, var2);
   }
}
