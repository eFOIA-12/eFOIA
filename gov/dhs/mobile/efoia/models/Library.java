package gov.dhs.mobile.efoia.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.Brand;
import com.parallel6.captivereachconnectsdk.models.CRImage;
import com.parallel6.captivereachconnectsdk.models.CRModel;

public class Library extends CRModel implements Parcelable {
   private static final Creator CREATOR = new Creator() {
      public Library createFromParcel(Parcel var1) {
         Library var2 = new Library();
         var2.setId(var1.readLong());
         var2.setTitle(var1.readString());
         var2.setDescription(var1.readString());
         var2.setContent_type(var1.readString());
         var2.setImage((CRImage)var1.readParcelable(CRImage.class.getClassLoader()));
         var2.setBrand((Brand)var1.readParcelable(Brand.class.getClassLoader()));
         var2.setLibrary_url(var1.readString());
         return var2;
      }

      public Library[] newArray(int var1) {
         return new Library[var1];
      }
   };
   @SerializedName("library_url")
   private String library_url;

   public Library() {
   }

   public Library(long var1, String var3, String var4, CRImage var5, String var6) {
      super(var1, var3, var4, var5);
      this.library_url = var6;
   }

   public String getLibrary_url() {
      return this.library_url;
   }

   public void setLibrary_url(String var1) {
      this.library_url = var1;
   }
}
