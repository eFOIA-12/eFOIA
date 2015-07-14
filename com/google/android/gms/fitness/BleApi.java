package com.google.android.gms.fitness;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;

public interface BleApi {
   PendingResult claimBleDevice(GoogleApiClient var1, BleDevice var2);

   PendingResult claimBleDevice(GoogleApiClient var1, String var2);

   PendingResult listClaimedBleDevices(GoogleApiClient var1);

   PendingResult startBleScan(GoogleApiClient var1, StartBleScanRequest var2);

   PendingResult stopBleScan(GoogleApiClient var1, BleScanCallback var2);

   PendingResult unclaimBleDevice(GoogleApiClient var1, BleDevice var2);

   PendingResult unclaimBleDevice(GoogleApiClient var1, String var2);
}
