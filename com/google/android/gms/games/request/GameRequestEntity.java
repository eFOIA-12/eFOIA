package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestEntityCreator;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GameRequestEntity implements SafeParcelable, GameRequest {
   public static final GameRequestEntityCreator CREATOR = new GameRequestEntityCreator();
   private final int CK;
   private final int FP;
   private final int Gt;
   private final String Zt;
   private final GameEntity acs;
   private final long adS;
   private final byte[] aeA;
   private final PlayerEntity aeU;
   private final ArrayList aeV;
   private final long aeW;
   private final Bundle aeX;

   GameRequestEntity(int var1, GameEntity var2, PlayerEntity var3, byte[] var4, String var5, ArrayList var6, int var7, long var8, long var10, Bundle var12, int var13) {
      this.CK = var1;
      this.acs = var2;
      this.aeU = var3;
      this.aeA = var4;
      this.Zt = var5;
      this.aeV = var6;
      this.Gt = var7;
      this.adS = var8;
      this.aeW = var10;
      this.aeX = var12;
      this.FP = var13;
   }

   public GameRequestEntity(GameRequest var1) {
      this.CK = 2;
      this.acs = new GameEntity(var1.getGame());
      this.aeU = new PlayerEntity(var1.getSender());
      this.Zt = var1.getRequestId();
      this.Gt = var1.getType();
      this.adS = var1.getCreationTimestamp();
      this.aeW = var1.getExpirationTimestamp();
      this.FP = var1.getStatus();
      byte[] var4 = var1.getData();
      if(var4 == null) {
         this.aeA = null;
      } else {
         this.aeA = new byte[var4.length];
         System.arraycopy(var4, 0, this.aeA, 0, var4.length);
      }

      List var7 = var1.getRecipients();
      int var3 = var7.size();
      this.aeV = new ArrayList(var3);
      this.aeX = new Bundle();

      for(int var2 = 0; var2 < var3; ++var2) {
         Player var5 = (Player)((Player)var7.get(var2)).freeze();
         String var6 = var5.getPlayerId();
         this.aeV.add((PlayerEntity)var5);
         this.aeX.putInt(var6, var1.getRecipientStatus(var6));
      }

   }

   static int a(GameRequest var0) {
      return jv.hashCode(new Object[]{var0.getGame(), var0.getRecipients(), var0.getRequestId(), var0.getSender(), b(var0), Integer.valueOf(var0.getType()), Long.valueOf(var0.getCreationTimestamp()), Long.valueOf(var0.getExpirationTimestamp())});
   }

   static boolean a(GameRequest var0, Object var1) {
      boolean var3 = true;
      boolean var2;
      if(!(var1 instanceof GameRequest)) {
         var2 = false;
      } else {
         var2 = var3;
         if(var0 != var1) {
            GameRequest var4 = (GameRequest)var1;
            if(jv.equal(var4.getGame(), var0.getGame()) && jv.equal(var4.getRecipients(), var0.getRecipients()) && jv.equal(var4.getRequestId(), var0.getRequestId()) && jv.equal(var4.getSender(), var0.getSender()) && Arrays.equals(b(var4), b(var0)) && jv.equal(Integer.valueOf(var4.getType()), Integer.valueOf(var0.getType())) && jv.equal(Long.valueOf(var4.getCreationTimestamp()), Long.valueOf(var0.getCreationTimestamp()))) {
               var2 = var3;
               if(jv.equal(Long.valueOf(var4.getExpirationTimestamp()), Long.valueOf(var0.getExpirationTimestamp()))) {
                  return var2;
               }
            }

            return false;
         }
      }

      return var2;
   }

   private static int[] b(GameRequest var0) {
      List var3 = var0.getRecipients();
      int var2 = var3.size();
      int[] var4 = new int[var2];

      for(int var1 = 0; var1 < var2; ++var1) {
         var4[var1] = var0.getRecipientStatus(((Player)var3.get(var1)).getPlayerId());
      }

      return var4;
   }

   static String c(GameRequest var0) {
      return jv.h(var0).a("Game", var0.getGame()).a("Sender", var0.getSender()).a("Recipients", var0.getRecipients()).a("Data", var0.getData()).a("RequestId", var0.getRequestId()).a("Type", Integer.valueOf(var0.getType())).a("CreationTimestamp", Long.valueOf(var0.getCreationTimestamp())).a("ExpirationTimestamp", Long.valueOf(var0.getExpirationTimestamp())).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return a(this, var1);
   }

   public GameRequest freeze() {
      return this;
   }

   public long getCreationTimestamp() {
      return this.adS;
   }

   public byte[] getData() {
      return this.aeA;
   }

   public long getExpirationTimestamp() {
      return this.aeW;
   }

   public Game getGame() {
      return this.acs;
   }

   public int getRecipientStatus(String var1) {
      return this.aeX.getInt(var1, 0);
   }

   public List getRecipients() {
      return new ArrayList(this.aeV);
   }

   public String getRequestId() {
      return this.Zt;
   }

   public Player getSender() {
      return this.aeU;
   }

   public int getStatus() {
      return this.FP;
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

   public boolean isConsumed(String var1) {
      return this.getRecipientStatus(var1) == 1;
   }

   public boolean isDataValid() {
      return true;
   }

   public Bundle mS() {
      return this.aeX;
   }

   public String toString() {
      return c(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      GameRequestEntityCreator.a(this, var1, var2);
   }
}
