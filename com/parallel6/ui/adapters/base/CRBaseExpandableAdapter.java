package com.parallel6.ui.adapters.base;

import android.content.Context;
import android.widget.BaseExpandableListAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class CRBaseExpandableAdapter extends BaseExpandableListAdapter {
   protected HashMap mChildObjectList;
   protected Context mContext;
   protected List mGroupObjectList;

   public CRBaseExpandableAdapter(Context var1, List var2) {
      this.mContext = var1;
      this.mGroupObjectList = var2;
      this.mChildObjectList = new HashMap();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         this.mChildObjectList.put(var4, new ArrayList());
      }

   }

   public CRBaseExpandableAdapter(Context var1, List var2, HashMap var3) {
      this.mContext = var1;
      this.mGroupObjectList = var2;
      this.mChildObjectList = var3;
   }

   public Object getChild(int var1, int var2) {
      return ((List)this.mChildObjectList.get(this.mGroupObjectList.get(var1))).get(var2);
   }

   public long getChildId(int var1, int var2) {
      return (long)var2;
   }

   public int getChildrenCount(int var1) {
      return ((List)this.mChildObjectList.get(this.mGroupObjectList.get(var1))).size();
   }

   public Object getGroup(int var1) {
      return this.mGroupObjectList.get(var1);
   }

   public int getGroupCount() {
      return this.mGroupObjectList.size();
   }

   public long getGroupId(int var1) {
      return (long)var1;
   }

   public boolean hasStableIds() {
      return false;
   }

   protected abstract void initializeFields(Object var1);

   public boolean isChildSelectable(int var1, int var2) {
      return true;
   }
}
