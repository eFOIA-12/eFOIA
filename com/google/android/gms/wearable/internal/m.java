package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import com.google.android.gms.wearable.internal.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class m implements SafeParcelable, DataItem {
   public static final Creator CREATOR = new n();
   final int CK;
   private byte[] aeA;
   private final Map axH;
   private final Uri mUri;

   m(int var1, Uri var2, Bundle var3, byte[] var4) {
      this.CK = var1;
      this.mUri = var2;
      HashMap var7 = new HashMap();
      var3.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
      Iterator var5 = var3.keySet().iterator();

      while(var5.hasNext()) {
         String var6 = (String)var5.next();
         var7.put(var6, (DataItemAssetParcelable)var3.getParcelable(var6));
      }

      this.axH = var7;
      this.aeA = var4;
   }

   public int describeContents() {
      return 0;
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.rq();
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

   public m m(byte[] var1) {
      this.aeA = var1;
      return this;
   }

   public Bundle rk() {
      Bundle var1 = new Bundle();
      var1.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
      Iterator var2 = this.axH.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.putParcelable((String)var3.getKey(), new DataItemAssetParcelable((DataItemAsset)var3.getValue()));
      }

      return var1;
   }

   public m rq() {
      return this;
   }

   // $FF: synthetic method
   public DataItem setData(byte[] var1) {
      return this.m(var1);
   }

   public String toString() {
      return this.toString(Log.isLoggable("DataItem", 3));
   }

   public String toString(boolean var1) {
      StringBuilder var3 = new StringBuilder("DataItemParcelable[");
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

   public void writeToParcel(Parcel var1, int var2) {
      n.a(this, var1, var2);
   }
}
