package com.google.android.gms.cast;

import com.google.android.gms.internal.in;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.li;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaTrack {
   public static final int SUBTYPE_CAPTIONS = 2;
   public static final int SUBTYPE_CHAPTERS = 4;
   public static final int SUBTYPE_DESCRIPTIONS = 3;
   public static final int SUBTYPE_METADATA = 5;
   public static final int SUBTYPE_NONE = 0;
   public static final int SUBTYPE_SUBTITLES = 1;
   public static final int SUBTYPE_UNKNOWN = -1;
   public static final int TYPE_AUDIO = 2;
   public static final int TYPE_TEXT = 1;
   public static final int TYPE_UNKNOWN = 0;
   public static final int TYPE_VIDEO = 3;
   private long Eg;
   private String FR;
   private String FT;
   private String FV;
   private JSONObject Ga;
   private int Gt;
   private int Gu;
   private String mName;

   MediaTrack(long var1, int var3) throws IllegalArgumentException {
      this.clear();
      this.Eg = var1;
      if(var3 > 0 && var3 <= 3) {
         this.Gt = var3;
      } else {
         throw new IllegalArgumentException("invalid type " + var3);
      }
   }

   MediaTrack(JSONObject var1) throws JSONException {
      this.c(var1);
   }

   private void c(JSONObject var1) throws JSONException {
      this.clear();
      this.Eg = var1.getLong("trackId");
      String var2 = var1.getString("type");
      if("TEXT".equals(var2)) {
         this.Gt = 1;
      } else if("AUDIO".equals(var2)) {
         this.Gt = 2;
      } else {
         if(!"VIDEO".equals(var2)) {
            throw new JSONException("invalid type: " + var2);
         }

         this.Gt = 3;
      }

      this.FT = var1.optString("trackContentId", (String)null);
      this.FV = var1.optString("trackContentType", (String)null);
      this.mName = var1.optString("name", (String)null);
      this.FR = var1.optString("language", (String)null);
      if(var1.has("subtype")) {
         var2 = var1.getString("subtype");
         if("SUBTITLES".equals(var2)) {
            this.Gu = 1;
         } else if("CAPTIONS".equals(var2)) {
            this.Gu = 2;
         } else if("DESCRIPTIONS".equals(var2)) {
            this.Gu = 3;
         } else if("CHAPTERS".equals(var2)) {
            this.Gu = 4;
         } else {
            if(!"METADATA".equals(var2)) {
               throw new JSONException("invalid subtype: " + var2);
            }

            this.Gu = 5;
         }
      } else {
         this.Gu = 0;
      }

      this.Ga = var1.optJSONObject("customData");
   }

   private void clear() {
      this.Eg = 0L;
      this.Gt = 0;
      this.FT = null;
      this.mName = null;
      this.FR = null;
      this.Gu = -1;
      this.Ga = null;
   }

   void ab(int var1) throws IllegalArgumentException {
      if(var1 > -1 && var1 <= 5) {
         if(var1 != 0 && this.Gt != 1) {
            throw new IllegalArgumentException("subtypes are only valid for text tracks");
         } else {
            this.Gu = var1;
         }
      } else {
         throw new IllegalArgumentException("invalid subtype " + var1);
      }
   }

   public boolean equals(Object var1) {
      boolean var5 = true;
      boolean var6 = false;
      boolean var4;
      if(this == var1) {
         var4 = true;
      } else {
         var4 = var6;
         if(var1 instanceof MediaTrack) {
            MediaTrack var7 = (MediaTrack)var1;
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

               if(this.Eg == var7.Eg && this.Gt == var7.Gt && in.a(this.FT, var7.FT) && in.a(this.FV, var7.FV) && in.a(this.mName, var7.mName) && in.a(this.FR, var7.FR) && this.Gu == var7.Gu) {
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

   public String getContentId() {
      return this.FT;
   }

   public String getContentType() {
      return this.FV;
   }

   public JSONObject getCustomData() {
      return this.Ga;
   }

   public long getId() {
      return this.Eg;
   }

   public String getLanguage() {
      return this.FR;
   }

   public String getName() {
      return this.mName;
   }

   public int getSubtype() {
      return this.Gu;
   }

   public int getType() {
      return this.Gt;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{Long.valueOf(this.Eg), Integer.valueOf(this.Gt), this.FT, this.FV, this.mName, this.FR, Integer.valueOf(this.Gu), this.Ga});
   }

   public void setContentId(String var1) {
      this.FT = var1;
   }

   public void setContentType(String var1) {
      this.FV = var1;
   }

   void setCustomData(JSONObject var1) {
      this.Ga = var1;
   }

   void setLanguage(String var1) {
      this.FR = var1;
   }

   void setName(String var1) {
      this.mName = var1;
   }

   public JSONObject toJson() {
      // $FF: Couldn't be decompiled
   }

   public static class Builder {
      private final MediaTrack Gv;

      public Builder(long var1, int var3) throws IllegalArgumentException {
         this.Gv = new MediaTrack(var1, var3);
      }

      public MediaTrack build() {
         return this.Gv;
      }

      public MediaTrack.Builder setContentId(String var1) {
         this.Gv.setContentId(var1);
         return this;
      }

      public MediaTrack.Builder setContentType(String var1) {
         this.Gv.setContentType(var1);
         return this;
      }

      public MediaTrack.Builder setCustomData(JSONObject var1) {
         this.Gv.setCustomData(var1);
         return this;
      }

      public MediaTrack.Builder setLanguage(String var1) {
         this.Gv.setLanguage(var1);
         return this;
      }

      public MediaTrack.Builder setLanguage(Locale var1) {
         this.Gv.setLanguage(in.b(var1));
         return this;
      }

      public MediaTrack.Builder setName(String var1) {
         this.Gv.setName(var1);
         return this;
      }

      public MediaTrack.Builder setSubtype(int var1) throws IllegalArgumentException {
         this.Gv.ab(var1);
         return this;
      }
   }
}
