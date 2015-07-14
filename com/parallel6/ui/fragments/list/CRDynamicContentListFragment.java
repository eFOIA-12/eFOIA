package com.parallel6.ui.fragments.list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.google.gson.reflect.TypeToken;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.captivereachconnectsdk.builders.DynamicContentTaskBuilder;
import com.parallel6.captivereachconnectsdk.enums.CRCachePolicy;
import com.parallel6.captivereachconnectsdk.models.Tag;
import com.parallel6.captivereachconnectsdk.models.filters.CRFilter;
import com.parallel6.captivereachconnectsdk.models.json.response.DynamicContentResponse;
import com.parallel6.captivereachconnectsdk.network.GetDynamicContent;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.ui.actions.CRActionFactory;
import com.parallel6.ui.adapters.list.CRListAdapter;
import com.parallel6.ui.enums.Action;
import com.parallel6.ui.fragments.base.BaseListFragment;
import com.parallel6.ui.interfaces.CRMessage;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CRDynamicContentListFragment extends BaseListFragment {
   private TaskListener dynamicTaskListener = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
      }

      public void onTaskSuccess(DynamicContentResponse var1) {
         CRDynamicContentListFragment.this.toggleProgressBar(BaseListFragment.Toggle.OFF);
         if(var1.getContent().size() > 0) {
            CRDynamicContentListFragment.this.mModelList = var1.getContent();
            CRDynamicContentListFragment.this.getListView().setAdapter(new CRListAdapter(CRDynamicContentListFragment.this.getActivity(), var1.getContent()));
         } else if(CRDynamicContentListFragment.this.mEmptyListText != null) {
            CRDynamicContentListFragment.this.mEmptyListText.setVisibility(0);
            return;
         }

      }

      public void onTaskTimeOut() {
      }
   };
   protected TextView mEmptyListText;
   protected String mFragmentTitle;
   protected List mModelList = new ArrayList();
   protected String mPermanentLink;
   protected CRFilter mTagsFilter = new CRFilter();
   protected List mTagsList = new ArrayList();

   public boolean handleMessage(int var1) {
      return false;
   }

   public boolean handleMessage(CRMessage var1) {
      return false;
   }

   public boolean onBack() {
      return false;
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.mPermanentLink = this.getArguments().getString("permanent_link", "");
      this.mFragmentTitle = this.getArguments().getString("extras_title", "");
      if(this.getArguments().getParcelableArrayList("tagged_extras") != null) {
         this.mTagsList = this.getArguments().getParcelableArrayList("tagged_extras");
         this.mTagsFilter.setAttributeName("tag");
         this.mTagsFilter.setFilterValues(new ArrayList());
         Iterator var3 = this.mTagsList.iterator();

         while(var3.hasNext()) {
            Tag var2 = (Tag)var3.next();
            this.mTagsFilter.getFilterValues().add(String.valueOf(var2.getId()));
         }
      }

   }

   public View onCreateView(@NonNull LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(R.layout.fragment_list, (ViewGroup)null);
   }

   public void onListItemClick(ListView var1, View var2, int var3, long var4) {
      CRActionFactory.getInstance().executeAction(Action.DYNAMIC_CONTENT_DETAIL, this.mModelList.get(var3), this.controller);
   }

   public void onViewCreated(View var1, Bundle var2) {
      this.mEmptyListText = (TextView)var1.findViewById(R.id.fragment_list_tv_empty);
      this.toggleProgressBar(BaseListFragment.Toggle.ON);
      Type var5 = (new TypeToken() {
      }).getType();
      GetDynamicContent var6;
      if(this.mTagsList.size() > 0) {
         DynamicContentTaskBuilder var3 = (new DynamicContentTaskBuilder()).withContext(this.getActivity()).withMethod("POST").withParam("page", "0").withCachePolicy(CRCachePolicy.CACHE_FIRST);
         CRFilter var4;
         if(this.mTagsFilter.getFilterValues().size() == 0) {
            var4 = null;
         } else {
            var4 = this.mTagsFilter;
         }

         var6 = var3.withFilter(var4).withPermanentLink(this.mPermanentLink).withTaskListener(this.dynamicTaskListener).withType(var5).build();
      } else {
         var6 = (new DynamicContentTaskBuilder()).withContext(this.getActivity()).withMethod("GET").withParam("page", "0").withCachePolicy(CRCachePolicy.CACHE_FIRST).withPermanentLink(this.mPermanentLink).withTaskListener(this.dynamicTaskListener).withType(var5).build();
      }

      var6.execute();
   }
}
