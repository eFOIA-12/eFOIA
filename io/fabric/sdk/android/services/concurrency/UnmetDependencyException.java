package io.fabric.sdk.android.services.concurrency;

public class UnmetDependencyException extends RuntimeException {
   public UnmetDependencyException() {
   }

   public UnmetDependencyException(String var1) {
      super(var1);
   }

   public UnmetDependencyException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public UnmetDependencyException(Throwable var1) {
      super(var1);
   }
}
