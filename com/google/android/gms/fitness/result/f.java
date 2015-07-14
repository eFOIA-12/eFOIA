package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.q;
import com.google.android.gms.fitness.result.SessionReadResult;
import java.util.ArrayList;

public class f implements Creator {
   static void a(SessionReadResult var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getSessions(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 2, var0.kv(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (Parcelable)var0.getStatus(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public SessionReadResult ci(Parcel var1) {
      Status var7 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      ArrayList var6 = null;
      ArrayList var5 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var5 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4, Session.CREATOR);
            break;
         case 2:
            var6 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4, q.CREATOR);
            break;
         case 3:
            var7 = (Status)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, Status.CREATOR);
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
         return new SessionReadResult(var2, var5, var6, var7);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.ci(var1);
   }

   public SessionReadResult[] dD(int var1) {
      return new SessionReadResult[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.dD(var1);
   }
}
