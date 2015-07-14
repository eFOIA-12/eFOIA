package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.x;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import java.util.concurrent.TimeUnit;

public class w implements SafeParcelable {
   public static final Creator CREATOR = new x();
   private final int CK;
   private final Session TQ;

   w(int var1, Session var2) {
      this.CK = var1;
      this.TQ = var2;
   }

   private w(w.a var1) {
      this.CK = 1;
      this.TQ = var1.TQ;
   }

   // $FF: synthetic method
   w(w.a var1, Object var2) {
      this(var1);
   }

   private boolean a(w var1) {
      return jv.equal(this.TQ, var1.TQ);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof w && this.a((w)var1);
   }

   public Session getSession() {
      return this.TQ;
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.TQ});
   }

   public String toString() {
      return jv.h(this).a("session", this.TQ).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      x.a(this, var1, var2);
   }

   public static class a {
      private Session TQ;

      public w.a b(Session var1) {
         boolean var2;
         if(var1.getEndTime(TimeUnit.MILLISECONDS) == 0L) {
            var2 = true;
         } else {
            var2 = false;
         }

         jx.b(var2, "Cannot start a session which has already ended");
         this.TQ = var1;
         return this;
      }

      public w kk() {
         return new w(this, null);
      }
   }
}
