package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.data.RawDataPoint;
import com.google.android.gms.fitness.data.Value;
import com.google.android.gms.fitness.data.e;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.lt;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class DataPoint implements SafeParcelable {
   public static final Creator CREATOR = new e();
   private final int CK;
   private final DataSource TN;
   private long Ud;
   private long Ue;
   private final Value[] Uf;
   private DataSource Ug;
   private long Uh;
   private long Ui;

   DataPoint(int var1, DataSource var2, long var3, long var5, Value[] var7, DataSource var8, long var9, long var11) {
      this.CK = var1;
      this.TN = var2;
      this.Ug = var8;
      this.Ud = var3;
      this.Ue = var5;
      this.Uf = var7;
      this.Uh = var9;
      this.Ui = var11;
   }

   private DataPoint(DataSource var1) {
      this.CK = 4;
      this.TN = (DataSource)jx.b((Object)var1, "Data source cannot be null");
      List var4 = var1.getDataType().getFields();
      this.Uf = new Value[var4.size()];
      Iterator var5 = var4.iterator();

      for(int var2 = 0; var5.hasNext(); ++var2) {
         Field var3 = (Field)var5.next();
         this.Uf[var2] = new Value(var3.getFormat());
      }

   }

   DataPoint(List var1, RawDataPoint var2) {
      this(4, c(var1, var2.UJ), var2.Ud, var2.Ue, var2.Uf, c(var1, var2.UK), var2.Uh, var2.Ui);
   }

   private boolean a(DataPoint var1) {
      return jv.equal(this.TN, var1.TN) && this.Ud == var1.Ud && this.Ue == var1.Ue && Arrays.equals(this.Uf, var1.Uf) && jv.equal(this.Ug, var1.Ug);
   }

   private static DataSource c(List var0, int var1) {
      return var1 >= 0 && var1 < var0.size()?(DataSource)var0.get(var1):null;
   }

   private void cL(int var1) {
      List var4 = this.getDataType().getFields();
      int var2 = var4.size();
      boolean var3;
      if(var1 == var2) {
         var3 = true;
      } else {
         var3 = false;
      }

      jx.b(var3, "Attempting to insert %s values, but needed %s: %s", new Object[]{Integer.valueOf(var1), Integer.valueOf(var2), var4});
   }

   public static DataPoint create(DataSource var0) {
      return new DataPoint(var0);
   }

   public static DataPoint extract(Intent var0) {
      return var0 == null?null:(DataPoint)com.google.android.gms.common.internal.safeparcel.c.a(var0, "com.google.android.gms.fitness.EXTRA_DATA_POINT", CREATOR);
   }

   private boolean jq() {
      return this.getDataType() == DataType.TYPE_LOCATION_SAMPLE;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof DataPoint && this.a((DataPoint)var1);
   }

   public DataSource getDataSource() {
      return this.TN;
   }

   public DataType getDataType() {
      return this.TN.getDataType();
   }

   public long getEndTime(TimeUnit var1) {
      return var1.convert(this.Ud, TimeUnit.NANOSECONDS);
   }

   public DataSource getOriginalDataSource() {
      return this.Ug;
   }

   public long getStartTime(TimeUnit var1) {
      return var1.convert(this.Ue, TimeUnit.NANOSECONDS);
   }

   public long getTimestamp(TimeUnit var1) {
      return var1.convert(this.Ud, TimeUnit.NANOSECONDS);
   }

   public long getTimestampNanos() {
      return this.Ud;
   }

   public Value getValue(Field var1) {
      int var2 = this.getDataType().indexOf(var1);
      return this.Uf[var2];
   }

   public int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.TN, Long.valueOf(this.Ud), Long.valueOf(this.Ue)});
   }

   public Value[] jr() {
      return this.Uf;
   }

   public long js() {
      return this.Uh;
   }

   public long jt() {
      return this.Ui;
   }

   public long ju() {
      return this.Ue;
   }

   public DataPoint setFloatValues(float... var1) {
      this.cL(var1.length);

      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.Uf[var2].setFloat(var1[var2]);
      }

      return this;
   }

   public DataPoint setIntValues(int... var1) {
      this.cL(var1.length);

      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.Uf[var2].setInt(var1[var2]);
      }

      return this;
   }

   public DataPoint setTimeInterval(long var1, long var3, TimeUnit var5) {
      this.Ue = var5.toNanos(var1);
      this.Ud = var5.toNanos(var3);
      return this;
   }

   public DataPoint setTimestamp(long var1, TimeUnit var3) {
      this.Ud = var3.toNanos(var1);
      if(this.jq() && lt.a(var3)) {
         Log.w("Fitness", "Storing location at more than millisecond granularity is not supported. Extra precision is lost as the value is converted to milliseconds.");
         this.Ud = lt.a(this.Ud, TimeUnit.NANOSECONDS, TimeUnit.MILLISECONDS);
      }

      return this;
   }

   public String toString() {
      return String.format("DataPoint{%s@[%s, %s,raw=%s,insert=%s](%s %s)}", new Object[]{Arrays.toString(this.Uf), Long.valueOf(this.Ue), Long.valueOf(this.Ud), Long.valueOf(this.Uh), Long.valueOf(this.Ui), this.TN, this.Ug});
   }

   public void writeToParcel(Parcel var1, int var2) {
      e.a(this, var1, var2);
   }
}
