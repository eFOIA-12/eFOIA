package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.c;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.in;
import com.google.android.gms.internal.jv;
import java.util.Locale;

public class LaunchOptions implements SafeParcelable {
   public static final Creator CREATOR = new c();
   private final int CK;
   private boolean FQ;
   private String FR;

   public LaunchOptions() {
      this(1, false, in.b(Locale.getDefault()));
   }

   LaunchOptions(int var1, boolean var2, String var3) {
      this.CK = var1;
      this.FQ = var2;
      this.FR = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof LaunchOptions)) {
            return false;
         }

         LaunchOptions var2 = (LaunchOptions)var1;
         if(this.FQ != var2.FQ || !in.a(this.FR, var2.FR)) {
            return false;
         }
      }

      return true;
   }

   public String getLanguage() {
      return this.FR;
   }

   public boolean getRelaunchIfRunning() {
      return this.FQ;
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{Boolean.valueOf(this.FQ), this.FR});
   }

   public void setLanguage(String var1) {
      this.FR = var1;
   }

   public void setRelaunchIfRunning(boolean var1) {
      this.FQ = var1;
   }

   public String toString() {
      return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s)", new Object[]{Boolean.valueOf(this.FQ), this.FR});
   }

   public void writeToParcel(Parcel var1, int var2) {
      c.a(this, var1, var2);
   }

   public static final class Builder {
      private LaunchOptions FS = new LaunchOptions();

      public LaunchOptions build() {
         return this.FS;
      }

      public LaunchOptions.Builder setLocale(Locale var1) {
         this.FS.setLanguage(in.b(var1));
         return this;
      }

      public LaunchOptions.Builder setRelaunchIfRunning(boolean var1) {
         this.FS.setRelaunchIfRunning(var1);
         return this;
      }
   }
}
