package gov.dhs.mobile.efoia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import com.parallel6.captivereachconnectsdk.CaptiveReachConnect;
import com.parallel6.captivereachconnectsdk.models.Advertisement;
import com.parallel6.captivereachconnectsdk.models.CRImage;
import com.parallel6.captivereachconnectsdk.models.MobileMenu;
import com.parallel6.captivereachconnectsdk.models.json.response.AdvertisementResponse;
import com.parallel6.captivereachconnectsdk.models.json.response.MobileMenuResponse;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import gov.dhs.mobile.efoia.arrayadapters.HomeViewTableArrayAdapter;
import gov.dhs.mobile.efoia.tasks.AdvertisementTask;
import gov.dhs.mobile.efoia.tasks.GetBackgroundImageTask;
import gov.dhs.mobile.efoia.tasks.GetMobileMenusTask;
import gov.dhs.mobile.efoia.viewcontrollers.events.EventsActivity;
import gov.dhs.mobile.efoia.viewcontrollers.exemptions.ExemptionsActivity;
import gov.dhs.mobile.efoia.viewcontrollers.howto.FOIAHowToActivity;
import gov.dhs.mobile.efoia.viewcontrollers.library.FOIALibrary;
import gov.dhs.mobile.efoia.viewcontrollers.privacypolicy.PrivacyPolicyActivity;
import gov.dhs.mobile.efoia.viewcontrollers.privacystatement.PrivacyActStatement;
import gov.dhs.mobile.efoia.viewcontrollers.status.FOIAStatus;
import gov.dhs.mobile.efoia.viewcontrollers.statutes.FOIAStatutes;
import java.util.List;
import java.util.Random;

public class MainActivity extends Activity {
   private ListView activityListView;
   private List advertisementList;
   private TaskListener advertisementTaskListener = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
      }

      public void onTaskSuccess(AdvertisementResponse var1) {
         if(var1 != null && var1.getAdvertisements() != null && var1.getAdvertisements().size() > 0) {
            MainActivity.this.advertisementList = var1.getAdvertisements();
            MainActivity.this.gestureDetector = new GestureDetector(MainActivity.this.mContext, MainActivity.this.new GestureListener());
            MainActivity.this.layout.setOnTouchListener(new OnTouchListener() {
               public boolean onTouch(View var1, MotionEvent var2) {
                  return MainActivity.this.gestureDetector.onTouchEvent(var2);
               }
            });
            Random var3 = new Random();
            var3.setSeed((long)MainActivity.this.advertisementList.size());
            MainActivity.this.currentImageIndex = var3.nextInt(MainActivity.this.advertisementList.size());
            String var4 = ((Advertisement)MainActivity.this.advertisementList.get(MainActivity.this.currentImageIndex)).getImage().getCRImage().getImageForDensity(CRImage.IMAGE_TYPE.FULLSCREEN, (Activity)MainActivity.this.mContext);

            try {
               MainActivity.this.layout.setBackground((Drawable)(new GetBackgroundImageTask()).execute(new String[]{var4}).get());
            } catch (Exception var2) {
               return;
            }
         }

      }

      public void onTaskTimeOut() {
      }
   };
   private int currentImageIndex;
   private GestureDetector gestureDetector;
   private RelativeLayout layout;
   private Context mContext = this;
   private List menus;
   private TaskListener mobileMenusTaskCallback = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
         Toast.makeText(MainActivity.this, "Error: " + var1.getLocalizedMessage(), 0).show();
      }

      public void onTaskSuccess(MobileMenuResponse var1) {
         if(var1 != null && var1.getMobileMenus() != null && var1.getMobileMenus().size() > 0) {
            MainActivity.this.menus = var1.getMobileMenus();
            MainActivity.this.activityListView.setAdapter(new HomeViewTableArrayAdapter(MainActivity.this, 2130968656, MainActivity.this.menus));
         }

      }

      public void onTaskTimeOut() {
      }
   };

   // $FF: synthetic method
   static int access$408(MainActivity var0) {
      int var1 = var0.currentImageIndex;
      var0.currentImageIndex = var1 + 1;
      return var1;
   }

   // $FF: synthetic method
   static int access$410(MainActivity var0) {
      int var1 = var0.currentImageIndex;
      var0.currentImageIndex = var1 - 1;
      return var1;
   }

   private void launchAction(MobileMenu var1) {
      CaptiveReachConnect.getInstance().trackInsightV2(this, "Main Menu", var1.getAction(), "", "");
      if(var1.getAction().equalsIgnoreCase("no_action") && var1.getActionObject().equals("privacy_policy")) {
         Intent var2 = new Intent(this, PrivacyActStatement.class);
         new Bundle();
         this.startActivity(var2);
      }

   }

   private void launchContentScreen(String var1) {
      Intent var2 = null;
      Bundle var3 = new Bundle();
      CaptiveReachConnect.getInstance().trackInsightV2(this, "Main Menu", var1, "", "");
      if(var1.equalsIgnoreCase("privacy_policy")) {
         var2 = new Intent(this, PrivacyPolicyActivity.class);
      } else if(var1.equalsIgnoreCase("library")) {
         var2 = new Intent(this, FOIALibrary.class);
      } else if(var1.equalsIgnoreCase("statutes")) {
         var2 = new Intent(this, FOIAStatutes.class);
      } else if(var1.equalsIgnoreCase("events")) {
         var2 = new Intent(this, EventsActivity.class);
      } else if(var1.equalsIgnoreCase("exemptions_exclusions")) {
         var2 = new Intent(this, ExemptionsActivity.class);
      } else if(var1.equalsIgnoreCase("foia_status")) {
         var2 = new Intent(this, FOIAStatus.class);
      }

      if(var2 != null) {
         var3.putString("action_object", var1);
         var2.putExtras(var3);
         this.startActivity(var2);
      }

   }

   private void launchSubMenu(MobileMenu var1, String var2) {
      CaptiveReachConnect.getInstance().trackInsightV2(this, "Main Menu", var2, "", "");
      if(var2.equalsIgnoreCase("How to Submit a FOIA Request")) {
         Intent var4 = new Intent(this, FOIAHowToActivity.class);
         Bundle var3 = new Bundle();
         var3.putInt("menu_id", (int)var1.getId());
         var4.putExtras(var3);
         this.startActivity(var4);
      }

   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130968613);
      (new GetMobileMenusTask(this, this.mobileMenusTaskCallback)).execute(new Void[0]);
      (new AdvertisementTask(this, this.advertisementTaskListener)).execute(new Void[0]);
      this.activityListView = (ListView)this.findViewById(2131689635);
      this.layout = (RelativeLayout)((Activity)this.mContext).findViewById(2131689633);
      this.activityListView.setOnItemClickListener(new OnItemClickListener() {
         public void onItemClick(AdapterView var1, View var2, int var3, long var4) {
            MobileMenu var6 = (MobileMenu)MainActivity.this.menus.get(var3);
            if(var6.getAction().equalsIgnoreCase("subcategory")) {
               MainActivity.this.launchSubMenu(var6, var6.getTitle());
            } else {
               if(var6.getAction().equalsIgnoreCase("dynamic_contents")) {
                  MainActivity.this.launchContentScreen((String)var6.getActionObject());
                  return;
               }

               if(!var6.getAction().equalsIgnoreCase("tagged_contents") && var6.getAction().equalsIgnoreCase("no_action")) {
                  MainActivity.this.launchAction(var6);
                  return;
               }
            }

         }
      });
      if(!this.getSharedPreferences("E-FOIA_PREFS", 0).getBoolean("AGREED", false)) {
         Intent var3 = new Intent(this, PrivacyPolicyActivity.class);
         Bundle var2 = new Bundle();
         var2.putString("action_object", "privacy_policy");
         var3.putExtras(var2);
         this.startActivity(var3);
      }

   }

   final class GestureListener extends SimpleOnGestureListener {
      private static final int SWIPE_THRESHOLD = 100;
      private static final int SWIPE_VELOCITY_THRESHOLD = 100;

      public boolean onDown(MotionEvent var1) {
         return true;
      }

      public boolean onFling(MotionEvent param1, MotionEvent param2, float param3, float param4) {
         // $FF: Couldn't be decompiled
      }

      public void onSwipeBottom() {
      }

      public void onSwipeLeft() {
         MainActivity.access$408(MainActivity.this);
         if(MainActivity.this.currentImageIndex == MainActivity.this.advertisementList.size()) {
            MainActivity.this.currentImageIndex = 0;
         }

         String var1 = ((Advertisement)MainActivity.this.advertisementList.get(MainActivity.this.currentImageIndex)).getImage().getCRImage().getImageForDensity(CRImage.IMAGE_TYPE.FULLSCREEN, (Activity)MainActivity.this.mContext);

         try {
            MainActivity.this.layout.setBackground((Drawable)(new GetBackgroundImageTask()).execute(new String[]{var1}).get());
         } catch (Exception var2) {
            ;
         }
      }

      public void onSwipeRight() {
         MainActivity.access$410(MainActivity.this);
         if(MainActivity.access$410(MainActivity.this) < 0) {
            MainActivity.this.currentImageIndex = MainActivity.this.advertisementList.size() - 1;
         }

         String var1 = ((Advertisement)MainActivity.this.advertisementList.get(MainActivity.access$410(MainActivity.this))).getImage().getCRImage().getImageForDensity(CRImage.IMAGE_TYPE.FULLSCREEN, (Activity)MainActivity.this.mContext);

         try {
            MainActivity.this.layout.setBackground((Drawable)(new GetBackgroundImageTask()).execute(new String[]{var1}).get());
         } catch (Exception var2) {
            ;
         }
      }

      public void onSwipeTop() {
      }
   }
}
