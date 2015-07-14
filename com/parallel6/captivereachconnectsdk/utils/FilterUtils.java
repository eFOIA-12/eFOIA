package com.parallel6.captivereachconnectsdk.utils;

import android.content.Context;
import com.parallel6.captivereachconnectsdk.models.filters.CRLocationRadiusFilter;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import com.parallel6.captivereachconnectsdk.utils.StringUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class FilterUtils {
   public static CRLocationRadiusFilter getLocationFilterWithRadius(Context var0, String var1, double var2) {
      return getLocationFilterWithRadius(var1, SettingsUtils.getLat(var0), SettingsUtils.getLng(var0), var2);
   }

   public static CRLocationRadiusFilter getLocationFilterWithRadius(String var0, String var1, String var2, double var3) {
      boolean var10 = true;
      CRLocationRadiusFilter var11 = new CRLocationRadiusFilter(var0);
      boolean var9;
      if(!StringUtils.isEmpty(var1)) {
         var9 = true;
      } else {
         var9 = false;
      }

      if(StringUtils.isEmpty(var2)) {
         var10 = false;
      }

      if(var9 & var10) {
         double var5 = Double.parseDouble(var1);
         double var7 = Double.parseDouble(var2);
         var11.setOriginLat(var5);
         var11.setOriginLng(var7);
         var11.setRadius(var3);
      }

      return var11;
   }

   public static String getRequestParamsString(HashMap var0) {
      String var2 = "?";
      String var1 = "&";
      Iterator var3 = var0.entrySet().iterator();

      String var4;
      Entry var5;
      for(var4 = var2; var3.hasNext(); var4 = var4 + var5.getKey() + "=" + var5.getValue() + var1) {
         var5 = (Entry)var3.next();
         if(!var3.hasNext()) {
            var1 = "";
         }
      }

      return var4;
   }
}
