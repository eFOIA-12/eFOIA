package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class l implements DataItem {
   private byte[] aeA;
   private Map axH;
   private Uri mUri;

   public l(DataItem var1) {
      this.mUri = var1.getUri();
      this.aeA = var1.getData();
      HashMap var2 = new HashMap();
      Iterator var4 = var1.getAssets().entrySet().iterator();

      while(var4.hasNext()) {
         Entry var3 = (Entry)var4.next();
         if(var3.getKey() != null) {
            var2.put(var3.getKey(), ((DataItemAsset)var3.getValue()).freeze());
         }
      }

      this.axH = Collections.unmodifiableMap(var2);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.rp();
   }

   public Map getAssets() {
      return this.axH;
   }

   public byte[] getData() {
      return this.aeA;
   }

   public Uri getUri() {
      return this.mUri;
   }

   public boolean isDataValid() {
      return true;
   }

   public DataItem rp() {
      return this;
   }

   public DataItem setData(byte[] var1) {
      throw new UnsupportedOperationException();
   }

   public String toString() {
      return this.toString(Log.isLoggable("DataItem", 3));
   }

   public String toString(boolean var1) {
      StringBuilder var3 = new StringBuilder("DataItemEntity[");
      var3.append("@");
      var3.append(Integer.toHexString(this.hashCode()));
      StringBuilder var4 = (new StringBuilder()).append(",dataSz=");
      Object var2;
      if(this.aeA == null) {
         var2 = "null";
      } else {
         var2 = Integer.valueOf(this.aeA.length);
      }

      var3.append(var4.append(var2).toString());
      var3.append(", numAssets=" + this.axH.size());
      var3.append(", uri=" + this.mUri);
      if(!var1) {
         var3.append("]");
         return var3.toString();
      } else {
         var3.append("]\n  assets: ");
         Iterator var5 = this.axH.keySet().iterator();

         while(var5.hasNext()) {
            String var6 = (String)var5.next();
            var3.append("\n    " + var6 + ": " + this.axH.get(var6));
         }

         var3.append("\n  ]");
         return var3.toString();
      }
   }
}
