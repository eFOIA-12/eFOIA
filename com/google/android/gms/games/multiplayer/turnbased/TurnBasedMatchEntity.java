package com.google.android.gms.games.multiplayer.turnbased;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchEntityCreator;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.le;
import java.util.ArrayList;

public final class TurnBasedMatchEntity implements SafeParcelable, TurnBasedMatch {
   public static final TurnBasedMatchEntityCreator CREATOR = new TurnBasedMatchEntityCreator();
   private final int CK;
   private final int Ef;
   private final String UO;
   private final long XH;
   private final String Zb;
   private final GameEntity acs;
   private final long adS;
   private final ArrayList adV;
   private final int adW;
   private final byte[] aeA;
   private final String aeB;
   private final byte[] aeC;
   private final int aeD;
   private final int aeE;
   private final boolean aeF;
   private final String aeG;
   private final Bundle aem;
   private final String aep;
   private final String aex;
   private final String aey;
   private final int aez;

   TurnBasedMatchEntity(int var1, GameEntity var2, String var3, String var4, long var5, String var7, long var8, String var10, int var11, int var12, int var13, byte[] var14, ArrayList var15, String var16, byte[] var17, int var18, Bundle var19, int var20, boolean var21, String var22, String var23) {
      this.CK = var1;
      this.acs = var2;
      this.Zb = var3;
      this.aep = var4;
      this.adS = var5;
      this.aex = var7;
      this.XH = var8;
      this.aey = var10;
      this.aez = var11;
      this.aeE = var20;
      this.adW = var12;
      this.Ef = var13;
      this.aeA = var14;
      this.adV = var15;
      this.aeB = var16;
      this.aeC = var17;
      this.aeD = var18;
      this.aem = var19;
      this.aeF = var21;
      this.UO = var22;
      this.aeG = var23;
   }

   public TurnBasedMatchEntity(TurnBasedMatch var1) {
      this.CK = 2;
      this.acs = new GameEntity(var1.getGame());
      this.Zb = var1.getMatchId();
      this.aep = var1.getCreatorId();
      this.adS = var1.getCreationTimestamp();
      this.aex = var1.getLastUpdaterId();
      this.XH = var1.getLastUpdatedTimestamp();
      this.aey = var1.getPendingParticipantId();
      this.aez = var1.getStatus();
      this.aeE = var1.getTurnStatus();
      this.adW = var1.getVariant();
      this.Ef = var1.getVersion();
      this.aeB = var1.getRematchId();
      this.aeD = var1.getMatchNumber();
      this.aem = var1.getAutoMatchCriteria();
      this.aeF = var1.isLocallyModified();
      this.UO = var1.getDescription();
      this.aeG = var1.getDescriptionParticipantId();
      byte[] var4 = var1.getData();
      if(var4 == null) {
         this.aeA = null;
      } else {
         this.aeA = new byte[var4.length];
         System.arraycopy(var4, 0, this.aeA, 0, var4.length);
      }

      var4 = var1.getPreviousMatchData();
      if(var4 == null) {
         this.aeC = null;
      } else {
         this.aeC = new byte[var4.length];
         System.arraycopy(var4, 0, this.aeC, 0, var4.length);
      }

      ArrayList var5 = var1.getParticipants();
      int var3 = var5.size();
      this.adV = new ArrayList(var3);

      for(int var2 = 0; var2 < var3; ++var2) {
         this.adV.add((ParticipantEntity)((ParticipantEntity)((Participant)var5.get(var2)).freeze()));
      }

   }

   static int a(TurnBasedMatch var0) {
      return jv.hashCode(new Object[]{var0.getGame(), var0.getMatchId(), var0.getCreatorId(), Long.valueOf(var0.getCreationTimestamp()), var0.getLastUpdaterId(), Long.valueOf(var0.getLastUpdatedTimestamp()), var0.getPendingParticipantId(), Integer.valueOf(var0.getStatus()), Integer.valueOf(var0.getTurnStatus()), var0.getDescription(), Integer.valueOf(var0.getVariant()), Integer.valueOf(var0.getVersion()), var0.getParticipants(), var0.getRematchId(), Integer.valueOf(var0.getMatchNumber()), var0.getAutoMatchCriteria(), Integer.valueOf(var0.getAvailableAutoMatchSlots()), Boolean.valueOf(var0.isLocallyModified())});
   }

   static int a(TurnBasedMatch var0, String var1) {
      ArrayList var4 = var0.getParticipants();
      int var3 = var4.size();

      for(int var2 = 0; var2 < var3; ++var2) {
         Participant var5 = (Participant)var4.get(var2);
         if(var5.getParticipantId().equals(var1)) {
            return var5.getStatus();
         }
      }

      throw new IllegalStateException("Participant " + var1 + " is not in match " + var0.getMatchId());
   }

   static boolean a(TurnBasedMatch var0, Object var1) {
      boolean var3 = true;
      boolean var2;
      if(!(var1 instanceof TurnBasedMatch)) {
         var2 = false;
      } else {
         var2 = var3;
         if(var0 != var1) {
            TurnBasedMatch var4 = (TurnBasedMatch)var1;
            if(jv.equal(var4.getGame(), var0.getGame()) && jv.equal(var4.getMatchId(), var0.getMatchId()) && jv.equal(var4.getCreatorId(), var0.getCreatorId()) && jv.equal(Long.valueOf(var4.getCreationTimestamp()), Long.valueOf(var0.getCreationTimestamp())) && jv.equal(var4.getLastUpdaterId(), var0.getLastUpdaterId()) && jv.equal(Long.valueOf(var4.getLastUpdatedTimestamp()), Long.valueOf(var0.getLastUpdatedTimestamp())) && jv.equal(var4.getPendingParticipantId(), var0.getPendingParticipantId()) && jv.equal(Integer.valueOf(var4.getStatus()), Integer.valueOf(var0.getStatus())) && jv.equal(Integer.valueOf(var4.getTurnStatus()), Integer.valueOf(var0.getTurnStatus())) && jv.equal(var4.getDescription(), var0.getDescription()) && jv.equal(Integer.valueOf(var4.getVariant()), Integer.valueOf(var0.getVariant())) && jv.equal(Integer.valueOf(var4.getVersion()), Integer.valueOf(var0.getVersion())) && jv.equal(var4.getParticipants(), var0.getParticipants()) && jv.equal(var4.getRematchId(), var0.getRematchId()) && jv.equal(Integer.valueOf(var4.getMatchNumber()), Integer.valueOf(var0.getMatchNumber())) && jv.equal(var4.getAutoMatchCriteria(), var0.getAutoMatchCriteria()) && jv.equal(Integer.valueOf(var4.getAvailableAutoMatchSlots()), Integer.valueOf(var0.getAvailableAutoMatchSlots()))) {
               var2 = var3;
               if(jv.equal(Boolean.valueOf(var4.isLocallyModified()), Boolean.valueOf(var0.isLocallyModified()))) {
                  return var2;
               }
            }

            return false;
         }
      }

      return var2;
   }

   static String b(TurnBasedMatch var0) {
      return jv.h(var0).a("Game", var0.getGame()).a("MatchId", var0.getMatchId()).a("CreatorId", var0.getCreatorId()).a("CreationTimestamp", Long.valueOf(var0.getCreationTimestamp())).a("LastUpdaterId", var0.getLastUpdaterId()).a("LastUpdatedTimestamp", Long.valueOf(var0.getLastUpdatedTimestamp())).a("PendingParticipantId", var0.getPendingParticipantId()).a("MatchStatus", Integer.valueOf(var0.getStatus())).a("TurnStatus", Integer.valueOf(var0.getTurnStatus())).a("Description", var0.getDescription()).a("Variant", Integer.valueOf(var0.getVariant())).a("Data", var0.getData()).a("Version", Integer.valueOf(var0.getVersion())).a("Participants", var0.getParticipants()).a("RematchId", var0.getRematchId()).a("PreviousData", var0.getPreviousMatchData()).a("MatchNumber", Integer.valueOf(var0.getMatchNumber())).a("AutoMatchCriteria", var0.getAutoMatchCriteria()).a("AvailableAutoMatchSlots", Integer.valueOf(var0.getAvailableAutoMatchSlots())).a("LocallyModified", Boolean.valueOf(var0.isLocallyModified())).a("DescriptionParticipantId", var0.getDescriptionParticipantId()).toString();
   }

   static String b(TurnBasedMatch var0, String var1) {
      ArrayList var6 = var0.getParticipants();
      int var3 = var6.size();

      for(int var2 = 0; var2 < var3; ++var2) {
         Participant var4 = (Participant)var6.get(var2);
         Player var5 = var4.getPlayer();
         if(var5 != null && var5.getPlayerId().equals(var1)) {
            return var4.getParticipantId();
         }
      }

      return null;
   }

   static Participant c(TurnBasedMatch var0, String var1) {
      ArrayList var4 = var0.getParticipants();
      int var3 = var4.size();

      for(int var2 = 0; var2 < var3; ++var2) {
         Participant var5 = (Participant)var4.get(var2);
         if(var5.getParticipantId().equals(var1)) {
            return var5;
         }
      }

      throw new IllegalStateException("Participant " + var1 + " is not in match " + var0.getMatchId());
   }

   static ArrayList c(TurnBasedMatch var0) {
      ArrayList var4 = var0.getParticipants();
      int var2 = var4.size();
      ArrayList var3 = new ArrayList(var2);

      for(int var1 = 0; var1 < var2; ++var1) {
         var3.add(((Participant)var4.get(var1)).getParticipantId());
      }

      return var3;
   }

   public boolean canRematch() {
      return this.aez == 2 && this.aeB == null;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return a(this, (Object)var1);
   }

   public TurnBasedMatch freeze() {
      return this;
   }

   public Bundle getAutoMatchCriteria() {
      return this.aem;
   }

   public int getAvailableAutoMatchSlots() {
      return this.aem == null?0:this.aem.getInt("max_automatch_players");
   }

   public long getCreationTimestamp() {
      return this.adS;
   }

   public String getCreatorId() {
      return this.aep;
   }

   public byte[] getData() {
      return this.aeA;
   }

   public String getDescription() {
      return this.UO;
   }

   public void getDescription(CharArrayBuffer var1) {
      le.b(this.UO, var1);
   }

   public Participant getDescriptionParticipant() {
      String var1 = this.getDescriptionParticipantId();
      return var1 == null?null:this.getParticipant(var1);
   }

   public String getDescriptionParticipantId() {
      return this.aeG;
   }

   public Game getGame() {
      return this.acs;
   }

   public long getLastUpdatedTimestamp() {
      return this.XH;
   }

   public String getLastUpdaterId() {
      return this.aex;
   }

   public String getMatchId() {
      return this.Zb;
   }

   public int getMatchNumber() {
      return this.aeD;
   }

   public Participant getParticipant(String var1) {
      return c(this, var1);
   }

   public String getParticipantId(String var1) {
      return b(this, var1);
   }

   public ArrayList getParticipantIds() {
      return c(this);
   }

   public int getParticipantStatus(String var1) {
      return a(this, (String)var1);
   }

   public ArrayList getParticipants() {
      return new ArrayList(this.adV);
   }

   public String getPendingParticipantId() {
      return this.aey;
   }

   public byte[] getPreviousMatchData() {
      return this.aeC;
   }

   public String getRematchId() {
      return this.aeB;
   }

   public int getStatus() {
      return this.aez;
   }

   public int getTurnStatus() {
      return this.aeE;
   }

   public int getVariant() {
      return this.adW;
   }

   public int getVersion() {
      return this.Ef;
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

   public boolean isLocallyModified() {
      return this.aeF;
   }

   public String toString() {
      return b(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      TurnBasedMatchEntityCreator.a(this, var1, var2);
   }
}
