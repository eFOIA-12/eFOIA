package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.qa;
import com.google.android.gms.internal.qb;
import com.google.android.gms.internal.qd;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public class qi extends com.google.android.gms.dynamic.g {
   private static qi awH;

   protected qi() {
      super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
   }

   public static qa a(Activity var0, com.google.android.gms.dynamic.c var1, WalletFragmentOptions var2, qb var3) throws GooglePlayServicesNotAvailableException {
      int var4 = GooglePlayServicesUtil.isGooglePlayServicesAvailable(var0);
      if(var4 != 0) {
         throw new GooglePlayServicesNotAvailableException(var4);
      } else {
         try {
            qa var7 = ((qd)rg().L(var0)).a(com.google.android.gms.dynamic.e.k(var0), var1, var2, var3);
            return var7;
         } catch (RemoteException var5) {
            throw new RuntimeException(var5);
         } catch (com.google.android.gms.dynamic.g var6) {
            throw new RuntimeException(var6);
         }
      }
   }

   private static qi rg() {
      if(awH == null) {
         awH = new qi();
      }

      return awH;
   }

   protected qd bW(IBinder var1) {
      return qd.a.bS(var1);
   }

   // $FF: synthetic method
   protected Object d(IBinder var1) {
      return this.bW(var1);
   }
}
