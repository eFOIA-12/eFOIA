package com.google.android.gms.internal;

import com.google.android.gms.internal.av;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.bv;
import com.google.android.gms.internal.cq;
import com.google.android.gms.internal.cr;
import com.google.android.gms.internal.ct;
import com.google.android.gms.internal.cz;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.fh;
import com.google.android.gms.internal.fj;
import com.google.android.gms.internal.gu;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@ey
public final class fy {
   public final int errorCode;
   public final int orientation;
   public final long qA;
   public final cq qP;
   public final cz qQ;
   public final String qR;
   public final ct qS;
   public final List qw;
   public final List qx;
   public final gu se;
   public final av tL;
   public final String tO;
   public final long tV;
   public final boolean tW;
   public final long tX;
   public final List tY;
   public final String ub;
   public final JSONObject vD;
   public final cr vE;
   public final ay vF;
   public final long vG;
   public final long vH;
   public final bv.a vI;

   public fy(av var1, gu var2, List var3, int var4, List var5, List var6, int var7, long var8, String var10, boolean var11, cq var12, cz var13, String var14, cr var15, ct var16, long var17, ay var19, long var20, long var22, long var24, String var26, JSONObject var27, bv.a var28) {
      this.tL = var1;
      this.se = var2;
      List var29;
      if(var3 != null) {
         var29 = Collections.unmodifiableList(var3);
      } else {
         var29 = null;
      }

      this.qw = var29;
      this.errorCode = var4;
      if(var5 != null) {
         var29 = Collections.unmodifiableList(var5);
      } else {
         var29 = null;
      }

      this.qx = var29;
      if(var6 != null) {
         var29 = Collections.unmodifiableList(var6);
      } else {
         var29 = null;
      }

      this.tY = var29;
      this.orientation = var7;
      this.qA = var8;
      this.tO = var10;
      this.tW = var11;
      this.qP = var12;
      this.qQ = var13;
      this.qR = var14;
      this.vE = var15;
      this.qS = var16;
      this.tX = var17;
      this.vF = var19;
      this.tV = var20;
      this.vG = var22;
      this.vH = var24;
      this.ub = var26;
      this.vD = var27;
      this.vI = var28;
   }

   public fy(fy.a var1, gu var2, cq var3, cz var4, String var5, ct var6, bv.a var7) {
      this(var1.vJ.tL, var2, var1.vK.qw, var1.errorCode, var1.vK.qx, var1.vK.tY, var1.vK.orientation, var1.vK.qA, var1.vJ.tO, var1.vK.tW, var3, var4, var5, var1.vE, var6, var1.vK.tX, var1.lS, var1.vK.tV, var1.vG, var1.vH, var1.vK.ub, var1.vD, var7);
   }

   @ey
   public static final class a {
      public final int errorCode;
      public final ay lS;
      public final JSONObject vD;
      public final cr vE;
      public final long vG;
      public final long vH;
      public final fh vJ;
      public final fj vK;

      public a(fh var1, fj var2, cr var3, ay var4, int var5, long var6, long var8, JSONObject var10) {
         this.vJ = var1;
         this.vK = var2;
         this.vE = var3;
         this.lS = var4;
         this.errorCode = var5;
         this.vG = var6;
         this.vH = var8;
         this.vD = var10;
      }
   }
}
