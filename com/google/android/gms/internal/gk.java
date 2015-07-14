package com.google.android.gms.internal;

import com.google.android.gms.internal.ey;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@ey
public class gk implements Future {
   private final Object wF;

   public gk(Object var1) {
      this.wF = var1;
   }

   public boolean cancel(boolean var1) {
      return false;
   }

   public Object get() {
      return this.wF;
   }

   public Object get(long var1, TimeUnit var3) {
      return this.wF;
   }

   public boolean isCancelled() {
      return false;
   }

   public boolean isDone() {
      return true;
   }
}
