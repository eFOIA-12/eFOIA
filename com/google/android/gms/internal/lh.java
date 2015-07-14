package com.google.android.gms.internal;

import android.os.ParcelFileDescriptor;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class lh {
   public static long a(InputStream var0, OutputStream var1, boolean var2) throws IOException {
      return a(var0, var1, var2, 1024);
   }

   public static long a(InputStream param0, OutputStream param1, boolean param2, int param3) throws IOException {
      // $FF: Couldn't be decompiled
   }

   public static void a(ParcelFileDescriptor var0) {
      if(var0 != null) {
         try {
            var0.close();
         } catch (IOException var1) {
            return;
         }
      }

   }

   public static byte[] a(InputStream var0, boolean var1) throws IOException {
      ByteArrayOutputStream var2 = new ByteArrayOutputStream();
      a(var0, var2, var1);
      return var2.toByteArray();
   }

   public static void b(Closeable var0) {
      if(var0 != null) {
         try {
            var0.close();
         } catch (IOException var1) {
            return;
         }
      }

   }

   public static byte[] d(InputStream var0) throws IOException {
      return a(var0, true);
   }
}
