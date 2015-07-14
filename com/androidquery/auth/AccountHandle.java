package com.androidquery.auth;

import android.content.Context;
import com.androidquery.callback.AbstractAjaxCallback;
import com.androidquery.callback.AjaxStatus;
import java.net.HttpURLConnection;
import java.util.LinkedHashSet;
import org.apache.http.HttpRequest;

public abstract class AccountHandle {
   private LinkedHashSet callbacks;

   public void applyToken(AbstractAjaxCallback var1, HttpURLConnection var2) {
   }

   public void applyToken(AbstractAjaxCallback var1, HttpRequest var2) {
   }

   protected abstract void auth();

   public void auth(AbstractAjaxCallback var1) {
      synchronized(this){}

      try {
         if(this.callbacks == null) {
            this.callbacks = new LinkedHashSet();
            this.callbacks.add(var1);
            this.auth();
         } else {
            this.callbacks.add(var1);
         }
      } finally {
         ;
      }

   }

   public abstract boolean authenticated();

   public abstract boolean expired(AbstractAjaxCallback var1, AjaxStatus var2);

   protected void failure(Context param1, int param2, String param3) {
      // $FF: Couldn't be decompiled
   }

   public String getCacheUrl(String var1) {
      return var1;
   }

   public String getNetworkUrl(String var1) {
      return var1;
   }

   public abstract boolean reauth(AbstractAjaxCallback var1);

   protected void success(Context param1) {
      // $FF: Couldn't be decompiled
   }

   public void unauth() {
   }
}
