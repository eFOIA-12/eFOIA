package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.games.internal.player.PlayerColumnNames;

public final class MostRecentGameInfoRef extends d implements MostRecentGameInfo {
   private final PlayerColumnNames Xv;

   public MostRecentGameInfoRef(DataHolder var1, int var2, PlayerColumnNames var3) {
      super(var1, var2);
      this.Xv = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return MostRecentGameInfoEntity.a(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.mC();
   }

   public int hashCode() {
      return MostRecentGameInfoEntity.a(this);
   }

   public Uri mA() {
      return this.aR(this.Xv.adi);
   }

   public Uri mB() {
      return this.aR(this.Xv.adj);
   }

   public MostRecentGameInfo mC() {
      return new MostRecentGameInfoEntity(this);
   }

   public String mw() {
      return this.getString(this.Xv.ade);
   }

   public String mx() {
      return this.getString(this.Xv.adf);
   }

   public long my() {
      return this.getLong(this.Xv.adg);
   }

   public Uri mz() {
      return this.aR(this.Xv.adh);
   }

   public String toString() {
      return MostRecentGameInfoEntity.b(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((MostRecentGameInfoEntity)this.mC()).writeToParcel(var1, var2);
   }
}
