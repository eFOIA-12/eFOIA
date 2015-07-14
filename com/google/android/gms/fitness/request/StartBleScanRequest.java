package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.a;
import com.google.android.gms.fitness.request.ac;
import com.google.android.gms.fitness.request.l;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.la;
import java.util.Collections;
import java.util.List;

public class StartBleScanRequest implements SafeParcelable {
   public static final Creator CREATOR = new ac();
   private final int CK;
   private final List TY;
   private final l Wm;
   private final int Wn;

   StartBleScanRequest(int var1, List var2, IBinder var3, int var4) {
      this.CK = var1;
      this.TY = var2;
      this.Wm = l.a.aB(var3);
      this.Wn = var4;
   }

   private StartBleScanRequest(StartBleScanRequest.Builder var1) {
      this.CK = 2;
      this.TY = la.b(var1.VU);
      this.Wm = var1.Wm;
      this.Wn = var1.Wn;
   }

   // $FF: synthetic method
   StartBleScanRequest(StartBleScanRequest.Builder var1, Object var2) {
      this(var1);
   }

   public int describeContents() {
      return 0;
   }

   public List getDataTypes() {
      return Collections.unmodifiableList(this.TY);
   }

   public int getTimeoutSecs() {
      return this.Wn;
   }

   int getVersionCode() {
      return this.CK;
   }

   public IBinder km() {
      return this.Wm.asBinder();
   }

   public String toString() {
      return jv.h(this).a("dataTypes", this.TY).a("timeoutSecs", Integer.valueOf(this.Wn)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      ac.a(this, var1, var2);
   }

   public static class Builder {
      private DataType[] VU = new DataType[0];
      private l Wm;
      private int Wn = 10;

      public StartBleScanRequest.Builder a(l var1) {
         this.Wm = var1;
         return this;
      }

      public StartBleScanRequest build() {
         boolean var1;
         if(this.Wm != null) {
            var1 = true;
         } else {
            var1 = false;
         }

         jx.a(var1, "Must set BleScanCallback");
         return new StartBleScanRequest(this, null);
      }

      public StartBleScanRequest.Builder setBleScanCallback(BleScanCallback var1) {
         this.a((l)a.a.jP().a(var1));
         return this;
      }

      public StartBleScanRequest.Builder setDataTypes(DataType... var1) {
         this.VU = var1;
         return this;
      }

      public StartBleScanRequest.Builder setTimeoutSecs(int var1) {
         boolean var3 = true;
         boolean var2;
         if(var1 > 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         jx.b(var2, "Stop time must be greater than zero");
         if(var1 <= 60) {
            var2 = var3;
         } else {
            var2 = false;
         }

         jx.b(var2, "Stop time must be less than 1 minute");
         this.Wn = var1;
         return this;
      }
   }
}
