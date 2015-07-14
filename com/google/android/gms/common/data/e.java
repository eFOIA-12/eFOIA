package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class e extends DataBuffer {
   private static final String[] Lb = new String[]{"data"};
   private final Creator Lc;

   public e(DataHolder var1, Creator var2) {
      super(var1);
      this.Lc = var2;
   }

   public SafeParcelable at(int var1) {
      byte[] var3 = this.JG.f("data", var1, this.JG.au(var1));
      Parcel var2 = Parcel.obtain();
      var2.unmarshall(var3, 0, var3.length);
      var2.setDataPosition(0);
      SafeParcelable var4 = (SafeParcelable)this.Lc.createFromParcel(var2);
      var2.recycle();
      return var4;
   }

   // $FF: synthetic method
   public Object get(int var1) {
      return this.at(var1);
   }
}
