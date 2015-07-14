package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.games.appcontent.AppContentAnnotation;
import com.google.android.gms.games.appcontent.AppContentAnnotationEntity;
import com.google.android.gms.games.appcontent.MultiDataBufferRef;
import java.util.ArrayList;

public final class AppContentAnnotationRef extends MultiDataBufferRef implements AppContentAnnotation {
   AppContentAnnotationRef(ArrayList var1, int var2) {
      super(var1, 2, var2);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return AppContentAnnotationEntity.a(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.kM();
   }

   public String getDescription() {
      return this.getString("annotation_description");
   }

   public String getTitle() {
      return this.getString("annotation_title");
   }

   public String getType() {
      return this.getString("annotation_type");
   }

   public int hashCode() {
      return AppContentAnnotationEntity.a(this);
   }

   public Uri kL() {
      return this.aR("annotation_image_uri");
   }

   public AppContentAnnotation kM() {
      return new AppContentAnnotationEntity(this);
   }

   public String toString() {
      return AppContentAnnotationEntity.b(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((AppContentAnnotationEntity)this.kM()).writeToParcel(var1, var2);
   }
}
