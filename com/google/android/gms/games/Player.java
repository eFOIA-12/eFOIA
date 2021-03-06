package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.PlayerLevelInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;

public interface Player extends Parcelable, Freezable {
   long CURRENT_XP_UNKNOWN = -1L;
   long TIMESTAMP_UNKNOWN = -1L;

   String getDisplayName();

   void getDisplayName(CharArrayBuffer var1);

   Uri getHiResImageUri();

   @Deprecated
   String getHiResImageUrl();

   Uri getIconImageUri();

   @Deprecated
   String getIconImageUrl();

   long getLastPlayedWithTimestamp();

   PlayerLevelInfo getLevelInfo();

   String getPlayerId();

   long getRetrievedTimestamp();

   String getTitle();

   void getTitle(CharArrayBuffer var1);

   boolean hasHiResImage();

   boolean hasIconImage();

   boolean isProfileVisible();

   int kE();

   MostRecentGameInfo kF();
}
