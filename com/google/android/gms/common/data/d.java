package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;

public abstract class d {
   protected final DataHolder JG;
   protected int KZ;
   private int La;

   public d(DataHolder var1, int var2) {
      this.JG = (DataHolder)jx.i(var1);
      this.as(var2);
   }

   protected void a(String var1, CharArrayBuffer var2) {
      this.JG.a(var1, this.KZ, this.La, var2);
   }

   public boolean aQ(String var1) {
      return this.JG.aQ(var1);
   }

   protected Uri aR(String var1) {
      return this.JG.g(var1, this.KZ, this.La);
   }

   protected boolean aS(String var1) {
      return this.JG.h(var1, this.KZ, this.La);
   }

   protected void as(int var1) {
      boolean var2;
      if(var1 >= 0 && var1 < this.JG.getCount()) {
         var2 = true;
      } else {
         var2 = false;
      }

      jx.K(var2);
      this.KZ = var1;
      this.La = this.JG.au(this.KZ);
   }

   public boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2 = var3;
      if(var1 instanceof d) {
         d var4 = (d)var1;
         var2 = var3;
         if(jv.equal(Integer.valueOf(var4.KZ), Integer.valueOf(this.KZ))) {
            var2 = var3;
            if(jv.equal(Integer.valueOf(var4.La), Integer.valueOf(this.La))) {
               var2 = var3;
               if(var4.JG == this.JG) {
                  var2 = true;
               }
            }
         }
      }

      return var2;
   }

   protected int gW() {
      return this.KZ;
   }

   protected boolean getBoolean(String var1) {
      return this.JG.d(var1, this.KZ, this.La);
   }

   protected byte[] getByteArray(String var1) {
      return this.JG.f(var1, this.KZ, this.La);
   }

   protected float getFloat(String var1) {
      return this.JG.e(var1, this.KZ, this.La);
   }

   protected int getInteger(String var1) {
      return this.JG.b(var1, this.KZ, this.La);
   }

   protected long getLong(String var1) {
      return this.JG.a(var1, this.KZ, this.La);
   }

   protected String getString(String var1) {
      return this.JG.c(var1, this.KZ, this.La);
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{Integer.valueOf(this.KZ), Integer.valueOf(this.La), this.JG});
   }

   public boolean isDataValid() {
      return !this.JG.isClosed();
   }
}
