package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.internal.eb;
import com.google.android.gms.internal.ef;
import com.google.android.gms.internal.eg;
import com.google.android.gms.internal.eh;
import com.google.android.gms.internal.ei;
import com.google.android.gms.internal.ek;
import com.google.android.gms.internal.er;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gf;
import com.google.android.gms.internal.gq;
import com.google.android.gms.internal.gr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@ey
public class ec extends gf implements ServiceConnection {
   private Context mContext;
   private final Object mH = new Object();
   private boolean sD = false;
   private er sE;
   private eb sF;
   private eh sG;
   private List sH = null;
   private ek sI;

   public ec(Context var1, er var2, ek var3) {
      this.mContext = var1;
      this.sE = var2;
      this.sI = var3;
      this.sF = new eb(var1);
      this.sG = eh.j(this.mContext);
      this.sH = this.sG.d(10L);
   }

   private void a(final ef var1, String var2, String var3) {
      final Intent var4 = new Intent();
      var4.putExtra("RESPONSE_CODE", 0);
      var4.putExtra("INAPP_PURCHASE_DATA", var2);
      var4.putExtra("INAPP_DATA_SIGNATURE", var3);
      gq.wR.post(new Runnable() {
         public void run() {
            try {
               if(ec.this.sI.a(var1.sU, -1, var4)) {
                  ec.this.sE.a(new eg(ec.this.mContext, var1.sV, true, -1, var4, var1));
               } else {
                  ec.this.sE.a(new eg(ec.this.mContext, var1.sV, false, -1, var4, var1));
               }
            } catch (RemoteException var2) {
               gr.W("Fail to verify and dispatch pending transaction");
            }
         }
      });
   }

   private void b(long var1) {
      do {
         if(!this.c(var1)) {
            gr.W("Timeout waiting for pending transaction to be processed.");
         }
      } while(!this.sD);

   }

   private boolean c(long var1) {
      var1 = 60000L - (SystemClock.elapsedRealtime() - var1);
      if(var1 <= 0L) {
         return false;
      } else {
         try {
            this.mH.wait(var1);
         } catch (InterruptedException var4) {
            gr.W("waitWithTimeout_lock interrupted");
         }

         return true;
      }
   }

   private void cy() {
      if(!this.sH.isEmpty()) {
         HashMap var3 = new HashMap();
         Iterator var2 = this.sH.iterator();

         while(var2.hasNext()) {
            ef var4 = (ef)var2.next();
            var3.put(var4.sV, var4);
         }

         String var12 = null;

         do {
            Bundle var13 = this.sF.d(this.mContext.getPackageName(), var12);
            if(var13 == null || ei.b(var13) != 0) {
               break;
            }

            ArrayList var14 = var13.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
            ArrayList var5 = var13.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
            ArrayList var6 = var13.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
            var12 = var13.getString("INAPP_CONTINUATION_TOKEN");

            for(int var1 = 0; var1 < var14.size(); ++var1) {
               if(var3.containsKey(var14.get(var1))) {
                  String var7 = (String)var14.get(var1);
                  String var8 = (String)var5.get(var1);
                  String var9 = (String)var6.get(var1);
                  ef var10 = (ef)var3.get(var7);
                  String var11 = ei.D(var8);
                  if(var10.sU.equals(var11)) {
                     this.a(var10, var8, var9);
                     var3.remove(var7);
                  }
               }
            }
         } while(var12 != null && !var3.isEmpty());

         var2 = var3.keySet().iterator();

         while(var2.hasNext()) {
            String var15 = (String)var2.next();
            this.sG.a((ef)var3.get(var15));
         }
      }

   }

   public void cx() {
      // $FF: Couldn't be decompiled
   }

   public void onServiceConnected(ComponentName param1, IBinder param2) {
      // $FF: Couldn't be decompiled
   }

   public void onServiceDisconnected(ComponentName var1) {
      gr.U("In-app billing service disconnected.");
      this.sF.destroy();
   }

   public void onStop() {
      // $FF: Couldn't be decompiled
   }
}
