package io.fabric.sdk.android.services.common;

import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.common.AdvertisingInfo;
import io.fabric.sdk.android.services.common.AdvertisingInfoStrategy;

class AdvertisingInfoReflectionStrategy implements AdvertisingInfoStrategy {
   private static final String CLASS_NAME_ADVERTISING_ID_CLIENT = "com.google.android.gms.ads.identifier.AdvertisingIdClient";
   private static final String CLASS_NAME_ADVERTISING_ID_CLIENT_INFO = "com.google.android.gms.ads.identifier.AdvertisingIdClient$Info";
   private static final String CLASS_NAME_GOOGLE_PLAY_SERVICES_UTILS = "com.google.android.gms.common.GooglePlayServicesUtil";
   private static final int GOOGLE_PLAY_SERVICES_SUCCESS_CODE = 0;
   private static final String METHOD_NAME_GET_ADVERTISING_ID_INFO = "getAdvertisingIdInfo";
   private static final String METHOD_NAME_GET_ID = "getId";
   private static final String METHOD_NAME_IS_GOOGLE_PLAY_SERVICES_AVAILABLE = "isGooglePlayServicesAvailable";
   private static final String METHOD_NAME_IS_LIMITED_AD_TRACKING_ENABLED = "isLimitAdTrackingEnabled";
   private final Context context;

   public AdvertisingInfoReflectionStrategy(Context var1) {
      this.context = var1.getApplicationContext();
   }

   private String getAdvertisingId() {
      try {
         String var1 = (String)Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("getId", new Class[0]).invoke(this.getInfo(), new Object[0]);
         return var1;
      } catch (Exception var2) {
         Fabric.getLogger().w("Fabric", "Could not call getId on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
         return null;
      }
   }

   private Object getInfo() {
      try {
         Object var1 = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke((Object)null, new Object[]{this.context});
         return var1;
      } catch (Exception var2) {
         Fabric.getLogger().w("Fabric", "Could not call getAdvertisingIdInfo on com.google.android.gms.ads.identifier.AdvertisingIdClient");
         return null;
      }
   }

   private boolean isLimitAdTrackingEnabled() {
      try {
         boolean var1 = ((Boolean)Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(this.getInfo(), new Object[0])).booleanValue();
         return var1;
      } catch (Exception var3) {
         Fabric.getLogger().w("Fabric", "Could not call isLimitAdTrackingEnabled on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
         return false;
      }
   }

   public AdvertisingInfo getAdvertisingInfo() {
      return this.isGooglePlayServiceAvailable(this.context)?new AdvertisingInfo(this.getAdvertisingId(), this.isLimitAdTrackingEnabled()):null;
   }

   boolean isGooglePlayServiceAvailable(Context var1) {
      int var2;
      try {
         var2 = ((Integer)Class.forName("com.google.android.gms.common.GooglePlayServicesUtil").getMethod("isGooglePlayServicesAvailable", new Class[]{Context.class}).invoke((Object)null, new Object[]{var1})).intValue();
      } catch (Exception var3) {
         return false;
      }

      return var2 == 0;
   }
}
