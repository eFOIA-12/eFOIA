package com.parallel6.ui.fragments.base;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.captivereachconnectsdk.utils.StringUtils;
import com.parallel6.ui.enums.ScreenOrientation;
import com.parallel6.ui.interfaces.CRMessage;
import com.parallel6.ui.interfaces.ControllerState;
import com.parallel6.ui.interfaces.FragmentState;

public abstract class BaseListFragment extends ListFragment implements FragmentState {
   protected ControllerState controller;

   private ProgressBar getProgressBar(View var1) {
      if(this.getView() != null) {
         try {
            ProgressBar var3 = (ProgressBar)var1.findViewById(R.id.fragment_list_pb);
            return var3;
         } catch (Exception var2) {
            return null;
         }
      } else {
         return null;
      }
   }

   protected boolean actionBarRequired() {
      return true;
   }

   protected View findView(View var1, int var2) {
      return var1.findViewById(var2);
   }

   protected View getFragmentActionBarView(Context var1) {
      View var2 = this.controller.getBaseBackActionbarView(var1);
      TextView var3 = (TextView)var2.findViewById(R.id.actionbar_tv_title);
      String var4;
      if(StringUtils.isNotEmpty(this.getFragmentTitle())) {
         var4 = this.getFragmentTitle();
      } else {
         var4 = "";
      }

      var3.setText(var4);
      return var2;
   }

   protected String getFragmentTitle() {
      return "";
   }

   public ScreenOrientation getScreenOrientation() {
      return ScreenOrientation.PORTRAIT;
   }

   public boolean goToHome() {
      return false;
   }

   public abstract boolean handleMessage(int var1);

   public abstract boolean handleMessage(CRMessage var1);

   public boolean hasActionBar() {
      return true;
   }

   protected void hideActionBar() {
      ActionBar var1 = this.getActivity().getActionBar();
      if(var1 != null) {
         var1.hide();
      }

   }

   public void initTopActionBar() {
      this.setTopPadding(true);
      this.showSystemActionBar(this.getFragmentActionBarView(this.getActivity()));
   }

   public void onAttach(Activity var1) {
      super.onAttach(var1);

      try {
         this.controller = (ControllerState)var1;
      } catch (ClassCastException var2) {
         throw new RuntimeException("Activity must implement ControllerState");
      }
   }

   public boolean onBack() {
      return false;
   }

   public void onRefresh() {
      this.initTopActionBar();
   }

   public void onResume() {
      super.onResume();
      if(this.actionBarRequired()) {
         this.initTopActionBar();
      }

   }

   protected void setTopPadding(boolean var1) {
      TypedValue var3 = new TypedValue();
      this.getActivity().getTheme().resolveAttribute(16843499, var3, true);
      int var2 = this.getResources().getDimensionPixelSize(var3.resourceId);
      if(this.getView() != null) {
         View var4 = this.getView();
         if(!var1) {
            var2 = 0;
         }

         var4.setPadding(0, var2, 0, 0);
      }

   }

   protected void showSystemActionBar(View var1) {
      ActionBar var2 = this.getActivity().getActionBar();
      if(var2 != null) {
         var2.setDisplayShowTitleEnabled(false);
         var2.setDisplayShowCustomEnabled(true);
         var2.setDisplayHomeAsUpEnabled(false);
         var2.setDisplayShowHomeEnabled(false);
         var2.setCustomView(var1);
         var2.setNavigationMode(0);
         var2.show();
      }

   }

   protected void showToast(String var1) {
      Toast.makeText(this.getActivity(), var1, 0).show();
   }

   protected void toggleProgressBar(BaseListFragment.Toggle var1) {
      if(this.getProgressBar(this.getView()) != null) {
         ProgressBar var3 = this.getProgressBar(this.getView());
         byte var2;
         if(var1 == BaseListFragment.Toggle.ON) {
            var2 = 0;
         } else {
            var2 = 8;
         }

         var3.setVisibility(var2);
      }

   }

   protected static enum Toggle {
      OFF,
      ON;
   }
}
