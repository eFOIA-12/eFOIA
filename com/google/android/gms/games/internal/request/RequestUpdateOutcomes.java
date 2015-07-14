package com.google.android.gms.games.internal.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.RequestUpdateResultOutcome;
import com.google.android.gms.internal.jx;
import java.util.HashMap;
import java.util.Set;

public final class RequestUpdateOutcomes {
   private static final String[] adl = new String[]{"requestId", "outcome"};
   private final int Iv;
   private final HashMap adm;

   private RequestUpdateOutcomes(int var1, HashMap var2) {
      this.Iv = var1;
      this.adm = var2;
   }

   // $FF: synthetic method
   RequestUpdateOutcomes(int var1, HashMap var2, Object var3) {
      this(var1, var2);
   }

   public static RequestUpdateOutcomes W(DataHolder var0) {
      RequestUpdateOutcomes.Builder var4 = new RequestUpdateOutcomes.Builder();
      var4.ek(var0.getStatusCode());
      int var2 = var0.getCount();

      for(int var1 = 0; var1 < var2; ++var1) {
         int var3 = var0.au(var1);
         var4.z(var0.c("requestId", var1, var3), var0.b("outcome", var1, var3));
      }

      return var4.mF();
   }

   public Set getRequestIds() {
      return this.adm.keySet();
   }

   public int getRequestOutcome(String var1) {
      jx.b(this.adm.containsKey(var1), "Request " + var1 + " was not part of the update operation!");
      return ((Integer)this.adm.get(var1)).intValue();
   }

   public static final class Builder {
      private int Iv = 0;
      private HashMap adm = new HashMap();

      public RequestUpdateOutcomes.Builder ek(int var1) {
         this.Iv = var1;
         return this;
      }

      public RequestUpdateOutcomes mF() {
         return new RequestUpdateOutcomes(this.Iv, this.adm, null);
      }

      public RequestUpdateOutcomes.Builder z(String var1, int var2) {
         if(RequestUpdateResultOutcome.isValid(var2)) {
            this.adm.put(var1, Integer.valueOf(var2));
         }

         return this;
      }
   }
}
