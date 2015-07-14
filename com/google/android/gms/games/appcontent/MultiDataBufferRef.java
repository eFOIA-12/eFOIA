package com.google.android.gms.games.appcontent;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import java.util.ArrayList;

public abstract class MultiDataBufferRef extends d {
   protected final ArrayList XX;

   protected MultiDataBufferRef(ArrayList var1, int var2, int var3) {
      super((DataHolder)var1.get(var2), var3);
      this.XX = var1;
   }
}
