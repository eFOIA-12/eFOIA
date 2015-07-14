package com.androidquery.util;

import android.os.Build.VERSION;

public interface Constants {
   String ACTIVE_ACCOUNT = "aq.account";
   float ANCHOR_DYNAMIC = Float.MAX_VALUE;
   String AUTH_ANALYTICS = "g.analytics";
   String AUTH_BLOGGER = "g.blogger";
   String AUTH_CALENDAR = "g.cl";
   String AUTH_CONTACTS = "g.cp";
   String AUTH_DOC_LIST = "g.writely";
   String AUTH_MAPS = "g.local";
   String AUTH_PICASA = "g.lh2";
   String AUTH_READER = "g.reader";
   String AUTH_SPREADSHEETS = "g.wise";
   String AUTH_YOUTUBE = "g.youtube";
   int CACHE_DEFAULT = 0;
   int CACHE_PERSISTENT = 1;
   int FADE_IN = -1;
   int FADE_IN_FILE = -3;
   int FADE_IN_NETWORK = -2;
   int FLAG_ACTIVITY_NO_ANIMATION = 65536;
   int FLAG_HARDWARE_ACCELERATED = 16777216;
   int GONE = -2;
   int INVISIBLE = -1;
   int LAYER_TYPE_HARDWARE = 2;
   int LAYER_TYPE_SOFTWARE = 1;
   int METHOD_DELETE = 2;
   int METHOD_DETECT = 4;
   int METHOD_GET = 0;
   int METHOD_POST = 1;
   int METHOD_PUT = 3;
   int OVER_SCROLL_ALWAYS = 0;
   int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
   int OVER_SCROLL_NEVER = 2;
   String POST_ENTITY = "%entity";
   int PRESET = -3;
   float RATIO_PRESERVE = Float.MAX_VALUE;
   int SDK_INT;
   int TAG_1 = 1090453509;
   int TAG_2 = 1090453510;
   int TAG_3 = 1090453511;
   int TAG_4 = 1090453512;
   int TAG_5 = 1090453513;
   int TAG_LAYOUT = 1090453507;
   int TAG_NUM = 1090453508;
   int TAG_SCROLL_LISTENER = 1090453506;
   int TAG_URL = 1090453505;
   String VERSION = "0.26.9";

   static default {
      SDK_INT = VERSION.SDK_INT;
   }
}
