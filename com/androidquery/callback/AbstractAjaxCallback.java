package com.androidquery.callback;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Xml;
import android.view.View;
import com.androidquery.auth.AccountHandle;
import com.androidquery.auth.GoogleHandle;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.callback.BitmapAjaxCallback;
import com.androidquery.callback.ProxyHandle;
import com.androidquery.callback.Transformer;
import com.androidquery.util.AQUtility;
import com.androidquery.util.Common;
import com.androidquery.util.Progress;
import com.androidquery.util.XmlDom;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.Proxy.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HttpContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.xmlpull.v1.XmlPullParser;

public abstract class AbstractAjaxCallback implements Runnable {
   private static String AGENT = null;
   private static final Class[] DEFAULT_SIG = new Class[]{String.class, Object.class, AjaxStatus.class};
   private static boolean GZIP = true;
   private static int NETWORK_POOL = 4;
   private static int NET_TIMEOUT = 30000;
   private static boolean REUSE_CLIENT = true;
   private static boolean SIMULATE_ERROR = false;
   private static final String boundary = "*****";
   private static DefaultHttpClient client;
   private static ExecutorService fetchExe;
   private static int lastStatus = 200;
   private static final String lineEnd = "\r\n";
   private static ProxyHandle proxyHandle;
   private static SocketFactory ssf;
   private static Transformer st;
   private static final String twoHyphens = "--";
   private boolean abort;
   private WeakReference act;
   protected AccountHandle ah;
   private boolean blocked;
   private File cacheDir;
   private String callback;
   private boolean completed;
   protected Map cookies;
   private String encoding = "UTF-8";
   private long expire;
   protected boolean fileCache;
   private Object handler;
   protected Map headers;
   protected boolean memCache;
   private int method = 4;
   private String networkUrl;
   protected Map params;
   private int policy = 0;
   private WeakReference progress;
   private HttpHost proxy;
   private boolean reauth;
   private boolean redirect = true;
   private boolean refresh;
   private HttpUriRequest request;
   protected Object result;
   private int retry = 0;
   protected AjaxStatus status;
   private File targetFile;
   private int timeout = 0;
   private Transformer transformer;
   private Class type;
   private boolean uiCallback = true;
   private String url;
   private Reference whandler;

   private void afterWork() {
      if(this.url != null && this.memCache) {
         this.memPut(this.url, this.result);
      }

      this.callback();
      this.clear();
   }

   private void backgroundWork() {
      if(!this.refresh && this.fileCache) {
         this.fileWork();
      }

      if(this.result == null) {
         this.datastoreWork();
      }

      if(this.result == null) {
         this.networkWork();
      }

   }

   public static void cancel() {
      if(fetchExe != null) {
         fetchExe.shutdownNow();
         fetchExe = null;
      }

      BitmapAjaxCallback.clearTasks();
   }

   private void clear() {
      this.whandler = null;
      this.handler = null;
      this.progress = null;
      this.request = null;
      this.transformer = null;
      this.ah = null;
      this.act = null;
   }

   private void copy(InputStream var1, OutputStream var2, int var3) throws IOException {
      Object var4 = null;
      if(this.progress != null) {
         var4 = this.progress.get();
      }

      Progress var5 = null;
      if(var4 != null) {
         var5 = new Progress(var4);
      }

      AQUtility.copy(var1, var2, var3, var5);
   }

   private void copy(InputStream var1, OutputStream var2, int var3, File var4, File var5) throws IOException {
      if(var5 == null) {
         this.copy(var1, var2, var3);
      } else {
         try {
            this.copy(var1, var2, var3);
            var1.close();
            var2.close();
            var4.renameTo(var5);
         } catch (IOException var7) {
            AQUtility.debug((Object)"copy failed, deleting files");
            var4.delete();
            var5.delete();
            AQUtility.close(var1);
            AQUtility.close(var2);
            throw var7;
         }
      }
   }

   private String correctEncoding(byte[] param1, String param2, AjaxStatus param3) {
      // $FF: Couldn't be decompiled
   }

   private void datastoreWork() {
      this.result = this.datastoreGet(this.url);
      if(this.result != null) {
         this.status.source(2).done();
      }

   }

   private HttpResponse execute(HttpUriRequest var1, DefaultHttpClient var2, HttpContext var3) throws ClientProtocolException, IOException {
      if(var1.getURI().getAuthority().contains("_")) {
         URL var4 = var1.getURI().toURL();
         HttpHost var5;
         if(var4.getPort() == -1) {
            var5 = new HttpHost(var4.getHost(), 80, var4.getProtocol());
         } else {
            var5 = new HttpHost(var4.getHost(), var4.getPort(), var4.getProtocol());
         }

         return var2.execute(var5, var1, var3);
      } else {
         return var2.execute(var1, var3);
      }
   }

   public static void execute(Runnable var0) {
      if(fetchExe == null) {
         fetchExe = Executors.newFixedThreadPool(NETWORK_POOL);
      }

      fetchExe.execute(var0);
   }

   private static Map extractParams(Uri var0) {
      HashMap var3 = new HashMap();
      String[] var5 = var0.getQuery().split("&");
      int var2 = var5.length;

      for(int var1 = 0; var1 < var2; ++var1) {
         String[] var4 = var5[var1].split("=");
         if(var4.length >= 2) {
            var3.put(var4[0], var4[1]);
         } else if(var4.length == 1) {
            var3.put(var4[0], "");
         }
      }

      return var3;
   }

   private static String extractUrl(Uri var0) {
      String var1 = var0.getScheme() + "://" + var0.getAuthority() + var0.getPath();
      String var2 = var0.getFragment();
      String var3 = var1;
      if(var2 != null) {
         var3 = var1 + "#" + var2;
      }

      return var3;
   }

   private void filePut() {
      if(this.result != null && this.fileCache) {
         byte[] var4 = this.status.getData();
         if(var4 != null) {
            try {
               if(this.status.getSource() == 1) {
                  File var2 = this.getCacheFile();
                  if(!this.status.getInvalid()) {
                     this.filePut(this.url, this.result, var2, var4);
                  } else if(var2.exists()) {
                     var2.delete();
                  }
               }
            } catch (Exception var3) {
               AQUtility.debug((Throwable)var3);
            }
         }

         this.status.data((byte[])null);
      } else if(this.status.getCode() == -103) {
         File var1 = this.getCacheFile();
         if(var1.exists()) {
            var1.delete();
            AQUtility.debug((Object)"invalidated cache due to transform error");
            return;
         }
      }

   }

   private void fileWork() {
      File var1 = this.accessFile(this.cacheDir, this.getCacheUrl());
      if(var1 != null) {
         this.status.source(3);
         this.result = this.fileGet(this.url, var1, this.status);
         if(this.result != null) {
            this.status.time(new Date(var1.lastModified())).done();
         }
      }

   }

   public static int getActiveCount() {
      int var0 = 0;
      if(fetchExe instanceof ThreadPoolExecutor) {
         var0 = ((ThreadPoolExecutor)fetchExe).getActiveCount();
      }

      return var0;
   }

   private String getCacheUrl() {
      return this.ah != null?this.ah.getCacheUrl(this.url):this.url;
   }

   private String getCharset(String var1) {
      Matcher var2 = Pattern.compile("<meta [^>]*http-equiv[^>]*\"Content-Type\"[^>]*>", 2).matcher(var1);
      return !var2.find()?null:this.parseCharset(var2.group());
   }

   private static DefaultHttpClient getClient() {
      if(client == null || !REUSE_CLIENT) {
         AQUtility.debug((Object)"creating http client");
         BasicHttpParams var1 = new BasicHttpParams();
         HttpConnectionParams.setConnectionTimeout(var1, NET_TIMEOUT);
         HttpConnectionParams.setSoTimeout(var1, NET_TIMEOUT);
         ConnManagerParams.setMaxConnectionsPerRoute(var1, new ConnPerRouteBean(25));
         HttpConnectionParams.setSocketBufferSize(var1, 8192);
         SchemeRegistry var2 = new SchemeRegistry();
         var2.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
         Object var0;
         if(ssf == null) {
            var0 = SSLSocketFactory.getSocketFactory();
         } else {
            var0 = ssf;
         }

         var2.register(new Scheme("https", (SocketFactory)var0, 443));
         client = new DefaultHttpClient(new ThreadSafeClientConnManager(var1, var2), var1);
      }

      return client;
   }

   private String getEncoding(HttpEntity var1) {
      if(var1 != null) {
         Header var2 = var1.getContentEncoding();
         if(var2 != null) {
            return var2.getValue();
         }
      }

      return null;
   }

   protected static int getLastStatus() {
      return lastStatus;
   }

   private String getNetworkUrl(String var1) {
      if(this.networkUrl != null) {
         var1 = this.networkUrl;
      }

      String var2 = var1;
      if(this.ah != null) {
         var2 = this.ah.getNetworkUrl(var1);
      }

      return var2;
   }

   private File getPreFile() {
      boolean var1 = this.isStreamingContent();
      File var2 = null;
      if(var1) {
         if(this.targetFile != null) {
            var2 = this.targetFile;
         } else if(this.fileCache) {
            var2 = this.getCacheFile();
         } else {
            File var3 = AQUtility.getTempDir();
            var2 = var3;
            if(var3 == null) {
               var2 = this.cacheDir;
            }

            var2 = AQUtility.getCacheFile(var2, this.url);
         }
      }

      if(var2 != null && !var2.exists()) {
         try {
            var2.getParentFile().mkdirs();
            var2.createNewFile();
         } catch (Exception var4) {
            AQUtility.report(var4);
            return null;
         }
      }

      return var2;
   }

   private void httpDelete(String var1, AjaxStatus var2) throws IOException {
      AQUtility.debug("get", var1);
      var1 = patchUrl(var1);
      this.httpDo(new HttpDelete(var1), var1, var2);
   }

   private void httpDo(HttpUriRequest param1, String param2, AjaxStatus param3) throws ClientProtocolException, IOException {
      // $FF: Couldn't be decompiled
   }

   private void httpEntity(String var1, HttpEntityEnclosingRequestBase var2, Map var3, AjaxStatus var4) throws ClientProtocolException, IOException {
      var2.getParams().setBooleanParameter("http.protocol.expect-continue", false);
      Object var5 = var3.get("%entity");
      Object var8;
      if(var5 instanceof HttpEntity) {
         var8 = (HttpEntity)var5;
      } else {
         ArrayList var10 = new ArrayList();
         Iterator var9 = var3.entrySet().iterator();

         while(var9.hasNext()) {
            Entry var6 = (Entry)var9.next();
            Object var7 = var6.getValue();
            if(var7 != null) {
               var10.add(new BasicNameValuePair((String)var6.getKey(), var7.toString()));
            }
         }

         var8 = new UrlEncodedFormEntity(var10, "UTF-8");
      }

      if(this.headers != null && !this.headers.containsKey("Content-Type")) {
         this.headers.put("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
      }

      var2.setEntity((HttpEntity)var8);
      this.httpDo(var2, var1, var4);
   }

   private void httpGet(String var1, AjaxStatus var2) throws IOException {
      AQUtility.debug("get", var1);
      var1 = patchUrl(var1);
      this.httpDo(new HttpGet(var1), var1, var2);
   }

   private void httpMulti(String var1, Map var2, AjaxStatus var3) throws IOException {
      AQUtility.debug("multipart", var1);
      URL var6 = new URL(var1);
      Proxy var5 = null;
      if(this.proxy != null) {
         AQUtility.debug("proxy", this.proxy);
         var5 = new Proxy(Type.HTTP, new InetSocketAddress(this.proxy.getHostName(), this.proxy.getPort()));
      } else if(proxyHandle != null) {
         var5 = proxyHandle.makeProxy(this);
      }

      HttpURLConnection var11;
      if(var5 == null) {
         var11 = (HttpURLConnection)var6.openConnection();
      } else {
         var11 = (HttpURLConnection)var6.openConnection(var5);
      }

      var11.setInstanceFollowRedirects(false);
      var11.setConnectTimeout(NET_TIMEOUT * 4);
      var11.setDoInput(true);
      var11.setDoOutput(true);
      var11.setUseCaches(false);
      var11.setRequestMethod("POST");
      var11.setRequestProperty("Connection", "Keep-Alive");
      var11.setRequestProperty("Content-Type", "multipart/form-data;charset=utf-8;boundary=*****");
      String var7;
      if(this.headers != null) {
         Iterator var12 = this.headers.keySet().iterator();

         while(var12.hasNext()) {
            var7 = (String)var12.next();
            var11.setRequestProperty(var7, (String)this.headers.get(var7));
         }
      }

      String var13 = this.makeCookie();
      if(var13 != null) {
         var11.setRequestProperty("Cookie", var13);
      }

      if(this.ah != null) {
         this.ah.applyToken(this, var11);
      }

      DataOutputStream var14 = new DataOutputStream(var11.getOutputStream());
      Iterator var9 = var2.entrySet().iterator();

      while(var9.hasNext()) {
         Entry var15 = (Entry)var9.next();
         writeObject(var14, (String)var15.getKey(), var15.getValue());
      }

      var14.writeBytes("--*****--\r\n");
      var14.flush();
      var14.close();
      var11.connect();
      int var4 = var11.getResponseCode();
      var7 = var11.getResponseMessage();
      byte[] var10 = null;
      String var8 = var11.getContentEncoding();
      var6 = null;
      String var16;
      if(var4 >= 200 && var4 < 300) {
         var10 = this.toData(var8, var11.getInputStream());
         var16 = var6;
      } else {
         var16 = new String(this.toData(var8, var11.getErrorStream()), "UTF-8");
         AQUtility.debug("error", var16);
      }

      AQUtility.debug("response", Integer.valueOf(var4));
      if(var10 != null) {
         AQUtility.debug(Integer.valueOf(var10.length), var1);
      }

      var3.code(var4).message(var7).redirect(var1).time(new Date()).data(var10).error(var16).client((DefaultHttpClient)null);
   }

   private void httpPost(String var1, Map var2, AjaxStatus var3) throws ClientProtocolException, IOException {
      AQUtility.debug("post", var1);
      this.httpEntity(var1, new HttpPost(var1), var2, var3);
   }

   private void httpPut(String var1, Map var2, AjaxStatus var3) throws ClientProtocolException, IOException {
      AQUtility.debug("put", var1);
      this.httpEntity(var1, new HttpPut(var1), var2, var3);
   }

   private boolean isActive() {
      if(this.act != null) {
         Activity var1 = (Activity)this.act.get();
         if(var1 == null || var1.isFinishing()) {
            return false;
         }
      }

      return true;
   }

   private static boolean isMultiPart(Map var0) {
      Iterator var3 = var0.entrySet().iterator();

      Object var2;
      do {
         if(!var3.hasNext()) {
            return false;
         }

         Entry var1 = (Entry)var3.next();
         var2 = var1.getValue();
         AQUtility.debug(var1.getKey(), var2);
      } while(!(var2 instanceof File) && !(var2 instanceof byte[]) && !(var2 instanceof InputStream));

      return true;
   }

   private static String makeAuthHeader(String var0, String var1) {
      byte[] var2 = (var0 + ":" + var1).getBytes();
      return "Basic " + new String(AQUtility.encode64(var2, 0, var2.length));
   }

   private String makeCookie() {
      if(this.cookies != null && this.cookies.size() != 0) {
         Iterator var1 = this.cookies.keySet().iterator();
         StringBuilder var2 = new StringBuilder();

         while(var1.hasNext()) {
            String var3 = (String)var1.next();
            String var4 = (String)this.cookies.get(var3);
            var2.append(var3);
            var2.append("=");
            var2.append(var4);
            if(var1.hasNext()) {
               var2.append("; ");
            }
         }

         return var2.toString();
      } else {
         return null;
      }
   }

   private File makeTempFile(File var1) throws IOException {
      var1 = new File(var1.getAbsolutePath() + ".tmp");
      var1.createNewFile();
      return var1;
   }

   private void network() throws IOException {
      String var3 = this.url;
      Map var4 = this.params;
      Map var1 = var4;
      String var2 = var3;
      if(var4 == null) {
         var1 = var4;
         var2 = var3;
         if(var3.length() > 2000) {
            Uri var5 = Uri.parse(var3);
            var2 = extractUrl(var5);
            var1 = extractParams(var5);
         }
      }

      var3 = this.getNetworkUrl(var2);
      if(2 == this.method) {
         this.httpDelete(var3, this.status);
      } else if(3 == this.method) {
         this.httpPut(var3, var1, this.status);
      } else {
         Object var6 = var1;
         if(1 == this.method) {
            var6 = var1;
            if(var1 == null) {
               var6 = new HashMap();
            }
         }

         if(var6 == null) {
            this.httpGet(var3, this.status);
         } else if(isMultiPart((Map)var6)) {
            this.httpMulti(var3, (Map)var6, this.status);
         } else {
            this.httpPost(var3, (Map)var6, this.status);
         }
      }
   }

   private void network(int var1) throws IOException {
      if(var1 <= 1) {
         this.network();
      } else {
         int var2 = 0;

         while(var2 < var1) {
            try {
               this.network();
               return;
            } catch (IOException var4) {
               if(var2 == var1 - 1) {
                  throw var4;
               }

               ++var2;
            }
         }
      }

   }

   private void networkWork() {
      if(this.url == null) {
         this.status.code(-101).done();
      } else {
         byte[] var1 = null;

         label54: {
            byte[] var6;
            try {
               this.network(this.retry + 1);
               if(this.ah != null && this.ah.expired(this, this.status) && !this.reauth) {
                  AQUtility.debug("reauth needed", this.status.getMessage());
                  this.reauth = true;
                  if(!this.ah.reauth(this)) {
                     this.status.reauth(true);
                     return;
                  }

                  this.network();
               }

               var6 = this.status.getData();
            } catch (IOException var4) {
               AQUtility.debug((Object)"IOException");
               String var2 = var4.getMessage();
               if(var2 != null && var2.contains("No authentication challenges found")) {
                  this.status.code(401).message(var2);
               } else {
                  this.status.code(-101).message("network error");
               }
               break label54;
            } catch (Exception var5) {
               AQUtility.debug((Throwable)var5);
               this.status.code(-101).message("network error");
               break label54;
            }

            var1 = var6;
         }

         try {
            this.result = this.transform(this.url, var1, this.status);
         } catch (Exception var3) {
            AQUtility.debug((Throwable)var3);
         }

         if(this.result == null && var1 != null) {
            this.status.code(-103).message("transform error");
         }

         lastStatus = this.status.getCode();
         this.status.done();
      }
   }

   private String parseCharset(String var1) {
      if(var1 != null) {
         int var4 = var1.indexOf("charset");
         if(var4 != -1) {
            int var3 = var1.indexOf(";", var4);
            int var2 = var3;
            if(var3 == -1) {
               var2 = var1.length();
            }

            return var1.substring(var4 + 7, var2).replaceAll("[^\\w-]", "");
         }
      }

      return null;
   }

   private static String patchUrl(String var0) {
      return var0.replaceAll(" ", "%20").replaceAll("\\|", "%7C");
   }

   private Object self() {
      return this;
   }

   public static void setAgent(String var0) {
      AGENT = var0;
   }

   public static void setGZip(boolean var0) {
      GZIP = var0;
   }

   public static void setNetworkLimit(int var0) {
      NETWORK_POOL = Math.max(1, Math.min(25, var0));
      fetchExe = null;
      AQUtility.debug("setting network limit", Integer.valueOf(NETWORK_POOL));
   }

   public static void setProxyHandle(ProxyHandle var0) {
      proxyHandle = var0;
   }

   public static void setReuseHttpClient(boolean var0) {
      REUSE_CLIENT = var0;
      client = null;
   }

   public static void setSSF(SocketFactory var0) {
      ssf = var0;
      client = null;
   }

   public static void setSimulateError(boolean var0) {
      SIMULATE_ERROR = var0;
   }

   public static void setTimeout(int var0) {
      NET_TIMEOUT = var0;
   }

   public static void setTransformer(Transformer var0) {
      st = var0;
   }

   private byte[] toData(String var1, InputStream var2) throws IOException {
      Object var3 = var2;
      if("gzip".equalsIgnoreCase(var1)) {
         var3 = new GZIPInputStream(var2);
      }

      return AQUtility.toBytes((InputStream)var3);
   }

   private void wake() {
      // $FF: Couldn't be decompiled
   }

   private void work(Context var1) {
      Object var2 = this.memGet(this.url);
      if(var2 != null) {
         this.result = var2;
         this.status.source(4).done();
         this.callback();
      } else {
         this.cacheDir = AQUtility.getCacheDir(var1, this.policy);
         execute(this);
      }
   }

   private static void writeData(DataOutputStream var0, String var1, String var2, InputStream var3) throws IOException {
      var0.writeBytes("--*****\r\n");
      var0.writeBytes("Content-Disposition: form-data; name=\"" + var1 + "\";" + " filename=\"" + var2 + "\"" + "\r\n");
      var0.writeBytes("Content-Type: application/octet-stream");
      var0.writeBytes("\r\n");
      var0.writeBytes("Content-Transfer-Encoding: binary");
      var0.writeBytes("\r\n");
      var0.writeBytes("\r\n");
      AQUtility.copy(var3, var0);
      var0.writeBytes("\r\n");
   }

   private static void writeField(DataOutputStream var0, String var1, String var2) throws IOException {
      var0.writeBytes("--*****\r\n");
      var0.writeBytes("Content-Disposition: form-data; name=\"" + var1 + "\"");
      var0.writeBytes("\r\n");
      var0.writeBytes("\r\n");
      var0.write(var2.getBytes("UTF-8"));
      var0.writeBytes("\r\n");
   }

   private static void writeObject(DataOutputStream var0, String var1, Object var2) throws IOException {
      if(var2 != null) {
         if(var2 instanceof File) {
            File var3 = (File)var2;
            writeData(var0, var1, var3.getName(), new FileInputStream(var3));
         } else if(var2 instanceof byte[]) {
            writeData(var0, var1, var1, new ByteArrayInputStream((byte[])((byte[])var2)));
         } else if(var2 instanceof InputStream) {
            writeData(var0, var1, var1, (InputStream)var2);
         } else {
            writeField(var0, var1, var2.toString());
         }
      }
   }

   public void abort() {
      this.abort = true;
      if(this.request != null && !this.request.isAborted()) {
         this.request.abort();
      }

   }

   protected File accessFile(File var1, String var2) {
      if(this.expire < 0L) {
         var1 = null;
      } else {
         File var3 = AQUtility.getExistedCacheByUrl(var1, var2);
         var1 = var3;
         if(var3 != null) {
            var1 = var3;
            if(this.expire != 0L) {
               var1 = var3;
               if(System.currentTimeMillis() - var3.lastModified() > this.expire) {
                  return null;
               }
            }
         }
      }

      return var1;
   }

   public void async(Activity var1) {
      if(var1.isFinishing()) {
         AQUtility.warn("Warning", "Possible memory leak. Calling ajax with a terminated activity.");
      }

      if(this.type == null) {
         AQUtility.warn("Warning", "type() is not called with response type.");
      } else {
         this.act = new WeakReference(var1);
         this.async((Context)var1);
      }
   }

   public void async(Context var1) {
      if(this.status == null) {
         this.status = new AjaxStatus();
         this.status.redirect(this.url).refresh(this.refresh);
      } else if(this.status.getDone()) {
         this.status.reset();
         this.result = null;
      }

      this.showProgress(true);
      if(this.ah != null && !this.ah.authenticated()) {
         AQUtility.debug("auth needed", this.url);
         this.ah.auth(this);
      } else {
         this.work(var1);
      }
   }

   public Object auth(Activity var1, String var2, String var3) {
      if(VERSION.SDK_INT >= 5 && var2.startsWith("g.")) {
         this.ah = new GoogleHandle(var1, var2, var3);
      }

      return this.self();
   }

   public Object auth(AccountHandle var1) {
      this.ah = var1;
      return this.self();
   }

   public void block() {
      // $FF: Couldn't be decompiled
   }

   protected boolean cacheAvailable(Context var1) {
      return this.fileCache && AQUtility.getExistedCacheByUrl(AQUtility.getCacheDir(var1, this.policy), this.url) != null;
   }

   void callback() {
      this.showProgress(false);
      this.completed = true;
      if(this.isActive()) {
         if(this.callback != null) {
            Object var1 = this.getHandler();
            Class var2 = this.type;
            String var3 = this.callback;
            Class[] var4 = DEFAULT_SIG;
            String var5 = this.url;
            Object var6 = this.result;
            AjaxStatus var7 = this.status;
            AQUtility.invokeHandler(var1, var3, true, true, new Class[]{String.class, var2, AjaxStatus.class}, var4, new Object[]{var5, var6, var7});
         } else {
            try {
               this.callback(this.url, this.result, this.status);
            } catch (Exception var8) {
               AQUtility.report(var8);
            }
         }
      } else {
         this.skip(this.url, this.result, this.status);
      }

      this.filePut();
      if(!this.blocked) {
         this.status.close();
      }

      this.wake();
      AQUtility.debugNotify();
   }

   public void callback(String var1, Object var2, AjaxStatus var3) {
   }

   public Object cookie(String var1, String var2) {
      if(this.cookies == null) {
         this.cookies = new HashMap();
      }

      this.cookies.put(var1, var2);
      return this.self();
   }

   public Object cookies(Map var1) {
      this.cookies = var1;
      return this.self();
   }

   protected Object datastoreGet(String var1) {
      return null;
   }

   public Object encoding(String var1) {
      this.encoding = var1;
      return this.self();
   }

   public Object expire(long var1) {
      this.expire = var1;
      return this.self();
   }

   public void failure(int var1, String var2) {
      if(this.status != null) {
         this.status.code(var1).message(var2).done();
         if(!this.uiCallback) {
            this.afterWork();
            return;
         }

         AQUtility.post(this);
      }

   }

   public Object fileCache(boolean var1) {
      this.fileCache = var1;
      return this.self();
   }

   protected Object fileGet(String param1, File param2, AjaxStatus param3) {
      // $FF: Couldn't be decompiled
   }

   protected void filePut(String var1, Object var2, File var3, byte[] var4) {
      if(var3 != null && var4 != null) {
         AQUtility.storeAsync(var3, var4, 0L);
      }
   }

   protected File getCacheFile() {
      return AQUtility.getCacheFile(this.cacheDir, this.getCacheUrl());
   }

   public String getCallback() {
      return this.callback;
   }

   public String getEncoding() {
      return this.encoding;
   }

   public Object getHandler() {
      return this.handler != null?this.handler:(this.whandler == null?null:this.whandler.get());
   }

   public Object getResult() {
      return this.result;
   }

   public AjaxStatus getStatus() {
      return this.status;
   }

   public Class getType() {
      return this.type;
   }

   public String getUrl() {
      return this.url;
   }

   public Object handler(Object var1, String var2) {
      this.handler = var1;
      this.callback = var2;
      this.whandler = null;
      return this.self();
   }

   public Object header(String var1, String var2) {
      if(this.headers == null) {
         this.headers = new HashMap();
      }

      this.headers.put(var1, var2);
      return this.self();
   }

   public Object headers(Map var1) {
      this.headers = var1;
      return this.self();
   }

   protected boolean isStreamingContent() {
      return File.class.equals(this.type) || XmlPullParser.class.equals(this.type) || InputStream.class.equals(this.type) || XmlDom.class.equals(this.type);
   }

   public Object memCache(boolean var1) {
      this.memCache = var1;
      return this.self();
   }

   protected Object memGet(String var1) {
      return null;
   }

   protected void memPut(String var1, Object var2) {
   }

   public Object method(int var1) {
      this.method = var1;
      return this.self();
   }

   public Object networkUrl(String var1) {
      this.networkUrl = var1;
      return this.self();
   }

   public Object param(String var1, Object var2) {
      if(this.params == null) {
         this.params = new HashMap();
      }

      this.params.put(var1, var2);
      return this.self();
   }

   public Object params(Map var1) {
      this.params = var1;
      return this.self();
   }

   public Object policy(int var1) {
      this.policy = var1;
      return this.self();
   }

   public Object progress(Dialog var1) {
      return this.progress((Object)var1);
   }

   public Object progress(View var1) {
      return this.progress((Object)var1);
   }

   public Object progress(Object var1) {
      if(var1 != null) {
         this.progress = new WeakReference(var1);
      }

      return this.self();
   }

   public Object proxy(String var1, int var2) {
      this.proxy = new HttpHost(var1, var2);
      return this.self();
   }

   public Object proxy(String var1, int var2, String var3, String var4) {
      this.proxy(var1, var2);
      var1 = makeAuthHeader(var3, var4);
      AQUtility.debug("proxy auth", var1);
      return this.header("Proxy-Authorization", var1);
   }

   public Object redirect(boolean var1) {
      this.redirect = var1;
      return this.self();
   }

   public Object refresh(boolean var1) {
      this.refresh = var1;
      return this.self();
   }

   public Object retry(int var1) {
      this.retry = var1;
      return this.self();
   }

   public void run() {
      if(!this.status.getDone()) {
         try {
            this.backgroundWork();
         } catch (Throwable var2) {
            AQUtility.debug(var2);
            this.status.code(-101).done();
         }

         if(!this.status.getReauth()) {
            if(!this.uiCallback) {
               this.afterWork();
               return;
            }

            AQUtility.post(this);
         }

      } else {
         this.afterWork();
      }
   }

   protected void showProgress(final boolean var1) {
      final Object var2;
      if(this.progress == null) {
         var2 = null;
      } else {
         var2 = this.progress.get();
      }

      if(var2 != null) {
         if(!AQUtility.isUIThread()) {
            AQUtility.post(new Runnable() {
               public void run() {
                  Common.showProgress(var2, AbstractAjaxCallback.this.url, var1);
               }
            });
            return;
         }

         Common.showProgress(var2, this.url, var1);
      }

   }

   protected void skip(String var1, Object var2, AjaxStatus var3) {
   }

   public Object targetFile(File var1) {
      this.targetFile = var1;
      return this.self();
   }

   public Object timeout(int var1) {
      this.timeout = var1;
      return this.self();
   }

   protected Object transform(String var1, byte[] var2, AjaxStatus var3) {
      if(this.type == null) {
         return null;
      } else {
         File var4 = var3.getFile();
         Exception var15;
         if(var2 != null) {
            if(this.type.equals(Bitmap.class)) {
               return BitmapFactory.decodeByteArray(var2, 0, var2.length);
            }

            if(this.type.equals(JSONObject.class)) {
               var1 = null;

               String var14;
               label91: {
                  try {
                     var14 = new String(var2, this.encoding);
                  } catch (Exception var10) {
                     var14 = var1;
                     var15 = var10;
                     break label91;
                  }

                  try {
                     JSONObject var16 = (JSONObject)(new JSONTokener(var14)).nextValue();
                     return var16;
                  } catch (Exception var9) {
                     var15 = var9;
                  }
               }

               AQUtility.debug((Throwable)var15);
               AQUtility.debug((Object)var14);
               return null;
            }

            if(this.type.equals(JSONArray.class)) {
               try {
                  JSONArray var13 = (JSONArray)(new JSONTokener(new String(var2, this.encoding))).nextValue();
                  return var13;
               } catch (Exception var5) {
                  AQUtility.debug((Throwable)var5);
                  return null;
               }
            }

            if(this.type.equals(String.class)) {
               if(var3.getSource() == 1) {
                  AQUtility.debug((Object)"network");
                  return this.correctEncoding(var2, this.encoding, var3);
               }

               AQUtility.debug((Object)"file");

               try {
                  var1 = new String(var2, this.encoding);
                  return var1;
               } catch (Exception var6) {
                  AQUtility.debug((Throwable)var6);
                  return null;
               }
            }

            if(this.type.equals(byte[].class)) {
               return var2;
            }

            if(this.transformer != null) {
               return this.transformer.transform(var1, this.type, this.encoding, var2, var3);
            }

            if(st != null) {
               return st.transform(var1, this.type, this.encoding, var2, var3);
            }
         } else if(var4 != null) {
            if(this.type.equals(File.class)) {
               return var4;
            }

            FileInputStream var19;
            if(this.type.equals(XmlDom.class)) {
               label102: {
                  XmlDom var18;
                  try {
                     var19 = new FileInputStream(var4);
                     var18 = new XmlDom(var19);
                  } catch (Exception var12) {
                     var15 = var12;
                     break label102;
                  }

                  try {
                     var3.closeLater(var19);
                     return var18;
                  } catch (Exception var11) {
                     var15 = var11;
                  }
               }

               AQUtility.report(var15);
               return null;
            }

            if(this.type.equals(XmlPullParser.class)) {
               XmlPullParser var20 = Xml.newPullParser();

               try {
                  FileInputStream var17 = new FileInputStream(var4);
                  var20.setInput(var17, this.encoding);
                  var3.closeLater(var17);
                  return var20;
               } catch (Exception var7) {
                  AQUtility.report(var7);
                  return null;
               }
            }

            if(this.type.equals(InputStream.class)) {
               try {
                  var19 = new FileInputStream(var4);
                  var3.closeLater(var19);
                  return var19;
               } catch (Exception var8) {
                  AQUtility.report(var8);
                  return null;
               }
            }
         }

         return null;
      }
   }

   public Object transformer(Transformer var1) {
      this.transformer = var1;
      return this.self();
   }

   public Object type(Class var1) {
      this.type = var1;
      return this.self();
   }

   public Object uiCallback(boolean var1) {
      this.uiCallback = var1;
      return this.self();
   }

   public Object url(String var1) {
      this.url = var1;
      return this.self();
   }

   public Object weakHandler(Object var1, String var2) {
      this.whandler = new WeakReference(var1);
      this.callback = var2;
      this.handler = null;
      return this.self();
   }
}
