package com.parallel6.captivereachconnectsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.parallel6.captivereachconnectsdk.utils.DeviceUtils;

public class SettingsUtils {
   public static final String AGE = "age";
   private static final String BASE_REST_URL = "base_rest_url";
   private static final String BASE_URL = "base_url";
   public static final String CACHE_ENABLE = "cache_enable";
   public static final String CACHE_RUNNING = "cache_service";
   public static final String DEVICE_ID = "device_id";
   public static final String DEVICE_REGISTER = "device_register";
   public static final String EMAIL = "email";
   public static final String EMPTY_STRING = "";
   public static final String FACEBOOK = "facebook";
   public static final String FIRST_NAME = "first_name";
   private static final String GCM_SENDER_ID = "gcm_sender_id";
   public static final String GENDER = "gender";
   public static final String LAST_NAME = "last_name";
   public static final String LAT = "lat";
   public static final String LNG = "lng";
   public static final String LOCATION_SERVICE = "location_service";
   public static final String LOCATION_SERVICES = "location_services_preference";
   public static final String MEMBER_AGE = "memberAge";
   public static final String MEMBER_CITY = "memberCity";
   public static final String MEMBER_EMAIL = "memberEmail";
   public static final String MEMBER_FIRST_NAME = "memberFirstName";
   public static final String MEMBER_LAST_NAME = "memberLastName";
   public static final String MEMBER_STATE = "memberState";
   public static final String MY_EMPTY_STRING = "PENDING";
   public static final String PRIVACY_ACCEPTED = "privacy_accepted";
   public static final String PROFILE_SET_UP = "profile_set_up";
   public static final String PUSH_ID = "push_id";
   public static final String REGISTRATION_TOKEN = "registration_token";
   public static final String REST_DYNAMIC_MODULE = "dynamic/";
   public static final String TWITTER = "twitter";
   public static final String USERNAME = "username";
   private static final String USE_GOOGLE_PLAY_LOCATION_SERVICE = "use_google_play_location_service_preference";
   public static final String WEB_CACHE_ENABLE = "web_cache_enable";

   public static String getAge(Context var0) {
      return getSafeSetting(var0, "age", "");
   }

   public static String getBaseRestUrl(Context var0) {
      return getSettings(var0).getString("base_rest_url", "");
   }

   public static String getBaseUrl(Context var0) {
      return getSettings(var0).getString("base_url", "");
   }

   public static String getDeviceId(Context var0) {
      String var2 = getSafeSetting(var0, "device_id", (String)null);
      String var1 = var2;
      if(var2 == null) {
         var1 = DeviceUtils.getDeviceId(var0);
         getSettingsEditor(var0).putString("device_id", var1).commit();
      }

      return var1;
   }

   public static String getDeviceInfo(Context var0) {
      return DeviceUtils.getDeviceInfo();
   }

   public static Boolean getDeviceRegister(Context var0) {
      return Boolean.valueOf(getSettings(var0).getBoolean("device_register", false));
   }

   public static String getEmail(Context var0) {
      return getSafeSetting(var0, "email", "");
   }

   public static String getFacebookPreference(Context var0) {
      return getSafeSetting(var0, "facebook", "OFF");
   }

   public static String getFirstname(Context var0) {
      return getSafeSetting(var0, "first_name", "");
   }

   public static String getGcmSenderId(Context var0) {
      return getSettings(var0).getString("gcm_sender_id", "");
   }

   public static String getGender(Context var0) {
      return getSafeSetting(var0, "gender", "");
   }

   public static boolean getIsPreferedGooglePlayLocationServicesPreference(Context var0) {
      return getSettings(var0).getBoolean("use_google_play_location_service_preference", true);
   }

   public static String getLastname(Context var0) {
      return getSafeSetting(var0, "last_name", "");
   }

   public static String getLat(Context var0) {
      return getSafeSetting(var0, "lat", "");
   }

   public static String getLng(Context var0) {
      return getSafeSetting(var0, "lng", "");
   }

   public static boolean getLocationServicesPreference(Context var0) {
      return getSafeSetting(var0, "location_services_preference", true);
   }

   public static Boolean getProfileSetUp(Context var0) {
      return Boolean.valueOf(getSettings(var0).getBoolean("profile_set_up", false));
   }

   public static String getPushId(Context var0) {
      return getSafeSetting(var0, "push_id", "PENDING");
   }

   public static String getRegistrationToken(Context var0) {
      return getSafeSetting(var0, "registration_token", "");
   }

   public static String getSafeSetting(Context var0, String var1, String var2) {
      return getSettings(var0).getString(var1, var2);
   }

   public static boolean getSafeSetting(Context var0, String var1, boolean var2) {
      return getSettings(var0).getBoolean(var1, var2);
   }

   public static SharedPreferences getSettings(Context var0) {
      return PreferenceManager.getDefaultSharedPreferences(var0);
   }

   public static Editor getSettingsEditor(Context var0) {
      return getSettings(var0).edit();
   }

   public static String getTwitterPreference(Context var0) {
      return getSafeSetting(var0, "twitter", "OFF");
   }

   public static String getUsername(Context var0) {
      return getSafeSetting(var0, "username", "");
   }

   public static Boolean isCacheEnabled(Context var0) {
      return Boolean.valueOf(getSettings(var0).getBoolean("cache_enable", false));
   }

   public static Boolean isCacheRunning(Context var0) {
      return Boolean.valueOf(getSettings(var0).getBoolean("cache_service", false));
   }

   public static Boolean isWebCacheEnabled(Context var0) {
      return Boolean.valueOf(getSettings(var0).getBoolean("web_cache_enable", true));
   }

   public static void setAge(Context var0, String var1) {
      getSettingsEditor(var0).putString("age", var1).commit();
   }

   public static void setBaseRestUrl(Context var0, String var1) {
      getSettingsEditor(var0).putString("base_rest_url", var1).commit();
   }

   public static void setBaseUrl(Context var0, String var1) {
      getSettingsEditor(var0).putString("base_url", var1).commit();
   }

   public static void setCacheEnable(Context var0, Boolean var1) {
      getSettingsEditor(var0).putBoolean("cache_enable", var1.booleanValue()).commit();
   }

   public static void setCacheRunning(Context var0, Boolean var1) {
      getSettingsEditor(var0).putBoolean("cache_service", var1.booleanValue()).commit();
   }

   public static void setDeviceRegister(Context var0, Boolean var1) {
      getSettingsEditor(var0).putBoolean("device_register", var1.booleanValue()).commit();
   }

   public static void setEmail(Context var0, String var1) {
      getSettingsEditor(var0).putString("email", var1).commit();
   }

   public static void setFacebookPreference(Context var0, String var1) {
      getSettingsEditor(var0).putString("facebook", var1).commit();
   }

   public static void setFirstName(Context var0, String var1) {
      getSettingsEditor(var0).putString("first_name", var1).commit();
   }

   public static void setGcmSenderId(Context var0, String var1) {
      getSettingsEditor(var0).putString("gcm_sender_id", var1).commit();
   }

   public static void setGender(Context var0, String var1) {
      getSettingsEditor(var0).putString("gender", var1).commit();
   }

   public static void setLastName(Context var0, String var1) {
      getSettingsEditor(var0).putString("last_name", var1).commit();
   }

   public static void setLat(Context var0, double var1) {
      getSettingsEditor(var0).putString("lat", String.valueOf(var1)).commit();
   }

   public static void setLng(Context var0, double var1) {
      getSettingsEditor(var0).putString("lng", String.valueOf(var1)).commit();
   }

   public static void setPreferedGooglePlayLocationServicesPreference(Context var0, String var1) {
      getSettingsEditor(var0).putString("use_google_play_location_service_preference", var1).commit();
   }

   public static void setProfileSetUp(Context var0, Boolean var1) {
      getSettingsEditor(var0).putBoolean("profile_set_up", var1.booleanValue()).commit();
   }

   public static void setPushId(Context var0, String var1) {
      getSettingsEditor(var0).putString("push_id", var1).commit();
   }

   public static void setRegistrationToken(Context var0, String var1) {
      getSettingsEditor(var0).putString("registration_token", var1).commit();
   }

   public static void setTwitterPreference(Context var0, String var1) {
      getSettingsEditor(var0).putString("twitter", var1).commit();
   }

   public static void setUsername(Context var0, String var1) {
      getSettingsEditor(var0).putString("username", var1).commit();
   }

   public static void setWebCacheEnable(Context var0, Boolean var1) {
      getSettingsEditor(var0).putBoolean("web_cache_enable", var1.booleanValue()).commit();
   }

   public static void setlocationServicesPreference(Context var0, String var1) {
      getSettingsEditor(var0).putString("location_services_preference", var1).commit();
   }

   public static void setlocationServicesPreference(Context var0, boolean var1) {
      getSettingsEditor(var0).putBoolean("location_services_preference", var1).commit();
   }
}
