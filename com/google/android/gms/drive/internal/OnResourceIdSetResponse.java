package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.av;
import java.util.List;

public class OnResourceIdSetResponse implements SafeParcelable {
   public static final Creator CREATOR = new av();
   private final int CK;
   private final List Po;

   OnResourceIdSetResponse(int var1, List var2) {
      this.CK = var1;
      this.Po = var2;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public List iF() {
      return this.Po;
   }

   public void writeToParcel(Parcel var1, int var2) {
      av.a(this, var1, var2);
   }
}
