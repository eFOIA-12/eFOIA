package gov.dhs.mobile.efoia.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.Brand;
import com.parallel6.captivereachconnectsdk.models.CRImage;
import com.parallel6.captivereachconnectsdk.models.CRModel;

public class Processing extends CRModel implements Parcelable {
   private static final Creator CREATOR = new Creator() {
      public Processing createFromParcel(Parcel var1) {
         Processing var2 = new Processing();
         var2.setId(var1.readLong());
         var2.setTitle(var1.readString());
         var2.setDescription(var1.readString());
         var2.setContent_type(var1.readString());
         var2.setImage((CRImage)var1.readParcelable(CRImage.class.getClassLoader()));
         var2.setBrand((Brand)var1.readParcelable(Brand.class.getClassLoader()));
         var2.setProcessingText(var1.readString());
         return var2;
      }

      public Processing[] newArray(int var1) {
         return new Processing[var1];
      }
   };
   @SerializedName("processing_text")
   String processing_text;

   public Processing() {
   }

   public Processing(long var1, String var3, String var4, CRImage var5, String var6) {
      super(var1, var3, var4, var5);
      this.processing_text = var6;
   }

   public String getProcessingText() {
      return this.processing_text;
   }

   public void setProcessingText(String var1) {
      this.processing_text = var1;
   }
}
