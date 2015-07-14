package io.fabric.sdk.android.services.persistence;

public interface SerializationStrategy {
   Object deserialize(String var1);

   String serialize(Object var1);
}
