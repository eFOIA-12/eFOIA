package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.AbstractFilter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.f;
import com.google.android.gms.drive.query.internal.k;

public class NotFilter extends AbstractFilter {
   public static final Creator CREATOR = new k();
   final int CK;
   final FilterHolder Sv;

   NotFilter(int var1, FilterHolder var2) {
      this.CK = var1;
      this.Sv = var2;
   }

   public NotFilter(Filter var1) {
      this(1, new FilterHolder(var1));
   }

   public Object a(f var1) {
      return var1.j(this.Sv.getFilter().a(var1));
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      k.a(this, var1, var2);
   }
}
