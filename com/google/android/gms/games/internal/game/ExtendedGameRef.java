package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.internal.game.ExtendedGame;
import com.google.android.gms.games.internal.game.ExtendedGameEntity;
import com.google.android.gms.games.internal.game.GameBadgeRef;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataRef;
import java.util.ArrayList;

public class ExtendedGameRef extends d implements ExtendedGame {
   private final int Ya;
   private final SnapshotMetadataRef acD;
   private final GameRef acr;

   ExtendedGameRef(DataHolder var1, int var2, int var3) {
      super(var1, var2);
      this.acr = new GameRef(var1, var2);
      this.Ya = var3;
      if(this.aQ("external_snapshot_id") && !this.aS("external_snapshot_id")) {
         this.acD = new SnapshotMetadataRef(var1, var2);
      } else {
         this.acD = null;
      }
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return ExtendedGameEntity.a(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.mj();
   }

   public Game getGame() {
      return this.acr;
   }

   public int hashCode() {
      return ExtendedGameEntity.a(this);
   }

   public ArrayList lY() {
      int var1 = 0;
      if(this.JG.c("badge_title", this.KZ, this.JG.au(this.KZ)) == null) {
         return new ArrayList(0);
      } else {
         ArrayList var2;
         for(var2 = new ArrayList(this.Ya); var1 < this.Ya; ++var1) {
            var2.add(new GameBadgeRef(this.JG, this.KZ + var1));
         }

         return var2;
      }
   }

   public int lZ() {
      return this.getInteger("availability");
   }

   public boolean ma() {
      return this.getBoolean("owned");
   }

   public int mb() {
      return this.getInteger("achievement_unlocked_count");
   }

   public long mc() {
      return this.getLong("last_played_server_time");
   }

   public long md() {
      return this.getLong("price_micros");
   }

   public String me() {
      return this.getString("formatted_price");
   }

   public long mf() {
      return this.getLong("full_price_micros");
   }

   public String mg() {
      return this.getString("formatted_full_price");
   }

   public SnapshotMetadata mh() {
      return this.acD;
   }

   public ExtendedGame mj() {
      return new ExtendedGameEntity(this);
   }

   public String toString() {
      return ExtendedGameEntity.b((ExtendedGame)this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((ExtendedGameEntity)this.mj()).writeToParcel(var1, var2);
   }
}
