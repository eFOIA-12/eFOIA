package gov.dhs.mobile.efoia.tasks;

import android.graphics.drawable.Drawable;
import com.parallel6.captivereachconnectsdk.utils.AsyncTask;
import java.io.InputStream;
import java.net.URL;

public class GetBackgroundImageTask extends AsyncTask {
   private Drawable parseResults(Drawable var1) {
      return var1;
   }

   protected Drawable doInBackground(String... var1) {
      try {
         Drawable var3 = Drawable.createFromStream((InputStream)(new URL(var1[0])).getContent(), "src name");
         return var3;
      } catch (Exception var2) {
         return null;
      }
   }
}
