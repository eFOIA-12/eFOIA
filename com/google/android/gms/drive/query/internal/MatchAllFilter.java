package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.query.internal.AbstractFilter;
import com.google.android.gms.drive.query.internal.f;
import com.google.android.gms.drive.query.internal.j;

public class MatchAllFilter extends AbstractFilter {
   public static final j CREATOR = new j();
   final int CK;

   public MatchAllFilter() {
      this(1);
   }

   MatchAllFilter(int var1) {
      this.CK = var1;
   }

   public Object a(f var1) {
      return var1.jd();
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      j.a(this, var1, var2);
   }
}
