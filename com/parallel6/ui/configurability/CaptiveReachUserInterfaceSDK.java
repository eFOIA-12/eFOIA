package com.parallel6.ui.configurability;

import com.parallel6.captivereachconnectsdk.models.MobileMenu;
import com.parallel6.ui.configurability.enums.LayoutTemplates;
import com.parallel6.ui.configurability.fragments.CRConfCalendarFragment;
import com.parallel6.ui.configurability.fragments.CRConfListFragment;
import com.parallel6.ui.configurability.fragments.CRConfMapFragment;
import com.parallel6.ui.configurability.fragments.detail.CRConfDetailFragment1;
import com.parallel6.ui.configurability.fragments.detail.CRConfDetailFragment2;
import com.parallel6.ui.configurability.fragments.detail.CRConfDetailFragment3;
import com.parallel6.ui.configurability.fragments.undefined.CRUndefinedFragment;
import com.parallel6.ui.configurability.models.CRConfLayoutModule;
import com.parallel6.ui.enums.Action;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class CaptiveReachUserInterfaceSDK {
   private static CaptiveReachUserInterfaceSDK instance;
   private HashMap actionsMap = new HashMap();
   private boolean useConfigurability;

   private HashMap getChildMap(String var1, CRConfLayoutModule var2) {
      HashMap var3 = new HashMap();
      var3.put(var1, var2);
      return var3;
   }

   private Class getFragmentClass(LayoutTemplates var1) {
      switch(null.$SwitchMap$com$parallel6$ui$configurability$enums$LayoutTemplates[var1.ordinal()]) {
      case 1:
      case 2:
      case 3:
      case 4:
         return CRConfListFragment.class;
      case 5:
      case 6:
         return CRConfDetailFragment1.class;
      case 7:
         return CRConfDetailFragment2.class;
      case 8:
         return CRConfDetailFragment3.class;
      case 9:
         return CRConfCalendarFragment.class;
      case 10:
         return CRConfMapFragment.class;
      default:
         return CRUndefinedFragment.class;
      }
   }

   public static CaptiveReachUserInterfaceSDK getInstance() {
      if(instance == null) {
         instance = new CaptiveReachUserInterfaceSDK();
      }

      return instance;
   }

   public void addAction(Action var1, String var2, CRConfLayoutModule var3) {
      if(this.actionsMap.containsKey(var1)) {
         ((HashMap)this.actionsMap.get(var1)).put(var2, var3);
      } else {
         this.actionsMap.put(var1, this.getChildMap(var2, var3));
      }
   }

   public Class getActionPermanentLinkClass(Action var1, String var2) {
      Class var4 = CRUndefinedFragment.class;
      Class var3 = var4;
      if(this.actionsMap.containsKey(var1)) {
         HashMap var5 = (HashMap)this.actionsMap.get(var1);
         var3 = var4;
         if(var5.containsKey(var2)) {
            var3 = this.getFragmentClass(LayoutTemplates.getSafeTemplate(((CRConfLayoutModule)var5.get(String.valueOf(var2))).getLayout().getLayoutID()));
         }
      }

      return var3;
   }

   public CRConfLayoutModule getLayoutViewModel(Action var1, String var2) {
      return (CRConfLayoutModule)((HashMap)this.actionsMap.get(var1)).get(var2);
   }

   public void initializeLayouts(Action var1, MobileMenu var2) {
      CRConfLayoutModule var3 = new CRConfLayoutModule();
      var3.setLayout(var2.getLayout());
      var3.setLayoutSlots(var2.getSlotList());
      var3.setPermanentLink(var2.getStringActionObject());
      this.addAction(var1, String.valueOf(var2.getId()), var3);
   }

   public void initializeLayouts(Action var1, List var2) {
      Iterator var4 = var2.iterator();

      while(var4.hasNext()) {
         CRConfLayoutModule var3 = (CRConfLayoutModule)var4.next();
         this.addAction(var1, var3.getPermanentLink(), var3);
      }

   }

   public boolean isUsingConfigurability() {
      return this.useConfigurability;
   }

   public void useConfigurability(boolean var1) {
      this.useConfigurability = var1;
   }
}
