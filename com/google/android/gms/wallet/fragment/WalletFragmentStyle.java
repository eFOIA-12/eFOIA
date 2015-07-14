package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.c;

public final class WalletFragmentStyle implements SafeParcelable {
   public static final Creator CREATOR = new c();
   final int CK;
   Bundle awy;
   int awz;

   public WalletFragmentStyle() {
      this.CK = 1;
      this.awy = new Bundle();
   }

   WalletFragmentStyle(int var1, Bundle var2, int var3) {
      this.CK = var1;
      this.awy = var2;
      this.awz = var3;
   }

   private void a(TypedArray var1, int var2, String var3) {
      if(!this.awy.containsKey(var3)) {
         TypedValue var4 = var1.peekValue(var2);
         if(var4 != null) {
            this.awy.putLong(var3, Dimension.a(var4));
            return;
         }
      }

   }

   private void a(TypedArray var1, int var2, String var3, String var4) {
      if(!this.awy.containsKey(var3) && !this.awy.containsKey(var4)) {
         TypedValue var5 = var1.peekValue(var2);
         if(var5 != null) {
            if(var5.type >= 28 && var5.type <= 31) {
               this.awy.putInt(var3, var5.data);
               return;
            }

            this.awy.putInt(var4, var5.resourceId);
            return;
         }
      }

   }

   private void b(TypedArray var1, int var2, String var3) {
      if(!this.awy.containsKey(var3)) {
         TypedValue var4 = var1.peekValue(var2);
         if(var4 != null) {
            this.awy.putInt(var3, var4.data);
            return;
         }
      }

   }

   public int a(String var1, DisplayMetrics var2, int var3) {
      if(this.awy.containsKey(var1)) {
         var3 = Dimension.a(this.awy.getLong(var1), var2);
      }

      return var3;
   }

   public void ab(Context var1) {
      int var2;
      if(this.awz <= 0) {
         var2 = R.style.WalletFragmentDefaultStyle;
      } else {
         var2 = this.awz;
      }

      TypedArray var3 = var1.obtainStyledAttributes(var2, R.styleable.WalletFragmentStyle);
      this.a(var3, R.styleable.WalletFragmentStyle_buyButtonWidth, "buyButtonWidth");
      this.a(var3, R.styleable.WalletFragmentStyle_buyButtonHeight, "buyButtonHeight");
      this.b(var3, R.styleable.WalletFragmentStyle_buyButtonText, "buyButtonText");
      this.b(var3, R.styleable.WalletFragmentStyle_buyButtonAppearance, "buyButtonAppearance");
      this.b(var3, R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance, "maskedWalletDetailsTextAppearance");
      this.b(var3, R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance, "maskedWalletDetailsHeaderTextAppearance");
      this.a(var3, R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground, "maskedWalletDetailsBackgroundColor", "maskedWalletDetailsBackgroundResource");
      this.b(var3, R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance, "maskedWalletDetailsButtonTextAppearance");
      this.a(var3, R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground, "maskedWalletDetailsButtonBackgroundColor", "maskedWalletDetailsButtonBackgroundResource");
      this.b(var3, R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor, "maskedWalletDetailsLogoTextColor");
      this.b(var3, R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType, "maskedWalletDetailsLogoImageType");
      var3.recycle();
   }

   public int describeContents() {
      return 0;
   }

   public WalletFragmentStyle setBuyButtonAppearance(int var1) {
      this.awy.putInt("buyButtonAppearance", var1);
      return this;
   }

   public WalletFragmentStyle setBuyButtonHeight(int var1) {
      this.awy.putLong("buyButtonHeight", Dimension.gg(var1));
      return this;
   }

   public WalletFragmentStyle setBuyButtonHeight(int var1, float var2) {
      this.awy.putLong("buyButtonHeight", Dimension.a(var1, var2));
      return this;
   }

   public WalletFragmentStyle setBuyButtonText(int var1) {
      this.awy.putInt("buyButtonText", var1);
      return this;
   }

   public WalletFragmentStyle setBuyButtonWidth(int var1) {
      this.awy.putLong("buyButtonWidth", Dimension.gg(var1));
      return this;
   }

   public WalletFragmentStyle setBuyButtonWidth(int var1, float var2) {
      this.awy.putLong("buyButtonWidth", Dimension.a(var1, var2));
      return this;
   }

   public WalletFragmentStyle setMaskedWalletDetailsBackgroundColor(int var1) {
      this.awy.remove("maskedWalletDetailsBackgroundResource");
      this.awy.putInt("maskedWalletDetailsBackgroundColor", var1);
      return this;
   }

   public WalletFragmentStyle setMaskedWalletDetailsBackgroundResource(int var1) {
      this.awy.remove("maskedWalletDetailsBackgroundColor");
      this.awy.putInt("maskedWalletDetailsBackgroundResource", var1);
      return this;
   }

   public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundColor(int var1) {
      this.awy.remove("maskedWalletDetailsButtonBackgroundResource");
      this.awy.putInt("maskedWalletDetailsButtonBackgroundColor", var1);
      return this;
   }

   public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundResource(int var1) {
      this.awy.remove("maskedWalletDetailsButtonBackgroundColor");
      this.awy.putInt("maskedWalletDetailsButtonBackgroundResource", var1);
      return this;
   }

   public WalletFragmentStyle setMaskedWalletDetailsButtonTextAppearance(int var1) {
      this.awy.putInt("maskedWalletDetailsButtonTextAppearance", var1);
      return this;
   }

   public WalletFragmentStyle setMaskedWalletDetailsHeaderTextAppearance(int var1) {
      this.awy.putInt("maskedWalletDetailsHeaderTextAppearance", var1);
      return this;
   }

   public WalletFragmentStyle setMaskedWalletDetailsLogoImageType(int var1) {
      this.awy.putInt("maskedWalletDetailsLogoImageType", var1);
      return this;
   }

   public WalletFragmentStyle setMaskedWalletDetailsLogoTextColor(int var1) {
      this.awy.putInt("maskedWalletDetailsLogoTextColor", var1);
      return this;
   }

   public WalletFragmentStyle setMaskedWalletDetailsTextAppearance(int var1) {
      this.awy.putInt("maskedWalletDetailsTextAppearance", var1);
      return this;
   }

   public WalletFragmentStyle setStyleResourceId(int var1) {
      this.awz = var1;
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      c.a(this, var1, var2);
   }
}
