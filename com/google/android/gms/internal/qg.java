package com.google.android.gms.internal;

import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.qh;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet;

public class qg implements Payments {
   public void changeMaskedWallet(final GoogleApiClient var1, final String var2, final String var3, final int var4) {
      var1.a((BaseImplementation.a)(new Wallet.b(var1) {
         protected void a(qh var1) {
            var1.d(var2, var3, var4);
            this.b(Status.Kw);
         }
      }));
   }

   public void checkForPreAuthorization(final GoogleApiClient var1, final int var2) {
      var1.a((BaseImplementation.a)(new Wallet.b(var1) {
         protected void a(qh var1) {
            var1.gk(var2);
            this.b(Status.Kw);
         }
      }));
   }

   public void loadFullWallet(final GoogleApiClient var1, final FullWalletRequest var2, final int var3) {
      var1.a((BaseImplementation.a)(new Wallet.b(var1) {
         protected void a(qh var1) {
            var1.a(var2, var3);
            this.b(Status.Kw);
         }
      }));
   }

   public void loadMaskedWallet(final GoogleApiClient var1, final MaskedWalletRequest var2, final int var3) {
      var1.a((BaseImplementation.a)(new Wallet.b(var1) {
         protected void a(qh var1) {
            var1.a(var2, var3);
            this.b(Status.Kw);
         }
      }));
   }

   public void notifyTransactionStatus(final GoogleApiClient var1, final NotifyTransactionStatusRequest var2) {
      var1.a((BaseImplementation.a)(new Wallet.b(var1) {
         protected void a(qh var1) {
            var1.a(var2);
            this.b(Status.Kw);
         }
      }));
   }
}
