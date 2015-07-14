package io.fabric.sdk.android.services.persistence;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import io.fabric.sdk.android.services.persistence.PersistenceStrategy;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.persistence.SerializationStrategy;

public class PreferenceStoreStrategy implements PersistenceStrategy {
   private final String key;
   private final SerializationStrategy serializer;
   private final PreferenceStore store;

   public PreferenceStoreStrategy(PreferenceStore var1, SerializationStrategy var2, String var3) {
      this.store = var1;
      this.serializer = var2;
      this.key = var3;
   }

   public void clear() {
      this.store.edit().remove(this.key).commit();
   }

   public Object restore() {
      SharedPreferences var1 = this.store.get();
      return this.serializer.deserialize(var1.getString(this.key, (String)null));
   }

   @SuppressLint({"CommitPrefEdits"})
   public void save(Object var1) {
      this.store.save(this.store.edit().putString(this.key, this.serializer.serialize(var1)));
   }
}
