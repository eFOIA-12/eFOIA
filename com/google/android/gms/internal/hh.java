package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hi;
import com.google.android.gms.internal.ho;
import com.google.android.gms.internal.hp;
import com.google.android.gms.internal.jx;

public class hh implements SafeParcelable {
   public static final hi CREATOR = new hi();
   public static final int CV = Integer.parseInt("-1");
   private static final hp CW = (new hp.a("SsbContext")).G(true).at("blob").fG();
   final int CK;
   public final String CX;
   final hp CY;
   public final int CZ;
   public final byte[] Da;

   hh(int var1, String var2, hp var3, int var4, byte[] var5) {
      boolean var6;
      if(var4 != CV && ho.P(var4) == null) {
         var6 = false;
      } else {
         var6 = true;
      }

      jx.b(var6, "Invalid section type " + var4);
      this.CK = var1;
      this.CX = var2;
      this.CY = var3;
      this.CZ = var4;
      this.Da = var5;
      var2 = this.fE();
      if(var2 != null) {
         throw new IllegalArgumentException(var2);
      }
   }

   public hh(String var1, hp var2) {
      this(1, var1, var2, CV, (byte[])null);
   }

   public hh(String var1, hp var2, String var3) {
      this(1, var1, var2, ho.as(var3), (byte[])null);
   }

   public hh(byte[] var1, hp var2) {
      this(1, (String)null, var2, CV, var1);
   }

   public int describeContents() {
      hi var1 = CREATOR;
      return 0;
   }

   public String fE() {
      return this.CZ != CV && ho.P(this.CZ) == null?"Invalid section type " + this.CZ:(this.CX != null && this.Da != null?"Both content and blobContent set":null);
   }

   public void writeToParcel(Parcel var1, int var2) {
      hi var3 = CREATOR;
      hi.a(this, var1, var2);
   }
}
