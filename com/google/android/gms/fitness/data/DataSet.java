package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawDataPoint;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.fitness.data.f;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class DataSet implements SafeParcelable {
   public static final Creator CREATOR = new f();
   private final int CK;
   private final DataType TM;
   private final DataSource TN;
   private boolean Uc;
   private final List Uj;
   private final List Uk;

   DataSet(int var1, DataSource var2, DataType var3, List var4, List var5, boolean var6) {
      this.Uc = false;
      this.CK = var1;
      this.TN = var2;
      this.TM = var3;
      this.Uc = var6;
      this.Uj = new ArrayList(var4.size());
      if(var1 < 2) {
         var5 = Collections.singletonList(var2);
      }

      this.Uk = var5;
      Iterator var7 = var4.iterator();

      while(var7.hasNext()) {
         RawDataPoint var8 = (RawDataPoint)var7.next();
         this.Uj.add(new DataPoint(this.Uk, var8));
      }

   }

   private DataSet(DataSource var1, DataType var2) {
      this.Uc = false;
      this.CK = 3;
      this.TN = (DataSource)jx.i(var1);
      this.TM = (DataType)jx.i(var2);
      this.Uj = new ArrayList();
      this.Uk = new ArrayList();
      this.Uk.add(this.TN);
   }

   public DataSet(RawDataSet var1, List var2, List var3) {
      this(3, (DataSource)d(var2, var1.UJ), (DataType)d(var3, var1.UL), var1.UM, var2, var1.Uc);
   }

   private boolean a(DataSet var1) {
      return jv.equal(this.TM, var1.TM) && jv.equal(this.TN, var1.TN) && jv.equal(this.Uj, var1.Uj) && this.Uc == var1.Uc;
   }

   public static DataSet create(DataSource var0) {
      jx.b((Object)var0, "DataSource should be specified");
      return new DataSet(var0, var0.getDataType());
   }

   private static Object d(List var0, int var1) {
      return var1 >= 0 && var1 < var0.size()?var0.get(var1):null;
   }

   public void a(Iterable var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         this.b((DataPoint)var2.next());
      }

   }

   public void add(DataPoint var1) {
      DataSource var3 = var1.getDataSource();
      jx.b(var3.getStreamIdentifier().equals(this.TN.getStreamIdentifier()), "Conflicting data sources found %s vs %s", new Object[]{var3, this.TN});
      jx.b(var1.getDataType().getName().equals(this.TM.getName()), "Conflicting data types found %s vs %s", new Object[]{var1.getDataType(), this.TM});
      boolean var2;
      if(var1.getTimestamp(TimeUnit.NANOSECONDS) > 0L) {
         var2 = true;
      } else {
         var2 = false;
      }

      jx.b(var2, "Data point does not have the timestamp set: %s", new Object[]{var1});
      if(var1.getStartTime(TimeUnit.NANOSECONDS) <= var1.getEndTime(TimeUnit.NANOSECONDS)) {
         var2 = true;
      } else {
         var2 = false;
      }

      jx.b(var2, "Data point with start time greater than end time found: %s", new Object[]{var1});
      this.b(var1);
   }

   public void addAll(Iterable var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         this.add((DataPoint)var2.next());
      }

   }

   public void b(DataPoint var1) {
      this.Uj.add(var1);
      DataSource var2 = var1.getOriginalDataSource();
      if(var2 != null && !this.Uk.contains(var2)) {
         this.Uk.add(var2);
      }

   }

   public DataPoint createDataPoint() {
      return DataPoint.create(this.TN);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof DataSet && this.a((DataSet)var1);
   }

   List f(List var1) {
      ArrayList var2 = new ArrayList(this.Uj.size());
      Iterator var3 = this.Uj.iterator();

      while(var3.hasNext()) {
         var2.add(new RawDataPoint((DataPoint)var3.next(), var1));
      }

      return var2;
   }

   public List getDataPoints() {
      return Collections.unmodifiableList(this.Uj);
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
      return jv.hashCode(new Object[]{this.TM, this.TN});
   }

   public boolean jn() {
      return this.Uc;
   }

   List jv() {
      return this.f(this.Uk);
   }

   List jw() {
      return this.Uk;
   }

   public String toString() {
      Object var1 = this.jv();
      String var2 = this.TN.toDebugString();
      if(this.Uj.size() >= 10) {
         var1 = String.format("%d data points, first 5: %s", new Object[]{Integer.valueOf(this.Uj.size()), ((List)var1).subList(0, 5)});
      }

      return String.format("DataSet{%s %s}", new Object[]{var2, var1});
   }

   public void writeToParcel(Parcel var1, int var2) {
      f.a(this, var1, var2);
   }
}
