package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.internal.OnEventResponse;

public class aq implements Creator {
   static void a(OnEventResponse var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 2, var0.Pm);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (Parcelable)var0.QO, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (Parcelable)var0.QP, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public OnEventResponse av(Parcel var1) {
      CompletionEvent var6 = null;
      int var3 = 0;
      int var5 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      ChangeEvent var7 = null;

      int var2;
      int var4;
      for(var2 = 0; var1.dataPosition() < var5; var2 = var4) {
         var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            var2 = var3;
            var3 = var4;
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            var3 = var2;
            var2 = var4;
            break;
         case 3:
            var7 = (ChangeEvent)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, ChangeEvent.CREATOR);
            var4 = var2;
            var2 = var3;
            var3 = var4;
            break;
         case 4:
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
            var4 = var3;
            var3 = var2;
            var2 = var4;
            break;
         case 5:
            var6 = (CompletionEvent)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, CompletionEvent.CREATOR);
            var4 = var2;
            var2 = var3;
            var3 = var4;
         }

         var4 = var3;
         var3 = var2;
      }

      if(var1.dataPosition() != var5) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var5, var1);
      } else {
         return new OnEventResponse(var2, var3, var7, var6);
      }
   }

   public OnEventResponse[] bK(int var1) {
      return new OnEventResponse[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.av(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.bK(var1);
   }
}
