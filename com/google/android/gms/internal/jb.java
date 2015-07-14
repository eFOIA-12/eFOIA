package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.widget.ImageView;

public final class jb extends ImageView {
   private Uri Mn;
   private int Mo;
   private int Mp;
   private jb.a Mq;
   private int Mr;
   private float Ms;

   public void aB(int var1) {
      this.Mo = var1;
   }

   public void g(Uri var1) {
      this.Mn = var1;
   }

   public int hj() {
      return this.Mo;
   }

   protected void onDraw(Canvas var1) {
      if(this.Mq != null) {
         var1.clipPath(this.Mq.g(this.getWidth(), this.getHeight()));
      }

      super.onDraw(var1);
      if(this.Mp != 0) {
         var1.drawColor(this.Mp);
      }

   }

   protected void onMeasure(int var1, int var2) {
      super.onMeasure(var1, var2);
      switch(this.Mr) {
      case 1:
         var1 = this.getMeasuredHeight();
         var2 = (int)((float)var1 * this.Ms);
         break;
      case 2:
         var2 = this.getMeasuredWidth();
         var1 = (int)((float)var2 / this.Ms);
         break;
      default:
         return;
      }

      this.setMeasuredDimension(var2, var1);
   }

   public interface a {
      Path g(int var1, int var2);
   }
}
