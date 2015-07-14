package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.game.ExtendedGame;
import com.google.android.gms.games.internal.game.ExtendedGameEntityCreator;
import com.google.android.gms.games.internal.game.GameBadge;
import com.google.android.gms.games.internal.game.GameBadgeEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;

public final class ExtendedGameEntity extends GamesDowngradeableSafeParcel implements ExtendedGame {
   public static final ExtendedGameEntityCreator CREATOR = new ExtendedGameEntity.ExtendedGameEntityCreatorCompat();
   private final int CK;
   private final String acA;
   private final ArrayList acB;
   private final SnapshotMetadataEntity acC;
   private final GameEntity acs;
   private final int act;
   private final boolean acu;
   private final int acv;
   private final long acw;
   private final long acx;
   private final String acy;
   private final long acz;

   ExtendedGameEntity(int var1, GameEntity var2, int var3, boolean var4, int var5, long var6, long var8, String var10, long var11, String var13, ArrayList var14, SnapshotMetadataEntity var15) {
      this.CK = var1;
      this.acs = var2;
      this.act = var3;
      this.acu = var4;
      this.acv = var5;
      this.acw = var6;
      this.acx = var8;
      this.acy = var10;
      this.acz = var11;
      this.acA = var13;
      this.acB = var14;
      this.acC = var15;
   }

   public ExtendedGameEntity(ExtendedGame var1) {
      Object var5 = null;
      super();
      this.CK = 2;
      Game var4 = var1.getGame();
      GameEntity var7;
      if(var4 == null) {
         var7 = null;
      } else {
         var7 = new GameEntity(var4);
      }

      this.acs = var7;
      this.act = var1.lZ();
      this.acu = var1.ma();
      this.acv = var1.mb();
      this.acw = var1.mc();
      this.acx = var1.md();
      this.acy = var1.me();
      this.acz = var1.mf();
      this.acA = var1.mg();
      SnapshotMetadata var8 = var1.mh();
      SnapshotMetadataEntity var9;
      if(var8 == null) {
         var9 = (SnapshotMetadataEntity)var5;
      } else {
         var9 = new SnapshotMetadataEntity(var8);
      }

      this.acC = var9;
      ArrayList var6 = var1.lY();
      int var3 = var6.size();
      this.acB = new ArrayList(var3);

      for(int var2 = 0; var2 < var3; ++var2) {
         this.acB.add((GameBadgeEntity)((GameBadge)var6.get(var2)).freeze());
      }

   }

   static int a(ExtendedGame var0) {
      return jv.hashCode(new Object[]{var0.getGame(), Integer.valueOf(var0.lZ()), Boolean.valueOf(var0.ma()), Integer.valueOf(var0.mb()), Long.valueOf(var0.mc()), Long.valueOf(var0.md()), var0.me(), Long.valueOf(var0.mf()), var0.mg()});
   }

   static boolean a(ExtendedGame var0, Object var1) {
      boolean var3 = true;
      boolean var2;
      if(!(var1 instanceof ExtendedGame)) {
         var2 = false;
      } else {
         var2 = var3;
         if(var0 != var1) {
            ExtendedGame var4 = (ExtendedGame)var1;
            if(jv.equal(var4.getGame(), var0.getGame()) && jv.equal(Integer.valueOf(var4.lZ()), Integer.valueOf(var0.lZ())) && jv.equal(Boolean.valueOf(var4.ma()), Boolean.valueOf(var0.ma())) && jv.equal(Integer.valueOf(var4.mb()), Integer.valueOf(var0.mb())) && jv.equal(Long.valueOf(var4.mc()), Long.valueOf(var0.mc())) && jv.equal(Long.valueOf(var4.md()), Long.valueOf(var0.md())) && jv.equal(var4.me(), var0.me()) && jv.equal(Long.valueOf(var4.mf()), Long.valueOf(var0.mf()))) {
               var2 = var3;
               if(jv.equal(var4.mg(), var0.mg())) {
                  return var2;
               }
            }

            return false;
         }
      }

      return var2;
   }

   static String b(ExtendedGame var0) {
      return jv.h(var0).a("Game", var0.getGame()).a("Availability", Integer.valueOf(var0.lZ())).a("Owned", Boolean.valueOf(var0.ma())).a("AchievementUnlockedCount", Integer.valueOf(var0.mb())).a("LastPlayedServerTimestamp", Long.valueOf(var0.mc())).a("PriceMicros", Long.valueOf(var0.md())).a("FormattedPrice", var0.me()).a("FullPriceMicros", Long.valueOf(var0.mf())).a("FormattedFullPrice", var0.mg()).a("Snapshot", var0.mh()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return a(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.mj();
   }

   // $FF: synthetic method
   public Game getGame() {
      return this.mi();
   }

   public int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return a(this);
   }

   public boolean isDataValid() {
      return true;
   }

   public ArrayList lY() {
      return new ArrayList(this.acB);
   }

   public int lZ() {
      return this.act;
   }

   public boolean ma() {
      return this.acu;
   }

   public int mb() {
      return this.acv;
   }

   public long mc() {
      return this.acw;
   }

   public long md() {
      return this.acx;
   }

   public String me() {
      return this.acy;
   }

   public long mf() {
      return this.acz;
   }

   public String mg() {
      return this.acA;
   }

   public SnapshotMetadata mh() {
      return this.acC;
   }

   public GameEntity mi() {
      return this.acs;
   }

   public ExtendedGame mj() {
      return this;
   }

   public String toString() {
      return b((ExtendedGame)this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      byte var4 = 0;
      if(!this.hu()) {
         ExtendedGameEntityCreator.a(this, var1, var2);
      } else {
         this.acs.writeToParcel(var1, var2);
         var1.writeInt(this.act);
         byte var3;
         if(this.acu) {
            var3 = 1;
         } else {
            var3 = 0;
         }

         var1.writeInt(var3);
         var1.writeInt(this.acv);
         var1.writeLong(this.acw);
         var1.writeLong(this.acx);
         var1.writeString(this.acy);
         var1.writeLong(this.acz);
         var1.writeString(this.acA);
         int var5 = this.acB.size();
         var1.writeInt(var5);

         for(int var6 = var4; var6 < var5; ++var6) {
            ((GameBadgeEntity)this.acB.get(var6)).writeToParcel(var1, var2);
         }
      }

   }

   static final class ExtendedGameEntityCreatorCompat extends ExtendedGameEntityCreator {
      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.cu(var1);
      }

      public ExtendedGameEntity cu(Parcel var1) {
         if(!ExtendedGameEntity.c(ExtendedGameEntity.ht()) && !ExtendedGameEntity.aW(ExtendedGameEntity.class.getCanonicalName())) {
            GameEntity var13 = (GameEntity)GameEntity.CREATOR.createFromParcel(var1);
            int var3 = var1.readInt();
            boolean var6;
            if(var1.readInt() == 1) {
               var6 = true;
            } else {
               var6 = false;
            }

            int var4 = var1.readInt();
            long var7 = var1.readLong();
            long var9 = var1.readLong();
            String var14 = var1.readString();
            long var11 = var1.readLong();
            String var15 = var1.readString();
            int var5 = var1.readInt();
            ArrayList var16 = new ArrayList(var5);

            for(int var2 = 0; var2 < var5; ++var2) {
               var16.add(GameBadgeEntity.CREATOR.cv(var1));
            }

            return new ExtendedGameEntity(2, var13, var3, var6, var4, var7, var9, var14, var11, var15, var16, (SnapshotMetadataEntity)null);
         } else {
            return super.cu(var1);
         }
      }
   }
}
