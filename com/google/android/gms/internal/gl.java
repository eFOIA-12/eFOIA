package com.google.android.gms.internal;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gi;
import java.util.Iterator;
import java.util.Map;

@ey
public final class gl {
   private final Context mContext;
   private int mState;
   private final float rz;
   private String wH;
   private float wI;
   private float wJ;
   private float wK;

   public gl(Context var1) {
      this.mState = 0;
      this.mContext = var1;
      this.rz = var1.getResources().getDisplayMetrics().density;
   }

   public gl(Context var1, String var2) {
      this(var1);
      this.wH = var2;
   }

   private void a(int var1, float var2, float var3) {
      if(var1 == 0) {
         this.mState = 0;
         this.wI = var2;
         this.wJ = var3;
         this.wK = var3;
      } else if(this.mState != -1) {
         if(var1 == 2) {
            if(var3 > this.wJ) {
               this.wJ = var3;
            } else if(var3 < this.wK) {
               this.wK = var3;
            }

            if(this.wJ - this.wK > 30.0F * this.rz) {
               this.mState = -1;
               return;
            }

            if(this.mState != 0 && this.mState != 2) {
               if((this.mState == 1 || this.mState == 3) && var2 - this.wI <= -50.0F * this.rz) {
                  this.wI = var2;
                  ++this.mState;
               }
            } else if(var2 - this.wI >= 50.0F * this.rz) {
               this.wI = var2;
               ++this.mState;
            }

            if(this.mState != 1 && this.mState != 3) {
               if(this.mState == 2 && var2 < this.wI) {
                  this.wI = var2;
                  return;
               }
            } else if(var2 > this.wI) {
               this.wI = var2;
               return;
            }
         } else if(var1 == 1 && this.mState == 4) {
            this.showDialog();
            return;
         }
      }

   }

   private void showDialog() {
      final String var5;
      if(!TextUtils.isEmpty(this.wH)) {
         Uri var2 = (new Builder()).encodedQuery(this.wH).build();
         StringBuilder var1 = new StringBuilder();
         Map var6 = gi.c(var2);
         Iterator var3 = var6.keySet().iterator();

         while(var3.hasNext()) {
            String var4 = (String)var3.next();
            var1.append(var4).append(" = ").append((String)var6.get(var4)).append("\n\n");
         }

         var5 = var1.toString().trim();
         if(TextUtils.isEmpty(var5)) {
            var5 = "No debug information";
         }
      } else {
         var5 = "No debug information";
      }

      android.app.AlertDialog.Builder var7 = new android.app.AlertDialog.Builder(this.mContext);
      var7.setMessage(var5);
      var7.setTitle("Ad Information");
      var7.setPositiveButton("Share", new OnClickListener() {
         public void onClick(DialogInterface var1, int var2) {
            gl.this.mContext.startActivity(Intent.createChooser((new Intent("android.intent.action.SEND")).setType("text/plain").putExtra("android.intent.extra.TEXT", var5), "Share via"));
         }
      });
      var7.setNegativeButton("Close", new OnClickListener() {
         public void onClick(DialogInterface var1, int var2) {
         }
      });
      var7.create().show();
   }

   public void Q(String var1) {
      this.wH = var1;
   }

   public void c(MotionEvent var1) {
      int var3 = var1.getHistorySize();

      for(int var2 = 0; var2 < var3; ++var2) {
         this.a(var1.getActionMasked(), var1.getHistoricalX(0, var2), var1.getHistoricalY(0, var2));
      }

      this.a(var1.getActionMasked(), var1.getX(), var1.getY());
   }
}
