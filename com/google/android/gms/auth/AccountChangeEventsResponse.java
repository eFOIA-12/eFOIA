package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.auth.AccountChangeEventsResponseCreator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;
import java.util.List;

public class AccountChangeEventsResponse implements SafeParcelable {
   public static final AccountChangeEventsResponseCreator CREATOR = new AccountChangeEventsResponseCreator();
   final int Ef;
   final List mp;

   AccountChangeEventsResponse(int var1, List var2) {
      this.Ef = var1;
      this.mp = (List)jx.i(var2);
   }

   public AccountChangeEventsResponse(List var1) {
      this.Ef = 1;
      this.mp = (List)jx.i(var1);
   }

   public int describeContents() {
      return 0;
   }

   public List getEvents() {
      return this.mp;
   }

   public void writeToParcel(Parcel var1, int var2) {
      AccountChangeEventsResponseCreator.a(this, var1, var2);
   }
}
