package gov.dhs.mobile.efoia.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.Brand;
import com.parallel6.captivereachconnectsdk.models.CRImage;
import com.parallel6.captivereachconnectsdk.models.CRModel;

public class FiveStepsItem extends CRModel implements Parcelable {
   private static final Creator CREATOR = new Creator() {
      public FiveStepsItem createFromParcel(Parcel var1) {
         FiveStepsItem var2 = new FiveStepsItem();
         var2.setId(var1.readLong());
         var2.setTitle(var1.readString());
         var2.setDescription(var1.readString());
         var2.setContent_type(var1.readString());
         var2.setImage((CRImage)var1.readParcelable(CRImage.class.getClassLoader()));
         var2.setBrand((Brand)var1.readParcelable(Brand.class.getClassLoader()));
         var2.setFoia_step_text(var1.readString());
         return var2;
      }

      public FiveStepsItem[] newArray(int var1) {
         return new FiveStepsItem[var1];
      }
   };
   @SerializedName("foia_step_text")
   String foia_step_text;

   public FiveStepsItem() {
   }

   public FiveStepsItem(long var1, String var3, String var4, CRImage var5, String var6) {
      super(var1, var3, var4, var5);
      this.foia_step_text = var6;
   }

   public FiveStepsItem(String var1) {
      this.foia_step_text = var1;
   }

   public String getFoia_step_text() {
      return this.foia_step_text;
   }

   public void setFoia_step_text(String var1) {
      this.foia_step_text = var1;
   }
}
