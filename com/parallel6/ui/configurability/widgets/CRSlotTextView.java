package com.parallel6.ui.configurability.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.ui.configurability.enums.SlotAlignment;
import com.parallel6.ui.configurability.interfaces.CRSlotView;
import com.parallel6.ui.configurability.models.CRConfLayoutStyle;

public class CRSlotTextView extends TextView implements CRSlotView {
   public CRSlotTextView(Context var1) {
      super(var1);
      this.initView((AttributeSet)null);
   }

   public CRSlotTextView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.initView(var2);
   }

   public CRSlotTextView(Context var1, AttributeSet var2, int var3) {
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

   public void initSlotView(Object var1, CRConfLayoutStyle var2) {
      byte var3 = 1;
      this.setGravity(SlotAlignment.getSafeSlotAlignment(var2.getHorizontalAlignment().toUpperCase(), var2.getVerticalAlignment().toUpperCase()));
      this.setMaxLines(var2.getMaxLines());
      this.setTextColor(Color.parseColor(String.format("#%s", new Object[]{var2.getFontColor()})));
      this.setTextSize((float)var2.getFontSize());
      if(!var2.isBold()) {
         var3 = 0;
      }

      byte var4;
      if(var2.isItalic()) {
         var4 = 2;
      } else {
         var4 = 0;
      }

      this.setTypeface((Typeface)null, 0 | var3 | var4);
      if(var2.isUnderlined()) {
         SpannableString var5 = new SpannableString((String)var1);
         var5.setSpan(new UnderlineSpan(), 0, ((String)var1).length(), 0);
         this.setText(var5);
      } else {
         this.setText((String)var1);
      }
   }
}
