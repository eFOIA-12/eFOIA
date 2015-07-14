package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hm;
import com.google.android.gms.internal.hn;
import java.util.List;

public class hl {
   public static class a implements SafeParcelable {
      public static final hm CREATOR = new hm();
      final int CK;
      public final Account Dc;

      public a() {
         this((Account)null);
      }

      a(int var1, Account var2) {
         this.CK = var1;
         this.Dc = var2;
      }

      public a(Account var1) {
         this(1, var1);
      }

      public int describeContents() {
         hm var1 = CREATOR;
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         hm var3 = CREATOR;
         hm.a(this, var1, var2);
      }
   }

   public static class b implements Result, SafeParcelable {
      public static final hn CREATOR = new hn();
      final int CK;
      public Status Dd;
      public List De;

      public b() {
         this.CK = 1;
      }

      b(int var1, Status var2, List var3) {
         this.CK = var1;
         this.Dd = var2;
         this.De = var3;
      }

      public int describeContents() {
         hn var1 = CREATOR;
         return 0;
      }

      public Status getStatus() {
         return this.Dd;
      }

      public void writeToParcel(Parcel var1, int var2) {
         hn var3 = CREATOR;
         hn.a(this, var1, var2);
      }
   }
}
