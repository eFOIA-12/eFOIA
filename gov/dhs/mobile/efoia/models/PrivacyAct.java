package gov.dhs.mobile.efoia.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.Brand;
import com.parallel6.captivereachconnectsdk.models.CRImage;
import com.parallel6.captivereachconnectsdk.models.CRModel;

public class PrivacyAct extends CRModel implements Parcelable {
   private static final Creator CREATOR = new Creator() {
      public PrivacyAct createFromParcel(Parcel var1) {
         PrivacyAct var2 = new PrivacyAct();
         var2.setId(var1.readLong());
         var2.setTitle(var1.readString());
         var2.setDescription(var1.readString());
         var2.setContent_type(var1.readString());
         var2.setImage((CRImage)var1.readParcelable(CRImage.class.getClassLoader()));
         var2.setBrand((Brand)var1.readParcelable(Brand.class.getClassLoader()));
         var2.setRequest_step(var1.readString());
         return var2;
      }

      public PrivacyAct[] newArray(int var1) {
         return new PrivacyAct[var1];
      }
   };
   @SerializedName("request_step")
   String request_step;

   public PrivacyAct() {
   }

   public PrivacyAct(long var1, String var3, String var4, CRImage var5, String var6) {
      super(var1, var3, var4, var5);
      this.request_step = var6;
   }

   public String getRequest_step() {
      return this.request_step;
   }

   public void setRequest_step(String var1) {
      this.request_step = var1;
   }
}
