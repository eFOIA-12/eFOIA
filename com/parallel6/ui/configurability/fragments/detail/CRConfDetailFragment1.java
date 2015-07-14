package com.parallel6.ui.configurability.fragments.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.ui.configurability.fragments.BaseLayoutFragment;
import com.parallel6.ui.configurability.models.CRConfLayoutSlot;
import java.util.Iterator;

public class CRConfDetailFragment1 extends BaseLayoutFragment {
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(R.layout.config_detail_1, (ViewGroup)null);
   }

   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      var1.setBackgroundColor(this.getResources().getColor(17170443));
      Iterator var4 = this.layoutModel.getLayoutSlots().iterator();

      while(var4.hasNext()) {
         CRConfLayoutSlot var5 = (CRConfLayoutSlot)var4.next();
         Object var3 = this.valuesMap.get(var5.getAttributeKey());
         this.getSlotViewById(this.getActivity(), var5.getSlotId()).initSlotView(var3, var5.getStyle());
      }

   }
}
