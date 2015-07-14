package org.apache.http.protocol;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
public class HttpDateGenerator {
   public static final TimeZone GMT = TimeZone.getTimeZone("GMT");
   public static final String PATTERN_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";
   @GuardedBy("this")
   private long dateAsLong = 0L;
   @GuardedBy("this")
   private String dateAsText = null;
   @GuardedBy("this")
   private final DateFormat dateformat;

   public HttpDateGenerator() {
      this.dateformat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
      this.dateformat.setTimeZone(GMT);
   }

   public String getCurrentDate() {
      synchronized(this){}

      String var3;
      try {
         long var1 = System.currentTimeMillis();
         if(var1 - this.dateAsLong > 1000L) {
            this.dateAsText = this.dateformat.format(new Date(var1));
            this.dateAsLong = var1;
         }

         var3 = this.dateAsText;
      } finally {
         ;
      }

      return var3;
   }
}
