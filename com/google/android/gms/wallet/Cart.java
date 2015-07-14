package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.LineItem;
import com.google.android.gms.wallet.b;
import java.util.ArrayList;
import java.util.List;

public final class Cart implements SafeParcelable {
   public static final Creator CREATOR = new b();
   private final int CK;
   String auF;
   String auG;
   ArrayList auH;

   Cart() {
      this.CK = 1;
      this.auH = new ArrayList();
   }

   Cart(int var1, String var2, String var3, ArrayList var4) {
      this.CK = var1;
      this.auF = var2;
      this.auG = var3;
      this.auH = var4;
   }

   public static Cart.Builder newBuilder() {
      Cart var0 = new Cart();
      return var0.new Builder(null);
   }

   public int describeContents() {
      return 0;
   }

   public String getCurrencyCode() {
      return this.auG;
   }

   public ArrayList getLineItems() {
      return this.auH;
   }

   public String getTotalPrice() {
      return this.auF;
   }

   public int getVersionCode() {
      return this.CK;
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

      public Cart.Builder addLineItem(LineItem var1) {
         Cart.this.auH.add(var1);
         return this;
      }

      public Cart build() {
         return Cart.this;
      }

      public Cart.Builder setCurrencyCode(String var1) {
         Cart.this.auG = var1;
         return this;
      }

      public Cart.Builder setLineItems(List var1) {
         Cart.this.auH.clear();
         Cart.this.auH.addAll(var1);
         return this;
      }

      public Cart.Builder setTotalPrice(String var1) {
         Cart.this.auF = var1;
         return this;
      }
   }
}
