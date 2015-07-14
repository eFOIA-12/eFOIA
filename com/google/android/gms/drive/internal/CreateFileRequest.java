package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.internal.k;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.jx;

public class CreateFileRequest implements SafeParcelable {
   public static final Creator CREATOR = new k();
   final int CK;
   final String Oy;
   final boolean PA;
   final int PB;
   final int PC;
   final Contents Pr;
   final MetadataBundle Px;
   final Integer Py;
   final DriveId Pz;

   CreateFileRequest(int var1, DriveId var2, MetadataBundle var3, Contents var4, Integer var5, boolean var6, String var7, int var8, int var9) {
      if(var4 != null && var9 != 0) {
         boolean var10;
         if(var4.getRequestId() == var9) {
            var10 = true;
         } else {
            var10 = false;
         }

         jx.b(var10, "inconsistent contents reference");
      }

      if((var5 == null || var5.intValue() == 0) && var4 == null && var9 == 0) {
         throw new IllegalArgumentException("Need a valid contents");
      } else {
         this.CK = var1;
         this.Pz = (DriveId)jx.i(var2);
         this.Px = (MetadataBundle)jx.i(var3);
         this.Pr = var4;
         this.Py = var5;
         this.Oy = var7;
         this.PB = var8;
         this.PA = var6;
         this.PC = var9;
      }
   }

   public CreateFileRequest(DriveId var1, MetadataBundle var2, int var3, int var4, ExecutionOptions var5) {
      this(2, var1, var2, (Contents)null, Integer.valueOf(var4), var5.iw(), var5.iv(), var5.ix(), var3);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      k.a(this, var1, var2);
   }
}
