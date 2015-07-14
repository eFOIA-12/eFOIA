package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class EventsImpl implements Events {
   public void increment(final GoogleApiClient var1, final String var2, final int var3) {
      GamesClientImpl var4 = Games.e(var1);
      if(var4.isConnected()) {
         var4.o(var2, var3);
      } else {
         var1.b(new EventsImpl.UpdateImpl(var1, null) {
            public void a(GamesClientImpl var1) {
               var1.o(var2, var3);
            }
         });
      }
   }

   public PendingResult load(final GoogleApiClient var1, final boolean var2) {
      return var1.a((BaseImplementation.a)(new EventsImpl.LoadImpl(var1, null) {
         public void a(GamesClientImpl var1) {
            var1.d(this, var2);
         }
      }));
   }

   public PendingResult loadByIds(final GoogleApiClient var1, final boolean var2, final String... var3) {
      return var1.a((BaseImplementation.a)(new EventsImpl.LoadImpl(var1, null) {
         public void a(GamesClientImpl var1) {
            var1.a(this, var2, (String[])var3);
         }
      }));
   }

   private abstract static class LoadImpl extends Games.BaseGamesApiMethodImpl {
      private LoadImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      LoadImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      public Events.LoadEventsResult O(final Status var1) {
         return new Events.LoadEventsResult() {
            public EventBuffer getEvents() {
               return new EventBuffer(DataHolder.av(14));
            }

            public Status getStatus() {
               return var1;
            }

            public void release() {
            }
         };
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.O(var1);
      }
   }

   private abstract static class UpdateImpl extends Games.BaseGamesApiMethodImpl {
      private UpdateImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      UpdateImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      public Result c(final Status var1) {
         return new Result() {
            public Status getStatus() {
               return var1;
            }
         };
      }
   }
}
