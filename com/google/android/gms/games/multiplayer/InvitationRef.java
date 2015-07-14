package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantRef;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;

public final class InvitationRef extends d implements Invitation {
   private final ArrayList adV;
   private final ParticipantRef adY;
   private final Game adq;

   InvitationRef(DataHolder var1, int var2, int var3) {
      super(var1, var2);
      this.adq = new GameRef(var1, var2);
      this.adV = new ArrayList(var3);
      String var5 = this.getString("external_inviter_id");
      var2 = 0;

      ParticipantRef var6;
      for(var6 = null; var2 < var3; ++var2) {
         ParticipantRef var4 = new ParticipantRef(this.JG, this.KZ + var2);
         if(var4.getParticipantId().equals(var5)) {
            var6 = var4;
         }

         this.adV.add(var4);
      }

      this.adY = (ParticipantRef)jx.b((Object)var6, "Must have a valid inviter!");
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return InvitationEntity.a(this, var1);
   }

   public Invitation freeze() {
      return new InvitationEntity(this);
   }

   public int getAvailableAutoMatchSlots() {
      return !this.getBoolean("has_automatch_criteria")?0:this.getInteger("automatch_max_players");
   }

   public long getCreationTimestamp() {
      return Math.max(this.getLong("creation_timestamp"), this.getLong("last_modified_timestamp"));
   }

   public Game getGame() {
      return this.adq;
   }

   public String getInvitationId() {
      return this.getString("external_invitation_id");
   }

   public int getInvitationType() {
      return this.getInteger("type");
   }

   public Participant getInviter() {
      return this.adY;
   }

   public ArrayList getParticipants() {
      return this.adV;
   }

   public int getVariant() {
      return this.getInteger("variant");
   }

   public int hashCode() {
      return InvitationEntity.a(this);
   }

   public String toString() {
      return InvitationEntity.b((Invitation)this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((InvitationEntity)this.freeze()).writeToParcel(var1, var2);
   }
}
