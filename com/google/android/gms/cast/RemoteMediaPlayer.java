package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.im;
import com.google.android.gms.internal.it;
import com.google.android.gms.internal.iu;
import com.google.android.gms.internal.iv;
import java.io.IOException;
import org.json.JSONObject;

public class RemoteMediaPlayer implements Cast.MessageReceivedCallback {
   public static final int RESUME_STATE_PAUSE = 2;
   public static final int RESUME_STATE_PLAY = 1;
   public static final int RESUME_STATE_UNCHANGED = 0;
   public static final int STATUS_CANCELED = 2101;
   public static final int STATUS_FAILED = 2100;
   public static final int STATUS_REPLACED = 2103;
   public static final int STATUS_SUCCEEDED = 0;
   public static final int STATUS_TIMED_OUT = 2102;
   private final it Gw = new it() {
      protected void onMetadataUpdated() {
         RemoteMediaPlayer.this.onMetadataUpdated();
      }

      protected void onStatusUpdated() {
         RemoteMediaPlayer.this.onStatusUpdated();
      }
   };
   private final RemoteMediaPlayer.a Gx = new RemoteMediaPlayer.a();
   private RemoteMediaPlayer.OnMetadataUpdatedListener Gy;
   private RemoteMediaPlayer.OnStatusUpdatedListener Gz;
   private final Object mH = new Object();

   public RemoteMediaPlayer() {
      this.Gw.a((iu)this.Gx);
   }

   // $FF: synthetic method
   static Object c(RemoteMediaPlayer var0) {
      return var0.mH;
   }

   // $FF: synthetic method
   static RemoteMediaPlayer.a d(RemoteMediaPlayer var0) {
      return var0.Gx;
   }

   private void onMetadataUpdated() {
      if(this.Gy != null) {
         this.Gy.onMetadataUpdated();
      }

   }

   private void onStatusUpdated() {
      if(this.Gz != null) {
         this.Gz.onStatusUpdated();
      }

   }

   public long getApproximateStreamPosition() {
      // $FF: Couldn't be decompiled
   }

   public MediaInfo getMediaInfo() {
      // $FF: Couldn't be decompiled
   }

   public MediaStatus getMediaStatus() {
      // $FF: Couldn't be decompiled
   }

   public String getNamespace() {
      return this.Gw.getNamespace();
   }

   public long getStreamDuration() {
      // $FF: Couldn't be decompiled
   }

   public PendingResult load(GoogleApiClient var1, MediaInfo var2) {
      return this.load(var1, var2, true, 0L, (long[])null, (JSONObject)null);
   }

   public PendingResult load(GoogleApiClient var1, MediaInfo var2, boolean var3) {
      return this.load(var1, var2, var3, 0L, (long[])null, (JSONObject)null);
   }

   public PendingResult load(GoogleApiClient var1, MediaInfo var2, boolean var3, long var4) {
      return this.load(var1, var2, var3, var4, (long[])null, (JSONObject)null);
   }

   public PendingResult load(GoogleApiClient var1, MediaInfo var2, boolean var3, long var4, JSONObject var6) {
      return this.load(var1, var2, var3, var4, (long[])null, var6);
   }

   public PendingResult load(final GoogleApiClient var1, final MediaInfo var2, final boolean var3, final long var4, final long[] var6, final JSONObject var7) {
      return var1.b(new RemoteMediaPlayer.b(var1) {
         protected void a(im param1) {
            // $FF: Couldn't be decompiled
         }
      });
   }

   public void onMessageReceived(CastDevice var1, String var2, String var3) {
      this.Gw.aD(var3);
   }

   public PendingResult pause(GoogleApiClient var1) {
      return this.pause(var1, (JSONObject)null);
   }

   public PendingResult pause(final GoogleApiClient var1, final JSONObject var2) {
      return var1.b(new RemoteMediaPlayer.b(var1) {
         protected void a(im param1) {
            // $FF: Couldn't be decompiled
         }
      });
   }

   public PendingResult play(GoogleApiClient var1) {
      return this.play(var1, (JSONObject)null);
   }

   public PendingResult play(final GoogleApiClient var1, final JSONObject var2) {
      return var1.b(new RemoteMediaPlayer.b(var1) {
         protected void a(im param1) {
            // $FF: Couldn't be decompiled
         }
      });
   }

   public PendingResult requestStatus(final GoogleApiClient var1) {
      return var1.b(new RemoteMediaPlayer.b(var1) {
         protected void a(im param1) {
            // $FF: Couldn't be decompiled
         }
      });
   }

   public PendingResult seek(GoogleApiClient var1, long var2) {
      return this.seek(var1, var2, 0, (JSONObject)null);
   }

   public PendingResult seek(GoogleApiClient var1, long var2, int var4) {
      return this.seek(var1, var2, var4, (JSONObject)null);
   }

   public PendingResult seek(final GoogleApiClient var1, final long var2, final int var4, final JSONObject var5) {
      return var1.b(new RemoteMediaPlayer.b(var1) {
         protected void a(im param1) {
            // $FF: Couldn't be decompiled
         }
      });
   }

   public PendingResult setActiveMediaTracks(final GoogleApiClient var1, final long[] var2) {
      if(var2 != null && var2.length != 0) {
         return var1.b(new RemoteMediaPlayer.b(var1) {
            protected void a(im param1) {
               // $FF: Couldn't be decompiled
            }
         });
      } else {
         throw new IllegalArgumentException("trackIds cannot be null or empty");
      }
   }

   public void setOnMetadataUpdatedListener(RemoteMediaPlayer.OnMetadataUpdatedListener var1) {
      this.Gy = var1;
   }

   public void setOnStatusUpdatedListener(RemoteMediaPlayer.OnStatusUpdatedListener var1) {
      this.Gz = var1;
   }

   public PendingResult setStreamMute(GoogleApiClient var1, boolean var2) {
      return this.setStreamMute(var1, var2, (JSONObject)null);
   }

   public PendingResult setStreamMute(final GoogleApiClient var1, final boolean var2, final JSONObject var3) {
      return var1.b(new RemoteMediaPlayer.b(var1) {
         protected void a(im param1) {
            // $FF: Couldn't be decompiled
         }
      });
   }

   public PendingResult setStreamVolume(GoogleApiClient var1, double var2) throws IllegalArgumentException {
      return this.setStreamVolume(var1, var2, (JSONObject)null);
   }

   public PendingResult setStreamVolume(final GoogleApiClient var1, final double var2, final JSONObject var4) throws IllegalArgumentException {
      if(!Double.isInfinite(var2) && !Double.isNaN(var2)) {
         return var1.b(new RemoteMediaPlayer.b(var1) {
            protected void a(im param1) {
               // $FF: Couldn't be decompiled
            }
         });
      } else {
         throw new IllegalArgumentException("Volume cannot be " + var2);
      }
   }

   public PendingResult setTextTrackStyle(final GoogleApiClient var1, final TextTrackStyle var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("trackStyle cannot be null");
      } else {
         return var1.b(new RemoteMediaPlayer.b(var1) {
            protected void a(im param1) {
               // $FF: Couldn't be decompiled
            }
         });
      }
   }

   public PendingResult stop(GoogleApiClient var1) {
      return this.stop(var1, (JSONObject)null);
   }

   public PendingResult stop(final GoogleApiClient var1, final JSONObject var2) {
      return var1.b(new RemoteMediaPlayer.b(var1) {
         protected void a(im param1) {
            // $FF: Couldn't be decompiled
         }
      });
   }

   public interface MediaChannelResult extends Result {
      JSONObject getCustomData();
   }

   public interface OnMetadataUpdatedListener {
      void onMetadataUpdated();
   }

   public interface OnStatusUpdatedListener {
      void onStatusUpdated();
   }

   private class a implements iu {
      private GoogleApiClient GN;
      private long GO = 0L;

      public void a(String var1, String var2, long var3, String var5) throws IOException {
         if(this.GN == null) {
            throw new IOException("No GoogleApiClient available");
         } else {
            Cast.CastApi.sendMessage(this.GN, var1, var2).setResultCallback(new RemoteMediaPlayer.a(var3));
         }
      }

      public void b(GoogleApiClient var1) {
         this.GN = var1;
      }

      public long fS() {
         long var1 = this.GO + 1L;
         this.GO = var1;
         return var1;
      }
   }

   private final class a implements ResultCallback {
      private final long GP;

      a(long var2) {
         this.GP = var2;
      }

      public void j(Status var1) {
         if(!var1.isSuccess()) {
            RemoteMediaPlayer.super.GA.Gw.b(this.GP, var1.getStatusCode());
         }

      }

      // $FF: synthetic method
      public void onResult(Result var1) {
         this.j((Status)var1);
      }
   }

   private abstract static class b extends Cast.a {
      iv GR = new iv() {
         public void a(long var1, int var3, JSONObject var4) {
            b.this.b(new RemoteMediaPlayer.c(new Status(var3), var4));
         }

         public void n(long var1) {
            b.this.b(b.this.k(new Status(2103)));
         }
      };

      b(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.k(var1);
      }

      public RemoteMediaPlayer.MediaChannelResult k(final Status var1) {
         return new RemoteMediaPlayer.MediaChannelResult() {
            public JSONObject getCustomData() {
               return null;
            }

            public Status getStatus() {
               return var1;
            }
         };
      }
   }

   private static final class c implements RemoteMediaPlayer.MediaChannelResult {
      private final Status Eb;
      private final JSONObject Ga;

      c(Status var1, JSONObject var2) {
         this.Eb = var1;
         this.Ga = var2;
      }

      public JSONObject getCustomData() {
         return this.Ga;
      }

      public Status getStatus() {
         return this.Eb;
      }
   }
}
