package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.he;
import com.google.android.gms.internal.hh;
import com.google.android.gms.internal.ho;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class hd implements SafeParcelable {
   public static final he CREATOR = new he();
   final int CK;
   final hh[] CL;
   public final String CM;
   public final boolean CN;
   public final Account account;

   hd(int var1, hh[] var2, String var3, boolean var4, Account var5) {
      this.CK = var1;
      this.CL = var2;
      this.CM = var3;
      this.CN = var4;
      this.account = var5;
   }

   hd(String var1, boolean var2, Account var3, hh... var4) {
      this(1, var4, var1, var2, var3);
      BitSet var7 = new BitSet(ho.fF());

      for(int var5 = 0; var5 < var4.length; ++var5) {
         int var6 = var4[var5].CZ;
         if(var6 != -1) {
            if(var7.get(var6)) {
               throw new IllegalArgumentException("Duplicate global search section type " + ho.P(var6));
            }

            var7.set(var6);
         }
      }

   }

   public int describeContents() {
      he var1 = CREATOR;
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      he var3 = CREATOR;
      he.a(this, var1, var2);
   }

   public static class a {
      private List CO;
      private String CP;
      private boolean CQ;
      private Account CR;

      public hd.a F(boolean var1) {
         this.CQ = var1;
         return this;
      }

      public hd.a a(hh var1) {
         if(this.CO == null) {
            this.CO = new ArrayList();
         }

         this.CO.add(var1);
         return this;
      }

      public hd.a ar(String var1) {
         this.CP = var1;
         return this;
      }

      public hd fD() {
         String var3 = this.CP;
         boolean var1 = this.CQ;
         Account var4 = this.CR;
         hh[] var2;
         if(this.CO != null) {
            var2 = (hh[])this.CO.toArray(new hh[this.CO.size()]);
         } else {
            var2 = null;
         }

         return new hd(var3, var1, var4, var2);
      }
   }
}
