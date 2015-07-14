package com.google.android.gms.cast;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.im;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jx;
import java.io.IOException;

public final class Cast {
   public static final Api API;
   public static final Cast.CastApi CastApi;
   static final Api.c DQ = new Api.c();
   private static final Api.b DR = new Api.b() {
      public im a(Context var1, Looper var2, jg var3, Cast.CastOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         jx.b((Object)var4, "Setting the API options is required.");
         return new im(var1, var2, var4.Fz, (long)var4.FB, var4.FA, var5, var6);
      }

      public int getPriority() {
         return Integer.MAX_VALUE;
      }
   };
   public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
   public static final int MAX_MESSAGE_LENGTH = 65536;
   public static final int MAX_NAMESPACE_LENGTH = 128;

   static {
      API = new Api(DR, DQ, new Scope[0]);
      CastApi = new Cast.a();
   }

   public interface ApplicationConnectionResult extends Result {
      ApplicationMetadata getApplicationMetadata();

      String getApplicationStatus();

      String getSessionId();

      boolean getWasLaunched();
   }

   public interface CastApi {
      ApplicationMetadata getApplicationMetadata(GoogleApiClient var1) throws IllegalStateException;

      String getApplicationStatus(GoogleApiClient var1) throws IllegalStateException;

      double getVolume(GoogleApiClient var1) throws IllegalStateException;

      boolean isMute(GoogleApiClient var1) throws IllegalStateException;

      PendingResult joinApplication(GoogleApiClient var1);

      PendingResult joinApplication(GoogleApiClient var1, String var2);

      PendingResult joinApplication(GoogleApiClient var1, String var2, String var3);

      PendingResult launchApplication(GoogleApiClient var1, String var2);

      PendingResult launchApplication(GoogleApiClient var1, String var2, LaunchOptions var3);

      @Deprecated
      PendingResult launchApplication(GoogleApiClient var1, String var2, boolean var3);

      PendingResult leaveApplication(GoogleApiClient var1);

      void removeMessageReceivedCallbacks(GoogleApiClient var1, String var2) throws IOException, IllegalArgumentException;

      void requestStatus(GoogleApiClient var1) throws IOException, IllegalStateException;

      PendingResult sendMessage(GoogleApiClient var1, String var2, String var3);

      void setMessageReceivedCallbacks(GoogleApiClient var1, String var2, Cast.MessageReceivedCallback var3) throws IOException, IllegalStateException;

      void setMute(GoogleApiClient var1, boolean var2) throws IOException, IllegalStateException;

      void setVolume(GoogleApiClient var1, double var2) throws IOException, IllegalArgumentException, IllegalStateException;

      PendingResult stopApplication(GoogleApiClient var1);

      PendingResult stopApplication(GoogleApiClient var1, String var2);
   }

   public static final class a implements Cast.CastApi {
      public ApplicationMetadata getApplicationMetadata(GoogleApiClient var1) throws IllegalStateException {
         return ((im)var1.a(Cast.DQ)).getApplicationMetadata();
      }

      public String getApplicationStatus(GoogleApiClient var1) throws IllegalStateException {
         return ((im)var1.a(Cast.DQ)).getApplicationStatus();
      }

      public double getVolume(GoogleApiClient var1) throws IllegalStateException {
         return ((im)var1.a(Cast.DQ)).fZ();
      }

      public boolean isMute(GoogleApiClient var1) throws IllegalStateException {
         return ((im)var1.a(Cast.DQ)).isMute();
      }

      public PendingResult joinApplication(final GoogleApiClient var1) {
         return var1.b(new Cast.c(var1) {
            protected void a(im var1) throws RemoteException {
               try {
                  var1.b((String)null, (String)null, this);
               } catch (IllegalStateException var2) {
                  this.W(2001);
               }
            }
         });
      }

      public PendingResult joinApplication(final GoogleApiClient var1, final String var2) {
         return var1.b(new Cast.c(var1) {
            protected void a(im var1) throws RemoteException {
               try {
                  var1.b(var2, (String)null, this);
               } catch (IllegalStateException var2x) {
                  this.W(2001);
               }
            }
         });
      }

      public PendingResult joinApplication(final GoogleApiClient var1, final String var2, final String var3) {
         return var1.b(new Cast.c(var1) {
            protected void a(im var1) throws RemoteException {
               try {
                  var1.b(var2, var3, this);
               } catch (IllegalStateException var2x) {
                  this.W(2001);
               }
            }
         });
      }

      public PendingResult launchApplication(final GoogleApiClient var1, final String var2) {
         return var1.b(new Cast.c(var1) {
            protected void a(im var1) throws RemoteException {
               try {
                  var1.a(var2, false, this);
               } catch (IllegalStateException var2x) {
                  this.W(2001);
               }
            }
         });
      }

      public PendingResult launchApplication(final GoogleApiClient var1, final String var2, final LaunchOptions var3) {
         return var1.b(new Cast.c(var1) {
            protected void a(im var1) throws RemoteException {
               try {
                  var1.a(var2, (LaunchOptions)var3, this);
               } catch (IllegalStateException var2x) {
                  this.W(2001);
               }
            }
         });
      }

      @Deprecated
      public PendingResult launchApplication(GoogleApiClient var1, String var2, boolean var3) {
         return this.launchApplication(var1, var2, (new LaunchOptions.Builder()).setRelaunchIfRunning(var3).build());
      }

      public PendingResult leaveApplication(final GoogleApiClient var1) {
         return var1.b(new Cast.b(var1) {
            protected void a(im var1) throws RemoteException {
               try {
                  var1.d((BaseImplementation.b)this);
               } catch (IllegalStateException var2) {
                  this.W(2001);
               }
            }
         });
      }

      public void removeMessageReceivedCallbacks(GoogleApiClient var1, String var2) throws IOException, IllegalArgumentException {
         try {
            ((im)var1.a(Cast.DQ)).aE(var2);
         } catch (RemoteException var3) {
            throw new IOException("service error");
         }
      }

      public void requestStatus(GoogleApiClient var1) throws IOException, IllegalStateException {
         try {
            ((im)var1.a(Cast.DQ)).fY();
         } catch (RemoteException var2) {
            throw new IOException("service error");
         }
      }

      public PendingResult sendMessage(final GoogleApiClient var1, final String var2, final String var3) {
         return var1.b(new Cast.b(var1) {
            protected void a(im var1) throws RemoteException {
               try {
                  var1.a(var2, (String)var3, this);
               } catch (IllegalArgumentException var2x) {
                  this.W(2001);
               } catch (IllegalStateException var3x) {
                  this.W(2001);
               }
            }
         });
      }

      public void setMessageReceivedCallbacks(GoogleApiClient var1, String var2, Cast.MessageReceivedCallback var3) throws IOException, IllegalStateException {
         try {
            ((im)var1.a(Cast.DQ)).a(var2, var3);
         } catch (RemoteException var4) {
            throw new IOException("service error");
         }
      }

      public void setMute(GoogleApiClient var1, boolean var2) throws IOException, IllegalStateException {
         try {
            ((im)var1.a(Cast.DQ)).I(var2);
         } catch (RemoteException var3) {
            throw new IOException("service error");
         }
      }

      public void setVolume(GoogleApiClient var1, double var2) throws IOException, IllegalArgumentException, IllegalStateException {
         try {
            ((im)var1.a(Cast.DQ)).a(var2);
         } catch (RemoteException var4) {
            throw new IOException("service error");
         }
      }

      public PendingResult stopApplication(final GoogleApiClient var1) {
         return var1.b(new Cast.b(var1) {
            protected void a(im var1) throws RemoteException {
               try {
                  var1.a((String)"", (BaseImplementation.b)this);
               } catch (IllegalStateException var2) {
                  this.W(2001);
               }
            }
         });
      }

      public PendingResult stopApplication(final GoogleApiClient var1, final String var2) {
         return var1.b(new Cast.b(var1) {
            protected void a(im var1) throws RemoteException {
               if(TextUtils.isEmpty(var2)) {
                  this.e(2001, "IllegalArgument: sessionId cannot be null or empty");
               } else {
                  try {
                     var1.a((String)var2, (BaseImplementation.b)this);
                  } catch (IllegalStateException var2x) {
                     this.W(2001);
                  }
               }
            }
         });
      }
   }

   public static final class CastOptions implements Api.HasOptions {
      final Cast.Listener FA;
      private final int FB;
      final CastDevice Fz;

      private CastOptions(Cast.Builder var1) {
         this.Fz = var1.FC;
         this.FA = var1.FD;
         this.FB = var1.FE;
      }

      // $FF: synthetic method
      CastOptions(Cast.Builder var1, Object var2) {
         this(var1);
      }

      public static Cast.Builder builder(CastDevice var0, Cast.Listener var1) {
         return new Cast.Builder(var0, var1, null);
      }
   }

   public static final class Builder {
      CastDevice FC;
      Cast.Listener FD;
      private int FE;

      private Builder(CastDevice var1, Cast.Listener var2) {
         jx.b((Object)var1, "CastDevice parameter cannot be null");
         jx.b((Object)var2, "CastListener parameter cannot be null");
         this.FC = var1;
         this.FD = var2;
         this.FE = 0;
      }

      // $FF: synthetic method
      Builder(CastDevice var1, Cast.Listener var2, Object var3) {
         this(var1, var2);
      }

      public Cast.CastOptions build() {
         return new Cast.CastOptions(this, null);
      }

      public Cast.Builder setVerboseLoggingEnabled(boolean var1) {
         if(var1) {
            this.FE |= 1;
            return this;
         } else {
            this.FE &= -2;
            return this;
         }
      }
   }

   public static class Listener {
      public void X(int var1) {
      }

      public void Y(int var1) {
      }

      public void onApplicationDisconnected(int var1) {
      }

      public void onApplicationMetadataChanged(ApplicationMetadata var1) {
      }

      public void onApplicationStatusChanged() {
      }

      public void onVolumeChanged() {
      }
   }

   public interface MessageReceivedCallback {
      void onMessageReceived(CastDevice var1, String var2, String var3);
   }

   protected abstract static class a extends BaseImplementation.a {
      public a(GoogleApiClient var1) {
         super(Cast.DQ, var1);
      }

      public void W(int var1) {
         this.b(this.c(new Status(var1)));
      }

      public void e(int var1, String var2) {
         this.b(this.c(new Status(var1, var2, (PendingIntent)null)));
      }
   }

   private abstract static class b extends Cast.a {
      b(GoogleApiClient var1) {
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

   private abstract static class c extends Cast.a {
      public c(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.i(var1);
      }

      public Cast.ApplicationConnectionResult i(final Status var1) {
         return new Cast.ApplicationConnectionResult() {
            public ApplicationMetadata getApplicationMetadata() {
               return null;
            }

            public String getApplicationStatus() {
               return null;
            }

            public String getSessionId() {
               return null;
            }

            public Status getStatus() {
               return var1;
            }

            public boolean getWasLaunched() {
               return false;
            }
         };
      }
   }
}
