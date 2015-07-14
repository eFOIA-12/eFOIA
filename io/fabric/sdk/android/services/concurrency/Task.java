package io.fabric.sdk.android.services.concurrency;

public interface Task {
   Throwable getError();

   boolean isFinished();

   void setError(Throwable var1);

   void setFinished(boolean var1);
}
