package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.MilestoneEntity;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestEntityCreator;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.le;
import java.util.ArrayList;
import java.util.List;

public final class QuestEntity implements SafeParcelable, Quest {
   public static final QuestEntityCreator CREATOR = new QuestEntityCreator();
   private final int CK;
   private final int Gt;
   private final String UO;
   private final long XH;
   private final GameEntity acs;
   private final String aeK;
   private final long aeL;
   private final Uri aeM;
   private final String aeN;
   private final long aeO;
   private final Uri aeP;
   private final String aeQ;
   private final long aeR;
   private final long aeS;
   private final ArrayList aeT;
   private final String mName;
   private final int mState;

   QuestEntity(int var1, GameEntity var2, String var3, long var4, Uri var6, String var7, String var8, long var9, long var11, Uri var13, String var14, String var15, long var16, long var18, int var20, int var21, ArrayList var22) {
      this.CK = var1;
      this.acs = var2;
      this.aeK = var3;
      this.aeL = var4;
      this.aeM = var6;
      this.aeN = var7;
      this.UO = var8;
      this.aeO = var9;
      this.XH = var11;
      this.aeP = var13;
      this.aeQ = var14;
      this.mName = var15;
      this.aeR = var16;
      this.aeS = var18;
      this.mState = var20;
      this.Gt = var21;
      this.aeT = var22;
   }

   public QuestEntity(Quest var1) {
      this.CK = 2;
      this.acs = new GameEntity(var1.getGame());
      this.aeK = var1.getQuestId();
      this.aeL = var1.getAcceptedTimestamp();
      this.UO = var1.getDescription();
      this.aeM = var1.getBannerImageUri();
      this.aeN = var1.getBannerImageUrl();
      this.aeO = var1.getEndTimestamp();
      this.aeP = var1.getIconImageUri();
      this.aeQ = var1.getIconImageUrl();
      this.XH = var1.getLastUpdatedTimestamp();
      this.mName = var1.getName();
      this.aeR = var1.mR();
      this.aeS = var1.getStartTimestamp();
      this.mState = var1.getState();
      this.Gt = var1.getType();
      List var4 = var1.mQ();
      int var3 = var4.size();
      this.aeT = new ArrayList(var3);

      for(int var2 = 0; var2 < var3; ++var2) {
         this.aeT.add((MilestoneEntity)((MilestoneEntity)((Milestone)var4.get(var2)).freeze()));
      }

   }

   static int a(Quest var0) {
      return jv.hashCode(new Object[]{var0.getGame(), var0.getQuestId(), Long.valueOf(var0.getAcceptedTimestamp()), var0.getBannerImageUri(), var0.getDescription(), Long.valueOf(var0.getEndTimestamp()), var0.getIconImageUri(), Long.valueOf(var0.getLastUpdatedTimestamp()), var0.mQ(), var0.getName(), Long.valueOf(var0.mR()), Long.valueOf(var0.getStartTimestamp()), Integer.valueOf(var0.getState())});
   }

   static boolean a(Quest var0, Object var1) {
      boolean var3 = true;
      boolean var2;
      if(!(var1 instanceof Quest)) {
         var2 = false;
      } else {
         var2 = var3;
         if(var0 != var1) {
            Quest var4 = (Quest)var1;
            if(jv.equal(var4.getGame(), var0.getGame()) && jv.equal(var4.getQuestId(), var0.getQuestId()) && jv.equal(Long.valueOf(var4.getAcceptedTimestamp()), Long.valueOf(var0.getAcceptedTimestamp())) && jv.equal(var4.getBannerImageUri(), var0.getBannerImageUri()) && jv.equal(var4.getDescription(), var0.getDescription()) && jv.equal(Long.valueOf(var4.getEndTimestamp()), Long.valueOf(var0.getEndTimestamp())) && jv.equal(var4.getIconImageUri(), var0.getIconImageUri()) && jv.equal(Long.valueOf(var4.getLastUpdatedTimestamp()), Long.valueOf(var0.getLastUpdatedTimestamp())) && jv.equal(var4.mQ(), var0.mQ()) && jv.equal(var4.getName(), var0.getName()) && jv.equal(Long.valueOf(var4.mR()), Long.valueOf(var0.mR())) && jv.equal(Long.valueOf(var4.getStartTimestamp()), Long.valueOf(var0.getStartTimestamp()))) {
               var2 = var3;
               if(jv.equal(Integer.valueOf(var4.getState()), Integer.valueOf(var0.getState()))) {
                  return var2;
               }
            }

            return false;
         }
      }

      return var2;
   }

   static String b(Quest var0) {
      return jv.h(var0).a("Game", var0.getGame()).a("QuestId", var0.getQuestId()).a("AcceptedTimestamp", Long.valueOf(var0.getAcceptedTimestamp())).a("BannerImageUri", var0.getBannerImageUri()).a("BannerImageUrl", var0.getBannerImageUrl()).a("Description", var0.getDescription()).a("EndTimestamp", Long.valueOf(var0.getEndTimestamp())).a("IconImageUri", var0.getIconImageUri()).a("IconImageUrl", var0.getIconImageUrl()).a("LastUpdatedTimestamp", Long.valueOf(var0.getLastUpdatedTimestamp())).a("Milestones", var0.mQ()).a("Name", var0.getName()).a("NotifyTimestamp", Long.valueOf(var0.mR())).a("StartTimestamp", Long.valueOf(var0.getStartTimestamp())).a("State", Integer.valueOf(var0.getState())).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return a(this, var1);
   }

   public Quest freeze() {
      return this;
   }

   public long getAcceptedTimestamp() {
      return this.aeL;
   }

   public Uri getBannerImageUri() {
      return this.aeM;
   }

   public String getBannerImageUrl() {
      return this.aeN;
   }

   public Milestone getCurrentMilestone() {
      return (Milestone)this.mQ().get(0);
   }

   public String getDescription() {
      return this.UO;
   }

   public void getDescription(CharArrayBuffer var1) {
      le.b(this.UO, var1);
   }

   public long getEndTimestamp() {
      return this.aeO;
   }

   public Game getGame() {
      return this.acs;
   }

   public Uri getIconImageUri() {
      return this.aeP;
   }

   public String getIconImageUrl() {
      return this.aeQ;
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

   public String getQuestId() {
      return this.aeK;
   }

   public long getStartTimestamp() {
      return this.aeS;
   }

   public int getState() {
      return this.mState;
   }

   public int getType() {
      return this.Gt;
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

   public boolean isEndingSoon() {
      return this.aeR <= System.currentTimeMillis() + 1800000L;
   }

   public List mQ() {
      return new ArrayList(this.aeT);
   }

   public long mR() {
      return this.aeR;
   }

   public String toString() {
      return b(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      QuestEntityCreator.a(this, var1, var2);
   }
}
