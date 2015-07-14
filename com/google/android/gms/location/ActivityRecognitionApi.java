package com.google.android.gms.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

public interface ActivityRecognitionApi {
   PendingResult removeActivityUpdates(GoogleApiClient var1, PendingIntent var2);

   PendingResult requestActivityUpdates(GoogleApiClient var1, long var2, PendingIntent var4);
}
