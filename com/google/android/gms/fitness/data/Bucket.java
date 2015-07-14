package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawBucket;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.d;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Bucket implements SafeParcelable {
   public static final Creator CREATOR = new d();
   public static final int TYPE_ACTIVITY_SEGMENT = 4;
   public static final int TYPE_ACTIVITY_TYPE = 3;
   public static final int TYPE_SESSION = 2;
   public static final int TYPE_TIME = 1;
   private final int CK;
   private final long LW;
   private final long TO;
   private final Session TQ;
   private final int TZ;
   private final List Ua;
   private final int Ub;
   private boolean Uc;

   Bucket(int var1, long var2, long var4, Session var6, int var7, List var8, int var9, boolean var10) {
      this.Uc = false;
      this.CK = var1;
      this.LW = var2;
      this.TO = var4;
      this.TQ = var6;
      this.TZ = var7;
      this.Ua = var8;
      this.Ub = var9;
      this.Uc = var10;
   }

   public Bucket(RawBucket var1, List var2, List var3) {
      this(2, var1.LW, var1.TO, var1.TQ, var1.UI, a(var1.Ua, var2, var3), var1.Ub, var1.Uc);
   }

   private static List a(List var0, List var1, List var2) {
      ArrayList var3 = new ArrayList(var0.size());
      Iterator var4 = var0.iterator();

      while(var4.hasNext()) {
         var3.add(new DataSet((RawDataSet)var4.next(), var1, var2));
      }

      return var3;
   }

   private boolean a(Bucket var1) {
      return this.LW == var1.LW && this.TO == var1.TO && this.TZ == var1.TZ && jv.equal(this.Ua, var1.Ua) && this.Ub == var1.Ub && this.Uc == var1.Uc;
   }

   public static String cJ(int var0) {
      switch(var0) {
      case 0:
         return "unknown";
      case 1:
         return "time";
      case 2:
         return "session";
      case 3:
         return "type";
      case 4:
         return "segment";
      default:
         return "bug";
      }
   }

   public boolean b(Bucket var1) {
      return this.LW == var1.LW && this.TO == var1.TO && this.TZ == var1.TZ && this.Ub == var1.Ub;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof Bucket && this.a((Bucket)var1);
   }

   public String getActivity() {
      return FitnessActivities.getName(this.TZ);
   }

   public int getBucketType() {
      return this.Ub;
   }

   public DataSet getDataSet(DataType var1) {
      Iterator var2 = this.Ua.iterator();

      DataSet var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (DataSet)var2.next();
      } while(!var3.getDataType().equals(var1));

      return var3;
   }

   public List getDataSets() {
      return this.Ua;
   }

   public long getEndTime(TimeUnit var1) {
      return var1.convert(this.TO, TimeUnit.MILLISECONDS);
   }

   public Session getSession() {
      return this.TQ;
   }

   public long getStartTime(TimeUnit var1) {
      return var1.convert(this.LW, TimeUnit.MILLISECONDS);
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{Long.valueOf(this.LW), Long.valueOf(this.TO), Integer.valueOf(this.TZ), Integer.valueOf(this.Ub)});
   }

   public int jm() {
      return this.TZ;
   }

   public boolean jn() {
      if(this.Uc) {
         return true;
      } else {
         Iterator var1 = this.Ua.iterator();

         do {
            if(!var1.hasNext()) {
               return false;
            }
         } while(!((DataSet)var1.next()).jn());

         return true;
      }
   }

   public long jo() {
      return this.LW;
   }

   public long jp() {
      return this.TO;
   }

   public String toString() {
      return jv.h(this).a("startTime", Long.valueOf(this.LW)).a("endTime", Long.valueOf(this.TO)).a("activity", Integer.valueOf(this.TZ)).a("dataSets", this.Ua).a("bucketType", cJ(this.Ub)).a("serverHasMoreData", Boolean.valueOf(this.Uc)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      d.a(this, var1, var2);
   }
}
