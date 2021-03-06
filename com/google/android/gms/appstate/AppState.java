package com.google.android.gms.appstate;

import com.google.android.gms.common.data.Freezable;

@Deprecated
public interface AppState extends Freezable {
   byte[] getConflictData();

   String getConflictVersion();

   int getKey();

   byte[] getLocalData();

   String getLocalVersion();

   boolean hasConflict();
}
