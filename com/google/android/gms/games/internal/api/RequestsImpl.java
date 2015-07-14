package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class RequestsImpl implements Requests {
   public PendingResult acceptRequest(GoogleApiClient var1, String var2) {
      ArrayList var3 = new ArrayList();
      var3.add(var2);
      return this.acceptRequests(var1, var3);
   }

   public PendingResult acceptRequests(final GoogleApiClient var1, List var2) {
      final String[] var3;
      if(var2 == null) {
         var3 = null;
      } else {
         var3 = (String[])var2.toArray(new String[var2.size()]);
      }

      return var1.b(new RequestsImpl.UpdateRequestsImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.b(this, (String[])var3);
         }
      });
   }

   public PendingResult dismissRequest(GoogleApiClient var1, String var2) {
      ArrayList var3 = new ArrayList();
      var3.add(var2);
      return this.dismissRequests(var1, var3);
   }

   public PendingResult dismissRequests(final GoogleApiClient var1, List var2) {
      final String[] var3;
      if(var2 == null) {
         var3 = null;
      } else {
         var3 = (String[])var2.toArray(new String[var2.size()]);
      }

      return var1.b(new RequestsImpl.UpdateRequestsImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.c(this, (String[])var3);
         }
      });
   }

   public ArrayList getGameRequestsFromBundle(Bundle var1) {
      if(var1 != null && var1.containsKey("requests")) {
         ArrayList var5 = (ArrayList)var1.get("requests");
         ArrayList var4 = new ArrayList();
         int var3 = var5.size();

         for(int var2 = 0; var2 < var3; ++var2) {
            var4.add((GameRequest)var5.get(var2));
         }

         return var4;
      } else {
         return new ArrayList();
      }
   }

   public ArrayList getGameRequestsFromInboxResponse(Intent var1) {
      return var1 == null?new ArrayList():this.getGameRequestsFromBundle(var1.getExtras());
   }

   public Intent getInboxIntent(GoogleApiClient var1) {
      return Games.d(var1).ly();
   }

   public int getMaxLifetimeDays(GoogleApiClient var1) {
      return Games.d(var1).lA();
   }

   public int getMaxPayloadSize(GoogleApiClient var1) {
      return Games.d(var1).lz();
   }

   public Intent getSendIntent(GoogleApiClient var1, int var2, byte[] var3, int var4, Bitmap var5, String var6) {
      return Games.d(var1).a(var2, var3, var4, var5, var6);
   }

   public PendingResult loadRequests(final GoogleApiClient var1, final int var2, final int var3, final int var4) {
      return var1.a((BaseImplementation.a)(new RequestsImpl.LoadRequestsImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.a(this, var2, var3, var4);
         }
      }));
   }

   public void registerRequestListener(GoogleApiClient var1, OnRequestReceivedListener var2) {
      d var3 = var1.d(var2);
      Games.d(var1).d(var3);
   }

   public void unregisterRequestListener(GoogleApiClient var1) {
      Games.d(var1).ls();
   }

   private abstract static class LoadRequestSummariesImpl extends Games.BaseGamesApiMethodImpl {
      public Requests.LoadRequestSummariesResult ak(final Status var1) {
         return new Requests.LoadRequestSummariesResult() {
            public Status getStatus() {
               return var1;
            }

            public void release() {
            }
         };
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.ak(var1);
      }
   }

   private abstract static class LoadRequestsImpl extends Games.BaseGamesApiMethodImpl {
      private LoadRequestsImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      LoadRequestsImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      public Requests.LoadRequestsResult al(final Status var1) {
         return new Requests.LoadRequestsResult() {
            public GameRequestBuffer getRequests(int var1x) {
               return new GameRequestBuffer(DataHolder.av(var1.getStatusCode()));
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
         return this.al(var1);
      }
   }

   private abstract static class SendRequestImpl extends Games.BaseGamesApiMethodImpl {
      public Requests.SendRequestResult am(final Status var1) {
         return new Requests.SendRequestResult() {
            public Status getStatus() {
               return var1;
            }
         };
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.am(var1);
      }
   }

   private abstract static class UpdateRequestsImpl extends Games.BaseGamesApiMethodImpl {
      private UpdateRequestsImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      UpdateRequestsImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      public Requests.UpdateRequestsResult an(final Status var1) {
         return new Requests.UpdateRequestsResult() {
            public Set getRequestIds() {
               return null;
            }

            public int getRequestOutcome(String var1x) {
               throw new IllegalArgumentException("Unknown request ID " + var1x);
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
         return this.an(var1);
      }
   }
}
