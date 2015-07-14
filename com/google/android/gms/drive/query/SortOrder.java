package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.query.b;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SortOrder implements SafeParcelable {
   public static final Creator CREATOR = new b();
   final int CK;
   final List Sf;
   final boolean Sg;

   SortOrder(int var1, List var2, boolean var3) {
      this.CK = var1;
      this.Sf = var2;
      this.Sg = var3;
   }

   private SortOrder(List var1, boolean var2) {
      this(1, var1, var2);
   }

   // $FF: synthetic method
   SortOrder(List var1, boolean var2, Object var3) {
      this(var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public String toString() {
      return String.format(Locale.US, "SortOrder[%s, %s]", new Object[]{TextUtils.join(",", this.Sf), Boolean.valueOf(this.Sg)});
   }

   public void writeToParcel(Parcel var1, int var2) {
      b.a(this, var1, var2);
   }

   public static class Builder {
      private final List Sf = new ArrayList();
      private boolean Sg = false;

      public SortOrder.Builder addSortAscending(SortableMetadataField var1) {
         this.Sf.add(new FieldWithSortOrder(var1.getName(), true));
         return this;
      }

      public SortOrder.Builder addSortDescending(SortableMetadataField var1) {
         this.Sf.add(new FieldWithSortOrder(var1.getName(), false));
         return this;
      }

      public SortOrder build() {
         return new SortOrder(this.Sf, this.Sg, null);
      }
   }
}
