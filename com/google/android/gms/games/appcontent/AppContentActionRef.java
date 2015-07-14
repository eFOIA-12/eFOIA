package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.games.appcontent.AppContentAction;
import com.google.android.gms.games.appcontent.AppContentActionEntity;
import com.google.android.gms.games.appcontent.AppContentUtils;
import com.google.android.gms.games.appcontent.MultiDataBufferRef;
import java.util.ArrayList;
import java.util.List;

public final class AppContentActionRef extends MultiDataBufferRef implements AppContentAction {
   AppContentActionRef(ArrayList var1, int var2) {
      super(var1, 1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return AppContentActionEntity.a(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.kK();
   }

   public Bundle getExtras() {
      return AppContentUtils.d(this.JG, this.XX, "action_data", this.KZ);
   }

   public String getLabel() {
      return this.getString("action_label");
   }

   public String getType() {
      return this.getString("action_type");
   }

   public int hashCode() {
      return AppContentActionEntity.a(this);
   }

   public List kH() {
      return AppContentUtils.c(this.JG, this.XX, "action_conditions", this.KZ);
   }

   public String kI() {
      return this.getString("action_content_description");
   }

   public String kJ() {
      return this.getString("action_label_style");
   }

   public AppContentAction kK() {
      return new AppContentActionEntity(this);
   }

   public String toString() {
      return AppContentActionEntity.b(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((AppContentActionEntity)this.kK()).writeToParcel(var1, var2);
   }
}
