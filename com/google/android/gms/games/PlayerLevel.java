package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.PlayerLevelCreator;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;

public final class PlayerLevel implements SafeParcelable {
   public static final PlayerLevelCreator CREATOR = new PlayerLevelCreator();
   private final int CK;
   private final int Xo;
   private final long Xp;
   private final long Xq;

   PlayerLevel(int var1, int var2, long var3, long var5) {
      boolean var8 = true;
      super();
      boolean var7;
      if(var3 >= 0L) {
         var7 = true;
      } else {
         var7 = false;
      }

      jx.a(var7, "Min XP must be positive!");
      if(var5 > var3) {
         var7 = var8;
      } else {
         var7 = false;
      }

      jx.a(var7, "Max XP must be more than min XP!");
      this.CK = var1;
      this.Xo = var2;
      this.Xp = var3;
      this.Xq = var5;
   }

   public PlayerLevel(int var1, long var2, long var4) {
      this(1, var1, var2, var4);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      boolean var3 = true;
      boolean var2;
      if(!(var1 instanceof PlayerLevel)) {
         var2 = false;
      } else {
         var2 = var3;
         if(this != var1) {
            PlayerLevel var4 = (PlayerLevel)var1;
            if(jv.equal(Integer.valueOf(var4.getLevelNumber()), Integer.valueOf(this.getLevelNumber())) && jv.equal(Long.valueOf(var4.getMinXp()), Long.valueOf(this.getMinXp()))) {
               var2 = var3;
               if(jv.equal(Long.valueOf(var4.getMaxXp()), Long.valueOf(this.getMaxXp()))) {
                  return var2;
               }
            }

            return false;
         }
      }

      return var2;
   }

   public int getLevelNumber() {
      return this.Xo;
   }

   public long getMaxXp() {
      return this.Xq;
   }

   public long getMinXp() {
      return this.Xp;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{Integer.valueOf(this.Xo), Long.valueOf(this.Xp), Long.valueOf(this.Xq)});
   }

   public String toString() {
      return jv.h(this).a("LevelNumber", Integer.valueOf(this.getLevelNumber())).a("MinXp", Long.valueOf(this.getMinXp())).a("MaxXp", Long.valueOf(this.getMaxXp())).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      PlayerLevelCreator.a(this, var1, var2);
   }
}
