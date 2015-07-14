package com.google.android.gms.games.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.ConnectionInfoCreator;

public class ConnectionInfo implements SafeParcelable {
   public static final ConnectionInfoCreator CREATOR = new ConnectionInfoCreator();
   private final int CK;
   private final String Yi;
   private final int Yj;

   public ConnectionInfo(int var1, String var2, int var3) {
      this.CK = var1;
      this.Yi = var2;
      this.Yj = var3;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public String le() {
      return this.Yi;
   }

   public int lf() {
      return this.Yj;
   }

   public void writeToParcel(Parcel var1, int var2) {
      ConnectionInfoCreator.a(this, var1, var2);
   }
}
