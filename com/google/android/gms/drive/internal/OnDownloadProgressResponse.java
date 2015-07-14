package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.an;

public class OnDownloadProgressResponse implements SafeParcelable {
   public static final Creator CREATOR = new an();
   final int CK;
   final long QL;
   final long QM;

   OnDownloadProgressResponse(int var1, long var2, long var4) {
      this.CK = var1;
      this.QL = var2;
      this.QM = var4;
   }

   public int describeContents() {
      return 0;
   }

   public long iO() {
      return this.QL;
   }

   public long iP() {
      return this.QM;
   }

   public void writeToParcel(Parcel var1, int var2) {
      an.a(this, var1, var2);
   }
}
