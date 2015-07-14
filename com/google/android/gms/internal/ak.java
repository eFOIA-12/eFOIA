package com.google.android.gms.internal;

import com.google.android.gms.internal.ap;
import com.google.android.gms.internal.ey;
import java.util.ArrayList;
import java.util.Iterator;

@ey
public class ak {
   private final Object mH = new Object();
   private final int np;
   private final int nq;
   private final int nr;
   private final ap ns;
   private ArrayList nt = new ArrayList();
   private int nu = 0;
   private int nv = 0;
   private int nw = 0;
   private int nx;
   private String ny = "";

   public ak(int var1, int var2, int var3, int var4) {
      this.np = var1;
      this.nq = var2;
      this.nr = var3;
      this.ns = new ap(var4);
   }

   private String a(ArrayList var1, int var2) {
      String var4;
      if(var1.isEmpty()) {
         var4 = "";
      } else {
         StringBuffer var3 = new StringBuffer();
         Iterator var5 = var1.iterator();

         while(var5.hasNext()) {
            var3.append((String)var5.next());
            var3.append(' ');
            if(var3.length() > var2) {
               break;
            }
         }

         var3.deleteCharAt(var3.length() - 1);
         String var6 = var3.toString();
         var4 = var6;
         if(var6.length() >= var2) {
            return var6.substring(0, var2);
         }
      }

      return var4;
   }

   private void j(String param1) {
      // $FF: Couldn't be decompiled
   }

   int a(int var1, int var2) {
      return this.np * var1 + this.nq * var2;
   }

   public boolean aS() {
      // $FF: Couldn't be decompiled
   }

   public String aT() {
      return this.ny;
   }

   public void aU() {
      // $FF: Couldn't be decompiled
   }

   public void aV() {
      // $FF: Couldn't be decompiled
   }

   public void aW() {
      // $FF: Couldn't be decompiled
   }

   public void aX() {
      // $FF: Couldn't be decompiled
   }

   int aY() {
      return this.nu;
   }

   public void c(int var1) {
      this.nv = var1;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof ak) {
         if(var1 == this) {
            return true;
         }

         ak var2 = (ak)var1;
         if(var2.aT() != null && var2.aT().equals(this.aT())) {
            return true;
         }
      }

      return false;
   }

   public int getScore() {
      return this.nx;
   }

   public void h(String param1) {
      // $FF: Couldn't be decompiled
   }

   public int hashCode() {
      return this.aT().hashCode();
   }

   public void i(String var1) {
      this.j(var1);
   }

   public String toString() {
      return "ActivityContent fetchId: " + this.nv + " score:" + this.nx + " total_length:" + this.nu + "\n text: " + this.a(this.nt, 200) + "\n signture: " + this.ny;
   }
}
