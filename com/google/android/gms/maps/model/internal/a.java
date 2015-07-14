package com.google.android.gms.maps.model.internal;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.internal.b;

public final class a implements SafeParcelable {
   public static final b CREATOR = new b();
   private final int CK;
   private byte amJ;
   private Bundle amK;
   private Bitmap amL;

   a(int var1, byte var2, Bundle var3, Bitmap var4) {
      this.CK = var1;
      this.amJ = var2;
      this.amK = var3;
      this.amL = var4;
   }

   public int describeContents() {
      return 0;
   }

   public Bitmap getBitmap() {
      return this.amL;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public byte oh() {
      return this.amJ;
   }

   public Bundle oi() {
      return this.amK;
   }

   public void writeToParcel(Parcel var1, int var2) {
      b.a(this, var1, var2);
   }
}
