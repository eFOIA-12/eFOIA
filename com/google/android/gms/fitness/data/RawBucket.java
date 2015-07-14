package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.m;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class RawBucket implements SafeParcelable {
   public static final Creator CREATOR = new m();
   final int CK;
   final long LW;
   final long TO;
   final Session TQ;
   final int UI;
   final List Ua;
   final int Ub;
   final boolean Uc;

   RawBucket(int var1, long var2, long var4, Session var6, int var7, List var8, int var9, boolean var10) {
      this.CK = var1;
      this.LW = var2;
      this.TO = var4;
      this.TQ = var6;
      this.UI = var7;
      this.Ua = var8;
      this.Ub = var9;
      this.Uc = var10;
   }

   public RawBucket(Bucket var1, List var2, List var3) {
      this.CK = 2;
      this.LW = var1.getStartTime(TimeUnit.MILLISECONDS);
      this.TO = var1.getEndTime(TimeUnit.MILLISECONDS);
      this.TQ = var1.getSession();
      this.UI = var1.jm();
      this.Ub = var1.getBucketType();
      this.Uc = var1.jn();
      List var5 = var1.getDataSets();
      this.Ua = new ArrayList(var5.size());
      Iterator var6 = var5.iterator();

      while(var6.hasNext()) {
         DataSet var4 = (DataSet)var6.next();
         this.Ua.add(new RawDataSet(var4, var2, var3));
      }

   }

   private boolean a(RawBucket var1) {
      return this.LW == var1.LW && this.TO == var1.TO && this.UI == var1.UI && jv.equal(this.Ua, var1.Ua) && this.Ub == var1.Ub && this.Uc == var1.Uc;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof RawBucket && this.a((RawBucket)var1);
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{Long.valueOf(this.LW), Long.valueOf(this.TO), Integer.valueOf(this.Ub)});
   }

   public String toString() {
      return jv.h(this).a("startTime", Long.valueOf(this.LW)).a("endTime", Long.valueOf(this.TO)).a("activity", Integer.valueOf(this.UI)).a("dataSets", this.Ua).a("bucketType", Integer.valueOf(this.Ub)).a("serverHasMoreData", Boolean.valueOf(this.Uc)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      m.a(this, var1, var2);
   }
}
