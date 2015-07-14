package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.internal.o;

public class DataItemBuffer extends g implements Result {
   private final Status Eb;

   public DataItemBuffer(DataHolder var1) {
      super(var1);
      this.Eb = new Status(var1.getStatusCode());
   }

   // $FF: synthetic method
   protected Object f(int var1, int var2) {
      return this.r(var1, var2);
   }

   public Status getStatus() {
      return this.Eb;
   }

   protected String ha() {
      return "path";
   }

   protected DataItem r(int var1, int var2) {
      return new o(this.JG, var1, var2);
   }
}
