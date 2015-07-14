package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.PutDataRequest;
import java.io.InputStream;

public interface DataApi {
   PendingResult addListener(GoogleApiClient var1, DataApi.DataListener var2);

   PendingResult deleteDataItems(GoogleApiClient var1, Uri var2);

   PendingResult getDataItem(GoogleApiClient var1, Uri var2);

   PendingResult getDataItems(GoogleApiClient var1);

   PendingResult getDataItems(GoogleApiClient var1, Uri var2);

   PendingResult getFdForAsset(GoogleApiClient var1, Asset var2);

   PendingResult getFdForAsset(GoogleApiClient var1, DataItemAsset var2);

   PendingResult putDataItem(GoogleApiClient var1, PutDataRequest var2);

   PendingResult removeListener(GoogleApiClient var1, DataApi.DataListener var2);

   public interface DataItemResult extends Result {
      DataItem getDataItem();
   }

   public interface DataListener {
      void onDataChanged(DataEventBuffer var1);
   }

   public interface DeleteDataItemsResult extends Result {
      int getNumDeleted();
   }

   public interface GetFdForAssetResult extends Releasable, Result {
      ParcelFileDescriptor getFd();

      InputStream getInputStream();
   }
}
