package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import java.util.Arrays;
import java.util.Collections;

public class lo extends com.google.android.gms.drive.metadata.internal.j {
   public lo(int var1) {
      super("customProperties", Collections.singleton("customProperties"), Arrays.asList(new String[]{"customPropertiesExtra"}), var1);
   }

   // $FF: synthetic method
   protected Object c(DataHolder var1, int var2, int var3) {
      return this.l(var1, var2, var3);
   }

   protected AppVisibleCustomProperties l(DataHolder var1, int var2, int var3) {
      return (AppVisibleCustomProperties)var1.gV().getSparseParcelableArray("customPropertiesExtra").get(var2, AppVisibleCustomProperties.Rd);
   }
}
