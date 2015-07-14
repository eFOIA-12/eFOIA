package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.List;

public final class IndoorBuilding {
   private final com.google.android.gms.maps.model.internal.j ami;

   public IndoorBuilding(com.google.android.gms.maps.model.internal.j var1) {
      this.ami = (com.google.android.gms.maps.model.internal.j)jx.i(var1);
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof IndoorBuilding)) {
         return false;
      } else {
         try {
            boolean var2 = this.ami.b(((IndoorBuilding)var1).ami);
            return var2;
         } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
         }
      }
   }

   public int getActiveLevelIndex() {
      try {
         int var1 = this.ami.getActiveLevelIndex();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public int getDefaultLevelIndex() {
      try {
         int var1 = this.ami.getActiveLevelIndex();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public List getLevels() {
      // $FF: Couldn't be decompiled
   }

   public int hashCode() {
      try {
         int var1 = this.ami.hashCodeRemote();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isUnderground() {
      try {
         boolean var1 = this.ami.isUnderground();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }
}
