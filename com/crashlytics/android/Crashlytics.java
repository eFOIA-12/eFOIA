package com.crashlytics.android;

import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.beta.Beta;
import com.crashlytics.android.core.CrashlyticsCore;
import com.crashlytics.android.core.CrashlyticsListener;
import com.crashlytics.android.core.PinningInfoProvider;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.KitGroup;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Crashlytics extends Kit implements KitGroup {
   public static final String TAG = "Crashlytics";
   public final Answers answers;
   public final Beta beta;
   public final CrashlyticsCore core;
   public final Collection kits;

   public Crashlytics() {
      this(new Answers(), new Beta(), new CrashlyticsCore());
   }

   Crashlytics(Answers var1, Beta var2, CrashlyticsCore var3) {
      this.answers = var1;
      this.beta = var2;
      this.core = var3;
      this.kits = Collections.unmodifiableCollection(Arrays.asList(new Kit[]{var1, var2, var3}));
   }

   private static void checkInitialized() {
      if(getInstance() == null) {
         throw new IllegalStateException("Crashlytics must be initialized by calling Fabric.with(Context) prior to calling Crashlytics.getInstance()");
      }
   }

   public static Crashlytics getInstance() {
      return (Crashlytics)Fabric.getKit(Crashlytics.class);
   }

   @Deprecated
   public static PinningInfoProvider getPinningInfoProvider() {
      checkInitialized();
      return getInstance().core.getPinningInfoProvider();
   }

   @Deprecated
   public static void log(int var0, String var1, String var2) {
      checkInitialized();
      getInstance().core.log(var0, var1, var2);
   }

   @Deprecated
   public static void log(String var0) {
      checkInitialized();
      getInstance().core.log(var0);
   }

   @Deprecated
   public static void logException(Throwable var0) {
      checkInitialized();
      getInstance().core.logException(var0);
   }

   @Deprecated
   public static void setBool(String var0, boolean var1) {
      checkInitialized();
      getInstance().core.setBool(var0, var1);
   }

   @Deprecated
   public static void setDouble(String var0, double var1) {
      checkInitialized();
      getInstance().core.setDouble(var0, var1);
   }

   @Deprecated
   public static void setFloat(String var0, float var1) {
      checkInitialized();
      getInstance().core.setFloat(var0, var1);
   }

   @Deprecated
   public static void setInt(String var0, int var1) {
      checkInitialized();
      getInstance().core.setInt(var0, var1);
   }

   @Deprecated
   public static void setLong(String var0, long var1) {
      checkInitialized();
      getInstance().core.setLong(var0, var1);
   }

   @Deprecated
   public static void setPinningInfoProvider(PinningInfoProvider var0) {
      Fabric.getLogger().w("Crashlytics", "Use of Crashlytics.setPinningInfoProvider is deprecated");
   }

   @Deprecated
   public static void setString(String var0, String var1) {
      checkInitialized();
      getInstance().core.setString(var0, var1);
   }

   @Deprecated
   public static void setUserEmail(String var0) {
      checkInitialized();
      getInstance().core.setUserEmail(var0);
   }

   @Deprecated
   public static void setUserIdentifier(String var0) {
      checkInitialized();
      getInstance().core.setUserIdentifier(var0);
   }

   @Deprecated
   public static void setUserName(String var0) {
      checkInitialized();
      getInstance().core.setUserName(var0);
   }

   public void crash() {
      this.core.crash();
   }

   protected Void doInBackground() {
      return null;
   }

   @Deprecated
   public boolean getDebugMode() {
      Fabric.getLogger().w("Crashlytics", "Use of Crashlytics.getDebugMode is deprecated.");
      this.getFabric();
      return Fabric.isDebuggable();
   }

   public String getIdentifier() {
      return "com.crashlytics.sdk.android:crashlytics";
   }

   public Collection getKits() {
      return this.kits;
   }

   public String getVersion() {
      return "2.3.2.56";
   }

   @Deprecated
   public void setDebugMode(boolean var1) {
      Fabric.getLogger().w("Crashlytics", "Use of Crashlytics.setDebugMode is deprecated.");
   }

   @Deprecated
   public void setListener(CrashlyticsListener var1) {
      synchronized(this){}

      try {
         this.core.setListener(var1);
      } finally {
         ;
      }

   }

   public boolean verifyPinning(URL var1) {
      return this.core.verifyPinning(var1);
   }

   public static class Builder {
      private Answers answers;
      private Beta beta;
      private CrashlyticsCore core;
      private CrashlyticsCore.Builder coreBuilder;

      private CrashlyticsCore.Builder getCoreBuilder() {
         synchronized(this){}

         CrashlyticsCore.Builder var1;
         try {
            if(this.coreBuilder == null) {
               this.coreBuilder = new CrashlyticsCore.Builder();
            }

            var1 = this.coreBuilder;
         } finally {
            ;
         }

         return var1;
      }

      public Crashlytics.Builder answers(Answers var1) {
         if(var1 == null) {
            throw new NullPointerException("Answers Kit must not be null.");
         } else if(this.answers != null) {
            throw new IllegalStateException("Answers Kit already set.");
         } else {
            this.answers = var1;
            return this;
         }
      }

      public Crashlytics.Builder beta(Beta var1) {
         if(var1 == null) {
            throw new NullPointerException("Beta Kit must not be null.");
         } else if(this.beta != null) {
            throw new IllegalStateException("Beta Kit already set.");
         } else {
            this.beta = var1;
            return this;
         }
      }

      public Crashlytics build() {
         if(this.coreBuilder != null) {
            if(this.core != null) {
               throw new IllegalStateException("Must not use Deprecated methods delay(), disabled(), listener(), pinningInfoProvider() with core()");
            }

            this.core = this.coreBuilder.build();
         }

         if(this.answers == null) {
            this.answers = new Answers();
         }

         if(this.beta == null) {
            this.beta = new Beta();
         }

         if(this.core == null) {
            this.core = new CrashlyticsCore();
         }

         return new Crashlytics(this.answers, this.beta, this.core);
      }

      public Crashlytics.Builder core(CrashlyticsCore var1) {
         if(var1 == null) {
            throw new NullPointerException("CrashlyticsCore Kit must not be null.");
         } else if(this.core != null) {
            throw new IllegalStateException("CrashlyticsCore Kit already set.");
         } else {
            this.core = var1;
            return this;
         }
      }

      @Deprecated
      public Crashlytics.Builder delay(float var1) {
         this.getCoreBuilder().delay(var1);
         return this;
      }

      @Deprecated
      public Crashlytics.Builder disabled(boolean var1) {
         this.getCoreBuilder().disabled(var1);
         return this;
      }

      @Deprecated
      public Crashlytics.Builder listener(CrashlyticsListener var1) {
         this.getCoreBuilder().listener(var1);
         return this;
      }

      @Deprecated
      public Crashlytics.Builder pinningInfo(PinningInfoProvider var1) {
         this.getCoreBuilder().pinningInfo(var1);
         return this;
      }
   }
}
