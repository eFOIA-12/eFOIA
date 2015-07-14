package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.games.appcontent.AppContentCardRef;
import com.google.android.gms.games.appcontent.AppContentSection;
import com.google.android.gms.games.appcontent.AppContentSectionEntity;
import com.google.android.gms.games.appcontent.AppContentUtils;
import com.google.android.gms.games.appcontent.MultiDataBufferRef;
import java.util.ArrayList;
import java.util.List;

public final class AppContentSectionRef extends MultiDataBufferRef implements AppContentSection {
   private final int Ya;

   AppContentSectionRef(ArrayList var1, int var2, int var3) {
      super(var1, 0, var2);
      this.Ya = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return AppContentSectionEntity.a(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.la();
   }

   // $FF: synthetic method
   public List getActions() {
      return this.lb();
   }

   public String getTitle() {
      return this.getString("section_title");
   }

   public String getType() {
      return this.getString("section_type");
   }

   public int hashCode() {
      return AppContentSectionEntity.a(this);
   }

   public String kI() {
      return this.getString("section_content_description");
   }

   public Bundle kP() {
      return AppContentUtils.d(this.JG, this.XX, "section_data", this.KZ);
   }

   public String kQ() {
      return this.getString("section_subtitle");
   }

   public Uri kY() {
      return this.aR("section_background_image_uri");
   }

   // $FF: synthetic method
   public List kZ() {
      return this.lc();
   }

   public AppContentSection la() {
      return new AppContentSectionEntity(this);
   }

   public ArrayList lb() {
      return AppContentUtils.a(this.JG, this.XX, "section_actions", this.KZ);
   }

   public ArrayList lc() {
      ArrayList var2 = new ArrayList(this.Ya);

      for(int var1 = 0; var1 < this.Ya; ++var1) {
         var2.add(new AppContentCardRef(this.XX, this.KZ + var1));
      }

      return var2;
   }

   public String toString() {
      return AppContentSectionEntity.b(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((AppContentSectionEntity)this.la()).writeToParcel(var1, var2);
   }
}
