package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.jx;

public abstract class i implements Parcelable {
   private transient volatile boolean OW = false;

   protected abstract void I(Parcel var1, int var2);

   public final boolean iB() {
      return this.OW;
   }

   public void writeToParcel(Parcel var1, int var2) {
      boolean var3;
      if(!this.iB()) {
         var3 = true;
      } else {
         var3 = false;
      }

      jx.K(var3);
      this.OW = true;
      this.I(var1, var2);
   }
}
