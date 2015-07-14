package com.parallel6.ui.fragments.factories;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import com.parallel6.captivereachconnectsdk.models.MobileMenu;
import com.parallel6.ui.actions.CRActionFactory;
import com.parallel6.ui.fragments.CRSubcategoryListFragment;
import com.parallel6.ui.interfaces.FragmentState;

public class CRSubcategoryListFragmentFactory {
   public static CRSubcategoryListFragmentFactory getInstance() {
      return new CRSubcategoryListFragmentFactory();
   }

   public FragmentState getSubcategoryFragment(Context var1, Bundle var2, MobileMenu var3, CRActionFactory var4) {
      return (FragmentState)Fragment.instantiate(var1, CRSubcategoryListFragment.class.getName(), var2);
   }
}
