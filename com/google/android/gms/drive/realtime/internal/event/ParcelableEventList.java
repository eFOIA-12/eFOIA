package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.c;
import java.util.List;

public class ParcelableEventList implements SafeParcelable {
   public static final Creator CREATOR = new c();
   final int CK;
   final DataHolder Tb;
   final boolean Tc;
   final List Td;
   final List mp;

   ParcelableEventList(int var1, List var2, DataHolder var3, boolean var4, List var5) {
      this.CK = var1;
      this.mp = var2;
      this.Tb = var3;
      this.Tc = var4;
      this.Td = var5;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      c.a(this, var1, var2);
   }
}
