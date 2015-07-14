package com.google.android.gms.analytics;

import java.util.SortedSet;
import java.util.TreeSet;

class y {
   private static final y zV = new y();
   private SortedSet zS = new TreeSet();
   private StringBuilder zT = new StringBuilder();
   private boolean zU = false;

   public static y eK() {
      return zV;
   }

   public void D(boolean var1) {
      synchronized(this){}

      try {
         this.zU = var1;
      } finally {
         ;
      }

   }

   public void a(y.a var1) {
      synchronized(this){}

      try {
         if(!this.zU) {
            this.zS.add(var1);
            this.zT.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(var1.ordinal()));
         }
      } finally {
         ;
      }

   }

   public String eL() {
      // $FF: Couldn't be decompiled
   }

   public String eM() {
      synchronized(this){}

      String var1;
      try {
         if(this.zT.length() > 0) {
            this.zT.insert(0, ".");
         }

         var1 = this.zT.toString();
         this.zT = new StringBuilder();
      } finally {
         ;
      }

      return var1;
   }

   public static enum a {
      AA,
      AB,
      AC,
      AD,
      AE,
      AF,
      AG,
      AH,
      AI,
      AJ,
      AK,
      AL,
      AM,
      AN,
      AO,
      AP,
      AQ,
      AR,
      AS,
      AT,
      AU,
      AV,
      AW,
      AX,
      AY,
      AZ,
      Aa,
      Ab,
      Ac,
      Ad,
      Ae,
      Af,
      Ag,
      Ah,
      Ai,
      Aj,
      Ak,
      Al,
      Am,
      An,
      Ao,
      Ap,
      Aq,
      Ar,
      As,
      At,
      Au,
      Av,
      Aw,
      Ax,
      Ay,
      Az,
      Ba,
      Bb,
      Bc,
      Bd,
      Be,
      Bf,
      Bg,
      zW,
      zX,
      zY,
      zZ;
   }
}
