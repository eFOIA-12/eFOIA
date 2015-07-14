package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import java.util.Arrays;

public class lq extends com.google.android.gms.drive.metadata.internal.j {
   public static final lq RV = new lq();

   private lq() {
      super("driveId", Arrays.asList(new String[]{"sqlId", "resourceId"}), Arrays.asList(new String[]{"dbInstanceId"}), 4100000);
   }

   // $FF: synthetic method
   protected Object c(DataHolder var1, int var2, int var3) {
      return this.m(var1, var2, var3);
   }

   protected DriveId m(DataHolder var1, int var2, int var3) {
      long var4 = var1.gV().getLong("dbInstanceId");
      String var7 = var1.c("resourceId", var2, var3);
      String var6 = var7;
      if(var7 != null) {
         var6 = var7;
         if(var7.startsWith("generated-android-")) {
            var6 = null;
         }
      }

      return new DriveId(var6, Long.valueOf(var1.a("sqlId", var2, var3)).longValue(), var4);
   }
}
