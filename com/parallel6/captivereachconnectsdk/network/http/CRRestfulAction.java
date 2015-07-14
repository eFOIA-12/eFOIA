package com.parallel6.captivereachconnectsdk.network.http;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.parallel6.captivereachconnectsdk.enums.HttpMethod;
import com.parallel6.captivereachconnectsdk.enums.RestfulAction;
import com.parallel6.captivereachconnectsdk.utils.StringUtils;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;

public class CRRestfulAction implements Parcelable {
   public static final Creator CREATOR = new Creator() {
      public CRRestfulAction createFromParcel(Parcel var1) {
         CRRestfulAction var2 = new CRRestfulAction();
         var2.setRestfulAction((RestfulAction)var1.readSerializable());
         var2.setHttpMethod((HttpMethod)var1.readSerializable());
         var2.setBody(var1.readString());
         return var2;
      }

      public CRRestfulAction[] newArray(int var1) {
         return new CRRestfulAction[var1];
      }
   };
   private RestfulAction action;
   private HttpEntity body;
   private HttpMethod httpMethod;
   private String strBody;

   public CRRestfulAction() {
      this.action = RestfulAction.NONE;
      this.httpMethod = HttpMethod.GET;
   }

   public CRRestfulAction(RestfulAction var1, HttpMethod var2, String var3) {
      this.action = var1;
      this.httpMethod = var2;
      this.strBody = var3;
      this.setBody(var3);
   }

   public int describeContents() {
      return 0;
   }

   public HttpEntity getBody() {
      return this.body;
   }

   public HttpMethod getHttpMethod() {
      return this.httpMethod;
   }

   public String getRestfulAction() {
      return this.action.getValue();
   }

   public void setBody(String var1) {
      if(!StringUtils.isEmpty(var1)) {
         try {
            this.strBody = var1;
            this.body = new StringEntity(this.strBody, "UTF-8");
         } catch (UnsupportedEncodingException var3) {
            var3.printStackTrace();
            Log.e(CRRestfulAction.class.getSimpleName(), "Error while creating entity with body: " + var1 + ", error: " + var3);
         }
      }
   }

   public void setBody(HttpEntity var1) {
      this.body = var1;
   }

   public void setHttpMethod(HttpMethod var1) {
      this.httpMethod = var1;
   }

   public void setRestfulAction(RestfulAction var1) {
      this.action = var1;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeSerializable(this.action);
      var1.writeSerializable(this.httpMethod);
      var1.writeString(this.strBody);
   }
}
