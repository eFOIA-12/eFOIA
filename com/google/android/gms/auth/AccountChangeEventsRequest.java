package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.auth.AccountChangeEventsRequestCreator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountChangeEventsRequest implements SafeParcelable {
   public static final AccountChangeEventsRequestCreator CREATOR = new AccountChangeEventsRequestCreator();
   String DZ;
   final int Ef;
   int Ei;

   public AccountChangeEventsRequest() {
      this.Ef = 1;
   }

   AccountChangeEventsRequest(int var1, int var2, String var3) {
      this.Ef = var1;
      this.Ei = var2;
      this.DZ = var3;
   }

   public int describeContents() {
      return 0;
   }

   public String getAccountName() {
      return this.DZ;
   }

   public int getEventIndex() {
      return this.Ei;
   }

   public AccountChangeEventsRequest setAccountName(String var1) {
      this.DZ = var1;
      return this;
   }

   public AccountChangeEventsRequest setEventIndex(int var1) {
      this.Ei = var1;
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      AccountChangeEventsRequestCreator.a(this, var1, var2);
   }
}
