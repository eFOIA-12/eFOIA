package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.h;
import com.google.android.gms.internal.jx;

public class CreateContentsRequest implements SafeParcelable {
   public static final Creator CREATOR = new h();
   final int CK;
   final int Oi;

   public CreateContentsRequest(int var1) {
      this(1, var1);
   }

   CreateContentsRequest(int var1, int var2) {
      this.CK = var1;
      boolean var3;
      if(var2 != 536870912 && var2 != 805306368) {
         var3 = false;
      } else {
         var3 = true;
      }

      jx.b(var3, "Cannot create a new read-only contents!");
      this.Oi = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      h.a(this, var1, var2);
   }
}
