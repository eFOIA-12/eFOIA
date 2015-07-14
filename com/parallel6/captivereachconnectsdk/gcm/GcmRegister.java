package com.parallel6.captivereachconnectsdk.gcm;

import android.content.Context;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.parallel6.captivereachconnectsdk.log.LogDeviceInformation;
import com.parallel6.captivereachconnectsdk.log.LogEntry;
import com.parallel6.captivereachconnectsdk.log.LogRequest;
import com.parallel6.captivereachconnectsdk.log.LogTask;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.captivereachconnectsdk.utils.AsyncTask;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import java.io.IOException;

public class GcmRegister extends AsyncTask {
   private Context context;
   private GoogleCloudMessaging gcm;
   private TaskListener listener;

   public GcmRegister(Context var1, TaskListener var2) {
      this.context = var1;
      this.listener = var2;
      this.gcm = GoogleCloudMessaging.getInstance(var1);
   }

   protected String doInBackground(Void... var1) {
      String var4;
      try {
         var4 = this.gcm.register(new String[]{SettingsUtils.getGcmSenderId(this.context)});
      } catch (IOException var3) {
         LogRequest var2 = new LogRequest();
         var2.setDevice_information(new LogDeviceInformation(this.context));
         var2.setEntry(new LogEntry());
         var2.getEntry().setTag("GCM Register");
         var2.getEntry().setMessage("Error registering GCM id: " + var3.toString());
         (new LogTask(this.context, var2)).execute(new Void[0]);
         var4 = "PENDING";
      }

      SettingsUtils.setPushId(this.context, var4);
      return var4;
   }

   protected void onPostExecute(String var1) {
      super.onPostExecute(var1);
      if(this.listener != null) {
         this.listener.onTaskSuccess(var1);
      }

   }
}
