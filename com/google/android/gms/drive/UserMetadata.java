package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.h;

public class UserMetadata implements SafeParcelable {
   public static final Creator CREATOR = new h();
   final int CK;
   final String OR;
   final String OS;
   final String OT;
   final boolean OU;
   final String OV;

   UserMetadata(int var1, String var2, String var3, String var4, boolean var5, String var6) {
      this.CK = var1;
      this.OR = var2;
      this.OS = var3;
      this.OT = var4;
      this.OU = var5;
      this.OV = var6;
   }

   public UserMetadata(String var1, String var2, String var3, boolean var4, String var5) {
      this(1, var1, var2, var3, var4, var5);
   }

   public int describeContents() {
      return 0;
   }

   public String toString() {
      return String.format("Permission ID: \'%s\', Display Name: \'%s\', Picture URL: \'%s\', Authenticated User: %b, Email: \'%s\'", new Object[]{this.OR, this.OS, this.OT, Boolean.valueOf(this.OU), this.OV});
   }

   public void writeToParcel(Parcel var1, int var2) {
      h.a(this, var1, var2);
   }
}
