package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.PlayerLevel;
import com.google.android.gms.games.PlayerLevelInfoCreator;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;

public final class PlayerLevelInfo implements SafeParcelable {
   public static final PlayerLevelInfoCreator CREATOR = new PlayerLevelInfoCreator();
   private final int CK;
   private final long Xr;
   private final long Xs;
   private final PlayerLevel Xt;
   private final PlayerLevel Xu;

   PlayerLevelInfo(int var1, long var2, long var4, PlayerLevel var6, PlayerLevel var7) {
      boolean var8;
      if(var2 != -1L) {
         var8 = true;
      } else {
         var8 = false;
      }

      jx.K(var8);
      jx.i(var6);
      jx.i(var7);
      this.CK = var1;
      this.Xr = var2;
      this.Xs = var4;
      this.Xt = var6;
      this.Xu = var7;
   }

   public PlayerLevelInfo(long var1, long var3, PlayerLevel var5, PlayerLevel var6) {
      this(1, var1, var3, var5, var6);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      boolean var3 = true;
      boolean var2;
      if(!(var1 instanceof PlayerLevelInfo)) {
         var2 = false;
      } else {
         var2 = var3;
         if(var1 != this) {
            PlayerLevelInfo var4 = (PlayerLevelInfo)var1;
            if(jv.equal(Long.valueOf(this.Xr), Long.valueOf(var4.Xr)) && jv.equal(Long.valueOf(this.Xs), Long.valueOf(var4.Xs)) && jv.equal(this.Xt, var4.Xt)) {
               var2 = var3;
               if(jv.equal(this.Xu, var4.Xu)) {
                  return var2;
               }
            }

            return false;
         }
      }

      return var2;
   }

   public PlayerLevel getCurrentLevel() {
      return this.Xt;
   }

   public long getCurrentXpTotal() {
      return this.Xr;
   }

   public long getLastLevelUpTimestamp() {
      return this.Xs;
   }

   public PlayerLevel getNextLevel() {
      return this.Xu;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{Long.valueOf(this.Xr), Long.valueOf(this.Xs), this.Xt, this.Xu});
   }

   public boolean isMaxLevel() {
      return this.Xt.equals(this.Xu);
   }

   public void writeToParcel(Parcel var1, int var2) {
      PlayerLevelInfoCreator.a(this, var1, var2);
   }
}
