package com.parallel6.ui.utils;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.google.android.gms.maps.model.LatLng;
import com.parallel6.captivereachconnectsdk.models.CRLocation;
import com.parallel6.captivereachconnectsdk.models.CRModel;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import com.parallel6.captivereachconnectsdk.utils.StringUtils;
import com.parallel6.ui.dialogs.OverlayDialog;

public class ActivityUtils {
   public static void callPhoneNumber(Context var0, String var1) {
      if(!StringUtils.isEmpty(var1)) {
         try {
            Intent var2 = new Intent("android.intent.action.CALL");
            var2.setData(Uri.parse("tel:" + var1 + ")"));
            var0.startActivity(var2);
         } catch (Exception var3) {
            Log.d(var0.getClass().getName(), "Call failed: " + var3);
            Toast.makeText(var0, "Incorrect phone number.", 0).show();
         }
      }
   }

   public static void callPhoneNumber(Context var0, String var1, String var2) {
      callPhoneNumber(var0, var1);
   }

   public static void pushActivity(Activity var0, Intent var1) {
      var0.startActivity(var1);
   }

   public static void sendEmail(Context var0, String var1, String var2, String var3, String var4) {
      Intent var5 = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", var1, (String)null));
      var5.putExtra("android.intent.extra.SUBJECT", var2);
      var5.putExtra("android.intent.extra.TEXT", var3);
      var0.startActivity(Intent.createChooser(var5, "Send email..."));
   }

   public static void shareContent(Context var0, String var1, String var2) {
      Intent var3 = new Intent("android.intent.action.SEND");
      var3.setFlags(524288);
      var3.putExtra("android.intent.extra.SUBJECT", var1);
      var3.putExtra("android.intent.extra.TEXT", var2);
      var3.setType("text/plain");
      pushActivity((Activity)var0, var3);
   }

   public static void showDrivingDirections(Context var0, LatLng var1, LatLng var2) {
      var0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://maps.google.com/maps?saddr={$user_lat},{$user_lng}&daddr={$dest_lan},{$dest_lng}&mode=driving".replace("{$user_lat}", String.valueOf(var1.latitude)).replace("{$user_lng}", String.valueOf(var1.longitude)).replace("{$dest_lan}", String.valueOf(var2.latitude)).replace("{$dest_lng}", String.valueOf(var2.longitude)))));
   }

   public static void showDrivingDirections(Context var0, LatLng var1, CRModel var2) {
      String var7;
      if(StringUtils.isNotEmpty(SettingsUtils.getLat(var0)) && StringUtils.isNotEmpty(SettingsUtils.getLng(var0))) {
         double var3 = Double.parseDouble(SettingsUtils.getLat(var0));
         double var5 = Double.parseDouble(SettingsUtils.getLng(var0));
         var7 = "https://maps.google.com/maps?saddr={$user_lat},{$user_lng}&daddr={$dest_lan},{$dest_lng}&mode=driving".replace("{$user_lat}", String.valueOf(var3)).replace("{$user_lng}", String.valueOf(var5)).replace("{$dest_lan}", String.valueOf(var1.latitude)).replace("{$dest_lng}", String.valueOf(var1.longitude));
      } else {
         var7 = "https://maps.google.com/maps?daddr={$dest_lan},{$dest_lng}&mode=driving".replace("{$dest_lan}", String.valueOf(var1.latitude)).replace("{$dest_lng}", String.valueOf(var1.longitude));
      }

      var0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(var7)));
   }

   public static void showDrivingDirections(Context var0, CRLocation var1) {
      String var6;
      if(StringUtils.isNotEmpty(SettingsUtils.getLat(var0)) && StringUtils.isNotEmpty(SettingsUtils.getLng(var0))) {
         double var2 = Double.parseDouble(SettingsUtils.getLat(var0));
         double var4 = Double.parseDouble(SettingsUtils.getLng(var0));
         var6 = "https://maps.google.com/maps?saddr={$user_lat},{$user_lng}&daddr={$dest_lan},{$dest_lng}&mode=driving".replace("{$user_lat}", String.valueOf(var2)).replace("{$user_lng}", String.valueOf(var4)).replace("{$dest_lan}", String.valueOf(var1.getLat())).replace("{$dest_lng}", String.valueOf(var1.getLon()));
      } else {
         var6 = "https://maps.google.com/maps?daddr={$dest_lan},{$dest_lng}&mode=driving".replace("{$dest_lan}", String.valueOf(var1.getLat())).replace("{$dest_lng}", String.valueOf(var1.getLon()));
      }

      var0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(var6)));
   }

   public static void showDrivingDirections(Context var0, String var1) {
      var0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://maps.google.com/maps?q={$address}&mode=driving".replace("{$address}", var1))));
   }

   public static void showHelpOverlay(Context var0, FragmentManager var1, int var2) {
      Bundle var3 = new Bundle();
      var3.putInt("extras_dialog_image", var2);
      ((OverlayDialog)OverlayDialog.instantiate(var0, OverlayDialog.class.getName(), var3)).show(var1, "");
   }
}
