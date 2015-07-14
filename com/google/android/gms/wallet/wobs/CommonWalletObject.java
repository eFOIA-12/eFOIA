package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.la;
import com.google.android.gms.wallet.wobs.a;
import com.google.android.gms.wallet.wobs.l;
import java.util.ArrayList;

public class CommonWalletObject implements SafeParcelable {
   public static final Creator CREATOR = new a();
   private final int CK;
   String ave;
   String avg;
   String avh;
   String avi;
   String avj;
   String avk;
   ArrayList avl;
   l avm;
   ArrayList avn;
   String avo;
   String avp;
   ArrayList avq;
   boolean avr;
   ArrayList avs;
   ArrayList avt;
   ArrayList avu;
   String fl;
   String name;
   int state;

   CommonWalletObject() {
      this.CK = 1;
      this.avl = la.ie();
      this.avn = la.ie();
      this.avq = la.ie();
      this.avs = la.ie();
      this.avt = la.ie();
      this.avu = la.ie();
   }

   CommonWalletObject(int var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, int var10, ArrayList var11, l var12, ArrayList var13, String var14, String var15, ArrayList var16, boolean var17, ArrayList var18, ArrayList var19, ArrayList var20) {
      this.CK = var1;
      this.fl = var2;
      this.avk = var3;
      this.name = var4;
      this.ave = var5;
      this.avg = var6;
      this.avh = var7;
      this.avi = var8;
      this.avj = var9;
      this.state = var10;
      this.avl = var11;
      this.avm = var12;
      this.avn = var13;
      this.avo = var14;
      this.avp = var15;
      this.avq = var16;
      this.avr = var17;
      this.avs = var18;
      this.avt = var19;
      this.avu = var20;
   }

   public static CommonWalletObject.a rh() {
      CommonWalletObject var0 = new CommonWalletObject();
      return var0.new a(null);
   }

   public int describeContents() {
      return 0;
   }

   public String getId() {
      return this.fl;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public void writeToParcel(Parcel var1, int var2) {
      a.a(this, var1, var2);
   }

   public final class a {
      private a() {
      }

      // $FF: synthetic method
      a(Object var2) {
         this();
      }

      public CommonWalletObject.a dh(String var1) {
         CommonWalletObject.this.fl = var1;
         return this;
      }

      public CommonWalletObject ri() {
         return CommonWalletObject.this;
      }
   }
}
