package io.fabric.sdk.android.services.common;

public abstract class Crash {
   private final String sessionId;

   public Crash(String var1) {
      this.sessionId = var1;
   }

   public String getSessionId() {
      return this.sessionId;
   }

   public static class FatalException extends Crash {
      public FatalException(String var1) {
         super(var1);
      }
   }

   public static class LoggedException extends Crash {
      public LoggedException(String var1) {
         super(var1);
      }
   }
}
