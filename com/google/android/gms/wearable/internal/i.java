package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataItemAsset;

public class i implements DataItemAsset {
   private final String CE;
   private final String KP;

   public i(DataItemAsset var1) {
      this.CE = var1.getId();
      this.KP = var1.getDataItemKey();
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
      var1.append("DataItemAssetEntity[");
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
}
