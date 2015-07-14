package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawBucket;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.b;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DataReadResult implements Result, SafeParcelable {
   public static final Creator CREATOR = new b();
   private final int CK;
   private final Status Eb;
   private final List Ua;
   private final List Uk;
   private final List Wr;
   private int Ws;
   private final List Wt;

   DataReadResult(int var1, List var2, Status var3, List var4, int var5, List var6, List var7) {
      this.CK = var1;
      this.Eb = var3;
      this.Ws = var5;
      this.Uk = var6;
      this.Wt = var7;
      this.Ua = new ArrayList(var2.size());
      Iterator var8 = var2.iterator();

      while(var8.hasNext()) {
         RawDataSet var9 = (RawDataSet)var8.next();
         this.Ua.add(new DataSet(var9, var6, var7));
      }

      this.Wr = new ArrayList(var4.size());
      var8 = var4.iterator();

      while(var8.hasNext()) {
         RawBucket var10 = (RawBucket)var8.next();
         this.Wr.add(new Bucket(var10, var6, var7));
      }

   }

   public DataReadResult(List var1, List var2, Status var3) {
      this.CK = 5;
      this.Ua = var1;
      this.Eb = var3;
      this.Wr = var2;
      this.Ws = 1;
      this.Uk = new ArrayList();
      this.Wt = new ArrayList();
   }

   public static DataReadResult a(Status var0, DataReadRequest var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = var1.getDataSources().iterator();

      while(var3.hasNext()) {
         var2.add(DataSet.create((DataSource)var3.next()));
      }

      Iterator var4 = var1.getDataTypes().iterator();

      while(var4.hasNext()) {
         DataType var5 = (DataType)var4.next();
         var2.add(DataSet.create((new DataSource.Builder()).setDataType(var5).setType(1).setName("Default").build()));
      }

      return new DataReadResult(var2, Collections.emptyList(), var0);
   }

   private void a(Bucket var1, List var2) {
      Iterator var3 = var2.iterator();

      while(true) {
         if(var3.hasNext()) {
            Bucket var5 = (Bucket)var3.next();
            if(!var5.b(var1)) {
               continue;
            }

            Iterator var4 = var1.getDataSets().iterator();

            while(var4.hasNext()) {
               this.a((DataSet)var4.next(), var5.getDataSets());
            }

            return;
         }

         this.Wr.add(var1);
         return;
      }
   }

   private void a(DataSet var1, List var2) {
      Iterator var3 = var2.iterator();

      DataSet var4;
      do {
         if(!var3.hasNext()) {
            var2.add(var1);
            return;
         }

         var4 = (DataSet)var3.next();
      } while(!var4.getDataSource().equals(var1.getDataSource()));

      var4.a((Iterable)var1.getDataPoints());
   }

   private boolean c(DataReadResult var1) {
      return this.Eb.equals(var1.Eb) && jv.equal(this.Ua, var1.Ua) && jv.equal(this.Wr, var1.Wr);
   }

   public void b(DataReadResult var1) {
      Iterator var2 = var1.getDataSets().iterator();

      while(var2.hasNext()) {
         this.a((DataSet)var2.next(), this.Ua);
      }

      Iterator var3 = var1.getBuckets().iterator();

      while(var3.hasNext()) {
         this.a((Bucket)var3.next(), this.Wr);
      }

   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof DataReadResult && this.c((DataReadResult)var1);
   }

   public List getBuckets() {
      return this.Wr;
   }

   public DataSet getDataSet(DataSource var1) {
      Iterator var2 = this.Ua.iterator();

      DataSet var3;
      do {
         if(!var2.hasNext()) {
            throw new IllegalArgumentException(String.format("Attempting to read data for %s, which was not requested", new Object[]{var1.getStreamIdentifier()}));
         }

         var3 = (DataSet)var2.next();
      } while(!var1.equals(var3.getDataSource()));

      return var3;
   }

   public DataSet getDataSet(DataType var1) {
      Iterator var2 = this.Ua.iterator();

      DataSet var3;
      do {
         if(!var2.hasNext()) {
            throw new IllegalArgumentException(String.format("Attempting to read data for %s, which was not requested", new Object[]{var1.getName()}));
         }

         var3 = (DataSet)var2.next();
      } while(!var1.equals(var3.getDataType()));

      return var3;
   }

   public List getDataSets() {
      return this.Ua;
   }

   public Status getStatus() {
      return this.Eb;
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.Eb, this.Ua, this.Wr});
   }

   List jw() {
      return this.Uk;
   }

   public int kr() {
      return this.Ws;
   }

   List ks() {
      ArrayList var1 = new ArrayList(this.Wr.size());
      Iterator var2 = this.Wr.iterator();

      while(var2.hasNext()) {
         var1.add(new RawBucket((Bucket)var2.next(), this.Uk, this.Wt));
      }

      return var1;
   }

   List kt() {
      ArrayList var1 = new ArrayList(this.Ua.size());
      Iterator var2 = this.Ua.iterator();

      while(var2.hasNext()) {
         var1.add(new RawDataSet((DataSet)var2.next(), this.Uk, this.Wt));
      }

      return var1;
   }

   List ku() {
      return this.Wt;
   }

   public String toString() {
      jv.a var2 = jv.h(this).a("status", this.Eb);
      Object var1;
      if(this.Ua.size() > 5) {
         var1 = this.Ua.size() + " data sets";
      } else {
         var1 = this.Ua;
      }

      var2 = var2.a("dataSets", var1);
      if(this.Wr.size() > 5) {
         var1 = this.Wr.size() + " buckets";
      } else {
         var1 = this.Wr;
      }

      return var2.a("buckets", var1).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      b.a(this, var1, var2);
   }
}
