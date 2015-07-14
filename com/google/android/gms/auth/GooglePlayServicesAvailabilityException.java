package com.google.android.gms.auth;

import android.content.Intent;
import com.google.android.gms.auth.UserRecoverableAuthException;

public class GooglePlayServicesAvailabilityException extends UserRecoverableAuthException {
   private final int Eo;

   GooglePlayServicesAvailabilityException(int var1, String var2, Intent var3) {
      super(var2, var3);
      this.Eo = var1;
   }

   public int getConnectionStatusCode() {
      return this.Eo;
   }
}
