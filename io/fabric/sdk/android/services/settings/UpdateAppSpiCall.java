package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.settings.AbstractAppSpiCall;

public class UpdateAppSpiCall extends AbstractAppSpiCall {
   public UpdateAppSpiCall(Kit var1, String var2, String var3, HttpRequestFactory var4) {
      super(var1, var2, var3, var4, HttpMethod.PUT);
   }
}
