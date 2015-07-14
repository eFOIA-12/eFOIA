package com.google.android.gms.appindexing;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import java.util.List;

public interface AppIndexApi {
   AppIndexApi.ActionResult action(GoogleApiClient var1, Action var2);

   @Deprecated
   PendingResult view(GoogleApiClient var1, Activity var2, Intent var3, String var4, Uri var5, List var6);

   PendingResult view(GoogleApiClient var1, Activity var2, Uri var3, String var4, Uri var5, List var6);

   @Deprecated
   PendingResult viewEnd(GoogleApiClient var1, Activity var2, Intent var3);

   PendingResult viewEnd(GoogleApiClient var1, Activity var2, Uri var3);

   public interface ActionResult {
      PendingResult end(GoogleApiClient var1);

      PendingResult getPendingResult();
   }

   public static final class AppIndexingLink {
      public final Uri appIndexingUrl;
      public final int viewId;
      public final Uri webUrl;

      public AppIndexingLink(Uri var1, Uri var2, View var3) {
         this.appIndexingUrl = var1;
         this.webUrl = var2;
         this.viewId = var3.getId();
      }

      public AppIndexingLink(Uri var1, View var2) {
         this(var1, (Uri)null, var2);
      }
   }
}
