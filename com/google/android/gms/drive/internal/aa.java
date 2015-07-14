package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.CompletionListener;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.internal.OnEventResponse;
import com.google.android.gms.drive.internal.ag;
import com.google.android.gms.drive.internal.w;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.List;

public class aa extends ag.a {
   private final int Pm;
   private final com.google.android.gms.drive.events.c Qw;
   private final aa.a Qx;
   private final List Qy = new ArrayList();

   public aa(Looper var1, Context var2, int var3, com.google.android.gms.drive.events.c var4) {
      this.Pm = var3;
      this.Qw = var4;
      this.Qx = new aa.a(var1, var2, null);
   }

   public void bw(int var1) {
      this.Qy.add(Integer.valueOf(var1));
   }

   public boolean bx(int var1) {
      return this.Qy.contains(Integer.valueOf(var1));
   }

   public void c(OnEventResponse var1) throws RemoteException {
      DriveEvent var3 = var1.iQ();
      boolean var2;
      if(this.Pm == var3.getType()) {
         var2 = true;
      } else {
         var2 = false;
      }

      jx.K(var2);
      jx.K(this.Qy.contains(Integer.valueOf(var3.getType())));
      this.Qx.a(this.Qw, var3);
   }

   private static class a extends Handler {
      private final Context mContext;

      private a(Looper var1, Context var2) {
         super(var1);
         this.mContext = var2;
      }

      // $FF: synthetic method
      a(Looper var1, Context var2, Object var3) {
         this(var1, var2);
      }

      public void a(com.google.android.gms.drive.events.c var1, DriveEvent var2) {
         this.sendMessage(this.obtainMessage(1, new Pair(var1, var2)));
      }

      public void handleMessage(Message var1) {
         switch(var1.what) {
         case 1:
            Pair var2 = (Pair)var1.obj;
            com.google.android.gms.drive.events.c var3 = (com.google.android.gms.drive.events.c)var2.first;
            DriveEvent var4 = (DriveEvent)var2.second;
            switch(var4.getType()) {
            case 1:
               ((ChangeListener)var3).onChange((ChangeEvent)var4);
               return;
            case 2:
               ((CompletionListener)var3).onCompletion((CompletionEvent)var4);
               return;
            default:
               w.o("EventCallback", "Unexpected event: " + var4);
               return;
            }
         default:
            w.e(this.mContext, "EventCallback", "Don\'t know how to handle this event");
         }
      }
   }
}
