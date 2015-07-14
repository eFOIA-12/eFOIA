package com.google.android.gms.ads.search;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.bg;

public final class SearchAdRequest {
   public static final int BORDER_TYPE_DASHED = 1;
   public static final int BORDER_TYPE_DOTTED = 2;
   public static final int BORDER_TYPE_NONE = 0;
   public static final int BORDER_TYPE_SOLID = 3;
   public static final int CALL_BUTTON_COLOR_DARK = 2;
   public static final int CALL_BUTTON_COLOR_LIGHT = 0;
   public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
   public static final String DEVICE_ID_EMULATOR;
   public static final int ERROR_CODE_INTERNAL_ERROR = 0;
   public static final int ERROR_CODE_INVALID_REQUEST = 1;
   public static final int ERROR_CODE_NETWORK_ERROR = 2;
   public static final int ERROR_CODE_NO_FILL = 3;
   private final bg lg;
   private final int xA;
   private final int xB;
   private final int xC;
   private final int xD;
   private final int xE;
   private final int xF;
   private final int xG;
   private final int xH;
   private final String xI;
   private final int xJ;
   private final String xK;
   private final int xL;
   private final int xM;
   private final String xN;

   static {
      DEVICE_ID_EMULATOR = bg.DEVICE_ID_EMULATOR;
   }

   private SearchAdRequest(SearchAdRequest.Builder var1) {
      this.xA = var1.xA;
      this.xB = var1.xB;
      this.xC = var1.xC;
      this.xD = var1.xD;
      this.xE = var1.xE;
      this.xF = var1.xF;
      this.xG = var1.xG;
      this.xH = var1.xH;
      this.xI = var1.xI;
      this.xJ = var1.xJ;
      this.xK = var1.xK;
      this.xL = var1.xL;
      this.xM = var1.xM;
      this.xN = var1.xN;
      this.lg = new bg(var1.lh, this);
   }

   // $FF: synthetic method
   SearchAdRequest(SearchAdRequest.Builder var1, Object var2) {
      this(var1);
   }

   bg Y() {
      return this.lg;
   }

   public int getAnchorTextColor() {
      return this.xA;
   }

   public int getBackgroundColor() {
      return this.xB;
   }

   public int getBackgroundGradientBottom() {
      return this.xC;
   }

   public int getBackgroundGradientTop() {
      return this.xD;
   }

   public int getBorderColor() {
      return this.xE;
   }

   public int getBorderThickness() {
      return this.xF;
   }

   public int getBorderType() {
      return this.xG;
   }

   public int getCallButtonColor() {
      return this.xH;
   }

   public String getCustomChannels() {
      return this.xI;
   }

   public Bundle getCustomEventExtrasBundle(Class var1) {
      return this.lg.getCustomEventExtrasBundle(var1);
   }

   public int getDescriptionTextColor() {
      return this.xJ;
   }

   public String getFontFace() {
      return this.xK;
   }

   public int getHeaderTextColor() {
      return this.xL;
   }

   public int getHeaderTextSize() {
      return this.xM;
   }

   public Location getLocation() {
      return this.lg.getLocation();
   }

   @Deprecated
   public NetworkExtras getNetworkExtras(Class var1) {
      return this.lg.getNetworkExtras(var1);
   }

   public Bundle getNetworkExtrasBundle(Class var1) {
      return this.lg.getNetworkExtrasBundle(var1);
   }

   public String getQuery() {
      return this.xN;
   }

   public boolean isTestDevice(Context var1) {
      return this.lg.isTestDevice(var1);
   }

   public static final class Builder {
      private final bg.a lh = new bg.a();
      private int xA;
      private int xB;
      private int xC;
      private int xD;
      private int xE;
      private int xF;
      private int xG = 0;
      private int xH;
      private String xI;
      private int xJ;
      private String xK;
      private int xL;
      private int xM;
      private String xN;

      public SearchAdRequest.Builder addCustomEventExtrasBundle(Class var1, Bundle var2) {
         this.lh.b(var1, var2);
         return this;
      }

      public SearchAdRequest.Builder addNetworkExtras(NetworkExtras var1) {
         this.lh.a(var1);
         return this;
      }

      public SearchAdRequest.Builder addNetworkExtrasBundle(Class var1, Bundle var2) {
         this.lh.a(var1, var2);
         return this;
      }

      public SearchAdRequest.Builder addTestDevice(String var1) {
         this.lh.s(var1);
         return this;
      }

      public SearchAdRequest build() {
         return new SearchAdRequest(this, null);
      }

      public SearchAdRequest.Builder setAnchorTextColor(int var1) {
         this.xA = var1;
         return this;
      }

      public SearchAdRequest.Builder setBackgroundColor(int var1) {
         this.xB = var1;
         this.xC = Color.argb(0, 0, 0, 0);
         this.xD = Color.argb(0, 0, 0, 0);
         return this;
      }

      public SearchAdRequest.Builder setBackgroundGradient(int var1, int var2) {
         this.xB = Color.argb(0, 0, 0, 0);
         this.xC = var2;
         this.xD = var1;
         return this;
      }

      public SearchAdRequest.Builder setBorderColor(int var1) {
         this.xE = var1;
         return this;
      }

      public SearchAdRequest.Builder setBorderThickness(int var1) {
         this.xF = var1;
         return this;
      }

      public SearchAdRequest.Builder setBorderType(int var1) {
         this.xG = var1;
         return this;
      }

      public SearchAdRequest.Builder setCallButtonColor(int var1) {
         this.xH = var1;
         return this;
      }

      public SearchAdRequest.Builder setCustomChannels(String var1) {
         this.xI = var1;
         return this;
      }

      public SearchAdRequest.Builder setDescriptionTextColor(int var1) {
         this.xJ = var1;
         return this;
      }

      public SearchAdRequest.Builder setFontFace(String var1) {
         this.xK = var1;
         return this;
      }

      public SearchAdRequest.Builder setHeaderTextColor(int var1) {
         this.xL = var1;
         return this;
      }

      public SearchAdRequest.Builder setHeaderTextSize(int var1) {
         this.xM = var1;
         return this;
      }

      public SearchAdRequest.Builder setLocation(Location var1) {
         this.lh.a(var1);
         return this;
      }

      public SearchAdRequest.Builder setQuery(String var1) {
         this.xN = var1;
         return this;
      }

      public SearchAdRequest.Builder tagForChildDirectedTreatment(boolean var1) {
         this.lh.j(var1);
         return this;
      }
   }
}
