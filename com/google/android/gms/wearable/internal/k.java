package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.internal.i;

public class k extends com.google.android.gms.common.data.d implements DataItemAsset {
   public k(DataHolder var1, int var2) {
      super(var1, var2);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.ro();
   }

   public String getDataItemKey() {
      return this.getString("asset_key");
   }

   public String getId() {
      return this.getString("asset_id");
   }

   public DataItemAsset ro() {
      return new i(this);
   }
}
