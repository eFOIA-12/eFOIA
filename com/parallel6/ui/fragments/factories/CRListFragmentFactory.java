package com.parallel6.ui.fragments.factories;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import com.parallel6.ui.enums.styles.CRContentListStyle;
import com.parallel6.ui.fragments.base.BaseListFragment;
import com.parallel6.ui.fragments.list.CRDynamicContentListFragment;

public class CRListFragmentFactory {
   public static BaseListFragment getDynamicContentListFragment(Context var0, Bundle var1, CRContentListStyle var2) {
      switch(null.$SwitchMap$com$parallel6$ui$enums$styles$CRContentListStyle[var2.ordinal()]) {
      case 1:
         return (CRDynamicContentListFragment)Fragment.instantiate(var0, CRDynamicContentListFragment.class.getName(), var1);
      default:
         return null;
      }
   }

   public static CRListFragmentFactory getInstance() {
      return new CRListFragmentFactory();
   }
}
