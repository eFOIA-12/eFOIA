package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.kr;
import com.google.android.gms.internal.ku;
import com.google.android.gms.internal.kw;
import com.google.android.gms.internal.kx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class kv implements SafeParcelable {
   public static final kw CREATOR = new kw();
   private final int CK;
   private final HashMap NV;
   private final ArrayList NW;
   private final String NX;

   kv(int var1, ArrayList var2, String var3) {
      this.CK = var1;
      this.NW = null;
      this.NV = c(var2);
      this.NX = (String)jx.i(var3);
      this.hX();
   }

   public kv(Class var1) {
      this.CK = 1;
      this.NW = null;
      this.NV = new HashMap();
      this.NX = var1.getCanonicalName();
   }

   private static HashMap c(ArrayList var0) {
      HashMap var3 = new HashMap();
      int var2 = var0.size();

      for(int var1 = 0; var1 < var2; ++var1) {
         kv.a var4 = (kv.a)var0.get(var1);
         var3.put(var4.className, var4.ib());
      }

      return var3;
   }

   public void a(Class var1, HashMap var2) {
      this.NV.put(var1.getCanonicalName(), var2);
   }

   public boolean b(Class var1) {
      return this.NV.containsKey(var1.getCanonicalName());
   }

   public HashMap bg(String var1) {
      return (HashMap)this.NV.get(var1);
   }

   public int describeContents() {
      kw var1 = CREATOR;
      return 0;
   }

   int getVersionCode() {
      return this.CK;
   }

   public void hX() {
      Iterator var1 = this.NV.keySet().iterator();

      while(var1.hasNext()) {
         String var2 = (String)var1.next();
         HashMap var4 = (HashMap)this.NV.get(var2);
         Iterator var3 = var4.keySet().iterator();

         while(var3.hasNext()) {
            ((kr.a)var4.get((String)var3.next())).a(this);
         }
      }

   }

   public void hY() {
      Iterator var1 = this.NV.keySet().iterator();

      while(var1.hasNext()) {
         String var2 = (String)var1.next();
         HashMap var3 = (HashMap)this.NV.get(var2);
         HashMap var4 = new HashMap();
         Iterator var5 = var3.keySet().iterator();

         while(var5.hasNext()) {
            String var6 = (String)var5.next();
            var4.put(var6, ((kr.a)var3.get(var6)).hN());
         }

         this.NV.put(var2, var4);
      }

   }

   ArrayList hZ() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.NV.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var1.add(new kv.a(var3, (HashMap)this.NV.get(var3)));
      }

      return var1;
   }

   public String ia() {
      return this.NX;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      Iterator var2 = this.NV.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var1.append(var3).append(":\n");
         HashMap var6 = (HashMap)this.NV.get(var3);
         Iterator var4 = var6.keySet().iterator();

         while(var4.hasNext()) {
            String var5 = (String)var4.next();
            var1.append("  ").append(var5).append(": ");
            var1.append(var6.get(var5));
         }
      }

      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      kw var3 = CREATOR;
      kw.a(this, var1, var2);
   }

   public static class a implements SafeParcelable {
      public static final kx CREATOR = new kx();
      final ArrayList NY;
      final String className;
      final int versionCode;

      a(int var1, String var2, ArrayList var3) {
         this.versionCode = var1;
         this.className = var2;
         this.NY = var3;
      }

      a(String var1, HashMap var2) {
         this.versionCode = 1;
         this.className = var1;
         this.NY = a(var2);
      }

      private static ArrayList a(HashMap var0) {
         if(var0 == null) {
            return null;
         } else {
            ArrayList var1 = new ArrayList();
            Iterator var2 = var0.keySet().iterator();

            while(var2.hasNext()) {
               String var3 = (String)var2.next();
               var1.add(new kv.b(var3, (kr.a)var0.get(var3)));
            }

            return var1;
         }
      }

      public int describeContents() {
         kx var1 = CREATOR;
         return 0;
      }

      HashMap ib() {
         HashMap var3 = new HashMap();
         int var2 = this.NY.size();

         for(int var1 = 0; var1 < var2; ++var1) {
            kv.b var4 = (kv.b)this.NY.get(var1);
            var3.put(var4.fv, var4.NZ);
         }

         return var3;
      }

      public void writeToParcel(Parcel var1, int var2) {
         kx var3 = CREATOR;
         kx.a(this, var1, var2);
      }
   }

   public static class b implements SafeParcelable {
      public static final ku CREATOR = new ku();
      final kr.a NZ;
      final String fv;
      final int versionCode;

      b(int var1, String var2, kr.a var3) {
         this.versionCode = var1;
         this.fv = var2;
         this.NZ = var3;
      }

      b(String var1, kr.a var2) {
         this.versionCode = 1;
         this.fv = var1;
         this.NZ = var2;
      }

      public int describeContents() {
         ku var1 = CREATOR;
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         ku var3 = CREATOR;
         ku.a(this, var1, var2);
      }
   }
}
