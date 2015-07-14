package com.google.android.gms.internal;

import android.os.Parcel;
import android.view.View;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class jg {
   private final View JJ;
   private final jg.a Mw;

   public jg(String var1, Collection var2, int var3, View var4, String var5) {
      this.Mw = new jg.a(var1, var2, var3, var5);
      this.JJ = var4;
   }

   public String getAccountName() {
      return this.Mw.getAccountName();
   }

   public String hm() {
      return this.Mw.hm();
   }

   public int hn() {
      return this.Mw.hn();
   }

   public List ho() {
      return this.Mw.ho();
   }

   public String[] hp() {
      return (String[])this.Mw.ho().toArray(new String[0]);
   }

   public String hq() {
      return this.Mw.hq();
   }

   public View hr() {
      return this.JJ;
   }

   public static final class a implements SafeParcelable {
      public static final jw CREATOR = new jw();
      private final int CK;
      private final String DZ;
      private final int JI;
      private final String JK;
      private final List Kh;

      a(int var1, String var2, List var3, int var4, String var5) {
         this.Kh = new ArrayList();
         this.CK = var1;
         this.DZ = var2;
         this.Kh.addAll(var3);
         this.JI = var4;
         this.JK = var5;
      }

      public a(String var1, Collection var2, int var3, String var4) {
         this(3, var1, new ArrayList(var2), var3, var4);
      }

      public int describeContents() {
         return 0;
      }

      public String getAccountName() {
         return this.DZ;
      }

      public int getVersionCode() {
         return this.CK;
      }

      public String hm() {
         return this.DZ != null?this.DZ:"<<default account>>";
      }

      public int hn() {
         return this.JI;
      }

      public List ho() {
         return new ArrayList(this.Kh);
      }

      public String hq() {
         return this.JK;
      }

      public void writeToParcel(Parcel var1, int var2) {
         jw.a(this, var1, var2);
      }
   }
}
