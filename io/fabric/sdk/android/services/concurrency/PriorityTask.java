package io.fabric.sdk.android.services.concurrency;

import io.fabric.sdk.android.services.concurrency.Dependency;
import io.fabric.sdk.android.services.concurrency.Priority;
import io.fabric.sdk.android.services.concurrency.PriorityProvider;
import io.fabric.sdk.android.services.concurrency.Task;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class PriorityTask implements Dependency, PriorityProvider, Task {
   private final List dependencies = new ArrayList();
   private final AtomicBoolean hasRun = new AtomicBoolean(false);
   private final AtomicReference throwable = new AtomicReference((Object)null);

   public static boolean isProperDelegate(Object var0) {
      boolean var2 = false;

      Dependency var3;
      Task var4;
      PriorityProvider var6;
      try {
         var3 = (Dependency)var0;
         var4 = (Task)var0;
         var6 = (PriorityProvider)var0;
      } catch (ClassCastException var5) {
         return false;
      }

      boolean var1 = var2;
      if(var3 != null) {
         var1 = var2;
         if(var4 != null) {
            var1 = var2;
            if(var6 != null) {
               var1 = true;
            }
         }
      }

      return var1;
   }

   public void addDependency(Task var1) {
      synchronized(this){}

      try {
         this.dependencies.add(var1);
      } finally {
         ;
      }

   }

   public boolean areDependenciesMet() {
      Iterator var1 = this.getDependencies().iterator();

      do {
         if(!var1.hasNext()) {
            return true;
         }
      } while(((Task)var1.next()).isFinished());

      return false;
   }

   public int compareTo(Object var1) {
      return Priority.compareTo(this, var1);
   }

   public Collection getDependencies() {
      synchronized(this){}

      Collection var1;
      try {
         var1 = Collections.unmodifiableCollection(this.dependencies);
      } finally {
         ;
      }

      return var1;
   }

   public Throwable getError() {
      return (Throwable)this.throwable.get();
   }

   public Priority getPriority() {
      return Priority.NORMAL;
   }

   public boolean isFinished() {
      return this.hasRun.get();
   }

   public void setError(Throwable var1) {
      this.throwable.set(var1);
   }

   public void setFinished(boolean var1) {
      synchronized(this){}

      try {
         this.hasRun.set(var1);
      } finally {
         ;
      }

   }
}
