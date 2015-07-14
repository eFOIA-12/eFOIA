package gov.dhs.mobile.efoia.tasks;

import com.parallel6.captivereachconnectsdk.utils.AsyncTask;

public class GetFormIDTask extends AsyncTask {
   String cookie;

   protected String doInBackground(Void... param1) {
      // $FF: Couldn't be decompiled
   }

   protected void onPostExecute(String var1) {
      super.onPostExecute(var1);
      this.cookie = var1;
   }
}
