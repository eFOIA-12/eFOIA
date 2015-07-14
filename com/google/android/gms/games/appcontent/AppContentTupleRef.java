package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.appcontent.AppContentTuple;
import com.google.android.gms.games.appcontent.AppContentTupleEntity;

public final class AppContentTupleRef extends d implements AppContentTuple {
   AppContentTupleRef(DataHolder var1, int var2) {
      super(var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return AppContentTupleEntity.a(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.ld();
   }

   public String getName() {
      return this.getString("tuple_name");
   }

   public String getValue() {
      return this.getString("tuple_value");
   }

   public int hashCode() {
      return AppContentTupleEntity.a(this);
   }

   public AppContentTuple ld() {
      return new AppContentTupleEntity(this);
   }

   public String toString() {
      return AppContentTupleEntity.b(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((AppContentTupleEntity)this.ld()).writeToParcel(var1, var2);
   }
}
