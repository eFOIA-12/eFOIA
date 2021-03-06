package org.apache.http.impl;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpResponse;
import org.apache.http.TokenIterator;
import org.apache.http.annotation.Immutable;
import org.apache.http.message.BasicTokenIterator;
import org.apache.http.protocol.HttpContext;

@Immutable
public class DefaultConnectionReuseStrategy implements ConnectionReuseStrategy {
   public static final DefaultConnectionReuseStrategy INSTANCE = new DefaultConnectionReuseStrategy();

   private boolean canResponseHaveBody(HttpResponse var1) {
      int var2 = var1.getStatusLine().getStatusCode();
      return var2 >= 200 && var2 != 204 && var2 != 304 && var2 != 205;
   }

   protected TokenIterator createTokenIterator(HeaderIterator var1) {
      return new BasicTokenIterator(var1);
   }

   public boolean keepAlive(HttpResponse param1, HttpContext param2) {
      // $FF: Couldn't be decompiled
   }
}
