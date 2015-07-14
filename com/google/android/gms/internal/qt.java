package com.google.android.gms.internal;

import com.google.android.gms.internal.qp;
import com.google.android.gms.internal.qr;
import com.google.android.gms.internal.qy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class qt {
   private qr azd;
   private Object aze;
   private List azf = new ArrayList();

   private byte[] toByteArray() throws IOException {
      byte[] var1 = new byte[this.c()];
      this.a(qp.q(var1));
      return var1;
   }

   void a(qp var1) throws IOException {
      if(this.aze != null) {
         this.azd.a(this.aze, var1);
      } else {
         Iterator var2 = this.azf.iterator();

         while(var2.hasNext()) {
            ((qy)var2.next()).a(var1);
         }
      }

   }

   void a(qy var1) {
      this.azf.add(var1);
   }

   Object b(qr var1) {
      if(this.aze != null) {
         if(this.azd != var1) {
            throw new IllegalStateException("Tried to getExtension with a differernt Extension.");
         }
      } else {
         this.azd = var1;
         this.aze = var1.m(this.azf);
         this.azf = null;
      }

      return this.aze;
   }

   int c() {
      int var2;
      if(this.aze != null) {
         var2 = this.azd.B(this.aze);
      } else {
         Iterator var3 = this.azf.iterator();
         int var1 = 0;

         while(true) {
            var2 = var1;
            if(!var3.hasNext()) {
               break;
            }

            var1 += ((qy)var3.next()).c();
         }
      }

      return var2;
   }

   public boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2;
      if(var1 == this) {
         var2 = true;
      } else {
         var2 = var3;
         if(var1 instanceof qt) {
            qt var5 = (qt)var1;
            if(this.aze == null || var5.aze == null) {
               if(this.azf != null && var5.azf != null) {
                  return this.azf.equals(var5.azf);
               }

               try {
                  var2 = Arrays.equals(this.toByteArray(), var5.toByteArray());
                  return var2;
               } catch (IOException var4) {
                  throw new IllegalStateException(var4);
               }
            }

            var2 = var3;
            if(this.azd == var5.azd) {
               if(!this.azd.ayX.isArray()) {
                  return this.aze.equals(var5.aze);
               }

               if(this.aze instanceof byte[]) {
                  return Arrays.equals((byte[])((byte[])this.aze), (byte[])((byte[])var5.aze));
               }

               if(this.aze instanceof int[]) {
                  return Arrays.equals((int[])((int[])this.aze), (int[])((int[])var5.aze));
               }

               if(this.aze instanceof long[]) {
                  return Arrays.equals((long[])((long[])this.aze), (long[])((long[])var5.aze));
               }

               if(this.aze instanceof float[]) {
                  return Arrays.equals((float[])((float[])this.aze), (float[])((float[])var5.aze));
               }

               if(this.aze instanceof double[]) {
                  return Arrays.equals((double[])((double[])this.aze), (double[])((double[])var5.aze));
               }

               if(this.aze instanceof boolean[]) {
                  return Arrays.equals((boolean[])((boolean[])this.aze), (boolean[])((boolean[])var5.aze));
               }

               return Arrays.deepEquals((Object[])((Object[])this.aze), (Object[])((Object[])var5.aze));
            }
         }
      }

      return var2;
   }

   public int hashCode() {
      int var1;
      try {
         var1 = Arrays.hashCode(this.toByteArray());
      } catch (IOException var3) {
         throw new IllegalStateException(var3);
      }

      return var1 + 527;
   }
}
