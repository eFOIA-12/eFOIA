package com.google.android.gms.games.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.GamesLog;
import com.google.android.gms.internal.ll;
import java.lang.ref.WeakReference;

public class PopupManager {
   protected GamesClientImpl ZQ;
   protected PopupManager.PopupLocationInfo ZR;

   private PopupManager(GamesClientImpl var1, int var2) {
      this.ZQ = var1;
      this.dY(var2);
   }

   // $FF: synthetic method
   PopupManager(GamesClientImpl var1, int var2, Object var3) {
      this(var1, var2);
   }

   public static PopupManager a(GamesClientImpl var0, int var1) {
      return (PopupManager)(ll.ih()?new PopupManager.PopupManagerHCMR1(var0, var1):new PopupManager(var0, var1));
   }

   protected void dY(int var1) {
      this.ZR = new PopupManager.PopupLocationInfo(var1, new Binder(), null);
   }

   public void l(View var1) {
   }

   public void lT() {
      this.ZQ.a(this.ZR.ZS, this.ZR.lW());
   }

   public Bundle lU() {
      return this.ZR.lW();
   }

   public IBinder lV() {
      return this.ZR.ZS;
   }

   public void setGravity(int var1) {
      this.ZR.gravity = var1;
   }

   public static final class PopupLocationInfo {
      public IBinder ZS;
      public int ZT;
      public int bottom;
      public int gravity;
      public int left;
      public int right;
      public int top;

      private PopupLocationInfo(int var1, IBinder var2) {
         this.ZT = -1;
         this.left = 0;
         this.top = 0;
         this.right = 0;
         this.bottom = 0;
         this.gravity = var1;
         this.ZS = var2;
      }

      // $FF: synthetic method
      PopupLocationInfo(int var1, IBinder var2, Object var3) {
         this(var1, var2);
      }

      public Bundle lW() {
         Bundle var1 = new Bundle();
         var1.putInt("popupLocationInfo.gravity", this.gravity);
         var1.putInt("popupLocationInfo.displayId", this.ZT);
         var1.putInt("popupLocationInfo.left", this.left);
         var1.putInt("popupLocationInfo.top", this.top);
         var1.putInt("popupLocationInfo.right", this.right);
         var1.putInt("popupLocationInfo.bottom", this.bottom);
         return var1;
      }
   }

   private static final class PopupManagerHCMR1 extends PopupManager implements OnAttachStateChangeListener, OnGlobalLayoutListener {
      private boolean Yq = false;
      private WeakReference ZU;

      protected PopupManagerHCMR1(GamesClientImpl var1, int var2) {
         super(var1, var2, null);
      }

      private void m(View var1) {
         byte var3 = -1;
         int var2 = var3;
         if(ll.il()) {
            Display var5 = var1.getDisplay();
            var2 = var3;
            if(var5 != null) {
               var2 = var5.getDisplayId();
            }
         }

         IBinder var8 = var1.getWindowToken();
         int[] var6 = new int[2];
         var1.getLocationInWindow(var6);
         int var7 = var1.getWidth();
         int var4 = var1.getHeight();
         this.ZR.ZT = var2;
         this.ZR.ZS = var8;
         this.ZR.left = var6[0];
         this.ZR.top = var6[1];
         this.ZR.right = var6[0] + var7;
         this.ZR.bottom = var6[1] + var4;
         if(this.Yq) {
            this.lT();
            this.Yq = false;
         }

      }

      protected void dY(int var1) {
         this.ZR = new PopupManager.PopupLocationInfo(var1, (IBinder)null, null);
      }

      public void l(View var1) {
         this.ZQ.lE();
         View var2;
         if(this.ZU != null) {
            View var3 = (View)this.ZU.get();
            Context var4 = this.ZQ.getContext();
            var2 = var3;
            if(var3 == null) {
               var2 = var3;
               if(var4 instanceof Activity) {
                  var2 = ((Activity)var4).getWindow().getDecorView();
               }
            }

            if(var2 != null) {
               var2.removeOnAttachStateChangeListener(this);
               ViewTreeObserver var6 = var2.getViewTreeObserver();
               if(ll.ik()) {
                  var6.removeOnGlobalLayoutListener(this);
               } else {
                  var6.removeGlobalOnLayoutListener(this);
               }
            }
         }

         this.ZU = null;
         Context var5 = this.ZQ.getContext();
         var2 = var1;
         if(var1 == null) {
            var2 = var1;
            if(var5 instanceof Activity) {
               var2 = ((Activity)var5).findViewById(16908290);
               var1 = var2;
               if(var2 == null) {
                  var1 = ((Activity)var5).getWindow().getDecorView();
               }

               GamesLog.o("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view which may not work properly in future versions of the API. Use setViewForPopups() to set your content view.");
               var2 = var1;
            }
         }

         if(var2 != null) {
            this.m(var2);
            this.ZU = new WeakReference(var2);
            var2.addOnAttachStateChangeListener(this);
            var2.getViewTreeObserver().addOnGlobalLayoutListener(this);
         } else {
            GamesLog.p("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client\'s calls. Use setViewForPopups() to set your content view.");
         }
      }

      public void lT() {
         if(this.ZR.ZS != null) {
            super.lT();
         } else {
            boolean var1;
            if(this.ZU != null) {
               var1 = true;
            } else {
               var1 = false;
            }

            this.Yq = var1;
         }
      }

      public void onGlobalLayout() {
         if(this.ZU != null) {
            View var1 = (View)this.ZU.get();
            if(var1 != null) {
               this.m(var1);
               return;
            }
         }

      }

      public void onViewAttachedToWindow(View var1) {
         this.m(var1);
      }

      public void onViewDetachedFromWindow(View var1) {
         this.ZQ.lE();
         var1.removeOnAttachStateChangeListener(this);
      }
   }
}
