package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.h;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.la;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DataSourcesRequest implements SafeParcelable {
   public static final Creator CREATOR = new h();
   private final int CK;
   private final List TY;
   private final List VS;
   private final boolean VT;

   DataSourcesRequest(int var1, List var2, List var3, boolean var4) {
      this.CK = var1;
      this.TY = var2;
      this.VS = var3;
      this.VT = var4;
   }

   private DataSourcesRequest(DataSourcesRequest.Builder var1) {
      this.CK = 2;
      this.TY = la.b(var1.VU);
      this.VS = Arrays.asList(la.a(var1.VV));
      this.VT = var1.VT;
   }

   // $FF: synthetic method
   DataSourcesRequest(DataSourcesRequest.Builder var1, Object var2) {
      this(var1);
   }

   public int describeContents() {
      return 0;
   }

   public List getDataTypes() {
      return Collections.unmodifiableList(this.TY);
   }

   int getVersionCode() {
      return this.CK;
   }

   public boolean jY() {
      return this.VT;
   }

   List jZ() {
      return this.VS;
   }

   public String toString() {
      jv.a var1 = jv.h(this).a("dataTypes", this.TY).a("sourceTypes", this.VS);
      if(this.VT) {
         var1.a("includeDbOnlySources", "true");
      }

      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      h.a(this, var1, var2);
   }

   public static class Builder {
      private boolean VT = false;
      private DataType[] VU = new DataType[0];
      private int[] VV = new int[]{0, 1};

      public DataSourcesRequest build() {
         boolean var2 = true;
         boolean var1;
         if(this.VU.length > 0) {
            var1 = true;
         } else {
            var1 = false;
         }

         jx.a(var1, "Must add at least one data type");
         if(this.VV.length > 0) {
            var1 = var2;
         } else {
            var1 = false;
         }

         jx.a(var1, "Must add at least one data source type");
         return new DataSourcesRequest(this, null);
      }

      public DataSourcesRequest.Builder setDataSourceTypes(int... var1) {
         this.VV = var1;
         return this;
      }

      public DataSourcesRequest.Builder setDataTypes(DataType... var1) {
         this.VU = var1;
         return this;
      }
   }
}
