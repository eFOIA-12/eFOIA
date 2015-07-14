package com.google.android.gms.internal;

import android.app.DownloadManager;
import android.app.AlertDialog.Builder;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.R;
import com.google.android.gms.internal.bl;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.ga;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.gu;
import com.google.android.gms.internal.ll;
import java.util.Map;
import org.json.JSONObject;

@ey
public class dj {
   private final Context mContext;
   private final gu mo;
   private final Map rd;

   public dj(gu var1, Map var2) {
      this.mo = var1;
      this.rd = var2;
      this.mContext = var1.dI();
   }

   String B(String var1) {
      return Uri.parse(var1).getLastPathSegment();
   }

   Request b(String var1, String var2) {
      Request var3 = new Request(Uri.parse(var1));
      var3.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, var2);
      if(ll.ig()) {
         var3.allowScanningByMediaScanner();
         var3.setNotificationVisibility(1);
         return var3;
      } else {
         var3.setShowRunningNotification(true);
         return var3;
      }
   }

   public void execute() {
      if(!(new bl(this.mContext)).bq()) {
         gr.W("Store picture feature is not supported on this device.");
      } else if(TextUtils.isEmpty((CharSequence)this.rd.get("iurl"))) {
         gr.W("Image url cannot be empty.");
      } else {
         final String var1 = (String)this.rd.get("iurl");
         if(!URLUtil.isValidUrl(var1)) {
            gr.W("Invalid image url:" + var1);
         } else {
            final String var2 = this.B(var1);
            if(!gi.N(var2)) {
               gr.W("Image type not recognized:");
            } else {
               Builder var3 = new Builder(this.mContext);
               var3.setTitle(ga.c(R.string.store_picture_title, "Save image"));
               var3.setMessage(ga.c(R.string.store_picture_message, "Allow Ad to store image in Picture gallery?"));
               var3.setPositiveButton(ga.c(R.string.accept, "Accept"), new OnClickListener() {
                  public void onClick(DialogInterface var1x, int var2x) {
                     DownloadManager var4 = (DownloadManager)dj.this.mContext.getSystemService("download");

                     try {
                        var4.enqueue(dj.this.b(var1, var2));
                     } catch (IllegalStateException var3) {
                        gr.U("Could not store picture.");
                     }
                  }
               });
               var3.setNegativeButton(ga.c(R.string.decline, "Decline"), new OnClickListener() {
                  public void onClick(DialogInterface var1, int var2) {
                     dj.this.mo.b("onStorePictureCanceled", new JSONObject());
                  }
               });
               var3.create().show();
            }
         }
      }
   }
}
