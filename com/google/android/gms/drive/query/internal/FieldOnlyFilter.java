package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.internal.AbstractFilter;
import com.google.android.gms.drive.query.internal.b;
import com.google.android.gms.drive.query.internal.e;
import com.google.android.gms.drive.query.internal.f;

public class FieldOnlyFilter extends AbstractFilter {
   public static final Creator CREATOR = new b();
   final int CK;
   final MetadataBundle Si;
   private final MetadataField Sj;

   FieldOnlyFilter(int var1, MetadataBundle var2) {
      this.CK = var1;
      this.Si = var2;
      this.Sj = e.b(var2);
   }

   public FieldOnlyFilter(SearchableMetadataField var1) {
      this(1, MetadataBundle.a(var1, (Object)null));
   }

   public Object a(f var1) {
      return var1.d(this.Sj);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      b.a(this, var1, var2);
   }
}
