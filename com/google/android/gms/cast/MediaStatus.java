package com.google.android.gms.cast;

import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.internal.in;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaStatus {
   public static final long COMMAND_PAUSE = 1L;
   public static final long COMMAND_SEEK = 2L;
   public static final long COMMAND_SET_VOLUME = 4L;
   public static final long COMMAND_SKIP_BACKWARD = 32L;
   public static final long COMMAND_SKIP_FORWARD = 16L;
   public static final long COMMAND_TOGGLE_MUTE = 8L;
   private static final long[] Gs = new long[0];
   public static final int IDLE_REASON_CANCELED = 2;
   public static final int IDLE_REASON_ERROR = 4;
   public static final int IDLE_REASON_FINISHED = 1;
   public static final int IDLE_REASON_INTERRUPTED = 3;
   public static final int IDLE_REASON_NONE = 0;
   public static final int PLAYER_STATE_BUFFERING = 4;
   public static final int PLAYER_STATE_IDLE = 1;
   public static final int PLAYER_STATE_PAUSED = 3;
   public static final int PLAYER_STATE_PLAYING = 2;
   public static final int PLAYER_STATE_UNKNOWN = 0;
   private JSONObject Ga;
   private MediaInfo Gb;
   private long Gj;
   private double Gk;
   private int Gl;
   private int Gm;
   private long Gn;
   private long Go;
   private double Gp;
   private boolean Gq;
   private long[] Gr;

   public MediaStatus(JSONObject var1) throws JSONException {
      this.a(var1, 0);
   }

   public int a(JSONObject var1, int var2) throws JSONException {
      byte var11 = 2;
      boolean var10 = false;
      boolean var9 = true;
      long var12 = var1.getLong("mediaSessionId");
      byte var6;
      if(var12 != this.Gj) {
         this.Gj = var12;
         var6 = 1;
      } else {
         var6 = 0;
      }

      int var7 = var6;
      if(var1.has("playerState")) {
         String var15 = var1.getString("playerState");
         byte var5;
         if(var15.equals("IDLE")) {
            var5 = 1;
         } else if(var15.equals("PLAYING")) {
            var5 = 2;
         } else if(var15.equals("PAUSED")) {
            var5 = 3;
         } else if(var15.equals("BUFFERING")) {
            var5 = 4;
         } else {
            var5 = 0;
         }

         int var8 = var6;
         if(var5 != this.Gl) {
            this.Gl = var5;
            var8 = var6 | 2;
         }

         var7 = var8;
         if(var5 == 1) {
            var7 = var8;
            if(var1.has("idleReason")) {
               var15 = var1.getString("idleReason");
               if(var15.equals("CANCELLED")) {
                  var5 = var11;
               } else if(var15.equals("INTERRUPTED")) {
                  var5 = 3;
               } else if(var15.equals("FINISHED")) {
                  var5 = 1;
               } else if(var15.equals("ERROR")) {
                  var5 = 4;
               } else {
                  var5 = 0;
               }

               var7 = var8;
               if(var5 != this.Gm) {
                  this.Gm = var5;
                  var7 = var8 | 2;
               }
            }
         }
      }

      int var19 = var7;
      double var3;
      if(var1.has("playbackRate")) {
         var3 = var1.getDouble("playbackRate");
         var19 = var7;
         if(this.Gk != var3) {
            this.Gk = var3;
            var19 = var7 | 2;
         }
      }

      var7 = var19;
      if(var1.has("currentTime")) {
         var7 = var19;
         if((var2 & 2) == 0) {
            var12 = in.b(var1.getDouble("currentTime"));
            var7 = var19;
            if(var12 != this.Gn) {
               this.Gn = var12;
               var7 = var19 | 2;
            }
         }
      }

      int var18 = var7;
      if(var1.has("supportedMediaCommands")) {
         var12 = var1.getLong("supportedMediaCommands");
         var18 = var7;
         if(var12 != this.Go) {
            this.Go = var12;
            var18 = var7 | 2;
         }
      }

      var19 = var18;
      if(var1.has("volume")) {
         var19 = var18;
         if((var2 & 1) == 0) {
            JSONObject var21 = var1.getJSONObject("volume");
            var3 = var21.getDouble("level");
            var2 = var18;
            if(var3 != this.Gp) {
               this.Gp = var3;
               var2 = var18 | 2;
            }

            boolean var14 = var21.getBoolean("muted");
            var19 = var2;
            if(var14 != this.Gq) {
               this.Gq = var14;
               var19 = var2 | 2;
            }
         }
      }

      boolean var20;
      long[] var22;
      if(var1.has("activeTrackIds")) {
         JSONArray var16 = var1.getJSONArray("activeTrackIds");
         var7 = var16.length();
         var22 = new long[var7];

         for(var2 = 0; var2 < var7; ++var2) {
            var22[var2] = var16.getLong(var2);
         }

         boolean var17;
         if(this.Gr == null) {
            var17 = var9;
         } else {
            var17 = var9;
            if(this.Gr.length == var7) {
               var18 = 0;

               while(true) {
                  if(var18 >= var7) {
                     var17 = false;
                     break;
                  }

                  var17 = var9;
                  if(this.Gr[var18] != var22[var18]) {
                     break;
                  }

                  ++var18;
               }
            }
         }

         if(var17) {
            this.Gr = var22;
         }

         var20 = var17;
      } else if(this.Gr != null) {
         var20 = true;
         var22 = null;
      } else {
         var22 = null;
         var20 = var10;
      }

      var2 = var19;
      if(var20) {
         this.Gr = var22;
         var2 = var19 | 2;
      }

      var19 = var2;
      if(var1.has("customData")) {
         this.Ga = var1.getJSONObject("customData");
         var19 = var2 | 2;
      }

      var2 = var19;
      if(var1.has("media")) {
         var1 = var1.getJSONObject("media");
         this.Gb = new MediaInfo(var1);
         var19 |= 2;
         var2 = var19;
         if(var1.has("metadata")) {
            var2 = var19 | 4;
         }
      }

      return var2;
   }

   public long fR() {
      return this.Gj;
   }

   public long[] getActiveTrackIds() {
      return this.Gr != null?this.Gr:Gs;
   }

   public JSONObject getCustomData() {
      return this.Ga;
   }

   public int getIdleReason() {
      return this.Gm;
   }

   public MediaInfo getMediaInfo() {
      return this.Gb;
   }

   public double getPlaybackRate() {
      return this.Gk;
   }

   public int getPlayerState() {
      return this.Gl;
   }

   public long getStreamPosition() {
      return this.Gn;
   }

   public double getStreamVolume() {
      return this.Gp;
   }

   public boolean isMediaCommandSupported(long var1) {
      return (this.Go & var1) != 0L;
   }

   public boolean isMute() {
      return this.Gq;
   }
}
