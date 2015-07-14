package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.provider.CalendarContract.Events;
import android.text.TextUtils;
import com.google.android.gms.R;
import com.google.android.gms.internal.bl;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.ga;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.gu;
import java.util.Map;
import org.json.JSONObject;

@ey
public class dh {
   private final Context mContext;
   private final gu mo;
   private final Map rd;
   private String re;
   private long rf;
   private long rg;
   private String rh;
   private String ri;

   public dh(gu var1, Map var2) {
      this.mo = var1;
      this.rd = var2;
      this.mContext = var1.dI();
      this.bQ();
   }

   private String A(String var1) {
      return TextUtils.isEmpty((CharSequence)this.rd.get(var1))?"":(String)this.rd.get(var1);
   }

   private void bQ() {
      this.re = this.A("description");
      this.rh = this.A("summary");
      this.rf = gi.O((String)this.rd.get("start"));
      this.rg = gi.O((String)this.rd.get("end"));
      this.ri = this.A("location");
   }

   Intent createIntent() {
      Intent var1 = (new Intent("android.intent.action.EDIT")).setData(Events.CONTENT_URI);
      var1.putExtra("title", this.rh);
      var1.putExtra("eventLocation", this.ri);
      var1.putExtra("description", this.re);
      var1.putExtra("beginTime", this.rf);
      var1.putExtra("endTime", this.rg);
      var1.setFlags(268435456);
      return var1;
   }

   public void execute() {
      if(!(new bl(this.mContext)).bt()) {
         gr.W("This feature is not available on this version of the device.");
      } else {
         Builder var1 = new Builder(this.mContext);
         var1.setTitle(ga.c(R.string.create_calendar_title, "Create calendar event"));
         var1.setMessage(ga.c(R.string.create_calendar_message, "Allow Ad to create a calendar event?"));
         var1.setPositiveButton(ga.c(R.string.accept, "Accept"), new OnClickListener() {
            public void onClick(DialogInterface var1, int var2) {
               Intent var3 = dh.this.createIntent();
               dh.this.mContext.startActivity(var3);
            }
         });
         var1.setNegativeButton(ga.c(R.string.decline, "Decline"), new OnClickListener() {
            public void onClick(DialogInterface var1, int var2) {
               dh.this.mo.b("onCalendarEventCanceled", new JSONObject());
            }
         });
         var1.create().show();
      }
   }
}
