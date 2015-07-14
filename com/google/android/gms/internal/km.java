package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kn;
import com.google.android.gms.internal.ko;
import com.google.android.gms.internal.kr;

public class km implements SafeParcelable {
   public static final kn CREATOR = new kn();
   private final int CK;
   private final ko NF;

   km(int var1, ko var2) {
      this.CK = var1;
      this.NF = var2;
   }

   private km(ko var1) {
      this.CK = 1;
      this.NF = var1;
   }

   public static km a(kr.b var0) {
      if(var0 instanceof ko) {
         return new km((ko)var0);
      } else {
         throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
      }
   }

   public int describeContents() {
      kn var1 = CREATOR;
      return 0;
   }

   int getVersionCode() {
      return this.CK;
   }

   ko hF() {
      return this.NF;
   }

   public kr.b hG() {
      if(this.NF != null) {
         return this.NF;
      } else {
         throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
      }
   }

   public void writeToParcel(Parcel var1, int var2) {
      kn var3 = CREATOR;
      kn.a(this, var1, var2);
   }
}
