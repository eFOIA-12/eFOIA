package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.km;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.kv;
import com.google.android.gms.internal.ky;
import com.google.android.gms.internal.lb;
import com.google.android.gms.internal.li;
import com.google.android.gms.internal.lj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public abstract class kr {
   private void a(StringBuilder var1, kr.a var2, Object var3) {
      if(var2.hI() == 11) {
         var1.append(((kr)var2.hS().cast(var3)).toString());
      } else if(var2.hI() == 7) {
         var1.append("\"");
         var1.append(li.bh((String)var3));
         var1.append("\"");
      } else {
         var1.append(var3);
      }
   }

   private void a(StringBuilder var1, kr.a var2, ArrayList var3) {
      var1.append("[");
      int var4 = 0;

      for(int var5 = var3.size(); var4 < var5; ++var4) {
         if(var4 > 0) {
            var1.append(",");
         }

         Object var6 = var3.get(var4);
         if(var6 != null) {
            this.a(var1, var2, var6);
         }
      }

      var1.append("]");
   }

   protected Object a(kr.a var1, Object var2) {
      Object var3 = var2;
      if(var1.NU != null) {
         var3 = var1.convertBack(var2);
      }

      return var3;
   }

   protected boolean a(kr.a var1) {
      return var1.hJ() == 11?(var1.hP()?this.bf(var1.hQ()):this.be(var1.hQ())):this.bd(var1.hQ());
   }

   protected Object b(kr.a var1) {
      String var3 = var1.hQ();
      if(var1.hS() != null) {
         boolean var2;
         if(this.bc(var1.hQ()) == null) {
            var2 = true;
         } else {
            var2 = false;
         }

         jx.a(var2, "Concrete field shouldn\'t be value object: %s", new Object[]{var1.hQ()});
         HashMap var5;
         if(var1.hP()) {
            var5 = this.hM();
         } else {
            var5 = this.hL();
         }

         if(var5 != null) {
            return var5.get(var3);
         } else {
            try {
               String var6 = "get" + Character.toUpperCase(var3.charAt(0)) + var3.substring(1);
               Object var7 = this.getClass().getMethod(var6, new Class[0]).invoke(this, new Object[0]);
               return var7;
            } catch (Exception var4) {
               throw new RuntimeException(var4);
            }
         }
      } else {
         return this.bc(var1.hQ());
      }
   }

   protected abstract Object bc(String var1);

   protected abstract boolean bd(String var1);

   protected boolean be(String var1) {
      throw new UnsupportedOperationException("Concrete types not supported");
   }

   protected boolean bf(String var1) {
      throw new UnsupportedOperationException("Concrete type arrays not supported");
   }

   public abstract HashMap hK();

   public HashMap hL() {
      return null;
   }

   public HashMap hM() {
      return null;
   }

   public String toString() {
      HashMap var1 = this.hK();
      StringBuilder var2 = new StringBuilder(100);
      Iterator var3 = var1.keySet().iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         kr.a var5 = (kr.a)var1.get(var4);
         if(this.a(var5)) {
            Object var6 = this.a(var5, this.b(var5));
            if(var2.length() == 0) {
               var2.append("{");
            } else {
               var2.append(",");
            }

            var2.append("\"").append(var4).append("\":");
            if(var6 == null) {
               var2.append("null");
            } else {
               switch(var5.hJ()) {
               case 8:
                  var2.append("\"").append(lb.d((byte[])((byte[])var6))).append("\"");
                  break;
               case 9:
                  var2.append("\"").append(lb.e((byte[])((byte[])var6))).append("\"");
                  break;
               case 10:
                  lj.a(var2, (HashMap)var6);
                  break;
               default:
                  if(var5.hO()) {
                     this.a(var2, var5, (ArrayList)var6);
                  } else {
                     this.a(var2, var5, var6);
                  }
               }
            }
         }
      }

      if(var2.length() > 0) {
         var2.append("}");
      } else {
         var2.append("{}");
      }

      return var2.toString();
   }

   public static class a implements SafeParcelable {
      public static final kt CREATOR = new kt();
      private final int CK;
      protected final int NL;
      protected final boolean NM;
      protected final int NN;
      protected final boolean NO;
      protected final String NP;
      protected final int NQ;
      protected final Class NR;
      protected final String NS;
      private kv NT;
      private kr.b NU;

      a(int var1, int var2, boolean var3, int var4, boolean var5, String var6, int var7, String var8, km var9) {
         this.CK = var1;
         this.NL = var2;
         this.NM = var3;
         this.NN = var4;
         this.NO = var5;
         this.NP = var6;
         this.NQ = var7;
         if(var8 == null) {
            this.NR = null;
            this.NS = null;
         } else {
            this.NR = ky.class;
            this.NS = var8;
         }

         if(var9 == null) {
            this.NU = null;
         } else {
            this.NU = var9.hG();
         }
      }

      protected a(int var1, boolean var2, int var3, boolean var4, String var5, int var6, Class var7, kr.b var8) {
         this.CK = 1;
         this.NL = var1;
         this.NM = var2;
         this.NN = var3;
         this.NO = var4;
         this.NP = var5;
         this.NQ = var6;
         this.NR = var7;
         if(var7 == null) {
            this.NS = null;
         } else {
            this.NS = var7.getCanonicalName();
         }

         this.NU = var8;
      }

      public static kr.a a(String var0, int var1, kr.b var2, boolean var3) {
         return new kr.a(var2.hI(), var3, var2.hJ(), false, var0, var1, (Class)null, var2);
      }

      public static kr.a a(String var0, int var1, Class var2) {
         return new kr.a(11, false, 11, false, var0, var1, var2, (kr.b)null);
      }

      public static kr.a b(String var0, int var1, Class var2) {
         return new kr.a(11, true, 11, true, var0, var1, var2, (kr.b)null);
      }

      public static kr.a i(String var0, int var1) {
         return new kr.a(0, false, 0, false, var0, var1, (Class)null, (kr.b)null);
      }

      public static kr.a j(String var0, int var1) {
         return new kr.a(4, false, 4, false, var0, var1, (Class)null, (kr.b)null);
      }

      public static kr.a k(String var0, int var1) {
         return new kr.a(6, false, 6, false, var0, var1, (Class)null, (kr.b)null);
      }

      public static kr.a l(String var0, int var1) {
         return new kr.a(7, false, 7, false, var0, var1, (Class)null, (kr.b)null);
      }

      public static kr.a m(String var0, int var1) {
         return new kr.a(7, true, 7, true, var0, var1, (Class)null, (kr.b)null);
      }

      public void a(kv var1) {
         this.NT = var1;
      }

      public Object convertBack(Object var1) {
         return this.NU.convertBack(var1);
      }

      public int describeContents() {
         kt var1 = CREATOR;
         return 0;
      }

      public int getVersionCode() {
         return this.CK;
      }

      public int hI() {
         return this.NL;
      }

      public int hJ() {
         return this.NN;
      }

      public kr.a hN() {
         return new kr.a(this.CK, this.NL, this.NM, this.NN, this.NO, this.NP, this.NQ, this.NS, this.hV());
      }

      public boolean hO() {
         return this.NM;
      }

      public boolean hP() {
         return this.NO;
      }

      public String hQ() {
         return this.NP;
      }

      public int hR() {
         return this.NQ;
      }

      public Class hS() {
         return this.NR;
      }

      String hT() {
         return this.NS == null?null:this.NS;
      }

      public boolean hU() {
         return this.NU != null;
      }

      km hV() {
         return this.NU == null?null:km.a(this.NU);
      }

      public HashMap hW() {
         jx.i(this.NS);
         jx.i(this.NT);
         return this.NT.bg(this.NS);
      }

      public String toString() {
         StringBuilder var2 = new StringBuilder();
         var2.append("Field\n");
         var2.append("            versionCode=").append(this.CK).append('\n');
         var2.append("                 typeIn=").append(this.NL).append('\n');
         var2.append("            typeInArray=").append(this.NM).append('\n');
         var2.append("                typeOut=").append(this.NN).append('\n');
         var2.append("           typeOutArray=").append(this.NO).append('\n');
         var2.append("        outputFieldName=").append(this.NP).append('\n');
         var2.append("      safeParcelFieldId=").append(this.NQ).append('\n');
         var2.append("       concreteTypeName=").append(this.hT()).append('\n');
         if(this.hS() != null) {
            var2.append("     concreteType.class=").append(this.hS().getCanonicalName()).append('\n');
         }

         StringBuilder var3 = var2.append("          converterName=");
         String var1;
         if(this.NU == null) {
            var1 = "null";
         } else {
            var1 = this.NU.getClass().getCanonicalName();
         }

         var3.append(var1).append('\n');
         return var2.toString();
      }

      public void writeToParcel(Parcel var1, int var2) {
         kt var3 = CREATOR;
         kt.a(this, var1, var2);
      }
   }

   public interface b {
      Object convertBack(Object var1);

      int hI();

      int hJ();
   }
}
