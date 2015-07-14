package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.AccountChangeEvent;
import com.google.android.gms.auth.AccountChangeEventsResponse;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class AccountChangeEventsResponseCreator implements Creator {
   public static final int CONTENT_DESCRIPTION = 0;

   static void a(AccountChangeEventsResponse var0, Parcel var1, int var2) {
      var2 = b.H(var1);
      b.c(var1, 1, var0.Ef);
      b.c(var1, 2, var0.mp, false);
      b.H(var1, var2);
   }

   public AccountChangeEventsResponse createFromParcel(Parcel var1) {
      int var3 = a.G(var1);
      int var2 = 0;
      ArrayList var5 = null;

      while(var1.dataPosition() < var3) {
         int var4 = a.F(var1);
         switch(a.aH(var4)) {
         case 1:
            var2 = a.g(var1, var4);
            break;
         case 2:
            var5 = a.c(var1, var4, AccountChangeEvent.CREATOR);
            break;
         default:
            a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new a.a("Overread allowed size end=" + var3, var1);
      } else {
         return new AccountChangeEventsResponse(var2, var5);
      }
   }

   public AccountChangeEventsResponse[] newArray(int var1) {
      return new AccountChangeEventsResponse[var1];
   }
}
