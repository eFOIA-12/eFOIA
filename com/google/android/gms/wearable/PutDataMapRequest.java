package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.internal.ql;
import com.google.android.gms.internal.qw;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.PutDataRequest;

public class PutDataMapRequest {
   private final DataMap axh;
   private final PutDataRequest axi;

   private PutDataMapRequest(PutDataRequest var1, DataMap var2) {
      this.axi = var1;
      this.axh = new DataMap();
      if(var2 != null) {
         this.axh.putAll(var2);
      }

   }

   public static PutDataMapRequest create(String var0) {
      return new PutDataMapRequest(PutDataRequest.create(var0), (DataMap)null);
   }

   public static PutDataMapRequest createFromDataMapItem(DataMapItem var0) {
      return new PutDataMapRequest(PutDataRequest.k(var0.getUri()), var0.getDataMap());
   }

   public static PutDataMapRequest createWithAutoAppendedId(String var0) {
      return new PutDataMapRequest(PutDataRequest.createWithAutoAppendedId(var0), (DataMap)null);
   }

   public PutDataRequest asPutDataRequest() {
      ql.a var3 = ql.a(this.axh);
      this.axi.setData(qw.f(var3.ayo));
      int var2 = var3.ayp.size();

      for(int var1 = 0; var1 < var2; ++var1) {
         String var4 = Integer.toString(var1);
         Asset var5 = (Asset)var3.ayp.get(var1);
         if(var4 == null) {
            throw new IllegalStateException("asset key cannot be null: " + var5);
         }

         if(var5 == null) {
            throw new IllegalStateException("asset cannot be null: key=" + var4);
         }

         if(Log.isLoggable("DataMap", 3)) {
            Log.d("DataMap", "asPutDataRequest: adding asset: " + var4 + " " + var5);
         }

         this.axi.putAsset(var4, var5);
      }

      return this.axi;
   }

   public DataMap getDataMap() {
      return this.axh;
   }

   public Uri getUri() {
      return this.axi.getUri();
   }
}
