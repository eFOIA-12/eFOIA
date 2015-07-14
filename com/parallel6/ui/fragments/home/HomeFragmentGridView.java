package com.parallel6.ui.fragments.home;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.google.gson.reflect.TypeToken;
import com.parallel6.captivereachconnectsdk.CaptiveReachConnect;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.captivereachconnectsdk.builders.DynamicContentTaskBuilder;
import com.parallel6.captivereachconnectsdk.enums.CRCachePolicy;
import com.parallel6.captivereachconnectsdk.models.Advertisement;
import com.parallel6.captivereachconnectsdk.models.json.response.AdvertisementResponse;
import com.parallel6.captivereachconnectsdk.models.json.response.AdvertisementSettingsResponse;
import com.parallel6.captivereachconnectsdk.models.json.response.MobileMenuResponse;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.ui.activities.CRMainActivity;
import com.parallel6.ui.adapters.pager.AdsPageAdapter;
import com.parallel6.ui.adapters.pager.CategoriesPageAdapter;
import com.parallel6.ui.adapters.pager.InfinitePagerAdapter;
import com.parallel6.ui.fragments.base.BaseFragment;
import com.parallel6.ui.interfaces.CRMessage;
import com.parallel6.ui.widgets.CustomScroller;
import com.parallel6.ui.widgets.InfiniteViewPager;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;

public class HomeFragmentGridView extends BaseFragment {
   private static final long ANIM_VIEWPAGER_DELAY = 3000L;
   private static final int ANIM_VIEWPAGER_TRANSITION = 2000;
   private static final long MILI_TO_SECOND = 1000L;
   private TaskListener adsSettingsListener = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
      }

      public void onTaskSuccess(AdvertisementSettingsResponse var1) {
         boolean var2 = true;
         if(var1 != null && var1.getAdsSettings() != null) {
            if(var1.getAdsSettings().getAdvertisementSetting() != null) {
               HomeFragmentGridView.this.mAdsSettingsFetched = true;
               HomeFragmentGridView.this.mTransitionTime = (long)var1.getAdsSettings().getAdvertisementSetting().getTransitionTime() * 1000L;
               HomeFragmentGridView.this.mDisplayTime = (long)var1.getAdsSettings().getAdvertisementSetting().getDisplayTime() * 1000L;
            }

            if(HomeFragmentGridView.this.mAdsInitialized) {
               var2 = false;
            }

            if(var2 & HomeFragmentGridView.this.mAdvertisementsFetched) {
               HomeFragmentGridView.this.initAdvertisements(HomeFragmentGridView.this.mAdvertisementsList);
            }

            if(HomeFragmentGridView.this.mTransitionTime == 0L) {
               HomeFragmentGridView.this.mTransitionTime = 2000L;
            }
         }

         if(HomeFragmentGridView.this.mAdsSettingsFetched & HomeFragmentGridView.this.mAdvertisementsFetched & HomeFragmentGridView.this.mCategoriesFetched && HomeFragmentGridView.this.mProgressBar != null) {
            HomeFragmentGridView.this.mProgressBar.setVisibility(8);
            HomeFragmentGridView.this.showHomeContent();
         }

      }

      public void onTaskTimeOut() {
      }
   };
   private TaskListener advertisementTaskListener = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
      }

      public void onTaskSuccess(AdvertisementResponse var1) {
         HomeFragmentGridView.this.mAdvertisementsFetched = true;
         if(var1.getAdvertisements().size() > 0) {
            HomeFragmentGridView.this.initAdvertisements(var1.getAdvertisements());
         }

         if(HomeFragmentGridView.this.mAdvertisementsFetched & HomeFragmentGridView.this.mCategoriesFetched & HomeFragmentGridView.this.mAdsSettingsFetched && HomeFragmentGridView.this.mProgressBar != null) {
            HomeFragmentGridView.this.mProgressBar.setVisibility(8);
            HomeFragmentGridView.this.showHomeContent();
         }

      }

      public void onTaskTimeOut() {
      }
   };
   private OnClickListener advertisementsClickListener = new OnClickListener() {
      public void onClick(View var1) {
         HomeFragmentGridView.this.clickAD(var1);
         Advertisement var2 = (Advertisement)var1.getTag();
         if(var2 != null) {
            CaptiveReachConnect.getInstance().trackInsightV2(HomeFragmentGridView.this.getActivity(), "advertisements", "open", String.valueOf(var2.getId()), var2.getTitle());
         }

      }
   };
   private TaskListener categoriesTaskListener = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
      }

      public void onTaskSuccess(MobileMenuResponse var1) {
         HomeFragmentGridView.this.mCategoriesFetched = true;
         if(var1.getMobileMenus().size() > 0) {
            HomeFragmentGridView.this.initCategories(var1.getMobileMenus());
         }

         if(HomeFragmentGridView.this.mCategoriesFetched & HomeFragmentGridView.this.mAdvertisementsFetched & HomeFragmentGridView.this.mAdsSettingsFetched && HomeFragmentGridView.this.mProgressBar != null) {
            HomeFragmentGridView.this.mProgressBar.setVisibility(8);
            HomeFragmentGridView.this.showHomeContent();
         }

      }

      public void onTaskTimeOut() {
      }
   };
   private boolean mAdsInitialized;
   private boolean mAdsSettingsFetched;
   private AdsPageAdapter mAdvertisementsAdapter;
   private boolean mAdvertisementsFetched;
   private List mAdvertisementsList;
   protected InfiniteViewPager mAdvertisementsPager;
   private boolean mCategoriesFetched;
   protected InfiniteViewPager mCategoriesPager;
   private int mCurrentPage;
   private long mDisplayTime = 3000L;
   private RelativeLayout mHomeContentLayout;
   private ProgressBar mProgressBar;
   private boolean mScrolling;
   private long mTransitionTime;
   private ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
      public void onPageScrollStateChanged(int var1) {
         HomeFragmentGridView.this.mScrolling = false;
      }

      public void onPageScrolled(int var1, float var2, int var3) {
         if(HomeFragmentGridView.this.mCurrentPage != var1) {
            HomeFragmentGridView.this.mCurrentPage = var1;
            HomeFragmentGridView.this.mScrolling = true;

            Advertisement var4;
            try {
               InfinitePagerAdapter var6 = (InfinitePagerAdapter)HomeFragmentGridView.this.mAdvertisementsPager.getAdapter();
               var4 = (Advertisement)HomeFragmentGridView.this.mAdvertisementsList.get(var6.getRealPosition());
            } catch (Exception var5) {
               var4 = null;
            }

            if(var4 != null) {
               CaptiveReachConnect.getInstance().trackInsightV2(HomeFragmentGridView.this.getActivity(), "advertisements", "view", String.valueOf(var4.getId()), var4.getTitle());
               return;
            }
         }

      }

      public void onPageSelected(int var1) {
      }
   };

   private void initAdvertisements(List var1) {
      if(var1 != null && var1.size() != 0) {
         this.mAdvertisementsList = var1;

         try {
            Field var4 = ViewPager.class.getDeclaredField("mScroller");
            var4.setAccessible(true);
            CustomScroller var2 = new CustomScroller(this.getActivity());
            var2.setmDuration((int)this.mTransitionTime);
            var4.set(this.mAdvertisementsPager, var2);
         } catch (Exception var3) {
            var3.printStackTrace();
         }

         this.mAdvertisementsAdapter = new AdsPageAdapter(this.getActivity(), this.mAdvertisementsList, this.advertisementsClickListener);
         InfinitePagerAdapter var5 = new InfinitePagerAdapter(this.mAdvertisementsAdapter);
         this.mAdvertisementsPager.setAdapter(var5);
         this.mAdvertisementsPager.setOnPageChangeListener(this.pageChangeListener);
         if(this.mAdvertisementsAdapter.getCount() > 1) {
            this.startAutomaticScroll();
         } else {
            this.mAdvertisementsPager.setSwipeable(false);
         }

         this.mAdsInitialized = true;
      }
   }

   private void showHomeContent() {
      if(this.mHomeContentLayout != null) {
         this.mHomeContentLayout.setVisibility(0);
      }

   }

   private void startAutomaticScroll() {
      if(this.mAdvertisementsPager != null && this.mAdvertisementsAdapter != null && !this.mScrolling) {
         if(this.mDisplayTime == 0L) {
            this.mDisplayTime = 3000L;
         }

         this.mAdvertisementsPager.postDelayed(new Runnable() {
            public void run() {
               if(HomeFragmentGridView.this.mAdsInitialized) {
                  HomeFragmentGridView.this.mAdvertisementsPager.setCurrentItem(HomeFragmentGridView.this.mCurrentPage + 1, true);
                  HomeFragmentGridView.this.startAutomaticScroll();
               } else {
                  HomeFragmentGridView.this.mAdvertisementsPager.removeCallbacks(this);
               }
            }
         }, this.mDisplayTime);
      }

   }

   protected void clickAD(View var1) {
   }

   protected PagerAdapter getCategoriesPagerAdapter(List var1) {
      return new CategoriesPageAdapter(this.getActivity(), var1, this.getGridTopRowBackground(), this.getGridBottomRowBackground(), this.controller, this.matchGridSize(), ((CRMainActivity)this.getActivity()).getActionFactory());
   }

   protected int getGridBottomRowBackground() {
      return -1;
   }

   protected int getGridTopRowBackground() {
      return -1;
   }

   protected int getHomeFragmentGridViewLayoutResource() {
      return R.layout.fragment_home_grid_view;
   }

   public boolean handleMessage(int var1) {
      return false;
   }

   public boolean handleMessage(CRMessage var1) {
      return false;
   }

   protected void initCategories(List var1) {
      this.mCategoriesPager.setAdapter(this.getCategoriesPagerAdapter(var1));
   }

   public void initTopActionBar() {
      this.setTopPadding(false);
      this.hideActionBar();
   }

   protected boolean matchGridSize() {
      return false;
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      Type var2 = (new TypeToken() {
      }).getType();
      (new DynamicContentTaskBuilder()).withContext(this.getActivity()).withMethod("GET").withCachePolicy(CRCachePolicy.CACHE_FIRST).withPath("advertisements").withTaskListener(this.advertisementTaskListener).withType(var2).build().execute();
      var2 = (new TypeToken() {
      }).getType();
      (new DynamicContentTaskBuilder()).withContext(this.getActivity()).withMethod("GET").withCachePolicy(CRCachePolicy.CACHE_FIRST).withPath("advertisements/settings").withTaskListener(this.adsSettingsListener).withType(var2).build().execute();
      var2 = (new TypeToken() {
      }).getType();
      (new DynamicContentTaskBuilder()).withContext(this.getActivity()).withMethod("GET").withCachePolicy(CRCachePolicy.NETWORK_FIRST).withPath("v2/mobile_menus").withTaskListener(this.categoriesTaskListener).withType(var2).build().execute();
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(this.getHomeFragmentGridViewLayoutResource(), var2, false);
   }

   public void onPause() {
      super.onPause();
      this.mScrolling = false;
      this.mAdsInitialized = false;
   }

   public void onResume() {
      super.onResume();
      if(!this.mAdsInitialized && this.mAdvertisementsPager != null && this.mAdvertisementsAdapter != null && !this.mScrolling) {
         if(this.mAdvertisementsAdapter.getCount() <= 1) {
            this.mAdvertisementsPager.setSwipeable(false);
            return;
         }

         this.mAdsInitialized = true;
         this.startAutomaticScroll();
      }

   }

   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.mAdvertisementsPager = (InfiniteViewPager)var1.findViewById(R.id.fragment_home_grid_viewPager_advertisements);
      this.mCategoriesPager = (InfiniteViewPager)var1.findViewById(R.id.fragment_home_grid_viewPager_categories);
      this.mHomeContentLayout = (RelativeLayout)var1.findViewById(R.id.fragment_home_grid_lyt_content);
      this.mProgressBar = (ProgressBar)var1.findViewById(R.id.fragment_home_grid_pb_loading);
   }
}
