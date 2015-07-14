package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.la;
import com.google.android.gms.wallet.j;
import java.util.ArrayList;

public final class LoyaltyWalletObject implements SafeParcelable {
   public static final Creator CREATOR = new j();
   private final int CK;
   String aki;
   String avd;
   String ave;
   String avf;
   String avg;
   String avh;
   String avi;
   String avj;
   String avk;
   ArrayList avl;
   com.google.android.gms.wallet.wobs.l avm;
   ArrayList avn;
   String avo;
   String avp;
   ArrayList avq;
   boolean avr;
   ArrayList avs;
   ArrayList avt;
   ArrayList avu;
   com.google.android.gms.wallet.wobs.f avv;
   String fl;
   int state;

   LoyaltyWalletObject() {
      this.CK = 4;
      this.avl = la.ie();
      this.avn = la.ie();
      this.avq = la.ie();
      this.avs = la.ie();
      this.avt = la.ie();
      this.avu = la.ie();
   }

   LoyaltyWalletObject(int var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11, int var12, ArrayList var13, com.google.android.gms.wallet.wobs.l var14, ArrayList var15, String var16, String var17, ArrayList var18, boolean var19, ArrayList var20, ArrayList var21, ArrayList var22, com.google.android.gms.wallet.wobs.f var23) {
      this.CK = var1;
      this.fl = var2;
      this.avd = var3;
      this.ave = var4;
      this.avf = var5;
      this.aki = var6;
      this.avg = var7;
      this.avh = var8;
      this.avi = var9;
      this.avj = var10;
      this.avk = var11;
      this.state = var12;
      this.avl = var13;
      this.avm = var14;
      this.avn = var15;
      this.avo = var16;
      this.avp = var17;
      this.avq = var18;
      this.avr = var19;
      this.avs = var20;
      this.avt = var21;
      this.avu = var22;
      this.avv = var23;
   }

   public int describeContents() {
      return 0;
   }

   public String getAccountId() {
      return this.avd;
   }

   public String getAccountName() {
      return this.aki;
   }

   public String getBarcodeAlternateText() {
      return this.avg;
   }

   public String getBarcodeType() {
      return this.avh;
   }

   public String getBarcodeValue() {
      return this.avi;
   }

   public String getId() {
      return this.fl;
   }

   public String getIssuerName() {
      return this.ave;
   }

   public String getProgramName() {
      return this.avf;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public void writeToParcel(Parcel var1, int var2) {
      j.a(this, var1, var2);
   }
}
