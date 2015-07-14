package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.fi;
import com.google.android.gms.internal.gs;
import java.util.List;

@ey
public final class fh implements SafeParcelable {
   public static final fi CREATOR = new fi();
   public final ApplicationInfo applicationInfo;
   public final String lL;
   public final gs lO;
   public final ay lS;
   public final List mc;
   public final Bundle tK;
   public final av tL;
   public final PackageInfo tM;
   public final String tN;
   public final String tO;
   public final String tP;
   public final Bundle tQ;
   public final int tR;
   public final Bundle tS;
   public final boolean tT;
   public final int versionCode;

   fh(int var1, Bundle var2, av var3, ay var4, String var5, ApplicationInfo var6, PackageInfo var7, String var8, String var9, String var10, gs var11, Bundle var12, int var13, List var14, Bundle var15, boolean var16) {
      this.versionCode = var1;
      this.tK = var2;
      this.tL = var3;
      this.lS = var4;
      this.lL = var5;
      this.applicationInfo = var6;
      this.tM = var7;
      this.tN = var8;
      this.tO = var9;
      this.tP = var10;
      this.lO = var11;
      this.tQ = var12;
      this.tR = var13;
      this.mc = var14;
      this.tS = var15;
      this.tT = var16;
   }

   public fh(Bundle var1, av var2, ay var3, String var4, ApplicationInfo var5, PackageInfo var6, String var7, String var8, String var9, gs var10, Bundle var11, int var12, List var13, Bundle var14, boolean var15) {
      this(4, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15);
   }

   public fh(fh.a var1, String var2) {
      this(var1.tK, var1.tL, var1.lS, var1.lL, var1.applicationInfo, var1.tM, var2, var1.tO, var1.tP, var1.lO, var1.tQ, var1.tR, var1.mc, var1.tS, var1.tT);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      fi.a(this, var1, var2);
   }

   @ey
   public static final class a {
      public final ApplicationInfo applicationInfo;
      public final String lL;
      public final gs lO;
      public final ay lS;
      public final List mc;
      public final Bundle tK;
      public final av tL;
      public final PackageInfo tM;
      public final String tO;
      public final String tP;
      public final Bundle tQ;
      public final int tR;
      public final Bundle tS;
      public final boolean tT;

      public a(Bundle var1, av var2, ay var3, String var4, ApplicationInfo var5, PackageInfo var6, String var7, String var8, gs var9, Bundle var10, List var11, Bundle var12, boolean var13) {
         this.tK = var1;
         this.tL = var2;
         this.lS = var3;
         this.lL = var4;
         this.applicationInfo = var5;
         this.tM = var6;
         this.tO = var7;
         this.tP = var8;
         this.lO = var9;
         this.tQ = var10;
         this.tT = var13;
         if(var11 != null && var11.size() > 0) {
            this.tR = 2;
            this.mc = var11;
         } else {
            this.tR = 0;
            this.mc = null;
         }

         this.tS = var12;
      }
   }
}
