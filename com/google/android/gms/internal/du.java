package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gq;

@ey
public final class du extends FrameLayout implements OnClickListener {
   private final Activity nB;
   private final ImageButton sx;

   public du(Activity var1, int var2) {
      super(var1);
      this.nB = var1;
      this.setOnClickListener(this);
      this.sx = new ImageButton(var1);
      this.sx.setImageResource(17301527);
      this.sx.setBackgroundColor(0);
      this.sx.setOnClickListener(this);
      this.sx.setPadding(0, 0, 0, 0);
      this.sx.setContentDescription("Interstitial close button");
      var2 = gq.a((Context)var1, var2);
      this.addView(this.sx, new LayoutParams(var2, var2, 17));
   }

   public void onClick(View var1) {
      this.nB.finish();
   }

   public void q(boolean var1) {
      ImageButton var3 = this.sx;
      byte var2;
      if(var1) {
         var2 = 4;
      } else {
         var2 = 0;
      }

      var3.setVisibility(var2);
   }
}
