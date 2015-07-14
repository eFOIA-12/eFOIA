package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gr;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public final class ei {
   public static String D(String var0) {
      if(var0 == null) {
         return null;
      } else {
         try {
            var0 = (new JSONObject(var0)).getString("developerPayload");
            return var0;
         } catch (JSONException var1) {
            gr.W("Fail to parse purchase data");
            return null;
         }
      }
   }

   public static String E(String var0) {
      if(var0 == null) {
         return null;
      } else {
         try {
            var0 = (new JSONObject(var0)).getString("purchaseToken");
            return var0;
         } catch (JSONException var1) {
            gr.W("Fail to parse purchase data");
            return null;
         }
      }
   }

   public static int b(Bundle var0) {
      Object var1 = var0.get("RESPONSE_CODE");
      if(var1 == null) {
         gr.W("Bundle with null response code, assuming OK (known issue)");
         return 0;
      } else if(var1 instanceof Integer) {
         return ((Integer)var1).intValue();
      } else if(var1 instanceof Long) {
         return (int)((Long)var1).longValue();
      } else {
         gr.W("Unexpected type for intent response code. " + var1.getClass().getName());
         return 5;
      }
   }

   public static int d(Intent var0) {
      Object var1 = var0.getExtras().get("RESPONSE_CODE");
      if(var1 == null) {
         gr.W("Intent with no response code, assuming OK (known issue)");
         return 0;
      } else if(var1 instanceof Integer) {
         return ((Integer)var1).intValue();
      } else if(var1 instanceof Long) {
         return (int)((Long)var1).longValue();
      } else {
         gr.W("Unexpected type for intent response code. " + var1.getClass().getName());
         return 5;
      }
   }

   public static String e(Intent var0) {
      return var0 == null?null:var0.getStringExtra("INAPP_PURCHASE_DATA");
   }

   public static String f(Intent var0) {
      return var0 == null?null:var0.getStringExtra("INAPP_DATA_SIGNATURE");
   }
}
