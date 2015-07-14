package com.google.android.gms.internal;

import com.google.android.gms.internal.ao;
import com.google.android.gms.internal.aq;
import java.security.MessageDigest;

public class ar extends ao {
   private MessageDigest nZ;

   byte[] a(String[] var1) {
      byte[] var3 = new byte[var1.length];

      for(int var2 = 0; var2 < var1.length; ++var2) {
         var3[var2] = this.e(aq.o(var1[var2]));
      }

      return var3;
   }

   byte e(int var1) {
      return (byte)(var1 & 255 ^ ('\uff00' & var1) >> 8 ^ (16711680 & var1) >> 16 ^ (-16777216 & var1) >> 24);
   }

   public byte[] l(String param1) {
      // $FF: Couldn't be decompiled
   }
}
