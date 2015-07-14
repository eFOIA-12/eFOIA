package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.appcontent.AppContentAction;
import com.google.android.gms.games.appcontent.AppContentActionEntity;
import com.google.android.gms.games.appcontent.AppContentCard;
import com.google.android.gms.games.appcontent.AppContentCardEntity;
import com.google.android.gms.games.appcontent.AppContentSection;
import com.google.android.gms.games.appcontent.AppContentSectionEntityCreator;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;
import java.util.List;

public final class AppContentSectionEntity implements SafeParcelable, AppContentSection {
   public static final AppContentSectionEntityCreator CREATOR = new AppContentSectionEntityCreator();
   private final int CK;
   private final String OH;
   private final String XK;
   private final Bundle XQ;
   private final String XR;
   private final Uri XY;
   private final ArrayList XZ;
   private final ArrayList mActions;
   private final String vc;

   AppContentSectionEntity(int var1, ArrayList var2, Uri var3, ArrayList var4, String var5, Bundle var6, String var7, String var8, String var9) {
      this.CK = var1;
      this.mActions = var2;
      this.XY = var3;
      this.XZ = var4;
      this.XK = var5;
      this.XQ = var6;
      this.XR = var7;
      this.OH = var8;
      this.vc = var9;
   }

   public AppContentSectionEntity(AppContentSection var1) {
      byte var3 = 0;
      super();
      this.CK = 1;
      this.XY = var1.kY();
      this.XK = var1.kI();
      this.XQ = var1.kP();
      this.XR = var1.kQ();
      this.OH = var1.getTitle();
      this.vc = var1.getType();
      List var5 = var1.getActions();
      int var4 = var5.size();
      this.mActions = new ArrayList(var4);

      int var2;
      for(var2 = 0; var2 < var4; ++var2) {
         this.mActions.add((AppContentActionEntity)((AppContentActionEntity)((AppContentAction)var5.get(var2)).freeze()));
      }

      List var6 = var1.kZ();
      var4 = var6.size();
      this.XZ = new ArrayList(var4);

      for(var2 = var3; var2 < var4; ++var2) {
         this.XZ.add((AppContentCardEntity)((AppContentCardEntity)((AppContentCard)var6.get(var2)).freeze()));
      }

   }

   static int a(AppContentSection var0) {
      return jv.hashCode(new Object[]{var0.getActions(), var0.kY(), var0.kZ(), var0.kI(), var0.kP(), var0.kQ(), var0.getTitle(), var0.getType()});
   }

   static boolean a(AppContentSection var0, Object var1) {
      boolean var3 = true;
      boolean var2;
      if(!(var1 instanceof AppContentSection)) {
         var2 = false;
      } else {
         var2 = var3;
         if(var0 != var1) {
            AppContentSection var4 = (AppContentSection)var1;
            if(jv.equal(var4.getActions(), var0.getActions()) && jv.equal(var4.kY(), var0.kY()) && jv.equal(var4.kZ(), var0.kZ()) && jv.equal(var4.kI(), var0.kI()) && jv.equal(var4.kP(), var0.kP()) && jv.equal(var4.kQ(), var0.kQ()) && jv.equal(var4.getTitle(), var0.getTitle())) {
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

   static String b(AppContentSection var0) {
      return jv.h(var0).a("Actions", var0.getActions()).a("BackgroundImageUri", var0.kY()).a("Cards", var0.kZ()).a("ContentDescription", var0.kI()).a("ExtraData", var0.kP()).a("Subtitle", var0.kQ()).a("Title", var0.getTitle()).a("Type", var0.getType()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return a(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.la();
   }

   public List getActions() {
      return new ArrayList(this.mActions);
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

   public String kI() {
      return this.XK;
   }

   public Bundle kP() {
      return this.XQ;
   }

   public String kQ() {
      return this.XR;
   }

   public Uri kY() {
      return this.XY;
   }

   public List kZ() {
      return new ArrayList(this.XZ);
   }

   public AppContentSection la() {
      return this;
   }

   public String toString() {
      return b(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      AppContentSectionEntityCreator.a(this, var1, var2);
   }
}
