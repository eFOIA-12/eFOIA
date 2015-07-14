package com.parallel6.ui.fragments.base;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.captivereachconnectsdk.utils.StringUtils;
import com.parallel6.ui.enums.ScreenOrientation;
import com.parallel6.ui.interfaces.CRMessage;
import com.parallel6.ui.interfaces.ControllerState;
import com.parallel6.ui.interfaces.FragmentState;
import com.parallel6.ui.models.CRTheme;

public abstract class BaseFragment extends Fragment implements FragmentState {
   protected ControllerState controller;
   protected CRTheme theme;

   protected boolean actionBarRequired() {
      return true;
   }

   protected View findView(View var1, int var2) {
      return var1.findViewById(var2);
   }

   protected int getActionBarBackgroundResource(Context var1) {
      return 0;
   }

   protected View getFragmentActionBarView(Context var1) {
      View var2 = this.controller.getBaseBackActionbarView(var1);
      if(this.getActionBarBackgroundResource(var1) != 0) {
         var2.setBackgroundResource(this.getActionBarBackgroundResource(var1));
      }

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

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
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
      this.showSystemActionBar(var1, 0);
   }

   protected void showSystemActionBar(View var1, int var2) {
      ActionBar var3 = this.getActivity().getActionBar();
      if(var3 != null) {
         var3.setDisplayShowTitleEnabled(false);
         var3.setDisplayShowCustomEnabled(true);
         var3.setDisplayHomeAsUpEnabled(false);
         var3.setDisplayShowHomeEnabled(false);
         if(var2 != 0) {
            var3.setBackgroundDrawable(new ColorDrawable(this.getResources().getColor(var2)));
            var1.setBackgroundResource(var2);
         }

         var3.setCustomView(var1);
         var3.setNavigationMode(0);
         var3.show();
      }

   }

   protected void showToast(String var1) {
      Toast.makeText(this.getActivity(), var1, 0).show();
   }

   protected void showToast(String var1, int var2) {
      if(this.getActivity() != null) {
         Toast.makeText(this.getActivity(), var1, var2).show();
      }

   }
}
