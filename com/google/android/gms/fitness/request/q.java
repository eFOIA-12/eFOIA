package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.r;

public class q implements SafeParcelable {
   public static final Creator CREATOR = new r();
   private final int CK;
   private final com.google.android.gms.fitness.data.k VW;
   private final PendingIntent mPendingIntent;

   q(int var1, IBinder var2, PendingIntent var3) {
      this.CK = var1;
      com.google.android.gms.fitness.data.k var4;
      if(var2 == null) {
         var4 = null;
      } else {
         var4 = com.google.android.gms.fitness.data.k.aq(var2);
      }

      this.VW = var4;
      this.mPendingIntent = var3;
   }

   public q(com.google.android.gms.fitness.data.k var1, PendingIntent var2) {
      this.CK = 2;
      this.VW = var1;
      this.mPendingIntent = var2;
   }

   public int describeContents() {
      return 0;
   }

   int getVersionCode() {
      return this.CK;
   }

   public PendingIntent kb() {
      return this.mPendingIntent;
   }

   IBinder kg() {
      return this.VW == null?null:this.VW.asBinder();
   }

   public String toString() {
      return String.format("SensorUnregistrationRequest{%s}", new Object[]{this.VW});
   }

   public void writeToParcel(Parcel var1, int var2) {
      r.a(this, var1, var2);
   }
}
