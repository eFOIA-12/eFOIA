package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.identity.intents.UserAddressRequest;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;

public class a implements Creator {
   static void a(UserAddressRequest var0, Parcel var1, int var2) {
      var2 = b.H(var1);
      b.c(var1, 1, var0.getVersionCode());
      b.c(var1, 2, var0.afH, false);
      b.H(var1, var2);
   }

   public UserAddressRequest cF(Parcel var1) {
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      ArrayList var5 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4, CountrySpecification.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new UserAddressRequest(var2, var5);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.cF(var1);
   }

   public UserAddressRequest[] es(int var1) {
      return new UserAddressRequest[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.es(var1);
   }
}
