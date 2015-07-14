package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntityCreator;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.le;

public final class ParticipantEntity extends GamesDowngradeableSafeParcel implements Participant {
   public static final Creator CREATOR = new ParticipantEntity.ParticipantEntityCreatorCompat();
   private final int CK;
   private final int FO;
   private final int FP;
   private final String OS;
   private final Uri WD;
   private final Uri WE;
   private final String WO;
   private final String WP;
   private final PlayerEntity XE;
   private final String Yi;
   private final String Zk;
   private final boolean adZ;
   private final ParticipantResult aea;

   ParticipantEntity(int var1, String var2, String var3, Uri var4, Uri var5, int var6, String var7, boolean var8, PlayerEntity var9, int var10, ParticipantResult var11, String var12, String var13) {
      this.CK = var1;
      this.Zk = var2;
      this.OS = var3;
      this.WD = var4;
      this.WE = var5;
      this.FP = var6;
      this.Yi = var7;
      this.adZ = var8;
      this.XE = var9;
      this.FO = var10;
      this.aea = var11;
      this.WO = var12;
      this.WP = var13;
   }

   public ParticipantEntity(Participant var1) {
      this.CK = 3;
      this.Zk = var1.getParticipantId();
      this.OS = var1.getDisplayName();
      this.WD = var1.getIconImageUri();
      this.WE = var1.getHiResImageUri();
      this.FP = var1.getStatus();
      this.Yi = var1.le();
      this.adZ = var1.isConnectedToRoom();
      Player var2 = var1.getPlayer();
      PlayerEntity var3;
      if(var2 == null) {
         var3 = null;
      } else {
         var3 = new PlayerEntity(var2);
      }

      this.XE = var3;
      this.FO = var1.getCapabilities();
      this.aea = var1.getResult();
      this.WO = var1.getIconImageUrl();
      this.WP = var1.getHiResImageUrl();
   }

   static int a(Participant var0) {
      return jv.hashCode(new Object[]{var0.getPlayer(), Integer.valueOf(var0.getStatus()), var0.le(), Boolean.valueOf(var0.isConnectedToRoom()), var0.getDisplayName(), var0.getIconImageUri(), var0.getHiResImageUri(), Integer.valueOf(var0.getCapabilities()), var0.getResult(), var0.getParticipantId()});
   }

   static boolean a(Participant var0, Object var1) {
      boolean var3 = true;
      boolean var2;
      if(!(var1 instanceof Participant)) {
         var2 = false;
      } else {
         var2 = var3;
         if(var0 != var1) {
            Participant var4 = (Participant)var1;
            if(jv.equal(var4.getPlayer(), var0.getPlayer()) && jv.equal(Integer.valueOf(var4.getStatus()), Integer.valueOf(var0.getStatus())) && jv.equal(var4.le(), var0.le()) && jv.equal(Boolean.valueOf(var4.isConnectedToRoom()), Boolean.valueOf(var0.isConnectedToRoom())) && jv.equal(var4.getDisplayName(), var0.getDisplayName()) && jv.equal(var4.getIconImageUri(), var0.getIconImageUri()) && jv.equal(var4.getHiResImageUri(), var0.getHiResImageUri()) && jv.equal(Integer.valueOf(var4.getCapabilities()), Integer.valueOf(var0.getCapabilities())) && jv.equal(var4.getResult(), var0.getResult())) {
               var2 = var3;
               if(jv.equal(var4.getParticipantId(), var0.getParticipantId())) {
                  return var2;
               }
            }

            return false;
         }
      }

      return var2;
   }

   static String b(Participant var0) {
      return jv.h(var0).a("ParticipantId", var0.getParticipantId()).a("Player", var0.getPlayer()).a("Status", Integer.valueOf(var0.getStatus())).a("ClientAddress", var0.le()).a("ConnectedToRoom", Boolean.valueOf(var0.isConnectedToRoom())).a("DisplayName", var0.getDisplayName()).a("IconImage", var0.getIconImageUri()).a("IconImageUrl", var0.getIconImageUrl()).a("HiResImage", var0.getHiResImageUri()).a("HiResImageUrl", var0.getHiResImageUrl()).a("Capabilities", Integer.valueOf(var0.getCapabilities())).a("Result", var0.getResult()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return a(this, var1);
   }

   public Participant freeze() {
      return this;
   }

   public int getCapabilities() {
      return this.FO;
   }

   public String getDisplayName() {
      return this.XE == null?this.OS:this.XE.getDisplayName();
   }

   public void getDisplayName(CharArrayBuffer var1) {
      if(this.XE == null) {
         le.b(this.OS, var1);
      } else {
         this.XE.getDisplayName(var1);
      }
   }

   public Uri getHiResImageUri() {
      return this.XE == null?this.WE:this.XE.getHiResImageUri();
   }

   public String getHiResImageUrl() {
      return this.XE == null?this.WP:this.XE.getHiResImageUrl();
   }

   public Uri getIconImageUri() {
      return this.XE == null?this.WD:this.XE.getIconImageUri();
   }

   public String getIconImageUrl() {
      return this.XE == null?this.WO:this.XE.getIconImageUrl();
   }

   public String getParticipantId() {
      return this.Zk;
   }

   public Player getPlayer() {
      return this.XE;
   }

   public ParticipantResult getResult() {
      return this.aea;
   }

   public int getStatus() {
      return this.FP;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return a(this);
   }

   public boolean isConnectedToRoom() {
      return this.adZ;
   }

   public boolean isDataValid() {
      return true;
   }

   public String le() {
      return this.Yi;
   }

   public String toString() {
      return b((Participant)this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      Object var6 = null;
      byte var4 = 0;
      if(!this.hu()) {
         ParticipantEntityCreator.a(this, var1, var2);
      } else {
         var1.writeString(this.Zk);
         var1.writeString(this.OS);
         String var5;
         if(this.WD == null) {
            var5 = null;
         } else {
            var5 = this.WD.toString();
         }

         var1.writeString(var5);
         if(this.WE == null) {
            var5 = (String)var6;
         } else {
            var5 = this.WE.toString();
         }

         var1.writeString(var5);
         var1.writeInt(this.FP);
         var1.writeString(this.Yi);
         byte var3;
         if(this.adZ) {
            var3 = 1;
         } else {
            var3 = 0;
         }

         var1.writeInt(var3);
         if(this.XE == null) {
            var3 = var4;
         } else {
            var3 = 1;
         }

         var1.writeInt(var3);
         if(this.XE != null) {
            this.XE.writeToParcel(var1, var2);
            return;
         }
      }

   }

   static final class ParticipantEntityCreatorCompat extends ParticipantEntityCreator {
      public ParticipantEntity cA(Parcel var1) {
         boolean var2 = true;
         if(!ParticipantEntity.c(ParticipantEntity.ht()) && !ParticipantEntity.aW(ParticipantEntity.class.getCanonicalName())) {
            String var7 = var1.readString();
            String var8 = var1.readString();
            String var5 = var1.readString();
            Uri var11;
            if(var5 == null) {
               var11 = null;
            } else {
               var11 = Uri.parse(var5);
            }

            String var6 = var1.readString();
            Uri var12;
            if(var6 == null) {
               var12 = null;
            } else {
               var12 = Uri.parse(var6);
            }

            int var3 = var1.readInt();
            String var9 = var1.readString();
            boolean var4;
            if(var1.readInt() > 0) {
               var4 = true;
            } else {
               var4 = false;
            }

            if(var1.readInt() <= 0) {
               var2 = false;
            }

            PlayerEntity var10;
            if(var2) {
               var10 = (PlayerEntity)PlayerEntity.CREATOR.createFromParcel(var1);
            } else {
               var10 = null;
            }

            return new ParticipantEntity(3, var7, var8, var11, var12, var3, var9, var4, var10, 7, (ParticipantResult)null, (String)null, (String)null);
         } else {
            return super.cA(var1);
         }
      }

      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.cA(var1);
      }
   }
}
