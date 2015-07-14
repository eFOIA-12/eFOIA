package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ResourceEvent;
import com.google.android.gms.drive.events.a;
import java.util.Locale;

public final class ChangeEvent implements SafeParcelable, ResourceEvent {
   public static final Creator CREATOR = new a();
   final int CK;
   final int OX;
   final DriveId Oj;

   ChangeEvent(int var1, DriveId var2, int var3) {
      this.CK = var1;
      this.Oj = var2;
      this.OX = var3;
   }

   public int describeContents() {
      return 0;
   }

   public DriveId getDriveId() {
      return this.Oj;
   }

   public int getType() {
      return 1;
   }

   public boolean hasContentChanged() {
      return (this.OX & 2) != 0;
   }

   public boolean hasMetadataChanged() {
      return (this.OX & 1) != 0;
   }

   public String toString() {
      return String.format(Locale.US, "ChangeEvent [id=%s,changeFlags=%x]", new Object[]{this.Oj, Integer.valueOf(this.OX)});
   }

   public void writeToParcel(Parcel var1, int var2) {
      a.a(this, var1, var2);
   }
}
