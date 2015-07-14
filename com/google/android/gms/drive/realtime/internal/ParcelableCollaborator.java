package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.p;

public class ParcelableCollaborator implements SafeParcelable {
   public static final Creator CREATOR = new p();
   final int CK;
   final String OS;
   final boolean SH;
   final boolean SI;
   final String SJ;
   final String SK;
   final String SL;
   final String vZ;

   ParcelableCollaborator(int var1, boolean var2, boolean var3, String var4, String var5, String var6, String var7, String var8) {
      this.CK = var1;
      this.SH = var2;
      this.SI = var3;
      this.vZ = var4;
      this.SJ = var5;
      this.OS = var6;
      this.SK = var7;
      this.SL = var8;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof ParcelableCollaborator)) {
         return false;
      } else {
         ParcelableCollaborator var2 = (ParcelableCollaborator)var1;
         return this.vZ.equals(var2.vZ);
      }
   }

   public int hashCode() {
      return this.vZ.hashCode();
   }

   public String toString() {
      return "Collaborator [isMe=" + this.SH + ", isAnonymous=" + this.SI + ", sessionId=" + this.vZ + ", userId=" + this.SJ + ", displayName=" + this.OS + ", color=" + this.SK + ", photoUrl=" + this.SL + "]";
   }

   public void writeToParcel(Parcel var1, int var2) {
      p.a(this, var1, var2);
   }
}
