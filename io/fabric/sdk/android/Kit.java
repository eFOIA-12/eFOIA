package io.fabric.sdk.android;

import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.FabricContext;
import io.fabric.sdk.android.InitializationCallback;
import io.fabric.sdk.android.InitializationTask;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.DependsOn;
import java.io.File;
import java.util.Collection;

public abstract class Kit implements Comparable {
   Context context;
   Fabric fabric;
   IdManager idManager;
   InitializationCallback initializationCallback;
   InitializationTask initializationTask = new InitializationTask(this);

   public int compareTo(Kit var1) {
      if(!this.containsAnnotatedDependency(var1)) {
         if(var1.containsAnnotatedDependency(this)) {
            return -1;
         }

         if(!this.hasAnnotatedDependency() || var1.hasAnnotatedDependency()) {
            if(!this.hasAnnotatedDependency() && var1.hasAnnotatedDependency()) {
               return -1;
            }

            return 0;
         }
      }

      return 1;
   }

   boolean containsAnnotatedDependency(Kit var1) {
      DependsOn var4 = (DependsOn)this.getClass().getAnnotation(DependsOn.class);
      if(var4 != null) {
         Class[] var5 = var4.value();
         int var3 = var5.length;

         for(int var2 = 0; var2 < var3; ++var2) {
            if(var5[var2].equals(var1.getClass())) {
               return true;
            }
         }
      }

      return false;
   }

   protected abstract Object doInBackground();

   public Context getContext() {
      return this.context;
   }

   protected Collection getDependencies() {
      return this.initializationTask.getDependencies();
   }

   public Fabric getFabric() {
      return this.fabric;
   }

   protected IdManager getIdManager() {
      return this.idManager;
   }

   public abstract String getIdentifier();

   public String getPath() {
      return ".Fabric" + File.separator + this.getIdentifier();
   }

   public abstract String getVersion();

   boolean hasAnnotatedDependency() {
      return (DependsOn)this.getClass().getAnnotation(DependsOn.class) != null;
   }

   final void initialize() {
      this.initializationTask.executeOnExecutor(this.fabric.getExecutorService(), new Void[]{(Void)null});
   }

   void injectParameters(Context var1, Fabric var2, InitializationCallback var3, IdManager var4) {
      this.fabric = var2;
      this.context = new FabricContext(var1, this.getIdentifier(), this.getPath());
      this.initializationCallback = var3;
      this.idManager = var4;
   }

   protected void onCancelled(Object var1) {
   }

   protected void onPostExecute(Object var1) {
   }

   protected boolean onPreExecute() {
      return true;
   }
}
