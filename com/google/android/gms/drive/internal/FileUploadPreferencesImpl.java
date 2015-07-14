package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.FileUploadPreferences;
import com.google.android.gms.drive.internal.ab;

public final class FileUploadPreferencesImpl implements SafeParcelable, FileUploadPreferences {
   public static final Creator CREATOR = new ab();
   final int CK;
   int QA;
   boolean QB;
   int Qz;

   FileUploadPreferencesImpl(int var1, int var2, int var3, boolean var4) {
      this.CK = var1;
      this.Qz = var2;
      this.QA = var3;
      this.QB = var4;
   }

   public static boolean by(int var0) {
      switch(var0) {
      case 1:
      case 2:
         return true;
      default:
         return false;
      }
   }

   public static boolean bz(int var0) {
      switch(var0) {
      case 256:
      case 257:
         return true;
      default:
         return false;
      }
   }

   public int describeContents() {
      return 0;
   }

   public int getBatteryUsagePreference() {
      return !bz(this.QA)?0:this.QA;
   }

   public int getNetworkTypePreference() {
      return !by(this.Qz)?0:this.Qz;
   }

   public boolean isRoamingAllowed() {
      return this.QB;
   }

   public void setBatteryUsagePreference(int var1) {
      if(!bz(var1)) {
         throw new IllegalArgumentException("Invalid battery usage preference value.");
      } else {
         this.QA = var1;
      }
   }

   public void setNetworkTypePreference(int var1) {
      if(!by(var1)) {
         throw new IllegalArgumentException("Invalid data connection preference value.");
      } else {
         this.Qz = var1;
      }
   }

   public void setRoamingAllowed(boolean var1) {
      this.QB = var1;
   }

   public void writeToParcel(Parcel var1, int var2) {
      ab.a(this, var1, var2);
   }
}
