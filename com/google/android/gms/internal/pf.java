package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.internal.kr;
import com.google.android.gms.internal.ks;
import com.google.android.gms.internal.pd;
import com.google.android.gms.internal.pg;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class pf extends ks implements Moment {
   public static final pg CREATOR = new pg();
   private static final HashMap aom = new HashMap();
   String CE;
   final int CK;
   final Set aon;
   String apa;
   pd api;
   pd apj;
   String vc;

   static {
      aom.put("id", kr.a.l("id", 2));
      aom.put("result", kr.a.a("result", 4, pd.class));
      aom.put("startDate", kr.a.l("startDate", 5));
      aom.put("target", kr.a.a("target", 6, pd.class));
      aom.put("type", kr.a.l("type", 7));
   }

   public pf() {
      this.CK = 1;
      this.aon = new HashSet();
   }

   pf(Set var1, int var2, String var3, pd var4, String var5, pd var6, String var7) {
      this.aon = var1;
      this.CK = var2;
      this.CE = var3;
      this.api = var4;
      this.apa = var5;
      this.apj = var6;
      this.vc = var7;
   }

   public pf(Set var1, String var2, pd var3, String var4, pd var5, String var6) {
      this.aon = var1;
      this.CK = 1;
      this.CE = var2;
      this.api = var3;
      this.apa = var4;
      this.apj = var5;
      this.vc = var6;
   }

   protected boolean a(kr.a var1) {
      return this.aon.contains(Integer.valueOf(var1.hR()));
   }

   protected Object b(kr.a var1) {
      switch(var1.hR()) {
      case 2:
         return this.CE;
      case 3:
      default:
         throw new IllegalStateException("Unknown safe parcelable id=" + var1.hR());
      case 4:
         return this.api;
      case 5:
         return this.apa;
      case 6:
         return this.apj;
      case 7:
         return this.vc;
      }
   }

   public int describeContents() {
      pg var1 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof pf)) {
         return false;
      } else if(this == var1) {
         return true;
      } else {
         pf var4 = (pf)var1;
         Iterator var2 = aom.values().iterator();

         while(var2.hasNext()) {
            kr.a var3 = (kr.a)var2.next();
            if(this.a(var3)) {
               if(!var4.a(var3)) {
                  return false;
               }

               if(!this.b(var3).equals(var4.b(var3))) {
                  return false;
               }
            } else if(var4.a(var3)) {
               return false;
            }
         }

         return true;
      }
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.oJ();
   }

   public String getId() {
      return this.CE;
   }

   public ItemScope getResult() {
      return this.api;
   }

   public String getStartDate() {
      return this.apa;
   }

   public ItemScope getTarget() {
      return this.apj;
   }

   public String getType() {
      return this.vc;
   }

   public HashMap hK() {
      return aom;
   }

   public boolean hasId() {
      return this.aon.contains(Integer.valueOf(2));
   }

   public boolean hasResult() {
      return this.aon.contains(Integer.valueOf(4));
   }

   public boolean hasStartDate() {
      return this.aon.contains(Integer.valueOf(5));
   }

   public boolean hasTarget() {
      return this.aon.contains(Integer.valueOf(6));
   }

   public boolean hasType() {
      return this.aon.contains(Integer.valueOf(7));
   }

   public int hashCode() {
      Iterator var3 = aom.values().iterator();
      int var1 = 0;

      while(var3.hasNext()) {
         kr.a var4 = (kr.a)var3.next();
         if(this.a(var4)) {
            int var2 = var4.hR();
            var1 = this.b(var4).hashCode() + var1 + var2;
         }
      }

      return var1;
   }

   public boolean isDataValid() {
      return true;
   }

   public pf oJ() {
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      pg var3 = CREATOR;
      pg.a(this, var1, var2);
   }
}
