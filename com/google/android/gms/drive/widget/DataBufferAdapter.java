package com.google.android.gms.drive.widget;

import android.content.Context;
import android.database.CursorIndexOutOfBoundsException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.drive.internal.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DataBufferAdapter extends BaseAdapter {
   private final int To;
   private int Tp;
   private final int Tq;
   private final List Tr;
   private final LayoutInflater Ts;
   private boolean Tt;
   private final Context mContext;

   public DataBufferAdapter(Context var1, int var2) {
      this(var1, var2, 0, (List)(new ArrayList()));
   }

   public DataBufferAdapter(Context var1, int var2, int var3) {
      this(var1, var2, var3, (List)(new ArrayList()));
   }

   public DataBufferAdapter(Context var1, int var2, int var3, List var4) {
      this.Tt = true;
      this.mContext = var1;
      this.Tp = var2;
      this.To = var2;
      this.Tq = var3;
      this.Tr = var4;
      this.Ts = (LayoutInflater)var1.getSystemService("layout_inflater");
   }

   public DataBufferAdapter(Context var1, int var2, int var3, DataBuffer... var4) {
      this(var1, var2, var3, Arrays.asList(var4));
   }

   public DataBufferAdapter(Context var1, int var2, List var3) {
      this(var1, var2, 0, (List)var3);
   }

   public DataBufferAdapter(Context var1, int var2, DataBuffer... var3) {
      this(var1, var2, 0, (List)Arrays.asList(var3));
   }

   private View a(int var1, View var2, ViewGroup var3, int var4) {
      if(var2 == null) {
         var2 = this.Ts.inflate(var4, var3, false);
      }

      TextView var7;
      try {
         if(this.Tq == 0) {
            var7 = (TextView)var2;
         } else {
            var7 = (TextView)var2.findViewById(this.Tq);
         }
      } catch (ClassCastException var6) {
         w.a("DataBufferAdapter", var6, "You must supply a resource ID for a TextView");
         throw new IllegalStateException("DataBufferAdapter requires the resource ID to be a TextView", var6);
      }

      Object var5 = this.getItem(var1);
      if(var5 instanceof CharSequence) {
         var7.setText((CharSequence)var5);
         return var2;
      } else {
         var7.setText(var5.toString());
         return var2;
      }
   }

   public void append(DataBuffer var1) {
      this.Tr.add(var1);
      if(this.Tt) {
         this.notifyDataSetChanged();
      }

   }

   public void clear() {
      Iterator var1 = this.Tr.iterator();

      while(var1.hasNext()) {
         ((DataBuffer)var1.next()).release();
      }

      this.Tr.clear();
      if(this.Tt) {
         this.notifyDataSetChanged();
      }

   }

   public Context getContext() {
      return this.mContext;
   }

   public int getCount() {
      Iterator var2 = this.Tr.iterator();

      int var1;
      for(var1 = 0; var2.hasNext(); var1 += ((DataBuffer)var2.next()).getCount()) {
         ;
      }

      return var1;
   }

   public View getDropDownView(int var1, View var2, ViewGroup var3) {
      return this.a(var1, var2, var3, this.Tp);
   }

   public Object getItem(int var1) throws CursorIndexOutOfBoundsException {
      Iterator var4 = this.Tr.iterator();

      int var3;
      for(int var2 = var1; var4.hasNext(); var2 -= var3) {
         DataBuffer var5 = (DataBuffer)var4.next();
         var3 = var5.getCount();
         if(var3 > var2) {
            try {
               Object var7 = var5.get(var2);
               return var7;
            } catch (CursorIndexOutOfBoundsException var6) {
               throw new CursorIndexOutOfBoundsException(var1, this.getCount());
            }
         }
      }

      throw new CursorIndexOutOfBoundsException(var1, this.getCount());
   }

   public long getItemId(int var1) {
      return (long)var1;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      return this.a(var1, var2, var3, this.To);
   }

   public void notifyDataSetChanged() {
      super.notifyDataSetChanged();
      this.Tt = true;
   }

   public void setDropDownViewResource(int var1) {
      this.Tp = var1;
   }

   public void setNotifyOnChange(boolean var1) {
      this.Tt = var1;
   }
}
