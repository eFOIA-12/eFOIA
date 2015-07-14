package com.crashlytics.android.core.internal.models;

public class BinaryImageData {
   public final long baseAddress;
   public final String id;
   public final String path;
   public final long size;

   public BinaryImageData(long var1, long var3, String var5, String var6) {
      this.baseAddress = var1;
      this.size = var3;
      this.path = var5;
      this.id = var6;
   }
}
