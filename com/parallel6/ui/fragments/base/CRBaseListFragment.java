package com.parallel6.ui.fragments.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.captivereachconnectsdk.builders.DynamicContentTaskBuilder;
import com.parallel6.captivereachconnectsdk.models.json.response.DynamicContentResponse;
import com.parallel6.captivereachconnectsdk.network.GetDynamicContent;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.ui.adapters.base.CRBaseAdapter;
import com.parallel6.ui.fragments.base.BaseListFragment;
import com.parallel6.ui.interfaces.CRMessage;
import java.lang.reflect.Type;
import java.util.List;

public abstract class CRBaseListFragment extends BaseListFragment {
   protected TextView mDynamicListEmptyPrompt;
   protected ProgressBar mDynamicListPb;
   protected ListView mDynamicListView;
   protected String mFragmentTitle;
   protected CRBaseAdapter mListAdapter;
   protected TaskListener mListTaskListener = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
         if(CRBaseListFragment.this.mDynamicListPb != null) {
            CRBaseListFragment.this.mDynamicListPb.setVisibility(8);
         }

         if(CRBaseListFragment.this.mDynamicListEmptyPrompt != null) {
            CRBaseListFragment.this.mDynamicListEmptyPrompt.setVisibility(0);
         }

      }

      public void onTaskSuccess(DynamicContentResponse var1) {
         if(CRBaseListFragment.this.mDynamicListPb != null) {
            CRBaseListFragment.this.mDynamicListPb.setVisibility(8);
         }

         if(var1 != null && var1.getContent().size() > 0) {
            CRBaseListFragment.this.mObjectsList = var1.getContent();
            CRBaseListFragment.this.initListView();
         } else if(CRBaseListFragment.this.mDynamicListEmptyPrompt != null) {
            CRBaseListFragment.this.mDynamicListEmptyPrompt.setVisibility(0);
            return;
         }

      }

      public void onTaskTimeOut() {
      }
   };
   protected List mObjectsList;
   protected String mPermanentLink;
   protected List mTagsList;

   protected abstract CRBaseAdapter getCRListAdapter();

   protected GetDynamicContent getDynamicListTask() {
      return (new DynamicContentTaskBuilder()).withContext(this.getActivity()).withPermanentLink(this.mPermanentLink).withMethod("GET").withTaskListener(this.mListTaskListener).withType(this.getDynamicListType()).build();
   }

   protected abstract Type getDynamicListType();

   public boolean handleMessage(int var1) {
      return false;
   }

   public boolean handleMessage(CRMessage var1) {
      return false;
   }

   protected void initListView() {
      if(this.mListAdapter == null) {
         this.mDynamicListView.setAdapter(this.getCRListAdapter());
      } else {
         this.mListAdapter.setDynamicObjectList(this.mObjectsList);
         this.mListAdapter.notifyDataSetChanged();
      }
   }

   public boolean onBack() {
      return false;
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if(this.getArguments() != null) {
         if(this.getArguments().getString("permanent_link", (String)null) != null) {
            this.mPermanentLink = this.getArguments().getString("permanent_link");
         }

         if(this.getArguments().getString("extras_title", (String)null) != null) {
            this.mFragmentTitle = this.getArguments().getString("extras_title");
         }

         if(this.getArguments().getParcelableArrayList("tagged_extras") != null) {
            this.mTagsList = this.getArguments().getParcelableArrayList("tagged_extras");
         }

         if(this.getArguments().getParcelableArrayList("dynamic_list_objects") != null) {
            this.mObjectsList = this.getArguments().getParcelableArrayList("dynamic_list_objects");
         }
      }

      if(this.mPermanentLink != null) {
         this.getDynamicListTask().execute();
      }

   }

   public View onCreateView(@NonNull LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(R.layout.fragment_list, (ViewGroup)null);
   }

   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.mDynamicListView = this.getListView();
      this.mDynamicListEmptyPrompt = (TextView)var1.findViewById(R.id.fragment_list_tv_empty);
      this.mDynamicListPb = (ProgressBar)var1.findViewById(R.id.fragment_list_pb);
   }
}
