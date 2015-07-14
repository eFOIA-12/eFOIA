package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.f;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.HashMap;

public final class DataHolder implements SafeParcelable {
   public static final f CREATOR = new f();
   private static final DataHolder.a Ll = new DataHolder.a(new String[0], (String)null, null) {
   };
   private final int CK;
   private final int Iv;
   private final String[] Ld;
   Bundle Le;
   private final CursorWindow[] Lf;
   private final Bundle Lg;
   int[] Lh;
   int Li;
   private Object Lj;
   private boolean Lk;
   boolean mClosed;

   DataHolder(int var1, String[] var2, CursorWindow[] var3, int var4, Bundle var5) {
      this.mClosed = false;
      this.Lk = true;
      this.CK = var1;
      this.Ld = var2;
      this.Lf = var3;
      this.Iv = var4;
      this.Lg = var5;
   }

   private DataHolder(DataHolder.a var1, int var2, Bundle var3) {
      this(var1.Ld, a(var1, -1), var2, var3);
   }

   public DataHolder(String[] var1, CursorWindow[] var2, int var3, Bundle var4) {
      this.mClosed = false;
      this.Lk = true;
      this.CK = 1;
      this.Ld = (String[])jx.i(var1);
      this.Lf = (CursorWindow[])jx.i(var2);
      this.Iv = var3;
      this.Lg = var4;
      this.gX();
   }

   public static DataHolder a(int var0, Bundle var1) {
      return new DataHolder(Ll, var0, var1);
   }

   private static CursorWindow[] a(DataHolder.a param0, int param1) {
      // $FF: Couldn't be decompiled
   }

   public static DataHolder av(int var0) {
      return a(var0, (Bundle)null);
   }

   private void g(String var1, int var2) {
      if(this.Le != null && this.Le.containsKey(var1)) {
         if(this.isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
         } else if(var2 < 0 || var2 >= this.Li) {
            throw new CursorIndexOutOfBoundsException(var2, this.Li);
         }
      } else {
         throw new IllegalArgumentException("No such column: " + var1);
      }
   }

   public long a(String var1, int var2, int var3) {
      this.g(var1, var2);
      return this.Lf[var3].getLong(var2, this.Le.getInt(var1));
   }

   public void a(String var1, int var2, int var3, CharArrayBuffer var4) {
      this.g(var1, var2);
      this.Lf[var3].copyStringToBuffer(var2, this.Le.getInt(var1), var4);
   }

   public boolean aQ(String var1) {
      return this.Le.containsKey(var1);
   }

   public int au(int var1) {
      int var3 = 0;
      boolean var4;
      if(var1 >= 0 && var1 < this.Li) {
         var4 = true;
      } else {
         var4 = false;
      }

      jx.K(var4);

      int var2;
      while(true) {
         var2 = var3;
         if(var3 >= this.Lh.length) {
            break;
         }

         if(var1 < this.Lh[var3]) {
            var2 = var3 - 1;
            break;
         }

         ++var3;
      }

      var1 = var2;
      if(var2 == this.Lh.length) {
         var1 = var2 - 1;
      }

      return var1;
   }

   public int b(String var1, int var2, int var3) {
      this.g(var1, var2);
      return this.Lf[var3].getInt(var2, this.Le.getInt(var1));
   }

   public String c(String var1, int var2, int var3) {
      this.g(var1, var2);
      return this.Lf[var3].getString(var2, this.Le.getInt(var1));
   }

   public void close() {
      // $FF: Couldn't be decompiled
   }

   public boolean d(String var1, int var2, int var3) {
      this.g(var1, var2);
      return Long.valueOf(this.Lf[var3].getLong(var2, this.Le.getInt(var1))).longValue() == 1L;
   }

   public int describeContents() {
      return 0;
   }

   public float e(String var1, int var2, int var3) {
      this.g(var1, var2);
      return this.Lf[var3].getFloat(var2, this.Le.getInt(var1));
   }

   public void e(Object var1) {
      this.Lj = var1;
   }

   public byte[] f(String var1, int var2, int var3) {
      this.g(var1, var2);
      return this.Lf[var3].getBlob(var2, this.Le.getInt(var1));
   }

   protected void finalize() throws Throwable {
      // $FF: Couldn't be decompiled
   }

   public Uri g(String var1, int var2, int var3) {
      var1 = this.c(var1, var2, var3);
      return var1 == null?null:Uri.parse(var1);
   }

   public Bundle gV() {
      return this.Lg;
   }

   public void gX() {
      byte var2 = 0;
      this.Le = new Bundle();

      int var1;
      for(var1 = 0; var1 < this.Ld.length; ++var1) {
         this.Le.putInt(this.Ld[var1], var1);
      }

      this.Lh = new int[this.Lf.length];
      byte var3 = 0;
      var1 = var2;

      int var4;
      for(var4 = var3; var1 < this.Lf.length; ++var1) {
         this.Lh[var1] = var4;
         int var5 = this.Lf[var1].getStartPosition();
         var4 += this.Lf[var1].getNumRows() - (var4 - var5);
      }

      this.Li = var4;
   }

   String[] gY() {
      return this.Ld;
   }

   CursorWindow[] gZ() {
      return this.Lf;
   }

   public int getCount() {
      return this.Li;
   }

   public int getStatusCode() {
      return this.Iv;
   }

   int getVersionCode() {
      return this.CK;
   }

   public boolean h(String var1, int var2, int var3) {
      this.g(var1, var2);
      return this.Lf[var3].isNull(var2, this.Le.getInt(var1));
   }

   public boolean isClosed() {
      // $FF: Couldn't be decompiled
   }

   public void writeToParcel(Parcel var1, int var2) {
      f.a(this, var1, var2);
   }

   public static class a {
      private final String[] Ld;
      private final ArrayList Lm;
      private final String Ln;
      private final HashMap Lo;
      private boolean Lp;
      private String Lq;

      private a(String[] var1, String var2) {
         this.Ld = (String[])jx.i(var1);
         this.Lm = new ArrayList();
         this.Ln = var2;
         this.Lo = new HashMap();
         this.Lp = false;
         this.Lq = null;
      }

      // $FF: synthetic method
      a(String[] var1, String var2, Object var3) {
         this(var1, var2);
      }

      // $FF: synthetic method
      static ArrayList b(DataHolder.a var0) {
         return var0.Lm;
      }
   }

   public static class b extends RuntimeException {
      public b(String var1) {
         super(var1);
      }
   }
}
