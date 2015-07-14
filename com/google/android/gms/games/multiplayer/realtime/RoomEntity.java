package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomEntityCreator;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.le;
import java.util.ArrayList;

public final class RoomEntity extends GamesDowngradeableSafeParcel implements Room {
   public static final Creator CREATOR = new RoomEntity.RoomEntityCreatorCompat();
   private final int CK;
   private final String UO;
   private final String YI;
   private final long adS;
   private final ArrayList adV;
   private final int adW;
   private final Bundle aem;
   private final String aep;
   private final int aeq;
   private final int aer;

   RoomEntity(int var1, String var2, String var3, long var4, int var6, String var7, int var8, Bundle var9, ArrayList var10, int var11) {
      this.CK = var1;
      this.YI = var2;
      this.aep = var3;
      this.adS = var4;
      this.aeq = var6;
      this.UO = var7;
      this.adW = var8;
      this.aem = var9;
      this.adV = var10;
      this.aer = var11;
   }

   public RoomEntity(Room var1) {
      this.CK = 2;
      this.YI = var1.getRoomId();
      this.aep = var1.getCreatorId();
      this.adS = var1.getCreationTimestamp();
      this.aeq = var1.getStatus();
      this.UO = var1.getDescription();
      this.adW = var1.getVariant();
      this.aem = var1.getAutoMatchCriteria();
      ArrayList var4 = var1.getParticipants();
      int var3 = var4.size();
      this.adV = new ArrayList(var3);

      for(int var2 = 0; var2 < var3; ++var2) {
         this.adV.add((ParticipantEntity)((Participant)var4.get(var2)).freeze());
      }

      this.aer = var1.getAutoMatchWaitEstimateSeconds();
   }

   static int a(Room var0) {
      return jv.hashCode(new Object[]{var0.getRoomId(), var0.getCreatorId(), Long.valueOf(var0.getCreationTimestamp()), Integer.valueOf(var0.getStatus()), var0.getDescription(), Integer.valueOf(var0.getVariant()), var0.getAutoMatchCriteria(), var0.getParticipants(), Integer.valueOf(var0.getAutoMatchWaitEstimateSeconds())});
   }

   static int a(Room var0, String var1) {
      ArrayList var4 = var0.getParticipants();
      int var3 = var4.size();

      for(int var2 = 0; var2 < var3; ++var2) {
         Participant var5 = (Participant)var4.get(var2);
         if(var5.getParticipantId().equals(var1)) {
            return var5.getStatus();
         }
      }

      throw new IllegalStateException("Participant " + var1 + " is not in room " + var0.getRoomId());
   }

   static boolean a(Room var0, Object var1) {
      boolean var3 = true;
      boolean var2;
      if(!(var1 instanceof Room)) {
         var2 = false;
      } else {
         var2 = var3;
         if(var0 != var1) {
            Room var4 = (Room)var1;
            if(jv.equal(var4.getRoomId(), var0.getRoomId()) && jv.equal(var4.getCreatorId(), var0.getCreatorId()) && jv.equal(Long.valueOf(var4.getCreationTimestamp()), Long.valueOf(var0.getCreationTimestamp())) && jv.equal(Integer.valueOf(var4.getStatus()), Integer.valueOf(var0.getStatus())) && jv.equal(var4.getDescription(), var0.getDescription()) && jv.equal(Integer.valueOf(var4.getVariant()), Integer.valueOf(var0.getVariant())) && jv.equal(var4.getAutoMatchCriteria(), var0.getAutoMatchCriteria()) && jv.equal(var4.getParticipants(), var0.getParticipants())) {
               var2 = var3;
               if(jv.equal(Integer.valueOf(var4.getAutoMatchWaitEstimateSeconds()), Integer.valueOf(var0.getAutoMatchWaitEstimateSeconds()))) {
                  return var2;
               }
            }

            return false;
         }
      }

      return var2;
   }

   static String b(Room var0) {
      return jv.h(var0).a("RoomId", var0.getRoomId()).a("CreatorId", var0.getCreatorId()).a("CreationTimestamp", Long.valueOf(var0.getCreationTimestamp())).a("RoomStatus", Integer.valueOf(var0.getStatus())).a("Description", var0.getDescription()).a("Variant", Integer.valueOf(var0.getVariant())).a("AutoMatchCriteria", var0.getAutoMatchCriteria()).a("Participants", var0.getParticipants()).a("AutoMatchWaitEstimateSeconds", Integer.valueOf(var0.getAutoMatchWaitEstimateSeconds())).toString();
   }

   static String b(Room var0, String var1) {
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

   static Participant c(Room var0, String var1) {
      ArrayList var4 = var0.getParticipants();
      int var3 = var4.size();

      for(int var2 = 0; var2 < var3; ++var2) {
         Participant var5 = (Participant)var4.get(var2);
         if(var5.getParticipantId().equals(var1)) {
            return var5;
         }
      }

      throw new IllegalStateException("Participant " + var1 + " is not in match " + var0.getRoomId());
   }

   static ArrayList c(Room var0) {
      ArrayList var4 = var0.getParticipants();
      int var2 = var4.size();
      ArrayList var3 = new ArrayList(var2);

      for(int var1 = 0; var1 < var2; ++var1) {
         var3.add(((Participant)var4.get(var1)).getParticipantId());
      }

      return var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return a(this, (Object)var1);
   }

   public Room freeze() {
      return this;
   }

   public Bundle getAutoMatchCriteria() {
      return this.aem;
   }

   public int getAutoMatchWaitEstimateSeconds() {
      return this.aer;
   }

   public long getCreationTimestamp() {
      return this.adS;
   }

   public String getCreatorId() {
      return this.aep;
   }

   public String getDescription() {
      return this.UO;
   }

   public void getDescription(CharArrayBuffer var1) {
      le.b(this.UO, var1);
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

   public String getRoomId() {
      return this.YI;
   }

   public int getStatus() {
      return this.aeq;
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
      return b((Room)this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(!this.hu()) {
         RoomEntityCreator.a(this, var1, var2);
      } else {
         var1.writeString(this.YI);
         var1.writeString(this.aep);
         var1.writeLong(this.adS);
         var1.writeInt(this.aeq);
         var1.writeString(this.UO);
         var1.writeInt(this.adW);
         var1.writeBundle(this.aem);
         int var4 = this.adV.size();
         var1.writeInt(var4);

         for(int var3 = 0; var3 < var4; ++var3) {
            ((ParticipantEntity)this.adV.get(var3)).writeToParcel(var1, var2);
         }
      }

   }

   static final class RoomEntityCreatorCompat extends RoomEntityCreator {
      public RoomEntity cC(Parcel var1) {
         if(!RoomEntity.c(RoomEntity.ht()) && !RoomEntity.aW(RoomEntity.class.getCanonicalName())) {
            String var8 = var1.readString();
            String var9 = var1.readString();
            long var6 = var1.readLong();
            int var3 = var1.readInt();
            String var10 = var1.readString();
            int var4 = var1.readInt();
            Bundle var11 = var1.readBundle();
            int var5 = var1.readInt();
            ArrayList var12 = new ArrayList(var5);

            for(int var2 = 0; var2 < var5; ++var2) {
               var12.add(ParticipantEntity.CREATOR.createFromParcel(var1));
            }

            return new RoomEntity(2, var8, var9, var6, var3, var10, var4, var11, var12, -1);
         } else {
            return super.cC(var1);
         }
      }

      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.cC(var1);
      }
   }
}
