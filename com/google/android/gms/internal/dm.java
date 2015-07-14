package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.do;
import com.google.android.gms.internal.dv;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gr;

@ey
public final class dm {
   public static boolean a(Context var0, do var1, dv var2) {
      if(var1 == null) {
         gr.W("No intent data for launcher overlay.");
         return false;
      } else {
         Intent var3 = new Intent();
         if(TextUtils.isEmpty(var1.rH)) {
            gr.W("Open GMSG did not contain a URL.");
            return false;
         } else {
            if(!TextUtils.isEmpty(var1.mimeType)) {
               var3.setDataAndType(Uri.parse(var1.rH), var1.mimeType);
            } else {
               var3.setData(Uri.parse(var1.rH));
            }

            var3.setAction("android.intent.action.VIEW");
            if(!TextUtils.isEmpty(var1.packageName)) {
               var3.setPackage(var1.packageName);
            }

            if(!TextUtils.isEmpty(var1.rI)) {
               String[] var4 = var1.rI.split("/", 2);
               if(var4.length < 2) {
                  gr.W("Could not parse component name from open GMSG: " + var1.rI);
                  return false;
               }

               var3.setClassName(var4[0], var4[1]);
            }

            try {
               gr.V("Launching an intent: " + var3);
               var0.startActivity(var3);
               var2.af();
               return true;
            } catch (ActivityNotFoundException var5) {
               gr.W(var5.getMessage());
               return false;
            }
         }
      }
   }
}
