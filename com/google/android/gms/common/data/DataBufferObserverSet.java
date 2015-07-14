package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBufferObserver;
import java.util.HashSet;
import java.util.Iterator;

public final class DataBufferObserverSet implements DataBufferObserver, DataBufferObserver.Observable {
   private HashSet KY = new HashSet();

   public void addObserver(DataBufferObserver var1) {
      this.KY.add(var1);
   }

   public void clear() {
      this.KY.clear();
   }

   public boolean hasObservers() {
      return !this.KY.isEmpty();
   }

   public void onDataChanged() {
      Iterator var1 = this.KY.iterator();

      while(var1.hasNext()) {
         ((DataBufferObserver)var1.next()).onDataChanged();
      }

   }

   public void onDataRangeChanged(int var1, int var2) {
      Iterator var3 = this.KY.iterator();

      while(var3.hasNext()) {
         ((DataBufferObserver)var3.next()).onDataRangeChanged(var1, var2);
      }

   }

   public void onDataRangeInserted(int var1, int var2) {
      Iterator var3 = this.KY.iterator();

      while(var3.hasNext()) {
         ((DataBufferObserver)var3.next()).onDataRangeInserted(var1, var2);
      }

   }

   public void onDataRangeMoved(int var1, int var2, int var3) {
      Iterator var4 = this.KY.iterator();

      while(var4.hasNext()) {
         ((DataBufferObserver)var4.next()).onDataRangeMoved(var1, var2, var3);
      }

   }

   public void onDataRangeRemoved(int var1, int var2) {
      Iterator var3 = this.KY.iterator();

      while(var3.hasNext()) {
         ((DataBufferObserver)var3.next()).onDataRangeRemoved(var1, var2);
      }

   }

   public void removeObserver(DataBufferObserver var1) {
      this.KY.remove(var1);
   }
}
