package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.bk;
import com.google.android.gms.internal.ey;

@ey
public final class bj implements SafeParcelable {
   public static final bk CREATOR = new bk();
   public final int backgroundColor;
   public final int oQ;
   public final int oR;
   public final int oS;
   public final int oT;
   public final int oU;
   public final int oV;
   public final int oW;
   public final String oX;
   public final int oY;
   public final String oZ;
   public final int pa;
   public final int pb;
   public final String pc;
   public final int versionCode;

   bj(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, String var10, int var11, String var12, int var13, int var14, String var15) {
      this.versionCode = var1;
      this.oQ = var2;
      this.backgroundColor = var3;
      this.oR = var4;
      this.oS = var5;
      this.oT = var6;
      this.oU = var7;
      this.oV = var8;
      this.oW = var9;
      this.oX = var10;
      this.oY = var11;
      this.oZ = var12;
      this.pa = var13;
      this.pb = var14;
      this.pc = var15;
   }

   public bj(SearchAdRequest var1) {
      this.versionCode = 1;
      this.oQ = var1.getAnchorTextColor();
      this.backgroundColor = var1.getBackgroundColor();
      this.oR = var1.getBackgroundGradientBottom();
      this.oS = var1.getBackgroundGradientTop();
      this.oT = var1.getBorderColor();
      this.oU = var1.getBorderThickness();
      this.oV = var1.getBorderType();
      this.oW = var1.getCallButtonColor();
      this.oX = var1.getCustomChannels();
      this.oY = var1.getDescriptionTextColor();
      this.oZ = var1.getFontFace();
      this.pa = var1.getHeaderTextColor();
      this.pb = var1.getHeaderTextSize();
      this.pc = var1.getQuery();
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      bk.a(this, var1, var2);
   }
}
