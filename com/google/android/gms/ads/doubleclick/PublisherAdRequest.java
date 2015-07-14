package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.bg;
import com.google.android.gms.internal.jx;
import java.util.Date;
import java.util.Set;

public final class PublisherAdRequest {
   public static final String DEVICE_ID_EMULATOR;
   public static final int ERROR_CODE_INTERNAL_ERROR = 0;
   public static final int ERROR_CODE_INVALID_REQUEST = 1;
   public static final int ERROR_CODE_NETWORK_ERROR = 2;
   public static final int ERROR_CODE_NO_FILL = 3;
   public static final int GENDER_FEMALE = 2;
   public static final int GENDER_MALE = 1;
   public static final int GENDER_UNKNOWN = 0;
   private final bg lg;

   static {
      DEVICE_ID_EMULATOR = bg.DEVICE_ID_EMULATOR;
   }

   private PublisherAdRequest(PublisherAdRequest.Builder var1) {
      this.lg = new bg(var1.lh);
   }

   // $FF: synthetic method
   PublisherAdRequest(PublisherAdRequest.Builder var1, Object var2) {
      this(var1);
   }

   public bg Y() {
      return this.lg;
   }

   public Date getBirthday() {
      return this.lg.getBirthday();
   }

   public String getContentUrl() {
      return this.lg.getContentUrl();
   }

   public Bundle getCustomEventExtrasBundle(Class var1) {
      return this.lg.getCustomEventExtrasBundle(var1);
   }

   public int getGender() {
      return this.lg.getGender();
   }

   public Set getKeywords() {
      return this.lg.getKeywords();
   }

   public Location getLocation() {
      return this.lg.getLocation();
   }

   public boolean getManualImpressionsEnabled() {
      return this.lg.getManualImpressionsEnabled();
   }

   @Deprecated
   public NetworkExtras getNetworkExtras(Class var1) {
      return this.lg.getNetworkExtras(var1);
   }

   public Bundle getNetworkExtrasBundle(Class var1) {
      return this.lg.getNetworkExtrasBundle(var1);
   }

   public String getPublisherProvidedId() {
      return this.lg.getPublisherProvidedId();
   }

   public boolean isTestDevice(Context var1) {
      return this.lg.isTestDevice(var1);
   }

   public static final class Builder {
      private final bg.a lh = new bg.a();

      public PublisherAdRequest.Builder addCustomEventExtrasBundle(Class var1, Bundle var2) {
         this.lh.b(var1, var2);
         return this;
      }

      public PublisherAdRequest.Builder addKeyword(String var1) {
         this.lh.r(var1);
         return this;
      }

      public PublisherAdRequest.Builder addNetworkExtras(NetworkExtras var1) {
         this.lh.a(var1);
         return this;
      }

      public PublisherAdRequest.Builder addNetworkExtrasBundle(Class var1, Bundle var2) {
         this.lh.a(var1, var2);
         return this;
      }

      public PublisherAdRequest.Builder addTestDevice(String var1) {
         this.lh.s(var1);
         return this;
      }

      public PublisherAdRequest build() {
         return new PublisherAdRequest(this, null);
      }

      public PublisherAdRequest.Builder setBirthday(Date var1) {
         this.lh.a(var1);
         return this;
      }

      public PublisherAdRequest.Builder setContentUrl(String var1) {
         jx.b((Object)var1, "Content URL must be non-null.");
         jx.b((String)var1, "Content URL must be non-empty.");
         boolean var2;
         if(var1.length() <= 512) {
            var2 = true;
         } else {
            var2 = false;
         }

         jx.b(var2, "Content URL must not exceed %d in length.  Provided length was %d.", new Object[]{Integer.valueOf(512), Integer.valueOf(var1.length())});
         this.lh.t(var1);
         return this;
      }

      public PublisherAdRequest.Builder setGender(int var1) {
         this.lh.h(var1);
         return this;
      }

      public PublisherAdRequest.Builder setLocation(Location var1) {
         this.lh.a(var1);
         return this;
      }

      public PublisherAdRequest.Builder setManualImpressionsEnabled(boolean var1) {
         this.lh.i(var1);
         return this;
      }

      public PublisherAdRequest.Builder setPublisherProvidedId(String var1) {
         this.lh.u(var1);
         return this;
      }

      public PublisherAdRequest.Builder tagForChildDirectedTreatment(boolean var1) {
         this.lh.j(var1);
         return this;
      }
   }
}
