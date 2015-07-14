package io.fabric.sdk.android.services.common;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import io.fabric.sdk.android.services.concurrency.PriorityRunnable;

public class SafeToast extends Toast {
   public SafeToast(Context var1) {
      super(var1);
   }

   public static Toast makeText(Context var0, int var1, int var2) throws NotFoundException {
      return makeText(var0, var0.getResources().getText(var1), var2);
   }

   public static Toast makeText(Context var0, CharSequence var1, int var2) {
      Toast var4 = Toast.makeText(var0, var1, var2);
      SafeToast var3 = new SafeToast(var0);
      var3.setView(var4.getView());
      var3.setDuration(var4.getDuration());
      return var3;
   }

   public void show() {
      if(Looper.myLooper() == Looper.getMainLooper()) {
         super.show();
      } else {
         (new Handler(Looper.getMainLooper())).post(new PriorityRunnable() {
            public void run() {
               SafeToast.super.show();
            }
         });
      }
   }
}
