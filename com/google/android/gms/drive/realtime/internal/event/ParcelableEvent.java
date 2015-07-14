package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.ObjectChangedDetails;
import com.google.android.gms.drive.realtime.internal.event.ReferenceShiftedDetails;
import com.google.android.gms.drive.realtime.internal.event.TextDeletedDetails;
import com.google.android.gms.drive.realtime.internal.event.TextInsertedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValueChangedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValuesAddedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValuesRemovedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValuesSetDetails;
import com.google.android.gms.drive.realtime.internal.event.b;
import java.util.List;

public class ParcelableEvent implements SafeParcelable {
   public static final Creator CREATOR = new b();
   final int CK;
   final String SJ;
   final String SM;
   final List SQ;
   final boolean SR;
   final String SS;
   final TextInsertedDetails ST;
   final TextDeletedDetails SU;
   final ValuesAddedDetails SV;
   final ValuesRemovedDetails SW;
   final ValuesSetDetails SX;
   final ValueChangedDetails SY;
   final ReferenceShiftedDetails SZ;
   final ObjectChangedDetails Ta;
   final String vZ;

   ParcelableEvent(int var1, String var2, String var3, List var4, boolean var5, String var6, String var7, TextInsertedDetails var8, TextDeletedDetails var9, ValuesAddedDetails var10, ValuesRemovedDetails var11, ValuesSetDetails var12, ValueChangedDetails var13, ReferenceShiftedDetails var14, ObjectChangedDetails var15) {
      this.CK = var1;
      this.vZ = var2;
      this.SJ = var3;
      this.SQ = var4;
      this.SR = var5;
      this.SM = var6;
      this.SS = var7;
      this.ST = var8;
      this.SU = var9;
      this.SV = var10;
      this.SW = var11;
      this.SX = var12;
      this.SY = var13;
      this.SZ = var14;
      this.Ta = var15;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      b.a(this, var1, var2);
   }
}
