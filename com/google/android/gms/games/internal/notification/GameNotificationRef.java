package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.internal.notification.GameNotification;
import com.google.android.gms.internal.jv;

public final class GameNotificationRef extends d implements GameNotification {
   GameNotificationRef(DataHolder var1, int var2) {
      super(var1, var2);
   }

   public long getId() {
      return this.getLong("_id");
   }

   public String getText() {
      return this.getString("text");
   }

   public String getTitle() {
      return this.getString("title");
   }

   public int getType() {
      return this.getInteger("type");
   }

   public String mr() {
      return this.getString("notification_id");
   }

   public String ms() {
      return this.getString("ticker");
   }

   public String mt() {
      return this.getString("coalesced_text");
   }

   public boolean mu() {
      return this.getInteger("acknowledged") > 0;
   }

   public boolean mv() {
      return this.getInteger("alert_level") == 0;
   }

   public String toString() {
      return jv.h(this).a("Id", Long.valueOf(this.getId())).a("NotificationId", this.mr()).a("Type", Integer.valueOf(this.getType())).a("Title", this.getTitle()).a("Ticker", this.ms()).a("Text", this.getText()).a("CoalescedText", this.mt()).a("isAcknowledged", Boolean.valueOf(this.mu())).a("isSilent", Boolean.valueOf(this.mv())).toString();
   }
}
