package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.data.DataBuffer;
import java.util.ArrayList;

public final class DataBufferUtils {
   public static ArrayList freezeAndClose(DataBuffer param0) {
      // $FF: Couldn't be decompiled
   }

   public static boolean hasData(DataBuffer var0) {
      return var0 != null && var0.getCount() > 0;
   }

   public static boolean hasNextPage(DataBuffer var0) {
      Bundle var1 = var0.gV();
      return var1 != null && var1.getString("next_page_token") != null;
   }

   public static boolean hasPrevPage(DataBuffer var0) {
      Bundle var1 = var0.gV();
      return var1 != null && var1.getString("prev_page_token") != null;
   }
}
