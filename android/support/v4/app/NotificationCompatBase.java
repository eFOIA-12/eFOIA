package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;
import android.support.v4.app.RemoteInputCompatBase;

class NotificationCompatBase {
   public abstract static class Action {
      protected abstract PendingIntent getActionIntent();

      protected abstract Bundle getExtras();

      protected abstract int getIcon();

      protected abstract RemoteInputCompatBase.RemoteInput[] getRemoteInputs();

      protected abstract CharSequence getTitle();
   }

   public interface Factory {
      NotificationCompatBase.Action build(int var1, CharSequence var2, PendingIntent var3, Bundle var4, RemoteInputCompatBase.RemoteInput[] var5);

      NotificationCompatBase.Action[] newArray(int var1);
   }

   public abstract static class UnreadConversation {
      abstract long getLatestTimestamp();

      abstract String[] getMessages();

      abstract String getParticipant();

      abstract String[] getParticipants();

      abstract PendingIntent getReadPendingIntent();

      abstract RemoteInputCompatBase.RemoteInput getRemoteInput();

      abstract PendingIntent getReplyPendingIntent();
   }

   public interface Factory {
      NotificationCompatBase.UnreadConversation build(String[] var1, RemoteInputCompatBase.RemoteInput var2, PendingIntent var3, PendingIntent var4, String[] var5, long var6);
   }
}
