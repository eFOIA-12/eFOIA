package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.auth.AccountChangeEventCreator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;

public class AccountChangeEvent implements SafeParcelable {
   public static final AccountChangeEventCreator CREATOR = new AccountChangeEventCreator();
   final String DZ;
   final int Ef;
   final long Eg;
   final int Eh;
   final int Ei;
   final String Ej;

   AccountChangeEvent(int var1, long var2, String var4, int var5, int var6, String var7) {
      this.Ef = var1;
      this.Eg = var2;
      this.DZ = (String)jx.i(var4);
      this.Eh = var5;
      this.Ei = var6;
      this.Ej = var7;
   }

   public AccountChangeEvent(long var1, String var3, int var4, int var5, String var6) {
      this.Ef = 1;
      this.Eg = var1;
      this.DZ = (String)jx.i(var3);
      this.Eh = var4;
      this.Ei = var5;
      this.Ej = var6;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof AccountChangeEvent)) {
            return false;
         }

         AccountChangeEvent var2 = (AccountChangeEvent)var1;
         if(this.Ef != var2.Ef || this.Eg != var2.Eg || !jv.equal(this.DZ, var2.DZ) || this.Eh != var2.Eh || this.Ei != var2.Ei || !jv.equal(this.Ej, var2.Ej)) {
            return false;
         }
      }

      return true;
   }

   public String getAccountName() {
      return this.DZ;
   }

   public String getChangeData() {
      return this.Ej;
   }

   public int getChangeType() {
      return this.Eh;
   }

   public int getEventIndex() {
      return this.Ei;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{Integer.valueOf(this.Ef), Long.valueOf(this.Eg), this.DZ, Integer.valueOf(this.Eh), Integer.valueOf(this.Ei), this.Ej});
   }

   public String toString() {
      String var1 = "UNKNOWN";
      switch(this.Eh) {
      case 1:
         var1 = "ADDED";
         break;
      case 2:
         var1 = "REMOVED";
         break;
      case 3:
         var1 = "RENAMED_FROM";
         break;
      case 4:
         var1 = "RENAMED_TO";
      }

      return "AccountChangeEvent {accountName = " + this.DZ + ", changeType = " + var1 + ", changeData = " + this.Ej + ", eventIndex = " + this.Ei + "}";
   }

   public void writeToParcel(Parcel var1, int var2) {
      AccountChangeEventCreator.a(this, var1, var2);
   }
}
