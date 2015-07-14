package com.androidquery.util;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.view.View;
import android.widget.ProgressBar;
import com.androidquery.AQuery;
import com.androidquery.util.AQUtility;

public class Progress implements Runnable {
   private Activity act;
   private int bytes;
   private int current;
   private ProgressBar pb;
   private ProgressDialog pd;
   private boolean unknown;
   private String url;
   private View view;

   public Progress(Object var1) {
      if(var1 instanceof ProgressBar) {
         this.pb = (ProgressBar)var1;
      } else {
         if(var1 instanceof ProgressDialog) {
            this.pd = (ProgressDialog)var1;
            return;
         }

         if(var1 instanceof Activity) {
            this.act = (Activity)var1;
            return;
         }

         if(var1 instanceof View) {
            this.view = (View)var1;
            return;
         }
      }

   }

   private void dismiss(String var1) {
      if(this.pd != null) {
         (new AQuery(this.pd.getContext())).dismiss(this.pd);
      }

      if(this.act != null) {
         this.act.setProgressBarIndeterminateVisibility(false);
         this.act.setProgressBarVisibility(false);
      }

      if(this.pb != null) {
         this.pb.setTag(1090453505, var1);
         this.pb.setVisibility(0);
      }

      ProgressBar var3 = this.pb;
      Object var2 = var3;
      if(var3 == null) {
         var2 = this.view;
      }

      if(var2 != null) {
         Object var4 = ((View)var2).getTag(1090453505);
         if(var4 == null || var4.equals(var1)) {
            ((View)var2).setTag(1090453505, (Object)null);
            if(this.pb != null && this.pb.isIndeterminate()) {
               ((View)var2).setVisibility(8);
            }
         }
      }

   }

   private void showProgress(Object var1, String var2, boolean var3) {
      if(var1 != null) {
         if(var1 instanceof View) {
            View var5 = (View)var1;
            ProgressBar var4 = null;
            if(var1 instanceof ProgressBar) {
               var4 = (ProgressBar)var1;
            }

            if(var3) {
               var5.setTag(1090453505, var2);
               var5.setVisibility(0);
               if(var4 != null) {
                  var4.setProgress(0);
                  var4.setMax(100);
               }
            } else {
               var1 = var5.getTag(1090453505);
               if(var1 == null || var1.equals(var2)) {
                  var5.setTag(1090453505, (Object)null);
                  if(var4 != null && var4.isIndeterminate()) {
                     var5.setVisibility(8);
                     return;
                  }
               }
            }
         } else {
            if(var1 instanceof Dialog) {
               Dialog var7 = (Dialog)var1;
               AQuery var8 = new AQuery(var7.getContext());
               if(var3) {
                  var8.show(var7);
                  return;
               }

               var8.dismiss(var7);
               return;
            }

            if(var1 instanceof Activity) {
               Activity var6 = (Activity)var1;
               var6.setProgressBarIndeterminateVisibility(var3);
               var6.setProgressBarVisibility(var3);
               if(var3) {
                  var6.setProgress(0);
                  return;
               }
            }
         }
      }

   }

   public void done() {
      if(this.pb != null) {
         this.pb.setProgress(this.pb.getMax());
      }

      if(this.pd != null) {
         this.pd.setProgress(this.pd.getMax());
      }

      if(this.act != null) {
         this.act.setProgress(9999);
      }

   }

   public void hide(String var1) {
      if(AQUtility.isUIThread()) {
         this.dismiss(var1);
      } else {
         this.url = var1;
         AQUtility.post(this);
      }
   }

   public void increment(int var1) {
      byte var3 = 1;
      int var2;
      if(this.pb != null) {
         ProgressBar var4 = this.pb;
         if(this.unknown) {
            var2 = 1;
         } else {
            var2 = var1;
         }

         var4.incrementProgressBy(var2);
      }

      if(this.pd != null) {
         ProgressDialog var5 = this.pd;
         if(this.unknown) {
            var2 = var3;
         } else {
            var2 = var1;
         }

         var5.incrementProgressBy(var2);
      }

      if(this.act != null) {
         if(this.unknown) {
            var1 = this.current;
            this.current = var1 + 1;
         } else {
            this.current += var1;
            var1 = this.current * 10000 / this.bytes;
         }

         var2 = var1;
         if(var1 > 9999) {
            var2 = 9999;
         }

         this.act.setProgress(var2);
      }

   }

   public void reset() {
      if(this.pb != null) {
         this.pb.setProgress(0);
         this.pb.setMax(10000);
      }

      if(this.pd != null) {
         this.pd.setProgress(0);
         this.pd.setMax(10000);
      }

      if(this.act != null) {
         this.act.setProgress(0);
      }

      this.unknown = false;
      this.current = 0;
      this.bytes = 10000;
   }

   public void run() {
      this.dismiss(this.url);
   }

   public void setBytes(int var1) {
      int var2 = var1;
      if(var1 <= 0) {
         this.unknown = true;
         var2 = 10000;
      }

      this.bytes = var2;
      if(this.pb != null) {
         this.pb.setProgress(0);
         this.pb.setMax(var2);
      }

      if(this.pd != null) {
         this.pd.setProgress(0);
         this.pd.setMax(var2);
      }

   }

   public void show(String var1) {
      this.reset();
      if(this.pd != null) {
         (new AQuery(this.pd.getContext())).show(this.pd);
      }

      if(this.act != null) {
         this.act.setProgressBarIndeterminateVisibility(true);
         this.act.setProgressBarVisibility(true);
      }

      if(this.pb != null) {
         this.pb.setTag(1090453505, var1);
         this.pb.setVisibility(0);
      }

      if(this.view != null) {
         this.view.setTag(1090453505, var1);
         this.view.setVisibility(0);
      }

   }
}
