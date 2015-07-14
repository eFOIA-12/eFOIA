package com.parallel6.ui.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.AbsListView.LayoutParams;
import com.androidquery.AQuery;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.captivereachconnectsdk.models.CRImage;
import com.parallel6.captivereachconnectsdk.models.MobileMenu;
import java.util.List;

public class CategoriesGridAdapter extends BaseAdapter implements OnClickListener {
   private static int COLUMNS = 3;
   private static int ROWS = 2;
   private int bgCategoriesGridBottom = -1;
   private int bgCategoriesGridTop = -1;
   private List categories;
   private int categoriesPerPage;
   private CategoriesGridAdapter.OnCategorySelectedListener categorySelectedListener;
   private boolean isShowTitle;
   private Context mContext;
   private boolean matchSize;

   public CategoriesGridAdapter(Context var1, List var2, int var3) {
      this.mContext = var1;
      this.categories = var2;
      this.categoriesPerPage = var3;
   }

   public CategoriesGridAdapter(Context var1, List var2, int var3, int var4, int var5, CategoriesGridAdapter.OnCategorySelectedListener var6) {
      this.mContext = var1;
      this.categories = var2;
      this.categoriesPerPage = var3;
      this.bgCategoriesGridTop = var4;
      this.bgCategoriesGridBottom = var5;
      this.categorySelectedListener = var6;
   }

   public CategoriesGridAdapter(Context var1, List var2, int var3, int var4, int var5, CategoriesGridAdapter.OnCategorySelectedListener var6, boolean var7) {
      this.mContext = var1;
      this.categories = var2;
      this.categoriesPerPage = var3;
      this.bgCategoriesGridTop = var4;
      this.bgCategoriesGridBottom = var5;
      this.categorySelectedListener = var6;
      this.matchSize = var7;
   }

   public CategoriesGridAdapter(Context var1, List var2, int var3, CategoriesGridAdapter.OnCategorySelectedListener var4) {
      this.mContext = var1;
      this.categories = var2;
      this.categoriesPerPage = var3;
      this.categorySelectedListener = var4;
   }

   protected int getCategoryGridLayout() {
      return R.layout.category_image;
   }

   public int getCount() {
      return this.categories.size();
   }

   public Object getItem(int var1) {
      return null;
   }

   public long getItemId(int var1) {
      return 0L;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      MobileMenu var8 = (MobileMenu)this.categories.get(var1);
      int var7 = var3.getWidth() / COLUMNS;
      int var6 = var3.getHeight() / ROWS;
      LinearLayout var11 = (LinearLayout)View.inflate(this.mContext, this.getCategoryGridLayout(), (ViewGroup)null);
      var11.setTag(var8);
      var11.setOnClickListener(this);
      int var5 = var6;
      int var4 = var7;
      if(this.matchSize) {
         var4 = Math.min(var6, var7);
         var5 = Math.min(var6, var4);
      }

      ImageView var12 = (ImageView)var11.findViewById(R.id.grid_category_iv);
      TextView var9 = (TextView)var11.findViewById(R.id.grid_category_tv_title);
      if(this.isShowTitle) {
         var9.setText(var8.getTitle());
      } else {
         var9.setVisibility(8);
      }

      var11.setLayoutParams(new LayoutParams(var4, var5));
      var11.setMinimumHeight(var5);
      var11.setMinimumWidth(var4);
      if(var1 / (this.categoriesPerPage / ROWS) == 0) {
         if(this.bgCategoriesGridTop != -1) {
            var11.setBackgroundResource(this.bgCategoriesGridTop);
         } else {
            var11.setBackgroundResource(R.drawable.bg_categories_toprow);
         }
      } else if(var1 / (this.categoriesPerPage / ROWS) == 1) {
         if(this.bgCategoriesGridBottom != -1) {
            var11.setBackgroundResource(this.bgCategoriesGridBottom);
         } else {
            var11.setBackgroundResource(R.drawable.bg_categories_bottomrow);
         }
      }

      String var13 = var8.getImage().getCRImage().getImageForDensity(CRImage.IMAGE_TYPE.SMALL, (Activity)this.mContext);
      AQuery var14 = new AQuery(this.mContext);
      Bitmap var10 = var14.getCachedImage(var13);
      if(var10 != null) {
         ((AQuery)var14.id(var12)).image(var13, true, true, 0, 0, var10, -1);
         return var11;
      } else {
         ((AQuery)var14.id(var12)).image(var13, true, true, 0, 0);
         return var11;
      }
   }

   public void isShowTitle(boolean var1) {
      this.isShowTitle = var1;
   }

   public void onClick(View var1) {
      if(this.categorySelectedListener != null) {
         this.categorySelectedListener.onCategorySelected((MobileMenu)var1.getTag());
      }

   }

   public interface OnCategorySelectedListener {
      void onCategorySelected(MobileMenu var1);
   }
}
