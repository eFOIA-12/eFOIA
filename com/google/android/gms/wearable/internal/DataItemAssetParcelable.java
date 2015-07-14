package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.internal.j;

public class DataItemAssetParcelable implements SafeParcelable, DataItemAsset {
   public static final Creator CREATOR = new j();
   private final String CE;
   final int CK;
   private final String KP;

   DataItemAssetParcelable(int var1, String var2, String var3) {
      this.CK = var1;
      this.CE = var2;
      this.KP = var3;
   }

   public DataItemAssetParcelable(DataItemAsset var1) {
      this.CK = 1;
      this.CE = (String)jx.i(var1.getId());
      this.KP = (String)jx.i(var1.getDataItemKey());
   }

   public int describeContents() {
      return 0;
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.ro();
   }

   public String getDataItemKey() {
      return this.KP;
   }

   public String getId() {
      return this.CE;
   }

   public boolean isDataValid() {
      return true;
   }

   public DataItemAsset ro() {
      return this;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("DataItemAssetParcelable[");
      var1.append("@");
      var1.append(Integer.toHexString(this.hashCode()));
      if(this.CE == null) {
         var1.append(",noid");
      } else {
         var1.append(",");
         var1.append(this.CE);
      }

      var1.append(", key=");
      var1.append(this.KP);
      var1.append("]");
      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      j.a(this, var1, var2);
   }
}
