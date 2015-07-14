package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.internal.g;
import com.google.android.gms.wearable.internal.o;

public final class h extends com.google.android.gms.common.data.d implements DataEvent {
   private final int Ya;

   public h(DataHolder var1, int var2, int var3) {
      super(var1, var2);
      this.Ya = var3;
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.rn();
   }

   public DataItem getDataItem() {
      return new o(this.JG, this.KZ, this.Ya);
   }

   public int getType() {
      return this.getInteger("event_type");
   }

   public DataEvent rn() {
      return new g(this);
   }
}
