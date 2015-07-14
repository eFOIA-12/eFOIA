package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.game.Acls;

public final class AclsImpl implements Acls {
   private static Acls.LoadAclResult K(final Status var0) {
      return new Acls.LoadAclResult() {
         public Status getStatus() {
            return var0;
         }

         public void release() {
         }
      };
   }

   private abstract static class LoadNotifyAclImpl extends Games.BaseGamesApiMethodImpl {
      public Acls.LoadAclResult M(Status var1) {
         return AclsImpl.K(var1);
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.M(var1);
      }
   }

   private abstract static class UpdateNotifyAclImpl extends Games.BaseGamesApiMethodImpl {
      public Status b(Status var1) {
         return var1;
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.b(var1);
      }
   }
}
