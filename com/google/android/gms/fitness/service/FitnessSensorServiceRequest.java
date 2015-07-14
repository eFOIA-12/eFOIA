package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.k;
import com.google.android.gms.fitness.service.SensorEventDispatcher;
import com.google.android.gms.fitness.service.a;
import com.google.android.gms.fitness.service.b;
import com.google.android.gms.internal.jv;
import java.util.concurrent.TimeUnit;

public class FitnessSensorServiceRequest implements SafeParcelable {
   public static final Creator CREATOR = new a();
   public static final int UNSPECIFIED = -1;
   private final int CK;
   private final DataSource TN;
   private final k VW;
   private final long Wy;
   private final long Wz;

   FitnessSensorServiceRequest(int var1, DataSource var2, IBinder var3, long var4, long var6) {
      this.CK = var1;
      this.TN = var2;
      this.VW = k.a.aq(var3);
      this.Wy = var4;
      this.Wz = var6;
   }

   private boolean a(FitnessSensorServiceRequest var1) {
      return jv.equal(this.TN, var1.TN) && this.Wy == var1.Wy && this.Wz == var1.Wz;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof FitnessSensorServiceRequest && this.a((FitnessSensorServiceRequest)var1);
   }

   public long getBatchInterval(TimeUnit var1) {
      return var1.convert(this.Wz, TimeUnit.MICROSECONDS);
   }

   public DataSource getDataSource() {
      return this.TN;
   }

   public SensorEventDispatcher getDispatcher() {
      return new b(this.VW);
   }

   public long getSamplingRate(TimeUnit var1) {
      return this.Wy == -1L?-1L:var1.convert(this.Wy, TimeUnit.MICROSECONDS);
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.TN, Long.valueOf(this.Wy), Long.valueOf(this.Wz)});
   }

   public long jI() {
      return this.Wy;
   }

   IBinder kg() {
      return this.VW.asBinder();
   }

   public long kx() {
      return this.Wz;
   }

   public String toString() {
      return String.format("FitnessSensorServiceRequest{%s}", new Object[]{this.TN});
   }

   public void writeToParcel(Parcel var1, int var2) {
      a.a(this, var1, var2);
   }
}
