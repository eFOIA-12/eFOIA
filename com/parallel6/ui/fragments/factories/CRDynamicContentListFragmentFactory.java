package com.parallel6.ui.fragments.factories;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import com.parallel6.ui.fragments.list.CRDynamicContentListFragment;
import com.parallel6.ui.fragments.list.pager.CRDynamicPagerFragment;
import com.parallel6.ui.interfaces.FragmentState;

public class CRDynamicContentListFragmentFactory {
   public static CRDynamicContentListFragmentFactory getInstance() {
      return new CRDynamicContentListFragmentFactory();
   }

   protected FragmentState getDynamicListFragment(Context var1, Bundle var2) {
      return (FragmentState)Fragment.instantiate(var1, CRDynamicContentListFragment.class.getName(), var2);
   }

   protected FragmentState getDynamicPagerFragment(Context var1, Bundle var2) {
      return (FragmentState)Fragment.instantiate(var1, CRDynamicPagerFragment.class.getName(), var2);
   }

   public FragmentState getListFragment(Context var1, Bundle var2, String var3) {
      return this.getDynamicListFragment(var1, var2);
   }
}
