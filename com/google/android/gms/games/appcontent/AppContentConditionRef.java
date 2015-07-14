package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.games.appcontent.AppContentCondition;
import com.google.android.gms.games.appcontent.AppContentConditionEntity;
import com.google.android.gms.games.appcontent.AppContentUtils;
import com.google.android.gms.games.appcontent.MultiDataBufferRef;
import java.util.ArrayList;

public final class AppContentConditionRef extends MultiDataBufferRef implements AppContentCondition {
   AppContentConditionRef(ArrayList var1, int var2) {
      super(var1, 4, var2);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return AppContentConditionEntity.a(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.kX();
   }

   public int hashCode() {
      return AppContentConditionEntity.a(this);
   }

   public String kT() {
      return this.getString("condition_default_value");
   }

   public String kU() {
      return this.getString("condition_expected_value");
   }

   public String kV() {
      return this.getString("condition_predicate");
   }

   public Bundle kW() {
      return AppContentUtils.d(this.JG, this.XX, "condition_predicate_parameters", this.KZ);
   }

   public AppContentCondition kX() {
      return new AppContentConditionEntity(this);
   }

   public String toString() {
      return AppContentConditionEntity.b(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((AppContentConditionEntity)this.kX()).writeToParcel(var1, var2);
   }
}
