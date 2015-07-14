package gov.dhs.mobile.efoia.tasks;

import android.util.Log;
import com.parallel6.captivereachconnectsdk.utils.AsyncTask;
import gov.dhs.mobile.efoia.datastructures.Submission;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class SubmitFOIATask extends AsyncTask {
   String responseString = "";

   private Boolean parseResults(String var1) {
      return new Boolean(var1.contains("Thank You for your FOIA Submission"));
   }

   protected Boolean doInBackground(Submission... var1) {
      Submission var6 = var1[0];

      try {
         String var7 = var6.serializeSubmission("*************************************************************************");
         String var2 = "multipart/form-data; boundary=" + "*************************************************************************";
         DefaultHttpClient var3 = new DefaultHttpClient();
         HttpPost var4 = new HttpPost("http://www.dhs.gov/dhs-foia-request-submission-form");
         var4.setHeader("Connection", "Keep-Alive");
         var4.setHeader("User-Agent", "Android Multipart HTTP Client 1.0");
         var4.setHeader("Content-Type", var2);
         var4.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
         var4.setHeader("Accept-Language", "en-US,en;q=0.8");
         var4.setHeader("Cache-Control", "max-age=0");
         var4.setHeader("Connection", "keep-alive");
         var4.setHeader("DNT", "1");
         var4.setHeader("Host", "www.dhs.gov");
         var4.setHeader("Origin", "http://www.dhs.gov");
         var4.setHeader("Referer", "http://www.dhs.gov/dhs-foia-request-submission-form");
         var4.setHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.118 Safari/537.36");
         var4.setEntity(new StringEntity(var7));
         this.responseString = EntityUtils.toString(var3.execute(var4).getEntity());
         Log.e(this.getClass().getName(), this.responseString);
      } catch (Exception var5) {
         var5.printStackTrace();
      }

      return this.parseResults(this.responseString);
   }
}
