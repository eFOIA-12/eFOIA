package com.parallel6.ui.configurability;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.ui.configurability.fragments.CRConfListFragment;

public class CRTabListFragment extends CRConfListFragment {
   public View onCreateView(@NonNull LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(R.layout.fragment_tablist, (ViewGroup)null);
   }
}
