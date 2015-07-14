package com.parallel6.ui.fragments.list.pager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.google.gson.reflect.TypeToken;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.captivereachconnectsdk.builders.DynamicContentTaskBuilder;
import com.parallel6.captivereachconnectsdk.models.json.response.DynamicContentResponse;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.ui.activities.CRMainActivity;
import com.parallel6.ui.fragments.base.BaseFragment;
import com.parallel6.ui.fragments.list.pager.CRPagerFragmentListView;
import com.parallel6.ui.fragments.list.pager.CRPagerFragmentMapView;
import com.parallel6.ui.interfaces.CRMessage;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CRDynamicPagerFragment extends BaseFragment {
   private FrameLayout mContentContainer;
   private List mPlacesList = new ArrayList();
   private LinearLayout mTabsContainer;
   private TaskListener placeListener = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
      }

      public void onTaskSuccess(DynamicContentResponse var1) {
         if(var1.getContent().size() > 0) {
            CRDynamicPagerFragment.this.mPlacesList = var1.getContent();
         }

      }

      public void onTaskTimeOut() {
      }
   };
   private OnClickListener tabButtonListener = new OnClickListener() {
      public void onClick(View var1) {
         CRDynamicPagerFragment.PagerTab var2 = (CRDynamicPagerFragment.PagerTab)var1.getTag();
         CRDynamicPagerFragment.this.switchTab(var2);
      }
   };

   private Button getTabButton(String var1, CRDynamicPagerFragment.PagerTab var2) {
      ((CRMainActivity)this.getActivity()).getCRTheme();
      Button var3 = new Button(this.getActivity());
      var3.setLayoutParams(new LayoutParams(-1, -1, 1.0F));
      var3.setTag(var2);
      var3.setText(var1);
      var3.setOnClickListener(this.tabButtonListener);
      return var3;
   }

   private void setupButtons(LinearLayout var1) {
      var1.addView(this.getTabButton("List", CRDynamicPagerFragment.PagerTab.List));
      var1.addView(this.getTabButton("Map", CRDynamicPagerFragment.PagerTab.Map));
   }

   private void switchTab(CRDynamicPagerFragment.PagerTab var1) {
      this.mContentContainer.removeAllViews();
      switch(null.$SwitchMap$com$parallel6$ui$fragments$list$pager$CRDynamicPagerFragment$PagerTab[var1.ordinal()]) {
      case 1:
         CRPagerFragmentListView var3 = new CRPagerFragmentListView(this.getActivity());
         var3.initView(this.mPlacesList);
         this.mContentContainer.addView(var3);
         return;
      case 2:
         CRPagerFragmentMapView var2 = (CRPagerFragmentMapView)View.inflate(this.getActivity(), R.layout.pager_view_map, (ViewGroup)null);
         var2.initView(this.mPlacesList);
         this.mContentContainer.addView(var2);
         return;
      default:
      }
   }

   public boolean handleMessage(int var1) {
      return false;
   }

   public boolean handleMessage(CRMessage var1) {
      return false;
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      String var3 = this.getArguments().getString("permanent_link", "");
      Type var2 = (new TypeToken() {
      }).getType();
      (new DynamicContentTaskBuilder()).withContext(this.getActivity()).withMethod("GET").withPermanentLink(var3).withTaskListener(this.placeListener).withType(var2).build().execute();
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(R.layout.fragment_dynamic_pager, (ViewGroup)null);
   }

   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.mContentContainer = (FrameLayout)var1.findViewById(R.id.fragment_dynamic_pager_lyt_container);
      this.mTabsContainer = (LinearLayout)var1.findViewById(R.id.fragment_dynamic_pager_lyt_tabs);
      this.switchTab(CRDynamicPagerFragment.PagerTab.Map);
      this.setupButtons(this.mTabsContainer);
   }

   private static enum PagerTab {
      Layar,
      List,
      Map;
   }
}
