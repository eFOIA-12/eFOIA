package io.fabric.sdk.android.services.settings;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.common.CommonUtils;

public class IconRequest {
   public final String hash;
   public final int height;
   public final int iconResourceId;
   public final int width;

   public IconRequest(String var1, int var2, int var3, int var4) {
      this.hash = var1;
      this.iconResourceId = var2;
      this.width = var3;
      this.height = var4;
   }

   public static IconRequest build(Context var0, String var1) {
      IconRequest var3 = null;
      if(var1 != null) {
         try {
            int var2 = CommonUtils.getAppIconResourceId(var0);
            Fabric.getLogger().d("Fabric", "App icon resource ID is " + var2);
            Options var5 = new Options();
            var5.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(var0.getResources(), var2, var5);
            var3 = new IconRequest(var1, var2, var5.outWidth, var5.outHeight);
         } catch (Exception var4) {
            Fabric.getLogger().e("Fabric", "Failed to load icon", var4);
            return null;
         }
      }

      return var3;
   }
}
