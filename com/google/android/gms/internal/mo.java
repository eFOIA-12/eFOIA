package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;
import com.google.android.gms.internal.me;

public class mo implements BleApi {
   private static final Status VB = new Status(5007);

   public PendingResult claimBleDevice(GoogleApiClient var1, BleDevice var2) {
      return new me(VB);
   }

   public PendingResult claimBleDevice(GoogleApiClient var1, String var2) {
      return new me(VB);
   }

   public PendingResult listClaimedBleDevices(GoogleApiClient var1) {
      return new me(BleDevicesResult.C(VB));
   }

   public PendingResult startBleScan(GoogleApiClient var1, StartBleScanRequest var2) {
      return new me(VB);
   }

   public PendingResult stopBleScan(GoogleApiClient var1, BleScanCallback var2) {
      return new me(VB);
   }

   public PendingResult unclaimBleDevice(GoogleApiClient var1, BleDevice var2) {
      return new me(VB);
   }

   public PendingResult unclaimBleDevice(GoogleApiClient var1, String var2) {
      return new me(VB);
   }
}
