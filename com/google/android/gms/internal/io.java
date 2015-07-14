package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.in;
import com.google.android.gms.internal.ip;
import com.google.android.gms.internal.jv;

public class io implements SafeParcelable {
   public static final Creator CREATOR = new ip();
   private final int CK;
   private double Gp;
   private boolean Gq;
   private ApplicationMetadata HD;
   private int Hr;
   private int Hs;

   public io() {
      this(3, Double.NaN, false, -1, (ApplicationMetadata)null, -1);
   }

   io(int var1, double var2, boolean var4, int var5, ApplicationMetadata var6, int var7) {
      this.CK = var1;
      this.Gp = var2;
      this.Gq = var4;
      this.Hr = var5;
      this.HD = var6;
      this.Hs = var7;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof io)) {
            return false;
         }

         io var2 = (io)var1;
         if(this.Gp != var2.Gp || this.Gq != var2.Gq || this.Hr != var2.Hr || !in.a(this.HD, var2.HD) || this.Hs != var2.Hs) {
            return false;
         }
      }

      return true;
   }

   public double fZ() {
      return this.Gp;
   }

   public ApplicationMetadata getApplicationMetadata() {
      return this.HD;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public boolean gi() {
      return this.Gq;
   }

   public int gj() {
      return this.Hr;
   }

   public int gk() {
      return this.Hs;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{Double.valueOf(this.Gp), Boolean.valueOf(this.Gq), Integer.valueOf(this.Hr), this.HD, Integer.valueOf(this.Hs)});
   }

   public void writeToParcel(Parcel var1, int var2) {
      ip.a(this, var1, var2);
   }
}
