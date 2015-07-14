package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.kr;
import com.google.android.gms.internal.kv;
import com.google.android.gms.internal.kz;
import com.google.android.gms.internal.la;
import com.google.android.gms.internal.lb;
import com.google.android.gms.internal.li;
import com.google.android.gms.internal.lj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class ky extends kr implements SafeParcelable {
   public static final kz CREATOR = new kz();
   private final int CK;
   private final kv NT;
   private final Parcel Oa;
   private final int Ob;
   private int Oc;
   private int Od;
   private final String mClassName;

   ky(int var1, Parcel var2, kv var3) {
      this.CK = var1;
      this.Oa = (Parcel)jx.i(var2);
      this.Ob = 2;
      this.NT = var3;
      if(this.NT == null) {
         this.mClassName = null;
      } else {
         this.mClassName = this.NT.ia();
      }

      this.Oc = 2;
   }

   private ky(SafeParcelable var1, kv var2, String var3) {
      this.CK = 1;
      this.Oa = Parcel.obtain();
      var1.writeToParcel(this.Oa, 0);
      this.Ob = 1;
      this.NT = (kv)jx.i(var2);
      this.mClassName = (String)jx.i(var3);
      this.Oc = 2;
   }

   public static ky a(kr var0) {
      String var1 = var0.getClass().getCanonicalName();
      kv var2 = b(var0);
      return new ky((SafeParcelable)var0, var2, var1);
   }

   private static void a(kv var0, kr var1) {
      Class var3 = var1.getClass();
      if(!var0.b(var3)) {
         HashMap var2 = var1.hK();
         var0.a(var3, var1.hK());
         Iterator var8 = var2.keySet().iterator();

         while(var8.hasNext()) {
            kr.a var7 = (kr.a)var2.get((String)var8.next());
            Class var4 = var7.hS();
            if(var4 != null) {
               try {
                  a(var0, (kr)var4.newInstance());
               } catch (InstantiationException var5) {
                  throw new IllegalStateException("Could not instantiate an object of type " + var7.hS().getCanonicalName(), var5);
               } catch (IllegalAccessException var6) {
                  throw new IllegalStateException("Could not access object of type " + var7.hS().getCanonicalName(), var6);
               }
            }
         }
      }

   }

   private void a(StringBuilder var1, int var2, Object var3) {
      switch(var2) {
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
         var1.append(var3);
         return;
      case 7:
         var1.append("\"").append(li.bh(var3.toString())).append("\"");
         return;
      case 8:
         var1.append("\"").append(lb.d((byte[])((byte[])var3))).append("\"");
         return;
      case 9:
         var1.append("\"").append(lb.e((byte[])((byte[])var3)));
         var1.append("\"");
         return;
      case 10:
         lj.a(var1, (HashMap)var3);
         return;
      case 11:
         throw new IllegalArgumentException("Method does not accept concrete type.");
      default:
         throw new IllegalArgumentException("Unknown type = " + var2);
      }
   }

   private void a(StringBuilder var1, kr.a var2, Parcel var3, int var4) {
      switch(var2.hJ()) {
      case 0:
         this.b(var1, var2, this.a(var2, Integer.valueOf(com.google.android.gms.common.internal.safeparcel.a.g(var3, var4))));
         return;
      case 1:
         this.b(var1, var2, this.a(var2, com.google.android.gms.common.internal.safeparcel.a.k(var3, var4)));
         return;
      case 2:
         this.b(var1, var2, this.a(var2, Long.valueOf(com.google.android.gms.common.internal.safeparcel.a.i(var3, var4))));
         return;
      case 3:
         this.b(var1, var2, this.a(var2, Float.valueOf(com.google.android.gms.common.internal.safeparcel.a.l(var3, var4))));
         return;
      case 4:
         this.b(var1, var2, this.a(var2, Double.valueOf(com.google.android.gms.common.internal.safeparcel.a.m(var3, var4))));
         return;
      case 5:
         this.b(var1, var2, this.a(var2, com.google.android.gms.common.internal.safeparcel.a.n(var3, var4)));
         return;
      case 6:
         this.b(var1, var2, this.a(var2, Boolean.valueOf(com.google.android.gms.common.internal.safeparcel.a.c(var3, var4))));
         return;
      case 7:
         this.b(var1, var2, this.a(var2, com.google.android.gms.common.internal.safeparcel.a.o(var3, var4)));
         return;
      case 8:
      case 9:
         this.b(var1, var2, this.a(var2, com.google.android.gms.common.internal.safeparcel.a.r(var3, var4)));
         return;
      case 10:
         this.b(var1, var2, this.a(var2, g(com.google.android.gms.common.internal.safeparcel.a.q(var3, var4))));
         return;
      case 11:
         throw new IllegalArgumentException("Method does not accept concrete type.");
      default:
         throw new IllegalArgumentException("Unknown field out type = " + var2.hJ());
      }
   }

   private void a(StringBuilder var1, String var2, kr.a var3, Parcel var4, int var5) {
      var1.append("\"").append(var2).append("\":");
      if(var3.hU()) {
         this.a(var1, var3, var4, var5);
      } else {
         this.b(var1, var3, var4, var5);
      }
   }

   private void a(StringBuilder var1, HashMap var2, Parcel var3) {
      var2 = b(var2);
      var1.append('{');
      int var5 = com.google.android.gms.common.internal.safeparcel.a.G(var3);
      boolean var4 = false;

      while(var3.dataPosition() < var5) {
         int var6 = com.google.android.gms.common.internal.safeparcel.a.F(var3);
         Entry var7 = (Entry)var2.get(Integer.valueOf(com.google.android.gms.common.internal.safeparcel.a.aH(var6)));
         if(var7 != null) {
            if(var4) {
               var1.append(",");
            }

            this.a(var1, (String)var7.getKey(), (kr.a)var7.getValue(), var3, var6);
            var4 = true;
         }
      }

      if(var3.dataPosition() != var5) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var5, var3);
      } else {
         var1.append('}');
      }
   }

   private static kv b(kr var0) {
      kv var1 = new kv(var0.getClass());
      a(var1, var0);
      var1.hY();
      var1.hX();
      return var1;
   }

   private static HashMap b(HashMap var0) {
      HashMap var1 = new HashMap();
      Iterator var3 = var0.entrySet().iterator();

      while(var3.hasNext()) {
         Entry var2 = (Entry)var3.next();
         var1.put(Integer.valueOf(((kr.a)var2.getValue()).hR()), var2);
      }

      return var1;
   }

   private void b(StringBuilder var1, kr.a var2, Parcel var3, int var4) {
      if(!var2.hP()) {
         byte[] var8;
         switch(var2.hJ()) {
         case 0:
            var1.append(com.google.android.gms.common.internal.safeparcel.a.g(var3, var4));
            return;
         case 1:
            var1.append(com.google.android.gms.common.internal.safeparcel.a.k(var3, var4));
            return;
         case 2:
            var1.append(com.google.android.gms.common.internal.safeparcel.a.i(var3, var4));
            return;
         case 3:
            var1.append(com.google.android.gms.common.internal.safeparcel.a.l(var3, var4));
            return;
         case 4:
            var1.append(com.google.android.gms.common.internal.safeparcel.a.m(var3, var4));
            return;
         case 5:
            var1.append(com.google.android.gms.common.internal.safeparcel.a.n(var3, var4));
            return;
         case 6:
            var1.append(com.google.android.gms.common.internal.safeparcel.a.c(var3, var4));
            return;
         case 7:
            String var9 = com.google.android.gms.common.internal.safeparcel.a.o(var3, var4);
            var1.append("\"").append(li.bh(var9)).append("\"");
            return;
         case 8:
            var8 = com.google.android.gms.common.internal.safeparcel.a.r(var3, var4);
            var1.append("\"").append(lb.d(var8)).append("\"");
            return;
         case 9:
            var8 = com.google.android.gms.common.internal.safeparcel.a.r(var3, var4);
            var1.append("\"").append(lb.e(var8));
            var1.append("\"");
            return;
         case 10:
            Bundle var7 = com.google.android.gms.common.internal.safeparcel.a.q(var3, var4);
            Set var11 = var7.keySet();
            var11.size();
            var1.append("{");
            Iterator var12 = var11.iterator();

            for(boolean var13 = true; var12.hasNext(); var13 = false) {
               String var6 = (String)var12.next();
               if(!var13) {
                  var1.append(",");
               }

               var1.append("\"").append(var6).append("\"");
               var1.append(":");
               var1.append("\"").append(li.bh(var7.getString(var6))).append("\"");
            }

            var1.append("}");
            return;
         case 11:
            var3 = com.google.android.gms.common.internal.safeparcel.a.D(var3, var4);
            var3.setDataPosition(0);
            this.a(var1, var2.hW(), var3);
            return;
         default:
            throw new IllegalStateException("Unknown field type out");
         }
      } else {
         var1.append("[");
         label56:
         switch(var2.hJ()) {
         case 0:
            la.a(var1, com.google.android.gms.common.internal.safeparcel.a.u(var3, var4));
            break;
         case 1:
            la.a((StringBuilder)var1, (Object[])com.google.android.gms.common.internal.safeparcel.a.w(var3, var4));
            break;
         case 2:
            la.a(var1, com.google.android.gms.common.internal.safeparcel.a.v(var3, var4));
            break;
         case 3:
            la.a(var1, com.google.android.gms.common.internal.safeparcel.a.x(var3, var4));
            break;
         case 4:
            la.a(var1, com.google.android.gms.common.internal.safeparcel.a.y(var3, var4));
            break;
         case 5:
            la.a((StringBuilder)var1, (Object[])com.google.android.gms.common.internal.safeparcel.a.z(var3, var4));
            break;
         case 6:
            la.a(var1, com.google.android.gms.common.internal.safeparcel.a.t(var3, var4));
            break;
         case 7:
            la.a(var1, com.google.android.gms.common.internal.safeparcel.a.A(var3, var4));
            break;
         case 8:
         case 9:
         case 10:
            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
         case 11:
            Parcel[] var10 = com.google.android.gms.common.internal.safeparcel.a.E(var3, var4);
            int var5 = var10.length;
            var4 = 0;

            while(true) {
               if(var4 >= var5) {
                  break label56;
               }

               if(var4 > 0) {
                  var1.append(",");
               }

               var10[var4].setDataPosition(0);
               this.a(var1, var2.hW(), var10[var4]);
               ++var4;
            }
         default:
            throw new IllegalStateException("Unknown field type out.");
         }

         var1.append("]");
      }
   }

   private void b(StringBuilder var1, kr.a var2, Object var3) {
      if(var2.hO()) {
         this.b(var1, var2, (ArrayList)var3);
      } else {
         this.a(var1, var2.hI(), var3);
      }
   }

   private void b(StringBuilder var1, kr.a var2, ArrayList var3) {
      var1.append("[");
      int var5 = var3.size();

      for(int var4 = 0; var4 < var5; ++var4) {
         if(var4 != 0) {
            var1.append(",");
         }

         this.a(var1, var2.hI(), var3.get(var4));
      }

      var1.append("]");
   }

   public static HashMap g(Bundle var0) {
      HashMap var1 = new HashMap();
      Iterator var2 = var0.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var1.put(var3, var0.getString(var3));
      }

      return var1;
   }

   protected Object bc(String var1) {
      throw new UnsupportedOperationException("Converting to JSON does not require this method.");
   }

   protected boolean bd(String var1) {
      throw new UnsupportedOperationException("Converting to JSON does not require this method.");
   }

   public int describeContents() {
      kz var1 = CREATOR;
      return 0;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public HashMap hK() {
      return this.NT == null?null:this.NT.bg(this.mClassName);
   }

   public Parcel ic() {
      switch(this.Oc) {
      case 0:
         this.Od = com.google.android.gms.common.internal.safeparcel.b.H(this.Oa);
         com.google.android.gms.common.internal.safeparcel.b.H(this.Oa, this.Od);
         this.Oc = 2;
         break;
      case 1:
         com.google.android.gms.common.internal.safeparcel.b.H(this.Oa, this.Od);
         this.Oc = 2;
      }

      return this.Oa;
   }

   kv id() {
      switch(this.Ob) {
      case 0:
         return null;
      case 1:
         return this.NT;
      case 2:
         return this.NT;
      default:
         throw new IllegalStateException("Invalid creation type: " + this.Ob);
      }
   }

   public String toString() {
      jx.b((Object)this.NT, "Cannot convert to JSON on client side.");
      Parcel var1 = this.ic();
      var1.setDataPosition(0);
      StringBuilder var2 = new StringBuilder(100);
      this.a(var2, this.NT.bg(this.mClassName), var1);
      return var2.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      kz var3 = CREATOR;
      kz.a(this, var1, var2);
   }
}
