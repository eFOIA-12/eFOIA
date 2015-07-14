package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.internal.AbstractFilter;
import com.google.android.gms.drive.query.internal.e;
import com.google.android.gms.drive.query.internal.f;
import com.google.android.gms.drive.query.internal.h;
import java.util.Collection;
import java.util.Collections;

public class InFilter extends AbstractFilter {
   public static final h CREATOR = new h();
   final int CK;
   final MetadataBundle Si;
   private final com.google.android.gms.drive.metadata.b St;

   InFilter(int var1, MetadataBundle var2) {
      this.CK = var1;
      this.Si = var2;
      this.St = (com.google.android.gms.drive.metadata.b)e.b(var2);
   }

   public InFilter(SearchableCollectionMetadataField var1, Object var2) {
      this(1, MetadataBundle.a(var1, Collections.singleton(var2)));
   }

   public Object a(f var1) {
      return var1.b(this.St, this.getValue());
   }

   public int describeContents() {
      return 0;
   }

   public Object getValue() {
      return ((Collection)this.Si.a((MetadataField)this.St)).iterator().next();
   }

   public void writeToParcel(Parcel var1, int var2) {
      h.a(this, var1, var2);
   }
}
