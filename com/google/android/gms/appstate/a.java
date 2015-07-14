package com.google.android.gms.appstate;

import com.google.android.gms.appstate.AppState;
import com.google.android.gms.internal.jv;

public final class a implements AppState {
   private final int DK;
   private final String DL;
   private final byte[] DM;
   private final boolean DN;
   private final String DO;
   private final byte[] DP;

   public a(AppState var1) {
      this.DK = var1.getKey();
      this.DL = var1.getLocalVersion();
      this.DM = var1.getLocalData();
      this.DN = var1.hasConflict();
      this.DO = var1.getConflictVersion();
      this.DP = var1.getConflictData();
   }

   static int a(AppState var0) {
      return jv.hashCode(new Object[]{Integer.valueOf(var0.getKey()), var0.getLocalVersion(), var0.getLocalData(), Boolean.valueOf(var0.hasConflict()), var0.getConflictVersion(), var0.getConflictData()});
   }

   static boolean a(AppState var0, Object var1) {
      boolean var3 = true;
      boolean var2;
      if(!(var1 instanceof AppState)) {
         var2 = false;
      } else {
         var2 = var3;
         if(var0 != var1) {
            AppState var4 = (AppState)var1;
            if(jv.equal(Integer.valueOf(var4.getKey()), Integer.valueOf(var0.getKey())) && jv.equal(var4.getLocalVersion(), var0.getLocalVersion()) && jv.equal(var4.getLocalData(), var0.getLocalData()) && jv.equal(Boolean.valueOf(var4.hasConflict()), Boolean.valueOf(var0.hasConflict())) && jv.equal(var4.getConflictVersion(), var0.getConflictVersion())) {
               var2 = var3;
               if(jv.equal(var4.getConflictData(), var0.getConflictData())) {
                  return var2;
               }
            }

            return false;
         }
      }

      return var2;
   }

   static String b(AppState var0) {
      return jv.h(var0).a("Key", Integer.valueOf(var0.getKey())).a("LocalVersion", var0.getLocalVersion()).a("LocalData", var0.getLocalData()).a("HasConflict", Boolean.valueOf(var0.hasConflict())).a("ConflictVersion", var0.getConflictVersion()).a("ConflictData", var0.getConflictData()).toString();
   }

   public boolean equals(Object var1) {
      return a(this, var1);
   }

   public AppState fJ() {
      return this;
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.fJ();
   }

   public byte[] getConflictData() {
      return this.DP;
   }

   public String getConflictVersion() {
      return this.DO;
   }

   public int getKey() {
      return this.DK;
   }

   public byte[] getLocalData() {
      return this.DM;
   }

   public String getLocalVersion() {
      return this.DL;
   }

   public boolean hasConflict() {
      return this.DN;
   }

   public int hashCode() {
      return a(this);
   }

   public boolean isDataValid() {
      return true;
   }

   public String toString() {
      return b(this);
   }
}
