package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.result.e;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListSubscriptionsResult implements Result, SafeParcelable {
   public static final Creator CREATOR = new e();
   private final int CK;
   private final Status Eb;
   private final List Wu;

   ListSubscriptionsResult(int var1, List var2, Status var3) {
      this.CK = var1;
      this.Wu = var2;
      this.Eb = var3;
   }

   public ListSubscriptionsResult(List var1, Status var2) {
      this.CK = 3;
      this.Wu = Collections.unmodifiableList(var1);
      this.Eb = (Status)jx.b((Object)var2, "status");
   }

   public static ListSubscriptionsResult F(Status var0) {
      return new ListSubscriptionsResult(Collections.emptyList(), var0);
   }

   private boolean b(ListSubscriptionsResult var1) {
      return this.Eb.equals(var1.Eb) && jv.equal(this.Wu, var1.Wu);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof ListSubscriptionsResult && this.b((ListSubscriptionsResult)var1);
   }

   public Status getStatus() {
      return this.Eb;
   }

   public List getSubscriptions() {
      return this.Wu;
   }

   public List getSubscriptions(DataType var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = this.Wu.iterator();

      while(var3.hasNext()) {
         Subscription var4 = (Subscription)var3.next();
         if(var1.equals(var4.jJ())) {
            var2.add(var4);
         }
      }

      return Collections.unmodifiableList(var2);
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.Eb, this.Wu});
   }

   public String toString() {
      return jv.h(this).a("status", this.Eb).a("subscriptions", this.Wu).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      e.a(this, var1, var2);
   }
}
