package gov.dhs.mobile.efoia.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.Brand;
import com.parallel6.captivereachconnectsdk.models.CRImage;
import com.parallel6.captivereachconnectsdk.models.CRModel;

public class Country extends CRModel implements Parcelable {
   private static final Creator CREATOR = new Creator() {
      public Country createFromParcel(Parcel var1) {
         Country var2 = new Country();
         var2.setId(var1.readLong());
         var2.setTitle(var1.readString());
         var2.setDescription(var1.readString());
         var2.setContent_type(var1.readString());
         var2.setImage((CRImage)var1.readParcelable(CRImage.class.getClassLoader()));
         var2.setBrand((Brand)var1.readParcelable(Brand.class.getClassLoader()));
         var2.setCode(var1.readString());
         return var2;
      }

      public Country[] newArray(int var1) {
         return new Country[var1];
      }
   };
   @SerializedName("code")
   private String code;

   public Country() {
   }

   public Country(long var1, String var3, String var4, CRImage var5, String var6) {
      super(var1, var3, var4, var5);
      this.code = var6;
   }

   public String Code() {
      return this.code;
   }

   public String getCode() {
      return this.code;
   }

   public void setCode(String var1) {
      this.code = var1;
   }
}
