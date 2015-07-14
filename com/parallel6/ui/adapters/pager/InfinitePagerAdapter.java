package com.parallel6.ui.adapters.pager;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class InfinitePagerAdapter extends PagerAdapter {
   private static final boolean DEBUG = true;
   private static final String TAG = "InfinitePagerAdapter";
   private PagerAdapter adapter;
   private int realPosition;

   public InfinitePagerAdapter(PagerAdapter var1) {
      this.adapter = var1;
   }

   private void debug(String var1) {
      Log.d("InfinitePagerAdapter", var1);
   }

   public void destroyItem(ViewGroup var1, int var2, Object var3) {
      int var4 = var2 % this.getRealCount();
      this.debug("destroyItem: real position: " + var2);
      this.debug("destroyItem: virtual position: " + var4);
      this.adapter.destroyItem(var1, var4, var3);
   }

   public void finishUpdate(ViewGroup var1) {
      this.adapter.finishUpdate(var1);
   }

   public int getCount() {
      return Integer.MAX_VALUE;
   }

   public int getRealCount() {
      return this.adapter.getCount();
   }

   public int getRealPosition() {
      return this.realPosition;
   }

   public Object instantiateItem(ViewGroup var1, int var2) {
      int var3 = var2 % this.getRealCount();
      this.debug("instantiateItem: real position: " + var2);
      this.debug("instantiateItem: virtual position: " + var3);
      this.realPosition = var3;
      return this.adapter.instantiateItem(var1, var3);
   }

   public boolean isViewFromObject(View var1, Object var2) {
      return this.adapter.isViewFromObject(var1, var2);
   }

   public void restoreState(Parcelable var1, ClassLoader var2) {
      this.adapter.restoreState(var1, var2);
   }

   public Parcelable saveState() {
      return this.adapter.saveState();
   }

   public void startUpdate(ViewGroup var1) {
      this.adapter.startUpdate(var1);
   }
}
