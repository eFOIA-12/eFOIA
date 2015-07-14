package com.google.android.gms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;

public final class c {
   public static SafeParcelable a(Intent var0, String var1, Creator var2) {
      byte[] var3 = var0.getByteArrayExtra(var1);
      return var3 == null?null:a(var3, var2);
   }

   public static SafeParcelable a(byte[] var0, Creator var1) {
      jx.i(var1);
      Parcel var2 = Parcel.obtain();
      var2.unmarshall(var0, 0, var0.length);
      var2.setDataPosition(0);
      SafeParcelable var3 = (SafeParcelable)var1.createFromParcel(var2);
      var2.recycle();
      return var3;
   }

   public static void a(SafeParcelable var0, Intent var1, String var2) {
      var1.putExtra(var2, a(var0));
   }

   public static byte[] a(SafeParcelable var0) {
      Parcel var1 = Parcel.obtain();
      var0.writeToParcel(var1, 0);
      byte[] var2 = var1.marshall();
      var1.recycle();
      return var2;
   }
}
