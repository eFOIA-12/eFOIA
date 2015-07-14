package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.bt;
import com.google.android.gms.internal.bv;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.fn;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public class fo implements fn.a {
   // $FF: synthetic method
   public bv.a a(fn var1, JSONObject var2) throws JSONException, InterruptedException, ExecutionException {
      return this.b(var1, var2);
   }

   public bt b(fn var1, JSONObject var2) throws JSONException, InterruptedException, ExecutionException {
      Future var3 = var1.a(var2, "image", true);
      Future var4 = var1.a(var2, "app_icon", true);
      return new bt(var2.getString("headline"), (Drawable)var3.get(), var2.getString("body"), (Drawable)var4.get(), var2.getString("call_to_action"), var2.optDouble("rating", -1.0D), var2.optString("store"), var2.optString("price"));
   }
}
