package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.internal.k;
import com.google.android.gms.wearable.internal.l;
import java.util.HashMap;
import java.util.Map;

public final class o extends com.google.android.gms.common.data.d implements DataItem {
   private final int Ya;

   public o(DataHolder var1, int var2, int var3) {
      super(var1, var2);
      this.Ya = var3;
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.rp();
   }

   public Map getAssets() {
      HashMap var2 = new HashMap(this.Ya);

      for(int var1 = 0; var1 < this.Ya; ++var1) {
         k var3 = new k(this.JG, this.KZ + var1);
         if(var3.getDataItemKey() != null) {
            var2.put(var3.getDataItemKey(), var3);
         }
      }

      return var2;
   }

   public byte[] getData() {
      return this.getByteArray("data");
   }

   public Uri getUri() {
      return Uri.parse(this.getString("path"));
   }

   public DataItem rp() {
      return new l(this);
   }

   public DataItem setData(byte[] var1) {
      throw new UnsupportedOperationException();
   }
}
