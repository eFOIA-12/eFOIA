package gov.dhs.mobile.efoia.tasks;

import com.parallel6.captivereachconnectsdk.utils.AsyncTask;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class RetrieveFormIDTask extends AsyncTask {
   String responseString = "";

   private String findDrupalFormId(String var1) {
      String[] var2 = var1.split("<input type=\"hidden\" name=\"form_build_id\" value=\"");
      return var2.length >= 1?var2[1].split("\"")[0]:"";
   }

   protected String doInBackground(Void... var1) {
      try {
         this.responseString = EntityUtils.toString((new DefaultHttpClient()).execute(new HttpGet("http://www.dhs.gov/dhs-foia-request-submission-form")).getEntity());
      } catch (Exception var2) {
         var2.printStackTrace();
      }

      return this.findDrupalFormId(this.responseString);
   }
}
