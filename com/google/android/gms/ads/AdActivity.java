package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.internal.dw;
import com.google.android.gms.internal.dx;
import com.google.android.gms.internal.gr;

public final class AdActivity extends Activity {
   public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
   public static final String SIMPLE_CLASS_NAME = "AdActivity";
   private dx lf;

   private void X() {
      if(this.lf != null) {
         try {
            this.lf.X();
         } catch (RemoteException var2) {
            gr.d("Could not forward setContentViewSet to ad overlay:", var2);
            return;
         }
      }

   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.lf = dw.b(this);
      if(this.lf == null) {
         gr.W("Could not create ad overlay.");
         this.finish();
      } else {
         try {
            this.lf.onCreate(var1);
         } catch (RemoteException var2) {
            gr.d("Could not forward onCreate to ad overlay:", var2);
            this.finish();
         }
      }
   }

   protected void onDestroy() {
      try {
         if(this.lf != null) {
            this.lf.onDestroy();
         }
      } catch (RemoteException var2) {
         gr.d("Could not forward onDestroy to ad overlay:", var2);
      }

      super.onDestroy();
   }

   protected void onPause() {
      try {
         if(this.lf != null) {
            this.lf.onPause();
         }
      } catch (RemoteException var2) {
         gr.d("Could not forward onPause to ad overlay:", var2);
         this.finish();
      }

      super.onPause();
   }

   protected void onRestart() {
      super.onRestart();

      try {
         if(this.lf != null) {
            this.lf.onRestart();
         }

      } catch (RemoteException var2) {
         gr.d("Could not forward onRestart to ad overlay:", var2);
         this.finish();
      }
   }

   protected void onResume() {
      super.onResume();

      try {
         if(this.lf != null) {
            this.lf.onResume();
         }

      } catch (RemoteException var2) {
         gr.d("Could not forward onResume to ad overlay:", var2);
         this.finish();
      }
   }

   protected void onSaveInstanceState(Bundle var1) {
      try {
         if(this.lf != null) {
            this.lf.onSaveInstanceState(var1);
         }
      } catch (RemoteException var3) {
         gr.d("Could not forward onSaveInstanceState to ad overlay:", var3);
         this.finish();
      }

      super.onSaveInstanceState(var1);
   }

   protected void onStart() {
      super.onStart();

      try {
         if(this.lf != null) {
            this.lf.onStart();
         }

      } catch (RemoteException var2) {
         gr.d("Could not forward onStart to ad overlay:", var2);
         this.finish();
      }
   }

   protected void onStop() {
      try {
         if(this.lf != null) {
            this.lf.onStop();
         }
      } catch (RemoteException var2) {
         gr.d("Could not forward onStop to ad overlay:", var2);
         this.finish();
      }

      super.onStop();
   }

   public void setContentView(int var1) {
      super.setContentView(var1);
      this.X();
   }

   public void setContentView(View var1) {
      super.setContentView(var1);
      this.X();
   }

   public void setContentView(View var1, LayoutParams var2) {
      super.setContentView(var1, var2);
      this.X();
   }
}
