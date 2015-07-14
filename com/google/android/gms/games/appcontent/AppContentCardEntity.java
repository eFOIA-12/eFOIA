package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.appcontent.AppContentAction;
import com.google.android.gms.games.appcontent.AppContentActionEntity;
import com.google.android.gms.games.appcontent.AppContentAnnotation;
import com.google.android.gms.games.appcontent.AppContentAnnotationEntity;
import com.google.android.gms.games.appcontent.AppContentCard;
import com.google.android.gms.games.appcontent.AppContentCardEntityCreator;
import com.google.android.gms.games.appcontent.AppContentCondition;
import com.google.android.gms.games.appcontent.AppContentConditionEntity;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;
import java.util.List;

public final class AppContentCardEntity implements SafeParcelable, AppContentCard {
   public static final AppContentCardEntityCreator CREATOR = new AppContentCardEntityCreator();
   private final int CK;
   private final String OH;
   private final String UO;
   private final Uri WD;
   private final ArrayList XJ;
   private final String XK;
   private final Uri XN;
   private final ArrayList XO;
   private final int XP;
   private final Bundle XQ;
   private final String XR;
   private final int XS;
   private final ArrayList mActions;
   private final String vc;

   AppContentCardEntity(int var1, ArrayList var2, ArrayList var3, ArrayList var4, String var5, int var6, String var7, Bundle var8, Uri var9, Uri var10, String var11, String var12, int var13, String var14) {
      this.CK = var1;
      this.mActions = var2;
      this.XO = var3;
      this.XJ = var4;
      this.XK = var5;
      this.XP = var6;
      this.UO = var7;
      this.XQ = var8;
      this.WD = var9;
      this.XN = var10;
      this.XR = var11;
      this.OH = var12;
      this.XS = var13;
      this.vc = var14;
   }

   public AppContentCardEntity(AppContentCard var1) {
      byte var3 = 0;
      super();
      this.CK = 1;
      this.XK = var1.kI();
      this.XP = var1.kO();
      this.UO = var1.getDescription();
      this.XQ = var1.kP();
      this.WD = var1.getIconImageUri();
      this.XN = var1.kL();
      this.OH = var1.getTitle();
      this.XR = var1.kQ();
      this.XS = var1.kR();
      this.vc = var1.getType();
      List var5 = var1.getActions();
      int var4 = var5.size();
      this.mActions = new ArrayList(var4);

      int var2;
      for(var2 = 0; var2 < var4; ++var2) {
         this.mActions.add((AppContentActionEntity)((AppContentActionEntity)((AppContentAction)var5.get(var2)).freeze()));
      }

      var5 = var1.kN();
      var4 = var5.size();
      this.XO = new ArrayList(var4);

      for(var2 = 0; var2 < var4; ++var2) {
         this.XO.add((AppContentAnnotationEntity)((AppContentAnnotationEntity)((AppContentAnnotation)var5.get(var2)).freeze()));
      }

      List var6 = var1.kH();
      var4 = var6.size();
      this.XJ = new ArrayList(var4);

      for(var2 = var3; var2 < var4; ++var2) {
         this.XJ.add((AppContentConditionEntity)((AppContentConditionEntity)((AppContentCondition)var6.get(var2)).freeze()));
      }

   }

   static int a(AppContentCard var0) {
      return jv.hashCode(new Object[]{var0.getActions(), var0.kN(), var0.kH(), var0.kI(), Integer.valueOf(var0.kO()), var0.getDescription(), var0.kP(), var0.getIconImageUri(), var0.kL(), var0.kQ(), var0.getTitle(), Integer.valueOf(var0.kR()), var0.getType()});
   }

   static boolean a(AppContentCard var0, Object var1) {
      boolean var3 = true;
      boolean var2;
      if(!(var1 instanceof AppContentCard)) {
         var2 = false;
      } else {
         var2 = var3;
         if(var0 != var1) {
            AppContentCard var4 = (AppContentCard)var1;
            if(jv.equal(var4.getActions(), var0.getActions()) && jv.equal(var4.kN(), var0.kN()) && jv.equal(var4.kH(), var0.kH()) && jv.equal(var4.kI(), var0.kI()) && jv.equal(Integer.valueOf(var4.kO()), Integer.valueOf(var0.kO())) && jv.equal(var4.getDescription(), var0.getDescription()) && jv.equal(var4.kP(), var0.kP()) && jv.equal(var4.getIconImageUri(), var0.getIconImageUri()) && jv.equal(var4.kL(), var0.kL()) && jv.equal(var4.kQ(), var0.kQ()) && jv.equal(var4.getTitle(), var0.getTitle()) && jv.equal(Integer.valueOf(var4.kR()), Integer.valueOf(var0.kR()))) {
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

   static String b(AppContentCard var0) {
      return jv.h(var0).a("Actions", var0.getActions()).a("Annotations", var0.kN()).a("Conditions", var0.kH()).a("ContentDescription", var0.kI()).a("CurrentSteps", Integer.valueOf(var0.kO())).a("Description", var0.getDescription()).a("ExtraData", var0.kP()).a("IconImageUri", var0.getIconImageUri()).a("ImageUri", var0.kL()).a("Subtitle", var0.kQ()).a("Title", var0.getTitle()).a("TotalSteps", Integer.valueOf(var0.kR())).a("Type", var0.getType()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return a(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.kS();
   }

   public List getActions() {
      return new ArrayList(this.mActions);
   }

   public String getDescription() {
      return this.UO;
   }

   public Uri getIconImageUri() {
      return this.WD;
   }

   public String getTitle() {
      return this.OH;
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

   public Uri kL() {
      return this.XN;
   }

   public List kN() {
      return new ArrayList(this.XO);
   }

   public int kO() {
      return this.XP;
   }

   public Bundle kP() {
      return this.XQ;
   }

   public String kQ() {
      return this.XR;
   }

   public int kR() {
      return this.XS;
   }

   public AppContentCard kS() {
      return this;
   }

   public String toString() {
      return b(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      AppContentCardEntityCreator.a(this, var1, var2);
   }
}
