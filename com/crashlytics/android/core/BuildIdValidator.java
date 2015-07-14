package com.crashlytics.android.core;

import android.util.Log;
import com.crashlytics.android.core.CrashlyticsMissingDependencyException;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.common.CommonUtils;

class BuildIdValidator {
   private static final String MESSAGE = "This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app\'s organization.";
   private final String buildId;
   private final boolean requiringBuildId;

   public BuildIdValidator(String var1, boolean var2) {
      this.buildId = var1;
      this.requiringBuildId = var2;
   }

   protected String getMessage(String var1, String var2) {
      return "This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app\'s organization.";
   }

   public void validate(String var1, String var2) {
      if(CommonUtils.isNullOrEmpty(this.buildId) && this.requiringBuildId) {
         var1 = this.getMessage(var1, var2);
         Log.e("Fabric", ".");
         Log.e("Fabric", ".     |  | ");
         Log.e("Fabric", ".     |  |");
         Log.e("Fabric", ".     |  |");
         Log.e("Fabric", ".   \\ |  | /");
         Log.e("Fabric", ".    \\    /");
         Log.e("Fabric", ".     \\  /");
         Log.e("Fabric", ".      \\/");
         Log.e("Fabric", ".");
         Log.e("Fabric", var1);
         Log.e("Fabric", ".");
         Log.e("Fabric", ".      /\\");
         Log.e("Fabric", ".     /  \\");
         Log.e("Fabric", ".    /    \\");
         Log.e("Fabric", ".   / |  | \\");
         Log.e("Fabric", ".     |  |");
         Log.e("Fabric", ".     |  |");
         Log.e("Fabric", ".     |  |");
         Log.e("Fabric", ".");
         throw new CrashlyticsMissingDependencyException(var1);
      } else {
         if(!this.requiringBuildId) {
            Fabric.getLogger().d("Fabric", "Configured not to require a build ID.");
         }

      }
   }
}
