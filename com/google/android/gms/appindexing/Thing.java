package com.google.android.gms.appindexing;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.internal.jx;

public class Thing {
   final Bundle DI;

   Thing(Bundle var1) {
      this.DI = var1;
   }

   public Bundle fI() {
      return this.DI;
   }

   public static class Builder {
      final Bundle DJ = new Bundle();

      public Thing build() {
         return new Thing(this.DJ);
      }

      public Thing.Builder put(String var1, Thing var2) {
         jx.i(var1);
         if(var2 != null) {
            this.DJ.putParcelable(var1, var2.DI);
         }

         return this;
      }

      public Thing.Builder put(String var1, String var2) {
         jx.i(var1);
         if(var2 != null) {
            this.DJ.putString(var1, var2);
         }

         return this;
      }

      public Thing.Builder setDescription(String var1) {
         this.put("description", var1);
         return this;
      }

      public Thing.Builder setId(String var1) {
         if(var1 != null) {
            this.put("id", var1);
         }

         return this;
      }

      public Thing.Builder setName(String var1) {
         jx.i(var1);
         this.put("name", var1);
         return this;
      }

      public Thing.Builder setType(String var1) {
         this.put("type", var1);
         return this;
      }

      public Thing.Builder setUrl(Uri var1) {
         jx.i(var1);
         this.put("url", var1.toString());
         return this;
      }
   }
}
