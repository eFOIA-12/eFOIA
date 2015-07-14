package com.parallel6.ui.activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.FragmentManager.OnBackStackChangedListener;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.captivereachconnectsdk.models.CRModel;
import com.parallel6.captivereachconnectsdk.models.MobileMenu;
import com.parallel6.captivereachconnectsdk.models.surveys.Survey;
import com.parallel6.ui.actions.CRActionFactory;
import com.parallel6.ui.configurability.CaptiveReachUserInterfaceSDK;
import com.parallel6.ui.controllers.CRActivity;
import com.parallel6.ui.enums.Action;
import com.parallel6.ui.enums.styles.CRContentHomeStyle;
import com.parallel6.ui.fragments.CRNavigationDrawerFragment;
import com.parallel6.ui.fragments.CRProfileFragment;
import com.parallel6.ui.fragments.CRTabbarFragment;
import com.parallel6.ui.fragments.CRWebViewFragment;
import com.parallel6.ui.fragments.calendar.CRCalendarFragment;
import com.parallel6.ui.fragments.calendar.CalendarEventDetailFragment;
import com.parallel6.ui.fragments.factories.CRDetailFragmentFactory;
import com.parallel6.ui.fragments.factories.CRDynamicContentListFragmentFactory;
import com.parallel6.ui.fragments.factories.CRHomeFragmentFactory;
import com.parallel6.ui.fragments.factories.CRSubcategoryListFragmentFactory;
import com.parallel6.ui.interfaces.CRMessage;
import com.parallel6.ui.interfaces.FragmentState;
import com.parallel6.ui.models.CRTheme;
import com.parallel6.ui.models.CRThemeDrawables;
import com.parallel6.ui.models.CalendarEvent;
import com.parallel6.ui.models.NotificationTriggerResponse;
import com.parallel6.ui.surveys.fragments.SurveyFragment;
import com.parallel6.ui.surveys.fragments.SurveyListFragment;
import com.parallel6.ui.utils.ActivityUtils;
import com.parallel6.ui.utils.FragmentUtils;
import com.parallel6.ui.utils.NotificationUtils;
import java.io.Serializable;
import java.util.ArrayList;

public class CRMainActivity extends CRActivity {
   private static CRContentHomeStyle homeStyle;
   private static boolean isActive;
   protected Intent mActivityIntent;
   private CRNavigationDrawerFragment mNavigationDrawerFragment;
   private View navigationDrawerButton;

   static {
      homeStyle = CRContentHomeStyle.GridViewmenu;
   }

   public static CRContentHomeStyle getHomeStyle() {
      return homeStyle;
   }

   private boolean goToHome() {
      FragmentState var1 = (FragmentState)this.getFragmentManager().findFragmentById(R.id.main_content);
      return var1 != null && var1.goToHome();
   }

   private void initializeNavigationDrawer() {
      this.mNavigationDrawerFragment = this.getNavigationDrawerFragment();
      this.navigationDrawerButton = this.getLayoutInflater().inflate(R.layout.actionbar_custom, (ViewGroup)null).findViewById(R.id.actionbar_left_action);
      this.navigationDrawerButton.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            CRMainActivity.this.switchDrawer(var1);
         }
      });
      this.mNavigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout)this.findViewById(R.id.drawer_layout));
      this.mNavigationDrawerFragment.closeDrawer();
   }

   public static boolean isIsActive() {
      return isActive;
   }

   public static void setHomeStyle(CRContentHomeStyle var0) {
      homeStyle = var0;
   }

   public static void setIsActive(boolean var0) {
      isActive = var0;
   }

   private boolean slidingMenuStyle() {
      return homeStyle == CRContentHomeStyle.SlidingMenu;
   }

   public CRActionFactory getActionFactory() {
      return CRActionFactory.getInstance();
   }

   public View getBaseBackActionbarView(Context var1) {
      View var3 = View.inflate(var1, R.layout.actionbar_custom, (ViewGroup)null);
      ImageView var2 = (ImageView)var3.findViewById(R.id.actionbar_left_action);
      var2.setImageResource(R.drawable.ic_back);
      var2.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            CRMainActivity.this.handleMessage(-1412628478);
         }
      });
      return var3;
   }

   public CRTheme getCRTheme() {
      CRTheme var1 = new CRTheme();
      var1.setAppBaseColorResource(R.color.base_theme_color);
      var1.setAppPrimaryColorResource(R.color.app_primary_color);
      var1.setAppActionbarColorResource(R.color.base_theme_color);
      var1.setAppTabBarColorResource(R.color.base_theme_color);
      var1.setAppSecondaryColorResource(R.color.white);
      CRThemeDrawables var2 = new CRThemeDrawables();
      var2.setSurveyLeftArrow(R.drawable.ic_cr_survey_left);
      var2.setSurveyRightArrow(R.drawable.ic_cr_survey_right);
      var2.setAppProfileImageResource(R.drawable.img_profile);
      var1.setAppDrawables(var2);
      return var1;
   }

   protected FragmentState getCalendarEventDetailFragment(Bundle var1) {
      return (FragmentState)Fragment.instantiate(this, CalendarEventDetailFragment.class.getName(), var1);
   }

   protected FragmentState getCalendarFragment(Bundle var1) {
      return (FragmentState)Fragment.instantiate(this, CRCalendarFragment.class.getName(), var1);
   }

   protected CRDetailFragmentFactory getDetailFragmentFactory() {
      return CRDetailFragmentFactory.getInstance();
   }

   protected CRHomeFragmentFactory getHomeFragmentFactory() {
      return CRHomeFragmentFactory.getInstance();
   }

   protected int getInitialScreenMessage() {
      return -1412628477;
   }

   protected CRDynamicContentListFragmentFactory getListFragmentFactory() {
      return CRDynamicContentListFragmentFactory.getInstance();
   }

   protected int getMainActivityLayout() {
      return R.layout.activity_main;
   }

   protected CRNavigationDrawerFragment getNavigationDrawerFragment() {
      return (CRNavigationDrawerFragment)this.getFragmentManager().findFragmentById(R.id.navigation_drawer);
   }

   protected FragmentState getProfileFragment(Context var1, Bundle var2) {
      return (FragmentState)Fragment.instantiate(var1, CRProfileFragment.class.getName(), var2);
   }

   protected CRSubcategoryListFragmentFactory getSubcategoryFragmentFactory() {
      return CRSubcategoryListFragmentFactory.getInstance();
   }

   protected FragmentState getSurveyListFragment(Context var1, Bundle var2) {
      return (SurveyListFragment)Fragment.instantiate(var1, SurveyListFragment.class.getName(), var2);
   }

   protected Class getTabbarFragmentClass() {
      return CRTabbarFragment.class;
   }

   protected FragmentState getWebViewFragment(Context var1, Bundle var2) {
      return (FragmentState)Fragment.instantiate(var1, CRWebViewFragment.class.getName(), var2);
   }

   public boolean handleCRMessage(CRMessage var1) {
      return false;
   }

   public boolean handleMessage(int var1) {
      return this.handleMessage(new CRMessage(var1));
   }

   public boolean handleMessage(CRMessage var1) {
      this.hideKeyboard();
      int var3 = var1.getMessageCode();
      if(var3 == -1412628479) {
         return true;
      } else if(var3 == -1412628466) {
         ActivityUtils.shareContent(this, (String)var1.getData()[0], (String)var1.getData()[1]);
         return true;
      } else if(var3 == -1412628478) {
         this.onBackPressed();
         return true;
      } else if(var3 == -1412628470) {
         this.switchDrawer((View)var1.getData()[0]);
         return true;
      } else {
         if(var3 == -1412628477) {
            for(int var2 = 0; var2 < this.getFragmentManager().getBackStackEntryCount(); ++var2) {
               this.getFragmentManager().popBackStack();
            }
         }

         boolean var4;
         if(var3 != this.getInitialScreenMessage() && var3 != -1412628477) {
            var4 = true;
         } else {
            var4 = false;
         }

         FragmentTransaction var5 = FragmentUtils.initTransaction(this, var4);
         if(this.getFragmentManager().findFragmentById(R.id.main_content) != null) {
            var5.hide(this.getFragmentManager().findFragmentById(R.id.main_content));
         }

         new Bundle();
         Bundle var6 = new Bundle();
         Bundle var7 = new Bundle();
         String var9;
         Object var17;
         String var19;
         switch(var1.getMessageCode()) {
         case -1412628477:
            var17 = this.getHomeFragmentFactory().getHomeFragment(this, var7, homeStyle, this.getActionFactory());
            break;
         case -1412628476:
            var17 = this.getProfileFragment(this, var7);
            break;
         case -1412628475:
            var7.putString("key_url", (String)var1.getData()[0]);

            try {
               var19 = (String)var1.getData()[1];
            } catch (ArrayIndexOutOfBoundsException var12) {
               var12.printStackTrace();
               var19 = "";
            }

            var7.putString("extras_title", var19);
            var17 = this.getWebViewFragment(this, var7);
            break;
         case -1412628474:
         case -1412628471:
         case -1412628470:
         case -1412628466:
         case -1412628464:
         default:
            return this.handleCRMessage(var1);
         case -1412628473:
            String var21 = (String)var1.getData()[0];
            var9 = (String)var1.getData()[1];

            try {
               if(var1.getData()[2] != null) {
                  var7.putParcelableArrayList("tagged_extras", (ArrayList)var1.getData()[2]);
               }
            } catch (IndexOutOfBoundsException var14) {
               var14.printStackTrace();
            } catch (ClassCastException var15) {
               Log.d(CRMainActivity.class.getSimpleName(), "The 3rd parameter must be of type ArrayList<Tag>");
            }

            var7.putString("permanent_link", var21);
            var7.putString("extras_title", var9);
            var17 = this.getListFragmentFactory().getListFragment(this, var7, var21);
            break;
         case -1412628472:
            if(var1.getData()[0] instanceof Integer) {
               var7.putInt("dynamic_detail_id", ((Integer)var1.getData()[0]).intValue());
            } else {
               var7.putParcelable("dynamic_detail", (CRModel)var1.getData()[0]);
            }

            try {
               var19 = (String)var1.getData()[1];
            } catch (Exception var13) {
               var19 = "NONE";
            }

            var17 = this.getDetailFragmentFactory().getDetailFragment(this, var7, var19);
            break;
         case -1412628469:
            MobileMenu var18 = (MobileMenu)var1.getData()[0];
            var7.putString("category_parent_id", String.valueOf(var18.getId()));
            var7.putString("extras_title", var18.getTitle());
            var17 = this.getSubcategoryFragmentFactory().getSubcategoryFragment(this, var7, var18, this.getActionFactory());
            break;
         case -1412628468:
            var17 = this.getSurveyListFragment(this, var7);
            break;
         case -1412628467:
            var7.putParcelable("survey_param", (Survey)var1.getData()[0]);
            var17 = (SurveyFragment)Fragment.instantiate(this, SurveyFragment.class.getName(), var7);
            break;
         case -1412628465:
            var17 = this.getCalendarFragment(var7);
            break;
         case -1412628463:
            var7.putLong("extras_event_mindate", ((Long)var1.getData()[0]).longValue());
            var7.putLong("extras_event_maxdate", ((Long)var1.getData()[1]).longValue());

            try {
               var7.putParcelable("extras_event_detail", (CalendarEvent)var1.getData()[2]);
            } catch (Exception var11) {
               var11.printStackTrace();

               try {
                  var7.putLong("extras_event_millis", ((Long)var1.getData()[2]).longValue());
               } catch (Exception var10) {
                  var10.printStackTrace();
               }
            }

            var17 = this.getCalendarEventDetailFragment(var7);
            break;
         case -1412628462:
            Action var8 = (Action)var1.getData()[0];
            var9 = (String)var1.getData()[1];
            var7.putString("permanent_link", CaptiveReachUserInterfaceSDK.getInstance().getLayoutViewModel(var8, var9).getPermanentLink());

            try {
               var7.putSerializable("extras_layout_values", (Serializable)var1.getData()[2]);
            } catch (Exception var16) {
               var16.printStackTrace();
            }

            var7.putParcelable("extras_layout_model", CaptiveReachUserInterfaceSDK.getInstance().getLayoutViewModel(var8, var9));
            var17 = CRActionFactory.getContentFragment(this, var8, var9, var7);
         }

         if(var17 != null) {
            if(this.useTabBarFragment()) {
               FragmentState var20 = (FragmentState)Fragment.instantiate(this, this.getTabbarFragmentClass().getName(), var6);
               FragmentUtils.addFragment(var5, R.id.main_footer, var20);
            }

            if(var3 != this.getInitialScreenMessage() && var3 != -1412628477) {
               var5.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_right, R.animator.slide_in_left, R.animator.slide_out_right);
            }

            this.setScreenOrientationForActivity(((FragmentState)var17).getScreenOrientation());
            FragmentUtils.addFragment((FragmentTransaction)var5, R.id.main_content, (FragmentState)var17);
         }

         FragmentUtils.endTransaction(var5);
         return true;
      }
   }

   public void onBackPressed() {
      this.hideKeyboard();
      if(this.goToHome()) {
         this.handleMessage(-1412628477);
      } else if(!((FragmentState)this.getFragmentManager().findFragmentById(R.id.main_content)).onBack()) {
         if(this.getFragmentManager().getBackStackEntryCount() > 0) {
            this.getFragmentManager().popBackStack();
            return;
         }

         super.onBackPressed();
         return;
      }

   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.requestWindowFeature(9);
      this.setContentView(this.getMainActivityLayout());
      this.mActivityIntent = this.getIntent();
      this.handleMessage(this.getInitialScreenMessage());
      this.initializeNavigationDrawer();
      if(!this.slidingMenuStyle()) {
         this.mNavigationDrawerFragment.getNavigationDrawerLayout().setDrawerLockMode(1);
      }

      this.getFragmentManager().addOnBackStackChangedListener(new OnBackStackChangedListener() {
         public void onBackStackChanged() {
            Fragment var1 = CRMainActivity.this.getFragmentManager().findFragmentById(R.id.main_content);
            if(var1 != null) {
               FragmentState var2 = (FragmentState)var1;
               CRMainActivity.this.setScreenOrientationForActivity(var2.getScreenOrientation());
               var2.onRefresh();
            }

         }
      });
   }

   protected void onNewIntent(Intent var1) {
      super.onNewIntent(var1);
      this.setIntent(var1);
   }

   protected void onResume() {
      super.onResume();
      if(this.getIntent() != null && this.getIntent().getBooleanExtra("notification_trigger_flag", false) && this.getIntent().getParcelableExtra("notification_trigger_object") != null) {
         NotificationUtils.executeNotificationTriggerExtras(this, (NotificationTriggerResponse)this.getIntent().getExtras().getParcelable("notification_trigger_object"), this.getActionFactory());
      }

   }

   protected void onStart() {
      super.onStart();
      setIsActive(true);
   }

   protected void onStop() {
      super.onStop();
      setIsActive(false);
   }

   public void switchDrawer(View var1) {
      if(var1.getId() == R.id.actionbarhome_left_action && this.mNavigationDrawerFragment != null) {
         if(!this.mNavigationDrawerFragment.isDrawerOpen()) {
            this.mNavigationDrawerFragment.openDrawer();
            return;
         }

         this.mNavigationDrawerFragment.closeDrawer();
      }

   }

   protected boolean useTabBarFragment() {
      return homeStyle == CRContentHomeStyle.GridViewmenu || homeStyle == CRContentHomeStyle.GridViewmenuHalf;
   }
}
