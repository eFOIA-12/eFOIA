package gov.dhs.mobile.efoia.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.Brand;
import com.parallel6.captivereachconnectsdk.models.CRImage;
import com.parallel6.captivereachconnectsdk.models.CRModel;

public class Component extends CRModel {
   private static final Creator CREATOR = new Creator() {
      public Component createFromParcel(Parcel var1) {
         Component var2 = new Component();
         var2.setId(var1.readLong());
         var2.setTitle(var1.readString());
         var2.setDescription(var1.readString());
         var2.setContent_type(var1.readString());
         var2.setImage((CRImage)var1.readParcelable(CRImage.class.getClassLoader()));
         var2.setBrand((Brand)var1.readParcelable(Brand.class.getClassLoader()));
         var2.setValue(var1.readString());
         return var2;
      }

      public Component[] newArray(int var1) {
         return new Component[var1];
      }
   };
   @SerializedName("value")
   private String value;

   public Component() {
   }

   public Component(long var1, String var3, String var4, CRImage var5, String var6) {
      super(var1, var3, var4, var5);
      this.value = var6;
   }

   public String getValue() {
      return this.value;
   }

   public void setValue(String var1) {
      this.value = var1;
   }
}
