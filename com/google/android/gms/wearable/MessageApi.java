package com.google.android.gms.wearable;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.wearable.MessageEvent;

public interface MessageApi {
   int UNKNOWN_REQUEST_ID = -1;

   PendingResult addListener(GoogleApiClient var1, MessageApi.MessageListener var2);

   PendingResult removeListener(GoogleApiClient var1, MessageApi.MessageListener var2);

   PendingResult sendMessage(GoogleApiClient var1, String var2, String var3, byte[] var4);

   public interface MessageListener {
      void onMessageReceived(MessageEvent var1);
   }

   public interface SendMessageResult extends Result {
      int getRequestId();
   }
}
