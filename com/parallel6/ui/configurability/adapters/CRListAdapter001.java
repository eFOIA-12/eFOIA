package com.parallel6.ui.configurability.adapters;

import android.content.Context;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.ui.configurability.adapters.CRBaseConfigurabilityAdapter;
import com.parallel6.ui.configurability.models.CRConfLayoutModule;
import java.util.List;

public class CRListAdapter001 extends CRBaseConfigurabilityAdapter {
   public CRListAdapter001(Context var1, List var2) {
      super(var1);
   }

   public CRListAdapter001(Context var1, List var2, CRConfLayoutModule var3) {
      super(var1, var2, var3);
   }

   protected int getRowLayoutResource() {
      return R.layout.config_list_1;
   }
}
