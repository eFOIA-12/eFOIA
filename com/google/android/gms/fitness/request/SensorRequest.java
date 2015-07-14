package com.google.android.gms.fitness.request;

import android.os.SystemClock;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.location.LocationRequest;
import java.util.concurrent.TimeUnit;

public class SensorRequest {
   public static final int ACCURACY_MODE_DEFAULT = 2;
   public static final int ACCURACY_MODE_HIGH = 3;
   public static final int ACCURACY_MODE_LOW = 1;
   private final DataType TM;
   private final DataSource TN;
   private final long UQ;
   private final int UR;
   private final long VZ;
   private final long Wa;
   private final LocationRequest We;
   private final long Wf;

   private SensorRequest(DataSource var1, LocationRequest var2) {
      this.We = var2;
      this.UQ = TimeUnit.MILLISECONDS.toMicros(var2.getInterval());
      this.Wa = TimeUnit.MILLISECONDS.toMicros(var2.getFastestInterval());
      this.VZ = this.UQ;
      this.TM = var1.getDataType();
      this.UR = a(var2);
      this.TN = var1;
      long var3 = var2.getExpirationTime();
      if(var3 == Long.MAX_VALUE) {
         this.Wf = Long.MAX_VALUE;
      } else {
         this.Wf = TimeUnit.MILLISECONDS.toMicros(var3 - SystemClock.elapsedRealtime());
      }
   }

   private SensorRequest(SensorRequest.Builder var1) {
      this.TN = var1.TN;
      this.TM = var1.TM;
      this.UQ = var1.UQ;
      this.Wa = var1.Wa;
      this.VZ = var1.VZ;
      this.UR = var1.UR;
      this.We = null;
      this.Wf = var1.Wf;
   }

   // $FF: synthetic method
   SensorRequest(SensorRequest.Builder var1, Object var2) {
      this(var1);
   }

   private static int a(LocationRequest var0) {
      switch(var0.getPriority()) {
      case 100:
         return 3;
      case 104:
         return 1;
      default:
         return 2;
      }
   }

   private boolean a(SensorRequest var1) {
      return jv.equal(this.TN, var1.TN) && jv.equal(this.TM, var1.TM) && this.UQ == var1.UQ && this.Wa == var1.Wa && this.VZ == var1.VZ && this.UR == var1.UR && jv.equal(this.We, var1.We) && this.Wf == var1.Wf;
   }

   public static int dl(int var0) {
      int var1 = var0;
      switch(var0) {
      case 2:
      default:
         var1 = 2;
      case 1:
      case 3:
         return var1;
      }
   }

   public static SensorRequest fromLocationRequest(DataSource var0, LocationRequest var1) {
      return new SensorRequest(var0, var1);
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof SensorRequest && this.a((SensorRequest)var1);
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

   public long getFastestRate(TimeUnit var1) {
      return var1.convert(this.Wa, TimeUnit.MICROSECONDS);
   }

   public long getMaxDeliveryLatency(TimeUnit var1) {
      return var1.convert(this.VZ, TimeUnit.MICROSECONDS);
   }

   public long getSamplingRate(TimeUnit var1) {
      return var1.convert(this.UQ, TimeUnit.MICROSECONDS);
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.TN, this.TM, Long.valueOf(this.UQ), Long.valueOf(this.Wa), Long.valueOf(this.VZ), Integer.valueOf(this.UR), this.We, Long.valueOf(this.Wf)});
   }

   public long kh() {
      return this.Wf;
   }

   public String toString() {
      return jv.h(this).a("dataSource", this.TN).a("dataType", this.TM).a("samplingRateMicros", Long.valueOf(this.UQ)).a("deliveryLatencyMicros", Long.valueOf(this.VZ)).a("timeOutMicros", Long.valueOf(this.Wf)).toString();
   }

   public static class Builder {
      private DataType TM;
      private DataSource TN;
      private long UQ = -1L;
      private int UR = 2;
      private long VZ = 0L;
      private long Wa = 0L;
      private long Wf = Long.MAX_VALUE;
      private boolean Wg = false;

      public SensorRequest build() {
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
         return new SensorRequest(this, null);
      }

      public SensorRequest.Builder setAccuracyMode(int var1) {
         this.UR = SensorRequest.dl(var1);
         return this;
      }

      public SensorRequest.Builder setDataSource(DataSource var1) {
         this.TN = var1;
         return this;
      }

      public SensorRequest.Builder setDataType(DataType var1) {
         this.TM = var1;
         return this;
      }

      public SensorRequest.Builder setFastestRate(int var1, TimeUnit var2) {
         boolean var3;
         if(var1 >= 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         jx.b(var3, "Cannot use a negative interval");
         this.Wg = true;
         this.Wa = var2.toMicros((long)var1);
         return this;
      }

      public SensorRequest.Builder setMaxDeliveryLatency(int var1, TimeUnit var2) {
         boolean var3;
         if(var1 >= 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         jx.b(var3, "Cannot use a negative delivery interval");
         this.VZ = var2.toMicros((long)var1);
         return this;
      }

      public SensorRequest.Builder setSamplingRate(long var1, TimeUnit var3) {
         boolean var4;
         if(var1 >= 0L) {
            var4 = true;
         } else {
            var4 = false;
         }

         jx.b(var4, "Cannot use a negative sampling interval");
         this.UQ = var3.toMicros(var1);
         if(!this.Wg) {
            this.Wa = this.UQ / 2L;
         }

         return this;
      }

      public SensorRequest.Builder setTimeout(long var1, TimeUnit var3) {
         boolean var5 = true;
         boolean var4;
         if(var1 > 0L) {
            var4 = true;
         } else {
            var4 = false;
         }

         jx.b(var4, "Invalid time out value specified: %d", new Object[]{Long.valueOf(var1)});
         if(var3 != null) {
            var4 = var5;
         } else {
            var4 = false;
         }

         jx.b(var4, "Invalid time unit specified");
         this.Wf = var3.toMicros(var1);
         return this;
      }
   }
}
