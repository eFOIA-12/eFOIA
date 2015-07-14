package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEvent;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEventList;
import java.util.ArrayList;

public class c implements Creator {
   static void a(ParcelableEventList var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 2, var0.mp, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (Parcelable)var0.Tb, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, var0.Tc);
      com.google.android.gms.common.internal.safeparcel.b.b(var1, 5, var0.Td, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public ParcelableEventList bi(Parcel var1) {
      boolean var5 = false;
      ArrayList var6 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      DataHolder var7 = null;
      ArrayList var8 = null;
      int var2 = 0;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         case 2:
            var8 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4, ParcelableEvent.CREATOR);
            break;
         case 3:
            var7 = (DataHolder)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, DataHolder.CREATOR);
            break;
         case 4:
            var5 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4);
            break;
         case 5:
            var6 = com.google.android.gms.common.internal.safeparcel.a.C(var1, var4);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new ParcelableEventList(var2, var8, var7, var5, var6);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.bi(var1);
   }

   public ParcelableEventList[] cy(int var1) {
      return new ParcelableEventList[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.cy(var1);
   }
}
