package com.crashlytics.android.core.internal.models;

public class ThreadData {
   public static final int IMPORTANCE_CRASHED_THREAD = 4;
   public final ThreadData.FrameData[] frames;
   public final int importance;
   public final String name;

   public ThreadData(int var1, ThreadData.FrameData[] var2) {
      this((String)null, var1, var2);
   }

   public ThreadData(String var1, int var2, ThreadData.FrameData[] var3) {
      this.name = var1;
      this.importance = var2;
      this.frames = var3;
   }

   public static final class FrameData {
      public final long address;
      public final String file;
      public final int importance;
      public final long offset;
      public final String symbol;

      public FrameData(long var1, int var3) {
         this(var1, "", var3);
      }

      public FrameData(long var1, String var3, int var4) {
         this(var1, var3, "", 0L, var4);
      }

      public FrameData(long var1, String var3, String var4, long var5, int var7) {
         this.address = var1;
         this.symbol = var3;
         this.file = var4;
         this.offset = var5;
         this.importance = var7;
      }
   }
}
