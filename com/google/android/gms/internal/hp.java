package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hj;
import com.google.android.gms.internal.hq;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class hp implements SafeParcelable {
   public static final hq CREATOR = new hq();
   final int CK;
   public final String Dh;
   public final boolean Di;
   public final boolean Dj;
   public final String Dk;
   public final hj[] Dl;
   final int[] Dm;
   public final String Dn;
   public final String name;
   public final int weight;

   hp(int var1, String var2, String var3, boolean var4, int var5, boolean var6, String var7, hj[] var8, int[] var9, String var10) {
      this.CK = var1;
      this.name = var2;
      this.Dh = var3;
      this.Di = var4;
      this.weight = var5;
      this.Dj = var6;
      this.Dk = var7;
      this.Dl = var8;
      this.Dm = var9;
      this.Dn = var10;
   }

   hp(String var1, String var2, boolean var3, int var4, boolean var5, String var6, hj[] var7, int[] var8, String var9) {
      this(2, var1, var2, var3, var4, var5, var6, var7, var8, var9);
   }

   public int describeContents() {
      hq var1 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2 = var3;
      if(var1 instanceof hp) {
         hp var4 = (hp)var1;
         var2 = var3;
         if(this.name.equals(var4.name)) {
            var2 = var3;
            if(this.Dh.equals(var4.Dh)) {
               var2 = var3;
               if(this.Di == var4.Di) {
                  var2 = true;
               }
            }
         }
      }

      return var2;
   }

   public void writeToParcel(Parcel var1, int var2) {
      hq var3 = CREATOR;
      hq.a(this, var1, var2);
   }

   public static final class a {
      private String Do;
      private boolean Dp;
      private int Dq;
      private boolean Dr;
      private String Ds;
      private final List Dt;
      private BitSet Du;
      private String Dv;
      private final String mName;

      public a(String var1) {
         this.mName = var1;
         this.Dq = 1;
         this.Dt = new ArrayList();
      }

      public hp.a G(boolean var1) {
         this.Dp = var1;
         return this;
      }

      public hp.a H(boolean var1) {
         this.Dr = var1;
         return this;
      }

      public hp.a Q(int var1) {
         if(this.Du == null) {
            this.Du = new BitSet();
         }

         this.Du.set(var1);
         return this;
      }

      public hp.a at(String var1) {
         this.Do = var1;
         return this;
      }

      public hp.a au(String var1) {
         this.Dv = var1;
         return this;
      }

      public hp fG() {
         int var1 = 0;
         int[] var3 = null;
         if(this.Du != null) {
            int[] var4 = new int[this.Du.cardinality()];
            int var2 = this.Du.nextSetBit(0);

            while(true) {
               var3 = var4;
               if(var2 < 0) {
                  break;
               }

               var4[var1] = var2;
               var2 = this.Du.nextSetBit(var2 + 1);
               ++var1;
            }
         }

         return new hp(this.mName, this.Do, this.Dp, this.Dq, this.Dr, this.Ds, (hj[])this.Dt.toArray(new hj[this.Dt.size()]), var3, this.Dv);
      }
   }
}
