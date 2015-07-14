package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.oi;
import java.util.Locale;

public class oh implements SafeParcelable {
   public static final oi CREATOR;
   public static final oh akf;
   public final String akg;
   public final String akh;
   public final String aki;
   public final String akj;
   public final int versionCode;

   static {
      akf = new oh("com.google.android.gms", Locale.ENGLISH, (String)null);
      CREATOR = new oi();
   }

   public oh(int var1, String var2, String var3, String var4, String var5) {
      this.versionCode = var1;
      this.akg = var2;
      this.akh = var3;
      this.aki = var4;
      this.akj = var5;
   }

   public oh(String var1, Locale var2, String var3) {
      this(1, var1, var2.toString(), var3, (String)null);
   }

   public int describeContents() {
      oi var1 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 == null || !(var1 instanceof oh)) {
            return false;
         }

         oh var2 = (oh)var1;
         if(!this.akh.equals(var2.akh) || !this.akg.equals(var2.akg) || !jv.equal(this.aki, var2.aki) || !jv.equal(this.akj, var2.akj)) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.akg, this.akh, this.aki});
   }

   public String toString() {
      return jv.h(this).a("clientPackageName", this.akg).a("locale", this.akh).a("accountName", this.aki).a("gCoreClientName", this.akj).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      oi var3 = CREATOR;
      oi.a(this, var1, var2);
   }
}
