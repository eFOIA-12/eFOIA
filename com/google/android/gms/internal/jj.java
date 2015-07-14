package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jk;
import com.google.android.gms.internal.jq;

public class jj implements SafeParcelable {
   public static final Creator CREATOR = new jk();
   final int MD;
   int ME;
   String MF;
   IBinder MG;
   Scope[] MH;
   Bundle MI;
   final int version;

   public jj(int var1) {
      this.version = 1;
      this.ME = 6587000;
      this.MD = var1;
   }

   jj(int var1, int var2, int var3, String var4, IBinder var5, Scope[] var6, Bundle var7) {
      this.version = var1;
      this.MD = var2;
      this.ME = var3;
      this.MF = var4;
      this.MG = var5;
      this.MH = var6;
      this.MI = var7;
   }

   public jj a(jq var1) {
      if(var1 != null) {
         this.MG = var1.asBinder();
      }

      return this;
   }

   public jj a(Scope[] var1) {
      this.MH = var1;
      return this;
   }

   public jj aX(String var1) {
      this.MF = var1;
      return this;
   }

   public int describeContents() {
      return 0;
   }

   public jj e(Bundle var1) {
      this.MI = var1;
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      jk.a(this, var1, var2);
   }
}
