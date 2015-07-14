package com.google.android.gms.fitness;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.internal.jx;
import java.util.concurrent.TimeUnit;

public interface HistoryApi {
   PendingResult deleteData(GoogleApiClient var1, DataDeleteRequest var2);

   PendingResult insertData(GoogleApiClient var1, DataSet var2);

   PendingResult readData(GoogleApiClient var1, DataReadRequest var2);

   public static class ViewIntentBuilder {
      private long LW;
      private final DataType TM;
      private DataSource TN;
      private long TO;
      private String TP;
      private final Context mContext;

      public ViewIntentBuilder(Context var1, DataType var2) {
         this.mContext = var1;
         this.TM = var2;
      }

      private Intent i(Intent var1) {
         if(this.TP != null) {
            Intent var2 = (new Intent(var1)).setPackage(this.TP);
            ResolveInfo var3 = this.mContext.getPackageManager().resolveActivity(var2, 0);
            if(var3 != null) {
               String var4 = var3.activityInfo.name;
               var2.setComponent(new ComponentName(this.TP, var4));
               return var2;
            }
         }

         return var1;
      }

      public Intent build() {
         boolean var2 = true;
         boolean var1;
         if(this.LW > 0L) {
            var1 = true;
         } else {
            var1 = false;
         }

         jx.a(var1, "Start time must be set");
         if(this.TO > this.LW) {
            var1 = var2;
         } else {
            var1 = false;
         }

         jx.a(var1, "End time must be set and after start time");
         Intent var3 = new Intent("vnd.google.fitness.VIEW");
         var3.setType(DataType.getMimeType(this.TN.getDataType()));
         var3.putExtra("vnd.google.fitness.start_time", this.LW);
         var3.putExtra("vnd.google.fitness.end_time", this.TO);
         c.a((SafeParcelable)this.TN, (Intent)var3, (String)"vnd.google.fitness.data_source");
         return this.i(var3);
      }

      public HistoryApi.ViewIntentBuilder setDataSource(DataSource var1) {
         jx.b(var1.getDataType().equals(this.TM), "Data source %s is not for the data type %s", new Object[]{var1, this.TM});
         this.TN = var1;
         return this;
      }

      public HistoryApi.ViewIntentBuilder setPreferredApplication(String var1) {
         this.TP = var1;
         return this;
      }

      public HistoryApi.ViewIntentBuilder setTimeInterval(long var1, long var3, TimeUnit var5) {
         this.LW = var5.toMillis(var1);
         this.TO = var5.toMillis(var3);
         return this;
      }
   }
}
