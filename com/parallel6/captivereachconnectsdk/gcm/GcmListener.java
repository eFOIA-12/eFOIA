package com.parallel6.captivereachconnectsdk.gcm;

import android.content.Intent;

public interface GcmListener {
   void onNotificationReceived(Intent var1, String var2);
}
