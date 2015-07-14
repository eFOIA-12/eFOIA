package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.i;
import java.util.Arrays;

public class h implements SafeParcelable {
   public static final i CREATOR = new i();
   private final int CK;
   private final String DZ;
   private final String[] anQ;
   private final String[] anR;
   private final String[] anS;
   private final String anT;
   private final String anU;
   private final String anV;
   private final String anW;
   private final PlusCommonExtras anX;

   h(int var1, String var2, String[] var3, String[] var4, String[] var5, String var6, String var7, String var8, String var9, PlusCommonExtras var10) {
      this.CK = var1;
      this.DZ = var2;
      this.anQ = var3;
      this.anR = var4;
      this.anS = var5;
      this.anT = var6;
      this.anU = var7;
      this.anV = var8;
      this.anW = var9;
      this.anX = var10;
   }

   public h(String var1, String[] var2, String[] var3, String[] var4, String var5, String var6, String var7, PlusCommonExtras var8) {
      this.CK = 1;
      this.DZ = var1;
      this.anQ = var2;
      this.anR = var3;
      this.anS = var4;
      this.anT = var5;
      this.anU = var6;
      this.anV = var7;
      this.anW = null;
      this.anX = var8;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof h) {
         h var2 = (h)var1;
         if(this.CK == var2.CK && jv.equal(this.DZ, var2.DZ) && Arrays.equals(this.anQ, var2.anQ) && Arrays.equals(this.anR, var2.anR) && Arrays.equals(this.anS, var2.anS) && jv.equal(this.anT, var2.anT) && jv.equal(this.anU, var2.anU) && jv.equal(this.anV, var2.anV) && jv.equal(this.anW, var2.anW) && jv.equal(this.anX, var2.anX)) {
            return true;
         }
      }

      return false;
   }

   public String getAccountName() {
      return this.DZ;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{Integer.valueOf(this.CK), this.DZ, this.anQ, this.anR, this.anS, this.anT, this.anU, this.anV, this.anW, this.anX});
   }

   public String[] oA() {
      return this.anR;
   }

   public String[] oB() {
      return this.anS;
   }

   public String oC() {
      return this.anT;
   }

   public String oD() {
      return this.anU;
   }

   public String oE() {
      return this.anV;
   }

   public String oF() {
      return this.anW;
   }

   public PlusCommonExtras oG() {
      return this.anX;
   }

   public Bundle oH() {
      Bundle var1 = new Bundle();
      var1.setClassLoader(PlusCommonExtras.class.getClassLoader());
      this.anX.q(var1);
      return var1;
   }

   public String[] oz() {
      return this.anQ;
   }

   public String toString() {
      return jv.h(this).a("versionCode", Integer.valueOf(this.CK)).a("accountName", this.DZ).a("requestedScopes", this.anQ).a("visibleActivities", this.anR).a("requiredFeatures", this.anS).a("packageNameForAuth", this.anT).a("callingPackageName", this.anU).a("applicationName", this.anV).a("extra", this.anX.toString()).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      i.a(this, var1, var2);
   }
}
