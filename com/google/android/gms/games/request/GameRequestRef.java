package com.google.android.gms.games.request;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;
import java.util.List;

public final class GameRequestRef extends d implements GameRequest {
   private final int Ya;

   public GameRequestRef(DataHolder var1, int var2, int var3) {
      super(var1, var2);
      this.Ya = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return GameRequestEntity.a(this, var1);
   }

   public GameRequest freeze() {
      return new GameRequestEntity(this);
   }

   public long getCreationTimestamp() {
      return this.getLong("creation_timestamp");
   }

   public byte[] getData() {
      return this.getByteArray("data");
   }

   public long getExpirationTimestamp() {
      return this.getLong("expiration_timestamp");
   }

   public Game getGame() {
      return new GameRef(this.JG, this.KZ);
   }

   public int getRecipientStatus(String var1) {
      for(int var2 = this.KZ; var2 < this.KZ + this.Ya; ++var2) {
         int var3 = this.JG.au(var2);
         if(this.JG.c("recipient_external_player_id", var2, var3).equals(var1)) {
            return this.JG.b("recipient_status", var2, var3);
         }
      }

      return -1;
   }

   public List getRecipients() {
      ArrayList var2 = new ArrayList(this.Ya);

      for(int var1 = 0; var1 < this.Ya; ++var1) {
         var2.add(new PlayerRef(this.JG, this.KZ + var1, "recipient_"));
      }

      return var2;
   }

   public String getRequestId() {
      return this.getString("external_request_id");
   }

   public Player getSender() {
      return new PlayerRef(this.JG, this.gW(), "sender_");
   }

   public int getStatus() {
      return this.getInteger("status");
   }

   public int getType() {
      return this.getInteger("type");
   }

   public int hashCode() {
      return GameRequestEntity.a(this);
   }

   public boolean isConsumed(String var1) {
      return this.getRecipientStatus(var1) == 1;
   }

   public String toString() {
      return GameRequestEntity.c(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((GameRequestEntity)this.freeze()).writeToParcel(var1, var2);
   }
}
