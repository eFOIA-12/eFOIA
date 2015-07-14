package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.appcontent.AppContents;

public final class AppContentsImpl implements AppContents {
   private abstract static class LoadsImpl extends Games.BaseGamesApiMethodImpl {
      public AppContents.LoadAppContentResult N(final Status var1) {
         return new AppContents.LoadAppContentResult() {
            public Status getStatus() {
               return var1;
            }

            public void release() {
            }
         };
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.N(var1);
      }
   }
}
