package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebImage implements SafeParcelable {
   public static final Creator CREATOR = new b();
   private final int CK;
   private final Uri LU;
   private final int li;
   private final int lj;

   WebImage(int var1, Uri var2, int var3, int var4) {
      this.CK = var1;
      this.LU = var2;
      this.li = var3;
      this.lj = var4;
   }

   public WebImage(Uri var1) throws IllegalArgumentException {
      this(var1, 0, 0);
   }

   public WebImage(Uri var1, int var2, int var3) throws IllegalArgumentException {
      this(1, var1, var2, var3);
      if(var1 == null) {
         throw new IllegalArgumentException("url cannot be null");
      } else if(var2 < 0 || var3 < 0) {
         throw new IllegalArgumentException("width and height must not be negative");
      }
   }

   public WebImage(JSONObject var1) throws IllegalArgumentException {
      this(d(var1), var1.optInt("width", 0), var1.optInt("height", 0));
   }

   private static Uri d(JSONObject var0) {
      Uri var1 = null;
      if(var0.has("url")) {
         try {
            var1 = Uri.parse(var0.getString("url"));
         } catch (JSONException var2) {
            return null;
         }
      }

      return var1;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 == null || !(var1 instanceof WebImage)) {
            return false;
         }

         WebImage var2 = (WebImage)var1;
         if(!jv.equal(this.LU, var2.LU) || this.li != var2.li || this.lj != var2.lj) {
            return false;
         }
      }

      return true;
   }

   public int getHeight() {
      return this.lj;
   }

   public Uri getUrl() {
      return this.LU;
   }

   int getVersionCode() {
      return this.CK;
   }

   public int getWidth() {
      return this.li;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.LU, Integer.valueOf(this.li), Integer.valueOf(this.lj)});
   }

   public JSONObject toJson() {
      JSONObject var1 = new JSONObject();

      try {
         var1.put("url", this.LU.toString());
         var1.put("width", this.li);
         var1.put("height", this.lj);
         return var1;
      } catch (JSONException var3) {
         return var1;
      }
   }

   public String toString() {
      return String.format("Image %dx%d %s", new Object[]{Integer.valueOf(this.li), Integer.valueOf(this.lj), this.LU.toString()});
   }

   public void writeToParcel(Parcel var1, int var2) {
      b.a(this, var1, var2);
   }
}
