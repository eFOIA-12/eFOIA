package io.fabric.sdk.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import io.fabric.sdk.android.ActivityLifecycleManager;
import io.fabric.sdk.android.DefaultLogger;
import io.fabric.sdk.android.FabricKitsFinder;
import io.fabric.sdk.android.InitializationCallback;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.KitGroup;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.Onboarding;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.DependsOn;
import io.fabric.sdk.android.services.concurrency.PriorityThreadPoolExecutor;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class Fabric {
   static final boolean DEFAULT_DEBUGGABLE = false;
   static final Logger DEFAULT_LOGGER = new DefaultLogger();
   static final String ROOT_DIR = ".Fabric";
   public static final String TAG = "Fabric";
   static volatile Fabric singleton;
   private WeakReference activity;
   private ActivityLifecycleManager activityLifecycleManager;
   private final Context context;
   final boolean debuggable;
   private final ExecutorService executorService;
   private final IdManager idManager;
   private final InitializationCallback initializationCallback;
   private AtomicBoolean initialized;
   private final InitializationCallback kitInitializationCallback;
   private final Map kits;
   final Logger logger;
   private final Handler mainHandler;

   Fabric(Context var1, Map var2, PriorityThreadPoolExecutor var3, Handler var4, Logger var5, boolean var6, InitializationCallback var7, IdManager var8) {
      this.context = var1;
      this.kits = var2;
      this.executorService = var3;
      this.mainHandler = var4;
      this.logger = var5;
      this.debuggable = var6;
      this.initializationCallback = var7;
      this.initialized = new AtomicBoolean(false);
      this.kitInitializationCallback = this.createKitInitializationCallback(var2.size());
      this.idManager = var8;
   }

   private static void addToKitMap(Map var0, Collection var1) {
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         Kit var2 = (Kit)var3.next();
         var0.put(var2.getClass(), var2);
         if(var2 instanceof KitGroup) {
            addToKitMap(var0, ((KitGroup)var2).getKits());
         }
      }

   }

   private Activity extractActivity(Context var1) {
      return var1 instanceof Activity?(Activity)var1:null;
   }

   public static Kit getKit(Class var0) {
      return (Kit)singleton().kits.get(var0);
   }

   private static Map getKitMap(Collection var0) {
      HashMap var1 = new HashMap(var0.size());
      addToKitMap(var1, var0);
      return var1;
   }

   public static Logger getLogger() {
      return singleton == null?DEFAULT_LOGGER:singleton.logger;
   }

   private void init() {
      this.setCurrentActivity(this.extractActivity(this.context));
      this.activityLifecycleManager = new ActivityLifecycleManager(this.context);
      this.activityLifecycleManager.registerCallbacks(new ActivityLifecycleManager.Callbacks() {
         public void onActivityCreated(Activity var1, Bundle var2) {
            Fabric.this.setCurrentActivity(var1);
         }

         public void onActivityResumed(Activity var1) {
            Fabric.this.setCurrentActivity(var1);
         }

         public void onActivityStarted(Activity var1) {
            Fabric.this.setCurrentActivity(var1);
         }
      });
      this.initializeKits(this.context);
   }

   public static boolean isDebuggable() {
      return singleton == null?false:singleton.debuggable;
   }

   public static boolean isInitialized() {
      return singleton != null && singleton.initialized.get();
   }

   private static void setFabric(Fabric var0) {
      singleton = var0;
      var0.init();
   }

   static Fabric singleton() {
      if(singleton == null) {
         throw new IllegalStateException("Must Initialize Fabric before using singleton()");
      } else {
         return singleton;
      }
   }

   public static Fabric with(Context param0, Kit... param1) {
      // $FF: Couldn't be decompiled
   }

   public static Fabric with(Fabric param0) {
      // $FF: Couldn't be decompiled
   }

   void addAnnotatedDependencies(Map var1, Kit var2) {
      DependsOn var5 = (DependsOn)var2.getClass().getAnnotation(DependsOn.class);
      if(var5 != null) {
         Class[] var9 = var5.value();
         int var4 = var9.length;

         for(int var3 = 0; var3 < var4; ++var3) {
            Class var6 = var9[var3];
            if(var6.isInterface()) {
               Iterator var7 = var1.values().iterator();

               while(var7.hasNext()) {
                  Kit var8 = (Kit)var7.next();
                  if(var6.isAssignableFrom(var8.getClass())) {
                     var2.initializationTask.addDependency(var8.initializationTask);
                  }
               }
            } else {
               if((Kit)var1.get(var6) == null) {
                  throw new UnmetDependencyException("Referenced Kit was null, does the kit exist?");
               }

               var2.initializationTask.addDependency(((Kit)var1.get(var6)).initializationTask);
            }
         }
      }

   }

   InitializationCallback createKitInitializationCallback(final int var1) {
      return new InitializationCallback() {
         final CountDownLatch kitInitializedLatch = new CountDownLatch(var1);

         public void failure(Exception var1x) {
            Fabric.this.initializationCallback.failure(var1x);
         }

         public void success(Object var1x) {
            this.kitInitializedLatch.countDown();
            if(this.kitInitializedLatch.getCount() == 0L) {
               Fabric.this.initialized.set(true);
               Fabric.this.initializationCallback.success(Fabric.this);
            }

         }
      };
   }

   public ActivityLifecycleManager getActivityLifecycleManager() {
      return this.activityLifecycleManager;
   }

   public String getAppIdentifier() {
      return this.idManager.getAppIdentifier();
   }

   public String getAppInstallIdentifier() {
      return this.idManager.getAppInstallIdentifier();
   }

   public Activity getCurrentActivity() {
      return this.activity != null?(Activity)this.activity.get():null;
   }

   public ExecutorService getExecutorService() {
      return this.executorService;
   }

   public String getIdentifier() {
      return "io.fabric.sdk.android:fabric";
   }

   public Collection getKits() {
      return this.kits.values();
   }

   Future getKitsFinderFuture(Context var1) {
      FabricKitsFinder var2 = new FabricKitsFinder(var1.getPackageCodePath());
      return this.getExecutorService().submit(var2);
   }

   public Handler getMainHandler() {
      return this.mainHandler;
   }

   public String getVersion() {
      return "1.3.3.56";
   }

   void initializeKits(Context var1) {
      Future var2 = this.getKitsFinderFuture(var1);
      Collection var3 = this.getKits();
      Onboarding var6 = new Onboarding(var2, var3);
      ArrayList var7 = new ArrayList(var3);
      Collections.sort(var7);
      var6.injectParameters(var1, this, InitializationCallback.EMPTY, this.idManager);
      Iterator var4 = var7.iterator();

      while(var4.hasNext()) {
         ((Kit)var4.next()).injectParameters(var1, this, this.kitInitializationCallback, this.idManager);
      }

      var6.initialize();
      StringBuilder var5;
      if(getLogger().isLoggable("Fabric", 3)) {
         var5 = (new StringBuilder("Initializing ")).append(this.getIdentifier()).append(" [Version: ").append(this.getVersion()).append("], with the following kits:\n");
      } else {
         var5 = null;
      }

      Iterator var8 = var7.iterator();

      while(var8.hasNext()) {
         Kit var9 = (Kit)var8.next();
         var9.initializationTask.addDependency(var6.initializationTask);
         this.addAnnotatedDependencies(this.kits, var9);
         var9.initialize();
         if(var5 != null) {
            var5.append(var9.getIdentifier()).append(" [Version: ").append(var9.getVersion()).append("]\n");
         }
      }

      if(var5 != null) {
         getLogger().d("Fabric", var5.toString());
      }

   }

   public Fabric setCurrentActivity(Activity var1) {
      this.activity = new WeakReference(var1);
      return this;
   }

   public static class Builder {
      private String appIdentifier;
      private String appInstallIdentifier;
      private final Context context;
      private boolean debuggable;
      private Handler handler;
      private InitializationCallback initializationCallback;
      private Kit[] kits;
      private Logger logger;
      private PriorityThreadPoolExecutor threadPoolExecutor;

      public Builder(Context var1) {
         if(var1 == null) {
            throw new IllegalArgumentException("Context must not be null.");
         } else {
            this.context = var1.getApplicationContext();
         }
      }

      public Fabric.Builder appIdentifier(String var1) {
         if(var1 == null) {
            throw new IllegalArgumentException("appIdentifier must not be null.");
         } else if(this.appIdentifier != null) {
            throw new IllegalStateException("appIdentifier already set.");
         } else {
            this.appIdentifier = var1;
            return this;
         }
      }

      public Fabric.Builder appInstallIdentifier(String var1) {
         if(var1 == null) {
            throw new IllegalArgumentException("appInstallIdentifier must not be null.");
         } else if(this.appInstallIdentifier != null) {
            throw new IllegalStateException("appInstallIdentifier already set.");
         } else {
            this.appInstallIdentifier = var1;
            return this;
         }
      }

      public Fabric build() {
         if(this.kits == null) {
            throw new IllegalStateException("Kits must not be null.");
         } else {
            if(this.threadPoolExecutor == null) {
               this.threadPoolExecutor = PriorityThreadPoolExecutor.create();
            }

            if(this.handler == null) {
               this.handler = new Handler(Looper.getMainLooper());
            }

            if(this.logger == null) {
               if(this.debuggable) {
                  this.logger = new DefaultLogger(3);
               } else {
                  this.logger = new DefaultLogger();
               }
            }

            if(this.appIdentifier == null) {
               this.appIdentifier = this.context.getPackageName();
            }

            if(this.initializationCallback == null) {
               this.initializationCallback = InitializationCallback.EMPTY;
            }

            Map var1 = Fabric.getKitMap(Arrays.asList(this.kits));
            IdManager var2 = new IdManager(this.context, this.appIdentifier, this.appInstallIdentifier, var1.values());
            return new Fabric(this.context, var1, this.threadPoolExecutor, this.handler, this.logger, this.debuggable, this.initializationCallback, var2);
         }
      }

      public Fabric.Builder debuggable(boolean var1) {
         this.debuggable = var1;
         return this;
      }

      @Deprecated
      public Fabric.Builder executorService(ExecutorService var1) {
         return this;
      }

      @Deprecated
      public Fabric.Builder handler(Handler var1) {
         return this;
      }

      public Fabric.Builder initializationCallback(InitializationCallback var1) {
         if(var1 == null) {
            throw new IllegalArgumentException("initializationCallback must not be null.");
         } else if(this.initializationCallback != null) {
            throw new IllegalStateException("initializationCallback already set.");
         } else {
            this.initializationCallback = var1;
            return this;
         }
      }

      public Fabric.Builder kits(Kit... var1) {
         if(var1 == null) {
            throw new IllegalArgumentException("Kits must not be null.");
         } else if(var1.length == 0) {
            throw new IllegalArgumentException("Kits must not be empty.");
         } else if(this.kits != null) {
            throw new IllegalStateException("Kits already set.");
         } else {
            this.kits = var1;
            return this;
         }
      }

      public Fabric.Builder logger(Logger var1) {
         if(var1 == null) {
            throw new IllegalArgumentException("Logger must not be null.");
         } else if(this.logger != null) {
            throw new IllegalStateException("Logger already set.");
         } else {
            this.logger = var1;
            return this;
         }
      }

      public Fabric.Builder threadPoolExecutor(PriorityThreadPoolExecutor var1) {
         if(var1 == null) {
            throw new IllegalArgumentException("PriorityThreadPoolExecutor must not be null.");
         } else if(this.threadPoolExecutor != null) {
            throw new IllegalStateException("PriorityThreadPoolExecutor already set.");
         } else {
            this.threadPoolExecutor = var1;
            return this;
         }
      }
   }
}
