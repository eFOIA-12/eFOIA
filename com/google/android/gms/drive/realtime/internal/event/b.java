package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.realtime.internal.event.ObjectChangedDetails;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEvent;
import com.google.android.gms.drive.realtime.internal.event.ReferenceShiftedDetails;
import com.google.android.gms.drive.realtime.internal.event.TextDeletedDetails;
import com.google.android.gms.drive.realtime.internal.event.TextInsertedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValueChangedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValuesAddedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValuesRemovedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValuesSetDetails;
import java.util.ArrayList;

public class b implements Creator {
   static void a(ParcelableEvent var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.vZ, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String)var0.SJ, false);
      com.google.android.gms.common.internal.safeparcel.b.b(var1, 4, var0.SQ, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, var0.SR);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (String)var0.SM, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, (String)var0.SS, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, (Parcelable)var0.ST, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 9, (Parcelable)var0.SU, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 10, (Parcelable)var0.SV, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 11, (Parcelable)var0.SW, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 12, (Parcelable)var0.SX, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 13, (Parcelable)var0.SY, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 14, (Parcelable)var0.SZ, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 15, (Parcelable)var0.Ta, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public ParcelableEvent bh(Parcel var1) {
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      String var18 = null;
      String var17 = null;
      ArrayList var16 = null;
      boolean var5 = false;
      String var15 = null;
      String var14 = null;
      TextInsertedDetails var13 = null;
      TextDeletedDetails var12 = null;
      ValuesAddedDetails var11 = null;
      ValuesRemovedDetails var10 = null;
      ValuesSetDetails var9 = null;
      ValueChangedDetails var8 = null;
      ReferenceShiftedDetails var7 = null;
      ObjectChangedDetails var6 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         case 2:
            var18 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 3:
            var17 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 4:
            var16 = com.google.android.gms.common.internal.safeparcel.a.C(var1, var4);
            break;
         case 5:
            var5 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4);
            break;
         case 6:
            var15 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 7:
            var14 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 8:
            var13 = (TextInsertedDetails)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, TextInsertedDetails.CREATOR);
            break;
         case 9:
            var12 = (TextDeletedDetails)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, TextDeletedDetails.CREATOR);
            break;
         case 10:
            var11 = (ValuesAddedDetails)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, ValuesAddedDetails.CREATOR);
            break;
         case 11:
            var10 = (ValuesRemovedDetails)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, ValuesRemovedDetails.CREATOR);
            break;
         case 12:
            var9 = (ValuesSetDetails)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, ValuesSetDetails.CREATOR);
            break;
         case 13:
            var8 = (ValueChangedDetails)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, ValueChangedDetails.CREATOR);
            break;
         case 14:
            var7 = (ReferenceShiftedDetails)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, ReferenceShiftedDetails.CREATOR);
            break;
         case 15:
            var6 = (ObjectChangedDetails)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, ObjectChangedDetails.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new ParcelableEvent(var2, var18, var17, var16, var5, var15, var14, var13, var12, var11, var10, var9, var8, var7, var6);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.bh(var1);
   }

   public ParcelableEvent[] cx(int var1) {
      return new ParcelableEvent[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.cx(var1);
   }
}
