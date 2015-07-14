package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.bu;
import com.google.android.gms.internal.bv;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.fn;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public class fp implements fn.a {
   // $FF: synthetic method
   public bv.a a(fn var1, JSONObject var2) throws JSONException, InterruptedException, ExecutionException {
      return this.c(var1, var2);
   }

   public bu c(fn var1, JSONObject var2) throws JSONException, InterruptedException, ExecutionException {
      Future var3 = var1.a(var2, "image", true);
      Future var4 = var1.a(var2, "secondary_image", false);
      return new bu(var2.getString("headline"), (Drawable)var3.get(), var2.getString("body"), (Drawable)var4.get(), var2.getString("call_to_action"), var2.getString("attribution"));
   }
}
