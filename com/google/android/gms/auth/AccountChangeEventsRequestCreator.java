package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class AccountChangeEventsRequestCreator implements Creator {
   public static final int CONTENT_DESCRIPTION = 0;

   static void a(AccountChangeEventsRequest var0, Parcel var1, int var2) {
      var2 = b.H(var1);
      b.c(var1, 1, var0.Ef);
      b.c(var1, 2, var0.Ei);
      b.a(var1, 3, (String)var0.DZ, false);
      b.H(var1, var2);
   }

   public AccountChangeEventsRequest createFromParcel(Parcel var1) {
      int var3 = 0;
      int var4 = a.G(var1);
      String var6 = null;
      int var2 = 0;

      while(var1.dataPosition() < var4) {
         int var5 = a.F(var1);
         switch(a.aH(var5)) {
         case 1:
            var2 = a.g(var1, var5);
            break;
         case 2:
            var3 = a.g(var1, var5);
            break;
         case 3:
            var6 = a.o(var1, var5);
            break;
         default:
            a.b(var1, var5);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new a.a("Overread allowed size end=" + var4, var1);
      } else {
         return new AccountChangeEventsRequest(var2, var3, var6);
      }
   }

   public AccountChangeEventsRequest[] newArray(int var1) {
      return new AccountChangeEventsRequest[var1];
   }
}
