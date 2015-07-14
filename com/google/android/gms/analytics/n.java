package com.google.android.gms.analytics;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.content.res.Resources.NotFoundException;
import com.google.android.gms.analytics.ae;
import com.google.android.gms.analytics.m;

abstract class n {
   Context mContext;
   n.a yL;

   public n(Context var1, n.a var2) {
      this.mContext = var1;
      this.yL = var2;
   }

   private m a(XmlResourceParser param1) {
      // $FF: Couldn't be decompiled
   }

   public m x(int var1) {
      try {
         m var2 = this.a(this.mContext.getResources().getXml(var1));
         return var2;
      } catch (NotFoundException var3) {
         ae.W("inflate() called with unknown resourceId: " + var3);
         return null;
      }
   }

   public interface a {
      void c(String var1, int var2);

      void e(String var1, String var2);

      void e(String var1, boolean var2);

      m er();

      void f(String var1, String var2);
   }
}
