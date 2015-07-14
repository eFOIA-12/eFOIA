package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.request.p;
import com.google.android.gms.internal.jv;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class o implements SafeParcelable {
   public static final Creator CREATOR = new p();
   private final int CK;
   private final DataType TM;
   private final DataSource TN;
   private final long UQ;
   private final int UR;
   private com.google.android.gms.fitness.data.k VW;
   int VX;
   int VY;
   private final long VZ;
   private final long Wa;
   private final List Wb;
   private final long Wc;
   private final List Wd;
   private final PendingIntent mPendingIntent;

   o(int var1, DataSource var2, DataType var3, IBinder var4, int var5, int var6, long var7, long var9, PendingIntent var11, long var12, int var14, List var15, long var16) {
      this.CK = var1;
      this.TN = var2;
      this.TM = var3;
      com.google.android.gms.fitness.data.k var20;
      if(var4 == null) {
         var20 = null;
      } else {
         var20 = com.google.android.gms.fitness.data.k.aq(var4);
      }

      this.VW = var20;
      long var18 = var7;
      if(var7 == 0L) {
         var18 = (long)var5;
      }

      this.UQ = var18;
      this.Wa = var12;
      var7 = var9;
      if(var9 == 0L) {
         var7 = (long)var6;
      }

      this.VZ = var7;
      this.Wb = var15;
      this.mPendingIntent = var11;
      this.UR = var14;
      this.Wd = Collections.emptyList();
      this.Wc = var16;
   }

   private o(DataSource var1, DataType var2, com.google.android.gms.fitness.data.k var3, PendingIntent var4, long var5, long var7, long var9, int var11, List var12, List var13, long var14) {
      this.CK = 4;
      this.TN = var1;
      this.TM = var2;
      this.VW = var3;
      this.mPendingIntent = var4;
      this.UQ = var5;
      this.Wa = var7;
      this.VZ = var9;
      this.UR = var11;
      this.Wb = var12;
      this.Wd = var13;
      this.Wc = var14;
   }

   public o(SensorRequest var1, com.google.android.gms.fitness.data.k var2, PendingIntent var3) {
      this(var1.getDataSource(), var1.getDataType(), var2, var3, var1.getSamplingRate(TimeUnit.MICROSECONDS), var1.getFastestRate(TimeUnit.MICROSECONDS), var1.getMaxDeliveryLatency(TimeUnit.MICROSECONDS), var1.getAccuracyMode(), (List)null, Collections.emptyList(), var1.kh());
   }

   private boolean a(o var1) {
      return jv.equal(this.TN, var1.TN) && jv.equal(this.TM, var1.TM) && this.UQ == var1.UQ && this.Wa == var1.Wa && this.VZ == var1.VZ && this.UR == var1.UR && jv.equal(this.Wb, var1.Wb);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof o && this.a((o)var1);
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
      return jv.hashCode(new Object[]{this.TN, this.TM, this.VW, Long.valueOf(this.UQ), Long.valueOf(this.Wa), Long.valueOf(this.VZ), Integer.valueOf(this.UR), this.Wb});
   }

   public long jI() {
      return this.UQ;
   }

   public PendingIntent kb() {
      return this.mPendingIntent;
   }

   public long kc() {
      return this.Wa;
   }

   public long kd() {
      return this.VZ;
   }

   public List ke() {
      return this.Wb;
   }

   public long kf() {
      return this.Wc;
   }

   IBinder kg() {
      return this.VW == null?null:this.VW.asBinder();
   }

   public String toString() {
      return String.format("SensorRegistrationRequest{type %s source %s interval %s fastest %s latency %s}", new Object[]{this.TM, this.TN, Long.valueOf(this.UQ), Long.valueOf(this.Wa), Long.valueOf(this.VZ)});
   }

   public void writeToParcel(Parcel var1, int var2) {
      p.a(this, var1, var2);
   }
}
