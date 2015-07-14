package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gt;

@ey
public final class gs implements SafeParcelable {
   public static final gt CREATOR = new gt();
   public final int versionCode;
   public String wS;
   public int wT;
   public int wU;
   public boolean wV;

   public gs(int var1, int var2, boolean var3) {
      StringBuilder var5 = (new StringBuilder()).append("afma-sdk-a-v").append(var1).append(".").append(var2).append(".");
      String var4;
      if(var3) {
         var4 = "0";
      } else {
         var4 = "1";
      }

      this(1, var5.append(var4).toString(), var1, var2, var3);
   }

   gs(int var1, String var2, int var3, int var4, boolean var5) {
      this.versionCode = var1;
      this.wS = var2;
      this.wT = var3;
      this.wU = var4;
      this.wV = var5;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      gt.a(this, var1, var2);
   }
}
