package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.bm;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class aw implements bm {
   private HttpURLConnection arE;

   private InputStream a(HttpURLConnection var1) throws IOException {
      int var2 = var1.getResponseCode();
      if(var2 == 200) {
         return var1.getInputStream();
      } else {
         String var3 = "Bad response: " + var2;
         if(var2 == 404) {
            throw new FileNotFoundException(var3);
         } else {
            throw new IOException(var3);
         }
      }
   }

   private void b(HttpURLConnection var1) {
      if(var1 != null) {
         var1.disconnect();
      }

   }

   public InputStream cF(String var1) throws IOException {
      this.arE = this.cG(var1);
      return this.a(this.arE);
   }

   HttpURLConnection cG(String var1) throws IOException {
      HttpURLConnection var2 = (HttpURLConnection)(new URL(var1)).openConnection();
      var2.setReadTimeout(20000);
      var2.setConnectTimeout(20000);
      return var2;
   }

   public void close() {
      this.b(this.arE);
   }
}
