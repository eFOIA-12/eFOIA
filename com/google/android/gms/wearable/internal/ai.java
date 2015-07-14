package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.internal.aj;

public class ai implements SafeParcelable, MessageEvent {
   public static final Creator CREATOR = new aj();
   final int CK;
   private final byte[] aeA;
   private final String ahy;
   private final String axW;
   private final int ve;

   ai(int var1, int var2, String var3, byte[] var4, String var5) {
      this.CK = var1;
      this.ve = var2;
      this.axW = var3;
      this.aeA = var4;
      this.ahy = var5;
   }

   public int describeContents() {
      return 0;
   }

   public byte[] getData() {
      return this.aeA;
   }

   public String getPath() {
      return this.axW;
   }

   public int getRequestId() {
      return this.ve;
   }

   public String getSourceNodeId() {
      return this.ahy;
   }

   public String toString() {
      StringBuilder var2 = (new StringBuilder()).append("MessageEventParcelable[").append(this.ve).append(",").append(this.axW).append(", size=");
      Object var1;
      if(this.aeA == null) {
         var1 = "null";
      } else {
         var1 = Integer.valueOf(this.aeA.length);
      }

      return var2.append(var1).append("]").toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      aj.a(this, var1, var2);
   }
}
