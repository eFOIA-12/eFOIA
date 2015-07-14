package com.google.android.gms.tagmanager;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Build.VERSION;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.bh;
import com.google.android.gms.tagmanager.cx;
import com.google.android.gms.tagmanager.d;
import com.google.android.gms.tagmanager.n;
import com.google.android.gms.tagmanager.o;
import com.google.android.gms.tagmanager.r;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager {
   private static TagManager atW;
   private final DataLayer aqn;
   private final r asD;
   private final TagManager.a atT;
   private final cx atU;
   private final ConcurrentMap atV;
   private final Context mContext;

   TagManager(Context var1, TagManager.a var2, DataLayer var3, cx var4) {
      if(var1 == null) {
         throw new NullPointerException("context cannot be null");
      } else {
         this.mContext = var1.getApplicationContext();
         this.atU = var4;
         this.atT = var2;
         this.atV = new ConcurrentHashMap();
         this.aqn = var3;
         this.aqn.a(new DataLayer.b() {
            public void C(Map var1) {
               Object var2 = var1.get("event");
               if(var2 != null) {
                  TagManager.this.cV(var2.toString());
               }

            }
         });
         this.aqn.a((DataLayer.b)(new d(this.mContext)));
         this.asD = new r();
         this.qP();
      }
   }

   private void cV(String var1) {
      Iterator var2 = this.atV.keySet().iterator();

      while(var2.hasNext()) {
         ((n)var2.next()).cr(var1);
      }

   }

   public static TagManager getInstance(Context param0) {
      // $FF: Couldn't be decompiled
   }

   private void qP() {
      if(VERSION.SDK_INT >= 14) {
         this.mContext.registerComponentCallbacks(new ComponentCallbacks2() {
            public void onConfigurationChanged(Configuration var1) {
            }

            public void onLowMemory() {
            }

            public void onTrimMemory(int var1) {
               if(var1 == 20) {
                  TagManager.this.dispatch();
               }

            }
         });
      }

   }

   void a(n var1) {
      this.atV.put(var1, Boolean.valueOf(true));
   }

   boolean b(n var1) {
      return this.atV.remove(var1) != null;
   }

   public void dispatch() {
      this.atU.dispatch();
   }

   public DataLayer getDataLayer() {
      return this.aqn;
   }

   boolean i(Uri param1) {
      // $FF: Couldn't be decompiled
   }

   public PendingResult loadContainerDefaultOnly(String var1, int var2) {
      o var3 = this.atT.a(this.mContext, this, (Looper)null, var1, var2, this.asD);
      var3.po();
      return var3;
   }

   public PendingResult loadContainerDefaultOnly(String var1, int var2, Handler var3) {
      o var4 = this.atT.a(this.mContext, this, var3.getLooper(), var1, var2, this.asD);
      var4.po();
      return var4;
   }

   public PendingResult loadContainerPreferFresh(String var1, int var2) {
      o var3 = this.atT.a(this.mContext, this, (Looper)null, var1, var2, this.asD);
      var3.pq();
      return var3;
   }

   public PendingResult loadContainerPreferFresh(String var1, int var2, Handler var3) {
      o var4 = this.atT.a(this.mContext, this, var3.getLooper(), var1, var2, this.asD);
      var4.pq();
      return var4;
   }

   public PendingResult loadContainerPreferNonDefault(String var1, int var2) {
      o var3 = this.atT.a(this.mContext, this, (Looper)null, var1, var2, this.asD);
      var3.pp();
      return var3;
   }

   public PendingResult loadContainerPreferNonDefault(String var1, int var2, Handler var3) {
      o var4 = this.atT.a(this.mContext, this, var3.getLooper(), var1, var2, this.asD);
      var4.pp();
      return var4;
   }

   public void setVerboseLoggingEnabled(boolean var1) {
      byte var2;
      if(var1) {
         var2 = 2;
      } else {
         var2 = 5;
      }

      bh.setLogLevel(var2);
   }

   interface a {
      o a(Context var1, TagManager var2, Looper var3, String var4, int var5, r var6);
   }
}
