package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.jx;
import com.google.android.gms.panorama.PanoramaApi;

class on implements PanoramaApi.PanoramaResult {
   private final Status Eb;
   private final Intent amR;

   public on(Status var1, Intent var2) {
      this.Eb = (Status)jx.i(var1);
      this.amR = var2;
   }

   public Status getStatus() {
      return this.Eb;
   }

   public Intent getViewerIntent() {
      return this.amR;
   }
}
