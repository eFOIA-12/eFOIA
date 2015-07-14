package io.fabric.sdk.android.services.persistence;

public interface PersistenceStrategy {
   void clear();

   Object restore();

   void save(Object var1);
}
