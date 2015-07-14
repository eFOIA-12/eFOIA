package com.parallel6.ui.utils;

import android.content.Context;
import com.parallel6.captivereachconnectsdk.models.login.Profile;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import com.parallel6.captivereachconnectsdk.utils.StringUtils;
import java.util.regex.Pattern;

public class ProfileUtils extends SettingsUtils {
   public static final String US_ZIP_CODE_FORMAT = "^\\d{5}(-\\d{4})?$";

   public static String getAttribute(Context var0, String var1) {
      return getSafeSetting(var0, var1, "");
   }

   public static Profile getProfile(Context var0) {
      Profile var2 = new Profile();
      var2.setUsername(SettingsUtils.getUsername(var0));
      var2.setFirst_name(SettingsUtils.getFirstname(var0));
      var2.setLast_name(SettingsUtils.getLastname(var0));
      var2.setEmail(SettingsUtils.getEmail(var0));
      var2.setGender(SettingsUtils.getGender(var0));

      int var1;
      try {
         var1 = Integer.valueOf(SettingsUtils.getAge(var0)).intValue();
      } catch (Exception var3) {
         var3.printStackTrace();
         var1 = 0;
      }

      var2.setAge(Integer.valueOf(var1));
      return var2;
   }

   public static boolean matchFields(String var0, String var1) {
      return var0.equals(var1);
   }

   public static void setAttribute(Context var0, String var1, String var2) {
      getSettingsEditor(var0).putString(var1, var2).commit();
   }

   public static void setProfile(Context var0, Profile var1) {
      if(StringUtils.isNotEmpty(var1.getUsername())) {
         SettingsUtils.setUsername(var0, var1.getUsername());
      }

      if(StringUtils.isNotEmpty(var1.getFirst_name())) {
         SettingsUtils.setFirstName(var0, var1.getFirst_name());
      }

      if(StringUtils.isNotEmpty(var1.getLast_name())) {
         SettingsUtils.setLastName(var0, var1.getLast_name());
      }

      if(StringUtils.isNotEmpty(var1.getEmail())) {
         SettingsUtils.setEmail(var0, var1.getEmail());
      }

      if(StringUtils.isNotEmpty(var1.getGender())) {
         SettingsUtils.setGender(var0, var1.getGender());
      }

      SettingsUtils.setAge(var0, String.valueOf(var1.getAge()));
   }

   public static boolean validAge(int var0, int var1, int var2) {
      boolean var3 = true;
      boolean var5;
      if(var0 >= var1) {
         var5 = true;
      } else {
         var5 = false;
      }

      boolean var4;
      if(var0 <= var2) {
         var4 = var3;
      } else {
         var4 = false;
      }

      return var4 & var5;
   }

   public static boolean validEmail(String var0) {
      return Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$").matcher(var0).matches();
   }

   public static boolean validZipCode(String var0) {
      return Pattern.matches("^\\d{5}(-\\d{4})?$", var0);
   }
}
