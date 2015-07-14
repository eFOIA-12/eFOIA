package com.google.android.gms.plus;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class PlusOneDummyView extends FrameLayout {
   public static final String TAG = "PlusOneDummyView";

   public PlusOneDummyView(Context var1, int var2) {
      super(var1);
      Button var4 = new Button(var1);
      var4.setEnabled(false);
      var4.setBackgroundDrawable(this.ot().getDrawable(var2));
      Point var3 = this.fs(var2);
      this.addView(var4, new LayoutParams(var3.x, var3.y, 17));
   }

   private Point fs(int var1) {
      byte var5 = 24;
      byte var4 = 20;
      Point var6 = new Point();
      byte var8;
      switch(var1) {
      case 0:
         var4 = 14;
         var8 = var5;
         break;
      case 1:
         var8 = 32;
         break;
      case 2:
         var8 = 50;
         break;
      default:
         var8 = 38;
         var4 = 24;
      }

      DisplayMetrics var7 = this.getResources().getDisplayMetrics();
      float var2 = TypedValue.applyDimension(1, (float)var8, var7);
      float var3 = TypedValue.applyDimension(1, (float)var4, var7);
      var6.x = (int)((double)var2 + 0.5D);
      var6.y = (int)((double)var3 + 0.5D);
      return var6;
   }

   private PlusOneDummyView.d ot() {
      PlusOneDummyView.b var2 = new PlusOneDummyView.b(this.getContext(), null);
      Object var1 = var2;
      if(!var2.isValid()) {
         var1 = new PlusOneDummyView.c(this.getContext(), null);
      }

      Object var3 = var1;
      if(!((PlusOneDummyView.d)var1).isValid()) {
         var3 = new PlusOneDummyView.a(this.getContext(), null);
      }

      return (PlusOneDummyView.d)var3;
   }

   private static class a implements PlusOneDummyView.d {
      private Context mContext;

      private a(Context var1) {
         this.mContext = var1;
      }

      // $FF: synthetic method
      a(Context var1, Object var2) {
         this(var1);
      }

      public Drawable getDrawable(int var1) {
         return this.mContext.getResources().getDrawable(17301508);
      }

      public boolean isValid() {
         return true;
      }
   }

   private static class b implements PlusOneDummyView.d {
      private Context mContext;

      private b(Context var1) {
         this.mContext = var1;
      }

      // $FF: synthetic method
      b(Context var1, Object var2) {
         this(var1);
      }

      public Drawable getDrawable(int param1) {
         // $FF: Couldn't be decompiled
      }

      public boolean isValid() {
         try {
            this.mContext.createPackageContext("com.google.android.gms", 4).getResources();
            return true;
         } catch (NameNotFoundException var2) {
            return false;
         }
      }
   }

   private static class c implements PlusOneDummyView.d {
      private Context mContext;

      private c(Context var1) {
         this.mContext = var1;
      }

      // $FF: synthetic method
      c(Context var1, Object var2) {
         this(var1);
      }

      public Drawable getDrawable(int var1) {
         String var2;
         switch(var1) {
         case 0:
            var2 = "ic_plusone_small_off_client";
            break;
         case 1:
            var2 = "ic_plusone_medium_off_client";
            break;
         case 2:
            var2 = "ic_plusone_tall_off_client";
            break;
         default:
            var2 = "ic_plusone_standard_off_client";
         }

         var1 = this.mContext.getResources().getIdentifier(var2, "drawable", this.mContext.getPackageName());
         return this.mContext.getResources().getDrawable(var1);
      }

      public boolean isValid() {
         int var1 = this.mContext.getResources().getIdentifier("ic_plusone_small_off_client", "drawable", this.mContext.getPackageName());
         int var2 = this.mContext.getResources().getIdentifier("ic_plusone_medium_off_client", "drawable", this.mContext.getPackageName());
         int var3 = this.mContext.getResources().getIdentifier("ic_plusone_tall_off_client", "drawable", this.mContext.getPackageName());
         int var4 = this.mContext.getResources().getIdentifier("ic_plusone_standard_off_client", "drawable", this.mContext.getPackageName());
         return var1 != 0 && var2 != 0 && var3 != 0 && var4 != 0;
      }
   }

   private interface d {
      Drawable getDrawable(int var1);

      boolean isValid();
   }
}
