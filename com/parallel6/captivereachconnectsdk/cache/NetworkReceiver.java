package com.parallel6.captivereachconnectsdk.cache;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.parallel6.captivereachconnectsdk.CaptiveReachConnect;
import com.parallel6.captivereachconnectsdk.utils.ConnectionUtils;

public class NetworkReceiver extends BroadcastReceiver {
   public void onReceive(Context var1, Intent var2) {
      if(ConnectionUtils.getNewNetworkState(var1) == ConnectionUtils.NetworkState.OFFLINE) {
         CaptiveReachConnect.getInstance().stopCache(var1);
      } else {
         CaptiveReachConnect.getInstance().startCache(var1);
      }
   }
}
