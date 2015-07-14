package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.internal.am;

public class al implements SafeParcelable, Node {
   public static final Creator CREATOR = new am();
   private final String CE;
   final int CK;
   private final String OS;

   al(int var1, String var2, String var3) {
      this.CK = var1;
      this.CE = var2;
      this.OS = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof al) {
         al var2 = (al)var1;
         if(var2.CE.equals(this.CE) && var2.OS.equals(this.OS)) {
            return true;
         }
      }

      return false;
   }

   public String getDisplayName() {
      return this.OS;
   }

   public String getId() {
      return this.CE;
   }

   public int hashCode() {
      return (this.CE.hashCode() + 629) * 37 + this.OS.hashCode();
   }

   public String toString() {
      return "NodeParcelable{" + this.CE + "," + this.OS + "}";
   }

   public void writeToParcel(Parcel var1, int var2) {
      am.a(this, var1, var2);
   }
}
