package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.fk;
import java.util.Collections;
import java.util.List;

@ey
public final class fj implements SafeParcelable {
   public static final fk CREATOR = new fk();
   public final int errorCode;
   public final int orientation;
   public final long qA;
   public final List qw;
   public final List qx;
   public final String sg;
   public final boolean tT;
   public final String tU;
   public final long tV;
   public final boolean tW;
   public final long tX;
   public final List tY;
   public final String tZ;
   public final long ua;
   public final String ub;
   public final boolean uc;
   public final String ud;
   public final String ue;
   public final boolean uf;
   public final boolean ug;
   public final boolean uh;
   public final int versionCode;

   public fj(int var1) {
      this(10, (String)null, (String)null, (List)null, var1, (List)null, -1L, false, -1L, (List)null, -1L, -1, (String)null, -1L, (String)null, false, (String)null, (String)null, false, false, false, false);
   }

   public fj(int var1, long var2) {
      this(10, (String)null, (String)null, (List)null, var1, (List)null, -1L, false, -1L, (List)null, var2, -1, (String)null, -1L, (String)null, false, (String)null, (String)null, false, false, false, false);
   }

   fj(int var1, String var2, String var3, List var4, int var5, List var6, long var7, boolean var9, long var10, List var12, long var13, int var15, String var16, long var17, String var19, boolean var20, String var21, String var22, boolean var23, boolean var24, boolean var25, boolean var26) {
      this.versionCode = var1;
      this.sg = var2;
      this.tU = var3;
      List var27;
      if(var4 != null) {
         var27 = Collections.unmodifiableList(var4);
      } else {
         var27 = null;
      }

      this.qw = var27;
      this.errorCode = var5;
      if(var6 != null) {
         var27 = Collections.unmodifiableList(var6);
      } else {
         var27 = null;
      }

      this.qx = var27;
      this.tV = var7;
      this.tW = var9;
      this.tX = var10;
      if(var12 != null) {
         var27 = Collections.unmodifiableList(var12);
      } else {
         var27 = null;
      }

      this.tY = var27;
      this.qA = var13;
      this.orientation = var15;
      this.tZ = var16;
      this.ua = var17;
      this.ub = var19;
      this.uc = var20;
      this.ud = var21;
      this.ue = var22;
      this.uf = var23;
      this.ug = var24;
      this.tT = var25;
      this.uh = var26;
   }

   public fj(String var1, String var2, List var3, List var4, long var5, boolean var7, long var8, List var10, long var11, int var13, String var14, long var15, String var17, String var18, boolean var19, boolean var20, boolean var21, boolean var22) {
      this(10, var1, var2, var3, -2, var4, var5, var7, var8, var10, var11, var13, var14, var15, var17, false, (String)null, var18, var19, var20, var21, var22);
   }

   public fj(String var1, String var2, List var3, List var4, long var5, boolean var7, long var8, List var10, long var11, int var13, String var14, long var15, String var17, boolean var18, String var19, String var20, boolean var21, boolean var22, boolean var23, boolean var24) {
      this(10, var1, var2, var3, -2, var4, var5, var7, var8, var10, var11, var13, var14, var15, var17, var18, var19, var20, var21, var22, var23, var24);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      fk.a(this, var1, var2);
   }
}
