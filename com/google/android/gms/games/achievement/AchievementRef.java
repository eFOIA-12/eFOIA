package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.games.achievement.Achievement;
import com.google.android.gms.games.achievement.AchievementEntity;
import com.google.android.gms.internal.je;

public final class AchievementRef extends d implements Achievement {
   AchievementRef(DataHolder var1, int var2) {
      super(var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public Achievement freeze() {
      return new AchievementEntity(this);
   }

   public String getAchievementId() {
      return this.getString("external_achievement_id");
   }

   public int getCurrentSteps() {
      boolean var1 = true;
      if(this.getType() != 1) {
         var1 = false;
      }

      je.K(var1);
      return this.getInteger("current_steps");
   }

   public String getDescription() {
      return this.getString("description");
   }

   public void getDescription(CharArrayBuffer var1) {
      this.a("description", var1);
   }

   public String getFormattedCurrentSteps() {
      boolean var1 = true;
      if(this.getType() != 1) {
         var1 = false;
      }

      je.K(var1);
      return this.getString("formatted_current_steps");
   }

   public void getFormattedCurrentSteps(CharArrayBuffer var1) {
      boolean var2 = true;
      if(this.getType() != 1) {
         var2 = false;
      }

      je.K(var2);
      this.a("formatted_current_steps", var1);
   }

   public String getFormattedTotalSteps() {
      boolean var1 = true;
      if(this.getType() != 1) {
         var1 = false;
      }

      je.K(var1);
      return this.getString("formatted_total_steps");
   }

   public void getFormattedTotalSteps(CharArrayBuffer var1) {
      boolean var2 = true;
      if(this.getType() != 1) {
         var2 = false;
      }

      je.K(var2);
      this.a("formatted_total_steps", var1);
   }

   public long getLastUpdatedTimestamp() {
      return this.getLong("last_updated_timestamp");
   }

   public String getName() {
      return this.getString("name");
   }

   public void getName(CharArrayBuffer var1) {
      this.a("name", var1);
   }

   public Player getPlayer() {
      return new PlayerRef(this.JG, this.KZ);
   }

   public Uri getRevealedImageUri() {
      return this.aR("revealed_icon_image_uri");
   }

   public String getRevealedImageUrl() {
      return this.getString("revealed_icon_image_url");
   }

   public int getState() {
      return this.getInteger("state");
   }

   public int getTotalSteps() {
      boolean var1 = true;
      if(this.getType() != 1) {
         var1 = false;
      }

      je.K(var1);
      return this.getInteger("total_steps");
   }

   public int getType() {
      return this.getInteger("type");
   }

   public Uri getUnlockedImageUri() {
      return this.aR("unlocked_icon_image_uri");
   }

   public String getUnlockedImageUrl() {
      return this.getString("unlocked_icon_image_url");
   }

   public long getXpValue() {
      return this.aQ("instance_xp_value") && !this.aS("instance_xp_value")?this.getLong("instance_xp_value"):this.getLong("definition_xp_value");
   }

   public String toString() {
      return AchievementEntity.b(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((AchievementEntity)this.freeze()).writeToParcel(var1, var2);
   }
}
