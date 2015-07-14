package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntityCreator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.le;

public final class GameEntity extends GamesDowngradeableSafeParcel implements Game {
   public static final Creator CREATOR = new GameEntity.GameEntityCreatorCompat();
   private final int CK;
   private final String Fo;
   private final String OS;
   private final String UO;
   private final String WA;
   private final String WB;
   private final String WC;
   private final Uri WD;
   private final Uri WE;
   private final Uri WF;
   private final boolean WG;
   private final boolean WH;
   private final String WI;
   private final int WJ;
   private final int WK;
   private final int WL;
   private final boolean WM;
   private final boolean WN;
   private final String WO;
   private final String WP;
   private final String WQ;
   private final boolean WR;
   private final boolean WS;
   private final boolean WT;
   private final String WU;

   GameEntity(int var1, String var2, String var3, String var4, String var5, String var6, String var7, Uri var8, Uri var9, Uri var10, boolean var11, boolean var12, String var13, int var14, int var15, int var16, boolean var17, boolean var18, String var19, String var20, String var21, boolean var22, boolean var23, boolean var24, String var25) {
      this.CK = var1;
      this.Fo = var2;
      this.OS = var3;
      this.WA = var4;
      this.WB = var5;
      this.UO = var6;
      this.WC = var7;
      this.WD = var8;
      this.WO = var19;
      this.WE = var9;
      this.WP = var20;
      this.WF = var10;
      this.WQ = var21;
      this.WG = var11;
      this.WH = var12;
      this.WI = var13;
      this.WJ = var14;
      this.WK = var15;
      this.WL = var16;
      this.WM = var17;
      this.WN = var18;
      this.WR = var22;
      this.WS = var23;
      this.WT = var24;
      this.WU = var25;
   }

   public GameEntity(Game var1) {
      this.CK = 5;
      this.Fo = var1.getApplicationId();
      this.WA = var1.getPrimaryCategory();
      this.WB = var1.getSecondaryCategory();
      this.UO = var1.getDescription();
      this.WC = var1.getDeveloperName();
      this.OS = var1.getDisplayName();
      this.WD = var1.getIconImageUri();
      this.WO = var1.getIconImageUrl();
      this.WE = var1.getHiResImageUri();
      this.WP = var1.getHiResImageUrl();
      this.WF = var1.getFeaturedImageUri();
      this.WQ = var1.getFeaturedImageUrl();
      this.WG = var1.ky();
      this.WH = var1.kA();
      this.WI = var1.kB();
      this.WJ = var1.kC();
      this.WK = var1.getAchievementTotalCount();
      this.WL = var1.getLeaderboardCount();
      this.WM = var1.isRealTimeMultiplayerEnabled();
      this.WN = var1.isTurnBasedMultiplayerEnabled();
      this.WR = var1.isMuted();
      this.WS = var1.kz();
      this.WT = var1.areSnapshotsEnabled();
      this.WU = var1.getThemeColor();
   }

   static int a(Game var0) {
      return jv.hashCode(new Object[]{var0.getApplicationId(), var0.getDisplayName(), var0.getPrimaryCategory(), var0.getSecondaryCategory(), var0.getDescription(), var0.getDeveloperName(), var0.getIconImageUri(), var0.getHiResImageUri(), var0.getFeaturedImageUri(), Boolean.valueOf(var0.ky()), Boolean.valueOf(var0.kA()), var0.kB(), Integer.valueOf(var0.kC()), Integer.valueOf(var0.getAchievementTotalCount()), Integer.valueOf(var0.getLeaderboardCount()), Boolean.valueOf(var0.isRealTimeMultiplayerEnabled()), Boolean.valueOf(var0.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(var0.isMuted()), Boolean.valueOf(var0.kz()), Boolean.valueOf(var0.areSnapshotsEnabled()), var0.getThemeColor()});
   }

   static boolean a(Game var0, Object var1) {
      boolean var3 = true;
      boolean var2;
      if(!(var1 instanceof Game)) {
         var2 = false;
      } else {
         var2 = var3;
         if(var0 != var1) {
            Game var5 = (Game)var1;
            if(jv.equal(var5.getApplicationId(), var0.getApplicationId()) && jv.equal(var5.getDisplayName(), var0.getDisplayName()) && jv.equal(var5.getPrimaryCategory(), var0.getPrimaryCategory()) && jv.equal(var5.getSecondaryCategory(), var0.getSecondaryCategory()) && jv.equal(var5.getDescription(), var0.getDescription()) && jv.equal(var5.getDeveloperName(), var0.getDeveloperName()) && jv.equal(var5.getIconImageUri(), var0.getIconImageUri()) && jv.equal(var5.getHiResImageUri(), var0.getHiResImageUri()) && jv.equal(var5.getFeaturedImageUri(), var0.getFeaturedImageUri()) && jv.equal(Boolean.valueOf(var5.ky()), Boolean.valueOf(var0.ky())) && jv.equal(Boolean.valueOf(var5.kA()), Boolean.valueOf(var0.kA())) && jv.equal(var5.kB(), var0.kB()) && jv.equal(Integer.valueOf(var5.kC()), Integer.valueOf(var0.kC())) && jv.equal(Integer.valueOf(var5.getAchievementTotalCount()), Integer.valueOf(var0.getAchievementTotalCount())) && jv.equal(Integer.valueOf(var5.getLeaderboardCount()), Integer.valueOf(var0.getLeaderboardCount())) && jv.equal(Boolean.valueOf(var5.isRealTimeMultiplayerEnabled()), Boolean.valueOf(var0.isRealTimeMultiplayerEnabled()))) {
               boolean var4 = var5.isTurnBasedMultiplayerEnabled();
               if(var0.isTurnBasedMultiplayerEnabled() && jv.equal(Boolean.valueOf(var5.isMuted()), Boolean.valueOf(var0.isMuted())) && jv.equal(Boolean.valueOf(var5.kz()), Boolean.valueOf(var0.kz()))) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               if(jv.equal(Boolean.valueOf(var4), Boolean.valueOf(var2)) && jv.equal(Boolean.valueOf(var5.areSnapshotsEnabled()), Boolean.valueOf(var0.areSnapshotsEnabled()))) {
                  var2 = var3;
                  if(jv.equal(var5.getThemeColor(), var0.getThemeColor())) {
                     return var2;
                  }
               }
            }

            return false;
         }
      }

      return var2;
   }

   static String b(Game var0) {
      return jv.h(var0).a("ApplicationId", var0.getApplicationId()).a("DisplayName", var0.getDisplayName()).a("PrimaryCategory", var0.getPrimaryCategory()).a("SecondaryCategory", var0.getSecondaryCategory()).a("Description", var0.getDescription()).a("DeveloperName", var0.getDeveloperName()).a("IconImageUri", var0.getIconImageUri()).a("IconImageUrl", var0.getIconImageUrl()).a("HiResImageUri", var0.getHiResImageUri()).a("HiResImageUrl", var0.getHiResImageUrl()).a("FeaturedImageUri", var0.getFeaturedImageUri()).a("FeaturedImageUrl", var0.getFeaturedImageUrl()).a("PlayEnabledGame", Boolean.valueOf(var0.ky())).a("InstanceInstalled", Boolean.valueOf(var0.kA())).a("InstancePackageName", var0.kB()).a("AchievementTotalCount", Integer.valueOf(var0.getAchievementTotalCount())).a("LeaderboardCount", Integer.valueOf(var0.getLeaderboardCount())).a("RealTimeMultiplayerEnabled", Boolean.valueOf(var0.isRealTimeMultiplayerEnabled())).a("TurnBasedMultiplayerEnabled", Boolean.valueOf(var0.isTurnBasedMultiplayerEnabled())).a("AreSnapshotsEnabled", Boolean.valueOf(var0.areSnapshotsEnabled())).a("ThemeColor", var0.getThemeColor()).toString();
   }

   public boolean areSnapshotsEnabled() {
      return this.WT;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return a(this, var1);
   }

   public Game freeze() {
      return this;
   }

   public int getAchievementTotalCount() {
      return this.WK;
   }

   public String getApplicationId() {
      return this.Fo;
   }

   public String getDescription() {
      return this.UO;
   }

   public void getDescription(CharArrayBuffer var1) {
      le.b(this.UO, var1);
   }

   public String getDeveloperName() {
      return this.WC;
   }

   public void getDeveloperName(CharArrayBuffer var1) {
      le.b(this.WC, var1);
   }

   public String getDisplayName() {
      return this.OS;
   }

   public void getDisplayName(CharArrayBuffer var1) {
      le.b(this.OS, var1);
   }

   public Uri getFeaturedImageUri() {
      return this.WF;
   }

   public String getFeaturedImageUrl() {
      return this.WQ;
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

   public int getLeaderboardCount() {
      return this.WL;
   }

   public String getPrimaryCategory() {
      return this.WA;
   }

   public String getSecondaryCategory() {
      return this.WB;
   }

   public String getThemeColor() {
      return this.WU;
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

   public boolean isMuted() {
      return this.WR;
   }

   public boolean isRealTimeMultiplayerEnabled() {
      return this.WM;
   }

   public boolean isTurnBasedMultiplayerEnabled() {
      return this.WN;
   }

   public boolean kA() {
      return this.WH;
   }

   public String kB() {
      return this.WI;
   }

   public int kC() {
      return this.WJ;
   }

   public boolean ky() {
      return this.WG;
   }

   public boolean kz() {
      return this.WS;
   }

   public String toString() {
      return b((Game)this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      byte var3 = 1;
      Object var5 = null;
      if(!this.hu()) {
         GameEntityCreator.a(this, var1, var2);
      } else {
         var1.writeString(this.Fo);
         var1.writeString(this.OS);
         var1.writeString(this.WA);
         var1.writeString(this.WB);
         var1.writeString(this.UO);
         var1.writeString(this.WC);
         String var4;
         if(this.WD == null) {
            var4 = null;
         } else {
            var4 = this.WD.toString();
         }

         var1.writeString(var4);
         if(this.WE == null) {
            var4 = null;
         } else {
            var4 = this.WE.toString();
         }

         var1.writeString(var4);
         if(this.WF == null) {
            var4 = (String)var5;
         } else {
            var4 = this.WF.toString();
         }

         var1.writeString(var4);
         byte var6;
         if(this.WG) {
            var6 = 1;
         } else {
            var6 = 0;
         }

         var1.writeInt(var6);
         if(this.WH) {
            var6 = var3;
         } else {
            var6 = 0;
         }

         var1.writeInt(var6);
         var1.writeString(this.WI);
         var1.writeInt(this.WJ);
         var1.writeInt(this.WK);
         var1.writeInt(this.WL);
      }
   }

   static final class GameEntityCreatorCompat extends GameEntityCreator {
      public GameEntity cl(Parcel var1) {
         if(!GameEntity.c(GameEntity.ht()) && !GameEntity.aW(GameEntity.class.getCanonicalName())) {
            String var7 = var1.readString();
            String var8 = var1.readString();
            String var9 = var1.readString();
            String var10 = var1.readString();
            String var11 = var1.readString();
            String var12 = var1.readString();
            String var4 = var1.readString();
            Uri var13;
            if(var4 == null) {
               var13 = null;
            } else {
               var13 = Uri.parse(var4);
            }

            String var5 = var1.readString();
            Uri var14;
            if(var5 == null) {
               var14 = null;
            } else {
               var14 = Uri.parse(var5);
            }

            String var6 = var1.readString();
            Uri var15;
            if(var6 == null) {
               var15 = null;
            } else {
               var15 = Uri.parse(var6);
            }

            boolean var2;
            if(var1.readInt() > 0) {
               var2 = true;
            } else {
               var2 = false;
            }

            boolean var3;
            if(var1.readInt() > 0) {
               var3 = true;
            } else {
               var3 = false;
            }

            return new GameEntity(5, var7, var8, var9, var10, var11, var12, var13, var14, var15, var2, var3, var1.readString(), var1.readInt(), var1.readInt(), var1.readInt(), false, false, (String)null, (String)null, (String)null, false, false, false, (String)null);
         } else {
            return super.cl(var1);
         }
      }

      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.cl(var1);
      }
   }
}
