package com.google.android.gms.appstate;

import com.google.android.gms.appstate.AppState;
import com.google.android.gms.appstate.a;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;

public final class b extends d implements AppState {
   b(DataHolder var1, int var2) {
      super(var1, var2);
   }

   public boolean equals(Object var1) {
      return a.a(this, var1);
   }

   public AppState fJ() {
      return new a(this);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.fJ();
   }

   public byte[] getConflictData() {
      return this.getByteArray("conflict_data");
   }

   public String getConflictVersion() {
      return this.getString("conflict_version");
   }

   public int getKey() {
      return this.getInteger("key");
   }

   public byte[] getLocalData() {
      return this.getByteArray("local_data");
   }

   public String getLocalVersion() {
      return this.getString("local_version");
   }

   public boolean hasConflict() {
      return !this.aS("conflict_version");
   }

   public int hashCode() {
      return a.a(this);
   }

   public String toString() {
      return a.b(this);
   }
}
