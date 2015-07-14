package com.parallel6.ui.configurability.fragments;

import android.content.Context;
import android.os.Bundle;
import com.google.gson.internal.LinkedTreeMap;
import com.parallel6.ui.configurability.interfaces.CRSlotView;
import com.parallel6.ui.configurability.models.CRConfLayoutModule;
import com.parallel6.ui.fragments.base.BaseFragment;
import com.parallel6.ui.interfaces.CRMessage;

public class BaseLayoutFragment extends BaseFragment {
   protected CRConfLayoutModule layoutModel;
   protected String permanentLink;
   protected LinkedTreeMap valuesMap = new LinkedTreeMap();

   public CRSlotView getSlotViewById(Context var1, String var2) {
      String var6 = var1.getPackageName();

      int var3;
      try {
         var3 = this.getResources().getIdentifier(var2, "id", var6);
      } catch (Exception var5) {
         var3 = -1;
      }

      if(var3 != -1) {
         try {
            if(this.getView() == null) {
               return null;
            } else {
               CRSlotView var7 = (CRSlotView)this.getView().findViewById(var3);
               return var7;
            }
         } catch (Exception var4) {
            throw new RuntimeException("Defined view must implement CRSlotView");
         }
      } else {
         return null;
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
      this.permanentLink = this.getArguments().getString("permanent_link");
      this.valuesMap = (LinkedTreeMap)this.getArguments().getSerializable("extras_layout_values");
      this.layoutModel = (CRConfLayoutModule)this.getArguments().getParcelable("extras_layout_model");
   }
}
