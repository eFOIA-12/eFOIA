package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.a;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Contents implements SafeParcelable {
   public static final Creator CREATOR = new a();
   final int CK;
   final ParcelFileDescriptor LG;
   final int Oi;
   final DriveId Oj;
   final boolean Ok;
   final int ve;

   Contents(int var1, ParcelFileDescriptor var2, int var3, int var4, DriveId var5, boolean var6) {
      this.CK = var1;
      this.LG = var2;
      this.ve = var3;
      this.Oi = var4;
      this.Oj = var5;
      this.Ok = var6;
   }

   public int describeContents() {
      return 0;
   }

   public DriveId getDriveId() {
      return this.Oj;
   }

   public InputStream getInputStream() {
      return new FileInputStream(this.LG.getFileDescriptor());
   }

   public int getMode() {
      return this.Oi;
   }

   public OutputStream getOutputStream() {
      return new FileOutputStream(this.LG.getFileDescriptor());
   }

   public ParcelFileDescriptor getParcelFileDescriptor() {
      return this.LG;
   }

   public int getRequestId() {
      return this.ve;
   }

   public boolean ip() {
      return this.Ok;
   }

   public void writeToParcel(Parcel var1, int var2) {
      a.a(this, var1, var2);
   }
}
