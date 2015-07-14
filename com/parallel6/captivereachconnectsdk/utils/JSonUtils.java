package com.parallel6.captivereachconnectsdk.utils;

import com.google.gson.Gson;
import com.parallel6.captivereachconnectsdk.utils.EncodingHelper;
import java.lang.reflect.Type;
import org.json.JSONException;
import org.json.JSONObject;

public class JSonUtils {
   public static String getCRJsonString(String var0) {
      EncodingHelper.encodeFromTo(var0, "ISO-8859-1", "UTF-8");

      try {
         String var1 = (new JSONObject(var0)).getJSONObject("json").toString();
         return var1;
      } catch (JSONException var2) {
         return var0;
      }
   }

   public static String getJSonString(Object var0, Type var1) {
      return (new Gson()).toJson(var0, var1).toString();
   }
}
