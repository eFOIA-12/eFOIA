package com.google.android.gms.appindexing;

import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.hc;
import com.google.android.gms.internal.hz;

public final class AppIndex {
   public static final Api API;
   public static final Api APP_INDEX_API;
   public static final AppIndexApi AppIndexApi;

   static {
      API = hc.CI;
      APP_INDEX_API = hc.CI;
      AppIndexApi = new hz();
   }
}
