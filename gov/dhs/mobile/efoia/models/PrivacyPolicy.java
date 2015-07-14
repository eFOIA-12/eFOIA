package gov.dhs.mobile.efoia.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.Brand;
import com.parallel6.captivereachconnectsdk.models.CRImage;
import com.parallel6.captivereachconnectsdk.models.CRModel;

public class PrivacyPolicy extends CRModel implements Parcelable {
   private static final Creator CREATOR = new Creator() {
      public PrivacyPolicy createFromParcel(Parcel var1) {
         PrivacyPolicy var2 = new PrivacyPolicy();
         var2.setId(var1.readLong());
         var2.setTitle(var1.readString());
         var2.setDescription(var1.readString());
         var2.setContent_type(var1.readString());
         var2.setImage((CRImage)var1.readParcelable(CRImage.class.getClassLoader()));
         var2.setBrand((Brand)var1.readParcelable(Brand.class.getClassLoader()));
         var2.setPolicy(var1.readString());
         return var2;
      }

      public PrivacyPolicy[] newArray(int var1) {
         return new PrivacyPolicy[var1];
      }
   };
   @SerializedName("policy")
   String policy;

   public PrivacyPolicy() {
   }

   public PrivacyPolicy(long var1, String var3, String var4, CRImage var5, String var6) {
      super(var1, var3, var4, var5);
      this.policy = var6;
   }

   public String getPolicy() {
      return this.policy;
   }

   public void setPolicy(String var1) {
      this.policy = var1;
   }
}
