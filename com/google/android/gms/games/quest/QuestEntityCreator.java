package com.google.android.gms.games.quest;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.quest.MilestoneEntity;
import com.google.android.gms.games.quest.QuestEntity;
import java.util.ArrayList;

public class QuestEntityCreator implements Creator {
   public static final int CONTENT_DESCRIPTION = 0;

   static void a(QuestEntity var0, Parcel var1, int var2) {
      int var3 = b.H(var1);
      b.a(var1, 1, (Parcelable)var0.getGame(), var2, false);
      b.a(var1, 2, (String)var0.getQuestId(), false);
      b.a(var1, 3, var0.getAcceptedTimestamp());
      b.a(var1, 4, (Parcelable)var0.getBannerImageUri(), var2, false);
      b.a(var1, 5, (String)var0.getBannerImageUrl(), false);
      b.a(var1, 6, (String)var0.getDescription(), false);
      b.a(var1, 7, var0.getEndTimestamp());
      b.a(var1, 8, var0.getLastUpdatedTimestamp());
      b.a(var1, 9, (Parcelable)var0.getIconImageUri(), var2, false);
      b.a(var1, 10, (String)var0.getIconImageUrl(), false);
      b.a(var1, 12, (String)var0.getName(), false);
      b.a(var1, 13, var0.mR());
      b.a(var1, 14, var0.getStartTimestamp());
      b.c(var1, 15, var0.getState());
      b.c(var1, 17, var0.mQ(), false);
      b.c(var1, 16, var0.getType());
      b.c(var1, 1000, var0.getVersionCode());
      b.H(var1, var3);
   }

   public QuestEntity createFromParcel(Parcel var1) {
      int var5 = a.G(var1);
      int var4 = 0;
      GameEntity var25 = null;
      String var24 = null;
      long var15 = 0L;
      Uri var23 = null;
      String var22 = null;
      String var21 = null;
      long var13 = 0L;
      long var11 = 0L;
      Uri var20 = null;
      String var19 = null;
      String var18 = null;
      long var9 = 0L;
      long var7 = 0L;
      int var3 = 0;
      int var2 = 0;
      ArrayList var17 = null;

      while(var1.dataPosition() < var5) {
         int var6 = a.F(var1);
         switch(a.aH(var6)) {
         case 1:
            var25 = (GameEntity)a.a(var1, var6, GameEntity.CREATOR);
            break;
         case 2:
            var24 = a.o(var1, var6);
            break;
         case 3:
            var15 = a.i(var1, var6);
            break;
         case 4:
            var23 = (Uri)a.a(var1, var6, Uri.CREATOR);
            break;
         case 5:
            var22 = a.o(var1, var6);
            break;
         case 6:
            var21 = a.o(var1, var6);
            break;
         case 7:
            var13 = a.i(var1, var6);
            break;
         case 8:
            var11 = a.i(var1, var6);
            break;
         case 9:
            var20 = (Uri)a.a(var1, var6, Uri.CREATOR);
            break;
         case 10:
            var19 = a.o(var1, var6);
            break;
         case 12:
            var18 = a.o(var1, var6);
            break;
         case 13:
            var9 = a.i(var1, var6);
            break;
         case 14:
            var7 = a.i(var1, var6);
            break;
         case 15:
            var3 = a.g(var1, var6);
            break;
         case 16:
            var2 = a.g(var1, var6);
            break;
         case 17:
            var17 = a.c(var1, var6, MilestoneEntity.CREATOR);
            break;
         case 1000:
            var4 = a.g(var1, var6);
            break;
         default:
            a.b(var1, var6);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new a.a("Overread allowed size end=" + var5, var1);
      } else {
         return new QuestEntity(var4, var25, var24, var15, var23, var22, var21, var13, var11, var20, var19, var18, var9, var7, var3, var2, var17);
      }
   }

   public QuestEntity[] newArray(int var1) {
      return new QuestEntity[var1];
   }
}
