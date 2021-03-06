package com.google.android.gms.plus;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;

public interface Moments {
   PendingResult load(GoogleApiClient var1);

   PendingResult load(GoogleApiClient var1, int var2, String var3, Uri var4, String var5, String var6);

   PendingResult remove(GoogleApiClient var1, String var2);

   PendingResult write(GoogleApiClient var1, Moment var2);

   public interface LoadMomentsResult extends Releasable, Result {
      MomentBuffer getMomentBuffer();

      String getNextPageToken();

      String getUpdated();
   }
}
