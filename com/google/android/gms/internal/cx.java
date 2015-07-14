package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.cy;
import com.google.android.gms.internal.cz;
import com.google.android.gms.internal.dc;
import com.google.android.gms.internal.de;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gr;
import java.util.Map;

@ey
public final class cx extends cy.a {
   private Map qT;

   private cz z(String var1) throws RemoteException {
      try {
         Class var2 = Class.forName(var1, false, cx.class.getClassLoader());
         if(MediationAdapter.class.isAssignableFrom(var2)) {
            MediationAdapter var4 = (MediationAdapter)var2.newInstance();
            return new de(var4, (NetworkExtras)this.qT.get(var4.getAdditionalParametersType()));
         } else if(com.google.android.gms.ads.mediation.MediationAdapter.class.isAssignableFrom(var2)) {
            return new dc((com.google.android.gms.ads.mediation.MediationAdapter)var2.newInstance());
         } else {
            gr.W("Could not instantiate mediation adapter: " + var1 + " (not a valid adapter).");
            throw new RemoteException();
         }
      } catch (Throwable var3) {
         gr.W("Could not instantiate mediation adapter: " + var1 + ". " + var3.getMessage());
         throw new RemoteException();
      }
   }

   public void d(Map var1) {
      this.qT = var1;
   }

   public cz x(String var1) throws RemoteException {
      return this.z(var1);
   }

   public boolean y(String var1) throws RemoteException {
      try {
         boolean var2 = CustomEvent.class.isAssignableFrom(Class.forName(var1, false, cx.class.getClassLoader()));
         return var2;
      } catch (Throwable var4) {
         gr.W("Could not load custom event implementation class: " + var1 + ", assuming old implementation.");
         return false;
      }
   }
}
