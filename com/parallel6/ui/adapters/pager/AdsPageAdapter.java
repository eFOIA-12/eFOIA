package com.parallel6.ui.adapters.pager;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.androidquery.AQuery;
import com.parallel6.captivereachconnectsdk.models.Advertisement;
import com.parallel6.captivereachconnectsdk.models.CRImage;
import java.util.List;

public class AdsPageAdapter extends PagerAdapter {
   private List ads;
   private Context context;
   private OnClickListener onActionClickListener;

   public AdsPageAdapter(Context var1, List var2, OnClickListener var3) {
      this.ads = var2;
      this.context = var1;
      this.onActionClickListener = var3;
   }

   public void destroyItem(ViewGroup var1, int var2, Object var3) {
      var1.removeView((View)var3);
   }

   public int getCount() {
      return this.ads == null?0:this.ads.size();
   }

   public Object instantiateItem(ViewGroup var1, int var2) {
      Advertisement var5 = (Advertisement)this.ads.get(var2);
      ImageView var6 = new ImageView(this.context);
      var6.setScaleType(ScaleType.FIT_XY);
      AQuery var7 = new AQuery(this.context);
      String var4 = var5.getImage().getCRImage().getImageForDensity(CRImage.IMAGE_TYPE.FULLSCREEN, (Activity)this.context);
      String var3 = var4;
      if(var4 == null) {
         var3 = "";
      }

      ((AQuery)var7.id(var6)).image(var3, true, true);
      var6.setTag(var5);
      var6.setOnClickListener(this.onActionClickListener);
      var1.addView(var6);
      return var6;
   }

   public boolean isViewFromObject(View var1, Object var2) {
      return var1.equals(var2);
   }
}
