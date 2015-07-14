package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

public class g implements DataEvent {
   private int Gt;
   private DataItem axE;

   public g(DataEvent var1) {
      this.Gt = var1.getType();
      this.axE = (DataItem)var1.getDataItem().freeze();
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.rn();
   }

   public DataItem getDataItem() {
      return this.axE;
   }

   public int getType() {
      return this.Gt;
   }

   public boolean isDataValid() {
      return true;
   }

   public DataEvent rn() {
      return this;
   }
}
