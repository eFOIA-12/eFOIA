package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.request.ag;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;

public class af implements SafeParcelable {
   public static final Creator CREATOR = new ag();
   private final int CK;
   private final Subscription Wo;
   private final boolean Wp;

   af(int var1, Subscription var2, boolean var3) {
      this.CK = var1;
      this.Wo = var2;
      this.Wp = var3;
   }

   private af(af.a var1) {
      this.CK = 1;
      this.Wo = var1.Wo;
      this.Wp = var1.Wp;
   }

   // $FF: synthetic method
   af(af.a var1, Object var2) {
      this(var1);
   }

   public int describeContents() {
      return 0;
   }

   int getVersionCode() {
      return this.CK;
   }

   public Subscription kn() {
      return this.Wo;
   }

   public boolean ko() {
      return this.Wp;
   }

   public String toString() {
      return jv.h(this).a("subscription", this.Wo).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      ag.a(this, var1, var2);
   }

   public static class a {
      private Subscription Wo;
      private boolean Wp = false;

      public af.a b(Subscription var1) {
         this.Wo = var1;
         return this;
      }

      public af kp() {
         boolean var1;
         if(this.Wo != null) {
            var1 = true;
         } else {
            var1 = false;
         }

         jx.a(var1, "Must call setSubscription()");
         return new af(this, null);
      }
   }
}
