package com.parallel6.ui.configurability.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.internal.LinkedTreeMap;
import com.parallel6.ui.adapters.base.CRBaseAdapter;
import com.parallel6.ui.configurability.interfaces.CRSlotView;
import com.parallel6.ui.configurability.models.CRConfLayoutModule;
import com.parallel6.ui.configurability.models.CRConfLayoutSlot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class CRBaseConfigurabilityAdapter extends CRBaseAdapter {
   protected CRConfLayoutModule layoutModel;
   protected List valuesMap = new ArrayList();

   public CRBaseConfigurabilityAdapter(Context var1) {
      super(var1, (List)null);
   }

   public CRBaseConfigurabilityAdapter(Context var1, List var2) {
      super(var1, (List)null);
      this.valuesMap = var2;
   }

   public CRBaseConfigurabilityAdapter(Context var1, List var2, CRConfLayoutModule var3) {
      super(var1, (List)null);
      this.valuesMap = var2;
      this.layoutModel = var3;
   }

   public int getCount() {
      return this.valuesMap.size();
   }

   public Object getItem(int var1) {
      return this.valuesMap.get(var1);
   }

   protected abstract int getRowLayoutResource();

   public CRSlotView getSlotViewById(Context var1, View var2, String var3) {
      String var5 = var1.getPackageName();

      int var4;
      try {
         var4 = var1.getResources().getIdentifier(var3, "id", var5);
      } catch (Exception var7) {
         var4 = -1;
      }

      if(var4 != -1 && var2 != null) {
         try {
            CRSlotView var8 = (CRSlotView)var2.findViewById(var4);
            return var8;
         } catch (Exception var6) {
            throw new RuntimeException("Defined view must implement CRSlotView");
         }
      } else {
         return null;
      }
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      var2 = View.inflate(this.mContext, this.getRowLayoutResource(), (ViewGroup)null);
      LinkedTreeMap var8 = (LinkedTreeMap)this.valuesMap.get(var1);
      Iterator var4 = this.layoutModel.getLayoutSlots().iterator();

      while(var4.hasNext()) {
         CRConfLayoutSlot var5 = (CRConfLayoutSlot)var4.next();

         try {
            Object var6 = var8.get(var5.getAttributeKey());
            this.getSlotViewById(this.mContext, var2, var5.getSlotId()).initSlotView(var6, var5.getStyle());
         } catch (Exception var7) {
            var7.printStackTrace();
         }
      }

      return var2;
   }
}
