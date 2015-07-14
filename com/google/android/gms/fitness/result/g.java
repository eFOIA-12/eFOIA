package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.result.SessionStopResult;
import java.util.ArrayList;

public class g implements Creator {
   static void a(SessionStopResult var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Parcelable)var0.getStatus(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 3, var0.getSessions(), false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public SessionStopResult cj(Parcel var1) {
      ArrayList var5 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      Status var6 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 2:
            var6 = (Status)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, Status.CREATOR);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4, Session.CREATOR);
            break;
         case 1000:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new SessionStopResult(var2, var6, var5);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.cj(var1);
   }

   public SessionStopResult[] dE(int var1) {
      return new SessionStopResult[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.dE(var1);
   }
}
