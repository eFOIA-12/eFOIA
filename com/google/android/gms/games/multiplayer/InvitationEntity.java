package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntityCreator;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;

public final class InvitationEntity extends GamesDowngradeableSafeParcel implements Invitation {
   public static final Creator CREATOR = new InvitationEntity.InvitationEntityCreatorCompat();
   private final int CK;
   private final String YG;
   private final GameEntity acs;
   private final long adS;
   private final int adT;
   private final ParticipantEntity adU;
   private final ArrayList adV;
   private final int adW;
   private final int adX;

   InvitationEntity(int var1, GameEntity var2, String var3, long var4, int var6, ParticipantEntity var7, ArrayList var8, int var9, int var10) {
      this.CK = var1;
      this.acs = var2;
      this.YG = var3;
      this.adS = var4;
      this.adT = var6;
      this.adU = var7;
      this.adV = var8;
      this.adW = var9;
      this.adX = var10;
   }

   InvitationEntity(Invitation var1) {
      this.CK = 2;
      this.acs = new GameEntity(var1.getGame());
      this.YG = var1.getInvitationId();
      this.adS = var1.getCreationTimestamp();
      this.adT = var1.getInvitationType();
      this.adW = var1.getVariant();
      this.adX = var1.getAvailableAutoMatchSlots();
      String var5 = var1.getInviter().getParticipantId();
      Participant var4 = null;
      ArrayList var6 = var1.getParticipants();
      int var3 = var6.size();
      this.adV = new ArrayList(var3);
      int var2 = 0;

      Participant var7;
      for(var7 = var4; var2 < var3; ++var2) {
         var4 = (Participant)var6.get(var2);
         if(var4.getParticipantId().equals(var5)) {
            var7 = var4;
         }

         this.adV.add((ParticipantEntity)var4.freeze());
      }

      jx.b((Object)var7, "Must have a valid inviter!");
      this.adU = (ParticipantEntity)var7.freeze();
   }

   static int a(Invitation var0) {
      return jv.hashCode(new Object[]{var0.getGame(), var0.getInvitationId(), Long.valueOf(var0.getCreationTimestamp()), Integer.valueOf(var0.getInvitationType()), var0.getInviter(), var0.getParticipants(), Integer.valueOf(var0.getVariant()), Integer.valueOf(var0.getAvailableAutoMatchSlots())});
   }

   static boolean a(Invitation var0, Object var1) {
      boolean var3 = true;
      boolean var2;
      if(!(var1 instanceof Invitation)) {
         var2 = false;
      } else {
         var2 = var3;
         if(var0 != var1) {
            Invitation var4 = (Invitation)var1;
            if(jv.equal(var4.getGame(), var0.getGame()) && jv.equal(var4.getInvitationId(), var0.getInvitationId()) && jv.equal(Long.valueOf(var4.getCreationTimestamp()), Long.valueOf(var0.getCreationTimestamp())) && jv.equal(Integer.valueOf(var4.getInvitationType()), Integer.valueOf(var0.getInvitationType())) && jv.equal(var4.getInviter(), var0.getInviter()) && jv.equal(var4.getParticipants(), var0.getParticipants()) && jv.equal(Integer.valueOf(var4.getVariant()), Integer.valueOf(var0.getVariant()))) {
               var2 = var3;
               if(jv.equal(Integer.valueOf(var4.getAvailableAutoMatchSlots()), Integer.valueOf(var0.getAvailableAutoMatchSlots()))) {
                  return var2;
               }
            }

            return false;
         }
      }

      return var2;
   }

   static String b(Invitation var0) {
      return jv.h(var0).a("Game", var0.getGame()).a("InvitationId", var0.getInvitationId()).a("CreationTimestamp", Long.valueOf(var0.getCreationTimestamp())).a("InvitationType", Integer.valueOf(var0.getInvitationType())).a("Inviter", var0.getInviter()).a("Participants", var0.getParticipants()).a("Variant", Integer.valueOf(var0.getVariant())).a("AvailableAutoMatchSlots", Integer.valueOf(var0.getAvailableAutoMatchSlots())).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return a(this, var1);
   }

   public Invitation freeze() {
      return this;
   }

   public int getAvailableAutoMatchSlots() {
      return this.adX;
   }

   public long getCreationTimestamp() {
      return this.adS;
   }

   public Game getGame() {
      return this.acs;
   }

   public String getInvitationId() {
      return this.YG;
   }

   public int getInvitationType() {
      return this.adT;
   }

   public Participant getInviter() {
      return this.adU;
   }

   public ArrayList getParticipants() {
      return new ArrayList(this.adV);
   }

   public int getVariant() {
      return this.adW;
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

   public String toString() {
      return b((Invitation)this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(!this.hu()) {
         InvitationEntityCreator.a(this, var1, var2);
      } else {
         this.acs.writeToParcel(var1, var2);
         var1.writeString(this.YG);
         var1.writeLong(this.adS);
         var1.writeInt(this.adT);
         this.adU.writeToParcel(var1, var2);
         int var4 = this.adV.size();
         var1.writeInt(var4);

         for(int var3 = 0; var3 < var4; ++var3) {
            ((ParticipantEntity)this.adV.get(var3)).writeToParcel(var1, var2);
         }
      }

   }

   static final class InvitationEntityCreatorCompat extends InvitationEntityCreator {
      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.cz(var1);
      }

      public InvitationEntity cz(Parcel var1) {
         if(!InvitationEntity.c(InvitationEntity.ht()) && !InvitationEntity.aW(InvitationEntity.class.getCanonicalName())) {
            GameEntity var7 = (GameEntity)GameEntity.CREATOR.createFromParcel(var1);
            String var8 = var1.readString();
            long var5 = var1.readLong();
            int var3 = var1.readInt();
            ParticipantEntity var9 = (ParticipantEntity)ParticipantEntity.CREATOR.createFromParcel(var1);
            int var4 = var1.readInt();
            ArrayList var10 = new ArrayList(var4);

            for(int var2 = 0; var2 < var4; ++var2) {
               var10.add(ParticipantEntity.CREATOR.createFromParcel(var1));
            }

            return new InvitationEntity(2, var7, var8, var5, var3, var9, var10, -1, 0);
         } else {
            return super.cz(var1);
         }
      }
   }
}
