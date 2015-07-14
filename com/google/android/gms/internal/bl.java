package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Build.VERSION;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.jx;

@ey
public class bl {
   private final Context mContext;

   public bl(Context var1) {
      jx.b((Object)var1, "Context can not be null");
      this.mContext = var1;
   }

   public static boolean bs() {
      return "mounted".equals(Environment.getExternalStorageState());
   }

   public boolean a(Intent var1) {
      boolean var2 = false;
      jx.b((Object)var1, "Intent can not be null");
      if(!this.mContext.getPackageManager().queryIntentActivities(var1, 0).isEmpty()) {
         var2 = true;
      }

      return var2;
   }

   public boolean bo() {
      Intent var1 = new Intent("android.intent.action.DIAL");
      var1.setData(Uri.parse("tel:"));
      return this.a(var1);
   }

   public boolean bp() {
      Intent var1 = new Intent("android.intent.action.VIEW");
      var1.setData(Uri.parse("sms:"));
      return this.a(var1);
   }

   public boolean bq() {
      return bs() && this.mContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
   }

   public boolean br() {
      return false;
   }

   public boolean bt() {
      Intent var1 = (new Intent("android.intent.action.INSERT")).setType("vnd.android.cursor.dir/event");
      return VERSION.SDK_INT >= 14 && this.a(var1);
   }
}
