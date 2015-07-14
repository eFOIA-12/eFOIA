package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.tagmanager.av;
import com.google.android.gms.tagmanager.aw;
import com.google.android.gms.tagmanager.bm;

class bn {
   public bm pO() {
      return (bm)(this.pg() < 8?new av():new aw());
   }

   int pg() {
      return VERSION.SDK_INT;
   }
}
