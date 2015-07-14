package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.ae;
import com.google.android.gms.wearable.internal.as;

public class ar implements SafeParcelable {
   public static final Creator CREATOR = new as();
   final int CK;
   public final ae axv;

   ar(int var1, IBinder var2) {
      this.CK = var1;
      if(var2 != null) {
         this.axv = ae.a.bY(var2);
      } else {
         this.axv = null;
      }
   }

   public ar(ae var1) {
      this.CK = 1;
      this.axv = var1;
   }

   public int describeContents() {
      return 0;
   }

   IBinder rm() {
      return this.axv == null?null:this.axv.asBinder();
   }

   public void writeToParcel(Parcel var1, int var2) {
      as.a(this, var1, var2);
   }
}
