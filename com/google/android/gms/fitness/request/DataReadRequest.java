package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.g;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataReadRequest implements SafeParcelable {
   public static final Creator CREATOR = new g();
   public static final int NO_LIMIT = 0;
   private final int CK;
   private final long LW;
   private final long TO;
   private final List TY;
   private final int Ub;
   private final List VH;
   private final List VL;
   private final List VM;
   private final long VN;
   private final DataSource VO;
   private final int VP;
   private final boolean VQ;
   private final boolean VR;

   DataReadRequest(int var1, List var2, List var3, long var4, long var6, List var8, List var9, int var10, long var11, DataSource var13, int var14, boolean var15, boolean var16) {
      this.CK = var1;
      this.TY = Collections.unmodifiableList(var2);
      this.VH = Collections.unmodifiableList(var3);
      this.LW = var4;
      this.TO = var6;
      this.VL = Collections.unmodifiableList(var8);
      this.VM = Collections.unmodifiableList(var9);
      this.Ub = var10;
      this.VN = var11;
      this.VO = var13;
      this.VP = var14;
      this.VQ = var15;
      this.VR = var16;
   }

   private DataReadRequest(DataReadRequest.Builder var1) {
      this.CK = 2;
      this.TY = Collections.unmodifiableList(var1.TY);
      this.VH = Collections.unmodifiableList(var1.VH);
      this.LW = var1.LW;
      this.TO = var1.TO;
      this.VL = Collections.unmodifiableList(var1.VL);
      this.VM = Collections.unmodifiableList(var1.VM);
      this.Ub = var1.Ub;
      this.VN = var1.VN;
      this.VO = var1.VO;
      this.VP = var1.VP;
      this.VQ = var1.VQ;
      this.VR = var1.VR;
   }

   // $FF: synthetic method
   DataReadRequest(DataReadRequest.Builder var1, Object var2) {
      this(var1);
   }

   private boolean a(DataReadRequest var1) {
      return this.TY.equals(var1.TY) && this.VH.equals(var1.VH) && this.LW == var1.LW && this.TO == var1.TO && this.Ub == var1.Ub && this.VM.equals(var1.VM) && this.VL.equals(var1.VL) && jv.equal(this.VO, var1.VO) && this.VN == var1.VN && this.VR == var1.VR;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof DataReadRequest && this.a((DataReadRequest)var1);
   }

   public DataSource getActivityDataSource() {
      return this.VO;
   }

   public List getAggregatedDataSources() {
      return this.VM;
   }

   public List getAggregatedDataTypes() {
      return this.VL;
   }

   public long getBucketDuration(TimeUnit var1) {
      return var1.convert(this.VN, TimeUnit.MILLISECONDS);
   }

   public int getBucketType() {
      return this.Ub;
   }

   public List getDataSources() {
      return this.VH;
   }

   public List getDataTypes() {
      return this.TY;
   }

   public long getEndTime(TimeUnit var1) {
      return var1.convert(this.TO, TimeUnit.MILLISECONDS);
   }

   public int getLimit() {
      return this.VP;
   }

   public long getStartTime(TimeUnit var1) {
      return var1.convert(this.LW, TimeUnit.MILLISECONDS);
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{Integer.valueOf(this.Ub), Long.valueOf(this.LW), Long.valueOf(this.TO)});
   }

   public boolean jV() {
      return this.VR;
   }

   public boolean jW() {
      return this.VQ;
   }

   public long jX() {
      return this.VN;
   }

   public long jo() {
      return this.LW;
   }

   public long jp() {
      return this.TO;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("DataReadRequest{");
      Iterator var2;
      if(!this.TY.isEmpty()) {
         var2 = this.TY.iterator();

         while(var2.hasNext()) {
            var1.append(((DataType)var2.next()).jB()).append(" ");
         }
      }

      if(!this.VH.isEmpty()) {
         var2 = this.VH.iterator();

         while(var2.hasNext()) {
            var1.append(((DataSource)var2.next()).toDebugString()).append(" ");
         }
      }

      if(this.Ub != 0) {
         var1.append("bucket by ").append(Bucket.cJ(this.Ub));
         if(this.VN > 0L) {
            var1.append(" >").append(this.VN).append("ms");
         }

         var1.append(": ");
      }

      if(!this.VL.isEmpty()) {
         var2 = this.VL.iterator();

         while(var2.hasNext()) {
            var1.append(((DataType)var2.next()).jB()).append(" ");
         }
      }

      if(!this.VM.isEmpty()) {
         var2 = this.VM.iterator();

         while(var2.hasNext()) {
            var1.append(((DataSource)var2.next()).toDebugString()).append(" ");
         }
      }

      var1.append(String.format("(%tF %tT - %tF %tT)", new Object[]{Long.valueOf(this.LW), Long.valueOf(this.LW), Long.valueOf(this.TO), Long.valueOf(this.TO)}));
      if(this.VO != null) {
         var1.append("activities: ").append(this.VO.toDebugString());
      }

      if(this.VR) {
         var1.append(" +server");
      }

      var1.append("}");
      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      g.a(this, var1, var2);
   }

   public static class Builder {
      private long LW;
      private long TO;
      private List TY = new ArrayList();
      private int Ub = 0;
      private List VH = new ArrayList();
      private List VL = new ArrayList();
      private List VM = new ArrayList();
      private long VN = 0L;
      private DataSource VO;
      private int VP = 0;
      private boolean VQ = false;
      private boolean VR = false;

      public DataReadRequest.Builder aggregate(DataSource var1, DataType var2) {
         jx.b((Object)var1, "Attempting to add a null data source");
         boolean var3;
         if(!this.VH.contains(var1)) {
            var3 = true;
         } else {
            var3 = false;
         }

         jx.a(var3, "Cannot add the same data source for aggregated and detailed");
         DataType var4 = var1.getDataType();
         jx.b(DataType.AGGREGATE_INPUT_TYPES.contains(var4), "Unsupported input data type specified for aggregation: %s", new Object[]{var4});
         jx.b(DataType.getAggregatesForInput(var4).contains(var2), "Invalid output aggregate data type specified: %s -> %s", new Object[]{var4, var2});
         if(!this.VM.contains(var1)) {
            this.VM.add(var1);
         }

         return this;
      }

      public DataReadRequest.Builder aggregate(DataType var1, DataType var2) {
         jx.b((Object)var1, "Attempting to use a null data type");
         boolean var3;
         if(!this.TY.contains(var1)) {
            var3 = true;
         } else {
            var3 = false;
         }

         jx.a(var3, "Cannot add the same data type as aggregated and detailed");
         jx.b(DataType.AGGREGATE_INPUT_TYPES.contains(var1), "Unsupported input data type specified for aggregation: %s", new Object[]{var1});
         jx.b(DataType.getAggregatesForInput(var1).contains(var2), "Invalid output aggregate data type specified: %s -> %s", new Object[]{var1, var2});
         if(!this.VL.contains(var1)) {
            this.VL.add(var1);
         }

         return this;
      }

      public DataReadRequest.Builder bucketByActivitySegment(int var1, TimeUnit var2) {
         boolean var3;
         if(this.Ub == 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         jx.b(var3, "Bucketing strategy already set to %s", new Object[]{Integer.valueOf(this.Ub)});
         if(var1 > 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         jx.b(var3, "Must specify a valid minimum duration for an activity segment: %d", new Object[]{Integer.valueOf(var1)});
         this.Ub = 4;
         this.VN = var2.toMillis((long)var1);
         return this;
      }

      public DataReadRequest.Builder bucketByActivitySegment(int var1, TimeUnit var2, DataSource var3) {
         boolean var4;
         if(this.Ub == 0) {
            var4 = true;
         } else {
            var4 = false;
         }

         jx.b(var4, "Bucketing strategy already set to %s", new Object[]{Integer.valueOf(this.Ub)});
         if(var1 > 0) {
            var4 = true;
         } else {
            var4 = false;
         }

         jx.b(var4, "Must specify a valid minimum duration for an activity segment: %d", new Object[]{Integer.valueOf(var1)});
         if(var3 != null) {
            var4 = true;
         } else {
            var4 = false;
         }

         jx.b(var4, "Invalid activity data source specified");
         jx.b(var3.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", new Object[]{var3});
         this.VO = var3;
         this.Ub = 4;
         this.VN = var2.toMillis((long)var1);
         return this;
      }

      public DataReadRequest.Builder bucketByActivityType(int var1, TimeUnit var2) {
         boolean var3;
         if(this.Ub == 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         jx.b(var3, "Bucketing strategy already set to %s", new Object[]{Integer.valueOf(this.Ub)});
         if(var1 > 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         jx.b(var3, "Must specify a valid minimum duration for an activity segment: %d", new Object[]{Integer.valueOf(var1)});
         this.Ub = 3;
         this.VN = var2.toMillis((long)var1);
         return this;
      }

      public DataReadRequest.Builder bucketByActivityType(int var1, TimeUnit var2, DataSource var3) {
         boolean var4;
         if(this.Ub == 0) {
            var4 = true;
         } else {
            var4 = false;
         }

         jx.b(var4, "Bucketing strategy already set to %s", new Object[]{Integer.valueOf(this.Ub)});
         if(var1 > 0) {
            var4 = true;
         } else {
            var4 = false;
         }

         jx.b(var4, "Must specify a valid minimum duration for an activity segment: %d", new Object[]{Integer.valueOf(var1)});
         if(var3 != null) {
            var4 = true;
         } else {
            var4 = false;
         }

         jx.b(var4, "Invalid activity data source specified");
         jx.b(var3.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", new Object[]{var3});
         this.VO = var3;
         this.Ub = 3;
         this.VN = var2.toMillis((long)var1);
         return this;
      }

      public DataReadRequest.Builder bucketBySession(int var1, TimeUnit var2) {
         boolean var3;
         if(this.Ub == 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         jx.b(var3, "Bucketing strategy already set to %s", new Object[]{Integer.valueOf(this.Ub)});
         if(var1 > 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         jx.b(var3, "Must specify a valid minimum duration for an activity segment: %d", new Object[]{Integer.valueOf(var1)});
         this.Ub = 2;
         this.VN = var2.toMillis((long)var1);
         return this;
      }

      public DataReadRequest.Builder bucketByTime(int var1, TimeUnit var2) {
         boolean var3;
         if(this.Ub == 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         jx.b(var3, "Bucketing strategy already set to %s", new Object[]{Integer.valueOf(this.Ub)});
         if(var1 > 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         jx.b(var3, "Must specify a valid minimum duration for an activity segment: %d", new Object[]{Integer.valueOf(var1)});
         this.Ub = 1;
         this.VN = var2.toMillis((long)var1);
         return this;
      }

      public DataReadRequest build() {
         boolean var3 = true;
         boolean var2;
         if(this.VH.isEmpty() && this.TY.isEmpty() && this.VM.isEmpty() && this.VL.isEmpty()) {
            var2 = false;
         } else {
            var2 = true;
         }

         jx.a(var2, "Must add at least one data source (aggregated or detailed)");
         if(this.LW > 0L) {
            var2 = true;
         } else {
            var2 = false;
         }

         jx.a(var2, "Invalid start time: %s", new Object[]{Long.valueOf(this.LW)});
         if(this.TO > 0L && this.TO > this.LW) {
            var2 = true;
         } else {
            var2 = false;
         }

         jx.a(var2, "Invalid end time: %s", new Object[]{Long.valueOf(this.TO)});
         boolean var1;
         if(this.VM.isEmpty() && this.VL.isEmpty()) {
            var1 = true;
         } else {
            var1 = false;
         }

         label57: {
            if(var1) {
               var2 = var3;
               if(this.Ub == 0) {
                  break label57;
               }
            }

            if(!var1 && this.Ub != 0) {
               var2 = var3;
            } else {
               var2 = false;
            }
         }

         jx.a(var2, "Must specify a valid bucketing strategy while requesting aggregation");
         return new DataReadRequest(this, null);
      }

      public DataReadRequest.Builder enableServerQueries() {
         this.VR = true;
         return this;
      }

      public DataReadRequest.Builder read(DataSource var1) {
         jx.b((Object)var1, "Attempting to add a null data source");
         boolean var2;
         if(!this.VM.contains(var1)) {
            var2 = true;
         } else {
            var2 = false;
         }

         jx.b(var2, "Cannot add the same data source as aggregated and detailed");
         if(!this.VH.contains(var1)) {
            this.VH.add(var1);
         }

         return this;
      }

      public DataReadRequest.Builder read(DataType var1) {
         jx.b((Object)var1, "Attempting to use a null data type");
         boolean var2;
         if(!this.VL.contains(var1)) {
            var2 = true;
         } else {
            var2 = false;
         }

         jx.a(var2, "Cannot add the same data type as aggregated and detailed");
         if(!this.TY.contains(var1)) {
            this.TY.add(var1);
         }

         return this;
      }

      public DataReadRequest.Builder setLimit(int var1) {
         boolean var2;
         if(var1 > 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         jx.b(var2, "Invalid limit %d is specified", new Object[]{Integer.valueOf(var1)});
         this.VP = var1;
         return this;
      }

      public DataReadRequest.Builder setTimeRange(long var1, long var3, TimeUnit var5) {
         this.LW = var5.toMillis(var1);
         this.TO = var5.toMillis(var3);
         return this;
      }
   }
}
