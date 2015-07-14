package com.androidquery.util;

import android.graphics.Bitmap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class BitmapCache extends LinkedHashMap {
   private static final long serialVersionUID = 1L;
   private int maxCount;
   private int maxPixels;
   private int maxTotalPixels;
   private int pixels;

   public BitmapCache(int var1, int var2, int var3) {
      super(8, 0.75F, true);
      this.maxCount = var1;
      this.maxPixels = var2;
      this.maxTotalPixels = var3;
   }

   private int pixels(Bitmap var1) {
      return var1 == null?0:var1.getWidth() * var1.getHeight();
   }

   private void shrink() {
      if(this.pixels > this.maxTotalPixels) {
         Iterator var1 = this.keySet().iterator();

         while(var1.hasNext()) {
            var1.next();
            var1.remove();
            if(this.pixels <= this.maxTotalPixels) {
               break;
            }
         }
      }

   }

   public void clear() {
      super.clear();
      this.pixels = 0;
   }

   public Bitmap put(String var1, Bitmap var2) {
      Bitmap var4 = null;
      int var3 = this.pixels(var2);
      if(var3 <= this.maxPixels) {
         this.pixels += var3;
         Bitmap var5 = (Bitmap)super.put(var1, var2);
         var4 = var5;
         if(var5 != null) {
            this.pixels -= this.pixels(var5);
            var4 = var5;
         }
      }

      return var4;
   }

   public Bitmap remove(Object var1) {
      Bitmap var2 = (Bitmap)super.remove(var1);
      if(var2 != null) {
         this.pixels -= this.pixels(var2);
      }

      return var2;
   }

   public boolean removeEldestEntry(Entry var1) {
      if(this.pixels > this.maxTotalPixels || this.size() > this.maxCount) {
         this.remove(var1.getKey());
      }

      this.shrink();
      return false;
   }
}
