package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.support.v4.view.TintableBackgroundView;
import android.view.View;

class ViewCompatBase {
   static ColorStateList getBackgroundTintList(View var0) {
      return var0 instanceof TintableBackgroundView?((TintableBackgroundView)var0).getSupportBackgroundTintList():null;
   }

   static Mode getBackgroundTintMode(View var0) {
      return var0 instanceof TintableBackgroundView?((TintableBackgroundView)var0).getSupportBackgroundTintMode():null;
   }

   static boolean isLaidOut(View var0) {
      return var0.getWidth() > 0 && var0.getHeight() > 0;
   }

   static void setBackgroundTintList(View var0, ColorStateList var1) {
      if(var0 instanceof TintableBackgroundView) {
         ((TintableBackgroundView)var0).setSupportBackgroundTintList(var1);
      }

   }

   static void setBackgroundTintMode(View var0, Mode var1) {
      if(var0 instanceof TintableBackgroundView) {
         ((TintableBackgroundView)var0).setSupportBackgroundTintMode(var1);
      }

   }
}
