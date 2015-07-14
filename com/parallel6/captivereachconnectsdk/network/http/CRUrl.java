package com.parallel6.captivereachconnectsdk.network.http;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.parallel6.captivereachconnectsdk.network.http.CRRestfulAction;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import com.parallel6.captivereachconnectsdk.utils.UrlUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CRUrl implements Parcelable {
   public static final Creator CREATOR = new Creator() {
      public CRUrl createFromParcel(Parcel var1) {
         CRUrl var4 = new CRUrl();
         var4.setHost(var1.readString());
         var4.setPermanent_link(var1.readString());
         var4.setAction((CRRestfulAction)var1.readParcelable(CRRestfulAction.class.getClassLoader()));
         HashMap var5 = new HashMap();
         int var3 = var1.readInt();

         for(int var2 = 0; var2 < var3; ++var2) {
            var5.put(var1.readString(), var1.readString());
         }

         var4.setParams(var5);
         return var4;
      }

      public CRUrl[] newArray(int var1) {
         return new CRUrl[var1];
      }
   };
   private CRRestfulAction action;
   private String host;
   private Context mContext;
   private Map params;
   private String permanent_link;

   public CRUrl() {
   }

   private CRUrl(CRUrl.CRUrlBuilder var1) {
      this.mContext = var1.mContext;
      this.host = var1.host;
      this.permanent_link = var1.permanent_link;
      this.action = var1.action;
      this.params = var1.params;
      if(this.host == null) {
         this.host = SettingsUtils.getBaseRestUrl(this.mContext);
         this.host = UrlUtils.appendHttp(this.host);
      }

      if(this.permanent_link == null) {
         this.permanent_link = "";
      }

      if(this.action == null) {
         this.action = new CRRestfulAction();
      }

      if(this.params == null) {
         this.params = new HashMap();
      }

   }

   // $FF: synthetic method
   CRUrl(CRUrl.CRUrlBuilder var1, Object var2) {
      this(var1);
   }

   public CRUrl(String var1, String var2, CRRestfulAction var3, Map var4) {
      this.host = var1;
      this.permanent_link = var2;
      this.action = var3;
      this.params = var4;
      if(this.action == null) {
         this.action = new CRRestfulAction();
      }

      if(this.params == null) {
         this.params = new HashMap();
      }

   }

   public int describeContents() {
      return 0;
   }

   public String getFullUrl() {
      String var1 = UrlUtils.appendSlash(this.getHost());
      if(var1 == null) {
         return "";
      } else {
         String var2 = var1 + this.getPermanent_link();
         var1 = var2;
         if(this.action != null) {
            var1 = UrlUtils.appendSlash(var2) + this.action.getRestfulAction();
         }

         var2 = var1;
         if(this.params != null) {
            StringBuilder var3 = new StringBuilder();
            Iterator var6 = this.params.keySet().iterator();

            while(var6.hasNext()) {
               String var4 = (String)var6.next();
               String var5 = (String)this.params.get(var4);
               var3.append(var4 + "=" + var5);
               if(var6.hasNext()) {
                  var3.append("&");
               }
            }

            var2 = var1;
            if(var3.length() > 0) {
               var2 = var1 + "?" + var3.toString();
            }
         }

         return var2;
      }
   }

   public String getHost() {
      return this.host;
   }

   public Map getParams() {
      return this.params;
   }

   public String getPermanent_link() {
      return this.permanent_link;
   }

   public CRRestfulAction getRestfulAction() {
      return this.action;
   }

   public void setAction(CRRestfulAction var1) {
      this.action = var1;
   }

   public void setHost(String var1) {
      this.host = var1;
   }

   public void setParams(Map var1) {
      this.params = var1;
   }

   public void setPermanent_link(String var1) {
      this.permanent_link = var1;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.host);
      var1.writeString(this.permanent_link);
      var1.writeParcelable(this.action, var2);
      var1.writeInt(this.params.size());
      Iterator var3 = this.params.keySet().iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         var1.writeString(var4);
         var1.writeString((String)this.params.get(var4));
      }

   }

   public static class CRUrlBuilder {
      private CRRestfulAction action;
      private String host;
      private Context mContext;
      private Map params;
      private String permanent_link;

      public CRUrlBuilder(Context var1) {
         this.mContext = var1;
      }

      public CRUrl build() {
         return new CRUrl(this, null);
      }

      public CRUrl.CRUrlBuilder host(String var1) {
         this.host = var1;
         return this;
      }

      public CRUrl.CRUrlBuilder param(String var1, String var2) {
         if(this.params == null) {
            this.params = new HashMap();
            this.params.put(var1, var2);
         }

         return this;
      }

      public CRUrl.CRUrlBuilder params(Map var1) {
         this.params = var1;
         return this;
      }

      public CRUrl.CRUrlBuilder permanent_link(String var1) {
         this.permanent_link = var1;
         return this;
      }

      public CRUrl.CRUrlBuilder restful_action(CRRestfulAction var1) {
         this.action = var1;
         return this;
      }
   }
}
