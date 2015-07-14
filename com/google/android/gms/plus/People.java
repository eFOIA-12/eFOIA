package com.google.android.gms.plus;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

public interface People {
   Person getCurrentPerson(GoogleApiClient var1);

   PendingResult load(GoogleApiClient var1, Collection var2);

   PendingResult load(GoogleApiClient var1, String... var2);

   PendingResult loadConnected(GoogleApiClient var1);

   PendingResult loadVisible(GoogleApiClient var1, int var2, String var3);

   PendingResult loadVisible(GoogleApiClient var1, String var2);

   public interface LoadPeopleResult extends Releasable, Result {
      String getNextPageToken();

      PersonBuffer getPersonBuffer();
   }

   public interface OrderBy {
      int ALPHABETICAL = 0;
      int BEST = 1;
   }
}
