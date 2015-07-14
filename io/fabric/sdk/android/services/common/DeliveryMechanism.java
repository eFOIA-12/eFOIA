package io.fabric.sdk.android.services.common;

public enum DeliveryMechanism {
   APP_STORE(4);

   public static final String BETA_APP_PACKAGE_NAME = "io.crash.air";
   DEVELOPER(1),
   TEST_DISTRIBUTION(3),
   USER_SIDELOAD(2);

   private final int id;

   private DeliveryMechanism(int var3) {
      this.id = var3;
   }

   public static DeliveryMechanism determineFrom(String var0) {
      return "io.crash.air".equals(var0)?TEST_DISTRIBUTION:(var0 != null?APP_STORE:DEVELOPER);
   }

   public int getId() {
      return this.id;
   }

   public String toString() {
      return Integer.toString(this.id);
   }
}
