package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.f;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class a {
   private LifecycleDelegate Tu;
   private Bundle Tv;
   private LinkedList Tw;
   private final f Tx = new f() {
      public void a(LifecycleDelegate var1) {
         a.this.Tu = var1;
         Iterator var2 = a.this.Tw.iterator();

         while(var2.hasNext()) {
            ((a.a)var2.next()).b(a.this.Tu);
         }

         a.this.Tw.clear();
         a.this.Tv = null;
      }
   };

   private void a(Bundle var1, a.a var2) {
      if(this.Tu != null) {
         var2.b(this.Tu);
      } else {
         if(this.Tw == null) {
            this.Tw = new LinkedList();
         }

         this.Tw.add(var2);
         if(var1 != null) {
            if(this.Tv == null) {
               this.Tv = (Bundle)var1.clone();
            } else {
               this.Tv.putAll(var1);
            }
         }

         this.a(this.Tx);
      }
   }

   public static void b(FrameLayout var0) {
      final Context var2 = var0.getContext();
      final int var1 = GooglePlayServicesUtil.isGooglePlayServicesAvailable(var2);
      String var5 = GooglePlayServicesUtil.b(var2, var1);
      String var3 = GooglePlayServicesUtil.c(var2, var1);
      LinearLayout var4 = new LinearLayout(var0.getContext());
      var4.setOrientation(1);
      var4.setLayoutParams(new LayoutParams(-2, -2));
      var0.addView(var4);
      TextView var6 = new TextView(var0.getContext());
      var6.setLayoutParams(new LayoutParams(-2, -2));
      var6.setText(var5);
      var4.addView(var6);
      if(var3 != null) {
         Button var7 = new Button(var2);
         var7.setLayoutParams(new LayoutParams(-2, -2));
         var7.setText(var3);
         var4.addView(var7);
         var7.setOnClickListener(new OnClickListener() {
            public void onClick(View var1x) {
               var2.startActivity(GooglePlayServicesUtil.aj(var1));
            }
         });
      }

   }

   private void cG(int var1) {
      while(!this.Tw.isEmpty() && ((a.a)this.Tw.getLast()).getState() >= var1) {
         this.Tw.removeLast();
      }

   }

   protected void a(FrameLayout var1) {
      b(var1);
   }

   protected abstract void a(f var1);

   public LifecycleDelegate je() {
      return this.Tu;
   }

   public void onCreate(final Bundle var1) {
      this.a(var1, new a.a() {
         public void b(LifecycleDelegate var1x) {
            a.this.Tu.onCreate(var1);
         }

         public int getState() {
            return 1;
         }
      });
   }

   public View onCreateView(final LayoutInflater var1, final ViewGroup var2, final Bundle var3) {
      final FrameLayout var4 = new FrameLayout(var1.getContext());
      this.a(var3, new a.a() {
         public void b(LifecycleDelegate var1x) {
            var4.removeAllViews();
            var4.addView(a.this.Tu.onCreateView(var1, var2, var3));
         }

         public int getState() {
            return 2;
         }
      });
      if(this.Tu == null) {
         this.a(var4);
      }

      return var4;
   }

   public void onDestroy() {
      if(this.Tu != null) {
         this.Tu.onDestroy();
      } else {
         this.cG(1);
      }
   }

   public void onDestroyView() {
      if(this.Tu != null) {
         this.Tu.onDestroyView();
      } else {
         this.cG(2);
      }
   }

   public void onInflate(final Activity var1, final Bundle var2, final Bundle var3) {
      this.a(var3, new a.a() {
         public void b(LifecycleDelegate var1x) {
            a.this.Tu.onInflate(var1, var2, var3);
         }

         public int getState() {
            return 0;
         }
      });
   }

   public void onLowMemory() {
      if(this.Tu != null) {
         this.Tu.onLowMemory();
      }

   }

   public void onPause() {
      if(this.Tu != null) {
         this.Tu.onPause();
      } else {
         this.cG(5);
      }
   }

   public void onResume() {
      this.a((Bundle)null, (a.a)(new a.a() {
         public void b(LifecycleDelegate var1) {
            a.this.Tu.onResume();
         }

         public int getState() {
            return 5;
         }
      }));
   }

   public void onSaveInstanceState(Bundle var1) {
      if(this.Tu != null) {
         this.Tu.onSaveInstanceState(var1);
      } else if(this.Tv != null) {
         var1.putAll(this.Tv);
         return;
      }

   }

   public void onStart() {
      this.a((Bundle)null, (a.a)(new a.a() {
         public void b(LifecycleDelegate var1) {
            a.this.Tu.onStart();
         }

         public int getState() {
            return 4;
         }
      }));
   }

   public void onStop() {
      if(this.Tu != null) {
         this.Tu.onStop();
      } else {
         this.cG(4);
      }
   }

   private interface a {
      void b(LifecycleDelegate var1);

      int getState();
   }
}
