package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.internal.aq;

public class OnEventResponse implements SafeParcelable {
   public static final Creator CREATOR = new aq();
   final int CK;
   final int Pm;
   final ChangeEvent QO;
   final CompletionEvent QP;

   OnEventResponse(int var1, int var2, ChangeEvent var3, CompletionEvent var4) {
      this.CK = var1;
      this.Pm = var2;
      this.QO = var3;
      this.QP = var4;
   }

   public int describeContents() {
      return 0;
   }

   public DriveEvent iQ() {
      switch(this.Pm) {
      case 1:
         return this.QO;
      case 2:
         return this.QP;
      default:
         throw new IllegalStateException("Unexpected event type " + this.Pm);
      }
   }

   public void writeToParcel(Parcel var1, int var2) {
      aq.a(this, var1, var2);
   }
}
