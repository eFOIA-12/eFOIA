package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.internal.r;
import com.google.android.gms.internal.jv;

public final class ExecutionOptions {
   public static final int CONFLICT_STRATEGY_KEEP_REMOTE = 1;
   public static final int CONFLICT_STRATEGY_OVERWRITE_REMOTE = 0;
   public static final int MAX_TRACKING_TAG_STRING_LENGTH = 65536;
   private final int OA;
   private final String Oy;
   private final boolean Oz;

   public ExecutionOptions(String var1, boolean var2, int var3) {
      this.Oy = var1;
      this.Oz = var2;
      this.OA = var3;
   }

   public static void a(GoogleApiClient var0, ExecutionOptions var1) {
      r var2 = (r)var0.a(Drive.DQ);
      if(var1.iw() && !var2.iJ()) {
         throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to be notified on completion");
      }
   }

   public static boolean ba(int var0) {
      switch(var0) {
      case 1:
         return true;
      default:
         return false;
      }
   }

   public static boolean bb(int var0) {
      switch(var0) {
      case 0:
      case 1:
         return true;
      default:
         return false;
      }
   }

   public static boolean bj(String var0) {
      return var0 != null && !var0.isEmpty() && var0.length() <= 65536;
   }

   public boolean equals(Object var1) {
      boolean var3 = true;
      boolean var2;
      if(var1 != null && var1.getClass() == this.getClass()) {
         var2 = var3;
         if(var1 != this) {
            ExecutionOptions var4 = (ExecutionOptions)var1;
            if(jv.equal(this.Oy, var4.Oy) && this.OA == var4.OA) {
               var2 = var3;
               if(this.Oz == var4.Oz) {
                  return var2;
               }
            }

            return false;
         }
      } else {
         var2 = false;
      }

      return var2;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.Oy, Integer.valueOf(this.OA), Boolean.valueOf(this.Oz)});
   }

   public String iv() {
      return this.Oy;
   }

   public boolean iw() {
      return this.Oz;
   }

   public int ix() {
      return this.OA;
   }

   public static final class Builder {
      private int OA = 0;
      private String Oy;
      private boolean Oz;

      public ExecutionOptions build() {
         if(this.OA == 1 && !this.Oz) {
            throw new IllegalStateException("Cannot use CONFLICT_STRATEGY_KEEP_REMOTE without requesting completion notifications");
         } else {
            return new ExecutionOptions(this.Oy, this.Oz, this.OA);
         }
      }

      public ExecutionOptions.Builder setConflictStrategy(int var1) {
         if(!ExecutionOptions.bb(var1)) {
            throw new IllegalArgumentException("Unrecognized value for conflict strategy: " + var1);
         } else {
            this.OA = var1;
            return this;
         }
      }

      public ExecutionOptions.Builder setNotifyOnCompletion(boolean var1) {
         this.Oz = var1;
         return this;
      }

      public ExecutionOptions.Builder setTrackingTag(String var1) {
         if(!ExecutionOptions.bj(var1)) {
            throw new IllegalArgumentException(String.format("trackingTag must not be null nor empty, and the length must be <= the maximum length (%s)", new Object[]{Integer.valueOf(65536)}));
         } else {
            this.Oy = var1;
            return this;
         }
      }
   }
}
