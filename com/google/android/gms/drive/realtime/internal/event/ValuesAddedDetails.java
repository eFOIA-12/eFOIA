package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.h;

public class ValuesAddedDetails implements SafeParcelable {
   public static final Creator CREATOR = new h();
   final int CK;
   final int SO;
   final int SP;
   final String Tk;
   final int Tl;
   final int mIndex;

   ValuesAddedDetails(int var1, int var2, int var3, int var4, String var5, int var6) {
      this.CK = var1;
      this.mIndex = var2;
      this.SO = var3;
      this.SP = var4;
      this.Tk = var5;
      this.Tl = var6;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      h.a(this, var1, var2);
   }
}
