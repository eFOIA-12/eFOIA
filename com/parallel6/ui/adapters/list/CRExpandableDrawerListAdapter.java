package com.parallel6.ui.adapters.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.androidquery.AQuery;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.captivereachconnectsdk.models.MobileMenu;
import java.util.HashMap;
import java.util.List;

public class CRExpandableDrawerListAdapter extends BaseExpandableListAdapter {
   private HashMap childsList;
   protected Context context;
   private List parentsList;

   public CRExpandableDrawerListAdapter(Context var1, List var2, HashMap var3) {
      this.context = var1;
      this.parentsList = var2;
      this.childsList = var3;
   }

   public MobileMenu getChild(int var1, int var2) {
      return (MobileMenu)((List)this.childsList.get(this.parentsList.get(var1))).get(var2);
   }

   public long getChildId(int var1, int var2) {
      return (long)var2;
   }

   public View getChildView(int var1, int var2, boolean var3, View var4, ViewGroup var5) {
      var4 = ((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(R.layout.row_navigationdrawer_child, (ViewGroup)null);
      MobileMenu var6 = this.getChild(var1, var2);
      if(var6 != null && var4 != null) {
         ((TextView)var4.findViewById(R.id.navigation_drawer_child_title)).setText(var6.getTitle());
         var4.setTag(var6);
      }

      return var4;
   }

   public int getChildrenCount(int var1) {
      return ((List)this.childsList.get(this.parentsList.get(var1))).size();
   }

   public MobileMenu getGroup(int var1) {
      return (MobileMenu)this.parentsList.get(var1);
   }

   public int getGroupCount() {
      return this.parentsList.size();
   }

   public long getGroupId(int var1) {
      return (long)var1;
   }

   public View getGroupView(int var1, boolean var2, View var3, ViewGroup var4) {
      var3 = ((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(R.layout.row_navigationdrawer, (ViewGroup)null);
      MobileMenu var6 = (MobileMenu)this.parentsList.get(var1);
      if(var6 != null && var3 != null) {
         ImageView var5 = (ImageView)var3.findViewById(R.id.navigation_drawer_icon);
         ((TextView)var3.findViewById(R.id.navigation_drawer_title)).setText(var6.getTitle());
         ((AQuery)(new AQuery(this.context)).id(var5)).image(var6.getImage().getCRImage().getSmall().getUrl(), true, true);
      }

      return var3;
   }

   public boolean hasStableIds() {
      return false;
   }

   public boolean isChildSelectable(int var1, int var2) {
      return true;
   }
}
