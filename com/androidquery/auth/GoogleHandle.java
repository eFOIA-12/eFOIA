package com.androidquery.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import com.androidquery.AQuery;
import com.androidquery.auth.AccountHandle;
import com.androidquery.callback.AbstractAjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.util.AQUtility;
import org.apache.http.HttpRequest;

public class GoogleHandle extends AccountHandle implements OnClickListener, OnCancelListener {
   private Account acc;
   private Account[] accs;
   private Activity act;
   private AccountManager am;
   private String email;
   private String token;
   private String type;

   public GoogleHandle(Activity var1, String var2, String var3) {
      String var4 = var3;
      if("aq.account".equals(var3)) {
         var4 = getActiveAccount(var1);
      }

      this.act = var1;
      this.type = var2.substring(2);
      this.email = var4;
      this.am = AccountManager.get(var1);
   }

   private void accountDialog() {
      Builder var3 = new Builder(this.act);
      this.accs = this.am.getAccountsByType("com.google");
      int var2 = this.accs.length;
      if(var2 == 1) {
         this.auth(this.accs[0]);
      } else {
         String[] var4 = new String[var2];

         for(int var1 = 0; var1 < var2; ++var1) {
            var4[var1] = this.accs[var1].name;
         }

         var3.setItems(var4, this);
         var3.setOnCancelListener(this);
         AlertDialog var5 = var3.create();
         (new AQuery(this.act)).show(var5);
      }
   }

   private void auth(Account var1) {
      this.acc = var1;
      (new GoogleHandle.Task(null)).execute(new String[0]);
   }

   public static String getActiveAccount(Context var0) {
      return PreferenceManager.getDefaultSharedPreferences(var0).getString("aq.account", (String)null);
   }

   public static void setActiveAccount(Context var0, String var1) {
      PreferenceManager.getDefaultSharedPreferences(var0).edit().putString("aq.account", var1).commit();
   }

   public void applyToken(AbstractAjaxCallback var1, HttpRequest var2) {
      var2.addHeader("Authorization", "GoogleLogin auth=" + this.token);
   }

   protected void auth() {
      if(this.email == null) {
         this.accountDialog();
      } else {
         Account[] var2 = this.am.getAccountsByType("com.google");

         for(int var1 = 0; var1 < var2.length; ++var1) {
            Account var3 = var2[var1];
            if(this.email.equals(var3.name)) {
               this.auth(var3);
               return;
            }
         }
      }

   }

   public boolean authenticated() {
      return this.token != null;
   }

   public boolean expired(AbstractAjaxCallback var1, AjaxStatus var2) {
      int var3 = var2.getCode();
      return var3 == 401 || var3 == 403;
   }

   public String getCacheUrl(String var1) {
      return var1 + "#" + this.token;
   }

   public String getType() {
      return this.type;
   }

   public void onCancel(DialogInterface var1) {
      this.failure(this.act, -102, "cancel");
   }

   public void onClick(DialogInterface var1, int var2) {
      Account var3 = this.accs[var2];
      AQUtility.debug("acc", var3.name);
      setActiveAccount(this.act, var3.name);
      this.auth(var3);
   }

   public boolean reauth(AbstractAjaxCallback var1) {
      this.am.invalidateAuthToken(this.acc.type, this.token);

      try {
         this.token = this.am.blockingGetAuthToken(this.acc, this.type, true);
         AQUtility.debug("re token", this.token);
      } catch (Exception var2) {
         AQUtility.debug((Throwable)var2);
         this.token = null;
      }

      return this.token != null;
   }

   private class Task extends AsyncTask {
      private Task() {
      }

      // $FF: synthetic method
      Task(Object var2) {
         this();
      }

      protected Bundle doInBackground(String... var1) {
         try {
            Bundle var5 = (Bundle)GoogleHandle.this.am.getAuthToken(GoogleHandle.this.acc, GoogleHandle.this.type, (Bundle)null, GoogleHandle.this.act, (AccountManagerCallback)null, (Handler)null).getResult();
            return var5;
         } catch (OperationCanceledException var2) {
            return null;
         } catch (AuthenticatorException var3) {
            AQUtility.debug((Throwable)var3);
            return null;
         } catch (Exception var4) {
            AQUtility.debug((Throwable)var4);
            return null;
         }
      }

      protected void onPostExecute(Bundle var1) {
         if(var1 != null && var1.containsKey("authtoken")) {
            GoogleHandle.this.token = var1.getString("authtoken");
            GoogleHandle.this.success(GoogleHandle.this.act);
         } else {
            GoogleHandle.this.failure(GoogleHandle.this.act, -102, "rejected");
         }
      }
   }
}
