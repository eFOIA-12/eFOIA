package io.fabric.sdk.android.services.settings;

public class SessionSettingsData {
   public final int identifierMask;
   public final int logBufferSize;
   public final int maxChainedExceptionDepth;
   public final int maxCustomExceptionEvents;
   public final int maxCustomKeyValuePairs;
   public final boolean sendSessionWithoutCrash;

   public SessionSettingsData(int var1, int var2, int var3, int var4, int var5, boolean var6) {
      this.logBufferSize = var1;
      this.maxChainedExceptionDepth = var2;
      this.maxCustomExceptionEvents = var3;
      this.maxCustomKeyValuePairs = var4;
      this.identifierMask = var5;
      this.sendSessionWithoutCrash = var6;
   }
}
