package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.in;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;
import java.util.List;

public final class ApplicationMetadata implements SafeParcelable {
   public static final Creator CREATOR = new a();
   private final int CK;
   String Fo;
   List Fp;
   List Fq;
   String Fr;
   Uri Fs;
   String mName;

   private ApplicationMetadata() {
      this.CK = 1;
      this.Fp = new ArrayList();
      this.Fq = new ArrayList();
   }

   ApplicationMetadata(int var1, String var2, String var3, List var4, List var5, String var6, Uri var7) {
      this.CK = var1;
      this.Fo = var2;
      this.mName = var3;
      this.Fp = var4;
      this.Fq = var5;
      this.Fr = var6;
      this.Fs = var7;
   }

   public boolean areNamespacesSupported(List var1) {
      return this.Fq != null && this.Fq.containsAll(var1);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof ApplicationMetadata)) {
            return false;
         }

         ApplicationMetadata var2 = (ApplicationMetadata)var1;
         if(!in.a(this.Fo, var2.Fo) || !in.a(this.Fp, var2.Fp) || !in.a(this.mName, var2.mName) || !in.a(this.Fq, var2.Fq) || !in.a(this.Fr, var2.Fr) || !in.a(this.Fs, var2.Fs)) {
            return false;
         }
      }

      return true;
   }

   public Uri fP() {
      return this.Fs;
   }

   public String getApplicationId() {
      return this.Fo;
   }

   public List getImages() {
      return this.Fp;
   }

   public String getName() {
      return this.mName;
   }

   public String getSenderAppIdentifier() {
      return this.Fr;
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{Integer.valueOf(this.CK), this.Fo, this.mName, this.Fp, this.Fq, this.Fr, this.Fs});
   }

   public boolean isNamespaceSupported(String var1) {
      return this.Fq != null && this.Fq.contains(var1);
   }

   public String toString() {
      return this.mName;
   }

   public void writeToParcel(Parcel var1, int var2) {
      a.a(this, var1, var2);
   }
}
