package com.google.android.gms.internal;

import com.google.android.gms.internal.qt;

class qs {
   private static final qt ayZ = new qt();
   private boolean aza;
   private int[] azb;
   private qt[] azc;
   private int mSize;

   public qs() {
      this(10);
   }

   public qs(int var1) {
      this.aza = false;
      var1 = this.idealIntArraySize(var1);
      this.azb = new int[var1];
      this.azc = new qt[var1];
      this.mSize = 0;
   }

   private boolean a(int[] var1, int[] var2, int var3) {
      for(int var4 = 0; var4 < var3; ++var4) {
         if(var1[var4] != var2[var4]) {
            return false;
         }
      }

      return true;
   }

   private boolean a(qt[] var1, qt[] var2, int var3) {
      for(int var4 = 0; var4 < var3; ++var4) {
         if(!var1[var4].equals(var2[var4])) {
            return false;
         }
      }

      return true;
   }

   private void gc() {
      int var4 = this.mSize;
      int[] var5 = this.azb;
      qt[] var6 = this.azc;
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var1 < var4; var2 = var3) {
         qt var7 = var6[var1];
         var3 = var2;
         if(var7 != ayZ) {
            if(var1 != var2) {
               var5[var2] = var5[var1];
               var6[var2] = var7;
               var6[var1] = null;
            }

            var3 = var2 + 1;
         }

         ++var1;
      }

      this.aza = false;
      this.mSize = var2;
   }

   private int hj(int var1) {
      int var2 = 0;
      int var3 = this.mSize - 1;

      while(var2 <= var3) {
         int var4 = var2 + var3 >>> 1;
         int var5 = this.azb[var4];
         if(var5 < var1) {
            var2 = var4 + 1;
         } else {
            if(var5 <= var1) {
               return var4;
            }

            var3 = var4 - 1;
         }
      }

      return ~var2;
   }

   private int idealByteArraySize(int var1) {
      int var2 = 4;

      int var3;
      while(true) {
         var3 = var1;
         if(var2 >= 32) {
            break;
         }

         if(var1 <= (1 << var2) - 12) {
            var3 = (1 << var2) - 12;
            break;
         }

         ++var2;
      }

      return var3;
   }

   private int idealIntArraySize(int var1) {
      return this.idealByteArraySize(var1 * 4) / 4;
   }

   public void a(int var1, qt var2) {
      int var3 = this.hj(var1);
      if(var3 >= 0) {
         this.azc[var3] = var2;
      } else {
         int var4 = ~var3;
         if(var4 < this.mSize && this.azc[var4] == ayZ) {
            this.azb[var4] = var1;
            this.azc[var4] = var2;
         } else {
            var3 = var4;
            if(this.aza) {
               var3 = var4;
               if(this.mSize >= this.azb.length) {
                  this.gc();
                  var3 = ~this.hj(var1);
               }
            }

            if(this.mSize >= this.azb.length) {
               var4 = this.idealIntArraySize(this.mSize + 1);
               int[] var5 = new int[var4];
               qt[] var6 = new qt[var4];
               System.arraycopy(this.azb, 0, var5, 0, this.azb.length);
               System.arraycopy(this.azc, 0, var6, 0, this.azc.length);
               this.azb = var5;
               this.azc = var6;
            }

            if(this.mSize - var3 != 0) {
               System.arraycopy(this.azb, var3, this.azb, var3 + 1, this.mSize - var3);
               System.arraycopy(this.azc, var3, this.azc, var3 + 1, this.mSize - var3);
            }

            this.azb[var3] = var1;
            this.azc[var3] = var2;
            ++this.mSize;
         }
      }
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof qs)) {
            return false;
         }

         qs var2 = (qs)var1;
         if(this.size() != var2.size()) {
            return false;
         }

         if(!this.a(this.azb, var2.azb, this.mSize) || !this.a(this.azc, var2.azc, this.mSize)) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      if(this.aza) {
         this.gc();
      }

      int var2 = 17;

      for(int var1 = 0; var1 < this.mSize; ++var1) {
         var2 = (var2 * 31 + this.azb[var1]) * 31 + this.azc[var1].hashCode();
      }

      return var2;
   }

   public qt hh(int var1) {
      var1 = this.hj(var1);
      return var1 >= 0 && this.azc[var1] != ayZ?this.azc[var1]:null;
   }

   public qt hi(int var1) {
      if(this.aza) {
         this.gc();
      }

      return this.azc[var1];
   }

   public boolean isEmpty() {
      return this.size() == 0;
   }

   public int size() {
      if(this.aza) {
         this.gc();
      }

      return this.mSize;
   }
}
