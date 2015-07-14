package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gq;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@ey
public final class bg {
   public static final String DEVICE_ID_EMULATOR = gq.R("emulator");
   private final Date d;
   private final Set f;
   private final Location h;
   private final String oA;
   private final SearchAdRequest oB;
   private final int oC;
   private final Set oD;
   private final String ov;
   private final int ow;
   private final boolean ox;
   private final Bundle oy;
   private final Map oz;

   public bg(bg.a var1) {
      this(var1, (SearchAdRequest)null);
   }

   public bg(bg.a var1, SearchAdRequest var2) {
      this.d = var1.d;
      this.ov = var1.ov;
      this.ow = var1.ow;
      this.f = Collections.unmodifiableSet(var1.oE);
      this.h = var1.h;
      this.ox = var1.ox;
      this.oy = var1.oy;
      this.oz = Collections.unmodifiableMap(var1.oF);
      this.oA = var1.oA;
      this.oB = var2;
      this.oC = var1.oC;
      this.oD = Collections.unmodifiableSet(var1.oG);
   }

   public SearchAdRequest bi() {
      return this.oB;
   }

   public Map bj() {
      return this.oz;
   }

   public Bundle bk() {
      return this.oy;
   }

   public int bl() {
      return this.oC;
   }

   public Date getBirthday() {
      return this.d;
   }

   public String getContentUrl() {
      return this.ov;
   }

   public Bundle getCustomEventExtrasBundle(Class var1) {
      Bundle var2 = this.oy.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
      return var2 != null?var2.getBundle(var1.getClass().getName()):null;
   }

   public int getGender() {
      return this.ow;
   }

   public Set getKeywords() {
      return this.f;
   }

   public Location getLocation() {
      return this.h;
   }

   public boolean getManualImpressionsEnabled() {
      return this.ox;
   }

   @Deprecated
   public NetworkExtras getNetworkExtras(Class var1) {
      return (NetworkExtras)this.oz.get(var1);
   }

   public Bundle getNetworkExtrasBundle(Class var1) {
      return this.oy.getBundle(var1.getName());
   }

   public String getPublisherProvidedId() {
      return this.oA;
   }

   public boolean isTestDevice(Context var1) {
      return this.oD.contains(gq.v(var1));
   }

   public static final class a {
      private Date d;
      private Location h;
      private String oA;
      private int oC = -1;
      private final HashSet oE = new HashSet();
      private final HashMap oF = new HashMap();
      private final HashSet oG = new HashSet();
      private String ov;
      private int ow = -1;
      private boolean ox = false;
      private final Bundle oy = new Bundle();

      public void a(Location var1) {
         this.h = var1;
      }

      @Deprecated
      public void a(NetworkExtras var1) {
         if(var1 instanceof AdMobExtras) {
            this.a(AdMobAdapter.class, ((AdMobExtras)var1).getExtras());
         } else {
            this.oF.put(var1.getClass(), var1);
         }
      }

      public void a(Class var1, Bundle var2) {
         this.oy.putBundle(var1.getName(), var2);
      }

      public void a(Date var1) {
         this.d = var1;
      }

      public void b(Class var1, Bundle var2) {
         if(this.oy.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
            this.oy.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
         }

         this.oy.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(var1.getName(), var2);
      }

      public void h(int var1) {
         this.ow = var1;
      }

      public void i(boolean var1) {
         this.ox = var1;
      }

      public void j(boolean var1) {
         byte var2;
         if(var1) {
            var2 = 1;
         } else {
            var2 = 0;
         }

         this.oC = var2;
      }

      public void r(String var1) {
         this.oE.add(var1);
      }

      public void s(String var1) {
         this.oG.add(var1);
      }

      public void t(String var1) {
         this.ov = var1;
      }

      public void u(String var1) {
         this.oA = var1;
      }
   }
}
