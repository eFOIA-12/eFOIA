package com.parallel6.ui.adapters.base;

import android.content.Context;
import android.widget.BaseAdapter;
import java.util.List;

public abstract class CRBaseAdapter extends BaseAdapter {
   protected Context mContext;
   protected List mObjectList;

   public CRBaseAdapter() {
   }

   public CRBaseAdapter(Context var1, List var2) {
      this.mContext = var1;
      this.mObjectList = var2;
   }

   public void addDynamicObject(Object var1) {
      this.mObjectList.add(var1);
   }

   public int getCount() {
      return this.mObjectList.size();
   }

   public List getDynamicObjectList() {
      return this.mObjectList;
   }

   public Object getItem(int var1) {
      return this.mObjectList.get(var1);
   }

   public long getItemId(int var1) {
      return 0L;
   }

   public void setDynamicObjectList(List var1) {
      this.mObjectList = var1;
   }
}
