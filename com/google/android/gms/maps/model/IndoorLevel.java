package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class IndoorLevel {
   private final com.google.android.gms.maps.model.internal.k amj;

   public IndoorLevel(com.google.android.gms.maps.model.internal.k var1) {
      this.amj = (com.google.android.gms.maps.model.internal.k)jx.i(var1);
   }

   public void activate() {
      try {
         this.amj.activate();
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof IndoorLevel)) {
         return false;
      } else {
         try {
            boolean var2 = this.amj.a(((IndoorLevel)var1).amj);
            return var2;
         } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
         }
      }
   }

   public String getName() {
      try {
         String var1 = this.amj.getName();
         return var1;
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public String getShortName() {
      try {
         String var1 = this.amj.getShortName();
         return var1;
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public int hashCode() {
      try {
         int var1 = this.amj.hashCodeRemote();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }
}
