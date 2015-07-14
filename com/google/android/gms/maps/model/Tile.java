package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.aa;
import com.google.android.gms.maps.model.u;
import com.google.android.gms.maps.model.v;

public final class Tile implements SafeParcelable {
   public static final u CREATOR = new u();
   private final int CK;
   public final byte[] data;
   public final int height;
   public final int width;

   Tile(int var1, int var2, int var3, byte[] var4) {
      this.CK = var1;
      this.width = var2;
      this.height = var3;
      this.data = var4;
   }

   public Tile(int var1, int var2, byte[] var3) {
      this(1, var1, var2, var3);
   }

   public int describeContents() {
      return 0;
   }

   int getVersionCode() {
      return this.CK;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(aa.ob()) {
         v.a(this, var1, var2);
      } else {
         u.a(this, var1, var2);
      }
   }
}
