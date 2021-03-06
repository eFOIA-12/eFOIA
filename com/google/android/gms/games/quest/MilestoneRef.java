package com.google.android.gms.games.quest;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.MilestoneEntity;

public final class MilestoneRef extends d implements Milestone {
   MilestoneRef(DataHolder var1, int var2) {
      super(var1, var2);
   }

   private long mP() {
      return this.getLong("initial_value");
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return MilestoneEntity.a(this, var1);
   }

   public Milestone freeze() {
      return new MilestoneEntity(this);
   }

   public byte[] getCompletionRewardData() {
      return this.getByteArray("completion_reward_data");
   }

   public long getCurrentProgress() {
      switch(this.getState()) {
      case 1:
      default:
         return 0L;
      case 2:
         return this.getLong("current_value") - this.mP();
      case 3:
      case 4:
         return this.getTargetProgress();
      }
   }

   public String getEventId() {
      return this.getString("external_event_id");
   }

   public String getMilestoneId() {
      return this.getString("external_milestone_id");
   }

   public int getState() {
      return this.getInteger("milestone_state");
   }

   public long getTargetProgress() {
      return this.getLong("target_value");
   }

   public int hashCode() {
      return MilestoneEntity.a(this);
   }

   public String toString() {
      return MilestoneEntity.b(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((MilestoneEntity)this.freeze()).writeToParcel(var1, var2);
   }
}
