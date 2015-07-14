package com.parallel6.ui.configurability.fragments;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.parallel6.captivereachconnectsdk.builders.DynamicContentTaskBuilder;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.ui.configurability.adapters.CRListAdapter001;
import com.parallel6.ui.configurability.adapters.CRListAdapter002;
import com.parallel6.ui.configurability.adapters.CRListAdapter003;
import com.parallel6.ui.configurability.adapters.CRListAdapter004;
import com.parallel6.ui.configurability.enums.LayoutTemplates;
import com.parallel6.ui.configurability.models.CRConfLayoutModule;
import com.parallel6.ui.configurability.models.DynamicContentHashResponse;
import com.parallel6.ui.enums.Action;
import com.parallel6.ui.fragments.base.BaseListFragment;
import com.parallel6.ui.fragments.list.CRDynamicContentListFragment;
import com.parallel6.ui.interfaces.CRMessage;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CRConfListFragment extends CRDynamicContentListFragment {
   protected TaskListener dynamicTaskListener = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
      }

      public void onTaskSuccess(DynamicContentHashResponse var1) {
         CRConfListFragment.this.toggleProgressBar(BaseListFragment.Toggle.OFF);
         if(var1.getContent().size() > 0) {
            CRConfListFragment.this.setupValuesMap(var1.getContent());
            CRConfListFragment.this.getListView().setAdapter(CRConfListFragment.this.getDynamicAdapter());
         } else if(CRConfListFragment.this.mEmptyListText != null) {
            CRConfListFragment.this.mEmptyListText.setVisibility(0);
            return;
         }

      }

      public void onTaskTimeOut() {
      }
   };
   private CRConfLayoutModule layoutModel;
   private List valuesListMap = new ArrayList();
   private LinkedTreeMap valuesMap;

   private ListAdapter getDynamicAdapter() {
      switch(null.$SwitchMap$com$parallel6$ui$configurability$enums$LayoutTemplates[LayoutTemplates.getSafeTemplate(this.layoutModel.getLayout().getLayoutID().toUpperCase()).ordinal()]) {
      case 1:
         return new CRListAdapter001(this.getActivity(), this.valuesListMap, this.layoutModel);
      case 2:
         return new CRListAdapter002(this.getActivity(), this.valuesListMap, this.layoutModel);
      case 3:
         return new CRListAdapter003(this.getActivity(), this.valuesListMap, this.layoutModel);
      case 4:
         return new CRListAdapter004(this.getActivity(), this.valuesListMap, this.layoutModel);
      default:
         return null;
      }
   }

   private void setupValuesMap(List var1) {
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         LinkedTreeMap var2 = (LinkedTreeMap)var3.next();
         this.valuesListMap.add(var2);
      }

   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.mPermanentLink = this.getArguments().getString("permanent_link");
      this.layoutModel = (CRConfLayoutModule)this.getArguments().getParcelable("extras_layout_model");
   }

   public void onListItemClick(ListView var1, View var2, int var3, long var4) {
      LinkedTreeMap var6 = (LinkedTreeMap)this.valuesListMap.get(var3);
      this.controller.handleMessage(new CRMessage(-1412628462, new Object[]{Action.DYNAMIC_CONTENT_DETAIL, this.mPermanentLink, var6}));
   }

   public void onViewCreated(View var1, Bundle var2) {
      var1.setBackgroundColor(this.getResources().getColor(17170443));
      this.getListView().setDivider(new ColorDrawable(this.getResources().getColor(17170432)));
      this.getListView().setDividerHeight(1);
      Type var3 = (new TypeToken() {
      }).getType();
      (new DynamicContentTaskBuilder()).withContext(this.getActivity()).withMethod("GET").withParam("page", "0").withPermanentLink(this.mPermanentLink).withTaskListener(this.dynamicTaskListener).withType(var3).build().execute();
   }
}
