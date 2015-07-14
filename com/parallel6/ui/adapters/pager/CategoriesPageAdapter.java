package com.parallel6.ui.adapters.pager;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.GridView;
import com.parallel6.captivereachconnectsdk.CaptiveReachConnect;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.captivereachconnectsdk.models.MobileMenu;
import com.parallel6.ui.actions.CRActionFactory;
import com.parallel6.ui.adapters.CategoriesGridAdapter;
import com.parallel6.ui.enums.Action;
import com.parallel6.ui.interfaces.ControllerState;
import java.util.ArrayList;
import java.util.List;

public class CategoriesPageAdapter extends PagerAdapter {
   private static final String TAG = CategoriesPageAdapter.class.getSimpleName();
   protected CRActionFactory actionFactory;
   protected Activity activity;
   private int bgCategoriesGridBottom = -1;
   private int bgCategoriesGridTop = -1;
   protected ControllerState categoriesController;
   private CategoriesGridAdapter.OnCategorySelectedListener categoriesListener = new CategoriesGridAdapter.OnCategorySelectedListener() {
      public void onCategorySelected(MobileMenu var1) {
         CaptiveReachConnect.getInstance().trackInsightV2(CategoriesPageAdapter.this.context, "mobile_menus", "open", String.valueOf(var1.getId()), var1.getTitle());
         CategoriesPageAdapter.this.actionFactory.executeAction(Action.valueOf(var1.getAction().toUpperCase()), var1, CategoriesPageAdapter.this.categoriesController);
      }
   };
   private final int categoriesPerPage = 6;
   private List categoryList;
   protected Context context;
   private boolean isShowTitle = true;
   private boolean matchSize;
   protected OnClickListener onActionClickListener;

   public CategoriesPageAdapter(Context var1, List var2, int var3, int var4, ControllerState var5, CRActionFactory var6) {
      this.context = var1;
      this.categoryList = var2;
      this.categoriesController = var5;
      this.bgCategoriesGridTop = var3;
      this.bgCategoriesGridBottom = var4;
      this.actionFactory = var6;
   }

   public CategoriesPageAdapter(Context var1, List var2, int var3, int var4, ControllerState var5, boolean var6, CRActionFactory var7) {
      this.context = var1;
      this.categoryList = var2;
      this.categoriesController = var5;
      this.bgCategoriesGridTop = var3;
      this.bgCategoriesGridBottom = var4;
      this.matchSize = var6;
      this.actionFactory = var7;
   }

   public void destroyItem(ViewGroup var1, int var2, Object var3) {
      var1.removeView((View)var3);
   }

   protected CategoriesGridAdapter getCategoriesGridAdapter(Context var1, List var2, int var3, int var4, int var5, CategoriesGridAdapter.OnCategorySelectedListener var6, boolean var7) {
      return new CategoriesGridAdapter(var1, var2, var3, var4, var5, var6, var7);
   }

   protected CategoriesGridAdapter.OnCategorySelectedListener getCategoriesGridListener() {
      return this.categoriesListener;
   }

   protected int getCategoryPageLayoutResource() {
      return R.layout.page_category;
   }

   public int getCount() {
      return (int)Math.ceil((double)this.categoryList.size() / 6.0D);
   }

   public boolean getIsShowTitle() {
      return this.isShowTitle;
   }

   public Object instantiateItem(ViewGroup var1, int var2) {
      Log.d(TAG, "Inflating page: " + var2);
      View var5 = LayoutInflater.from(this.context).inflate(this.getCategoryPageLayoutResource(), var1, false);
      GridView var6 = (GridView)var5.findViewById(R.id.categories_gridview);
      var2 *= 6;
      int var4 = var2 + 6;
      Log.d(TAG, "Showing categories: [" + var2 + ", " + var4 + "]");
      ArrayList var7 = new ArrayList();

      while(true) {
         int var3;
         if(var4 < this.categoryList.size()) {
            var3 = var4;
         } else {
            var3 = this.categoryList.size();
         }

         if(var2 >= var3) {
            CategoriesGridAdapter var8 = this.getCategoriesGridAdapter(this.context, var7, 6, this.bgCategoriesGridTop, this.bgCategoriesGridBottom, this.getCategoriesGridListener(), this.matchSize);
            var8.isShowTitle(this.getIsShowTitle());
            var6.setAdapter(var8);
            var1.addView(var5);
            return var5;
         }

         var7.add(this.categoryList.get(var2));
         ++var2;
      }
   }

   public boolean isViewFromObject(View var1, Object var2) {
      return var1.equals(var2);
   }

   public void setIsShowTitle(boolean var1) {
      this.isShowTitle = var1;
   }
}
