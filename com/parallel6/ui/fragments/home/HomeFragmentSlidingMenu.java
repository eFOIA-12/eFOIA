package com.parallel6.ui.fragments.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import com.androidquery.AQuery;
import com.google.gson.reflect.TypeToken;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.captivereachconnectsdk.builders.DynamicContentTaskBuilder;
import com.parallel6.captivereachconnectsdk.models.CRImage;
import com.parallel6.captivereachconnectsdk.models.json.response.AdvertisementResponse;
import com.parallel6.captivereachconnectsdk.models.json.response.DynamicContentResponse;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.ui.activities.CRMainActivity;
import com.parallel6.ui.adapters.pager.AdsPageAdapter;
import com.parallel6.ui.adapters.pager.InfinitePagerAdapter;
import com.parallel6.ui.enums.Action;
import com.parallel6.ui.fragments.base.BaseFragment;
import com.parallel6.ui.interfaces.CRMessage;
import com.parallel6.ui.models.SocialSite;
import com.parallel6.ui.widgets.CustomScroller;
import com.parallel6.ui.widgets.InfiniteViewPager;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

public class HomeFragmentSlidingMenu extends BaseFragment {
   private static final long ANIM_VIEWPAGER_DELAY = 3000L;
   private AdsPageAdapter adsAdapter;
   private TaskListener adsListener = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
      }

      public void onTaskSuccess(AdvertisementResponse var1) {
         if(var1.getAdvertisements().size() > 0) {
            HomeFragmentSlidingMenu.this.initAdvertisements(var1.getAdvertisements());
         }

      }

      public void onTaskTimeOut() {
      }
   };
   private List advertisements;
   private InfiniteViewPager advertisementsPager;
   int currentPage = 0;
   private InfinitePagerAdapter infinitePagerAdapter;
   private boolean initialized = false;
   private OnClickListener onActionClickListener = new OnClickListener() {
      public void onClick(View var1) {
      }
   };
   ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
      public void onPageScrollStateChanged(int var1) {
      }

      public void onPageScrolled(int var1, float var2, int var3) {
         HomeFragmentSlidingMenu.this.currentPage = var1;
         HomeFragmentSlidingMenu.this.scrolling = true;
      }

      public void onPageSelected(int var1) {
         HomeFragmentSlidingMenu.this.currentPage = var1;
         HomeFragmentSlidingMenu.this.scrolling = false;
      }
   };
   private boolean scrolling = false;
   private TaskListener socialSitesTaskListener = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
      }

      public void onTaskSuccess(DynamicContentResponse var1) {
         if(var1.getContent().size() > 0) {
            HomeFragmentSlidingMenu.this.setupSocialSitesBanner(var1.getContent());
         }

      }

      public void onTaskTimeOut() {
      }
   };

   private ImageView getSocialSiteView(SocialSite var1) {
      ImageView var4 = new ImageView(this.getActivity());
      var4.setScaleType(ScaleType.FIT_CENTER);
      int var2 = (int)this.getResources().getDimension(R.dimen.margin_social_button);
      int var3 = (int)this.getResources().getDimension(R.dimen.size_social_button);
      LayoutParams var5 = new LayoutParams(var3, var3, 1.0F);
      var5.setMargins(var2, var2, var2, var2);
      ((AQuery)(new AQuery(this.getActivity())).id(var4)).image(var1.getImage().getImageForDensity(CRImage.IMAGE_TYPE.SMALL, this.getActivity()));
      var4.setTag(var1);
      var4.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            SocialSite var3 = (SocialSite)var1.getTag();

            try {
               ((CRMainActivity)HomeFragmentSlidingMenu.this.getActivity()).getActionFactory().executeAction(Action.valueOf(var3.getActionModel().getAction().toUpperCase()), var3.getActionModel().getActionObject(), HomeFragmentSlidingMenu.this.controller);
            } catch (Exception var2) {
               var2.printStackTrace();
            }
         }
      });
      var4.setLayoutParams(var5);
      return var4;
   }

   private void initAdvertisements(List var1) {
      this.advertisements = var1;

      try {
         Field var4 = ViewPager.class.getDeclaredField("mScroller");
         var4.setAccessible(true);
         CustomScroller var2 = new CustomScroller(this.getActivity());
         var2.setmDuration(3000);
         var4.set(this.advertisementsPager, var2);
      } catch (Exception var3) {
         var3.printStackTrace();
      }

      this.adsAdapter = new AdsPageAdapter(this.getActivity(), this.advertisements, this.onActionClickListener);
      this.infinitePagerAdapter = new InfinitePagerAdapter(this.adsAdapter);
      this.advertisementsPager.setAdapter(this.infinitePagerAdapter);
      this.advertisementsPager.setOnPageChangeListener(this.pageChangeListener);
      if(this.adsAdapter.getCount() > 1) {
         this.startAutomaticScroll();
      }

      this.initialized = true;
   }

   private void setupSocialSitesBanner(List var1) {
      if(this.getView() != null) {
         LinearLayout var2 = (LinearLayout)this.getView().findViewById(R.id.fragment_home_social_site_lyt);
         Iterator var3 = var1.iterator();

         while(var3.hasNext()) {
            var2.addView(this.getSocialSiteView((SocialSite)var3.next()));
         }
      }

   }

   private void startAutomaticScroll() {
      if(this.advertisementsPager != null && this.adsAdapter != null && !this.scrolling) {
         this.advertisementsPager.postDelayed(new Runnable() {
            public void run() {
               HomeFragmentSlidingMenu.this.advertisementsPager.setCurrentItem(HomeFragmentSlidingMenu.this.currentPage + 1, true);
               HomeFragmentSlidingMenu.this.startAutomaticScroll();
            }
         }, 3000L);
      }

   }

   protected View getHomeActionBarView(Context var1) {
      View var4 = View.inflate(var1, R.layout.actionbar_custom_home, (ViewGroup)null);
      ImageView var2 = (ImageView)var4.findViewById(R.id.actionbarhome_left_action);
      ImageView var3 = (ImageView)var4.findViewById(R.id.actionbarhome_right_action);
      var2.setImageResource(R.drawable.ic_drawer);
      var2.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            HomeFragmentSlidingMenu.this.controller.handleMessage(new CRMessage(-1412628470, new Object[]{var1}));
         }
      });
      var3.setVisibility(8);
      return var4;
   }

   public boolean handleMessage(int var1) {
      return false;
   }

   public boolean handleMessage(CRMessage var1) {
      return false;
   }

   public void initTopActionBar() {
      this.setTopPadding(true);
      this.showSystemActionBar(this.getHomeActionBarView(this.getActivity()));
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      (new DynamicContentTaskBuilder()).withContext(this.getActivity()).withPermanentLink("social_sites").withMethod("GET").withTaskListener(this.socialSitesTaskListener).withType((new TypeToken() {
      }).getType()).build().execute();
      Type var2 = (new TypeToken() {
      }).getType();
      (new DynamicContentTaskBuilder()).withContext(this.getActivity()).withMethod("GET").withPath("advertisements").withTaskListener(this.adsListener).withType(var2).build().execute();
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(R.layout.fragment_home_sliding_menu, var2, false);
   }

   public void onPause() {
      super.onPause();
      this.scrolling = false;
      this.initialized = false;
   }

   public void onResume() {
      super.onResume();
      if(!this.initialized && this.advertisementsPager != null && this.adsAdapter != null && !this.scrolling && this.adsAdapter.getCount() > 1) {
         this.startAutomaticScroll();
      }

   }

   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.advertisementsPager = (InfiniteViewPager)var1.findViewById(R.id.fragment_home_grid_viewPager_advertisements);
   }

   public void showToast(String var1) {
      if(this.getActivity() != null) {
         Toast.makeText(this.getActivity(), var1, 0).show();
      }

   }
}
