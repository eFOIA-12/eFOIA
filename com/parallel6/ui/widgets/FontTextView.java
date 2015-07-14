package com.parallel6.ui.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;
import com.parallel6.captivereachconnectsdk.R;

public class FontTextView extends TextView {
   public FontTextView(Context var1) {
      super(var1);
      this.initView((AttributeSet)null);
   }

   public FontTextView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.initView(var2);
   }

   public FontTextView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.initView(var2);
   }

   private void initView(AttributeSet var1) {
      TypedArray var3 = this.getContext().obtainStyledAttributes(var1, R.styleable.FontWidget);
      String var2 = var3.getString(R.styleable.FontWidget_fontName);
      if(var2 != null) {
         this.setTypeface(Typeface.createFromAsset(this.getContext().getAssets(), "fonts/" + var2));
      }

      var3.recycle();
   }
}
