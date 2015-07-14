package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.ag;
import com.google.android.gms.tagmanager.bh;
import com.google.android.gms.tagmanager.br;
import com.google.android.gms.tagmanager.ce;
import com.google.android.gms.tagmanager.cr;
import com.google.android.gms.tagmanager.ct;
import com.google.android.gms.tagmanager.di;
import com.google.android.gms.tagmanager.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Container {
   private final String aqm;
   private final DataLayer aqn;
   private ct aqo;
   private Map aqp = new HashMap();
   private Map aqq = new HashMap();
   private volatile long aqr;
   private volatile String aqs = "";
   private final Context mContext;

   Container(Context var1, DataLayer var2, String var3, long var4, com.google.android.gms.internal.c var6) {
      this.mContext = var1;
      this.aqn = var2;
      this.aqm = var3;
      this.aqr = var4;
      this.a(var6.gs);
      if(var6.gr != null) {
         this.a(var6.gr);
      }

   }

   Container(Context var1, DataLayer var2, String var3, long var4, cr.c var6) {
      this.mContext = var1;
      this.aqn = var2;
      this.aqm = var3;
      this.aqr = var4;
      this.a(var6);
   }

   private void a(com.google.android.gms.internal.c var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         cr.c var2;
         try {
            var2 = cr.b(var1);
         } catch (cr.g var3) {
            bh.T("Not loading resource: " + var1 + " because it is invalid: " + var3.toString());
            return;
         }

         this.a(var2);
      }
   }

   private void a(cr.c var1) {
      this.aqs = var1.getVersion();
      ag var2 = this.cs(this.aqs);
      this.a(new ct(this.mContext, var1, this.aqn, new Container.a(null), new Container.b(null), var2));
   }

   private void a(ct var1) {
      synchronized(this){}

      try {
         this.aqo = var1;
      } finally {
         ;
      }

   }

   private void a(com.google.android.gms.internal.c[] var1) {
      ArrayList var4 = new ArrayList();
      int var3 = var1.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         var4.add(var1[var2]);
      }

      this.pk().l(var4);
   }

   private ct pk() {
      synchronized(this){}

      ct var1;
      try {
         var1 = this.aqo;
      } finally {
         ;
      }

      return var1;
   }

   Container.FunctionCallMacroCallback cp(String param1) {
      // $FF: Couldn't be decompiled
   }

   Container.FunctionCallTagCallback cq(String param1) {
      // $FF: Couldn't be decompiled
   }

   void cr(String var1) {
      this.pk().cr(var1);
   }

   ag cs(String var1) {
      if(ce.qa().qb().equals(ce.a.ass)) {
         ;
      }

      return new br();
   }

   public boolean getBoolean(String var1) {
      ct var3 = this.pk();
      if(var3 == null) {
         bh.T("getBoolean called for closed container.");
         return di.qY().booleanValue();
      } else {
         try {
            boolean var2 = di.n((com.google.android.gms.internal.d)var3.cT(var1).getObject()).booleanValue();
            return var2;
         } catch (Exception var4) {
            bh.T("Calling getBoolean() threw an exception: " + var4.getMessage() + " Returning default value.");
            return di.qY().booleanValue();
         }
      }
   }

   public String getContainerId() {
      return this.aqm;
   }

   public double getDouble(String var1) {
      ct var4 = this.pk();
      if(var4 == null) {
         bh.T("getDouble called for closed container.");
         return di.qX().doubleValue();
      } else {
         try {
            double var2 = di.m((com.google.android.gms.internal.d)var4.cT(var1).getObject()).doubleValue();
            return var2;
         } catch (Exception var5) {
            bh.T("Calling getDouble() threw an exception: " + var5.getMessage() + " Returning default value.");
            return di.qX().doubleValue();
         }
      }
   }

   public long getLastRefreshTime() {
      return this.aqr;
   }

   public long getLong(String var1) {
      ct var4 = this.pk();
      if(var4 == null) {
         bh.T("getLong called for closed container.");
         return di.qW().longValue();
      } else {
         try {
            long var2 = di.l((com.google.android.gms.internal.d)var4.cT(var1).getObject()).longValue();
            return var2;
         } catch (Exception var5) {
            bh.T("Calling getLong() threw an exception: " + var5.getMessage() + " Returning default value.");
            return di.qW().longValue();
         }
      }
   }

   public String getString(String var1) {
      ct var2 = this.pk();
      if(var2 == null) {
         bh.T("getString called for closed container.");
         return di.ra();
      } else {
         try {
            var1 = di.j((com.google.android.gms.internal.d)var2.cT(var1).getObject());
            return var1;
         } catch (Exception var3) {
            bh.T("Calling getString() threw an exception: " + var3.getMessage() + " Returning default value.");
            return di.ra();
         }
      }
   }

   public boolean isDefault() {
      return this.getLastRefreshTime() == 0L;
   }

   String pj() {
      return this.aqs;
   }

   public void registerFunctionCallMacroCallback(String param1, Container.FunctionCallMacroCallback param2) {
      // $FF: Couldn't be decompiled
   }

   public void registerFunctionCallTagCallback(String param1, Container.FunctionCallTagCallback param2) {
      // $FF: Couldn't be decompiled
   }

   void release() {
      this.aqo = null;
   }

   public void unregisterFunctionCallMacroCallback(String param1) {
      // $FF: Couldn't be decompiled
   }

   public void unregisterFunctionCallTagCallback(String param1) {
      // $FF: Couldn't be decompiled
   }

   public interface FunctionCallMacroCallback {
      Object getValue(String var1, Map var2);
   }

   public interface FunctionCallTagCallback {
      void execute(String var1, Map var2);
   }

   private class a implements s.a {
      private a() {
      }

      // $FF: synthetic method
      a(Object var2) {
         this();
      }

      public Object b(String var1, Map var2) {
         Container.FunctionCallMacroCallback var3 = Container.this.cp(var1);
         return var3 == null?null:var3.getValue(var1, var2);
      }
   }

   private class b implements s.a {
      private b() {
      }

      // $FF: synthetic method
      b(Object var2) {
         this();
      }

      public Object b(String var1, Map var2) {
         Container.FunctionCallTagCallback var3 = Container.this.cq(var1);
         if(var3 != null) {
            var3.execute(var1, var2);
         }

         return di.ra();
      }
   }
}
