package com.androidquery.callback;

import com.androidquery.util.AQUtility;
import java.io.Closeable;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;

public class AjaxStatus {
   public static final int AUTH_ERROR = -102;
   public static final int DATASTORE = 2;
   public static final int DEVICE = 5;
   public static final int FILE = 3;
   public static final int MEMORY = 4;
   public static final int NETWORK = 1;
   public static final int NETWORK_ERROR = -101;
   public static final int TRANSFORM_ERROR = -103;
   private DefaultHttpClient client;
   private Closeable close;
   private int code = 200;
   private HttpContext context;
   private byte[] data;
   private boolean done;
   private long duration;
   private String error;
   private File file;
   private Header[] headers;
   private boolean invalid;
   private String message = "OK";
   private boolean reauth;
   private String redirect;
   private boolean refresh;
   private int source = 1;
   private long start = System.currentTimeMillis();
   private Date time = new Date();

   public AjaxStatus() {
   }

   public AjaxStatus(int var1, String var2) {
      this.code = var1;
      this.message = var2;
   }

   protected AjaxStatus client(DefaultHttpClient var1) {
      this.client = var1;
      return this;
   }

   public void close() {
      AQUtility.close(this.close);
      this.close = null;
   }

   protected void closeLater(Closeable var1) {
      this.close = var1;
   }

   public AjaxStatus code(int var1) {
      this.code = var1;
      return this;
   }

   protected AjaxStatus context(HttpContext var1) {
      this.context = var1;
      return this;
   }

   protected AjaxStatus data(byte[] var1) {
      this.data = var1;
      return this;
   }

   public AjaxStatus done() {
      this.duration = System.currentTimeMillis() - this.start;
      this.done = true;
      this.reauth = false;
      return this;
   }

   protected AjaxStatus error(String var1) {
      this.error = var1;
      return this;
   }

   public boolean expired(long var1) {
      long var3 = this.time.getTime();
      return System.currentTimeMillis() - var3 > var1 && this.getSource() != 1;
   }

   protected AjaxStatus file(File var1) {
      this.file = var1;
      return this;
   }

   public DefaultHttpClient getClient() {
      return this.client;
   }

   public int getCode() {
      return this.code;
   }

   public List getCookies() {
      if(this.context == null) {
         return Collections.emptyList();
      } else {
         CookieStore var1 = (CookieStore)this.context.getAttribute("http.cookie-store");
         return var1 == null?Collections.emptyList():var1.getCookies();
      }
   }

   protected byte[] getData() {
      return this.data;
   }

   protected boolean getDone() {
      return this.done;
   }

   public long getDuration() {
      return this.duration;
   }

   public String getError() {
      return this.error;
   }

   protected File getFile() {
      return this.file;
   }

   public String getHeader(String var1) {
      if(this.headers != null) {
         for(int var2 = 0; var2 < this.headers.length; ++var2) {
            if(var1.equalsIgnoreCase(this.headers[var2].getName())) {
               return this.headers[var2].getValue();
            }
         }
      }

      return null;
   }

   public List getHeaders() {
      return this.headers == null?Collections.emptyList():Arrays.asList(this.headers);
   }

   protected boolean getInvalid() {
      return this.invalid;
   }

   public String getMessage() {
      return this.message;
   }

   protected boolean getReauth() {
      return this.reauth;
   }

   public String getRedirect() {
      return this.redirect;
   }

   public boolean getRefresh() {
      return this.refresh;
   }

   public int getSource() {
      return this.source;
   }

   public Date getTime() {
      return this.time;
   }

   protected AjaxStatus headers(Header[] var1) {
      this.headers = var1;
      return this;
   }

   public AjaxStatus invalidate() {
      this.invalid = true;
      return this;
   }

   public AjaxStatus message(String var1) {
      this.message = var1;
      return this;
   }

   protected AjaxStatus reauth(boolean var1) {
      this.reauth = var1;
      return this;
   }

   protected AjaxStatus redirect(String var1) {
      this.redirect = var1;
      return this;
   }

   protected AjaxStatus refresh(boolean var1) {
      this.refresh = var1;
      return this;
   }

   protected AjaxStatus reset() {
      this.duration = System.currentTimeMillis() - this.start;
      this.done = false;
      this.close();
      return this;
   }

   protected AjaxStatus source(int var1) {
      this.source = var1;
      return this;
   }

   protected AjaxStatus time(Date var1) {
      this.time = var1;
      return this;
   }
}
