package com.google.android.gms.fitness.data;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Parcel;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.i;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.mg;

public final class Device implements SafeParcelable {
   public static final Creator CREATOR = new i();
   public static final int TYPE_CHEST_STRAP = 4;
   public static final int TYPE_PHONE = 1;
   public static final int TYPE_SCALE = 5;
   public static final int TYPE_TABLET = 2;
   public static final int TYPE_UNKNOWN = 0;
   public static final int TYPE_WATCH = 3;
   private final int CK;
   private final int Gt;
   private final String TU;
   private final String Uw;
   private final String Ux;
   private final String Uy;
   private final int Uz;

   Device(int var1, String var2, String var3, String var4, String var5, int var6, int var7) {
      this.CK = var1;
      this.Uw = (String)jx.i(var2);
      this.Ux = (String)jx.i(var3);
      this.TU = "";
      this.Uy = (String)jx.i(var5);
      this.Gt = var6;
      this.Uz = var7;
   }

   public Device(String var1, String var2, String var3, int var4) {
      this(var1, var2, "", var3, var4, 0);
   }

   public Device(String var1, String var2, String var3, String var4, int var5) {
      this(var1, var2, var4, var5);
   }

   public Device(String var1, String var2, String var3, String var4, int var5, int var6) {
      this(1, var1, var2, "", var4, var5, var6);
   }

   private static String M(Context var0) {
      return Secure.getString(var0.getContentResolver(), "android_id");
   }

   private static int N(Context var0) {
      byte var2 = 0;
      byte var1 = var2;
      switch(P(var0)) {
      case 8:
      case 9:
         break;
      case 10:
         var1 = var2;
         if(O(var0)) {
            return 3;
         }
         break;
      default:
         if(!R(var0)) {
            return 2;
         }

         var1 = 1;
      }

      return var1;
   }

   public static boolean O(Context var0) {
      return (var0.getResources().getConfiguration().uiMode & 15) == 6;
   }

   private static int P(Context var0) {
      return Q(var0) % 1000 / 100 + 5;
   }

   private static int Q(Context var0) {
      try {
         int var1 = var0.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
         return var1;
      } catch (NameNotFoundException var2) {
         Log.w("Fitness", "Could not find package info for Google Play Services");
         return -1;
      }
   }

   private static boolean R(Context var0) {
      return ((TelephonyManager)var0.getSystemService("phone")).getPhoneType() != 0;
   }

   private boolean a(Device var1) {
      return jv.equal(this.Uw, var1.Uw) && jv.equal(this.Ux, var1.Ux) && jv.equal(this.TU, var1.TU) && jv.equal(this.Uy, var1.Uy) && this.Gt == var1.Gt && this.Uz == var1.Uz;
   }

   public static Device getLocalDevice(Context var0) {
      int var1 = N(var0);
      String var2 = M(var0);
      return new Device(Build.MANUFACTURER, Build.MODEL, VERSION.RELEASE, var2, var1, 2);
   }

   private boolean jD() {
      return this.jC() == 1;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof Device && this.a((Device)var1);
   }

   public String getManufacturer() {
      return this.Uw;
   }

   public String getModel() {
      return this.Ux;
   }

   String getStreamIdentifier() {
      return String.format("%s:%s:%s", new Object[]{this.Uw, this.Ux, this.Uy});
   }

   public int getType() {
      return this.Gt;
   }

   public String getUid() {
      return this.Uy;
   }

   public String getVersion() {
      return this.TU;
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.Uw, this.Ux, this.TU, this.Uy, Integer.valueOf(this.Gt)});
   }

   public int jC() {
      return this.Uz;
   }

   Device jE() {
      return new Device(mg.bw(this.Uw), mg.bw(this.Ux), mg.bw(this.TU), this.Uy, this.Gt);
   }

   public String jF() {
      return !mg.jN() && !this.jD()?mg.bw(this.Uy):this.Uy;
   }

   public String toString() {
      return String.format("Device{%s:%s:%s:%s}", new Object[]{this.getStreamIdentifier(), this.TU, Integer.valueOf(this.Gt), Integer.valueOf(this.Uz)});
   }

   public void writeToParcel(Parcel var1, int var2) {
      i.a(this, var1, var2);
   }
}
