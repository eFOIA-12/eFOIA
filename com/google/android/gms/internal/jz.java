package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.R;
import com.google.android.gms.internal.jx;

public final class jz extends Button {
   public jz(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public jz(Context var1, AttributeSet var2) {
      super(var1, var2, 16842824);
   }

   private int b(int var1, int var2, int var3) {
      switch(var1) {
      case 1:
         var2 = var3;
      case 0:
         return var2;
      default:
         throw new IllegalStateException("Unknown color scheme: " + var1);
      }
   }

   private void b(Resources var1, int var2, int var3) {
      switch(var2) {
      case 0:
      case 1:
         var2 = this.b(var3, R.drawable.common_signin_btn_text_dark, R.drawable.common_signin_btn_text_light);
         break;
      case 2:
         var2 = this.b(var3, R.drawable.common_signin_btn_icon_dark, R.drawable.common_signin_btn_icon_light);
         break;
      default:
         throw new IllegalStateException("Unknown button size: " + var2);
      }

      if(var2 == -1) {
         throw new IllegalStateException("Could not find background resource!");
      } else {
         this.setBackgroundDrawable(var1.getDrawable(var2));
      }
   }

   private void c(Resources var1) {
      this.setTypeface(Typeface.DEFAULT_BOLD);
      this.setTextSize(14.0F);
      float var2 = var1.getDisplayMetrics().density;
      this.setMinHeight((int)(var2 * 48.0F + 0.5F));
      this.setMinWidth((int)(var2 * 48.0F + 0.5F));
   }

   private void c(Resources var1, int var2, int var3) {
      this.setTextColor(var1.getColorStateList(this.b(var3, R.color.common_signin_btn_text_dark, R.color.common_signin_btn_text_light)));
      switch(var2) {
      case 0:
         this.setText(var1.getString(R.string.common_signin_button_text));
         return;
      case 1:
         this.setText(var1.getString(R.string.common_signin_button_text_long));
         return;
      case 2:
         this.setText((CharSequence)null);
         return;
      default:
         throw new IllegalStateException("Unknown button size: " + var2);
      }
   }

   public void a(Resources var1, int var2, int var3) {
      boolean var4;
      if(var2 >= 0 && var2 < 3) {
         var4 = true;
      } else {
         var4 = false;
      }

      jx.a(var4, "Unknown button size %d", new Object[]{Integer.valueOf(var2)});
      if(var3 >= 0 && var3 < 2) {
         var4 = true;
      } else {
         var4 = false;
      }

      jx.a(var4, "Unknown color scheme %s", new Object[]{Integer.valueOf(var3)});
      this.c(var1);
      this.b(var1, var2, var3);
      this.c(var1, var2, var3);
   }
}
