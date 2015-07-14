package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.ArrayList;

public class b implements Creator {
   static void a(CompletionEvent var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Parcelable)var0.Oj, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String)var0.DZ, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (Parcelable)var0.OY, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (Parcelable)var0.OZ, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (Parcelable)var0.Pa, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.b(var1, 7, var0.Pb, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 8, var0.FP);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 9, (IBinder)var0.Pc, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public CompletionEvent Y(Parcel var1) {
      int var2 = 0;
      IBinder var6 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      ArrayList var7 = null;
      MetadataBundle var8 = null;
      ParcelFileDescriptor var9 = null;
      ParcelFileDescriptor var10 = null;
      String var11 = null;
      DriveId var12 = null;
      int var3 = 0;

      while(var1.dataPosition() < var4) {
         int var5 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var5)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 2:
            var12 = (DriveId)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, DriveId.CREATOR);
            break;
         case 3:
            var11 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 4:
            var10 = (ParcelFileDescriptor)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, ParcelFileDescriptor.CREATOR);
            break;
         case 5:
            var9 = (ParcelFileDescriptor)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, ParcelFileDescriptor.CREATOR);
            break;
         case 6:
            var8 = (MetadataBundle)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, MetadataBundle.CREATOR);
            break;
         case 7:
            var7 = com.google.android.gms.common.internal.safeparcel.a.C(var1, var5);
            break;
         case 8:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 9:
            var6 = com.google.android.gms.common.internal.safeparcel.a.p(var1, var5);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var5);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var4, var1);
      } else {
         return new CompletionEvent(var3, var12, var11, var10, var9, var8, var7, var2, var6);
      }
   }

   public CompletionEvent[] bg(int var1) {
      return new CompletionEvent[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.Y(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.bg(var1);
   }
}
