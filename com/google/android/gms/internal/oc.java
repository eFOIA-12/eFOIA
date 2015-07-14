package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.od;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public class oc implements SafeParcelable {
   public static final Creator CREATOR = new od();
   final int CK;
   private final String TW;
   private final LatLng ajX;
   private final List ajY;
   private final String ajZ;
   private final String aka;
   private final String mName;

   oc(int var1, String var2, LatLng var3, String var4, List var5, String var6, String var7) {
      this.CK = var1;
      this.mName = var2;
      this.ajX = var3;
      this.TW = var4;
      this.ajY = new ArrayList(var5);
      this.ajZ = var6;
      this.aka = var7;
   }

   public int describeContents() {
      return 0;
   }

   public String getAddress() {
      return this.TW;
   }

   public String getName() {
      return this.mName;
   }

   public String getPhoneNumber() {
      return this.ajZ;
   }

   public LatLng nx() {
      return this.ajX;
   }

   public List ny() {
      return this.ajY;
   }

   public String nz() {
      return this.aka;
   }

   public void writeToParcel(Parcel var1, int var2) {
      od.a(this, var1, var2);
   }
}
