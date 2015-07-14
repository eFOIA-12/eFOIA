package com.google.android.gms.common;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.jy;
import com.google.android.gms.internal.jz;

public final class SignInButton extends FrameLayout implements OnClickListener {
   public static final int COLOR_DARK = 0;
   public static final int COLOR_LIGHT = 1;
   public static final int SIZE_ICON_ONLY = 2;
   public static final int SIZE_STANDARD = 0;
   public static final int SIZE_WIDE = 1;
   private View Jk;
   private OnClickListener Jl;
   private int mColor;
   private int mSize;

   public SignInButton(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public SignInButton(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public SignInButton(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.Jl = null;
      this.setStyle(0, 0);
   }

   private void G(Context var1) {
      if(this.Jk != null) {
         this.removeView(this.Jk);
      }

      try {
         this.Jk = jy.b(var1, this.mSize, this.mColor);
      } catch (g.a var3) {
         Log.w("SignInButton", "Sign in button not found, using placeholder instead");
         this.Jk = a(var1, this.mSize, this.mColor);
      }

      this.addView(this.Jk);
      this.Jk.setEnabled(this.isEnabled());
      this.Jk.setOnClickListener(this);
   }

   private static Button a(Context var0, int var1, int var2) {
      jz var3 = new jz(var0);
      var3.a(var0.getResources(), var1, var2);
      return var3;
   }

   public void onClick(View var1) {
      if(this.Jl != null && var1 == this.Jk) {
         this.Jl.onClick(this);
      }

   }

   public void setColorScheme(int var1) {
      this.setStyle(this.mSize, var1);
   }

   public void setEnabled(boolean var1) {
      super.setEnabled(var1);
      this.Jk.setEnabled(var1);
   }

   public void setOnClickListener(OnClickListener var1) {
      this.Jl = var1;
      if(this.Jk != null) {
         this.Jk.setOnClickListener(this);
      }

   }

   public void setSize(int var1) {
      this.setStyle(var1, this.mColor);
   }

   public void setStyle(int var1, int var2) {
      boolean var3;
      if(var1 >= 0 && var1 < 3) {
         var3 = true;
      } else {
         var3 = false;
      }

      jx.a(var3, "Unknown button size %d", new Object[]{Integer.valueOf(var1)});
      if(var2 >= 0 && var2 < 2) {
         var3 = true;
      } else {
         var3 = false;
      }

      jx.a(var3, "Unknown color scheme %s", new Object[]{Integer.valueOf(var2)});
      this.mSize = var1;
      this.mColor = var2;
      this.G(this.getContext());
   }
}
