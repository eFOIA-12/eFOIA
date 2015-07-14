package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.result.c;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DataSourcesResult implements Result, SafeParcelable {
   public static final Creator CREATOR = new c();
   private final int CK;
   private final Status Eb;
   private final List VH;

   DataSourcesResult(int var1, List var2, Status var3) {
      this.CK = var1;
      this.VH = Collections.unmodifiableList(var2);
      this.Eb = var3;
   }

   public DataSourcesResult(List var1, Status var2) {
      this.CK = 3;
      this.VH = Collections.unmodifiableList(var1);
      this.Eb = var2;
   }

   public static DataSourcesResult D(Status var0) {
      return new DataSourcesResult(Collections.emptyList(), var0);
   }

   private boolean b(DataSourcesResult var1) {
      return this.Eb.equals(var1.Eb) && jv.equal(this.VH, var1.VH);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof DataSourcesResult && this.b((DataSourcesResult)var1);
   }

   public List getDataSources() {
      return this.VH;
   }

   public List getDataSources(DataType var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = this.VH.iterator();

      while(var3.hasNext()) {
         DataSource var4 = (DataSource)var3.next();
         if(var4.getDataType().equals(var1)) {
            var2.add(var4);
         }
      }

      return Collections.unmodifiableList(var2);
   }

   public Status getStatus() {
      return this.Eb;
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.Eb, this.VH});
   }

   public String toString() {
      return jv.h(this).a("status", this.Eb).a("dataSets", this.VH).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      c.a(this, var1, var2);
   }
}
