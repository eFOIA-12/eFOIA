package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.a;
import com.google.android.gms.fitness.request.ae;
import com.google.android.gms.fitness.request.l;

public class ad implements SafeParcelable {
   public static final Creator CREATOR = new ae();
   private final int CK;
   private final l Wm;

   ad(int var1, IBinder var2) {
      this.CK = var1;
      this.Wm = l.a.aB(var2);
   }

   public ad(BleScanCallback var1) {
      this.CK = 1;
      this.Wm = a.a.jP().b(var1);
   }

   public int describeContents() {
      return 0;
   }

   int getVersionCode() {
      return this.CK;
   }

   public IBinder km() {
      return this.Wm.asBinder();
   }

   public void writeToParcel(Parcel var1, int var2) {
      ae.a(this, var1, var2);
   }
}
