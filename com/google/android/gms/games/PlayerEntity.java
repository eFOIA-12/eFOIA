package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntityCreator;
import com.google.android.gms.games.PlayerLevelInfo;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.internal.je;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.le;

public final class PlayerEntity extends GamesDowngradeableSafeParcel implements Player {
   public static final Creator CREATOR = new PlayerEntity.PlayerEntityCreatorCompat();
   private final int CK;
   private final String OH;
   private final String OS;
   private final Uri WD;
   private final Uri WE;
   private final String WO;
   private final String WP;
   private final String Xh;
   private final long Xi;
   private final int Xj;
   private final long Xk;
   private final MostRecentGameInfoEntity Xl;
   private final PlayerLevelInfo Xm;
   private final boolean Xn;

   PlayerEntity(int var1, String var2, String var3, Uri var4, Uri var5, long var6, int var8, long var9, String var11, String var12, String var13, MostRecentGameInfoEntity var14, PlayerLevelInfo var15, boolean var16) {
      this.CK = var1;
      this.Xh = var2;
      this.OS = var3;
      this.WD = var4;
      this.WO = var11;
      this.WE = var5;
      this.WP = var12;
      this.Xi = var6;
      this.Xj = var8;
      this.Xk = var9;
      this.OH = var13;
      this.Xn = var16;
      this.Xl = var14;
      this.Xm = var15;
   }

   public PlayerEntity(Player var1) {
      this.CK = 11;
      this.Xh = var1.getPlayerId();
      this.OS = var1.getDisplayName();
      this.WD = var1.getIconImageUri();
      this.WO = var1.getIconImageUrl();
      this.WE = var1.getHiResImageUri();
      this.WP = var1.getHiResImageUrl();
      this.Xi = var1.getRetrievedTimestamp();
      this.Xj = var1.kE();
      this.Xk = var1.getLastPlayedWithTimestamp();
      this.OH = var1.getTitle();
      this.Xn = var1.isProfileVisible();
      MostRecentGameInfo var3 = var1.kF();
      MostRecentGameInfoEntity var4;
      if(var3 == null) {
         var4 = null;
      } else {
         var4 = new MostRecentGameInfoEntity(var3);
      }

      this.Xl = var4;
      this.Xm = var1.getLevelInfo();
      je.f(this.Xh);
      je.f(this.OS);
      boolean var2;
      if(this.Xi > 0L) {
         var2 = true;
      } else {
         var2 = false;
      }

      je.K(var2);
   }

   static boolean a(Player var0, Object var1) {
      boolean var3 = true;
      boolean var2;
      if(!(var1 instanceof Player)) {
         var2 = false;
      } else {
         var2 = var3;
         if(var0 != var1) {
            Player var4 = (Player)var1;
            if(jv.equal(var4.getPlayerId(), var0.getPlayerId()) && jv.equal(var4.getDisplayName(), var0.getDisplayName()) && jv.equal(var4.getIconImageUri(), var0.getIconImageUri()) && jv.equal(var4.getHiResImageUri(), var0.getHiResImageUri()) && jv.equal(Long.valueOf(var4.getRetrievedTimestamp()), Long.valueOf(var0.getRetrievedTimestamp())) && jv.equal(var4.getTitle(), var0.getTitle())) {
               var2 = var3;
               if(jv.equal(var4.getLevelInfo(), var0.getLevelInfo())) {
                  return var2;
               }
            }

            return false;
         }
      }

      return var2;
   }

   static int b(Player var0) {
      return jv.hashCode(new Object[]{var0.getPlayerId(), var0.getDisplayName(), var0.getIconImageUri(), var0.getHiResImageUri(), Long.valueOf(var0.getRetrievedTimestamp()), var0.getTitle(), var0.getLevelInfo()});
   }

   static String c(Player var0) {
      return jv.h(var0).a("PlayerId", var0.getPlayerId()).a("DisplayName", var0.getDisplayName()).a("IconImageUri", var0.getIconImageUri()).a("IconImageUrl", var0.getIconImageUrl()).a("HiResImageUri", var0.getHiResImageUri()).a("HiResImageUrl", var0.getHiResImageUrl()).a("RetrievedTimestamp", Long.valueOf(var0.getRetrievedTimestamp())).a("Title", var0.getTitle()).a("LevelInfo", var0.getLevelInfo()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return a(this, var1);
   }

   public Player freeze() {
      return this;
   }

   public String getDisplayName() {
      return this.OS;
   }

   public void getDisplayName(CharArrayBuffer var1) {
      le.b(this.OS, var1);
   }

   public Uri getHiResImageUri() {
      return this.WE;
   }

   public String getHiResImageUrl() {
      return this.WP;
   }

   public Uri getIconImageUri() {
      return this.WD;
   }

   public String getIconImageUrl() {
      return this.WO;
   }

   public long getLastPlayedWithTimestamp() {
      return this.Xk;
   }

   public PlayerLevelInfo getLevelInfo() {
      return this.Xm;
   }

   public String getPlayerId() {
      return this.Xh;
   }

   public long getRetrievedTimestamp() {
      return this.Xi;
   }

   public String getTitle() {
      return this.OH;
   }

   public void getTitle(CharArrayBuffer var1) {
      le.b(this.OH, var1);
   }

   public int getVersionCode() {
      return this.CK;
   }

   public boolean hasHiResImage() {
      return this.getHiResImageUri() != null;
   }

   public boolean hasIconImage() {
      return this.getIconImageUri() != null;
   }

   public int hashCode() {
      return b((Player)this);
   }

   public boolean isDataValid() {
      return true;
   }

   public boolean isProfileVisible() {
      return this.Xn;
   }

   public int kE() {
      return this.Xj;
   }

   public MostRecentGameInfo kF() {
      return this.Xl;
   }

   public String toString() {
      return c(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      Object var4 = null;
      if(!this.hu()) {
         PlayerEntityCreator.a(this, var1, var2);
      } else {
         var1.writeString(this.Xh);
         var1.writeString(this.OS);
         String var3;
         if(this.WD == null) {
            var3 = null;
         } else {
            var3 = this.WD.toString();
         }

         var1.writeString(var3);
         if(this.WE == null) {
            var3 = (String)var4;
         } else {
            var3 = this.WE.toString();
         }

         var1.writeString(var3);
         var1.writeLong(this.Xi);
      }
   }

   static final class PlayerEntityCreatorCompat extends PlayerEntityCreator {
      public PlayerEntity cm(Parcel var1) {
         if(!PlayerEntity.c(PlayerEntity.ht()) && !PlayerEntity.aW(PlayerEntity.class.getCanonicalName())) {
            String var4 = var1.readString();
            String var5 = var1.readString();
            String var2 = var1.readString();
            String var3 = var1.readString();
            Uri var6;
            if(var2 == null) {
               var6 = null;
            } else {
               var6 = Uri.parse(var2);
            }

            Uri var7;
            if(var3 == null) {
               var7 = null;
            } else {
               var7 = Uri.parse(var3);
            }

            return new PlayerEntity(11, var4, var5, var6, var7, var1.readLong(), -1, -1L, (String)null, (String)null, (String)null, (MostRecentGameInfoEntity)null, (PlayerLevelInfo)null, true);
         } else {
            return super.cm(var1);
         }
      }

      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.cm(var1);
      }
   }
}
