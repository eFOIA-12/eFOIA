package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle;
import com.google.android.gms.wallet.fragment.b;

public final class WalletFragmentOptions implements SafeParcelable {
   public static final Creator CREATOR = new b();
   final int CK;
   private int Oi;
   private int avV;
   private WalletFragmentStyle aww;
   private int mTheme;

   private WalletFragmentOptions() {
      this.CK = 1;
   }

   WalletFragmentOptions(int var1, int var2, int var3, WalletFragmentStyle var4, int var5) {
      this.CK = var1;
      this.avV = var2;
      this.mTheme = var3;
      this.aww = var4;
      this.Oi = var5;
   }

   public static WalletFragmentOptions a(Context var0, AttributeSet var1) {
      TypedArray var6 = var0.obtainStyledAttributes(var1, R.styleable.WalletFragmentOptions);
      int var2 = var6.getInt(R.styleable.WalletFragmentOptions_appTheme, 0);
      int var3 = var6.getInt(R.styleable.WalletFragmentOptions_environment, 1);
      int var4 = var6.getResourceId(R.styleable.WalletFragmentOptions_fragmentStyle, 0);
      int var5 = var6.getInt(R.styleable.WalletFragmentOptions_fragmentMode, 1);
      var6.recycle();
      WalletFragmentOptions var7 = new WalletFragmentOptions();
      var7.mTheme = var2;
      var7.avV = var3;
      var7.aww = (new WalletFragmentStyle()).setStyleResourceId(var4);
      var7.aww.ab(var0);
      var7.Oi = var5;
      return var7;
   }

   public static WalletFragmentOptions.Builder newBuilder() {
      WalletFragmentOptions var0 = new WalletFragmentOptions();
      return var0.new Builder(null);
   }

   public void ab(Context var1) {
      if(this.aww != null) {
         this.aww.ab(var1);
      }

   }

   public int describeContents() {
      return 0;
   }

   public int getEnvironment() {
      return this.avV;
   }

   public WalletFragmentStyle getFragmentStyle() {
      return this.aww;
   }

   public int getMode() {
      return this.Oi;
   }

   public int getTheme() {
      return this.mTheme;
   }

   public void writeToParcel(Parcel var1, int var2) {
      b.a(this, var1, var2);
   }

   public final class Builder {
      private Builder() {
      }

      // $FF: synthetic method
      Builder(Object var2) {
         this();
      }

      public WalletFragmentOptions build() {
         return WalletFragmentOptions.this;
      }

      public WalletFragmentOptions.Builder setEnvironment(int var1) {
         WalletFragmentOptions.this.avV = var1;
         return this;
      }

      public WalletFragmentOptions.Builder setFragmentStyle(int var1) {
         WalletFragmentOptions.this.aww = (new WalletFragmentStyle()).setStyleResourceId(var1);
         return this;
      }

      public WalletFragmentOptions.Builder setFragmentStyle(WalletFragmentStyle var1) {
         WalletFragmentOptions.this.aww = var1;
         return this;
      }

      public WalletFragmentOptions.Builder setMode(int var1) {
         WalletFragmentOptions.this.Oi = var1;
         return this;
      }

      public WalletFragmentOptions.Builder setTheme(int var1) {
         WalletFragmentOptions.this.mTheme = var1;
         return this;
      }
   }
}
