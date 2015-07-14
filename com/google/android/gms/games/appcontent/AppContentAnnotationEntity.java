package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.appcontent.AppContentAnnotation;
import com.google.android.gms.games.appcontent.AppContentAnnotationEntityCreator;
import com.google.android.gms.internal.jv;

public final class AppContentAnnotationEntity implements SafeParcelable, AppContentAnnotation {
   public static final AppContentAnnotationEntityCreator CREATOR = new AppContentAnnotationEntityCreator();
   private final int CK;
   private final String OH;
   private final String UO;
   private final Uri XN;
   private final String vc;

   AppContentAnnotationEntity(int var1, String var2, Uri var3, String var4, String var5) {
      this.CK = var1;
      this.UO = var2;
      this.XN = var3;
      this.OH = var4;
      this.vc = var5;
   }

   public AppContentAnnotationEntity(AppContentAnnotation var1) {
      this.CK = 1;
      this.UO = var1.getDescription();
      this.XN = var1.kL();
      this.OH = var1.getTitle();
      this.vc = var1.getType();
   }

   static int a(AppContentAnnotation var0) {
      return jv.hashCode(new Object[]{var0.getDescription(), var0.kL(), var0.getTitle(), var0.getType()});
   }

   static boolean a(AppContentAnnotation var0, Object var1) {
      boolean var3 = true;
      boolean var2;
      if(!(var1 instanceof AppContentAnnotation)) {
         var2 = false;
      } else {
         var2 = var3;
         if(var0 != var1) {
            AppContentAnnotation var4 = (AppContentAnnotation)var1;
            if(jv.equal(var4.getDescription(), var0.getDescription()) && jv.equal(var4.kL(), var0.kL()) && jv.equal(var4.getTitle(), var0.getTitle())) {
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

   static String b(AppContentAnnotation var0) {
      return jv.h(var0).a("Description", var0.getDescription()).a("ImageUri", var0.kL()).a("Title", var0.getTitle()).a("Type", var0.getType()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return a(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.kM();
   }

   public String getDescription() {
      return this.UO;
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

   public Uri kL() {
      return this.XN;
   }

   public AppContentAnnotation kM() {
      return this;
   }

   public String toString() {
      return b(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      AppContentAnnotationEntityCreator.a(this, var1, var2);
   }
}
