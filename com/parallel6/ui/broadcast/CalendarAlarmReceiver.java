package com.parallel6.ui.broadcast;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.ui.enums.CalendarEventTone;

public class CalendarAlarmReceiver extends BroadcastReceiver {
   public static final String ALARM_ICON = "ALARM_ICON";
   public static final String ALARM_MESSAGE = "ALARM_MESSAGE";
   public static final String ALARM_TONE = "ALARM_TONE";
   public static final String ALARM_TONE_TYPE = "ALARM_TONE_TYPE";
   public static final int REQUEST_MEDIA = 10086;

   public void onReceive(Context var1, Intent var2) {
      String var4 = var2.getStringExtra("ALARM_MESSAGE");
      int var3 = var2.getIntExtra("ALARM_ICON", R.drawable.circle_dot);
      Uri var6 = (Uri)var2.getExtras().get("ALARM_TONE");
      CalendarEventTone var7 = (CalendarEventTone)var2.getSerializableExtra("ALARM_TONE_TYPE");
      NotificationManager var8 = (NotificationManager)var1.getSystemService("notification");
      Notification var5 = new Notification();
      var5.icon = var3;
      var5.tickerText = var4;
      switch(null.$SwitchMap$com$parallel6$ui$enums$CalendarEventTone[var7.ordinal()]) {
      case 1:
         var5.sound = null;
         break;
      case 2:
         var5.defaults = -1;
         break;
      case 3:
         var5.sound = var6;
      }

      if(var6 == null) {
         var5.defaults = 1;
      } else {
         var5.sound = var6;
      }

      var5.audioStreamType = -1;
      var5.flags |= 16;
      Intent var9 = new Intent();
      var9.setFlags(268435456);
      PendingIntent var10 = PendingIntent.getActivity(var1, 0, var9, 1073741824);
      var5.setLatestEventInfo(var1, var1.getString(R.string.app_name), var4, var10);
      var8.notify(1, var5);
   }
}
