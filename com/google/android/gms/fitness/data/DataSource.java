package com.google.android.gms.fitness.data;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Device;
import com.google.android.gms.fitness.data.a;
import com.google.android.gms.fitness.data.g;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.mg;

public class DataSource implements SafeParcelable {
   public static final Creator CREATOR = new g();
   public static final String EXTRA_DATA_SOURCE = "vnd.google.fitness.data_source";
   public static final int TYPE_DERIVED = 1;
   public static final int TYPE_RAW = 0;
   private final int CK;
   private final int Gt;
   private final DataType TM;
   private final Device Ul;
   private final a Um;
   private final String Un;
   private final boolean Uo;
   private final String Up;
   private final String mName;

   DataSource(int var1, DataType var2, String var3, int var4, Device var5, a var6, String var7, boolean var8) {
      this.CK = var1;
      this.TM = var2;
      this.Gt = var4;
      this.mName = var3;
      this.Ul = var5;
      this.Um = var6;
      this.Un = var7;
      this.Uo = var8;
      this.Up = this.jy();
   }

   private DataSource(DataSource.Builder var1) {
      this.CK = 3;
      this.TM = var1.TM;
      this.Gt = var1.Gt;
      this.mName = var1.mName;
      this.Ul = var1.Ul;
      this.Um = var1.Um;
      this.Un = var1.Un;
      this.Uo = var1.Uo;
      this.Up = this.jy();
   }

   // $FF: synthetic method
   DataSource(DataSource.Builder var1, Object var2) {
      this(var1);
   }

   private boolean a(DataSource var1) {
      return this.Up.equals(var1.Up);
   }

   public static DataSource extract(Intent var0) {
      return var0 == null?null:(DataSource)com.google.android.gms.common.internal.safeparcel.c.a(var0, "vnd.google.fitness.data_source", CREATOR);
   }

   private String getTypeString() {
      switch(this.Gt) {
      case 0:
         return "raw";
      case 1:
         return "derived";
      default:
         throw new IllegalArgumentException("invalid type value");
      }
   }

   private String jy() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.getTypeString());
      var1.append(":").append(this.TM.getName());
      if(this.Um != null) {
         var1.append(":").append(this.Um.getPackageName());
      }

      if(this.Ul != null) {
         var1.append(":").append(this.Ul.getStreamIdentifier());
      }

      if(this.Un != null) {
         var1.append(":").append(this.Un);
      }

      return var1.toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof DataSource && this.a((DataSource)var1);
   }

   public String getAppPackageName() {
      return this.Um == null?null:this.Um.getPackageName();
   }

   public DataType getDataType() {
      return this.TM;
   }

   public Device getDevice() {
      return this.Ul;
   }

   public String getName() {
      return this.mName;
   }

   public String getStreamIdentifier() {
      return this.Up;
   }

   public String getStreamName() {
      return this.Un;
   }

   public int getType() {
      return this.Gt;
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return this.Up.hashCode();
   }

   public DataSource jA() {
      Device var1;
      if(this.Ul == null) {
         var1 = null;
      } else {
         var1 = this.Ul.jE();
      }

      a var2;
      if(this.Um == null) {
         var2 = null;
      } else {
         var2 = this.Um.jl();
      }

      return new DataSource(3, this.TM, this.mName, this.Gt, var1, var2, mg.bw(this.Un), this.Uo);
   }

   public a jx() {
      return this.Um;
   }

   public boolean jz() {
      return this.Uo;
   }

   public String toDebugString() {
      StringBuilder var2 = new StringBuilder();
      String var1;
      if(this.Gt == 0) {
         var1 = "r";
      } else {
         var1 = "d";
      }

      var2 = var2.append(var1).append(":").append(this.TM.jB());
      if(this.Um == null) {
         var1 = "";
      } else if(this.Um.equals(a.TT)) {
         var1 = ":gms";
      } else {
         var1 = ":" + this.Um.getPackageName();
      }

      var2 = var2.append(var1);
      if(this.Ul != null) {
         var1 = ":" + this.Ul.getModel() + ":" + this.Ul.getUid();
      } else {
         var1 = "";
      }

      var2 = var2.append(var1);
      if(this.Un != null) {
         var1 = ":" + this.Un;
      } else {
         var1 = "";
      }

      return var2.append(var1).toString();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DataSource{");
      var1.append(this.getTypeString());
      if(this.mName != null) {
         var1.append(":").append(this.mName);
      }

      if(this.Um != null) {
         var1.append(":").append(this.Um);
      }

      if(this.Ul != null) {
         var1.append(":").append(this.Ul);
      }

      if(this.Un != null) {
         var1.append(":").append(this.Un);
      }

      var1.append(":").append(this.TM);
      return var1.append("}").toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      g.a(mg.c(this), var1, var2);
   }

   public static final class Builder {
      private int Gt = -1;
      private DataType TM;
      private Device Ul;
      private a Um;
      private String Un = "";
      private boolean Uo = false;
      private String mName;

      public DataSource build() {
         boolean var2 = true;
         boolean var1;
         if(this.TM != null) {
            var1 = true;
         } else {
            var1 = false;
         }

         jx.a(var1, "Must set data type");
         if(this.Gt >= 0) {
            var1 = var2;
         } else {
            var1 = false;
         }

         jx.a(var1, "Must set data source type");
         return new DataSource(this, null);
      }

      public DataSource.Builder setAppPackageName(Context var1) {
         return this.setAppPackageName(var1.getPackageName());
      }

      public DataSource.Builder setAppPackageName(String var1) {
         this.Um = new a(var1, (String)null, (String)null);
         return this;
      }

      public DataSource.Builder setDataType(DataType var1) {
         this.TM = var1;
         return this;
      }

      public DataSource.Builder setDevice(Device var1) {
         this.Ul = var1;
         return this;
      }

      public DataSource.Builder setName(String var1) {
         this.mName = var1;
         return this;
      }

      public DataSource.Builder setObfuscated(boolean var1) {
         this.Uo = var1;
         return this;
      }

      public DataSource.Builder setStreamName(String var1) {
         boolean var2;
         if(var1 != null) {
            var2 = true;
         } else {
            var2 = false;
         }

         jx.b(var2, "Must specify a valid stream name");
         this.Un = var1;
         return this;
      }

      public DataSource.Builder setType(int var1) {
         this.Gt = var1;
         return this;
      }
   }
}
