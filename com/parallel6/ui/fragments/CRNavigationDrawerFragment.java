package com.parallel6.ui.fragments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import com.google.gson.reflect.TypeToken;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.captivereachconnectsdk.builders.DynamicContentTaskBuilder;
import com.parallel6.captivereachconnectsdk.enums.CRCachePolicy;
import com.parallel6.captivereachconnectsdk.models.MobileMenu;
import com.parallel6.captivereachconnectsdk.models.json.response.MobileMenuResponse;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.captivereachconnectsdk.utils.StringUtils;
import com.parallel6.ui.actions.CRActionFactory;
import com.parallel6.ui.activities.CRMainActivity;
import com.parallel6.ui.adapters.list.CRExpandableDrawerListAdapter;
import com.parallel6.ui.enums.styles.CRContentHomeStyle;
import com.parallel6.ui.fragments.base.BaseFragment;
import com.parallel6.ui.interfaces.CRMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class CRNavigationDrawerFragment extends BaseFragment {
   private static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";
   private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";
   private CRExpandableDrawerListAdapter drawerAdapter;
   private ArrayList list;
   private int mCurrentSelectedPosition = 0;
   private ExpandableListView mDrawerExpandableListView;
   private DrawerLayout mDrawerLayout;
   private ActionBarDrawerToggle mDrawerToggle;
   private View mFragmentContainerView;
   private boolean mFromSavedInstanceState;
   private boolean mUserLearnedDrawer;
   private HashMap menuChilds;
   private TaskListener onTaskListener = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
      }

      public void onTaskSuccess(MobileMenuResponse var1) {
         if(var1 != null && CRNavigationDrawerFragment.this.getActivity() != null) {
            CRNavigationDrawerFragment.this.insertCategories(var1.getMobileMenus());
         }

      }

      public void onTaskTimeOut() {
      }
   };

   private void insertCategories(List var1) {
      this.list = new ArrayList();
      this.menuChilds = new HashMap();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         MobileMenu var2 = (MobileMenu)var3.next();
         this.list.add(var2);
         if(var2.getSubcategories() != null && var2.getSubcategories().size() > 0) {
            this.menuChilds.put(var2, var2.getSubcategories());
         } else {
            this.menuChilds.put(var2, new ArrayList());
         }
      }

      this.drawerAdapter = new CRExpandableDrawerListAdapter(this.getActivity(), this.list, this.menuChilds);
      this.mDrawerExpandableListView.setAdapter(this.drawerAdapter);
      this.mDrawerExpandableListView.setItemChecked(this.mCurrentSelectedPosition, true);
   }

   private void selectChildItem(MobileMenu var1) {
      if(this.mDrawerLayout != null) {
         this.mDrawerLayout.closeDrawer(this.mFragmentContainerView);
      }

      if(StringUtils.isNotEmpty(var1.getAction())) {
         ((CRMainActivity)this.getActivity()).getActionFactory().executeAction(CRActionFactory.getSafeAction(var1.getAction().toUpperCase()), var1, this.controller);
      }

   }

   private void selectItem(int var1) {
      this.mCurrentSelectedPosition = var1;
      if(this.mDrawerExpandableListView != null) {
         this.mDrawerExpandableListView.setItemChecked(var1, true);
      }

      if(this.mDrawerLayout != null) {
         this.mDrawerLayout.closeDrawer(this.mFragmentContainerView);
      }

      MobileMenu var2 = this.drawerAdapter.getGroup(var1);
      if(StringUtils.isNotEmpty(var2.getAction())) {
         ((CRMainActivity)this.getActivity()).getActionFactory().executeAction(CRActionFactory.getSafeAction(var2.getAction().toUpperCase()), var2, this.controller);
      }

   }

   protected boolean actionBarRequired() {
      return false;
   }

   public void closeDrawer() {
      this.mDrawerLayout.closeDrawer(this.mFragmentContainerView);
   }

   public DrawerLayout getNavigationDrawerLayout() {
      return this.mDrawerLayout;
   }

   public boolean handleMessage(int var1) {
      return false;
   }

   public boolean handleMessage(CRMessage var1) {
      return false;
   }

   public boolean isDrawerOpen() {
      return this.mDrawerLayout != null && this.mDrawerLayout.isDrawerOpen(this.mFragmentContainerView);
   }

   public void onActivityCreated(Bundle var1) {
      super.onActivityCreated(var1);
      this.setHasOptionsMenu(true);
   }

   public void onConfigurationChanged(Configuration var1) {
      super.onConfigurationChanged(var1);
      this.mDrawerToggle.onConfigurationChanged(var1);
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.mUserLearnedDrawer = PreferenceManager.getDefaultSharedPreferences(this.getActivity()).getBoolean("navigation_drawer_learned", false);
      if(var1 != null) {
         this.mCurrentSelectedPosition = var1.getInt("selected_navigation_drawer_position");
         this.mFromSavedInstanceState = true;
      }

   }

   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      super.onCreateOptionsMenu(var1, var2);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(R.layout.fragment_navigation_drawer_expandable, var2, false);
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      return this.mDrawerToggle.onOptionsItemSelected(var1) || super.onOptionsItemSelected(var1);
   }

   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putInt("selected_navigation_drawer_position", this.mCurrentSelectedPosition);
   }

   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      if(CRMainActivity.getHomeStyle() == CRContentHomeStyle.SlidingMenu) {
         this.setTopPadding(true);
         this.mDrawerExpandableListView = (ExpandableListView)var1.findViewById(R.id.navigation_drawer_listview);
         this.mDrawerExpandableListView.setOnGroupClickListener(new OnGroupClickListener() {
            public boolean onGroupClick(ExpandableListView var1, View var2, int var3, long var4) {
               if(CRNavigationDrawerFragment.this.menuChilds.get(CRNavigationDrawerFragment.this.list.get(var3)) != null && ((List)CRNavigationDrawerFragment.this.menuChilds.get(CRNavigationDrawerFragment.this.list.get(var3))).size() == 0) {
                  var2.setPressed(true);
                  CRNavigationDrawerFragment.this.selectItem(var3);
                  return true;
               } else {
                  return false;
               }
            }
         });
         this.mDrawerExpandableListView.setOnChildClickListener(new OnChildClickListener() {
            public boolean onChildClick(ExpandableListView var1, View var2, int var3, int var4, long var5) {
               CRNavigationDrawerFragment.this.selectChildItem((MobileMenu)var2.getTag());
               return false;
            }
         });
         (new DynamicContentTaskBuilder()).withContext(this.getActivity()).withPath("v2/mobile_menus?include_subcategories=true").withCachePolicy(CRCachePolicy.NETWORK_FIRST).withMethod("GET").withTaskListener(this.onTaskListener).withType((new TypeToken() {
         }).getType()).build().execute();
      }
   }

   public void openDrawer() {
      this.mDrawerLayout.openDrawer(this.mFragmentContainerView);
   }

   public void setUp(int var1, DrawerLayout var2) {
      this.mFragmentContainerView = this.findView(this.getView(), var1);
      this.mDrawerLayout = var2;
      this.mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, 8388611);
      this.mDrawerToggle = new ActionBarDrawerToggle(this.getActivity(), this.mDrawerLayout, R.drawable.ic_drawer, R.string.empty, R.string.empty) {
         public void onDrawerClosed(View var1) {
            super.onDrawerClosed(var1);
            if(CRNavigationDrawerFragment.this.isAdded()) {
               CRNavigationDrawerFragment.this.getActivity().invalidateOptionsMenu();
            }
         }

         public void onDrawerOpened(View var1) {
            super.onDrawerOpened(var1);
            if(CRNavigationDrawerFragment.this.isAdded()) {
               if(!CRNavigationDrawerFragment.this.mUserLearnedDrawer) {
                  CRNavigationDrawerFragment.this.mUserLearnedDrawer = true;
                  PreferenceManager.getDefaultSharedPreferences(CRNavigationDrawerFragment.this.getActivity()).edit().putBoolean("navigation_drawer_learned", true).apply();
               }

               CRNavigationDrawerFragment.this.getActivity().invalidateOptionsMenu();
            }
         }
      };
      this.mDrawerLayout.post(new Runnable() {
         public void run() {
            CRNavigationDrawerFragment.this.mDrawerToggle.syncState();
         }
      });
      this.mDrawerLayout.setDrawerListener(this.mDrawerToggle);
   }
}
