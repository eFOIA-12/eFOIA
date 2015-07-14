package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.la;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.LoyaltyWalletObject;
import com.google.android.gms.wallet.wobs.p;
import java.util.ArrayList;

public class j implements Creator {
   static void a(LoyaltyWalletObject var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.fl, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String)var0.avd, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (String)var0.ave, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (String)var0.avf, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (String)var0.aki, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, (String)var0.avg, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, (String)var0.avh, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 9, (String)var0.avi, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 10, (String)var0.avj, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 11, (String)var0.avk, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 12, var0.state);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 13, var0.avl, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 14, (Parcelable)var0.avm, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 15, var0.avn, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 17, (String)var0.avp, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 16, (String)var0.avo, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 19, var0.avr);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 18, var0.avq, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 21, var0.avt, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 20, var0.avs, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 23, (Parcelable)var0.avv, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 22, var0.avu, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.dR(var1);
   }

   public LoyaltyWalletObject dR(Parcel var1) {
      int var4 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var3 = 0;
      String var26 = null;
      String var25 = null;
      String var24 = null;
      String var23 = null;
      String var22 = null;
      String var21 = null;
      String var20 = null;
      String var19 = null;
      String var18 = null;
      String var17 = null;
      int var2 = 0;
      ArrayList var16 = la.ie();
      com.google.android.gms.wallet.wobs.l var15 = null;
      ArrayList var14 = la.ie();
      String var13 = null;
      String var12 = null;
      ArrayList var11 = la.ie();
      boolean var6 = false;
      ArrayList var10 = la.ie();
      ArrayList var9 = la.ie();
      ArrayList var8 = la.ie();
      com.google.android.gms.wallet.wobs.f var7 = null;

      while(var1.dataPosition() < var4) {
         int var5 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var5)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 2:
            var26 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 3:
            var25 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 4:
            var24 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 5:
            var23 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 6:
            var22 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 7:
            var21 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 8:
            var20 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 9:
            var19 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 10:
            var18 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 11:
            var17 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 12:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 13:
            var16 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var5, p.CREATOR);
            break;
         case 14:
            var15 = (com.google.android.gms.wallet.wobs.l)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, com.google.android.gms.wallet.wobs.l.CREATOR);
            break;
         case 15:
            var14 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var5, LatLng.CREATOR);
            break;
         case 16:
            var13 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 17:
            var12 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 18:
            var11 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var5, com.google.android.gms.wallet.wobs.d.CREATOR);
            break;
         case 19:
            var6 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var5);
            break;
         case 20:
            var10 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var5, com.google.android.gms.wallet.wobs.n.CREATOR);
            break;
         case 21:
            var9 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var5, com.google.android.gms.wallet.wobs.j.CREATOR);
            break;
         case 22:
            var8 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var5, com.google.android.gms.wallet.wobs.n.CREATOR);
            break;
         case 23:
            var7 = (com.google.android.gms.wallet.wobs.f)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, com.google.android.gms.wallet.wobs.f.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var5);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var4, var1);
      } else {
         return new LoyaltyWalletObject(var3, var26, var25, var24, var23, var22, var21, var20, var19, var18, var17, var2, var16, var15, var14, var13, var12, var11, var6, var10, var9, var8, var7);
      }
   }

   public LoyaltyWalletObject[] fY(int var1) {
      return new LoyaltyWalletObject[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.fY(var1);
   }
}
