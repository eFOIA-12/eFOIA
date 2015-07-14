package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.cd;
import com.google.android.gms.internal.cj;
import com.google.android.gms.internal.dp;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gp;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.gu;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public final class cc {
   public static final cd pQ = new cd() {
      public void a(gu var1, Map var2) {
      }
   };
   public static final cd pR = new cd() {
      public void a(gu var1, Map var2) {
         String var11 = (String)var2.get("urls");
         if(TextUtils.isEmpty(var11)) {
            gr.W("URLs missing in canOpenURLs GMSG.");
         } else {
            String[] var6 = var11.split(",");
            HashMap var7 = new HashMap();
            PackageManager var8 = var1.getContext().getPackageManager();
            int var4 = var6.length;

            for(int var3 = 0; var3 < var4; ++var3) {
               String var9 = var6[var3];
               String[] var12 = var9.split(";", 2);
               String var10 = var12[0].trim();
               if(var12.length > 1) {
                  var11 = var12[1].trim();
               } else {
                  var11 = "android.intent.action.VIEW";
               }

               boolean var5;
               if(var8.resolveActivity(new Intent(var11, Uri.parse(var10)), 65536) != null) {
                  var5 = true;
               } else {
                  var5 = false;
               }

               var7.put(var9, Boolean.valueOf(var5));
            }

            var1.a((String)"openableURLs", (Map)var7);
         }
      }
   };
   public static final cd pS = new cd() {
      public void a(gu var1, Map var2) {
         PackageManager var5 = var1.getContext().getPackageManager();
         String var18 = (String)var2.get("data");

         JSONObject var19;
         try {
            var19 = new JSONObject(var18);
         } catch (JSONException var16) {
            var1.b("openableIntents", new JSONObject());
            return;
         }

         JSONArray var20;
         try {
            var20 = var19.getJSONArray("intents");
         } catch (JSONException var15) {
            var1.b("openableIntents", new JSONObject());
            return;
         }

         JSONObject var6 = new JSONObject();

         for(int var3 = 0; var3 < var20.length(); ++var3) {
            JSONObject var13;
            try {
               var13 = var20.getJSONObject(var3);
            } catch (JSONException var17) {
               gr.b("Error parsing the intent data.", var17);
               continue;
            }

            String var7 = var13.optString("id");
            String var8 = var13.optString("u");
            String var9 = var13.optString("i");
            String var10 = var13.optString("m");
            String var11 = var13.optString("p");
            String var12 = var13.optString("c");
            var13.optString("f");
            var13.optString("e");
            Intent var22 = new Intent();
            if(!TextUtils.isEmpty(var8)) {
               var22.setData(Uri.parse(var8));
            }

            if(!TextUtils.isEmpty(var9)) {
               var22.setAction(var9);
            }

            if(!TextUtils.isEmpty(var10)) {
               var22.setType(var10);
            }

            if(!TextUtils.isEmpty(var11)) {
               var22.setPackage(var11);
            }

            if(!TextUtils.isEmpty(var12)) {
               String[] var21 = var12.split("/", 2);
               if(var21.length == 2) {
                  var22.setComponent(new ComponentName(var21[0], var21[1]));
               }
            }

            boolean var4;
            if(var5.resolveActivity(var22, 65536) != null) {
               var4 = true;
            } else {
               var4 = false;
            }

            try {
               var6.put(var7, var4);
            } catch (JSONException var14) {
               gr.b("Error constructing openable urls response.", var14);
            }
         }

         var1.b("openableIntents", var6);
      }
   };
   public static final cd pT = new cd() {
      public void a(gu param1, Map param2) {
         // $FF: Couldn't be decompiled
      }
   };
   public static final cd pU = new cd() {
      public void a(gu var1, Map var2) {
         dp var3 = var1.dC();
         if(var3 == null) {
            gr.W("A GMSG tried to close something that wasn\'t an overlay.");
         } else {
            var3.close();
         }
      }
   };
   public static final cd pV = new cd() {
      public void a(gu var1, Map var2) {
         var1.q("1".equals(var2.get("custom_close")));
      }
   };
   public static final cd pW = new cd() {
      public void a(gu var1, Map var2) {
         String var3 = (String)var2.get("u");
         if(var3 == null) {
            gr.W("URL missing from httpTrack GMSG.");
         } else {
            (new gp(var1.getContext(), var1.dG().wS, var3)).start();
         }
      }
   };
   public static final cd pX = new cd() {
      public void a(gu var1, Map var2) {
         gr.U("Received log message: " + (String)var2.get("string"));
      }
   };
   public static final cd pY = new cd() {
      public void a(gu param1, Map param2) {
         // $FF: Couldn't be decompiled
      }
   };
   public static final cd pZ = new cj();
}
