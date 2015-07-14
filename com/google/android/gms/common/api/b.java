package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public abstract class b implements Releasable, Result {
   protected final Status Eb;
   protected final DataHolder JG;

   protected b(DataHolder var1) {
      this.Eb = new Status(var1.getStatusCode());
      this.JG = var1;
   }

   public Status getStatus() {
      return this.Eb;
   }

   public void release() {
      if(this.JG != null) {
         this.JG.close();
      }

   }
}
