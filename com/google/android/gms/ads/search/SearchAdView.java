package com.google.android.gms.ads.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.bh;

public final class SearchAdView extends ViewGroup {
   private final bh ll;

   public SearchAdView(Context var1) {
      super(var1);
      this.ll = new bh(this);
   }

   public SearchAdView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.ll = new bh(this, var2, false);
   }

   public SearchAdView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.ll = new bh(this, var2, false);
   }

   public void destroy() {
      this.ll.destroy();
   }

   public AdListener getAdListener() {
      return this.ll.getAdListener();
   }

   public AdSize getAdSize() {
      return this.ll.getAdSize();
   }

   public String getAdUnitId() {
      return this.ll.getAdUnitId();
   }

   public void loadAd(SearchAdRequest var1) {
      this.ll.a(var1.Y());
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      View var8 = this.getChildAt(0);
      if(var8 != null && var8.getVisibility() != 8) {
         int var6 = var8.getMeasuredWidth();
         int var7 = var8.getMeasuredHeight();
         var2 = (var4 - var2 - var6) / 2;
         var3 = (var5 - var3 - var7) / 2;
         var8.layout(var2, var3, var6 + var2, var7 + var3);
      }

   }

   protected void onMeasure(int var1, int var2) {
      int var3 = 0;
      View var6 = this.getChildAt(0);
      AdSize var5 = this.getAdSize();
      int var4;
      if(var6 != null && var6.getVisibility() != 8) {
         this.measureChild(var6, var1, var2);
         var4 = var6.getMeasuredWidth();
         var3 = var6.getMeasuredHeight();
      } else if(var5 != null) {
         Context var7 = this.getContext();
         var4 = var5.getWidthInPixels(var7);
         var3 = var5.getHeightInPixels(var7);
      } else {
         var4 = 0;
      }

      var4 = Math.max(var4, this.getSuggestedMinimumWidth());
      var3 = Math.max(var3, this.getSuggestedMinimumHeight());
      this.setMeasuredDimension(View.resolveSize(var4, var1), View.resolveSize(var3, var2));
   }

   public void pause() {
      this.ll.pause();
   }

   public void resume() {
      this.ll.resume();
   }

   public void setAdListener(AdListener var1) {
      this.ll.setAdListener(var1);
   }

   public void setAdSize(AdSize var1) {
      this.ll.setAdSizes(new AdSize[]{var1});
   }

   public void setAdUnitId(String var1) {
      this.ll.setAdUnitId(var1);
   }
}
