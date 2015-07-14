package com.google.android.gms.internal;

import com.google.android.gms.internal.cb;
import com.google.android.gms.internal.cd;
import com.google.android.gms.internal.ce;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.dv;
import com.google.android.gms.internal.t;
import org.json.JSONObject;

public interface ah {
   void a(ah.a var1);

   void a(t var1, ds var2, cb var3, dv var4, boolean var5, ce var6);

   void a(String var1, cd var2);

   void a(String var1, JSONObject var2);

   void destroy();

   void f(String var1);

   void g(String var1);

   void pause();

   void resume();

   public interface a {
      void aR();
   }
}
