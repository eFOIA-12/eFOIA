package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.tagmanager.aq;
import com.google.android.gms.tagmanager.dg;
import com.google.android.gms.tagmanager.y;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class i extends dg {
   private static final String ID;
   private static final String URL;
   private static final String aqf;
   private static final String aqg;
   static final String aqh;
   private static final Set aqi;
   private final i.a aqj;
   private final Context mContext;

   static {
      ID = com.google.android.gms.internal.a.ay.toString();
      URL = com.google.android.gms.internal.b.eX.toString();
      aqf = com.google.android.gms.internal.b.bl.toString();
      aqg = com.google.android.gms.internal.b.eW.toString();
      aqh = "gtm_" + ID + "_unrepeatable";
      aqi = new HashSet();
   }

   public i(final Context var1) {
      this(var1, new i.a() {
         public aq pf() {
            return y.X(var1);
         }
      });
   }

   i(Context var1, i.a var2) {
      super(ID, new String[]{URL});
      this.aqj = var2;
      this.mContext = var1;
   }

   private boolean cl(String param1) {
      // $FF: Couldn't be decompiled
   }

   public void D(Map param1) {
      // $FF: Couldn't be decompiled
   }

   boolean cm(String var1) {
      return this.mContext.getSharedPreferences(aqh, 0).contains(var1);
   }

   boolean cn(String var1) {
      return aqi.contains(var1);
   }

   public interface a {
      aq pf();
   }
}
