package com.google.android.gms.games.quest;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.quest.MilestoneEntity;

public class MilestoneEntityCreator implements Creator {
   public static final int CONTENT_DESCRIPTION = 0;

   static void a(MilestoneEntity var0, Parcel var1, int var2) {
      var2 = b.H(var1);
      b.a(var1, 1, (String)var0.getMilestoneId(), false);
      b.c(var1, 1000, var0.getVersionCode());
      b.a(var1, 2, var0.getCurrentProgress());
      b.a(var1, 3, var0.getTargetProgress());
      b.a(var1, 4, (byte[])var0.getCompletionRewardData(), false);
      b.c(var1, 5, var0.getState());
      b.a(var1, 6, (String)var0.getEventId(), false);
      b.H(var1, var2);
   }

   public MilestoneEntity createFromParcel(Parcel var1) {
      long var6 = 0L;
      int var2 = 0;
      String var10 = null;
      int var4 = a.G(var1);
      byte[] var11 = null;
      long var8 = 0L;
      String var12 = null;
      int var3 = 0;

      while(var1.dataPosition() < var4) {
         int var5 = a.F(var1);
         switch(a.aH(var5)) {
         case 1:
            var12 = a.o(var1, var5);
            break;
         case 2:
            var8 = a.i(var1, var5);
            break;
         case 3:
            var6 = a.i(var1, var5);
            break;
         case 4:
            var11 = a.r(var1, var5);
            break;
         case 5:
            var2 = a.g(var1, var5);
            break;
         case 6:
            var10 = a.o(var1, var5);
            break;
         case 1000:
            var3 = a.g(var1, var5);
            break;
         default:
            a.b(var1, var5);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new a.a("Overread allowed size end=" + var4, var1);
      } else {
         return new MilestoneEntity(var3, var12, var8, var6, var11, var2, var10);
      }
   }

   public MilestoneEntity[] newArray(int var1) {
      return new MilestoneEntity[var1];
   }
}
