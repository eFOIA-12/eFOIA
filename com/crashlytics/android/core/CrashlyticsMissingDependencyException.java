package com.crashlytics.android.core;

public class CrashlyticsMissingDependencyException extends RuntimeException {
   private static final long serialVersionUID = -1151536370019872859L;

   CrashlyticsMissingDependencyException(String var1) {
      super(buildExceptionMessage(var1));
   }

   private static String buildExceptionMessage(String var0) {
      return "\n" + var0 + "\n";
   }
}
