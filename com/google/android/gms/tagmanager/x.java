package com.google.android.gms.tagmanager;

import android.util.Log;
import com.google.android.gms.tagmanager.bi;

class x implements bi {
   private int yM = 5;

   public void S(String var1) {
      if(this.yM <= 3) {
         Log.d("GoogleTagManager", var1);
      }

   }

   public void T(String var1) {
      if(this.yM <= 6) {
         Log.e("GoogleTagManager", var1);
      }

   }

   public void U(String var1) {
      if(this.yM <= 4) {
         Log.i("GoogleTagManager", var1);
      }

   }

   public void V(String var1) {
      if(this.yM <= 2) {
         Log.v("GoogleTagManager", var1);
      }

   }

   public void W(String var1) {
      if(this.yM <= 5) {
         Log.w("GoogleTagManager", var1);
      }

   }

   public void b(String var1, Throwable var2) {
      if(this.yM <= 6) {
         Log.e("GoogleTagManager", var1, var2);
      }

   }

   public void d(String var1, Throwable var2) {
      if(this.yM <= 5) {
         Log.w("GoogleTagManager", var1, var2);
      }

   }

   public void setLogLevel(int var1) {
      this.yM = var1;
   }
}
