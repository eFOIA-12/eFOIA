package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.internal.in;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.li;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaInfo {
   public static final int STREAM_TYPE_BUFFERED = 1;
   public static final int STREAM_TYPE_INVALID = -1;
   public static final int STREAM_TYPE_LIVE = 2;
   public static final int STREAM_TYPE_NONE = 0;
   public static final long UNKNOWN_DURATION = -1L;
   private final String FT;
   private int FU;
   private String FV;
   private MediaMetadata FW;
   private long FX;
   private List FY;
   private TextTrackStyle FZ;
   private JSONObject Ga;

   MediaInfo(String var1) throws IllegalArgumentException {
      if(TextUtils.isEmpty(var1)) {
         throw new IllegalArgumentException("content ID cannot be null or empty");
      } else {
         this.FT = var1;
         this.FU = -1;
      }
   }

   MediaInfo(JSONObject var1) throws JSONException {
      int var4 = 0;
      super();
      this.FT = var1.getString("contentId");
      String var5 = var1.getString("streamType");
      if("NONE".equals(var5)) {
         this.FU = 0;
      } else if("BUFFERED".equals(var5)) {
         this.FU = 1;
      } else if("LIVE".equals(var5)) {
         this.FU = 2;
      } else {
         this.FU = -1;
      }

      this.FV = var1.getString("contentType");
      JSONObject var7;
      if(var1.has("metadata")) {
         var7 = var1.getJSONObject("metadata");
         this.FW = new MediaMetadata(var7.getInt("metadataType"));
         this.FW.c(var7);
      }

      this.FX = -1L;
      if(var1.has("duration") && !var1.isNull("duration")) {
         double var2 = var1.optDouble("duration", 0.0D);
         if(!Double.isNaN(var2) && !Double.isInfinite(var2)) {
            this.FX = in.b(var2);
         }
      }

      if(var1.has("tracks")) {
         this.FY = new ArrayList();

         for(JSONArray var8 = var1.getJSONArray("tracks"); var4 < var8.length(); ++var4) {
            MediaTrack var6 = new MediaTrack(var8.getJSONObject(var4));
            this.FY.add(var6);
         }
      } else {
         this.FY = null;
      }

      if(var1.has("textTrackStyle")) {
         var7 = var1.getJSONObject("textTrackStyle");
         TextTrackStyle var9 = new TextTrackStyle();
         var9.c(var7);
         this.FZ = var9;
      } else {
         this.FZ = null;
      }

      this.Ga = var1.optJSONObject("customData");
   }

   void a(MediaMetadata var1) {
      this.FW = var1;
   }

   void d(List var1) {
      this.FY = var1;
   }

   public boolean equals(Object var1) {
      boolean var5 = true;
      boolean var6 = false;
      boolean var4;
      if(this == var1) {
         var4 = true;
      } else {
         var4 = var6;
         if(var1 instanceof MediaInfo) {
            MediaInfo var7 = (MediaInfo)var1;
            boolean var2;
            if(this.Ga == null) {
               var2 = true;
            } else {
               var2 = false;
            }

            boolean var3;
            if(var7.Ga == null) {
               var3 = true;
            } else {
               var3 = false;
            }

            var4 = var6;
            if(var2 == var3) {
               if(this.Ga != null && var7.Ga != null) {
                  var4 = var6;
                  if(!li.d(this.Ga, var7.Ga)) {
                     return var4;
                  }
               }

               if(in.a(this.FT, var7.FT) && this.FU == var7.FU && in.a(this.FV, var7.FV) && in.a(this.FW, var7.FW) && this.FX == var7.FX) {
                  var4 = var5;
               } else {
                  var4 = false;
               }

               return var4;
            }
         }
      }

      return var4;
   }

   void fQ() throws IllegalArgumentException {
      if(TextUtils.isEmpty(this.FT)) {
         throw new IllegalArgumentException("content ID cannot be null or empty");
      } else if(TextUtils.isEmpty(this.FV)) {
         throw new IllegalArgumentException("content type cannot be null or empty");
      } else if(this.FU == -1) {
         throw new IllegalArgumentException("a valid stream type must be specified");
      }
   }

   public String getContentId() {
      return this.FT;
   }

   public String getContentType() {
      return this.FV;
   }

   public JSONObject getCustomData() {
      return this.Ga;
   }

   public List getMediaTracks() {
      return this.FY;
   }

   public MediaMetadata getMetadata() {
      return this.FW;
   }

   public long getStreamDuration() {
      return this.FX;
   }

   public int getStreamType() {
      return this.FU;
   }

   public TextTrackStyle getTextTrackStyle() {
      return this.FZ;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.FT, Integer.valueOf(this.FU), this.FV, this.FW, Long.valueOf(this.FX), String.valueOf(this.Ga)});
   }

   void m(long var1) throws IllegalArgumentException {
      if(var1 < 0L) {
         throw new IllegalArgumentException("Stream duration cannot be negative");
      } else {
         this.FX = var1;
      }
   }

   void setContentType(String var1) throws IllegalArgumentException {
      if(TextUtils.isEmpty(var1)) {
         throw new IllegalArgumentException("content type cannot be null or empty");
      } else {
         this.FV = var1;
      }
   }

   void setCustomData(JSONObject var1) {
      this.Ga = var1;
   }

   void setStreamType(int var1) throws IllegalArgumentException {
      if(var1 >= -1 && var1 <= 2) {
         this.FU = var1;
      } else {
         throw new IllegalArgumentException("invalid stream type");
      }
   }

   public void setTextTrackStyle(TextTrackStyle var1) {
      this.FZ = var1;
   }

   public JSONObject toJson() {
      // $FF: Couldn't be decompiled
   }

   public static class Builder {
      private final MediaInfo Gb;

      public Builder(String var1) throws IllegalArgumentException {
         if(TextUtils.isEmpty(var1)) {
            throw new IllegalArgumentException("Content ID cannot be empty");
         } else {
            this.Gb = new MediaInfo(var1);
         }
      }

      public MediaInfo build() throws IllegalArgumentException {
         this.Gb.fQ();
         return this.Gb;
      }

      public MediaInfo.Builder setContentType(String var1) throws IllegalArgumentException {
         this.Gb.setContentType(var1);
         return this;
      }

      public MediaInfo.Builder setCustomData(JSONObject var1) {
         this.Gb.setCustomData(var1);
         return this;
      }

      public MediaInfo.Builder setMediaTracks(List var1) {
         this.Gb.d(var1);
         return this;
      }

      public MediaInfo.Builder setMetadata(MediaMetadata var1) {
         this.Gb.a(var1);
         return this;
      }

      public MediaInfo.Builder setStreamDuration(long var1) throws IllegalArgumentException {
         this.Gb.m(var1);
         return this;
      }

      public MediaInfo.Builder setStreamType(int var1) throws IllegalArgumentException {
         this.Gb.setStreamType(var1);
         return this;
      }

      public MediaInfo.Builder setTextTrackStyle(TextTrackStyle var1) {
         this.Gb.setTextTrackStyle(var1);
         return this;
      }
   }
}
