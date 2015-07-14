package com.crashlytics.android.answers;

import android.app.Activity;
import com.crashlytics.android.answers.SessionEventMetadata;
import java.util.Collections;
import java.util.Map;

final class SessionEvent {
   static final String ACTIVITY_KEY = "activity";
   static final String SESSION_ID_KEY = "sessionId";
   public final Map customAttributes;
   public final String customType;
   public final Map details;
   public final SessionEventMetadata sessionEventMetadata;
   private String stringRepresentation;
   public final long timestamp;
   public final SessionEvent.Type type;

   private SessionEvent(SessionEventMetadata var1, long var2, SessionEvent.Type var4, Map var5, String var6, Map var7) {
      this.sessionEventMetadata = var1;
      this.timestamp = var2;
      this.type = var4;
      this.details = var5;
      this.customType = var6;
      this.customAttributes = var7;
   }

   public static SessionEvent buildActivityLifecycleEvent(SessionEventMetadata var0, SessionEvent.Type var1, Activity var2) {
      return buildEvent(var0, var1, Collections.singletonMap("activity", var2.getClass().getName()));
   }

   public static SessionEvent buildCrashEvent(SessionEventMetadata var0, String var1) {
      Map var2 = Collections.singletonMap("sessionId", var1);
      return buildEvent(var0, SessionEvent.Type.CRASH, var2);
   }

   public static SessionEvent buildCustomEvent(SessionEventMetadata var0, String var1, Map var2) {
      return buildEvent(var0, SessionEvent.Type.CUSTOM, Collections.emptyMap(), var1, var2);
   }

   public static SessionEvent buildErrorEvent(SessionEventMetadata var0, String var1) {
      Map var2 = Collections.singletonMap("sessionId", var1);
      return buildEvent(var0, SessionEvent.Type.ERROR, var2);
   }

   private static SessionEvent buildEvent(SessionEventMetadata var0, SessionEvent.Type var1, Map var2) {
      return buildEvent(var0, var1, var2, (String)null, Collections.emptyMap());
   }

   private static SessionEvent buildEvent(SessionEventMetadata var0, SessionEvent.Type var1, Map var2, String var3, Map var4) {
      return new SessionEvent(var0, System.currentTimeMillis(), var1, var2, var3, var4);
   }

   public static SessionEvent buildInstallEvent(SessionEventMetadata var0) {
      return buildEvent(var0, SessionEvent.Type.INSTALL, Collections.emptyMap());
   }

   public String toString() {
      if(this.stringRepresentation == null) {
         this.stringRepresentation = "[" + this.getClass().getSimpleName() + ": " + "timestamp=" + this.timestamp + ", type=" + this.type + ", details=" + this.details.toString() + ", customType=" + this.customType + ", customAttributes=" + this.customAttributes.toString() + ", metadata=[" + this.sessionEventMetadata + "]]";
      }

      return this.stringRepresentation;
   }

   static enum Type {
      CRASH,
      CREATE,
      CUSTOM,
      DESTROY,
      ERROR,
      INSTALL,
      PAUSE,
      RESUME,
      SAVE_INSTANCE_STATE,
      START,
      STOP;
   }
}
