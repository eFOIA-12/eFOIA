package gov.dhs.mobile.efoia;

import android.os.Bundle;
import com.crashlytics.android.Crashlytics;
import com.parallel6.ui.activities.CRSplashActivity;
import gov.dhs.mobile.efoia.MainActivity;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;

public class HeroActivity extends CRSplashActivity {
   protected String getGCMKey() {
      return "AIzaSyCPTrA02rVbKWjeDoSfaUoM8kzQDYpyMvU";
   }

   protected int getHeroScreenResource() {
      return 2130837621;
   }

   protected Class getMainClassActivity() {
      return MainActivity.class;
   }

   protected String getServerUrl() {
      return "https://efoia-api-govreach.dhs.gov/";
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      Fabric.with(this, new Kit[]{new Crashlytics()});
   }
}
