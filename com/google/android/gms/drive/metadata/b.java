package com.google.android.gms.drive.metadata;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.a;
import java.util.Collection;

public abstract class b extends a {
   protected b(String var1, Collection var2, Collection var3, int var4) {
      super(var1, var2, var3, var4);
   }

   // $FF: synthetic method
   protected Object c(DataHolder var1, int var2, int var3) {
      return this.d(var1, var2, var3);
   }

   protected Collection d(DataHolder var1, int var2, int var3) {
      throw new UnsupportedOperationException("Cannot read collections from a dataHolder.");
   }
}
