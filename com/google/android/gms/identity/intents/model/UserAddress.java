package com.google.android.gms.identity.intents.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.b;

public final class UserAddress implements SafeParcelable {
   public static final Creator CREATOR = new b();
   private final int CK;
   String afK;
   String afL;
   String afM;
   String afN;
   String afO;
   String afP;
   String afQ;
   String afR;
   String afS;
   String afT;
   boolean afU;
   String afV;
   String afW;
   String name;
   String vk;

   UserAddress() {
      this.CK = 1;
   }

   UserAddress(int var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11, String var12, String var13, boolean var14, String var15, String var16) {
      this.CK = var1;
      this.name = var2;
      this.afK = var3;
      this.afL = var4;
      this.afM = var5;
      this.afN = var6;
      this.afO = var7;
      this.afP = var8;
      this.afQ = var9;
      this.vk = var10;
      this.afR = var11;
      this.afS = var12;
      this.afT = var13;
      this.afU = var14;
      this.afV = var15;
      this.afW = var16;
   }

   public static UserAddress fromIntent(Intent var0) {
      return var0 != null && var0.hasExtra("com.google.android.gms.identity.intents.EXTRA_ADDRESS")?(UserAddress)var0.getParcelableExtra("com.google.android.gms.identity.intents.EXTRA_ADDRESS"):null;
   }

   public int describeContents() {
      return 0;
   }

   public String getAddress1() {
      return this.afK;
   }

   public String getAddress2() {
      return this.afL;
   }

   public String getAddress3() {
      return this.afM;
   }

   public String getAddress4() {
      return this.afN;
   }

   public String getAddress5() {
      return this.afO;
   }

   public String getAdministrativeArea() {
      return this.afP;
   }

   public String getCompanyName() {
      return this.afV;
   }

   public String getCountryCode() {
      return this.vk;
   }

   public String getEmailAddress() {
      return this.afW;
   }

   public String getLocality() {
      return this.afQ;
   }

   public String getName() {
      return this.name;
   }

   public String getPhoneNumber() {
      return this.afT;
   }

   public String getPostalCode() {
      return this.afR;
   }

   public String getSortingCode() {
      return this.afS;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public boolean isPostBox() {
      return this.afU;
   }

   public void writeToParcel(Parcel var1, int var2) {
      b.a(this, var1, var2);
   }
}
