package com.google.android.gms.wearable;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.e;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

public class PutDataRequest implements SafeParcelable {
   public static final Creator CREATOR = new e();
   public static final String WEAR_URI_SCHEME = "wear";
   private static final Random axj = new SecureRandom();
   final int CK;
   private byte[] aeA;
   private final Bundle axk;
   private final Uri mUri;

   private PutDataRequest(int var1, Uri var2) {
      this(var1, var2, new Bundle(), (byte[])null);
   }

   PutDataRequest(int var1, Uri var2, Bundle var3, byte[] var4) {
      this.CK = var1;
      this.mUri = var2;
      this.axk = var3;
      this.axk.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
      this.aeA = var4;
   }

   public static PutDataRequest create(String var0) {
      return k(di(var0));
   }

   public static PutDataRequest createFromDataItem(DataItem var0) {
      PutDataRequest var1 = k(var0.getUri());
      Iterator var2 = var0.getAssets().entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if(((DataItemAsset)var3.getValue()).getId() == null) {
            throw new IllegalStateException("Cannot create an asset for a put request without a digest: " + (String)var3.getKey());
         }

         var1.putAsset((String)var3.getKey(), Asset.createFromRef(((DataItemAsset)var3.getValue()).getId()));
      }

      var1.setData(var0.getData());
      return var1;
   }

   public static PutDataRequest createWithAutoAppendedId(String var0) {
      StringBuilder var1 = new StringBuilder(var0);
      if(!var0.endsWith("/")) {
         var1.append("/");
      }

      var1.append("PN").append(axj.nextLong());
      return new PutDataRequest(1, di(var1.toString()));
   }

   private static Uri di(String var0) {
      if(TextUtils.isEmpty(var0)) {
         throw new IllegalArgumentException("An empty path was supplied.");
      } else if(!var0.startsWith("/")) {
         throw new IllegalArgumentException("A path must start with a single / .");
      } else if(var0.startsWith("//")) {
         throw new IllegalArgumentException("A path must start with a single / .");
      } else {
         return (new Builder()).scheme("wear").path(var0).build();
      }
   }

   public static PutDataRequest k(Uri var0) {
      return new PutDataRequest(1, var0);
   }

   public int describeContents() {
      return 0;
   }

   public Asset getAsset(String var1) {
      return (Asset)this.axk.getParcelable(var1);
   }

   public Map getAssets() {
      HashMap var1 = new HashMap();
      Iterator var2 = this.axk.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var1.put(var3, (Asset)this.axk.getParcelable(var3));
      }

      return Collections.unmodifiableMap(var1);
   }

   public byte[] getData() {
      return this.aeA;
   }

   public Uri getUri() {
      return this.mUri;
   }

   public boolean hasAsset(String var1) {
      return this.axk.containsKey(var1);
   }

   public PutDataRequest putAsset(String var1, Asset var2) {
      jx.i(var1);
      jx.i(var2);
      this.axk.putParcelable(var1, var2);
      return this;
   }

   public PutDataRequest removeAsset(String var1) {
      this.axk.remove(var1);
      return this;
   }

   public Bundle rk() {
      return this.axk;
   }

   public PutDataRequest setData(byte[] var1) {
      this.aeA = var1;
      return this;
   }

   public String toString() {
      return this.toString(Log.isLoggable("DataMap", 3));
   }

   public String toString(boolean var1) {
      StringBuilder var3 = new StringBuilder("PutDataRequest[");
      StringBuilder var4 = (new StringBuilder()).append("dataSz=");
      Object var2;
      if(this.aeA == null) {
         var2 = "null";
      } else {
         var2 = Integer.valueOf(this.aeA.length);
      }

      var3.append(var4.append(var2).toString());
      var3.append(", numAssets=" + this.axk.size());
      var3.append(", uri=" + this.mUri);
      if(!var1) {
         var3.append("]");
         return var3.toString();
      } else {
         var3.append("]\n  assets: ");
         Iterator var5 = this.axk.keySet().iterator();

         while(var5.hasNext()) {
            String var6 = (String)var5.next();
            var3.append("\n    " + var6 + ": " + this.axk.getParcelable(var6));
         }

         var3.append("\n  ]");
         return var3.toString();
      }
   }

   public void writeToParcel(Parcel var1, int var2) {
      e.a(this, var1, var2);
   }
}
