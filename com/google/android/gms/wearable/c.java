package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.wearable.d;

public class c implements SafeParcelable {
   public static final Creator CREATOR = new d();
   final int CK;
   private final int Gt;
   private final String TW;
   private final int axc;
   private final boolean axd;
   private boolean axe;
   private String axf;
   private final String mName;

   c(int var1, String var2, String var3, int var4, int var5, boolean var6, boolean var7, String var8) {
      this.CK = var1;
      this.mName = var2;
      this.TW = var3;
      this.Gt = var4;
      this.axc = var5;
      this.axd = var6;
      this.axe = var7;
      this.axf = var8;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof c) {
         c var2 = (c)var1;
         if(jv.equal(Integer.valueOf(this.CK), Integer.valueOf(var2.CK)) && jv.equal(this.mName, var2.mName) && jv.equal(this.TW, var2.TW) && jv.equal(Integer.valueOf(this.Gt), Integer.valueOf(var2.Gt)) && jv.equal(Integer.valueOf(this.axc), Integer.valueOf(var2.axc)) && jv.equal(Boolean.valueOf(this.axd), Boolean.valueOf(var2.axd))) {
            return true;
         }
      }

      return false;
   }

   public String getAddress() {
      return this.TW;
   }

   public String getName() {
      return this.mName;
   }

   public int getRole() {
      return this.axc;
   }

   public int getType() {
      return this.Gt;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{Integer.valueOf(this.CK), this.mName, this.TW, Integer.valueOf(this.Gt), Integer.valueOf(this.axc), Boolean.valueOf(this.axd)});
   }

   public boolean isConnected() {
      return this.axe;
   }

   public boolean isEnabled() {
      return this.axd;
   }

   public String rj() {
      return this.axf;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("ConnectionConfiguration[ ");
      var1.append("mName=" + this.mName);
      var1.append(", mAddress=" + this.TW);
      var1.append(", mType=" + this.Gt);
      var1.append(", mRole=" + this.axc);
      var1.append(", mEnabled=" + this.axd);
      var1.append(", mIsConnected=" + this.axe);
      var1.append(", mEnabled=" + this.axf);
      var1.append("]");
      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      d.a(this, var1, var2);
   }
}
