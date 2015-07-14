package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.fitness.data.u;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;

public final class Value implements SafeParcelable {
   public static final Creator CREATOR = new u();
   private final int CK;
   private final int UE;
   private boolean US;
   private float UT;

   Value(int var1) {
      this(1, var1, false, 0.0F);
   }

   Value(int var1, int var2, boolean var3, float var4) {
      this.CK = var1;
      this.UE = var2;
      this.US = var3;
      this.UT = var4;
   }

   private boolean a(Value var1) {
      if(this.UE == var1.UE && this.US == var1.US) {
         switch(this.UE) {
         case 1:
            if(this.asInt() != var1.asInt()) {
               return false;
            }
            break;
         case 2:
            if(this.asFloat() != var1.asFloat()) {
               return false;
            }
            break;
         default:
            if(this.UT != var1.UT) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public String asActivity() {
      try {
         String var1 = FitnessActivities.getName(this.asInt());
         return var1;
      } catch (IllegalArgumentException var2) {
         return "unknown";
      }
   }

   public float asFloat() {
      boolean var1;
      if(this.UE == 2) {
         var1 = true;
      } else {
         var1 = false;
      }

      jx.a(var1, "Value is not in float format");
      return this.UT;
   }

   public int asInt() {
      boolean var1 = true;
      if(this.UE != 1) {
         var1 = false;
      }

      jx.a(var1, "Value is not in int format");
      return Float.floatToRawIntBits(this.UT);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof Value && this.a((Value)var1);
   }

   public int getFormat() {
      return this.UE;
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{Float.valueOf(this.UT), Integer.valueOf(this.UE), Boolean.valueOf(this.US)});
   }

   public boolean isSet() {
      return this.US;
   }

   float jL() {
      return this.UT;
   }

   public void setActivity(String var1) {
      this.setInt(FitnessActivities.bs(var1));
   }

   public void setFloat(float var1) {
      boolean var2;
      if(this.UE == 2) {
         var2 = true;
      } else {
         var2 = false;
      }

      jx.a(var2, "Attempting to set an float value to a field that is not in FLOAT format.  Please check the data type definition and use the right format.");
      this.US = true;
      this.UT = var1;
   }

   public void setInt(int var1) {
      boolean var2;
      if(this.UE == 1) {
         var2 = true;
      } else {
         var2 = false;
      }

      jx.a(var2, "Attempting to set an int value to a field that is not in INT32 format.  Please check the data type definition and use the right format.");
      this.US = true;
      this.UT = Float.intBitsToFloat(var1);
   }

   public String toString() {
      if(!this.US) {
         return "unset";
      } else {
         switch(this.UE) {
         case 1:
            return Integer.toString(this.asInt());
         case 2:
            return Float.toString(this.asFloat());
         default:
            return "unknown";
         }
      }
   }

   public void writeToParcel(Parcel var1, int var2) {
      u.a(this, var1, var2);
   }
}
