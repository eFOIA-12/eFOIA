package com.google.android.gms.games.internal.constants;

import com.google.android.gms.games.internal.GamesLog;

public final class RequestType {
   public static String dZ(int var0) {
      switch(var0) {
      case 1:
         return "GIFT";
      case 2:
         return "WISH";
      default:
         GamesLog.p("RequestType", "Unknown request type: " + var0);
         return "UNKNOWN_TYPE";
      }
   }
}
