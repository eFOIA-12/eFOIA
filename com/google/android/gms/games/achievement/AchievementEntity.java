package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.achievement.Achievement;
import com.google.android.gms.games.achievement.AchievementEntityCreator;
import com.google.android.gms.internal.je;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.le;

public final class AchievementEntity implements SafeParcelable, Achievement {
   public static final AchievementEntityCreator CREATOR = new AchievementEntityCreator();
   private final int CK;
   private final int Gt;
   private final String UO;
   private final Uri XA;
   private final String XB;
   private final int XC;
   private final String XD;
   private final PlayerEntity XE;
   private final int XF;
   private final String XG;
   private final long XH;
   private final long XI;
   private final String Xx;
   private final Uri Xy;
   private final String Xz;
   private final String mName;
   private final int mState;

   AchievementEntity(int var1, String var2, int var3, String var4, String var5, Uri var6, String var7, Uri var8, String var9, int var10, String var11, PlayerEntity var12, int var13, int var14, String var15, long var16, long var18) {
      this.CK = var1;
      this.Xx = var2;
      this.Gt = var3;
      this.mName = var4;
      this.UO = var5;
      this.Xy = var6;
      this.Xz = var7;
      this.XA = var8;
      this.XB = var9;
      this.XC = var10;
      this.XD = var11;
      this.XE = var12;
      this.mState = var13;
      this.XF = var14;
      this.XG = var15;
      this.XH = var16;
      this.XI = var18;
   }

   public AchievementEntity(Achievement var1) {
      this.CK = 1;
      this.Xx = var1.getAchievementId();
      this.Gt = var1.getType();
      this.mName = var1.getName();
      this.UO = var1.getDescription();
      this.Xy = var1.getUnlockedImageUri();
      this.Xz = var1.getUnlockedImageUrl();
      this.XA = var1.getRevealedImageUri();
      this.XB = var1.getRevealedImageUrl();
      this.XE = (PlayerEntity)var1.getPlayer().freeze();
      this.mState = var1.getState();
      this.XH = var1.getLastUpdatedTimestamp();
      this.XI = var1.getXpValue();
      if(var1.getType() == 1) {
         this.XC = var1.getTotalSteps();
         this.XD = var1.getFormattedTotalSteps();
         this.XF = var1.getCurrentSteps();
         this.XG = var1.getFormattedCurrentSteps();
      } else {
         this.XC = 0;
         this.XD = null;
         this.XF = 0;
         this.XG = null;
      }

      je.f(this.Xx);
      je.f(this.UO);
   }

   static int a(Achievement var0) {
      int var1;
      int var2;
      if(var0.getType() == 1) {
         var2 = var0.getCurrentSteps();
         var1 = var0.getTotalSteps();
      } else {
         var1 = 0;
         var2 = 0;
      }

      return jv.hashCode(new Object[]{var0.getAchievementId(), var0.getName(), Integer.valueOf(var0.getType()), var0.getDescription(), Long.valueOf(var0.getXpValue()), Integer.valueOf(var0.getState()), Long.valueOf(var0.getLastUpdatedTimestamp()), var0.getPlayer(), Integer.valueOf(var2), Integer.valueOf(var1)});
   }

   static boolean a(Achievement var0, Object var1) {
      boolean var4 = true;
      boolean var3;
      if(!(var1 instanceof Achievement)) {
         var3 = false;
      } else {
         var3 = var4;
         if(var0 != var1) {
            Achievement var5 = (Achievement)var1;
            boolean var2;
            if(var0.getType() == 1) {
               var3 = jv.equal(Integer.valueOf(var5.getCurrentSteps()), Integer.valueOf(var0.getCurrentSteps()));
               var2 = jv.equal(Integer.valueOf(var5.getTotalSteps()), Integer.valueOf(var0.getTotalSteps()));
            } else {
               var2 = true;
               var3 = true;
            }

            if(jv.equal(var5.getAchievementId(), var0.getAchievementId()) && jv.equal(var5.getName(), var0.getName()) && jv.equal(Integer.valueOf(var5.getType()), Integer.valueOf(var0.getType())) && jv.equal(var5.getDescription(), var0.getDescription()) && jv.equal(Long.valueOf(var5.getXpValue()), Long.valueOf(var0.getXpValue())) && jv.equal(Integer.valueOf(var5.getState()), Integer.valueOf(var0.getState())) && jv.equal(Long.valueOf(var5.getLastUpdatedTimestamp()), Long.valueOf(var0.getLastUpdatedTimestamp())) && jv.equal(var5.getPlayer(), var0.getPlayer()) && var3) {
               var3 = var4;
               if(var2) {
                  return var3;
               }
            }

            return false;
         }
      }

      return var3;
   }

   static String b(Achievement var0) {
      jv.a var1 = jv.h(var0).a("Id", var0.getAchievementId()).a("Type", Integer.valueOf(var0.getType())).a("Name", var0.getName()).a("Description", var0.getDescription()).a("Player", var0.getPlayer()).a("State", Integer.valueOf(var0.getState()));
      if(var0.getType() == 1) {
         var1.a("CurrentSteps", Integer.valueOf(var0.getCurrentSteps()));
         var1.a("TotalSteps", Integer.valueOf(var0.getTotalSteps()));
      }

      return var1.toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return a(this, var1);
   }

   public Achievement freeze() {
      return this;
   }

   public String getAchievementId() {
      return this.Xx;
   }

   public int getCurrentSteps() {
      return this.XF;
   }

   public String getDescription() {
      return this.UO;
   }

   public void getDescription(CharArrayBuffer var1) {
      le.b(this.UO, var1);
   }

   public String getFormattedCurrentSteps() {
      return this.XG;
   }

   public void getFormattedCurrentSteps(CharArrayBuffer var1) {
      le.b(this.XG, var1);
   }

   public String getFormattedTotalSteps() {
      return this.XD;
   }

   public void getFormattedTotalSteps(CharArrayBuffer var1) {
      le.b(this.XD, var1);
   }

   public long getLastUpdatedTimestamp() {
      return this.XH;
   }

   public String getName() {
      return this.mName;
   }

   public void getName(CharArrayBuffer var1) {
      le.b(this.mName, var1);
   }

   public Player getPlayer() {
      return this.XE;
   }

   public Uri getRevealedImageUri() {
      return this.XA;
   }

   public String getRevealedImageUrl() {
      return this.XB;
   }

   public int getState() {
      return this.mState;
   }

   public int getTotalSteps() {
      return this.XC;
   }

   public int getType() {
      return this.Gt;
   }

   public Uri getUnlockedImageUri() {
      return this.Xy;
   }

   public String getUnlockedImageUrl() {
      return this.Xz;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public long getXpValue() {
      return this.XI;
   }

   public int hashCode() {
      return a(this);
   }

   public boolean isDataValid() {
      return true;
   }

   public String toString() {
      return b(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      AchievementEntityCreator.a(this, var1, var2);
   }
}
