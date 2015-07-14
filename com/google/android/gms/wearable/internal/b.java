package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.ae;
import com.google.android.gms.wearable.internal.bb;
import com.google.android.gms.wearable.internal.c;

public class b implements SafeParcelable {
   public static final Creator CREATOR = new c();
   final int CK;
   public final ae axv;
   public final IntentFilter[] axw;

   b(int var1, IBinder var2, IntentFilter[] var3) {
      this.CK = var1;
      if(var2 != null) {
         this.axv = ae.a.bY(var2);
      } else {
         this.axv = null;
      }

      this.axw = var3;
   }

   public b(bb var1) {
      this.CK = 1;
      this.axv = var1;
      this.axw = var1.rs();
   }

   public int describeContents() {
      return 0;
   }

   IBinder rm() {
      return this.axv == null?null:this.axv.asBinder();
   }

   public void writeToParcel(Parcel var1, int var2) {
      c.a(this, var1, var2);
   }
}
