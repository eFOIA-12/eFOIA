package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.ga;
import java.util.LinkedList;

@ey
public class fz {
   private final Object mH;
   private boolean uQ;
   private final ga vL;
   private final LinkedList vM;
   private final String vN;
   private final String vO;
   private long vP;
   private long vQ;
   private long vR;
   private long vS;
   private long vT;
   private long vU;

   public fz(ga var1, String var2, String var3) {
      this.mH = new Object();
      this.vP = -1L;
      this.vQ = -1L;
      this.uQ = false;
      this.vR = -1L;
      this.vS = 0L;
      this.vT = -1L;
      this.vU = -1L;
      this.vL = var1;
      this.vN = var2;
      this.vO = var3;
      this.vM = new LinkedList();
   }

   public fz(String var1, String var2) {
      this(ga.dc(), var1, var2);
   }

   public void cW() {
      // $FF: Couldn't be decompiled
   }

   public void cX() {
      // $FF: Couldn't be decompiled
   }

   public void cY() {
      // $FF: Couldn't be decompiled
   }

   public void e(av param1) {
      // $FF: Couldn't be decompiled
   }

   public void j(long param1) {
      // $FF: Couldn't be decompiled
   }

   public void k(long param1) {
      // $FF: Couldn't be decompiled
   }

   public Bundle toBundle() {
      // $FF: Couldn't be decompiled
   }

   public void v(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   public void w(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   @ey
   private static final class a {
      private long vV = -1L;
      private long vW = -1L;

      public long cZ() {
         return this.vW;
      }

      public void da() {
         this.vW = SystemClock.elapsedRealtime();
      }

      public void db() {
         this.vV = SystemClock.elapsedRealtime();
      }

      public Bundle toBundle() {
         Bundle var1 = new Bundle();
         var1.putLong("topen", this.vV);
         var1.putLong("tclose", this.vW);
         return var1;
      }
   }
}
