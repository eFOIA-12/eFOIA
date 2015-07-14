package com.google.android.gms.plus;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

public interface Account {
   @Deprecated
   void clearDefaultAccount(GoogleApiClient var1);

   String getAccountName(GoogleApiClient var1);

   PendingResult revokeAccessAndDisconnect(GoogleApiClient var1);
}
