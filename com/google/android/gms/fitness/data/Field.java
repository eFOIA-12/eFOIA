package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.j;
import com.google.android.gms.internal.jx;

public final class Field implements SafeParcelable {
   public static final Creator CREATOR = new j();
   public static final Field FIELD_ACCURACY = bv("accuracy");
   public static final Field FIELD_ACTIVITY = bu("activity");
   public static final Field FIELD_ALTITUDE = bv("altitude");
   public static final Field FIELD_AVERAGE = bv("average");
   public static final Field FIELD_BPM = bv("bpm");
   public static final Field FIELD_CALORIES = bv("calories");
   public static final Field FIELD_CONFIDENCE = bv("confidence");
   public static final Field FIELD_DISTANCE = bv("distance");
   public static final Field FIELD_DURATION = bu("duration");
   public static final Field FIELD_HEIGHT = bv("height");
   public static final Field FIELD_HIGH_LATITUDE = bv("high_latitude");
   public static final Field FIELD_HIGH_LONGITUDE = bv("high_longitude");
   public static final Field FIELD_LATITUDE = bv("latitude");
   public static final Field FIELD_LONGITUDE = bv("longitude");
   public static final Field FIELD_LOW_LATITUDE = bv("low_latitude");
   public static final Field FIELD_LOW_LONGITUDE = bv("low_longitude");
   public static final Field FIELD_MAX = bv("max");
   public static final Field FIELD_MIN = bv("min");
   public static final Field FIELD_NUM_SEGMENTS = bu("num_segments");
   public static final Field FIELD_REVOLUTIONS = bu("revolutions");
   public static final Field FIELD_RPM = bv("rpm");
   public static final Field FIELD_SPEED = bv("speed");
   public static final Field FIELD_STEPS = bu("steps");
   public static final Field FIELD_WATTS = bv("watts");
   public static final Field FIELD_WEIGHT = bv("weight");
   public static final int FORMAT_FLOAT = 2;
   public static final int FORMAT_INT32 = 1;
   public static final Field UA = bu("edge_type");
   public static final Field UB = bv("x");
   public static final Field UC = bv("y");
   public static final Field UD = bv("z");
   private final int CK;
   private final int UE;
   private final String mName;

   Field(int var1, String var2, int var3) {
      this.CK = var1;
      this.mName = (String)jx.i(var2);
      this.UE = var3;
   }

   public Field(String var1, int var2) {
      this(1, var1, var2);
   }

   private boolean a(Field var1) {
      return this.mName.equals(var1.mName) && this.UE == var1.UE;
   }

   private static Field bu(String var0) {
      return new Field(var0, 1);
   }

   private static Field bv(String var0) {
      return new Field(var0, 2);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof Field && this.a((Field)var1);
   }

   public int getFormat() {
      return this.UE;
   }

   public String getName() {
      return this.mName;
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return this.mName.hashCode();
   }

   public String toString() {
      String var2 = this.mName;
      String var1;
      if(this.UE == 1) {
         var1 = "i";
      } else {
         var1 = "f";
      }

      return String.format("%s(%s)", new Object[]{var2, var1});
   }

   public void writeToParcel(Parcel var1, int var2) {
      j.a(this, var1, var2);
   }
}
