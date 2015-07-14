package com.google.android.gms.games.request;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface Requests {
   String EXTRA_REQUESTS = "requests";
   int REQUEST_DEFAULT_LIFETIME_DAYS = -1;
   int REQUEST_DIRECTION_INBOUND = 0;
   int REQUEST_DIRECTION_OUTBOUND = 1;
   int REQUEST_UPDATE_OUTCOME_FAIL = 1;
   int REQUEST_UPDATE_OUTCOME_RETRY = 2;
   int REQUEST_UPDATE_OUTCOME_SUCCESS = 0;
   int REQUEST_UPDATE_TYPE_ACCEPT = 0;
   int REQUEST_UPDATE_TYPE_DISMISS = 1;
   int SORT_ORDER_EXPIRING_SOON_FIRST = 0;
   int SORT_ORDER_SOCIAL_AGGREGATION = 1;

   PendingResult acceptRequest(GoogleApiClient var1, String var2);

   PendingResult acceptRequests(GoogleApiClient var1, List var2);

   PendingResult dismissRequest(GoogleApiClient var1, String var2);

   PendingResult dismissRequests(GoogleApiClient var1, List var2);

   ArrayList getGameRequestsFromBundle(Bundle var1);

   ArrayList getGameRequestsFromInboxResponse(Intent var1);

   Intent getInboxIntent(GoogleApiClient var1);

   int getMaxLifetimeDays(GoogleApiClient var1);

   int getMaxPayloadSize(GoogleApiClient var1);

   Intent getSendIntent(GoogleApiClient var1, int var2, byte[] var3, int var4, Bitmap var5, String var6);

   PendingResult loadRequests(GoogleApiClient var1, int var2, int var3, int var4);

   void registerRequestListener(GoogleApiClient var1, OnRequestReceivedListener var2);

   void unregisterRequestListener(GoogleApiClient var1);

   public interface LoadRequestSummariesResult extends Releasable, Result {
   }

   public interface LoadRequestsResult extends Releasable, Result {
      GameRequestBuffer getRequests(int var1);
   }

   public interface SendRequestResult extends Result {
   }

   public interface UpdateRequestsResult extends Releasable, Result {
      Set getRequestIds();

      int getRequestOutcome(String var1);
   }
}
