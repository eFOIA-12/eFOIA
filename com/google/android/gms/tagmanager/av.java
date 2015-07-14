package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.bh;
import com.google.android.gms.tagmanager.bm;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

class av implements bm {
   private HttpClient arD;

   private InputStream a(HttpClient var1, HttpResponse var2) throws IOException {
      int var3 = var2.getStatusLine().getStatusCode();
      if(var3 == 200) {
         bh.V("Success response");
         return var2.getEntity().getContent();
      } else {
         String var4 = "Bad response: " + var3;
         if(var3 == 404) {
            throw new FileNotFoundException(var4);
         } else {
            throw new IOException(var4);
         }
      }
   }

   private void a(HttpClient var1) {
      if(var1 != null && var1.getConnectionManager() != null) {
         var1.getConnectionManager().shutdown();
      }

   }

   public InputStream cF(String var1) throws IOException {
      this.arD = this.pM();
      HttpResponse var2 = this.arD.execute(new HttpGet(var1));
      return this.a(this.arD, var2);
   }

   public void close() {
      this.a(this.arD);
   }

   HttpClient pM() {
      BasicHttpParams var1 = new BasicHttpParams();
      HttpConnectionParams.setConnectionTimeout(var1, 20000);
      HttpConnectionParams.setSoTimeout(var1, 20000);
      return new DefaultHttpClient(var1);
   }
}
