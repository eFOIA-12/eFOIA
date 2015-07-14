package com.parallel6.ui.adapters.list;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.captivereachconnectsdk.models.MobileMenu;
import com.parallel6.ui.adapters.base.CRBaseAdapter;
import com.parallel6.ui.widgets.RoundedImageView;
import java.util.List;

public class CRSubcategoriesAdapter extends CRBaseAdapter {
   public CRSubcategoriesAdapter(Context var1, List var2) {
      super(var1, var2);
   }

   private CRSubcategoriesAdapter.ViewHolder initViewHolder(View var1) {
      CRSubcategoriesAdapter.ViewHolder var2 = new CRSubcategoriesAdapter.ViewHolder();
      View var3 = var1.findViewById(R.id.row_list_iv_image);
      if(var3 instanceof RoundedImageView) {
         var2.roundedImageView = (RoundedImageView)var3;
      } else {
         var2.image = (ImageView)var3;
      }

      var2.title = (TextView)var1.findViewById(R.id.row_list_tv_title);
      return var2;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      CRSubcategoriesAdapter.ViewHolder var5;
      if(var2 == null) {
         var2 = View.inflate(this.mContext, R.layout.row_list, (ViewGroup)null);
         var5 = this.initViewHolder(var2);
         var2.setTag(var5);
      } else {
         var5 = (CRSubcategoriesAdapter.ViewHolder)var2.getTag();
      }

      MobileMenu var4 = (MobileMenu)this.getItem(var1);
      if(var5.image != null) {
         var5.image.setVisibility(8);
      }

      if(var5.roundedImageView != null) {
         var5.roundedImageView.setVisibility(8);
      }

      var5.title.setText(var4.getTitle());
      return var2;
   }

   public static class ViewHolder {
      private ImageView image;
      private RoundedImageView roundedImageView;
      private TextView title;
   }
}
