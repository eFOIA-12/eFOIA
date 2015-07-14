package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.f;
import com.google.android.gms.internal.jx;
import java.util.List;

public class RealtimeDocumentSyncRequest implements SafeParcelable {
   public static final Creator CREATOR = new f();
   final int CK;
   final List OK;
   final List OL;

   RealtimeDocumentSyncRequest(int var1, List var2, List var3) {
      this.CK = var1;
      this.OK = (List)jx.i(var2);
      this.OL = (List)jx.i(var3);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      f.a(this, var1, var2);
   }
}
