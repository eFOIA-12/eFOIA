package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.ah;
import com.google.android.gms.internal.aj;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gj;
import com.google.android.gms.internal.gq;
import com.google.android.gms.internal.gs;
import java.util.concurrent.Future;

@ey
public class ai {
   protected ah a(Context var1, gs var2, final gj var3) {
      final aj var4 = new aj(var1, var2);
      var4.a(new ah.a() {
         public void aR() {
            var3.a(var4);
         }
      });
      return var4;
   }

   public Future a(final Context var1, final gs var2, final String var3) {
      final gj var4 = new gj();
      gq.wR.post(new Runnable() {
         public void run() {
            ai.this.a(var1, var2, var4).f(var3);
         }
      });
      return var4;
   }
}
