package com.crashlytics.android.core.internal.models;

public class SignalData {
   public final String code;
   public final long faultAddress;
   public final String name;

   public SignalData(String var1, String var2, long var3) {
      this.name = var1;
      this.code = var2;
      this.faultAddress = var3;
   }
}
