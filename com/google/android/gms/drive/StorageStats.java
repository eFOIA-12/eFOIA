package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.g;

public class StorageStats implements SafeParcelable {
   public static final Creator CREATOR = new g();
   final int CK;
   final long OM;
   final long ON;
   final long OO;
   final long OP;
   final int OQ;

   StorageStats(int var1, long var2, long var4, long var6, long var8, int var10) {
      this.CK = var1;
      this.OM = var2;
      this.ON = var4;
      this.OO = var6;
      this.OP = var8;
      this.OQ = var10;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      g.a(this, var1, var2);
   }
}
