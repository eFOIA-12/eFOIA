package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

public abstract class g extends DataBuffer {
   private boolean Lr = false;
   private ArrayList Ls;

   protected g(DataHolder var1) {
      super(var1);
   }

   private void hb() {
      // $FF: Couldn't be decompiled
   }

   int ax(int var1) {
      if(var1 >= 0 && var1 < this.Ls.size()) {
         return ((Integer)this.Ls.get(var1)).intValue();
      } else {
         throw new IllegalArgumentException("Position " + var1 + " is out of bounds for this buffer");
      }
   }

   protected int ay(int var1) {
      int var3;
      if(var1 >= 0 && var1 != this.Ls.size()) {
         int var2;
         if(var1 == this.Ls.size() - 1) {
            var2 = this.JG.getCount() - ((Integer)this.Ls.get(var1)).intValue();
         } else {
            var2 = ((Integer)this.Ls.get(var1 + 1)).intValue() - ((Integer)this.Ls.get(var1)).intValue();
         }

         var3 = var2;
         if(var2 == 1) {
            var1 = this.ax(var1);
            int var4 = this.JG.au(var1);
            String var5 = this.hc();
            var3 = var2;
            if(var5 != null) {
               var3 = var2;
               if(this.JG.c(var5, var1, var4) == null) {
                  return 0;
               }
            }
         }
      } else {
         var3 = 0;
      }

      return var3;
   }

   protected abstract Object f(int var1, int var2);

   public final Object get(int var1) {
      this.hb();
      return this.f(this.ax(var1), this.ay(var1));
   }

   public int getCount() {
      this.hb();
      return this.Ls.size();
   }

   protected abstract String ha();

   protected String hc() {
      return null;
   }
}
