package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.c;
import java.util.Locale;

public class FieldWithSortOrder implements SafeParcelable {
   public static final c CREATOR = new c();
   final int CK;
   final String QY;
   final boolean Sk;

   FieldWithSortOrder(int var1, String var2, boolean var3) {
      this.CK = var1;
      this.QY = var2;
      this.Sk = var3;
   }

   public FieldWithSortOrder(String var1, boolean var2) {
      this(1, var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public String toString() {
      Locale var2 = Locale.US;
      String var3 = this.QY;
      String var1;
      if(this.Sk) {
         var1 = "ASC";
      } else {
         var1 = "DESC";
      }

      return String.format(var2, "FieldWithSortOrder[%s %s]", new Object[]{var3, var1});
   }

   public void writeToParcel(Parcel var1, int var2) {
      c.a(this, var1, var2);
   }
}
