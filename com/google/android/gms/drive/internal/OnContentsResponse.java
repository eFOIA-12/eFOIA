package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.internal.al;

public class OnContentsResponse implements SafeParcelable {
   public static final Creator CREATOR = new al();
   final int CK;
   final Contents PW;
   final boolean QJ;

   OnContentsResponse(int var1, Contents var2, boolean var3) {
      this.CK = var1;
      this.PW = var2;
      this.QJ = var3;
   }

   public int describeContents() {
      return 0;
   }

   public Contents iL() {
      return this.PW;
   }

   public boolean iM() {
      return this.QJ;
   }

   public void writeToParcel(Parcel var1, int var2) {
      al.a(this, var1, var2);
   }
}
