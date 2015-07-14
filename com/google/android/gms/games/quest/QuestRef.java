package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.MilestoneRef;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestEntity;
import java.util.ArrayList;
import java.util.List;

public final class QuestRef extends d implements Quest {
   private final int Ya;
   private final Game adq;

   QuestRef(DataHolder var1, int var2, int var3) {
      super(var1, var2);
      this.adq = new GameRef(var1, var2);
      this.Ya = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return QuestEntity.a(this, var1);
   }

   public Quest freeze() {
      return new QuestEntity(this);
   }

   public long getAcceptedTimestamp() {
      return this.getLong("accepted_ts");
   }

   public Uri getBannerImageUri() {
      return this.aR("quest_banner_image_uri");
   }

   public String getBannerImageUrl() {
      return this.getString("quest_banner_image_url");
   }

   public Milestone getCurrentMilestone() {
      return (Milestone)this.mQ().get(0);
   }

   public String getDescription() {
      return this.getString("quest_description");
   }

   public void getDescription(CharArrayBuffer var1) {
      this.a("quest_description", var1);
   }

   public long getEndTimestamp() {
      return this.getLong("quest_end_ts");
   }

   public Game getGame() {
      return this.adq;
   }

   public Uri getIconImageUri() {
      return this.aR("quest_icon_image_uri");
   }

   public String getIconImageUrl() {
      return this.getString("quest_icon_image_url");
   }

   public long getLastUpdatedTimestamp() {
      return this.getLong("quest_last_updated_ts");
   }

   public String getName() {
      return this.getString("quest_name");
   }

   public void getName(CharArrayBuffer var1) {
      this.a("quest_name", var1);
   }

   public String getQuestId() {
      return this.getString("external_quest_id");
   }

   public long getStartTimestamp() {
      return this.getLong("quest_start_ts");
   }

   public int getState() {
      return this.getInteger("quest_state");
   }

   public int getType() {
      return this.getInteger("quest_type");
   }

   public int hashCode() {
      return QuestEntity.a(this);
   }

   public boolean isEndingSoon() {
      return this.mR() <= System.currentTimeMillis() + 1800000L;
   }

   public List mQ() {
      ArrayList var2 = new ArrayList(this.Ya);

      for(int var1 = 0; var1 < this.Ya; ++var1) {
         var2.add(new MilestoneRef(this.JG, this.KZ + var1));
      }

      return var2;
   }

   public long mR() {
      return this.getLong("notification_ts");
   }

   public String toString() {
      return QuestEntity.b(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((QuestEntity)this.freeze()).writeToParcel(var1, var2);
   }
}
