package gov.dhs.mobile.efoia.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.Brand;
import com.parallel6.captivereachconnectsdk.models.CRImage;
import com.parallel6.captivereachconnectsdk.models.CRModel;

public class FeeStructure extends CRModel implements Parcelable {
   private static final Creator CREATOR = new Creator() {
      public FeeStructure createFromParcel(Parcel var1) {
         FeeStructure var2 = new FeeStructure();
         var2.setId(var1.readLong());
         var2.setTitle(var1.readString());
         var2.setDescription(var1.readString());
         var2.setContent_type(var1.readString());
         var2.setImage((CRImage)var1.readParcelable(CRImage.class.getClassLoader()));
         var2.setBrand((Brand)var1.readParcelable(Brand.class.getClassLoader()));
         var2.setFee_note(var1.readString());
         return var2;
      }

      public FeeStructure[] newArray(int var1) {
         return new FeeStructure[var1];
      }
   };
   @SerializedName("fee_note")
   String fee_note;

   public FeeStructure() {
   }

   public FeeStructure(long var1, String var3, String var4, CRImage var5, String var6) {
      super(var1, var3, var4, var5);
      this.fee_note = var6;
   }

   public String getFee_note() {
      return this.fee_note;
   }

   public void setFee_note(String var1) {
      this.fee_note = var1;
   }
}
