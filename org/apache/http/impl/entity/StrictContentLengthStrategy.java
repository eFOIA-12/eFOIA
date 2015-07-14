package org.apache.http.impl.entity;

import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.annotation.Immutable;
import org.apache.http.entity.ContentLengthStrategy;

@Immutable
public class StrictContentLengthStrategy implements ContentLengthStrategy {
   public static final StrictContentLengthStrategy INSTANCE = new StrictContentLengthStrategy();
   private final int implicitLen;

   public StrictContentLengthStrategy() {
      this(-1);
   }

   public StrictContentLengthStrategy(int var1) {
      this.implicitLen = var1;
   }

   public long determineLength(HttpMessage param1) throws HttpException {
      // $FF: Couldn't be decompiled
   }
}
