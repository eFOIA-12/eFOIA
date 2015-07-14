package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Notifications;

public final class NotificationsImpl implements Notifications {
   public void clear(GoogleApiClient var1, int var2) {
      Games.d(var1).dT(var2);
   }

   public void clearAll(GoogleApiClient var1) {
      this.clear(var1, 31);
   }

   private abstract static class ContactSettingLoadImpl extends Games.BaseGamesApiMethodImpl {
      public Notifications.ContactSettingLoadResult aa(final Status var1) {
         return new Notifications.ContactSettingLoadResult() {
            public Status getStatus() {
               return var1;
            }
         };
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.aa(var1);
      }
   }

   private abstract static class ContactSettingUpdateImpl extends Games.BaseGamesApiMethodImpl {
      public Status b(Status var1) {
         return var1;
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.b(var1);
      }
   }

   private abstract static class InboxCountImpl extends Games.BaseGamesApiMethodImpl {
      public Notifications.InboxCountResult ab(final Status var1) {
         return new Notifications.InboxCountResult() {
            public Status getStatus() {
               return var1;
            }
         };
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.ab(var1);
      }
   }
}
