package gov.dhs.mobile.efoia.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.parallel6.captivereachconnectsdk.models.Brand;
import com.parallel6.captivereachconnectsdk.models.CRImage;
import com.parallel6.captivereachconnectsdk.models.CRModel;

public class Suffix extends CRModel implements Parcelable {
   private static final Creator CREATOR = new Creator() {
      public Suffix createFromParcel(Parcel var1) {
         Suffix var2 = new Suffix();
         var2.setId(var1.readLong());
         var2.setTitle(var1.readString());
         var2.setDescription(var1.readString());
         var2.setContent_type(var1.readString());
         var2.setImage((CRImage)var1.readParcelable(CRImage.class.getClassLoader()));
         var2.setBrand((Brand)var1.readParcelable(Brand.class.getClassLoader()));
         return var2;
      }

      public Suffix[] newArray(int var1) {
         return new Suffix[var1];
      }
   };

   public Suffix() {
   }

   public Suffix(long var1, String var3, String var4, CRImage var5) {
      super(var1, var3, var4, var5);
   }
}
