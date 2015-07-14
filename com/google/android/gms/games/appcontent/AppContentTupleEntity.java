package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.appcontent.AppContentTuple;
import com.google.android.gms.games.appcontent.AppContentTupleEntityCreator;
import com.google.android.gms.internal.jv;

public final class AppContentTupleEntity implements SafeParcelable, AppContentTuple {
   public static final AppContentTupleEntityCreator CREATOR = new AppContentTupleEntityCreator();
   private final int CK;
   private final String mName;
   private final String mValue;

   AppContentTupleEntity(int var1, String var2, String var3) {
      this.CK = var1;
      this.mName = var2;
      this.mValue = var3;
   }

   public AppContentTupleEntity(AppContentTuple var1) {
      this.CK = 1;
      this.mName = var1.getName();
      this.mValue = var1.getValue();
   }

   static int a(AppContentTuple var0) {
      return jv.hashCode(new Object[]{var0.getName(), var0.getValue()});
   }

   static boolean a(AppContentTuple var0, Object var1) {
      boolean var3 = true;
      boolean var2;
      if(!(var1 instanceof AppContentTuple)) {
         var2 = false;
      } else {
         var2 = var3;
         if(var0 != var1) {
            AppContentTuple var4 = (AppContentTuple)var1;
            if(jv.equal(var4.getName(), var0.getName())) {
               var2 = var3;
               if(jv.equal(var4.getValue(), var0.getValue())) {
                  return var2;
               }
            }

            return false;
         }
      }

      return var2;
   }

   static String b(AppContentTuple var0) {
      return jv.h(var0).a("Name", var0.getName()).a("Value", var0.getValue()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return a(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.ld();
   }

   public String getName() {
      return this.mName;
   }

   public String getValue() {
      return this.mValue;
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

   public AppContentTuple ld() {
      return this;
   }

   public String toString() {
      return b(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      AppContentTupleEntityCreator.a(this, var1, var2);
   }
}
