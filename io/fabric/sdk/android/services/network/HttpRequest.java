package io.fabric.sdk.android.services.network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.Proxy.Type;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.security.AccessController;
import java.security.GeneralSecurityException;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class HttpRequest {
   private static final String BOUNDARY = "00content0boundary00";
   public static final String CHARSET_UTF8 = "UTF-8";
   private static HttpRequest.ConnectionFactory CONNECTION_FACTORY;
   public static final String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded";
   public static final String CONTENT_TYPE_JSON = "application/json";
   private static final String CONTENT_TYPE_MULTIPART = "multipart/form-data; boundary=00content0boundary00";
   private static final String CRLF = "\r\n";
   private static final String[] EMPTY_STRINGS = new String[0];
   public static final String ENCODING_GZIP = "gzip";
   public static final String HEADER_ACCEPT = "Accept";
   public static final String HEADER_ACCEPT_CHARSET = "Accept-Charset";
   public static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
   public static final String HEADER_AUTHORIZATION = "Authorization";
   public static final String HEADER_CACHE_CONTROL = "Cache-Control";
   public static final String HEADER_CONTENT_ENCODING = "Content-Encoding";
   public static final String HEADER_CONTENT_LENGTH = "Content-Length";
   public static final String HEADER_CONTENT_TYPE = "Content-Type";
   public static final String HEADER_DATE = "Date";
   public static final String HEADER_ETAG = "ETag";
   public static final String HEADER_EXPIRES = "Expires";
   public static final String HEADER_IF_NONE_MATCH = "If-None-Match";
   public static final String HEADER_LAST_MODIFIED = "Last-Modified";
   public static final String HEADER_LOCATION = "Location";
   public static final String HEADER_PROXY_AUTHORIZATION = "Proxy-Authorization";
   public static final String HEADER_REFERER = "Referer";
   public static final String HEADER_SERVER = "Server";
   public static final String HEADER_USER_AGENT = "User-Agent";
   public static final String METHOD_DELETE = "DELETE";
   public static final String METHOD_GET = "GET";
   public static final String METHOD_HEAD = "HEAD";
   public static final String METHOD_OPTIONS = "OPTIONS";
   public static final String METHOD_POST = "POST";
   public static final String METHOD_PUT = "PUT";
   public static final String METHOD_TRACE = "TRACE";
   public static final String PARAM_CHARSET = "charset";
   private static SSLSocketFactory TRUSTED_FACTORY;
   private static HostnameVerifier TRUSTED_VERIFIER;
   private int bufferSize = 8192;
   private HttpURLConnection connection = null;
   private boolean form;
   private String httpProxyHost;
   private int httpProxyPort;
   private boolean ignoreCloseExceptions = true;
   private boolean multipart;
   private HttpRequest.RequestOutputStream output;
   private final String requestMethod;
   private boolean uncompress = false;
   public final URL url;

   static {
      CONNECTION_FACTORY = HttpRequest.ConnectionFactory.DEFAULT;
   }

   public HttpRequest(CharSequence var1, String var2) throws HttpRequest.HttpRequestException {
      try {
         this.url = new URL(var1.toString());
      } catch (MalformedURLException var3) {
         throw new HttpRequest.HttpRequestException(var3);
      }

      this.requestMethod = var2;
   }

   public HttpRequest(URL var1, String var2) throws HttpRequest.HttpRequestException {
      this.url = var1;
      this.requestMethod = var2;
   }

   private static StringBuilder addParamPrefix(String var0, StringBuilder var1) {
      int var2 = var0.indexOf(63);
      int var3 = var1.length() - 1;
      if(var2 == -1) {
         var1.append('?');
      } else if(var2 < var3 && var0.charAt(var3) != 38) {
         var1.append('&');
         return var1;
      }

      return var1;
   }

   private static StringBuilder addPathSeparator(String var0, StringBuilder var1) {
      if(var0.indexOf(58) + 2 == var0.lastIndexOf(47)) {
         var1.append('/');
      }

      return var1;
   }

   public static String append(CharSequence var0, Map var1) {
      String var2 = var0.toString();
      if(var1 != null && !var1.isEmpty()) {
         StringBuilder var3 = new StringBuilder(var2);
         addPathSeparator(var2, var3);
         addParamPrefix(var2, var3);
         Iterator var4 = var1.entrySet().iterator();
         Entry var5 = (Entry)var4.next();
         var3.append(var5.getKey().toString());
         var3.append('=');
         Object var6 = var5.getValue();
         if(var6 != null) {
            var3.append(var6);
         }

         while(var4.hasNext()) {
            var3.append('&');
            var5 = (Entry)var4.next();
            var3.append(var5.getKey().toString());
            var3.append('=');
            var6 = var5.getValue();
            if(var6 != null) {
               var3.append(var6);
            }
         }

         return var3.toString();
      } else {
         return var2;
      }
   }

   public static String append(CharSequence var0, Object... var1) {
      String var3 = var0.toString();
      if(var1 != null && var1.length != 0) {
         if(var1.length % 2 != 0) {
            throw new IllegalArgumentException("Must specify an even number of parameter names/values");
         } else {
            StringBuilder var4 = new StringBuilder(var3);
            addPathSeparator(var3, var4);
            addParamPrefix(var3, var4);
            var4.append(var1[0]);
            var4.append('=');
            Object var5 = var1[1];
            if(var5 != null) {
               var4.append(var5);
            }

            for(int var2 = 2; var2 < var1.length; var2 += 2) {
               var4.append('&');
               var4.append(var1[var2]);
               var4.append('=');
               var5 = var1[var2 + 1];
               if(var5 != null) {
                  var4.append(var5);
               }
            }

            return var4.toString();
         }
      } else {
         return var3;
      }
   }

   private HttpURLConnection createConnection() {
      // $FF: Couldn't be decompiled
   }

   private Proxy createProxy() {
      return new Proxy(Type.HTTP, new InetSocketAddress(this.httpProxyHost, this.httpProxyPort));
   }

   public static HttpRequest delete(CharSequence var0) throws HttpRequest.HttpRequestException {
      return new HttpRequest(var0, "DELETE");
   }

   public static HttpRequest delete(CharSequence var0, Map var1, boolean var2) {
      String var4 = append(var0, var1);
      String var3 = var4;
      if(var2) {
         var3 = encode(var4);
      }

      return delete((CharSequence)var3);
   }

   public static HttpRequest delete(CharSequence var0, boolean var1, Object... var2) {
      String var4 = append(var0, var2);
      String var3 = var4;
      if(var1) {
         var3 = encode(var4);
      }

      return delete((CharSequence)var3);
   }

   public static HttpRequest delete(URL var0) throws HttpRequest.HttpRequestException {
      return new HttpRequest(var0, "DELETE");
   }

   public static String encode(CharSequence param0) throws HttpRequest.HttpRequestException {
      // $FF: Couldn't be decompiled
   }

   public static HttpRequest get(CharSequence var0) throws HttpRequest.HttpRequestException {
      return new HttpRequest(var0, "GET");
   }

   public static HttpRequest get(CharSequence var0, Map var1, boolean var2) {
      String var4 = append(var0, var1);
      String var3 = var4;
      if(var2) {
         var3 = encode(var4);
      }

      return get((CharSequence)var3);
   }

   public static HttpRequest get(CharSequence var0, boolean var1, Object... var2) {
      String var4 = append(var0, var2);
      String var3 = var4;
      if(var1) {
         var3 = encode(var4);
      }

      return get((CharSequence)var3);
   }

   public static HttpRequest get(URL var0) throws HttpRequest.HttpRequestException {
      return new HttpRequest(var0, "GET");
   }

   private static SSLSocketFactory getTrustedFactory() throws HttpRequest.HttpRequestException {
      if(TRUSTED_FACTORY == null) {
         X509TrustManager var0 = new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] var1, String var2) {
            }

            public void checkServerTrusted(X509Certificate[] var1, String var2) {
            }

            public X509Certificate[] getAcceptedIssuers() {
               return new X509Certificate[0];
            }
         };

         try {
            SSLContext var4 = SSLContext.getInstance("TLS");
            SecureRandom var2 = new SecureRandom();
            var4.init((KeyManager[])null, new TrustManager[]{var0}, var2);
            TRUSTED_FACTORY = var4.getSocketFactory();
         } catch (GeneralSecurityException var3) {
            IOException var1 = new IOException("Security exception configuring SSL context");
            var1.initCause(var3);
            throw new HttpRequest.HttpRequestException(var1);
         }
      }

      return TRUSTED_FACTORY;
   }

   private static HostnameVerifier getTrustedVerifier() {
      if(TRUSTED_VERIFIER == null) {
         TRUSTED_VERIFIER = new HostnameVerifier() {
            public boolean verify(String var1, SSLSession var2) {
               return true;
            }
         };
      }

      return TRUSTED_VERIFIER;
   }

   private static String getValidCharset(String var0) {
      return var0 != null && var0.length() > 0?var0:"UTF-8";
   }

   public static HttpRequest head(CharSequence var0) throws HttpRequest.HttpRequestException {
      return new HttpRequest(var0, "HEAD");
   }

   public static HttpRequest head(CharSequence var0, Map var1, boolean var2) {
      String var4 = append(var0, var1);
      String var3 = var4;
      if(var2) {
         var3 = encode(var4);
      }

      return head((CharSequence)var3);
   }

   public static HttpRequest head(CharSequence var0, boolean var1, Object... var2) {
      String var4 = append(var0, var2);
      String var3 = var4;
      if(var1) {
         var3 = encode(var4);
      }

      return head((CharSequence)var3);
   }

   public static HttpRequest head(URL var0) throws HttpRequest.HttpRequestException {
      return new HttpRequest(var0, "HEAD");
   }

   public static void keepAlive(boolean var0) {
      setProperty("http.keepAlive", Boolean.toString(var0));
   }

   public static void nonProxyHosts(String... var0) {
      if(var0 != null && var0.length > 0) {
         StringBuilder var3 = new StringBuilder();
         int var2 = var0.length - 1;

         for(int var1 = 0; var1 < var2; ++var1) {
            var3.append(var0[var1]).append('|');
         }

         var3.append(var0[var2]);
         setProperty("http.nonProxyHosts", var3.toString());
      } else {
         setProperty("http.nonProxyHosts", (String)null);
      }
   }

   public static HttpRequest options(CharSequence var0) throws HttpRequest.HttpRequestException {
      return new HttpRequest(var0, "OPTIONS");
   }

   public static HttpRequest options(URL var0) throws HttpRequest.HttpRequestException {
      return new HttpRequest(var0, "OPTIONS");
   }

   public static HttpRequest post(CharSequence var0) throws HttpRequest.HttpRequestException {
      return new HttpRequest(var0, "POST");
   }

   public static HttpRequest post(CharSequence var0, Map var1, boolean var2) {
      String var4 = append(var0, var1);
      String var3 = var4;
      if(var2) {
         var3 = encode(var4);
      }

      return post((CharSequence)var3);
   }

   public static HttpRequest post(CharSequence var0, boolean var1, Object... var2) {
      String var4 = append(var0, var2);
      String var3 = var4;
      if(var1) {
         var3 = encode(var4);
      }

      return post((CharSequence)var3);
   }

   public static HttpRequest post(URL var0) throws HttpRequest.HttpRequestException {
      return new HttpRequest(var0, "POST");
   }

   public static void proxyHost(String var0) {
      setProperty("http.proxyHost", var0);
      setProperty("https.proxyHost", var0);
   }

   public static void proxyPort(int var0) {
      String var1 = Integer.toString(var0);
      setProperty("http.proxyPort", var1);
      setProperty("https.proxyPort", var1);
   }

   public static HttpRequest put(CharSequence var0) throws HttpRequest.HttpRequestException {
      return new HttpRequest(var0, "PUT");
   }

   public static HttpRequest put(CharSequence var0, Map var1, boolean var2) {
      String var4 = append(var0, var1);
      String var3 = var4;
      if(var2) {
         var3 = encode(var4);
      }

      return put((CharSequence)var3);
   }

   public static HttpRequest put(CharSequence var0, boolean var1, Object... var2) {
      String var4 = append(var0, var2);
      String var3 = var4;
      if(var1) {
         var3 = encode(var4);
      }

      return put((CharSequence)var3);
   }

   public static HttpRequest put(URL var0) throws HttpRequest.HttpRequestException {
      return new HttpRequest(var0, "PUT");
   }

   public static void setConnectionFactory(HttpRequest.ConnectionFactory var0) {
      if(var0 == null) {
         CONNECTION_FACTORY = HttpRequest.ConnectionFactory.DEFAULT;
      } else {
         CONNECTION_FACTORY = var0;
      }
   }

   private static String setProperty(final String var0, final String var1) {
      PrivilegedAction var2;
      if(var1 != null) {
         var2 = new PrivilegedAction() {
            public String run() {
               return System.setProperty(var0, var1);
            }
         };
      } else {
         var2 = new PrivilegedAction() {
            public String run() {
               return System.clearProperty(var0);
            }
         };
      }

      return (String)AccessController.doPrivileged(var2);
   }

   public static HttpRequest trace(CharSequence var0) throws HttpRequest.HttpRequestException {
      return new HttpRequest(var0, "TRACE");
   }

   public static HttpRequest trace(URL var0) throws HttpRequest.HttpRequestException {
      return new HttpRequest(var0, "TRACE");
   }

   public HttpRequest accept(String var1) {
      return this.header("Accept", var1);
   }

   public HttpRequest acceptCharset(String var1) {
      return this.header("Accept-Charset", var1);
   }

   public HttpRequest acceptEncoding(String var1) {
      return this.header("Accept-Encoding", var1);
   }

   public HttpRequest acceptGzipEncoding() {
      return this.acceptEncoding("gzip");
   }

   public HttpRequest acceptJson() {
      return this.accept("application/json");
   }

   public HttpRequest authorization(String var1) {
      return this.header("Authorization", var1);
   }

   public boolean badRequest() throws HttpRequest.HttpRequestException {
      return 400 == this.code();
   }

   public HttpRequest basic(String var1, String var2) {
      return this.authorization("Basic " + HttpRequest.Base64.encode(var1 + ':' + var2));
   }

   public HttpRequest body(AtomicReference var1) throws HttpRequest.HttpRequestException {
      var1.set(this.body());
      return this;
   }

   public HttpRequest body(AtomicReference var1, String var2) throws HttpRequest.HttpRequestException {
      var1.set(this.body(var2));
      return this;
   }

   public String body() throws HttpRequest.HttpRequestException {
      return this.body(this.charset());
   }

   public String body(String var1) throws HttpRequest.HttpRequestException {
      ByteArrayOutputStream var2 = this.byteStream();

      try {
         this.copy((InputStream)this.buffer(), (OutputStream)var2);
         var1 = var2.toString(getValidCharset(var1));
         return var1;
      } catch (IOException var3) {
         throw new HttpRequest.HttpRequestException(var3);
      }
   }

   public BufferedInputStream buffer() throws HttpRequest.HttpRequestException {
      return new BufferedInputStream(this.stream(), this.bufferSize);
   }

   public int bufferSize() {
      return this.bufferSize;
   }

   public HttpRequest bufferSize(int var1) {
      if(var1 < 1) {
         throw new IllegalArgumentException("Size must be greater than zero");
      } else {
         this.bufferSize = var1;
         return this;
      }
   }

   public BufferedReader bufferedReader() throws HttpRequest.HttpRequestException {
      return this.bufferedReader(this.charset());
   }

   public BufferedReader bufferedReader(String var1) throws HttpRequest.HttpRequestException {
      return new BufferedReader(this.reader(var1), this.bufferSize);
   }

   protected ByteArrayOutputStream byteStream() {
      int var1 = this.contentLength();
      return var1 > 0?new ByteArrayOutputStream(var1):new ByteArrayOutputStream();
   }

   public byte[] bytes() throws HttpRequest.HttpRequestException {
      ByteArrayOutputStream var1 = this.byteStream();

      try {
         this.copy((InputStream)this.buffer(), (OutputStream)var1);
      } catch (IOException var2) {
         throw new HttpRequest.HttpRequestException(var2);
      }

      return var1.toByteArray();
   }

   public String cacheControl() {
      return this.header("Cache-Control");
   }

   public String charset() {
      return this.parameter("Content-Type", "charset");
   }

   public HttpRequest chunk(int var1) {
      this.getConnection().setChunkedStreamingMode(var1);
      return this;
   }

   protected HttpRequest closeOutput() throws IOException {
      if(this.output == null) {
         return this;
      } else {
         if(this.multipart) {
            this.output.write("\r\n--00content0boundary00--\r\n");
         }

         if(this.ignoreCloseExceptions) {
            try {
               this.output.close();
            } catch (IOException var2) {
               ;
            }
         } else {
            this.output.close();
         }

         this.output = null;
         return this;
      }
   }

   protected HttpRequest closeOutputQuietly() throws HttpRequest.HttpRequestException {
      try {
         HttpRequest var1 = this.closeOutput();
         return var1;
      } catch (IOException var2) {
         throw new HttpRequest.HttpRequestException(var2);
      }
   }

   public int code() throws HttpRequest.HttpRequestException {
      try {
         this.closeOutput();
         int var1 = this.getConnection().getResponseCode();
         return var1;
      } catch (IOException var3) {
         throw new HttpRequest.HttpRequestException(var3);
      }
   }

   public HttpRequest code(AtomicInteger var1) throws HttpRequest.HttpRequestException {
      var1.set(this.code());
      return this;
   }

   public HttpRequest connectTimeout(int var1) {
      this.getConnection().setConnectTimeout(var1);
      return this;
   }

   public String contentEncoding() {
      return this.header("Content-Encoding");
   }

   public int contentLength() {
      return this.intHeader("Content-Length");
   }

   public HttpRequest contentLength(int var1) {
      this.getConnection().setFixedLengthStreamingMode(var1);
      return this;
   }

   public HttpRequest contentLength(String var1) {
      return this.contentLength(Integer.parseInt(var1));
   }

   public HttpRequest contentType(String var1) {
      return this.contentType(var1, (String)null);
   }

   public HttpRequest contentType(String var1, String var2) {
      return var2 != null && var2.length() > 0?this.header("Content-Type", var1 + "; charset=" + var2):this.header("Content-Type", var1);
   }

   public String contentType() {
      return this.header("Content-Type");
   }

   protected HttpRequest copy(final InputStream var1, final OutputStream var2) throws IOException {
      return (HttpRequest)(new HttpRequest.CloseOperation(var1, this.ignoreCloseExceptions) {
         public HttpRequest run() throws IOException {
            byte[] var2x = new byte[HttpRequest.this.bufferSize];

            while(true) {
               int var1x = var1.read(var2x);
               if(var1x == -1) {
                  return HttpRequest.this;
               }

               var2.write(var2x, 0, var1x);
            }
         }
      }).call();
   }

   protected HttpRequest copy(final Reader var1, final Writer var2) throws IOException {
      return (HttpRequest)(new HttpRequest.CloseOperation(var1, this.ignoreCloseExceptions) {
         public HttpRequest run() throws IOException {
            char[] var2x = new char[HttpRequest.this.bufferSize];

            while(true) {
               int var1x = var1.read(var2x);
               if(var1x == -1) {
                  return HttpRequest.this;
               }

               var2.write(var2x, 0, var1x);
            }
         }
      }).call();
   }

   public boolean created() throws HttpRequest.HttpRequestException {
      return 201 == this.code();
   }

   public long date() {
      return this.dateHeader("Date");
   }

   public long dateHeader(String var1) throws HttpRequest.HttpRequestException {
      return this.dateHeader(var1, -1L);
   }

   public long dateHeader(String var1, long var2) throws HttpRequest.HttpRequestException {
      this.closeOutputQuietly();
      return this.getConnection().getHeaderFieldDate(var1, var2);
   }

   public HttpRequest disconnect() {
      this.getConnection().disconnect();
      return this;
   }

   public String eTag() {
      return this.header("ETag");
   }

   public long expires() {
      return this.dateHeader("Expires");
   }

   public HttpRequest followRedirects(boolean var1) {
      this.getConnection().setInstanceFollowRedirects(var1);
      return this;
   }

   public HttpRequest form(Object var1, Object var2) throws HttpRequest.HttpRequestException {
      return this.form(var1, var2, "UTF-8");
   }

   public HttpRequest form(Object param1, Object param2, String param3) throws HttpRequest.HttpRequestException {
      // $FF: Couldn't be decompiled
   }

   public HttpRequest form(Entry var1) throws HttpRequest.HttpRequestException {
      return this.form(var1, "UTF-8");
   }

   public HttpRequest form(Entry var1, String var2) throws HttpRequest.HttpRequestException {
      return this.form(var1.getKey(), var1.getValue(), var2);
   }

   public HttpRequest form(Map var1) throws HttpRequest.HttpRequestException {
      return this.form(var1, "UTF-8");
   }

   public HttpRequest form(Map var1, String var2) throws HttpRequest.HttpRequestException {
      if(!var1.isEmpty()) {
         Iterator var3 = var1.entrySet().iterator();

         while(var3.hasNext()) {
            this.form((Entry)var3.next(), var2);
         }
      }

      return this;
   }

   public HttpURLConnection getConnection() {
      if(this.connection == null) {
         this.connection = this.createConnection();
      }

      return this.connection;
   }

   protected String getParam(String var1, String var2) {
      if(var1 != null && var1.length() != 0) {
         int var4 = var1.length();
         int var6 = var1.indexOf(59) + 1;
         if(var6 == 0 || var6 == var4) {
            return null;
         }

         int var7 = var1.indexOf(59, var6);
         int var3 = var7;
         int var5 = var6;
         if(var7 == -1) {
            var3 = var4;
            var5 = var6;
         }

         while(true) {
            if(var5 >= var3) {
               return null;
            }

            var6 = var1.indexOf(61, var5);
            if(var6 != -1 && var6 < var3 && var2.equals(var1.substring(var5, var6).trim())) {
               String var8 = var1.substring(var6 + 1, var3).trim();
               var5 = var8.length();
               if(var5 != 0) {
                  var1 = var8;
                  if(var5 > 2) {
                     var1 = var8;
                     if(34 == var8.charAt(0)) {
                        var1 = var8;
                        if(34 == var8.charAt(var5 - 1)) {
                           return var8.substring(1, var5 - 1);
                        }
                     }
                  }
                  break;
               }
            }

            var6 = var3 + 1;
            var7 = var1.indexOf(59, var6);
            var3 = var7;
            var5 = var6;
            if(var7 == -1) {
               var3 = var4;
               var5 = var6;
            }
         }
      } else {
         var1 = null;
      }

      return var1;
   }

   protected Map getParams(String var1) {
      Object var7;
      if(var1 != null && var1.length() != 0) {
         int var3 = var1.length();
         int var4 = var1.indexOf(59) + 1;
         if(var4 == 0 || var4 == var3) {
            return Collections.emptyMap();
         }

         int var5 = var1.indexOf(59, var4);
         int var2 = var5;
         if(var5 == -1) {
            var2 = var3;
         }

         LinkedHashMap var8 = new LinkedHashMap();

         while(true) {
            var7 = var8;
            if(var4 >= var2) {
               break;
            }

            var5 = var1.indexOf(61, var4);
            if(var5 != -1 && var5 < var2) {
               String var10 = var1.substring(var4, var5).trim();
               if(var10.length() > 0) {
                  String var9 = var1.substring(var5 + 1, var2).trim();
                  var4 = var9.length();
                  if(var4 != 0) {
                     if(var4 > 2 && 34 == var9.charAt(0) && 34 == var9.charAt(var4 - 1)) {
                        var8.put(var10, var9.substring(1, var4 - 1));
                     } else {
                        var8.put(var10, var9);
                     }
                  }
               }
            }

            var5 = var2 + 1;
            int var6 = var1.indexOf(59, var5);
            var2 = var6;
            var4 = var5;
            if(var6 == -1) {
               var2 = var3;
               var4 = var5;
            }
         }
      } else {
         var7 = Collections.emptyMap();
      }

      return (Map)var7;
   }

   public HttpRequest header(String var1, Number var2) {
      String var3;
      if(var2 != null) {
         var3 = var2.toString();
      } else {
         var3 = null;
      }

      return this.header(var1, var3);
   }

   public HttpRequest header(String var1, String var2) {
      this.getConnection().setRequestProperty(var1, var2);
      return this;
   }

   public HttpRequest header(Entry var1) {
      return this.header((String)var1.getKey(), (String)var1.getValue());
   }

   public String header(String var1) throws HttpRequest.HttpRequestException {
      this.closeOutputQuietly();
      return this.getConnection().getHeaderField(var1);
   }

   public HttpRequest headers(Map var1) {
      if(!var1.isEmpty()) {
         Iterator var2 = var1.entrySet().iterator();

         while(var2.hasNext()) {
            this.header((Entry)var2.next());
         }
      }

      return this;
   }

   public Map headers() throws HttpRequest.HttpRequestException {
      this.closeOutputQuietly();
      return this.getConnection().getHeaderFields();
   }

   public String[] headers(String var1) {
      Map var2 = this.headers();
      if(var2 != null && !var2.isEmpty()) {
         List var3 = (List)var2.get(var1);
         return var3 != null && !var3.isEmpty()?(String[])var3.toArray(new String[var3.size()]):EMPTY_STRINGS;
      } else {
         return EMPTY_STRINGS;
      }
   }

   public HttpRequest ifModifiedSince(long var1) {
      this.getConnection().setIfModifiedSince(var1);
      return this;
   }

   public HttpRequest ifNoneMatch(String var1) {
      return this.header("If-None-Match", var1);
   }

   public HttpRequest ignoreCloseExceptions(boolean var1) {
      this.ignoreCloseExceptions = var1;
      return this;
   }

   public boolean ignoreCloseExceptions() {
      return this.ignoreCloseExceptions;
   }

   public int intHeader(String var1) throws HttpRequest.HttpRequestException {
      return this.intHeader(var1, -1);
   }

   public int intHeader(String var1, int var2) throws HttpRequest.HttpRequestException {
      this.closeOutputQuietly();
      return this.getConnection().getHeaderFieldInt(var1, var2);
   }

   public boolean isBodyEmpty() throws HttpRequest.HttpRequestException {
      return this.contentLength() == 0;
   }

   public long lastModified() {
      return this.dateHeader("Last-Modified");
   }

   public String location() {
      return this.header("Location");
   }

   public String message() throws HttpRequest.HttpRequestException {
      try {
         this.closeOutput();
         String var1 = this.getConnection().getResponseMessage();
         return var1;
      } catch (IOException var2) {
         throw new HttpRequest.HttpRequestException(var2);
      }
   }

   public String method() {
      return this.getConnection().getRequestMethod();
   }

   public boolean notFound() throws HttpRequest.HttpRequestException {
      return 404 == this.code();
   }

   public boolean notModified() throws HttpRequest.HttpRequestException {
      return 304 == this.code();
   }

   public boolean ok() throws HttpRequest.HttpRequestException {
      return 200 == this.code();
   }

   protected HttpRequest openOutput() throws IOException {
      if(this.output != null) {
         return this;
      } else {
         this.getConnection().setDoOutput(true);
         String var1 = this.getParam(this.getConnection().getRequestProperty("Content-Type"), "charset");
         this.output = new HttpRequest.RequestOutputStream(this.getConnection().getOutputStream(), var1, this.bufferSize);
         return this;
      }
   }

   public String parameter(String var1, String var2) {
      return this.getParam(this.header(var1), var2);
   }

   public Map parameters(String var1) {
      return this.getParams(this.header(var1));
   }

   public HttpRequest part(String var1, File var2) throws HttpRequest.HttpRequestException {
      return this.part(var1, (String)null, (File)var2);
   }

   public HttpRequest part(String var1, InputStream var2) throws HttpRequest.HttpRequestException {
      return this.part(var1, (String)null, (String)null, (InputStream)var2);
   }

   public HttpRequest part(String var1, Number var2) throws HttpRequest.HttpRequestException {
      return this.part(var1, (String)null, (Number)var2);
   }

   public HttpRequest part(String var1, String var2) {
      return this.part(var1, (String)null, (String)var2);
   }

   public HttpRequest part(String var1, String var2, File var3) throws HttpRequest.HttpRequestException {
      return this.part(var1, var2, (String)null, (File)var3);
   }

   public HttpRequest part(String var1, String var2, Number var3) throws HttpRequest.HttpRequestException {
      String var4;
      if(var3 != null) {
         var4 = var3.toString();
      } else {
         var4 = null;
      }

      return this.part(var1, var2, var4);
   }

   public HttpRequest part(String var1, String var2, String var3) throws HttpRequest.HttpRequestException {
      return this.part(var1, var2, (String)null, (String)var3);
   }

   public HttpRequest part(String param1, String param2, String param3, File param4) throws HttpRequest.HttpRequestException {
      // $FF: Couldn't be decompiled
   }

   public HttpRequest part(String var1, String var2, String var3, InputStream var4) throws HttpRequest.HttpRequestException {
      try {
         this.startPart();
         this.writePartHeader(var1, var2, var3);
         this.copy((InputStream)var4, (OutputStream)this.output);
         return this;
      } catch (IOException var5) {
         throw new HttpRequest.HttpRequestException(var5);
      }
   }

   public HttpRequest part(String var1, String var2, String var3, String var4) throws HttpRequest.HttpRequestException {
      try {
         this.startPart();
         this.writePartHeader(var1, var2, var3);
         this.output.write(var4);
         return this;
      } catch (IOException var5) {
         throw new HttpRequest.HttpRequestException(var5);
      }
   }

   public HttpRequest partHeader(String var1, String var2) throws HttpRequest.HttpRequestException {
      return this.send((CharSequence)var1).send((CharSequence)": ").send((CharSequence)var2).send((CharSequence)"\r\n");
   }

   public HttpRequest proxyAuthorization(String var1) {
      return this.header("Proxy-Authorization", var1);
   }

   public HttpRequest proxyBasic(String var1, String var2) {
      return this.proxyAuthorization("Basic " + HttpRequest.Base64.encode(var1 + ':' + var2));
   }

   public HttpRequest readTimeout(int var1) {
      this.getConnection().setReadTimeout(var1);
      return this;
   }

   public InputStreamReader reader() throws HttpRequest.HttpRequestException {
      return this.reader(this.charset());
   }

   public InputStreamReader reader(String var1) throws HttpRequest.HttpRequestException {
      try {
         InputStreamReader var3 = new InputStreamReader(this.stream(), getValidCharset(var1));
         return var3;
      } catch (UnsupportedEncodingException var2) {
         throw new HttpRequest.HttpRequestException(var2);
      }
   }

   public HttpRequest receive(File var1) throws HttpRequest.HttpRequestException {
      final BufferedOutputStream var3;
      try {
         var3 = new BufferedOutputStream(new FileOutputStream(var1), this.bufferSize);
      } catch (FileNotFoundException var2) {
         throw new HttpRequest.HttpRequestException(var2);
      }

      return (HttpRequest)(new HttpRequest.CloseOperation(var3, this.ignoreCloseExceptions) {
         protected HttpRequest run() throws HttpRequest.HttpRequestException, IOException {
            return HttpRequest.this.receive((OutputStream)var3);
         }
      }).call();
   }

   public HttpRequest receive(OutputStream var1) throws HttpRequest.HttpRequestException {
      try {
         HttpRequest var3 = this.copy((InputStream)this.buffer(), (OutputStream)var1);
         return var3;
      } catch (IOException var2) {
         throw new HttpRequest.HttpRequestException(var2);
      }
   }

   public HttpRequest receive(PrintStream var1) throws HttpRequest.HttpRequestException {
      return this.receive((OutputStream)var1);
   }

   public HttpRequest receive(final Writer var1) throws HttpRequest.HttpRequestException {
      final BufferedReader var2 = this.bufferedReader();
      return (HttpRequest)(new HttpRequest.CloseOperation(var2, this.ignoreCloseExceptions) {
         public HttpRequest run() throws IOException {
            return HttpRequest.this.copy((Reader)var2, (Writer)var1);
         }
      }).call();
   }

   public HttpRequest receive(final Appendable var1) throws HttpRequest.HttpRequestException {
      final BufferedReader var2 = this.bufferedReader();
      return (HttpRequest)(new HttpRequest.CloseOperation(var2, this.ignoreCloseExceptions) {
         public HttpRequest run() throws IOException {
            CharBuffer var2x = CharBuffer.allocate(HttpRequest.this.bufferSize);

            while(true) {
               int var1x = var2.read(var2x);
               if(var1x == -1) {
                  return HttpRequest.this;
               }

               var2x.rewind();
               var1.append(var2x, 0, var1x);
               var2x.rewind();
            }
         }
      }).call();
   }

   public HttpRequest referer(String var1) {
      return this.header("Referer", var1);
   }

   public HttpRequest send(File var1) throws HttpRequest.HttpRequestException {
      BufferedInputStream var3;
      try {
         var3 = new BufferedInputStream(new FileInputStream(var1));
      } catch (FileNotFoundException var2) {
         throw new HttpRequest.HttpRequestException(var2);
      }

      return this.send((InputStream)var3);
   }

   public HttpRequest send(InputStream var1) throws HttpRequest.HttpRequestException {
      try {
         this.openOutput();
         this.copy((InputStream)var1, (OutputStream)this.output);
         return this;
      } catch (IOException var2) {
         throw new HttpRequest.HttpRequestException(var2);
      }
   }

   public HttpRequest send(final Reader var1) throws HttpRequest.HttpRequestException {
      try {
         this.openOutput();
      } catch (IOException var3) {
         throw new HttpRequest.HttpRequestException(var3);
      }

      final OutputStreamWriter var2 = new OutputStreamWriter(this.output, this.output.encoder.charset());
      return (HttpRequest)(new HttpRequest.FlushOperation(var2) {
         protected HttpRequest run() throws IOException {
            return HttpRequest.this.copy((Reader)var1, (Writer)var2);
         }
      }).call();
   }

   public HttpRequest send(CharSequence var1) throws HttpRequest.HttpRequestException {
      try {
         this.openOutput();
         this.output.write(var1.toString());
         return this;
      } catch (IOException var2) {
         throw new HttpRequest.HttpRequestException(var2);
      }
   }

   public HttpRequest send(byte[] var1) throws HttpRequest.HttpRequestException {
      return this.send((InputStream)(new ByteArrayInputStream(var1)));
   }

   public String server() {
      return this.header("Server");
   }

   public boolean serverError() throws HttpRequest.HttpRequestException {
      return 500 == this.code();
   }

   protected HttpRequest startPart() throws IOException {
      if(!this.multipart) {
         this.multipart = true;
         this.contentType("multipart/form-data; boundary=00content0boundary00").openOutput();
         this.output.write("--00content0boundary00\r\n");
         return this;
      } else {
         this.output.write("\r\n--00content0boundary00\r\n");
         return this;
      }
   }

   public InputStream stream() throws HttpRequest.HttpRequestException {
      InputStream var1;
      if(this.code() < 400) {
         try {
            var1 = this.getConnection().getInputStream();
         } catch (IOException var5) {
            throw new HttpRequest.HttpRequestException(var5);
         }
      } else {
         InputStream var2 = this.getConnection().getErrorStream();
         var1 = var2;
         if(var2 == null) {
            try {
               var1 = this.getConnection().getInputStream();
            } catch (IOException var4) {
               throw new HttpRequest.HttpRequestException(var4);
            }
         }
      }

      if(this.uncompress && "gzip".equals(this.contentEncoding())) {
         try {
            GZIPInputStream var6 = new GZIPInputStream(var1);
            return var6;
         } catch (IOException var3) {
            throw new HttpRequest.HttpRequestException(var3);
         }
      } else {
         return var1;
      }
   }

   public String toString() {
      return this.method() + ' ' + this.url();
   }

   public HttpRequest trustAllCerts() throws HttpRequest.HttpRequestException {
      HttpURLConnection var1 = this.getConnection();
      if(var1 instanceof HttpsURLConnection) {
         ((HttpsURLConnection)var1).setSSLSocketFactory(getTrustedFactory());
      }

      return this;
   }

   public HttpRequest trustAllHosts() {
      HttpURLConnection var1 = this.getConnection();
      if(var1 instanceof HttpsURLConnection) {
         ((HttpsURLConnection)var1).setHostnameVerifier(getTrustedVerifier());
      }

      return this;
   }

   public HttpRequest uncompress(boolean var1) {
      this.uncompress = var1;
      return this;
   }

   public URL url() {
      return this.getConnection().getURL();
   }

   public HttpRequest useCaches(boolean var1) {
      this.getConnection().setUseCaches(var1);
      return this;
   }

   public HttpRequest useProxy(String var1, int var2) {
      if(this.connection != null) {
         throw new IllegalStateException("The connection has already been created. This method must be called before reading or writing to the request.");
      } else {
         this.httpProxyHost = var1;
         this.httpProxyPort = var2;
         return this;
      }
   }

   public HttpRequest userAgent(String var1) {
      return this.header("User-Agent", var1);
   }

   protected HttpRequest writePartHeader(String var1, String var2) throws IOException {
      return this.writePartHeader(var1, var2, (String)null);
   }

   protected HttpRequest writePartHeader(String var1, String var2, String var3) throws IOException {
      StringBuilder var4 = new StringBuilder();
      var4.append("form-data; name=\"").append(var1);
      if(var2 != null) {
         var4.append("\"; filename=\"").append(var2);
      }

      var4.append('\"');
      this.partHeader("Content-Disposition", var4.toString());
      if(var3 != null) {
         this.partHeader("Content-Type", var3);
      }

      return this.send((CharSequence)"\r\n");
   }

   public OutputStreamWriter writer() throws HttpRequest.HttpRequestException {
      try {
         this.openOutput();
         OutputStreamWriter var1 = new OutputStreamWriter(this.output, this.output.encoder.charset());
         return var1;
      } catch (IOException var2) {
         throw new HttpRequest.HttpRequestException(var2);
      }
   }

   public static class Base64 {
      private static final byte EQUALS_SIGN = 61;
      private static final String PREFERRED_ENCODING = "US-ASCII";
      private static final byte[] _STANDARD_ALPHABET = new byte[]{(byte)65, (byte)66, (byte)67, (byte)68, (byte)69, (byte)70, (byte)71, (byte)72, (byte)73, (byte)74, (byte)75, (byte)76, (byte)77, (byte)78, (byte)79, (byte)80, (byte)81, (byte)82, (byte)83, (byte)84, (byte)85, (byte)86, (byte)87, (byte)88, (byte)89, (byte)90, (byte)97, (byte)98, (byte)99, (byte)100, (byte)101, (byte)102, (byte)103, (byte)104, (byte)105, (byte)106, (byte)107, (byte)108, (byte)109, (byte)110, (byte)111, (byte)112, (byte)113, (byte)114, (byte)115, (byte)116, (byte)117, (byte)118, (byte)119, (byte)120, (byte)121, (byte)122, (byte)48, (byte)49, (byte)50, (byte)51, (byte)52, (byte)53, (byte)54, (byte)55, (byte)56, (byte)57, (byte)43, (byte)47};

      public static String encode(String var0) {
         byte[] var1;
         byte[] var3;
         try {
            var1 = var0.getBytes("US-ASCII");
         } catch (UnsupportedEncodingException var2) {
            var3 = var0.getBytes();
            return encodeBytes(var3);
         }

         var3 = var1;
         return encodeBytes(var3);
      }

      private static byte[] encode3to4(byte[] var0, int var1, int var2, byte[] var3, int var4) {
         int var7 = 0;
         byte[] var8 = _STANDARD_ALPHABET;
         int var5;
         if(var2 > 0) {
            var5 = var0[var1] << 24 >>> 8;
         } else {
            var5 = 0;
         }

         int var6;
         if(var2 > 1) {
            var6 = var0[var1 + 1] << 24 >>> 16;
         } else {
            var6 = 0;
         }

         if(var2 > 2) {
            var7 = var0[var1 + 2] << 24 >>> 24;
         }

         var1 = var6 | var5 | var7;
         switch(var2) {
         case 1:
            var3[var4] = var8[var1 >>> 18];
            var3[var4 + 1] = var8[var1 >>> 12 & 63];
            var3[var4 + 2] = 61;
            var3[var4 + 3] = 61;
            return var3;
         case 2:
            var3[var4] = var8[var1 >>> 18];
            var3[var4 + 1] = var8[var1 >>> 12 & 63];
            var3[var4 + 2] = var8[var1 >>> 6 & 63];
            var3[var4 + 3] = 61;
            return var3;
         case 3:
            var3[var4] = var8[var1 >>> 18];
            var3[var4 + 1] = var8[var1 >>> 12 & 63];
            var3[var4 + 2] = var8[var1 >>> 6 & 63];
            var3[var4 + 3] = var8[var1 & 63];
            return var3;
         default:
            return var3;
         }
      }

      public static String encodeBytes(byte[] var0) {
         return encodeBytes(var0, 0, var0.length);
      }

      public static String encodeBytes(byte[] var0, int var1, int var2) {
         var0 = encodeBytesToBytes(var0, var1, var2);

         try {
            String var3 = new String(var0, "US-ASCII");
            return var3;
         } catch (UnsupportedEncodingException var4) {
            return new String(var0);
         }
      }

      public static byte[] encodeBytesToBytes(byte[] var0, int var1, int var2) {
         if(var0 == null) {
            throw new NullPointerException("Cannot serialize a null array.");
         } else if(var1 < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + var1);
         } else if(var2 < 0) {
            throw new IllegalArgumentException("Cannot have length offset: " + var2);
         } else if(var1 + var2 > var0.length) {
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", new Object[]{Integer.valueOf(var1), Integer.valueOf(var2), Integer.valueOf(var0.length)}));
         } else {
            int var4 = var2 / 3;
            byte var3;
            if(var2 % 3 > 0) {
               var3 = 4;
            } else {
               var3 = 0;
            }

            byte[] var6 = new byte[var4 * 4 + var3];
            var4 = 0;

            int var7;
            for(var7 = 0; var4 < var2 - 2; var7 += 4) {
               encode3to4(var0, var4 + var1, 3, var6, var7);
               var4 += 3;
            }

            int var5 = var7;
            if(var4 < var2) {
               encode3to4(var0, var4 + var1, var2 - var4, var6, var7);
               var5 = var7 + 4;
            }

            if(var5 <= var6.length - 1) {
               var0 = new byte[var5];
               System.arraycopy(var6, 0, var0, 0, var5);
               return var0;
            } else {
               return var6;
            }
         }
      }
   }

   protected abstract static class CloseOperation extends HttpRequest.Operation {
      private final Closeable closeable;
      private final boolean ignoreCloseExceptions;

      protected CloseOperation(Closeable var1, boolean var2) {
         this.closeable = var1;
         this.ignoreCloseExceptions = var2;
      }

      protected void done() throws IOException {
         if(this.closeable instanceof Flushable) {
            ((Flushable)this.closeable).flush();
         }

         if(this.ignoreCloseExceptions) {
            try {
               this.closeable.close();
            } catch (IOException var2) {
               ;
            }
         } else {
            this.closeable.close();
         }
      }
   }

   public interface ConnectionFactory {
      HttpRequest.ConnectionFactory DEFAULT = new HttpRequest.ConnectionFactory() {
         public HttpURLConnection create(URL var1) throws IOException {
            return (HttpURLConnection)var1.openConnection();
         }

         public HttpURLConnection create(URL var1, Proxy var2) throws IOException {
            return (HttpURLConnection)var1.openConnection(var2);
         }
      };

      HttpURLConnection create(URL var1) throws IOException;

      HttpURLConnection create(URL var1, Proxy var2) throws IOException;
   }

   protected abstract static class FlushOperation extends HttpRequest.Operation {
      private final Flushable flushable;

      protected FlushOperation(Flushable var1) {
         this.flushable = var1;
      }

      protected void done() throws IOException {
         this.flushable.flush();
      }
   }

   public static class HttpRequestException extends RuntimeException {
      private static final long serialVersionUID = -1170466989781746231L;

      protected HttpRequestException(IOException var1) {
         super(var1);
      }

      public IOException getCause() {
         return (IOException)super.getCause();
      }
   }

   protected abstract static class Operation implements Callable {
      public Object call() throws HttpRequest.HttpRequestException {
         // $FF: Couldn't be decompiled
      }

      protected abstract void done() throws IOException;

      protected abstract Object run() throws HttpRequest.HttpRequestException, IOException;
   }

   public static class RequestOutputStream extends BufferedOutputStream {
      private final CharsetEncoder encoder;

      public RequestOutputStream(OutputStream var1, String var2, int var3) {
         super(var1, var3);
         this.encoder = Charset.forName(HttpRequest.getValidCharset(var2)).newEncoder();
      }

      public HttpRequest.RequestOutputStream write(String var1) throws IOException {
         ByteBuffer var2 = this.encoder.encode(CharBuffer.wrap(var1));
         super.write(var2.array(), 0, var2.limit());
         return this;
      }
   }
}
