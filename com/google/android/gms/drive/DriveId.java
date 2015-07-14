package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.c;
import com.google.android.gms.drive.internal.ak;
import com.google.android.gms.drive.internal.w;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.qv;
import com.google.android.gms.internal.qw;

public class DriveId implements SafeParcelable {
   public static final Creator CREATOR = new c();
   final int CK;
   final String Ot;
   final long Ou;
   final long Ov;
   private volatile String Ow;

   DriveId(int var1, String var2, long var3, long var5) {
      boolean var8 = false;
      super();
      this.Ow = null;
      this.CK = var1;
      this.Ot = var2;
      boolean var7;
      if(!"".equals(var2)) {
         var7 = true;
      } else {
         var7 = false;
      }

      label15: {
         jx.L(var7);
         if(var2 == null) {
            var7 = var8;
            if(var3 == -1L) {
               break label15;
            }
         }

         var7 = true;
      }

      jx.L(var7);
      this.Ou = var3;
      this.Ov = var5;
   }

   public DriveId(String var1, long var2, long var4) {
      this(1, var1, var2, var4);
   }

   public static DriveId bi(String var0) {
      jx.i(var0);
      return new DriveId(var0, -1L, -1L);
   }

   public static DriveId decodeFromString(String var0) {
      jx.b(var0.startsWith("DriveId:"), "Invalid DriveId: " + var0);
      return f(Base64.decode(var0.substring("DriveId:".length()), 10));
   }

   static DriveId f(byte[] var0) {
      ak var1;
      try {
         var1 = ak.g(var0);
      } catch (qv var2) {
         throw new IllegalArgumentException();
      }

      String var3;
      if("".equals(var1.QG)) {
         var3 = null;
      } else {
         var3 = var1.QG;
      }

      return new DriveId(var1.versionCode, var3, var1.QH, var1.QI);
   }

   public int describeContents() {
      return 0;
   }

   public final String encodeToString() {
      if(this.Ow == null) {
         String var1 = Base64.encodeToString(this.iu(), 10);
         this.Ow = "DriveId:" + var1;
      }

      return this.Ow;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof DriveId) {
         DriveId var2 = (DriveId)var1;
         if(var2.Ov != this.Ov) {
            w.o("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
            return false;
         }

         if(var2.Ou == -1L && this.Ou == -1L) {
            return var2.Ot.equals(this.Ot);
         }

         if(var2.Ou == this.Ou) {
            return true;
         }
      }

      return false;
   }

   public String getResourceId() {
      return this.Ot;
   }

   public int hashCode() {
      return this.Ou == -1L?this.Ot.hashCode():(this.Ov + String.valueOf(this.Ou)).hashCode();
   }

   final byte[] iu() {
      ak var2 = new ak();
      var2.versionCode = this.CK;
      String var1;
      if(this.Ot == null) {
         var1 = "";
      } else {
         var1 = this.Ot;
      }

      var2.QG = var1;
      var2.QH = this.Ou;
      var2.QI = this.Ov;
      return qw.f(var2);
   }

   public String toString() {
      return this.encodeToString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      c.a(this, var1, var2);
   }
}
