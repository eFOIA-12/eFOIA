package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.s;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;

public class Subscription implements SafeParcelable {
   public static final Creator CREATOR = new s();
   private final int CK;
   private final DataType TM;
   private final DataSource TN;
   private final long UQ;
   private final int UR;

   Subscription(int var1, DataSource var2, DataType var3, long var4, int var6) {
      this.CK = var1;
      this.TN = var2;
      this.TM = var3;
      this.UQ = var4;
      this.UR = var6;
   }

   private Subscription(Subscription.a var1) {
      this.CK = 1;
      this.TM = var1.TM;
      this.TN = var1.TN;
      this.UQ = var1.UQ;
      this.UR = var1.UR;
   }

   // $FF: synthetic method
   Subscription(Subscription.a var1, Object var2) {
      this(var1);
   }

   private boolean a(Subscription var1) {
      return jv.equal(this.TN, var1.TN) && jv.equal(this.TM, var1.TM) && this.UQ == var1.UQ && this.UR == var1.UR;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof Subscription && this.a((Subscription)var1);
   }

   public int getAccuracyMode() {
      return this.UR;
   }

   public DataSource getDataSource() {
      return this.TN;
   }

   public DataType getDataType() {
      return this.TM;
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.TN, this.TN, Long.valueOf(this.UQ), Integer.valueOf(this.UR)});
   }

   public long jI() {
      return this.UQ;
   }

   public DataType jJ() {
      return this.TM == null?this.TN.getDataType():this.TM;
   }

   public String toDebugString() {
      String var1;
      if(this.TN == null) {
         var1 = this.TM.getName();
      } else {
         var1 = this.TN.toDebugString();
      }

      return String.format("Subscription{%s}", new Object[]{var1});
   }

   public String toString() {
      return jv.h(this).a("dataSource", this.TN).a("dataType", this.TM).a("samplingIntervalMicros", Long.valueOf(this.UQ)).a("accuracyMode", Integer.valueOf(this.UR)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      s.a(this, var1, var2);
   }

   public static class a {
      private DataType TM;
      private DataSource TN;
      private long UQ = -1L;
      private int UR = 2;

      public Subscription.a b(DataSource var1) {
         this.TN = var1;
         return this;
      }

      public Subscription.a b(DataType var1) {
         this.TM = var1;
         return this;
      }

      public Subscription jK() {
         boolean var2 = false;
         boolean var1;
         if(this.TN == null && this.TM == null) {
            var1 = false;
         } else {
            var1 = true;
         }

         label17: {
            jx.a(var1, "Must call setDataSource() or setDataType()");
            if(this.TM != null && this.TN != null) {
               var1 = var2;
               if(!this.TM.equals(this.TN.getDataType())) {
                  break label17;
               }
            }

            var1 = true;
         }

         jx.a(var1, "Specified data type is incompatible with specified data source");
         return new Subscription(this, null);
      }
   }
}
