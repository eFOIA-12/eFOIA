package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.request.i;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataTypeCreateRequest implements SafeParcelable {
   public static final Creator CREATOR = new i();
   private final int CK;
   private final List Uv;
   private final String mName;

   DataTypeCreateRequest(int var1, String var2, List var3) {
      this.CK = var1;
      this.mName = var2;
      this.Uv = Collections.unmodifiableList(var3);
   }

   private DataTypeCreateRequest(DataTypeCreateRequest.Builder var1) {
      this.CK = 1;
      this.mName = var1.mName;
      this.Uv = Collections.unmodifiableList(var1.Uv);
   }

   // $FF: synthetic method
   DataTypeCreateRequest(DataTypeCreateRequest.Builder var1, Object var2) {
      this(var1);
   }

   private boolean a(DataTypeCreateRequest var1) {
      return jv.equal(this.mName, var1.mName) && jv.equal(this.Uv, var1.Uv);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof DataTypeCreateRequest && this.a((DataTypeCreateRequest)var1);
   }

   public List getFields() {
      return this.Uv;
   }

   public String getName() {
      return this.mName;
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.mName, this.Uv});
   }

   public String toString() {
      return jv.h(this).a("name", this.mName).a("fields", this.Uv).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      i.a(this, var1, var2);
   }

   public static class Builder {
      private List Uv = new ArrayList();
      private String mName;

      public DataTypeCreateRequest.Builder addField(Field var1) {
         if(!this.Uv.contains(var1)) {
            this.Uv.add(var1);
         }

         return this;
      }

      public DataTypeCreateRequest.Builder addField(String var1, int var2) {
         boolean var3;
         if(var1 == null && var1.isEmpty()) {
            var3 = false;
         } else {
            var3 = true;
         }

         jx.b(var3, "Invalid name specified");
         return this.addField(new Field(var1, var2));
      }

      public DataTypeCreateRequest build() {
         boolean var2 = true;
         boolean var1;
         if(this.mName != null) {
            var1 = true;
         } else {
            var1 = false;
         }

         jx.a(var1, "Must set the name");
         if(!this.Uv.isEmpty()) {
            var1 = var2;
         } else {
            var1 = false;
         }

         jx.a(var1, "Must specify the data fields");
         return new DataTypeCreateRequest(this, null);
      }

      public DataTypeCreateRequest.Builder setName(String var1) {
         this.mName = var1;
         return this;
      }
   }
}
