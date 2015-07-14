package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.internal.FileUploadPreferencesImpl;

public class ab implements Creator {
   static void a(FileUploadPreferencesImpl var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 2, var0.Qz);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 3, var0.QA);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, var0.QB);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public FileUploadPreferencesImpl al(Parcel var1) {
      boolean var7 = false;
      int var5 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var4 = 0;
      int var3 = 0;
      int var2 = 0;

      while(var1.dataPosition() < var5) {
         int var6 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var6)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 2:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 3:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 4:
            var7 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var6);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var6);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var5, var1);
      } else {
         return new FileUploadPreferencesImpl(var2, var3, var4, var7);
      }
   }

   public FileUploadPreferencesImpl[] bA(int var1) {
      return new FileUploadPreferencesImpl[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.al(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.bA(var1);
   }
}
