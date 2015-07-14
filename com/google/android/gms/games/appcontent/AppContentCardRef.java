package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.games.appcontent.AppContentCard;
import com.google.android.gms.games.appcontent.AppContentCardEntity;
import com.google.android.gms.games.appcontent.AppContentUtils;
import com.google.android.gms.games.appcontent.MultiDataBufferRef;
import java.util.ArrayList;
import java.util.List;

public final class AppContentCardRef extends MultiDataBufferRef implements AppContentCard {
   AppContentCardRef(ArrayList var1, int var2) {
      super(var1, 0, var2);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return AppContentCardEntity.a(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.kS();
   }

   public List getActions() {
      return AppContentUtils.a(this.JG, this.XX, "card_actions", this.KZ);
   }

   public String getDescription() {
      return this.getString("card_description");
   }

   public Uri getIconImageUri() {
      return this.aR("card_icon_image_uri");
   }

   public String getTitle() {
      return this.getString("card_title");
   }

   public String getType() {
      return this.getString("card_type");
   }

   public int hashCode() {
      return AppContentCardEntity.a(this);
   }

   public List kH() {
      return AppContentUtils.c(this.JG, this.XX, "card_conditions", this.KZ);
   }

   public String kI() {
      return this.getString("card_content_description");
   }

   public Uri kL() {
      return this.aR("card_image_uri");
   }

   public List kN() {
      return AppContentUtils.b(this.JG, this.XX, "card_annotations", this.KZ);
   }

   public int kO() {
      return this.getInteger("card_current_steps");
   }

   public Bundle kP() {
      return AppContentUtils.d(this.JG, this.XX, "card_data", this.KZ);
   }

   public String kQ() {
      return this.getString("card_subtitle");
   }

   public int kR() {
      return this.getInteger("card_total_steps");
   }

   public AppContentCard kS() {
      return new AppContentCardEntity(this);
   }

   public String toString() {
      return AppContentCardEntity.b(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((AppContentCardEntity)this.kS()).writeToParcel(var1, var2);
   }
}
