package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kp;
import com.google.android.gms.internal.kq;
import com.google.android.gms.internal.kr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class ko implements SafeParcelable, kr.b {
   public static final kp CREATOR = new kp();
   private final int CK;
   private final HashMap NG;
   private final HashMap NH;
   private final ArrayList NI;

   public ko() {
      this.CK = 1;
      this.NG = new HashMap();
      this.NH = new HashMap();
      this.NI = null;
   }

   ko(int var1, ArrayList var2) {
      this.CK = var1;
      this.NG = new HashMap();
      this.NH = new HashMap();
      this.NI = null;
      this.b(var2);
   }

   private void b(ArrayList var1) {
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         ko.a var2 = (ko.a)var3.next();
         this.h(var2.NJ, var2.NK);
      }

   }

   public String a(Integer var1) {
      String var2 = (String)this.NH.get(var1);
      String var3 = var2;
      if(var2 == null) {
         var3 = var2;
         if(this.NG.containsKey("gms_unknown")) {
            var3 = "gms_unknown";
         }
      }

      return var3;
   }

   // $FF: synthetic method
   public Object convertBack(Object var1) {
      return this.a((Integer)var1);
   }

   public int describeContents() {
      kp var1 = CREATOR;
      return 0;
   }

   int getVersionCode() {
      return this.CK;
   }

   public ko h(String var1, int var2) {
      this.NG.put(var1, Integer.valueOf(var2));
      this.NH.put(Integer.valueOf(var2), var1);
      return this;
   }

   ArrayList hH() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.NG.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var1.add(new ko.a(var3, ((Integer)this.NG.get(var3)).intValue()));
      }

      return var1;
   }

   public int hI() {
      return 7;
   }

   public int hJ() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      kp var3 = CREATOR;
      kp.a(this, var1, var2);
   }

   public static final class a implements SafeParcelable {
      public static final kq CREATOR = new kq();
      final String NJ;
      final int NK;
      final int versionCode;

      a(int var1, String var2, int var3) {
         this.versionCode = var1;
         this.NJ = var2;
         this.NK = var3;
      }

      a(String var1, int var2) {
         this.versionCode = 1;
         this.NJ = var1;
         this.NK = var2;
      }

      public int describeContents() {
         kq var1 = CREATOR;
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         kq var3 = CREATOR;
         kq.a(this, var1, var2);
      }
   }
}
