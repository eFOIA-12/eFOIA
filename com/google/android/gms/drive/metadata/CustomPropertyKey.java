package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.c;
import com.google.android.gms.internal.jx;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomPropertyKey implements SafeParcelable {
   public static final Creator CREATOR = new c();
   public static final int PRIVATE = 1;
   public static final int PUBLIC = 0;
   private static final Pattern Rc = Pattern.compile("[\\w.!@$%^&*()/-]+");
   final int CK;
   final String KP;
   final int mVisibility;

   CustomPropertyKey(int var1, String var2, int var3) {
      boolean var5 = true;
      super();
      jx.b((Object)var2, "key");
      jx.b(Rc.matcher(var2).matches(), "key name characters must be alphanumeric or one of .!@$%^&*()-_/");
      boolean var4 = var5;
      if(var3 != 0) {
         if(var3 == 1) {
            var4 = var5;
         } else {
            var4 = false;
         }
      }

      jx.b(var4, "visibility must be either PUBLIC or PRIVATE");
      this.CK = var1;
      this.KP = var2;
      this.mVisibility = var3;
   }

   public CustomPropertyKey(String var1, int var2) {
      this(1, var1, var2);
   }

   public static CustomPropertyKey fromJson(JSONObject var0) throws JSONException {
      return new CustomPropertyKey(var0.getString("key"), var0.getInt("visibility"));
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      boolean var2 = true;
      if(var1 != null) {
         if(var1 == this) {
            return true;
         }

         if(var1 instanceof CustomPropertyKey) {
            CustomPropertyKey var3 = (CustomPropertyKey)var1;
            if(!var3.getKey().equals(this.KP) || var3.getVisibility() != this.mVisibility) {
               var2 = false;
            }

            return var2;
         }
      }

      return false;
   }

   public String getKey() {
      return this.KP;
   }

   public int getVisibility() {
      return this.mVisibility;
   }

   public int hashCode() {
      return (this.KP + this.mVisibility).hashCode();
   }

   public JSONObject toJson() throws JSONException {
      JSONObject var1 = new JSONObject();
      var1.put("key", this.getKey());
      var1.put("visibility", this.getVisibility());
      return var1;
   }

   public String toString() {
      return "CustomPropertyKey(" + this.KP + "," + this.mVisibility + ")";
   }

   public void writeToParcel(Parcel var1, int var2) {
      c.a(this, var1, var2);
   }
}
