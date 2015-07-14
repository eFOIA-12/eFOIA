package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.s;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.lt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SessionInsertRequest implements SafeParcelable {
   public static final Creator CREATOR = new s();
   private final int CK;
   private final Session TQ;
   private final List Ua;
   private final List Wh;

   SessionInsertRequest(int var1, Session var2, List var3, List var4) {
      this.CK = var1;
      this.TQ = var2;
      this.Ua = Collections.unmodifiableList(var3);
      this.Wh = Collections.unmodifiableList(var4);
   }

   private SessionInsertRequest(SessionInsertRequest.Builder var1) {
      this.CK = 1;
      this.TQ = var1.TQ;
      this.Ua = Collections.unmodifiableList(var1.Ua);
      this.Wh = Collections.unmodifiableList(var1.Wh);
   }

   // $FF: synthetic method
   SessionInsertRequest(SessionInsertRequest.Builder var1, Object var2) {
      this(var1);
   }

   private boolean a(SessionInsertRequest var1) {
      return jv.equal(this.TQ, var1.TQ) && jv.equal(this.Ua, var1.Ua) && jv.equal(this.Wh, var1.Wh);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof SessionInsertRequest && this.a((SessionInsertRequest)var1);
   }

   public List getAggregateDataPoints() {
      return this.Wh;
   }

   public List getDataSets() {
      return this.Ua;
   }

   public Session getSession() {
      return this.TQ;
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.TQ, this.Ua, this.Wh});
   }

   public String toString() {
      return jv.h(this).a("session", this.TQ).a("dataSets", this.Ua).a("aggregateDataPoints", this.Wh).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      s.a(this, var1, var2);
   }

   public static class Builder {
      private Session TQ;
      private List Ua = new ArrayList();
      private List Wh = new ArrayList();
      private List Wi = new ArrayList();

      private void d(DataPoint var1) {
         this.f(var1);
         this.e(var1);
      }

      private void e(DataPoint var1) {
         long var6 = this.TQ.getStartTime(TimeUnit.NANOSECONDS);
         long var8 = this.TQ.getEndTime(TimeUnit.NANOSECONDS);
         long var10 = var1.getStartTime(TimeUnit.NANOSECONDS);
         long var4 = var1.getEndTime(TimeUnit.NANOSECONDS);
         if(var10 != 0L && var4 != 0L) {
            TimeUnit var13 = TimeUnit.MILLISECONDS;
            long var2 = var4;
            if(var4 > var8) {
               var2 = lt.a(var4, TimeUnit.NANOSECONDS, var13);
            }

            boolean var12;
            if(var10 >= var6 && var2 <= var8) {
               var12 = true;
            } else {
               var12 = false;
            }

            jx.a(var12, "Data point %s has start and end times outside session interval [%d, %d]", new Object[]{var1, Long.valueOf(var6), Long.valueOf(var8)});
            if(var2 != var1.getEndTime(TimeUnit.NANOSECONDS)) {
               Log.w("Fitness", String.format("Data point end time [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", new Object[]{Long.valueOf(var1.getEndTime(TimeUnit.NANOSECONDS)), Long.valueOf(var2), var13}));
               var1.setTimeInterval(var10, var2, TimeUnit.NANOSECONDS);
            }
         }

      }

      private void f(DataPoint var1) {
         long var6 = this.TQ.getStartTime(TimeUnit.NANOSECONDS);
         long var8 = this.TQ.getEndTime(TimeUnit.NANOSECONDS);
         long var4 = var1.getTimestamp(TimeUnit.NANOSECONDS);
         if(var4 != 0L) {
            long var2;
            TimeUnit var11;
            label24: {
               var11 = TimeUnit.MILLISECONDS;
               if(var4 >= var6) {
                  var2 = var4;
                  if(var4 <= var8) {
                     break label24;
                  }
               }

               var2 = lt.a(var4, TimeUnit.NANOSECONDS, var11);
            }

            boolean var10;
            if(var2 >= var6 && var2 <= var8) {
               var10 = true;
            } else {
               var10 = false;
            }

            jx.a(var10, "Data point %s has time stamp outside session interval [%d, %d]", new Object[]{var1, Long.valueOf(var6), Long.valueOf(var8)});
            if(var1.getTimestamp(TimeUnit.NANOSECONDS) != var2) {
               Log.w("Fitness", String.format("Data point timestamp [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", new Object[]{Long.valueOf(var1.getTimestamp(TimeUnit.NANOSECONDS)), Long.valueOf(var2), var11}));
               var1.setTimestamp(var2, TimeUnit.NANOSECONDS);
            }
         }

      }

      private void ki() {
         Iterator var1 = this.Ua.iterator();

         while(var1.hasNext()) {
            Iterator var2 = ((DataSet)var1.next()).getDataPoints().iterator();

            while(var2.hasNext()) {
               this.d((DataPoint)var2.next());
            }
         }

         var1 = this.Wh.iterator();

         while(var1.hasNext()) {
            this.d((DataPoint)var1.next());
         }

      }

      public SessionInsertRequest.Builder addAggregateDataPoint(DataPoint var1) {
         boolean var2;
         if(var1 != null) {
            var2 = true;
         } else {
            var2 = false;
         }

         jx.b(var2, "Must specify a valid aggregate data point.");
         long var3 = var1.getStartTime(TimeUnit.NANOSECONDS);
         long var5 = var1.getEndTime(TimeUnit.NANOSECONDS);
         if(var3 > 0L && var5 > var3) {
            var2 = true;
         } else {
            var2 = false;
         }

         jx.b(var2, "Aggregate data point should have valid start and end times: %s", new Object[]{var1});
         DataSource var7 = var1.getDataSource();
         if(!this.Wi.contains(var7)) {
            var2 = true;
         } else {
            var2 = false;
         }

         jx.a(var2, "Data set/Aggregate data point for this data source %s is already added.", new Object[]{var7});
         this.Wi.add(var7);
         this.Wh.add(var1);
         return this;
      }

      public SessionInsertRequest.Builder addDataSet(DataSet var1) {
         boolean var3 = true;
         boolean var2;
         if(var1 != null) {
            var2 = true;
         } else {
            var2 = false;
         }

         jx.b(var2, "Must specify a valid data set.");
         DataSource var4 = var1.getDataSource();
         if(!this.Wi.contains(var4)) {
            var2 = true;
         } else {
            var2 = false;
         }

         jx.a(var2, "Data set for this data source %s is already added.", new Object[]{var4});
         if(!var1.getDataPoints().isEmpty()) {
            var2 = var3;
         } else {
            var2 = false;
         }

         jx.b(var2, "No data points specified in the input data set.");
         this.Wi.add(var4);
         this.Ua.add(var1);
         return this;
      }

      public SessionInsertRequest build() {
         boolean var2 = true;
         boolean var1;
         if(this.TQ != null) {
            var1 = true;
         } else {
            var1 = false;
         }

         jx.a(var1, "Must specify a valid session.");
         if(this.TQ.getEndTime(TimeUnit.MILLISECONDS) != 0L) {
            var1 = var2;
         } else {
            var1 = false;
         }

         jx.a(var1, "Must specify a valid end time, cannot insert a continuing session.");
         this.ki();
         return new SessionInsertRequest(this, null);
      }

      public SessionInsertRequest.Builder setSession(Session var1) {
         this.TQ = var1;
         return this;
      }
   }
}
