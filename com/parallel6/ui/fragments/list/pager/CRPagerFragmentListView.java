package com.parallel6.ui.fragments.list.pager;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.List;

public class CRPagerFragmentListView extends RelativeLayout {
   private List placeList;

   public CRPagerFragmentListView(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public CRPagerFragmentListView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public CRPagerFragmentListView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.placeList = new ArrayList();
   }

   public void initView(List var1) {
   }
}
