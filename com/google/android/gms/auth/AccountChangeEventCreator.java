package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.AccountChangeEvent;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class AccountChangeEventCreator implements Creator {
   public static final int CONTENT_DESCRIPTION = 0;

   static void a(AccountChangeEvent var0, Parcel var1, int var2) {
      var2 = b.H(var1);
      b.c(var1, 1, var0.Ef);
      b.a(var1, 2, var0.Eg);
      b.a(var1, 3, (String)var0.DZ, false);
      b.c(var1, 4, var0.Eh);
      b.c(var1, 5, var0.Ei);
      b.a(var1, 6, (String)var0.Ej, false);
      b.H(var1, var2);
   }

   public AccountChangeEvent createFromParcel(Parcel var1) {
      String var9 = null;
      int var2 = 0;
      int var5 = a.G(var1);
      long var7 = 0L;
      int var3 = 0;
      String var10 = null;
      int var4 = 0;

      while(var1.dataPosition() < var5) {
         int var6 = a.F(var1);
         switch(a.aH(var6)) {
         case 1:
            var4 = a.g(var1, var6);
            break;
         case 2:
            var7 = a.i(var1, var6);
            break;
         case 3:
            var10 = a.o(var1, var6);
            break;
         case 4:
            var3 = a.g(var1, var6);
            break;
         case 5:
            var2 = a.g(var1, var6);
            break;
         case 6:
            var9 = a.o(var1, var6);
            break;
         default:
            a.b(var1, var6);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new a.a("Overread allowed size end=" + var5, var1);
      } else {
         return new AccountChangeEvent(var4, var7, var10, var3, var2, var9);
      }
   }

   public AccountChangeEvent[] newArray(int var1) {
      return new AccountChangeEvent[var1];
   }
}
