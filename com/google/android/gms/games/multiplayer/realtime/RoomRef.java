package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantRef;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import java.util.ArrayList;

public final class RoomRef extends d implements Room {
   private final int Ya;

   RoomRef(DataHolder var1, int var2, int var3) {
      super(var1, var2);
      this.Ya = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return RoomEntity.a(this, (Object)var1);
   }

   public Room freeze() {
      return new RoomEntity(this);
   }

   public Bundle getAutoMatchCriteria() {
      return !this.getBoolean("has_automatch_criteria")?null:RoomConfig.createAutoMatchCriteria(this.getInteger("automatch_min_players"), this.getInteger("automatch_max_players"), this.getLong("automatch_bit_mask"));
   }

   public int getAutoMatchWaitEstimateSeconds() {
      return this.getInteger("automatch_wait_estimate_sec");
   }

   public long getCreationTimestamp() {
      return this.getLong("creation_timestamp");
   }

   public String getCreatorId() {
      return this.getString("creator_external");
   }

   public String getDescription() {
      return this.getString("description");
   }

   public void getDescription(CharArrayBuffer var1) {
      this.a("description", var1);
   }

   public Participant getParticipant(String var1) {
      return RoomEntity.c(this, var1);
   }

   public String getParticipantId(String var1) {
      return RoomEntity.b(this, var1);
   }

   public ArrayList getParticipantIds() {
      return RoomEntity.c(this);
   }

   public int getParticipantStatus(String var1) {
      return RoomEntity.a(this, (String)var1);
   }

   public ArrayList getParticipants() {
      ArrayList var2 = new ArrayList(this.Ya);

      for(int var1 = 0; var1 < this.Ya; ++var1) {
         var2.add(new ParticipantRef(this.JG, this.KZ + var1));
      }

      return var2;
   }

   public String getRoomId() {
      return this.getString("external_match_id");
   }

   public int getStatus() {
      return this.getInteger("status");
   }

   public int getVariant() {
      return this.getInteger("variant");
   }

   public int hashCode() {
      return RoomEntity.a(this);
   }

   public String toString() {
      return RoomEntity.b((Room)this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((RoomEntity)this.freeze()).writeToParcel(var1, var2);
   }
}
