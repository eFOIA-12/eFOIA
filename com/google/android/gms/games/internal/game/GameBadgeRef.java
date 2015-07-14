package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.internal.game.GameBadge;
import com.google.android.gms.games.internal.game.GameBadgeEntity;

public final class GameBadgeRef extends d implements GameBadge {
   GameBadgeRef(DataHolder var1, int var2) {
      super(var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return GameBadgeEntity.a(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.mk();
   }

   public String getDescription() {
      return this.getString("badge_description");
   }

   public Uri getIconImageUri() {
      return this.aR("badge_icon_image_uri");
   }

   public String getTitle() {
      return this.getString("badge_title");
   }

   public int getType() {
      return this.getInteger("badge_type");
   }

   public int hashCode() {
      return GameBadgeEntity.a(this);
   }

   public GameBadge mk() {
      return new GameBadgeEntity(this);
   }

   public String toString() {
      return GameBadgeEntity.b((GameBadge)this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((GameBadgeEntity)this.mk()).writeToParcel(var1, var2);
   }
}
