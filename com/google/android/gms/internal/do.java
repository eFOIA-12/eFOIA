package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.dn;
import com.google.android.gms.internal.ey;

@ey
public final class do implements SafeParcelable {
   public static final dn CREATOR = new dn();
   public final String mimeType;
   public final String packageName;
   public final String rG;
   public final String rH;
   public final String rI;
   public final String rJ;
   public final String rK;
   public final int versionCode;

   public do(int var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8) {
      this.versionCode = var1;
      this.rG = var2;
      this.rH = var3;
      this.mimeType = var4;
      this.packageName = var5;
      this.rI = var6;
      this.rJ = var7;
      this.rK = var8;
   }

   public do(String var1, String var2, String var3, String var4, String var5, String var6, String var7) {
      this(1, var1, var2, var3, var4, var5, var6, var7);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      dn.a(this, var1, var2);
   }
}
