package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class i extends com.google.android.gms.drive.metadata.b {
   public i(String var1, int var2) {
      super(var1, Collections.emptySet(), Collections.singleton(var1), var2);
   }

   protected void a(Bundle var1, Collection var2) {
      var1.putParcelableArrayList(this.getName(), new ArrayList(var2));
   }

   // $FF: synthetic method
   protected Object i(Bundle var1) {
      return this.n(var1);
   }

   protected Collection n(Bundle var1) {
      return var1.getParcelableArrayList(this.getName());
   }
}
