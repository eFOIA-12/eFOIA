package com.google.android.gms.drive.events;

import com.google.android.gms.drive.DriveId;

public class d {
   public static boolean a(int var0, DriveId var1) {
      return var1 != null || bi(var0);
   }

   public static boolean bi(int var0) {
      return (2L & (long)(1 << var0)) != 0L;
   }
}
