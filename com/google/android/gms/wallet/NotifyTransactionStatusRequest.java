package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;
import com.google.android.gms.wallet.m;

public final class NotifyTransactionStatusRequest implements SafeParcelable {
   public static final Creator CREATOR = new m();
   final int CK;
   String auL;
   String avL;
   int status;

   NotifyTransactionStatusRequest() {
      this.CK = 1;
   }

   NotifyTransactionStatusRequest(int var1, String var2, int var3, String var4) {
      this.CK = var1;
      this.auL = var2;
      this.status = var3;
      this.avL = var4;
   }

   public static NotifyTransactionStatusRequest.Builder newBuilder() {
      NotifyTransactionStatusRequest var0 = new NotifyTransactionStatusRequest();
      return var0.new Builder(null);
   }

   public int describeContents() {
      return 0;
   }

   public String getDetailedReason() {
      return this.avL;
   }

   public String getGoogleTransactionId() {
      return this.auL;
   }

   public int getStatus() {
      return this.status;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public void writeToParcel(Parcel var1, int var2) {
      m.a(this, var1, var2);
   }

   public final class Builder {
      private Builder() {
      }

      // $FF: synthetic method
      Builder(Object var2) {
         this();
      }

      public NotifyTransactionStatusRequest build() {
         boolean var2 = true;
         boolean var1;
         if(!TextUtils.isEmpty(NotifyTransactionStatusRequest.this.auL)) {
            var1 = true;
         } else {
            var1 = false;
         }

         jx.b(var1, "googleTransactionId is required");
         if(NotifyTransactionStatusRequest.this.status >= 1 && NotifyTransactionStatusRequest.this.status <= 8) {
            var1 = var2;
         } else {
            var1 = false;
         }

         jx.b(var1, "status is an unrecognized value");
         return NotifyTransactionStatusRequest.this;
      }

      public NotifyTransactionStatusRequest.Builder setDetailedReason(String var1) {
         NotifyTransactionStatusRequest.this.avL = var1;
         return this;
      }

      public NotifyTransactionStatusRequest.Builder setGoogleTransactionId(String var1) {
         NotifyTransactionStatusRequest.this.auL = var1;
         return this;
      }

      public NotifyTransactionStatusRequest.Builder setStatus(int var1) {
         NotifyTransactionStatusRequest.this.status = var1;
         return this;
      }
   }

   public interface Status {
      int SUCCESS = 1;
   }

   public interface Error {
      int AVS_DECLINE = 7;
      int BAD_CARD = 4;
      int BAD_CVC = 3;
      int DECLINED = 5;
      int FRAUD_DECLINE = 8;
      int OTHER = 6;
      int UNKNOWN = 2;
   }
}
