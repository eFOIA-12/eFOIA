package com.androidquery.util;

import android.app.Activity;
import android.app.Dialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Gallery;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import com.androidquery.AQuery;
import com.androidquery.callback.BitmapAjaxCallback;
import com.androidquery.util.AQUtility;
import java.io.File;
import java.util.Comparator;

public class Common implements Comparator, Runnable, OnClickListener, OnLongClickListener, OnItemClickListener, OnItemLongClickListener, OnScrollListener, OnItemSelectedListener, TextWatcher {
   protected static final int CLEAN_CACHE = 2;
   protected static final int STORE_FILE = 1;
   private boolean fallback;
   private boolean galleryListen = false;
   private OnItemSelectedListener galleryListener;
   private Object handler;
   private int lastBottom;
   private String method;
   private int methodId;
   private OnScrollListener osl;
   private Object[] params;
   private int scrollState = 0;
   private Class[] sig;

   private void checkScrolledBottom(AbsListView var1, int var2) {
      int var3 = var1.getCount();
      int var4 = var1.getLastVisiblePosition();
      if(var2 == 0 && var3 == var4 + 1) {
         if(var4 != this.lastBottom) {
            this.lastBottom = var4;
            this.invoke(new Object[]{var1, Integer.valueOf(var2)});
         }

      } else {
         this.lastBottom = -1;
      }
   }

   private Object invoke(Object... var1) {
      if(this.method != null) {
         if(this.params != null) {
            var1 = this.params;
         }

         Object var3 = this.handler;
         Object var2 = var3;
         if(var3 == null) {
            var2 = this;
         }

         return AQUtility.invokeHandler(var2, this.method, this.fallback, true, this.sig, var1);
      } else {
         if(this.methodId != 0) {
            switch(this.methodId) {
            case 1:
               AQUtility.store((File)this.params[0], (byte[])((byte[])this.params[1]));
               break;
            case 2:
               AQUtility.cleanCache((File)this.params[0], ((Long)this.params[1]).longValue(), ((Long)this.params[2]).longValue());
            }
         }

         return null;
      }
   }

   private void onScrollStateChanged(ExpandableListView var1, int var2) {
      var1.setTag(1090453508, Integer.valueOf(var2));
      if(var2 == 0) {
         int var3 = var1.getFirstVisiblePosition();
         int var4 = var1.getLastVisiblePosition();
         ExpandableListAdapter var10 = var1.getExpandableListAdapter();

         for(var2 = 0; var2 <= var4 - var3; ++var2) {
            long var7 = var1.getExpandableListPosition(var2 + var3);
            int var5 = ExpandableListView.getPackedPositionGroup(var7);
            int var6 = ExpandableListView.getPackedPositionChild(var7);
            if(var5 >= 0) {
               View var11 = var1.getChildAt(var2);
               Long var12 = (Long)var11.getTag(1090453508);
               if(var12 != null && var12.longValue() == var7) {
                  if(var6 == -1) {
                     var10.getGroupView(var5, var1.isGroupExpanded(var5), var11, var1);
                  } else {
                     boolean var9;
                     if(var6 == var10.getChildrenCount(var5) - 1) {
                        var9 = true;
                     } else {
                        var9 = false;
                     }

                     var10.getChildView(var5, var6, var9, var11, var1);
                  }

                  var11.setTag(1090453508, (Object)null);
               }
            }
         }
      }

   }

   private void onScrollStateChanged2(AbsListView var1, int var2) {
      var1.setTag(1090453508, Integer.valueOf(var2));
      if(var2 == 0) {
         int var3 = var1.getFirstVisiblePosition();
         int var4 = var1.getLastVisiblePosition();
         ListAdapter var7 = (ListAdapter)var1.getAdapter();

         for(var2 = 0; var2 <= var4 - var3; ++var2) {
            long var5 = (long)(var2 + var3);
            View var8 = var1.getChildAt(var2);
            if((Number)var8.getTag(1090453508) != null) {
               var7.getView((int)var5, var8, var1);
               var8.setTag(1090453508, (Object)null);
            }
         }
      }

   }

   public static boolean shouldDelay(int var0, int var1, View var2, ViewGroup var3, String var4) {
      if(var4 != null && !BitmapAjaxCallback.isMemoryCached(var4)) {
         AbsListView var8 = (AbsListView)var3;
         if((OnScrollListener)var3.getTag(1090453506) == null) {
            Common var7 = new Common();
            var8.setOnScrollListener(var7);
            var3.setTag(1090453506, var7);
         }

         Integer var9 = (Integer)var8.getTag(1090453508);
         if(var9 != null && var9.intValue() != 0 && var9.intValue() != 1) {
            long var5 = (long)var1;
            if(var3 instanceof ExpandableListView) {
               var5 = ExpandableListView.getPackedPositionForChild(var0, var1);
            }

            var2.setTag(1090453508, Long.valueOf(var5));
            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public static boolean shouldDelay(int var0, View var1, ViewGroup var2, String var3) {
      return var2 instanceof Gallery?shouldDelayGallery(var0, var1, var2, var3):shouldDelay(-2, var0, var1, var2, var3);
   }

   public static boolean shouldDelay(View var0, ViewGroup var1, String var2, float var3, boolean var4) {
      return shouldDelay(-1, var0, var1, var2);
   }

   private static boolean shouldDelayGallery(int var0, View var1, ViewGroup var2, String var3) {
      if(var3 != null && !BitmapAjaxCallback.isMemoryCached(var3)) {
         Gallery var8 = (Gallery)var2;
         Integer var10 = (Integer)var8.getTag(1090453508);
         Integer var9 = var10;
         if(var10 == null) {
            var9 = Integer.valueOf(0);
            var8.setTag(1090453508, Integer.valueOf(0));
            var8.setCallbackDuringFling(false);
            (new Common()).listen(var8);
         }

         int var4 = var8.getFirstVisiblePosition();
         var4 = (var8.getLastVisiblePosition() - var4) / 2 + 1;
         int var6 = var9.intValue() - var4;
         int var7 = var9.intValue() + var4;
         int var5 = var6;
         var4 = var7;
         if(var6 < 0) {
            var4 = var7 - var6;
            var5 = 0;
         }

         if(var0 >= var5 && var0 <= var4) {
            var1.setTag(1090453508, Integer.valueOf(var0));
            return false;
         } else {
            var1.setTag(1090453508, (Object)null);
            return true;
         }
      } else {
         return false;
      }
   }

   public static void showProgress(Object var0, String var1, boolean var2) {
      if(var0 != null) {
         if(var0 instanceof View) {
            View var4 = (View)var0;
            ProgressBar var3 = null;
            if(var0 instanceof ProgressBar) {
               var3 = (ProgressBar)var0;
            }

            if(var2) {
               var4.setTag(1090453505, var1);
               var4.setVisibility(0);
               if(var3 != null) {
                  var3.setProgress(0);
                  var3.setMax(100);
               }
            } else {
               var0 = var4.getTag(1090453505);
               if(var0 == null || var0.equals(var1)) {
                  var4.setTag(1090453505, (Object)null);
                  if(var3 == null || var3.isIndeterminate()) {
                     var4.setVisibility(8);
                     return;
                  }
               }
            }
         } else {
            if(var0 instanceof Dialog) {
               Dialog var6 = (Dialog)var0;
               AQuery var7 = new AQuery(var6.getContext());
               if(var2) {
                  var7.show(var6);
                  return;
               }

               var7.dismiss(var6);
               return;
            }

            if(var0 instanceof Activity) {
               Activity var5 = (Activity)var0;
               var5.setProgressBarIndeterminateVisibility(var2);
               var5.setProgressBarVisibility(var2);
               if(var2) {
                  var5.setProgress(0);
                  return;
               }
            }
         }
      }

   }

   public void afterTextChanged(Editable var1) {
   }

   public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
   }

   public int compare(File var1, File var2) {
      long var3 = var1.lastModified();
      long var5 = var2.lastModified();
      return var5 > var3?1:(var5 == var3?0:-1);
   }

   public Common forward(Object var1, String var2, boolean var3, Class[] var4) {
      this.handler = var1;
      this.method = var2;
      this.fallback = var3;
      this.sig = var4;
      return this;
   }

   public void forward(OnScrollListener var1) {
      this.osl = var1;
   }

   public int getScrollState() {
      return this.scrollState;
   }

   public void listen(Gallery var1) {
      this.galleryListener = var1.getOnItemSelectedListener();
      this.galleryListen = true;
      var1.setOnItemSelectedListener(this);
   }

   public Common method(int var1, Object... var2) {
      this.methodId = var1;
      this.params = var2;
      return this;
   }

   public void onClick(View var1) {
      this.invoke(new Object[]{var1});
   }

   public void onItemClick(AdapterView var1, View var2, int var3, long var4) {
      this.invoke(new Object[]{var1, var2, Integer.valueOf(var3), Long.valueOf(var4)});
   }

   public boolean onItemLongClick(AdapterView var1, View var2, int var3, long var4) {
      return ((Boolean)this.invoke(new Object[]{var1, var2, Integer.valueOf(var3), Long.valueOf(var4)})).booleanValue();
   }

   public void onItemSelected(AdapterView var1, View var2, int var3, long var4) {
      this.invoke(new Object[]{var1, var2, Integer.valueOf(var3), Long.valueOf(var4)});
      if(this.galleryListener != null) {
         this.galleryListener.onItemSelected(var1, var2, var3, var4);
      }

      if(this.galleryListen && ((Integer)var1.getTag(1090453508)).intValue() != var3) {
         Adapter var11 = var1.getAdapter();
         var1.setTag(1090453508, Integer.valueOf(var3));
         int var6 = var1.getChildCount();
         int var7 = var1.getFirstVisiblePosition();

         for(var3 = 0; var3 < var6; ++var3) {
            View var9 = var1.getChildAt(var3);
            int var8 = var7 + var3;
            Integer var10 = (Integer)var9.getTag(1090453508);
            if(var10 == null || var10.intValue() != var8) {
               var11.getView(var8, var9, var1);
            }
         }
      }

   }

   public boolean onLongClick(View var1) {
      boolean var2 = false;
      Object var3 = this.invoke(new Object[]{var1});
      if(var3 instanceof Boolean) {
         var2 = ((Boolean)var3).booleanValue();
      }

      return var2;
   }

   public void onNothingSelected(AdapterView var1) {
      if(this.galleryListener != null) {
         this.galleryListener.onNothingSelected(var1);
      }

   }

   public void onScroll(AbsListView var1, int var2, int var3, int var4) {
      this.checkScrolledBottom(var1, this.scrollState);
      if(this.osl != null) {
         this.osl.onScroll(var1, var2, var3, var4);
      }

   }

   public void onScrollStateChanged(AbsListView var1, int var2) {
      this.scrollState = var2;
      this.checkScrolledBottom(var1, var2);
      if(var1 instanceof ExpandableListView) {
         this.onScrollStateChanged((ExpandableListView)var1, var2);
      } else {
         this.onScrollStateChanged2(var1, var2);
      }

      if(this.osl != null) {
         this.osl.onScrollStateChanged(var1, var2);
      }

   }

   public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
      this.invoke(new Object[]{var1, Integer.valueOf(var2), Integer.valueOf(var3), Integer.valueOf(var4)});
   }

   public void run() {
      this.invoke(new Object[0]);
   }
}
