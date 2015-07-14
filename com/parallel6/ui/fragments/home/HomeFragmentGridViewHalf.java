package com.parallel6.ui.fragments.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.ui.fragments.home.HomeFragmentGridView;
import com.parallel6.ui.interfaces.CRMessage;

public class HomeFragmentGridViewHalf extends HomeFragmentGridView {
   public boolean handleMessage(int var1) {
      return false;
   }

   public boolean handleMessage(CRMessage var1) {
      return false;
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(R.layout.fragment_home_grid_view_half, (ViewGroup)null);
   }
}
