package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONException;

public class k extends com.google.android.gms.drive.metadata.b {
   public k(String var1, int var2) {
      super(var1, Collections.singleton(var1), Collections.emptySet(), var2);
   }

   public static final Collection bn(String var0) throws JSONException {
      if(var0 == null) {
         return null;
      } else {
         ArrayList var2 = new ArrayList();
         JSONArray var3 = new JSONArray(var0);

         for(int var1 = 0; var1 < var3.length(); ++var1) {
            var2.add(var3.getString(var1));
         }

         return Collections.unmodifiableCollection(var2);
      }
   }

   protected void a(Bundle var1, Collection var2) {
      var1.putStringArrayList(this.getName(), new ArrayList(var2));
   }

   // $FF: synthetic method
   protected Object c(DataHolder var1, int var2, int var3) {
      return this.d(var1, var2, var3);
   }

   protected Collection d(DataHolder var1, int var2, int var3) {
      try {
         Collection var5 = bn(var1.c(this.getName(), var2, var3));
         return var5;
      } catch (JSONException var4) {
         throw new IllegalStateException("DataHolder supplied invalid JSON", var4);
      }
   }

   // $FF: synthetic method
   protected Object i(Bundle var1) {
      return this.n(var1);
   }

   protected Collection n(Bundle var1) {
      return var1.getStringArrayList(this.getName());
   }
}
