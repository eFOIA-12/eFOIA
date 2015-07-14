package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.event.EventEntity;

public class EventEntityCreator implements Creator {
   public static final int CONTENT_DESCRIPTION = 0;

   static void a(EventEntity var0, Parcel var1, int var2) {
      int var3 = b.H(var1);
      b.a(var1, 1, (String)var0.getEventId(), false);
      b.c(var1, 1000, var0.getVersionCode());
      b.a(var1, 2, (String)var0.getName(), false);
      b.a(var1, 3, (String)var0.getDescription(), false);
      b.a(var1, 4, (Parcelable)var0.getIconImageUri(), var2, false);
      b.a(var1, 5, (String)var0.getIconImageUrl(), false);
      b.a(var1, 6, (Parcelable)var0.getPlayer(), var2, false);
      b.a(var1, 7, var0.getValue());
      b.a(var1, 8, (String)var0.getFormattedValue(), false);
      b.a(var1, 9, var0.isVisible());
      b.H(var1, var3);
   }

   public EventEntity createFromParcel(Parcel var1) {
      boolean var5 = false;
      String var8 = null;
      int var3 = a.G(var1);
      long var6 = 0L;
      PlayerEntity var9 = null;
      String var10 = null;
      Uri var11 = null;
      String var12 = null;
      String var13 = null;
      String var14 = null;
      int var2 = 0;

      while(var1.dataPosition() < var3) {
         int var4 = a.F(var1);
         switch(a.aH(var4)) {
         case 1:
            var14 = a.o(var1, var4);
            break;
         case 2:
            var13 = a.o(var1, var4);
            break;
         case 3:
            var12 = a.o(var1, var4);
            break;
         case 4:
            var11 = (Uri)a.a(var1, var4, Uri.CREATOR);
            break;
         case 5:
            var10 = a.o(var1, var4);
            break;
         case 6:
            var9 = (PlayerEntity)a.a(var1, var4, PlayerEntity.CREATOR);
            break;
         case 7:
            var6 = a.i(var1, var4);
            break;
         case 8:
            var8 = a.o(var1, var4);
            break;
         case 9:
            var5 = a.c(var1, var4);
            break;
         case 1000:
            var2 = a.g(var1, var4);
            break;
         default:
            a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new a.a("Overread allowed size end=" + var3, var1);
      } else {
         return new EventEntity(var2, var14, var13, var12, var11, var10, var9, var6, var8, var5);
      }
   }

   public EventEntity[] newArray(int var1) {
      return new EventEntity[var1];
   }
}
