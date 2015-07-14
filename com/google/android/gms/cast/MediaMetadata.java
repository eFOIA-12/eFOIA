package com.google.android.gms.cast;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.internal.ix;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaMetadata {
   private static final String[] Gc = new String[]{null, "String", "int", "double", "ISO-8601 date String"};
   private static final MediaMetadata.a Gd = (new MediaMetadata.a()).a("com.google.android.gms.cast.metadata.CREATION_DATE", "creationDateTime", 4).a("com.google.android.gms.cast.metadata.RELEASE_DATE", "releaseDate", 4).a("com.google.android.gms.cast.metadata.BROADCAST_DATE", "originalAirdate", 4).a("com.google.android.gms.cast.metadata.TITLE", "title", 1).a("com.google.android.gms.cast.metadata.SUBTITLE", "subtitle", 1).a("com.google.android.gms.cast.metadata.ARTIST", "artist", 1).a("com.google.android.gms.cast.metadata.ALBUM_ARTIST", "albumArtist", 1).a("com.google.android.gms.cast.metadata.ALBUM_TITLE", "albumName", 1).a("com.google.android.gms.cast.metadata.COMPOSER", "composer", 1).a("com.google.android.gms.cast.metadata.DISC_NUMBER", "discNumber", 2).a("com.google.android.gms.cast.metadata.TRACK_NUMBER", "trackNumber", 2).a("com.google.android.gms.cast.metadata.SEASON_NUMBER", "season", 2).a("com.google.android.gms.cast.metadata.EPISODE_NUMBER", "episode", 2).a("com.google.android.gms.cast.metadata.SERIES_TITLE", "seriesTitle", 1).a("com.google.android.gms.cast.metadata.STUDIO", "studio", 1).a("com.google.android.gms.cast.metadata.WIDTH", "width", 2).a("com.google.android.gms.cast.metadata.HEIGHT", "height", 2).a("com.google.android.gms.cast.metadata.LOCATION_NAME", "location", 1).a("com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "latitude", 3).a("com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "longitude", 3);
   public static final String KEY_ALBUM_ARTIST = "com.google.android.gms.cast.metadata.ALBUM_ARTIST";
   public static final String KEY_ALBUM_TITLE = "com.google.android.gms.cast.metadata.ALBUM_TITLE";
   public static final String KEY_ARTIST = "com.google.android.gms.cast.metadata.ARTIST";
   public static final String KEY_BROADCAST_DATE = "com.google.android.gms.cast.metadata.BROADCAST_DATE";
   public static final String KEY_COMPOSER = "com.google.android.gms.cast.metadata.COMPOSER";
   public static final String KEY_CREATION_DATE = "com.google.android.gms.cast.metadata.CREATION_DATE";
   public static final String KEY_DISC_NUMBER = "com.google.android.gms.cast.metadata.DISC_NUMBER";
   public static final String KEY_EPISODE_NUMBER = "com.google.android.gms.cast.metadata.EPISODE_NUMBER";
   public static final String KEY_HEIGHT = "com.google.android.gms.cast.metadata.HEIGHT";
   public static final String KEY_LOCATION_LATITUDE = "com.google.android.gms.cast.metadata.LOCATION_LATITUDE";
   public static final String KEY_LOCATION_LONGITUDE = "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE";
   public static final String KEY_LOCATION_NAME = "com.google.android.gms.cast.metadata.LOCATION_NAME";
   public static final String KEY_RELEASE_DATE = "com.google.android.gms.cast.metadata.RELEASE_DATE";
   public static final String KEY_SEASON_NUMBER = "com.google.android.gms.cast.metadata.SEASON_NUMBER";
   public static final String KEY_SERIES_TITLE = "com.google.android.gms.cast.metadata.SERIES_TITLE";
   public static final String KEY_STUDIO = "com.google.android.gms.cast.metadata.STUDIO";
   public static final String KEY_SUBTITLE = "com.google.android.gms.cast.metadata.SUBTITLE";
   public static final String KEY_TITLE = "com.google.android.gms.cast.metadata.TITLE";
   public static final String KEY_TRACK_NUMBER = "com.google.android.gms.cast.metadata.TRACK_NUMBER";
   public static final String KEY_WIDTH = "com.google.android.gms.cast.metadata.WIDTH";
   public static final int MEDIA_TYPE_GENERIC = 0;
   public static final int MEDIA_TYPE_MOVIE = 1;
   public static final int MEDIA_TYPE_MUSIC_TRACK = 3;
   public static final int MEDIA_TYPE_PHOTO = 4;
   public static final int MEDIA_TYPE_TV_SHOW = 2;
   public static final int MEDIA_TYPE_USER = 100;
   private final List Fp;
   private final Bundle Ge;
   private int Gf;

   public MediaMetadata() {
      this(0);
   }

   public MediaMetadata(int var1) {
      this.Fp = new ArrayList();
      this.Ge = new Bundle();
      this.Gf = var1;
   }

   private void a(JSONObject param1, String... param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean a(Bundle var1, Bundle var2) {
      if(var1.size() != var2.size()) {
         return false;
      } else {
         Iterator var3 = var1.keySet().iterator();

         String var4;
         Object var6;
         label37:
         do {
            Object var5;
            do {
               if(!var3.hasNext()) {
                  return true;
               }

               var4 = (String)var3.next();
               var5 = var1.get(var4);
               var6 = var2.get(var4);
               if(var5 instanceof Bundle && var6 instanceof Bundle && !this.a((Bundle)var5, (Bundle)var6)) {
                  return false;
               }

               if(var5 == null) {
                  continue label37;
               }
            } while(var5.equals(var6));

            return false;
         } while(var6 == null && var2.containsKey(var4));

         return false;
      }
   }

   private void b(JSONObject param1, String... param2) {
      // $FF: Couldn't be decompiled
   }

   private void f(String var1, int var2) throws IllegalArgumentException {
      if(TextUtils.isEmpty(var1)) {
         throw new IllegalArgumentException("null and empty keys are not allowed");
      } else {
         int var3 = Gd.aB(var1);
         if(var3 != var2 && var3 != 0) {
            throw new IllegalArgumentException("Value for " + var1 + " must be a " + Gc[var2]);
         }
      }
   }

   public void addImage(WebImage var1) {
      this.Fp.add(var1);
   }

   public void c(JSONObject var1) {
      this.clear();
      this.Gf = 0;

      try {
         this.Gf = var1.getInt("metadataType");
      } catch (JSONException var3) {
         ;
      }

      ix.a(this.Fp, var1);
      switch(this.Gf) {
      case 0:
         this.b(var1, new String[]{"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE"});
         return;
      case 1:
         this.b(var1, new String[]{"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.STUDIO", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE"});
         return;
      case 2:
         this.b(var1, new String[]{"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.SERIES_TITLE", "com.google.android.gms.cast.metadata.SEASON_NUMBER", "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "com.google.android.gms.cast.metadata.BROADCAST_DATE"});
         return;
      case 3:
         this.b(var1, new String[]{"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ALBUM_TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "com.google.android.gms.cast.metadata.COMPOSER", "com.google.android.gms.cast.metadata.TRACK_NUMBER", "com.google.android.gms.cast.metadata.DISC_NUMBER", "com.google.android.gms.cast.metadata.RELEASE_DATE"});
         return;
      case 4:
         this.b(var1, new String[]{"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.LOCATION_NAME", "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "com.google.android.gms.cast.metadata.WIDTH", "com.google.android.gms.cast.metadata.HEIGHT", "com.google.android.gms.cast.metadata.CREATION_DATE"});
         return;
      default:
         this.b(var1, new String[0]);
      }
   }

   public void clear() {
      this.Ge.clear();
      this.Fp.clear();
   }

   public void clearImages() {
      this.Fp.clear();
   }

   public boolean containsKey(String var1) {
      return this.Ge.containsKey(var1);
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof MediaMetadata)) {
            return false;
         }

         MediaMetadata var2 = (MediaMetadata)var1;
         if(!this.a(this.Ge, var2.Ge) || !this.Fp.equals(var2.Fp)) {
            return false;
         }
      }

      return true;
   }

   public Calendar getDate(String var1) {
      this.f(var1, 4);
      var1 = this.Ge.getString(var1);
      return var1 != null?ix.aL(var1):null;
   }

   public String getDateAsString(String var1) {
      this.f(var1, 4);
      return this.Ge.getString(var1);
   }

   public double getDouble(String var1) {
      this.f(var1, 3);
      return this.Ge.getDouble(var1);
   }

   public List getImages() {
      return this.Fp;
   }

   public int getInt(String var1) {
      this.f(var1, 2);
      return this.Ge.getInt(var1);
   }

   public int getMediaType() {
      return this.Gf;
   }

   public String getString(String var1) {
      this.f(var1, 1);
      return this.Ge.getString(var1);
   }

   public boolean hasImages() {
      return this.Fp != null && !this.Fp.isEmpty();
   }

   public int hashCode() {
      Iterator var2 = this.Ge.keySet().iterator();

      int var1;
      String var3;
      for(var1 = 17; var2.hasNext(); var1 = this.Ge.get(var3).hashCode() + var1 * 31) {
         var3 = (String)var2.next();
      }

      return var1 * 31 + this.Fp.hashCode();
   }

   public Set keySet() {
      return this.Ge.keySet();
   }

   public void putDate(String var1, Calendar var2) {
      this.f(var1, 4);
      this.Ge.putString(var1, ix.a(var2));
   }

   public void putDouble(String var1, double var2) {
      this.f(var1, 3);
      this.Ge.putDouble(var1, var2);
   }

   public void putInt(String var1, int var2) {
      this.f(var1, 2);
      this.Ge.putInt(var1, var2);
   }

   public void putString(String var1, String var2) {
      this.f(var1, 1);
      this.Ge.putString(var1, var2);
   }

   public JSONObject toJson() {
      JSONObject var1 = new JSONObject();

      try {
         var1.put("metadataType", this.Gf);
      } catch (JSONException var3) {
         ;
      }

      ix.a(var1, this.Fp);
      switch(this.Gf) {
      case 0:
         this.a(var1, new String[]{"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE"});
         return var1;
      case 1:
         this.a(var1, new String[]{"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.STUDIO", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE"});
         return var1;
      case 2:
         this.a(var1, new String[]{"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.SERIES_TITLE", "com.google.android.gms.cast.metadata.SEASON_NUMBER", "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "com.google.android.gms.cast.metadata.BROADCAST_DATE"});
         return var1;
      case 3:
         this.a(var1, new String[]{"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.ALBUM_TITLE", "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "com.google.android.gms.cast.metadata.COMPOSER", "com.google.android.gms.cast.metadata.TRACK_NUMBER", "com.google.android.gms.cast.metadata.DISC_NUMBER", "com.google.android.gms.cast.metadata.RELEASE_DATE"});
         return var1;
      case 4:
         this.a(var1, new String[]{"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.LOCATION_NAME", "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "com.google.android.gms.cast.metadata.WIDTH", "com.google.android.gms.cast.metadata.HEIGHT", "com.google.android.gms.cast.metadata.CREATION_DATE"});
         return var1;
      default:
         this.a(var1, new String[0]);
         return var1;
      }
   }

   private static class a {
      private final Map Gg = new HashMap();
      private final Map Gh = new HashMap();
      private final Map Gi = new HashMap();

      public MediaMetadata.a a(String var1, String var2, int var3) {
         this.Gg.put(var1, var2);
         this.Gh.put(var2, var1);
         this.Gi.put(var1, Integer.valueOf(var3));
         return this;
      }

      public String aA(String var1) {
         return (String)this.Gh.get(var1);
      }

      public int aB(String var1) {
         Integer var2 = (Integer)this.Gi.get(var1);
         return var2 != null?var2.intValue():0;
      }

      public String az(String var1) {
         return (String)this.Gg.get(var1);
      }
   }
}
