package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.RealtimeDocumentSyncRequest;
import java.util.ArrayList;

public class f implements Creator {
   static void a(RealtimeDocumentSyncRequest var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.b(var1, 2, var0.OK, false);
      com.google.android.gms.common.internal.safeparcel.b.b(var1, 3, var0.OL, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public RealtimeDocumentSyncRequest U(Parcel var1) {
      ArrayList var6 = null;
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
            var5 = com.google.android.gms.common.internal.safeparcel.a.C(var1, var4);
            break;
         case 3:
            var6 = com.google.android.gms.common.internal.safeparcel.a.C(var1, var4);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new RealtimeDocumentSyncRequest(var2, var5, var6);
      }
   }

   public RealtimeDocumentSyncRequest[] bc(int var1) {
      return new RealtimeDocumentSyncRequest[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.U(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.bc(var1);
   }
}
