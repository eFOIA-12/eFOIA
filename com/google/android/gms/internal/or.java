package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ot;
import java.util.Iterator;

public class or implements SafeParcelable {
   public static final ot CREATOR = new ot();
   public final long amW;
   public final byte[] amX;
   public final Bundle amY;
   public final String tag;
   public final int versionCode;

   or(int var1, long var2, String var4, byte[] var5, Bundle var6) {
      this.versionCode = var1;
      this.amW = var2;
      this.tag = var4;
      this.amX = var5;
      this.amY = var6;
   }

   public or(long var1, String var3, byte[] var4, String... var5) {
      this.versionCode = 1;
      this.amW = var1;
      this.tag = var3;
      this.amX = var4;
      this.amY = g(var5);
   }

   private static Bundle g(String... var0) {
      Bundle var3 = null;
      if(var0 != null) {
         if(var0.length % 2 != 0) {
            throw new IllegalArgumentException("extras must have an even number of elements");
         }

         int var2 = var0.length / 2;
         if(var2 != 0) {
            Bundle var4 = new Bundle(var2);
            int var1 = 0;

            while(true) {
               var3 = var4;
               if(var1 >= var2) {
                  break;
               }

               var4.putString(var0[var1 * 2], var0[var1 * 2 + 1]);
               ++var1;
            }
         }
      }

      return var3;
   }

   public int describeContents() {
      return 0;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("tag=").append(this.tag).append(",");
      var1.append("eventTime=").append(this.amW).append(",");
      if(this.amY != null && !this.amY.isEmpty()) {
         var1.append("keyValues=");
         Iterator var2 = this.amY.keySet().iterator();

         while(var2.hasNext()) {
            String var3 = (String)var2.next();
            var1.append("(").append(var3).append(",");
            var1.append(this.amY.getString(var3)).append(")");
            var1.append(" ");
         }
      }

      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      ot.a(this, var1, var2);
   }
}
