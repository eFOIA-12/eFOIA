package com.google.android.gms.games.appcontent;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.games.appcontent.AppContentSection;
import com.google.android.gms.games.appcontent.AppContentSectionRef;
import java.util.ArrayList;

public final class AppContentSectionBuffer extends g {
   private final ArrayList XX;

   // $FF: synthetic method
   protected Object f(int var1, int var2) {
      return this.h(var1, var2);
   }

   protected AppContentSection h(int var1, int var2) {
      return new AppContentSectionRef(this.XX, var1, var2);
   }

   protected String ha() {
      return "section_id";
   }

   protected String hc() {
      return "card_id";
   }

   public void release() {
      super.release();
      int var2 = this.XX.size();

      for(int var1 = 1; var1 < var2; ++var1) {
         DataHolder var3 = (DataHolder)this.XX.get(var1);
         if(var3 != null) {
            var3.close();
         }
      }

   }
}
