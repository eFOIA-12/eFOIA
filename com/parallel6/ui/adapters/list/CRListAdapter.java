package com.parallel6.ui.adapters.list;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.androidquery.AQuery;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.captivereachconnectsdk.models.CRImage;
import com.parallel6.captivereachconnectsdk.models.CRModel;
import com.parallel6.ui.adapters.base.CRBaseAdapter;
import com.parallel6.ui.widgets.RoundedImageView;
import java.util.List;

public class CRListAdapter extends CRBaseAdapter {
   public CRListAdapter(Context var1, List var2) {
      super.mContext = var1;
      super.mObjectList = var2;
   }

   private CRListAdapter.ViewHolder initViewHolder(View var1) {
      CRListAdapter.ViewHolder var2 = new CRListAdapter.ViewHolder();
      var2.image = (RoundedImageView)var1.findViewById(R.id.row_list_iv_image);
      var2.title = (TextView)var1.findViewById(R.id.row_list_tv_title);
      return var2;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      CRListAdapter.ViewHolder var5;
      if(var2 == null) {
         var2 = View.inflate(this.mContext, R.layout.row_list, (ViewGroup)null);
         var5 = this.initViewHolder(var2);
         var2.setTag(var5);
      } else {
         var5 = (CRListAdapter.ViewHolder)var2.getTag();
      }

      CRModel var4 = (CRModel)this.getItem(var1);
      if(var4.getImage() != null) {
         ((AQuery)(new AQuery(this.mContext)).id(var5.image)).image(var4.getImage().getImageForDensity(CRImage.IMAGE_TYPE.SMALL, (Activity)this.mContext));
      }

      var5.title.setText(var4.getTitle());
      return var2;
   }

   public static class ViewHolder {
      private RoundedImageView image;
      private TextView title;
   }
}
