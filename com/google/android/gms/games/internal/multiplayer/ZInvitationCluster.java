package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.internal.multiplayer.InvitationClusterCreator;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.internal.je;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;

public final class ZInvitationCluster implements SafeParcelable, Invitation {
   public static final InvitationClusterCreator CREATOR = new InvitationClusterCreator();
   private final int CK;
   private final ArrayList acE;

   ZInvitationCluster(int var1, ArrayList var2) {
      this.CK = var1;
      this.acE = var2;
      this.mp();
   }

   private void mp() {
      boolean var3;
      if(!this.acE.isEmpty()) {
         var3 = true;
      } else {
         var3 = false;
      }

      je.K(var3);
      Invitation var4 = (Invitation)this.acE.get(0);
      int var2 = this.acE.size();

      for(int var1 = 1; var1 < var2; ++var1) {
         Invitation var5 = (Invitation)this.acE.get(var1);
         je.a(var4.getInviter().equals(var5.getInviter()), "All the invitations must be from the same inviter");
      }

   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof ZInvitationCluster)) {
         return false;
      } else if(this == var1) {
         return true;
      } else {
         ZInvitationCluster var4 = (ZInvitationCluster)var1;
         if(var4.acE.size() != this.acE.size()) {
            return false;
         } else {
            int var3 = this.acE.size();

            for(int var2 = 0; var2 < var3; ++var2) {
               if(!((Invitation)this.acE.get(var2)).equals((Invitation)var4.acE.get(var2))) {
                  return false;
               }
            }

            return true;
         }
      }
   }

   public Invitation freeze() {
      return this;
   }

   public int getAvailableAutoMatchSlots() {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   public long getCreationTimestamp() {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   public Game getGame() {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   public String getInvitationId() {
      return ((InvitationEntity)this.acE.get(0)).getInvitationId();
   }

   public int getInvitationType() {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   public Participant getInviter() {
      return ((InvitationEntity)this.acE.get(0)).getInviter();
   }

   public ArrayList getParticipants() {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   public int getVariant() {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   public int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(this.acE.toArray());
   }

   public boolean isDataValid() {
      return true;
   }

   public ArrayList mq() {
      return new ArrayList(this.acE);
   }

   public void writeToParcel(Parcel var1, int var2) {
      InvitationClusterCreator.a(this, var1, var2);
   }
}
