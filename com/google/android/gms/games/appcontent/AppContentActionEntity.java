package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.appcontent.AppContentAction;
import com.google.android.gms.games.appcontent.AppContentActionEntityCreator;
import com.google.android.gms.games.appcontent.AppContentCondition;
import com.google.android.gms.games.appcontent.AppContentConditionEntity;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;
import java.util.List;

public final class AppContentActionEntity implements SafeParcelable, AppContentAction {
   public static final AppContentActionEntityCreator CREATOR = new AppContentActionEntityCreator();
   private final int CK;
   private final ArrayList XJ;
   private final String XK;
   private final String XL;
   private final String XM;
   private final Bundle mExtras;
   private final String vc;

   AppContentActionEntity(int var1, ArrayList var2, String var3, Bundle var4, String var5, String var6, String var7) {
      this.CK = var1;
      this.XJ = var2;
      this.XK = var3;
      this.mExtras = var4;
      this.XL = var5;
      this.XM = var6;
      this.vc = var7;
   }

   public AppContentActionEntity(AppContentAction var1) {
      this.CK = 1;
      this.XK = var1.kI();
      this.mExtras = var1.getExtras();
      this.XL = var1.getLabel();
      this.XM = var1.kJ();
      this.vc = var1.getType();
      List var4 = var1.kH();
      int var3 = var4.size();
      this.XJ = new ArrayList(var3);

      for(int var2 = 0; var2 < var3; ++var2) {
         this.XJ.add((AppContentConditionEntity)((AppContentConditionEntity)((AppContentCondition)var4.get(var2)).freeze()));
      }

   }

   static int a(AppContentAction var0) {
      return jv.hashCode(new Object[]{var0.kH(), var0.kI(), var0.getExtras(), var0.getLabel(), var0.kJ(), var0.getType()});
   }

   static boolean a(AppContentAction var0, Object var1) {
      boolean var3 = true;
      boolean var2;
      if(!(var1 instanceof AppContentAction)) {
         var2 = false;
      } else {
         var2 = var3;
         if(var0 != var1) {
            AppContentAction var4 = (AppContentAction)var1;
            if(jv.equal(var4.kH(), var0.kH()) && jv.equal(var4.kI(), var0.kI()) && jv.equal(var4.getExtras(), var0.getExtras()) && jv.equal(var4.getLabel(), var0.getLabel()) && jv.equal(var4.kJ(), var0.kJ())) {
               var2 = var3;
               if(jv.equal(var4.getType(), var0.getType())) {
                  return var2;
               }
            }

            return false;
         }
      }

      return var2;
   }

   static String b(AppContentAction var0) {
      return jv.h(var0).a("Conditions", var0.kH()).a("ContentDescription", var0.kI()).a("Extras", var0.getExtras()).a("Label", var0.getLabel()).a("LabelStyle", var0.kJ()).a("Type", var0.getType()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return a(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.kK();
   }

   public Bundle getExtras() {
      return this.mExtras;
   }

   public String getLabel() {
      return this.XL;
   }

   public String getType() {
      return this.vc;
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

   public List kH() {
      return new ArrayList(this.XJ);
   }

   public String kI() {
      return this.XK;
   }

   public String kJ() {
      return this.XM;
   }

   public AppContentAction kK() {
      return this;
   }

   public String toString() {
      return b(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      AppContentActionEntityCreator.a(this, var1, var2);
   }
}
