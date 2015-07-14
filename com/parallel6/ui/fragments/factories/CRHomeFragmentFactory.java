package com.parallel6.ui.fragments.factories;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import com.parallel6.ui.actions.CRActionFactory;
import com.parallel6.ui.enums.styles.CRContentHomeStyle;
import com.parallel6.ui.fragments.home.HomeFragmentGridView;
import com.parallel6.ui.fragments.home.HomeFragmentGridViewHalf;
import com.parallel6.ui.fragments.home.HomeFragmentSlidingMenu;
import com.parallel6.ui.interfaces.FragmentState;

public class CRHomeFragmentFactory {
   public static CRHomeFragmentFactory getInstance() {
      return new CRHomeFragmentFactory();
   }

   public FragmentState getHomeFragment(Context var1, Bundle var2, CRContentHomeStyle var3, CRActionFactory var4) {
      switch(null.$SwitchMap$com$parallel6$ui$enums$styles$CRContentHomeStyle[var3.ordinal()]) {
      case 1:
         return this.getHomeFragmentSlidingMenu(var1, var2, var4);
      case 2:
      case 3:
         return this.getHomeFragmentGridMenu(var1, var2, var3, var4);
      default:
         return null;
      }
   }

   protected FragmentState getHomeFragmentGridMenu(Context var1, Bundle var2, CRContentHomeStyle var3, CRActionFactory var4) {
      return var3 == CRContentHomeStyle.GridViewmenu?(FragmentState)Fragment.instantiate(var1, HomeFragmentGridView.class.getName(), var2):(FragmentState)Fragment.instantiate(var1, HomeFragmentGridViewHalf.class.getName(), var2);
   }

   protected FragmentState getHomeFragmentSlidingMenu(Context var1, Bundle var2, CRActionFactory var3) {
      return (FragmentState)Fragment.instantiate(var1, HomeFragmentSlidingMenu.class.getName(), var2);
   }
}
