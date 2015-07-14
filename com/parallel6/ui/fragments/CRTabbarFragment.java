package com.parallel6.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.ui.fragments.base.BaseFragment;
import com.parallel6.ui.interfaces.CRMessage;
import com.parallel6.ui.models.TabbarButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CRTabbarFragment extends BaseFragment {
   private List tabbarButtonList = new ArrayList();

   private void setupTabBarButtons(LinearLayout var1) {
      Iterator var2 = this.tabbarButtonList.iterator();

      while(var2.hasNext()) {
         TabbarButton var3 = (TabbarButton)var2.next();
         LayoutParams var4 = new LayoutParams(-2, -2, 1.0F);
         ImageView var5 = new ImageView(this.getActivity());
         var5.setScaleType(ScaleType.FIT_CENTER);
         var5.setLayoutParams(var4);
         var5.setOnClickListener(var3.getButtonListener());
         var5.setImageResource(var3.getButtonResource());
         var1.addView(var5);
      }

   }

   protected boolean actionBarRequired() {
      return false;
   }

   protected List getTabbarButtons() {
      return new ArrayList();
   }

   protected int getTabbarLayoutResource() {
      return R.layout.fragment_tabbar;
   }

   public boolean handleMessage(int var1) {
      return false;
   }

   public boolean handleMessage(CRMessage var1) {
      return false;
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.tabbarButtonList = this.getTabbarButtons();
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(this.getTabbarLayoutResource(), (ViewGroup)null);
   }

   public void onViewCreated(View var1, Bundle var2) {
      if(this.tabbarButtonList.size() > 0) {
         this.setupTabBarButtons((LinearLayout)var1.findViewById(R.id.fragment_tabbar_lyt_buttons));
      }

   }
}
