package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;

public final class ParticipantRef extends d implements Participant {
   private final PlayerRef aeb;

   public ParticipantRef(DataHolder var1, int var2) {
      super(var1, var2);
      this.aeb = new PlayerRef(var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return ParticipantEntity.a(this, var1);
   }

   public Participant freeze() {
      return new ParticipantEntity(this);
   }

   public int getCapabilities() {
      return this.getInteger("capabilities");
   }

   public String getDisplayName() {
      return this.aS("external_player_id")?this.getString("default_display_name"):this.aeb.getDisplayName();
   }

   public void getDisplayName(CharArrayBuffer var1) {
      if(this.aS("external_player_id")) {
         this.a("default_display_name", var1);
      } else {
         this.aeb.getDisplayName(var1);
      }
   }

   public Uri getHiResImageUri() {
      return this.aS("external_player_id")?this.aR("default_display_hi_res_image_uri"):this.aeb.getHiResImageUri();
   }

   public String getHiResImageUrl() {
      return this.aS("external_player_id")?this.getString("default_display_hi_res_image_url"):this.aeb.getHiResImageUrl();
   }

   public Uri getIconImageUri() {
      return this.aS("external_player_id")?this.aR("default_display_image_uri"):this.aeb.getIconImageUri();
   }

   public String getIconImageUrl() {
      return this.aS("external_player_id")?this.getString("default_display_image_url"):this.aeb.getIconImageUrl();
   }

   public String getParticipantId() {
      return this.getString("external_participant_id");
   }

   public Player getPlayer() {
      return this.aS("external_player_id")?null:this.aeb;
   }

   public ParticipantResult getResult() {
      if(this.aS("result_type")) {
         return null;
      } else {
         int var1 = this.getInteger("result_type");
         int var2 = this.getInteger("placing");
         return new ParticipantResult(this.getParticipantId(), var1, var2);
      }
   }

   public int getStatus() {
      return this.getInteger("player_status");
   }

   public int hashCode() {
      return ParticipantEntity.a(this);
   }

   public boolean isConnectedToRoom() {
      return this.getInteger("connected") > 0;
   }

   public String le() {
      return this.getString("client_address");
   }

   public String toString() {
      return ParticipantEntity.b((Participant)this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((ParticipantEntity)this.freeze()).writeToParcel(var1, var2);
   }
}
