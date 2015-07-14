package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.games.internal.notification.GameNotification;
import com.google.android.gms.games.internal.notification.GameNotificationRef;

public final class GameNotificationBuffer extends DataBuffer {
   public GameNotification eh(int var1) {
      return new GameNotificationRef(this.JG, var1);
   }

   // $FF: synthetic method
   public Object get(int var1) {
      return this.eh(var1);
   }
}
