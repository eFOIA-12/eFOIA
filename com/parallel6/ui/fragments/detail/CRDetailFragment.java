package com.parallel6.ui.fragments.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.androidquery.AQuery;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.captivereachconnectsdk.models.CRModel;
import com.parallel6.ui.fragments.base.BaseFragment;
import com.parallel6.ui.interfaces.CRMessage;

public class CRDetailFragment extends BaseFragment {
   private static final int ROW_MARGIN = 5;
   private CRModel place;

   public boolean handleMessage(int var1) {
      return false;
   }

   public boolean handleMessage(CRMessage var1) {
      return false;
   }

   public void initViews(View var1) {
      ImageView var3 = (ImageView)var1.findViewById(R.id.fragment_dynamic_detail_iv_image);
      if(this.place.getBrand() != null) {
         ((TextView)var1.findViewById(R.id.fragment_dynamic_detail_tv_title)).setText(this.place.getBrand().getName() + "-" + this.place.getTitle());
      } else {
         ((TextView)var1.findViewById(R.id.fragment_dynamic_detail_tv_title)).setText(this.place.getTitle());
      }

      ((TextView)var1.findViewById(R.id.fragment_dynamic_detail_tv_description)).setText(this.place.getDescription());
      String var2 = "";
      AQuery var4 = new AQuery(this.getActivity());
      String var5 = var2;
      if(this.place.getImage() != null) {
         var5 = var2;
         if(this.place.getImage().getUrl() != null) {
            var5 = this.place.getImage().getUrl();
         }
      }

      ((AQuery)var4.id(var3)).image(var5, true, true);
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if(this.getArguments() != null) {
         if(this.getArguments().getParcelable("dynamic_detail") != null) {
            this.place = (CRModel)this.getArguments().getParcelable("dynamic_detail");
         }
      } else if(var1 != null) {
         var1.getParcelable("content");
         return;
      }

   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4 = var1.inflate(R.layout.fragment_dynamic_detail, (ViewGroup)null);
      if(this.place != null && var4 != null) {
         this.initViews(var4);
      }

      return var4;
   }

   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putParcelable("content", this.place);
   }

   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
   }
}
