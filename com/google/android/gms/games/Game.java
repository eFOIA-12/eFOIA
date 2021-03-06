package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public interface Game extends Parcelable, Freezable {
   boolean areSnapshotsEnabled();

   int getAchievementTotalCount();

   String getApplicationId();

   String getDescription();

   void getDescription(CharArrayBuffer var1);

   String getDeveloperName();

   void getDeveloperName(CharArrayBuffer var1);

   String getDisplayName();

   void getDisplayName(CharArrayBuffer var1);

   Uri getFeaturedImageUri();

   @Deprecated
   String getFeaturedImageUrl();

   Uri getHiResImageUri();

   @Deprecated
   String getHiResImageUrl();

   Uri getIconImageUri();

   @Deprecated
   String getIconImageUrl();

   int getLeaderboardCount();

   String getPrimaryCategory();

   String getSecondaryCategory();

   String getThemeColor();

   boolean isMuted();

   boolean isRealTimeMultiplayerEnabled();

   boolean isTurnBasedMultiplayerEnabled();

   boolean kA();

   String kB();

   int kC();

   boolean ky();

   boolean kz();
}
