package com.google.android.gms.analytics;

import com.google.android.gms.analytics.r;
import java.util.Collection;
import java.util.Map;

interface d {
   void a(Map var1, long var2, String var4, Collection var5);

   r dV();

   void dispatch();

   void l(long var1);

   void setDryRun(boolean var1);
}
