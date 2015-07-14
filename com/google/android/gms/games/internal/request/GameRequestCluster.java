package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.internal.request.GameRequestClusterCreator;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestEntity;
import com.google.android.gms.internal.je;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;
import java.util.List;

public final class GameRequestCluster implements SafeParcelable, GameRequest {
   public static final GameRequestClusterCreator CREATOR = new GameRequestClusterCreator();
   private final int CK;
   private final ArrayList adk;

   GameRequestCluster(int var1, ArrayList var2) {
      this.CK = var1;
      this.adk = var2;
      this.mp();
   }

   private void mp() {
      boolean var3;
      if(!this.adk.isEmpty()) {
         var3 = true;
      } else {
         var3 = false;
      }

      je.K(var3);
      GameRequest var4 = (GameRequest)this.adk.get(0);
      int var2 = this.adk.size();

      for(int var1 = 1; var1 < var2; ++var1) {
         GameRequest var5 = (GameRequest)this.adk.get(var1);
         if(var4.getType() == var5.getType()) {
            var3 = true;
         } else {
            var3 = false;
         }

         je.a(var3, "All the requests must be of the same type");
         je.a(var4.getSender().equals(var5.getSender()), "All the requests must be from the same sender");
      }

   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof GameRequestCluster)) {
         return false;
      } else if(this == var1) {
         return true;
      } else {
         GameRequestCluster var4 = (GameRequestCluster)var1;
         if(var4.adk.size() != this.adk.size()) {
            return false;
         } else {
            int var3 = this.adk.size();

            for(int var2 = 0; var2 < var3; ++var2) {
               if(!((GameRequest)this.adk.get(var2)).equals((GameRequest)var4.adk.get(var2))) {
                  return false;
               }
            }

            return true;
         }
      }
   }

   public GameRequest freeze() {
      return this;
   }

   public long getCreationTimestamp() {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   public byte[] getData() {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   public long getExpirationTimestamp() {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   public Game getGame() {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   public int getRecipientStatus(String var1) {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   // $FF: synthetic method
   public List getRecipients() {
      return this.mE();
   }

   public String getRequestId() {
      return ((GameRequestEntity)this.adk.get(0)).getRequestId();
   }

   public Player getSender() {
      return ((GameRequestEntity)this.adk.get(0)).getSender();
   }

   public int getStatus() {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   public int getType() {
      return ((GameRequestEntity)this.adk.get(0)).getType();
   }

   public int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(this.adk.toArray());
   }

   public boolean isConsumed(String var1) {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   public boolean isDataValid() {
      return true;
   }

   public ArrayList mD() {
      return new ArrayList(this.adk);
   }

   public ArrayList mE() {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   public void writeToParcel(Parcel var1, int var2) {
      GameRequestClusterCreator.a(this, var1, var2);
   }
}
