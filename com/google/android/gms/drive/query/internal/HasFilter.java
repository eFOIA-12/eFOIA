package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.internal.AbstractFilter;
import com.google.android.gms.drive.query.internal.e;
import com.google.android.gms.drive.query.internal.f;
import com.google.android.gms.drive.query.internal.g;

public class HasFilter extends AbstractFilter {
   public static final g CREATOR = new g();
   final int CK;
   final MetadataBundle Si;
   final MetadataField Sj;

   HasFilter(int var1, MetadataBundle var2) {
      this.CK = var1;
      this.Si = var2;
      this.Sj = e.b(var2);
   }

   public HasFilter(SearchableMetadataField var1, Object var2) {
      this(1, MetadataBundle.a(var1, var2));
   }

   public Object a(f var1) {
      return var1.d(this.Sj, this.getValue());
   }

   public int describeContents() {
      return 0;
   }

   public Object getValue() {
      return this.Si.a(this.Sj);
   }

   public void writeToParcel(Parcel var1, int var2) {
      g.a(this, var1, var2);
   }
}
