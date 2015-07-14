package gov.dhs.mobile.efoia.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.Brand;
import com.parallel6.captivereachconnectsdk.models.CRImage;
import com.parallel6.captivereachconnectsdk.models.CRModel;

public class Statutes extends CRModel {
   private static final Creator CREATOR = new Creator() {
      public Statutes createFromParcel(Parcel var1) {
         Statutes var2 = new Statutes();
         var2.setId(var1.readLong());
         var2.setTitle(var1.readString());
         var2.setDescription(var1.readString());
         var2.setContent_type(var1.readString());
         var2.setImage((CRImage)var1.readParcelable(CRImage.class.getClassLoader()));
         var2.setBrand((Brand)var1.readParcelable(Brand.class.getClassLoader()));
         var2.setStatutes_url(var1.readString());
         return var2;
      }

      public Statutes[] newArray(int var1) {
         return new Statutes[var1];
      }
   };
   @SerializedName("statutes_url")
   private String statutes_url;

   public Statutes() {
   }

   public Statutes(long var1, String var3, String var4, CRImage var5, String var6) {
      super(var1, var3, var4, var5);
      this.statutes_url = var6;
   }

   public String getStatutes_url() {
      return this.statutes_url;
   }

   public void setStatutes_url(String var1) {
      this.statutes_url = var1;
   }
}
