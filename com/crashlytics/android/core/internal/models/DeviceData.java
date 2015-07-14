package com.crashlytics.android.core.internal.models;

public class DeviceData {
   public final long availableInternalStorage;
   public final long availablePhysicalMemory;
   public final int batteryCapacity;
   public final int batteryVelocity;
   public final int orientation;
   public final boolean proximity;
   public final long totalInternalStorage;
   public final long totalPhysicalMemory;

   public DeviceData(int var1, long var2, long var4, long var6, long var8, int var10, int var11, boolean var12) {
      this.orientation = var1;
      this.totalPhysicalMemory = var2;
      this.totalInternalStorage = var4;
      this.availablePhysicalMemory = var6;
      this.availableInternalStorage = var8;
      this.batteryCapacity = var10;
      this.batteryVelocity = var11;
      this.proximity = var12;
   }
}
