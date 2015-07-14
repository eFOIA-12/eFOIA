package io.fabric.sdk.android.services.events;

import java.io.IOException;

public interface EventTransform {
   byte[] toBytes(Object var1) throws IOException;
}
