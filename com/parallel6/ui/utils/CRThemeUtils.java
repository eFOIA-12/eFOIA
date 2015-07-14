package com.parallel6.ui.utils;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.parallel6.ui.models.CRTheme;

public class CRThemeUtils {
   public static void setThemeAttributes(Context var0, View var1, CRTheme var2) {
      setThemeAttributes(var0, var1, var2, false);
   }

   public static void setThemeAttributes(Context var0, View var1, CRTheme var2, boolean var3) {
      if(var2 != null) {
         if(var1 instanceof Button) {
            ((Button)var1).setTextColor(var0.getResources().getColor(var2.getAppSecondaryColorResource()));
            var1.setBackgroundResource(var2.getAppPrimaryColorResource());
         } else if(var1 instanceof TextView) {
            TextView var6 = (TextView)var1;
            Resources var5 = var0.getResources();
            int var4;
            if(var3) {
               var4 = var2.getAppPrimaryColorResource();
            } else {
               var4 = var2.getAppSecondaryColorResource();
            }

            var6.setTextColor(var5.getColor(var4));
            return;
         }
      }

   }
}
