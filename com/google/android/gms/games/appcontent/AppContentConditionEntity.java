package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.appcontent.AppContentCondition;
import com.google.android.gms.games.appcontent.AppContentConditionEntityCreator;
import com.google.android.gms.internal.jv;

public final class AppContentConditionEntity implements SafeParcelable, AppContentCondition {
   public static final AppContentConditionEntityCreator CREATOR = new AppContentConditionEntityCreator();
   private final int CK;
   private final String XT;
   private final String XU;
   private final String XV;
   private final Bundle XW;

   AppContentConditionEntity(int var1, String var2, String var3, String var4, Bundle var5) {
      this.CK = var1;
      this.XT = var2;
      this.XU = var3;
      this.XV = var4;
      this.XW = var5;
   }

   public AppContentConditionEntity(AppContentCondition var1) {
      this.CK = 1;
      this.XT = var1.kT();
      this.XU = var1.kT();
      this.XV = var1.kV();
      this.XW = var1.kW();
   }

   static int a(AppContentCondition var0) {
      return jv.hashCode(new Object[]{var0.kT(), var0.kU(), var0.kV(), var0.kW()});
   }

   static boolean a(AppContentCondition var0, Object var1) {
      boolean var3 = true;
      boolean var2;
      if(!(var1 instanceof AppContentCondition)) {
         var2 = false;
      } else {
         var2 = var3;
         if(var0 != var1) {
            AppContentCondition var4 = (AppContentCondition)var1;
            if(jv.equal(var4.kT(), var0.kT()) && jv.equal(var4.kU(), var0.kU()) && jv.equal(var4.kV(), var0.kV())) {
               var2 = var3;
               if(jv.equal(var4.kW(), var0.kW())) {
                  return var2;
               }
            }

            return false;
         }
      }

      return var2;
   }

   static String b(AppContentCondition var0) {
      return jv.h(var0).a("DefaultValue", var0.kT()).a("ExpectedValue", var0.kU()).a("Predicate", var0.kV()).a("PredicateParameters", var0.kW()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return a(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.kX();
   }

   public int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return a(this);
   }

   public boolean isDataValid() {
      return true;
   }

   public String kT() {
      return this.XT;
   }

   public String kU() {
      return this.XU;
   }

   public String kV() {
      return this.XV;
   }

   public Bundle kW() {
      return this.XW;
   }

   public AppContentCondition kX() {
      return this;
   }

   public String toString() {
      return b(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      AppContentConditionEntityCreator.a(this, var1, var2);
   }
}
