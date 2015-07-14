package gov.dhs.mobile.efoia.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.Brand;
import com.parallel6.captivereachconnectsdk.models.CRImage;
import com.parallel6.captivereachconnectsdk.models.CRModel;

public class SubmissionPageOne extends CRModel {
   public static final Creator CREATOR = new Creator() {
      public SubmissionPageOne createFromParcel(Parcel var1) {
         SubmissionPageOne var2 = new SubmissionPageOne();
         var2.setId(var1.readLong());
         var2.setTitle(var1.readString());
         var2.setDescription(var1.readString());
         var2.setContent_type(var1.readString());
         var2.setImage((CRImage)var1.readParcelable(CRImage.class.getClassLoader()));
         var2.setBrand((Brand)var1.readParcelable(Brand.class.getClassLoader()));
         var2.setSecretary(var1.readString());
         var2.setComponent(var1.readString());
         var2.setCbp(var1.readString());
         return var2;
      }

      public SubmissionPageOne[] newArray(int var1) {
         return new SubmissionPageOne[var1];
      }
   };
   @SerializedName("cbp")
   private String cbp;
   @SerializedName("component")
   private String component;
   @SerializedName("secretary")
   private String secretary;

   public int describeContents() {
      return 0;
   }

   public String getCbp() {
      return this.cbp;
   }

   public String getComponent() {
      return this.component;
   }

   public String getSecretary() {
      return this.secretary;
   }

   public void setCbp(String var1) {
      this.cbp = var1;
   }

   public void setComponent(String var1) {
      this.component = var1;
   }

   public void setSecretary(String var1) {
      this.secretary = var1;
   }

   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
      var1.writeString(this.secretary);
      var1.writeString(this.component);
      var1.writeString(this.cbp);
   }
}
