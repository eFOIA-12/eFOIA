package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.a;

@Deprecated
public final class Address implements SafeParcelable {
   public static final Creator CREATOR = new a();
   private final int CK;
   String afK;
   String afL;
   String afM;
   String afR;
   String afT;
   boolean afU;
   String afV;
   String auD;
   String auE;
   String name;
   String vk;

   Address() {
      this.CK = 1;
   }

   Address(int var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, boolean var11, String var12) {
      this.CK = var1;
      this.name = var2;
      this.afK = var3;
      this.afL = var4;
      this.afM = var5;
      this.vk = var6;
      this.auD = var7;
      this.auE = var8;
      this.afR = var9;
      this.afT = var10;
      this.afU = var11;
      this.afV = var12;
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

   public String getCity() {
      return this.auD;
   }

   public String getCompanyName() {
      return this.afV;
   }

   public String getCountryCode() {
      return this.vk;
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

   public String getState() {
      return this.auE;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public boolean isPostBox() {
      return this.afU;
   }

   public void writeToParcel(Parcel var1, int var2) {
      a.a(this, var1, var2);
   }
}
