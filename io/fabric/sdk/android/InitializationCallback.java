package io.fabric.sdk.android;

public interface InitializationCallback {
   InitializationCallback EMPTY = new InitializationCallback.Empty(null);

   void failure(Exception var1);

   void success(Object var1);

   public static class Empty implements InitializationCallback {
      private Empty() {
      }

      // $FF: synthetic method
      Empty(Object var1) {
         this();
      }

      public void failure(Exception var1) {
      }

      public void success(Object var1) {
      }
   }
}
