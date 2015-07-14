package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.la;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.CommonWalletObject;
import com.google.android.gms.wallet.wobs.d;
import com.google.android.gms.wallet.wobs.j;
import com.google.android.gms.wallet.wobs.l;
import com.google.android.gms.wallet.wobs.n;
import com.google.android.gms.wallet.wobs.p;
import java.util.ArrayList;

public class a implements Creator {
   static void a(CommonWalletObject var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.fl, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String)var0.avk, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (String)var0.name, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (String)var0.ave, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (String)var0.avg, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, (String)var0.avh, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, (String)var0.avi, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 9, (String)var0.avj, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 10, var0.state);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 11, var0.avl, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 12, (Parcelable)var0.avm, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 13, var0.avn, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 14, (String)var0.avo, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 15, (String)var0.avp, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 17, var0.avr);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 16, var0.avq, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 19, var0.avt, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 18, var0.avs, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 20, var0.avu, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.ec(var1);
   }

   public CommonWalletObject ec(Parcel var1) {
      int var4 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var3 = 0;
      String var23 = null;
      String var22 = null;
      String var21 = null;
      String var20 = null;
      String var19 = null;
      String var18 = null;
      String var17 = null;
      String var16 = null;
      int var2 = 0;
      ArrayList var15 = la.ie();
      l var14 = null;
      ArrayList var13 = la.ie();
      String var12 = null;
      String var11 = null;
      ArrayList var10 = la.ie();
      boolean var6 = false;
      ArrayList var9 = la.ie();
      ArrayList var8 = la.ie();
      ArrayList var7 = la.ie();

      while(var1.dataPosition() < var4) {
         int var5 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var5)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 2:
            var23 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 3:
            var22 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 4:
            var21 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 5:
            var20 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 6:
            var19 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 7:
            var18 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 8:
            var17 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 9:
            var16 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 10:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 11:
            var15 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var5, p.CREATOR);
            break;
         case 12:
            var14 = (l)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, l.CREATOR);
            break;
         case 13:
            var13 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var5, LatLng.CREATOR);
            break;
         case 14:
            var12 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 15:
            var11 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 16:
            var10 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var5, d.CREATOR);
            break;
         case 17:
            var6 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var5);
            break;
         case 18:
            var9 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var5, n.CREATOR);
            break;
         case 19:
            var8 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var5, j.CREATOR);
            break;
         case 20:
            var7 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var5, n.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var5);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var4, var1);
      } else {
         return new CommonWalletObject(var3, var23, var22, var21, var20, var19, var18, var17, var16, var2, var15, var14, var13, var12, var11, var10, var6, var9, var8, var7);
      }
   }

   public CommonWalletObject[] gl(int var1) {
      return new CommonWalletObject[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.gl(var1);
   }
}
