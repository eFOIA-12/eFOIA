package io.fabric.sdk.android.services.network;

import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.PinningInfoProvider;
import java.util.Map;

public interface HttpRequestFactory {
   HttpRequest buildHttpRequest(HttpMethod var1, String var2);

   HttpRequest buildHttpRequest(HttpMethod var1, String var2, Map var3);

   PinningInfoProvider getPinningInfoProvider();

   void setPinningInfoProvider(PinningInfoProvider var1);
}
