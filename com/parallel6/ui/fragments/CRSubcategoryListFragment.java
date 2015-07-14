package com.parallel6.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.AdapterView.OnItemClickListener;
import com.google.gson.reflect.TypeToken;
import com.parallel6.captivereachconnectsdk.CaptiveReachConnect;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.captivereachconnectsdk.builders.DynamicContentTaskBuilder;
import com.parallel6.captivereachconnectsdk.enums.CRCachePolicy;
import com.parallel6.captivereachconnectsdk.models.MobileMenu;
import com.parallel6.captivereachconnectsdk.models.json.response.MobileMenuResponse;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.captivereachconnectsdk.utils.StringUtils;
import com.parallel6.ui.activities.CRMainActivity;
import com.parallel6.ui.adapters.list.CRSubcategoriesAdapter;
import com.parallel6.ui.enums.Action;
import com.parallel6.ui.fragments.base.BaseFragment;
import com.parallel6.ui.interfaces.CRMessage;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CRSubcategoryListFragment extends BaseFragment implements OnItemClickListener {
   protected ProgressBar loadingBar;
   protected String mFragmentTitle;
   protected List mSubcategoriesList = new ArrayList();
   protected String parentId;
   protected AbsListView subcategoriesListView;
   private TaskListener subcategoriesListener = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
      }

      public void onTaskSuccess(MobileMenuResponse var1) {
         if(var1.getMobileMenus().size() > 0) {
            CRSubcategoryListFragment.this.mSubcategoriesList = var1.getMobileMenus();
            CRSubcategoryListFragment.this.initListView();
         }

         if(CRSubcategoryListFragment.this.loadingBar != null) {
            CRSubcategoryListFragment.this.loadingBar.setVisibility(8);
         }

      }

      public void onTaskTimeOut() {
      }
   };

   private void updateList(String var1) {
      Type var2 = (new TypeToken() {
      }).getType();
      (new DynamicContentTaskBuilder()).withContext(this.getActivity()).withPath("v2/mobile_menus/" + this.parentId + "/subcategories").withParam("page", "0").withCachePolicy(CRCachePolicy.NETWORK_FIRST).withMethod("GET").withTaskListener(this.subcategoriesListener).withType(var2).build().execute();
   }

   protected String getFragmentTitle() {
      return this.mFragmentTitle;
   }

   protected AbsListView getListView() {
      if(this.subcategoriesListView == null && this.getView() != null) {
         this.subcategoriesListView = (ListView)this.getView().findViewById(16908298);
      }

      return this.subcategoriesListView;
   }

   protected BaseAdapter getSubcategoriesAdapter() {
      return new CRSubcategoriesAdapter(this.getActivity(), this.mSubcategoriesList);
   }

   public boolean handleMessage(int var1) {
      return false;
   }

   public boolean handleMessage(CRMessage var1) {
      return false;
   }

   protected void initListView() {
      if(this.getListView() != null) {
         this.getListView().setAdapter(this.getSubcategoriesAdapter());
         this.getListView().setOnItemClickListener(this);
      }

   }

   public boolean onBack() {
      return false;
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if(this.getArguments() != null) {
         if(this.getArguments().getString("category_parent_id") != null) {
            this.parentId = this.getArguments().getString("category_parent_id");
         }

         if(this.getArguments().getString("extras_title") != null) {
            this.mFragmentTitle = this.getArguments().getString("extras_title");
         }
      }

   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(R.layout.fragment_list, var2, false);
   }

   public void onItemClick(AdapterView var1, View var2, int var3, long var4) {
      if(this.mSubcategoriesList.size() > 0) {
         MobileMenu var6 = (MobileMenu)this.mSubcategoriesList.get(var3);
         CaptiveReachConnect.getInstance().trackInsightV2(this.getActivity(), this.mFragmentTitle.toLowerCase().replace(" ", "_"), "open", String.valueOf(var6.getId()), var6.getTitle());
         ((CRMainActivity)this.getActivity()).getActionFactory().executeAction(Action.valueOf(var6.getAction().toUpperCase()), var6, this.controller);
      }

   }

   public void onViewCreated(View var1, Bundle var2) {
      this.loadingBar = (ProgressBar)var1.findViewById(R.id.fragment_list_pb);
      if(this.loadingBar != null) {
         this.loadingBar.setVisibility(0);
      }

      if(StringUtils.isNotEmpty(this.parentId)) {
         this.updateList(this.parentId);
      }

   }
}
