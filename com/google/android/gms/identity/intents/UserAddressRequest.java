package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.a;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class UserAddressRequest implements SafeParcelable {
   public static final Creator CREATOR = new a();
   private final int CK;
   List afH;

   UserAddressRequest() {
      this.CK = 1;
   }

   UserAddressRequest(int var1, List var2) {
      this.CK = var1;
      this.afH = var2;
   }

   public static UserAddressRequest.Builder newBuilder() {
      UserAddressRequest var0 = new UserAddressRequest();
      return var0.new Builder(null);
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public void writeToParcel(Parcel var1, int var2) {
      a.a(this, var1, var2);
   }

   public final class Builder {
      private Builder() {
      }

      // $FF: synthetic method
      Builder(Object var2) {
         this();
      }

      public UserAddressRequest.Builder addAllowedCountrySpecification(CountrySpecification var1) {
         if(UserAddressRequest.this.afH == null) {
            UserAddressRequest.this.afH = new ArrayList();
         }

         UserAddressRequest.this.afH.add(var1);
         return this;
      }

      public UserAddressRequest.Builder addAllowedCountrySpecifications(Collection var1) {
         if(UserAddressRequest.this.afH == null) {
            UserAddressRequest.this.afH = new ArrayList();
         }

         UserAddressRequest.this.afH.addAll(var1);
         return this;
      }

      public UserAddressRequest build() {
         if(UserAddressRequest.this.afH != null) {
            UserAddressRequest.this.afH = Collections.unmodifiableList(UserAddressRequest.this.afH);
         }

         return UserAddressRequest.this;
      }
   }
}
