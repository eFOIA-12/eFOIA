package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.PlayerLevel;
import com.google.android.gms.games.PlayerLevelInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoRef;
import com.google.android.gms.games.internal.player.PlayerColumnNames;

public final class PlayerRef extends d implements Player {
   private final PlayerLevelInfo Xm;
   private final PlayerColumnNames Xv;
   private final MostRecentGameInfoRef Xw;

   public PlayerRef(DataHolder var1, int var2) {
      this(var1, var2, (String)null);
   }

   public PlayerRef(DataHolder var1, int var2, String var3) {
      super(var1, var2);
      this.Xv = new PlayerColumnNames(var3);
      this.Xw = new MostRecentGameInfoRef(var1, var2, this.Xv);
      if(this.kG()) {
         var2 = this.getInteger(this.Xv.acV);
         int var4 = this.getInteger(this.Xv.acY);
         PlayerLevel var6 = new PlayerLevel(var2, this.getLong(this.Xv.acW), this.getLong(this.Xv.acX));
         PlayerLevel var5;
         if(var2 != var4) {
            var5 = new PlayerLevel(var4, this.getLong(this.Xv.acX), this.getLong(this.Xv.acZ));
         } else {
            var5 = var6;
         }

         this.Xm = new PlayerLevelInfo(this.getLong(this.Xv.acU), this.getLong(this.Xv.ada), var6, var5);
      } else {
         this.Xm = null;
      }
   }

   private boolean kG() {
      return !this.aS(this.Xv.acU) && this.getLong(this.Xv.acU) != -1L;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return PlayerEntity.a(this, var1);
   }

   public Player freeze() {
      return new PlayerEntity(this);
   }

   public String getDisplayName() {
      return this.getString(this.Xv.acM);
   }

   public void getDisplayName(CharArrayBuffer var1) {
      this.a(this.Xv.acM, var1);
   }

   public Uri getHiResImageUri() {
      return this.aR(this.Xv.acP);
   }

   public String getHiResImageUrl() {
      return this.getString(this.Xv.acQ);
   }

   public Uri getIconImageUri() {
      return this.aR(this.Xv.acN);
   }

   public String getIconImageUrl() {
      return this.getString(this.Xv.acO);
   }

   public long getLastPlayedWithTimestamp() {
      return this.aQ(this.Xv.acT) && !this.aS(this.Xv.acT)?this.getLong(this.Xv.acT):-1L;
   }

   public PlayerLevelInfo getLevelInfo() {
      return this.Xm;
   }

   public String getPlayerId() {
      return this.getString(this.Xv.acL);
   }

   public long getRetrievedTimestamp() {
      return this.getLong(this.Xv.acR);
   }

   public String getTitle() {
      return this.getString(this.Xv.adb);
   }

   public void getTitle(CharArrayBuffer var1) {
      this.a(this.Xv.adb, var1);
   }

   public boolean hasHiResImage() {
      return this.getHiResImageUri() != null;
   }

   public boolean hasIconImage() {
      return this.getIconImageUri() != null;
   }

   public int hashCode() {
      return PlayerEntity.b((Player)this);
   }

   public boolean isProfileVisible() {
      return this.getBoolean(this.Xv.add);
   }

   public int kE() {
      return this.getInteger(this.Xv.acS);
   }

   public MostRecentGameInfo kF() {
      return this.aS(this.Xv.ade)?null:this.Xw;
   }

   public String toString() {
      return PlayerEntity.c(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((PlayerEntity)this.freeze()).writeToParcel(var1, var2);
   }
}
