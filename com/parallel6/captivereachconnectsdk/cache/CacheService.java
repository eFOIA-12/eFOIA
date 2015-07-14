package com.parallel6.captivereachconnectsdk.cache;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Log;
import com.parallel6.captivereachconnectsdk.cache.CRDynamicContentDao;
import com.parallel6.captivereachconnectsdk.cache.CRSendContentDao;
import com.parallel6.captivereachconnectsdk.cache.CacheUrl;
import com.parallel6.captivereachconnectsdk.network.http.CRUrl;
import com.parallel6.captivereachconnectsdk.network.request.CaptiveReachMultiRequest;
import com.parallel6.captivereachconnectsdk.network.request.NetworkHelper;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.captivereachconnectsdk.utils.AsyncTask;
import com.parallel6.captivereachconnectsdk.utils.JSonUtils;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import com.parallel6.captivereachconnectsdk.utils.StringUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;

public class CacheService extends Service {
   public static final String KEY_PERMANENT_LINKS = "permanent_links";
   private static final int MAX_CACHE = 500;
   public static final String TAG = CacheService.class.getSimpleName();
   private CacheService.CacheTask cacheTask;
   private CRUrl[] links;
   private String[] permanent_links;
   private CacheService.SaveDBTask saveDBTask;
   private CacheService.SendDataTask sendDataTask;
   private String[] urls;

   private void stop() {
      SettingsUtils.setCacheRunning(this, Boolean.valueOf(false));
      this.stopSelf();
   }

   public IBinder onBind(Intent var1) {
      throw null;
   }

   public void onCreate() {
      super.onCreate();
      (new CRDynamicContentDao(this)).clearDatabase();
   }

   public void onDestroy() {
      super.onDestroy();
      if(this.sendDataTask != null) {
         this.sendDataTask.cancel(true);
      }

      if(this.cacheTask != null) {
         this.cacheTask.cancel(true);
      }

      if(this.saveDBTask != null) {
         this.saveDBTask.cancel(true);
      }

   }

   public int onStartCommand(Intent var1, int var2, int var3) {
      Log.d(TAG, "onStartCommand()");
      if(var1 != null) {
         Parcelable[] var4 = var1.getParcelableArrayExtra("permanent_links");
         if(var4 != null) {
            this.links = (CRUrl[])Arrays.copyOf(var4, var4.length, CRUrl[].class);
            this.urls = new String[this.links.length];
            this.permanent_links = new String[this.links.length];

            for(var2 = 0; var2 < this.urls.length; ++var2) {
               if(this.links[var2] != null) {
                  this.urls[var2] = this.links[var2].getFullUrl();
                  this.permanent_links[var2] = this.links[var2].getPermanent_link();
               }
            }
         }
      }

      this.sendDataTask = new CacheService.SendDataTask(null);
      this.sendDataTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      return 2;
   }

   private class CacheTask extends CaptiveReachMultiRequest {
      private int i = -1;

      public CacheTask(Context var2, TaskListener var3) {
         super(var2, "GET", (String)null, var3);
      }

      protected HttpEntity getHttpEntity() throws IOException {
         return CacheService.this.links[this.i].getRestfulAction().getBody();
      }

      protected String getHttpMethod() {
         ++this.i;
         String var2 = CacheService.this.links[this.i].getRestfulAction().getHttpMethod().getValue();
         String var1 = var2;
         if(StringUtils.isEmpty(var2)) {
            var1 = "GET";
         }

         return var1;
      }

      protected String[] getKeyUrl() {
         return CacheService.this.permanent_links;
      }

      protected String[] getRequestUrl() {
         return CacheService.this.urls;
      }

      protected String parseResponse(Map var1) throws Exception {
         if(!this.isCancelled()) {
            CacheService.this.saveDBTask = CacheService.this.new SaveDBTask(null);
            CacheService.this.saveDBTask.execute(new Map[]{var1});
         }

         return null;
      }
   }

   private class SaveDBTask extends AsyncTask {
      private SaveDBTask() {
      }

      // $FF: synthetic method
      SaveDBTask(Object var2) {
         this();
      }

      protected Void doInBackground(Map... var1) {
         if(!this.isCancelled()) {
            Set var3 = var1[0].keySet();
            CRDynamicContentDao var2 = new CRDynamicContentDao(CacheService.this);
            Iterator var6 = var3.iterator();

            while(var6.hasNext()) {
               String var4 = (String)var6.next();
               NetworkHelper.Result var5 = (NetworkHelper.Result)var1[0].get(var4);
               if(var5.isSuccess()) {
                  var2.insertData(var4, JSonUtils.getCRJsonString(var5.getJSONResponse()), var5.getETag());
               }
            }
         }

         return null;
      }

      protected void onPostExecute(Void var1) {
         super.onPostExecute(var1);
         CacheService.this.stop();
      }

      protected void onPreExecute() {
         super.onPreExecute();
         CacheService.this.cacheTask = null;
      }
   }

   private class SendDataTask extends AsyncTask {
      private SendDataTask() {
      }

      // $FF: synthetic method
      SendDataTask(Object var2) {
         this();
      }

      protected Void doInBackground(Void... var1) {
         CRSendContentDao var4 = new CRSendContentDao(CacheService.this);
         Iterator var5 = var4.getAll(false).iterator();

         while(var5.hasNext()) {
            CacheUrl var6 = (CacheUrl)var5.next();
            NetworkHelper.Result var8 = null;
            Object var3 = null;
            StringEntity var2 = (StringEntity)var3;
            if(StringUtils.isNotEmpty(var6.getJson())) {
               try {
                  var2 = new StringEntity(var6.getJson());
               } catch (UnsupportedEncodingException var7) {
                  Log.e(CacheService.TAG, "" + var7);
                  var2 = (StringEntity)var3;
               }
            }

            if(var6.getHttpMethod().equals("POST")) {
               var8 = NetworkHelper.post(CacheService.this, var6.getPath(), var2, false);
            } else if(var6.getHttpMethod().equals("PUT")) {
               var8 = NetworkHelper.put(CacheService.this, var6.getPath(), var2, false);
            } else if(var6.getHttpMethod().equals("DELETE")) {
               var8 = NetworkHelper.delete(CacheService.this, var6.getPath(), var2);
            }

            if(var8 != null && var8.isSuccess()) {
               var4.update(var6, true);
            }
         }

         var4.deleteAll(true);
         return null;
      }

      protected void onPostExecute(Void var1) {
         super.onPostExecute(var1);
         CacheService.this.cacheTask = CacheService.this.new CacheTask(CacheService.this, (TaskListener)null);
         CacheService.this.cacheTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      }
   }
}
