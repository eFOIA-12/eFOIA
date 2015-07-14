package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.internal.AbstractFilter;
import com.google.android.gms.drive.query.internal.Operator;
import com.google.android.gms.drive.query.internal.a;
import com.google.android.gms.drive.query.internal.e;
import com.google.android.gms.drive.query.internal.f;

public class ComparisonFilter extends AbstractFilter {
   public static final a CREATOR = new a();
   final int CK;
   final Operator Sh;
   final MetadataBundle Si;
   final MetadataField Sj;

   ComparisonFilter(int var1, Operator var2, MetadataBundle var3) {
      this.CK = var1;
      this.Sh = var2;
      this.Si = var3;
      this.Sj = e.b(var3);
   }

   public ComparisonFilter(Operator var1, SearchableMetadataField var2, Object var3) {
      this(1, var1, MetadataBundle.a(var2, var3));
   }

   public Object a(f var1) {
      return var1.b(this.Sh, this.Sj, this.getValue());
   }

   public int describeContents() {
      return 0;
   }

   public Object getValue() {
      return this.Si.a(this.Sj);
   }

   public void writeToParcel(Parcel var1, int var2) {
      a.a(this, var1, var2);
   }
}
