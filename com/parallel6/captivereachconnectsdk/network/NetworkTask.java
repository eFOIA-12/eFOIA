package com.parallel6.captivereachconnectsdk.network;

public enum NetworkTask {
   ADVERTISEMENTS_GET("advertisements"),
   ANNOUNCEMENTS_GET("announcements"),
   DEVICE_REGISTRATION("devices/registration"),
   DEVICE_TOKEN("devices/token"),
   DEVICE_UPDATE("devices"),
   EVENTS_GET("events"),
   HOTELS_GET("hotels"),
   MOBILE_MENUS_GET("v2/mobile_menus"),
   MOBILE_USER_TOKEN("mobile_users/sign_in_guest"),
   OFFERS_GET("offers"),
   PROMOTIONS_GET("promotions"),
   REWARDS_GET("rewards"),
   TARGET_POST("vuforia_targets");

   String path;

   private NetworkTask(String var3) {
      this.path = var3;
   }

   public String getPath() {
      return this.path;
   }
}
