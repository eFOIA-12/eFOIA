package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.StatusCreator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

public final class Status implements Result, SafeParcelable {
   public static final StatusCreator CREATOR = new StatusCreator();
   public static final Status KA = new Status(16);
   public static final Status Kw = new Status(0);
   public static final Status Kx = new Status(14);
   public static final Status Ky = new Status(8);
   public static final Status Kz = new Status(15);
   private final int CK;
   private final int Iv;
   private final String KB;
   private final PendingIntent mPendingIntent;

   public Status(int var1) {
      this(var1, (String)null);
   }

   Status(int var1, int var2, String var3, PendingIntent var4) {
      this.CK = var1;
      this.Iv = var2;
      this.KB = var3;
      this.mPendingIntent = var4;
   }

   public Status(int var1, String var2) {
      this(1, var1, var2, (PendingIntent)null);
   }

   public Status(int var1, String var2, PendingIntent var3) {
      this(1, var1, var2, var3);
   }

   private String gt() {
      return this.KB != null?this.KB:CommonStatusCodes.getStatusCodeString(this.Iv);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof Status) {
         Status var2 = (Status)var1;
         if(this.CK == var2.CK && this.Iv == var2.Iv && jv.equal(this.KB, var2.KB) && jv.equal(this.mPendingIntent, var2.mPendingIntent)) {
            return true;
         }
      }

      return false;
   }

   PendingIntent gP() {
      return this.mPendingIntent;
   }

   @Deprecated
   public ConnectionResult gQ() {
      return new ConnectionResult(this.Iv, this.mPendingIntent);
   }

   public PendingIntent getResolution() {
      return this.mPendingIntent;
   }

   public Status getStatus() {
      return this;
   }

   public int getStatusCode() {
      return this.Iv;
   }

   public String getStatusMessage() {
      return this.KB;
   }

   int getVersionCode() {
      return this.CK;
   }

   public boolean hasResolution() {
      return this.mPendingIntent != null;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{Integer.valueOf(this.CK), Integer.valueOf(this.Iv), this.KB, this.mPendingIntent});
   }

   public boolean isCanceled() {
      return this.Iv == 16;
   }

   public boolean isInterrupted() {
      return this.Iv == 14;
   }

   public boolean isSuccess() {
      return this.Iv <= 0;
   }

   public void startResolutionForResult(Activity var1, int var2) throws SendIntentException {
      if(this.hasResolution()) {
         var1.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), var2, (Intent)null, 0, 0, 0);
      }
   }

   public String toString() {
      return jv.h(this).a("statusCode", this.gt()).a("resolution", this.mPendingIntent).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      StatusCreator.a(this, var1, var2);
   }
}
