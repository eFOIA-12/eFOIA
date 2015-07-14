package com.google.android.gms.appstate;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.ib;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jx;

@Deprecated
public final class AppStateManager {
   public static final Api API;
   static final Api.c DQ = new Api.c();
   private static final Api.b DR = new Api.b() {
      // $FF: synthetic method
      public Api.a a(Context var1, Looper var2, jg var3, Object var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return this.b(var1, var2, var3, (Api.NoOptions)var4, var5, var6);
      }

      public ib b(Context var1, Looper var2, jg var3, Api.NoOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return new ib(var1, var2, var5, var6, var3.hm(), (String[])var3.ho().toArray(new String[0]));
      }

      public int getPriority() {
         return Integer.MAX_VALUE;
      }
   };
   public static final Scope SCOPE_APP_STATE = new Scope("https://www.googleapis.com/auth/appstate");

   static {
      API = new Api(DR, DQ, new Scope[]{SCOPE_APP_STATE});
   }

   public static ib a(GoogleApiClient var0) {
      boolean var2 = true;
      boolean var1;
      if(var0 != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      jx.b(var1, "GoogleApiClient parameter is required.");
      jx.a(var0.isConnected(), "GoogleApiClient must be connected.");
      ib var3 = (ib)var0.a(DQ);
      if(var3 != null) {
         var1 = var2;
      } else {
         var1 = false;
      }

      jx.a(var1, "GoogleApiClient is not configured to use the AppState API. Pass AppStateManager.API into GoogleApiClient.Builder#addApi() to use this feature.");
      return var3;
   }

   private static AppStateManager.StateResult d(final Status var0) {
      return new AppStateManager.StateResult() {
         public AppStateManager.StateConflictResult getConflictResult() {
            return null;
         }

         public AppStateManager.StateLoadedResult getLoadedResult() {
            return null;
         }

         public Status getStatus() {
            return var0;
         }

         public void release() {
         }
      };
   }

   public static PendingResult delete(final GoogleApiClient var0, final int var1) {
      return var0.b(new AppStateManager.b(var0) {
         protected void a(ib var1x) {
            var1x.a(this, var1);
         }

         // $FF: synthetic method
         public Result c(Status var1x) {
            return this.f(var1x);
         }

         public AppStateManager.StateDeletedResult f(final Status var1x) {
            return new AppStateManager.StateDeletedResult() {
               public int getStateKey() {
                  return var1;
               }

               public Status getStatus() {
                  return var1x;
               }
            };
         }
      });
   }

   public static int getMaxNumKeys(GoogleApiClient var0) {
      return a(var0).fM();
   }

   public static int getMaxStateSize(GoogleApiClient var0) {
      return a(var0).fL();
   }

   public static PendingResult list(final GoogleApiClient var0) {
      return var0.a((BaseImplementation.a)(new AppStateManager.c(var0) {
         protected void a(ib var1) {
            var1.a(this);
         }
      }));
   }

   public static PendingResult load(final GoogleApiClient var0, final int var1) {
      return var0.a((BaseImplementation.a)(new AppStateManager.e(var0) {
         protected void a(ib var1x) {
            var1x.b(this, var1);
         }
      }));
   }

   public static PendingResult resolve(final GoogleApiClient var0, final int var1, final String var2, final byte[] var3) {
      return var0.b(new AppStateManager.e(var0) {
         protected void a(ib var1x) {
            var1x.a(this, var1, var2, var3);
         }
      });
   }

   public static PendingResult signOut(final GoogleApiClient var0) {
      return var0.b(new AppStateManager.d(var0) {
         protected void a(ib var1) {
            var1.b(this);
         }
      });
   }

   public static void update(final GoogleApiClient var0, final int var1, final byte[] var2) {
      var0.b(new AppStateManager.e(var0) {
         protected void a(ib var1x) {
            var1x.a((BaseImplementation.b)null, var1, var2);
         }
      });
   }

   public static PendingResult updateImmediate(final GoogleApiClient var0, final int var1, final byte[] var2) {
      return var0.b(new AppStateManager.e(var0) {
         protected void a(ib var1x) {
            var1x.a(this, var1, var2);
         }
      });
   }

   public interface StateConflictResult extends Releasable, Result {
      byte[] getLocalData();

      String getResolvedVersion();

      byte[] getServerData();

      int getStateKey();
   }

   public interface StateDeletedResult extends Result {
      int getStateKey();
   }

   public interface StateListResult extends Result {
      AppStateBuffer getStateBuffer();
   }

   public interface StateLoadedResult extends Releasable, Result {
      byte[] getLocalData();

      int getStateKey();
   }

   public interface StateResult extends Releasable, Result {
      AppStateManager.StateConflictResult getConflictResult();

      AppStateManager.StateLoadedResult getLoadedResult();
   }

   public abstract static class a extends BaseImplementation.a {
      public a(GoogleApiClient var1) {
         super(AppStateManager.DQ, var1);
      }
   }

   private abstract static class b extends AppStateManager.a {
      b(GoogleApiClient var1) {
         super(var1);
      }
   }

   private abstract static class c extends AppStateManager.a {
      public c(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.g(var1);
      }

      public AppStateManager.StateListResult g(final Status var1) {
         return new AppStateManager.StateListResult() {
            public AppStateBuffer getStateBuffer() {
               return new AppStateBuffer((DataHolder)null);
            }

            public Status getStatus() {
               return var1;
            }
         };
      }
   }

   private abstract static class d extends AppStateManager.a {
      public d(GoogleApiClient var1) {
         super(var1);
      }

      public Status b(Status var1) {
         return var1;
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.b(var1);
      }
   }

   private abstract static class e extends AppStateManager.a {
      public e(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.h(var1);
      }

      public AppStateManager.StateResult h(Status var1) {
         return AppStateManager.d(var1);
      }
   }
}
