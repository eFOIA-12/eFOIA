package org.apache.http.impl.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.MessageConstraintException;
import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.config.MessageConstraints;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.LineParser;
import org.apache.http.params.HttpParamConfig;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
public abstract class AbstractMessageParser implements HttpMessageParser {
   private static final int HEADERS = 1;
   private static final int HEAD_LINE = 0;
   private final List headerLines;
   protected final LineParser lineParser;
   private HttpMessage message;
   private final MessageConstraints messageConstraints;
   private final SessionInputBuffer sessionBuffer;
   private int state;

   public AbstractMessageParser(SessionInputBuffer var1, LineParser var2, MessageConstraints var3) {
      this.sessionBuffer = (SessionInputBuffer)Args.notNull(var1, "Session input buffer");
      if(var2 == null) {
         var2 = BasicLineParser.INSTANCE;
      }

      this.lineParser = (LineParser)var2;
      if(var3 == null) {
         var3 = MessageConstraints.DEFAULT;
      }

      this.messageConstraints = var3;
      this.headerLines = new ArrayList();
      this.state = 0;
   }

   @Deprecated
   public AbstractMessageParser(SessionInputBuffer var1, LineParser var2, HttpParams var3) {
      Args.notNull(var1, "Session input buffer");
      Args.notNull(var3, "HTTP parameters");
      this.sessionBuffer = var1;
      this.messageConstraints = HttpParamConfig.getMessageConstraints(var3);
      if(var2 == null) {
         var2 = BasicLineParser.INSTANCE;
      }

      this.lineParser = (LineParser)var2;
      this.headerLines = new ArrayList();
      this.state = 0;
   }

   public static Header[] parseHeaders(SessionInputBuffer var0, int var1, int var2, LineParser var3) throws HttpException, IOException {
      ArrayList var4 = new ArrayList();
      if(var3 == null) {
         var3 = BasicLineParser.INSTANCE;
      }

      return parseHeaders(var0, var1, var2, (LineParser)var3, var4);
   }

   public static Header[] parseHeaders(SessionInputBuffer var0, int var1, int var2, LineParser var3, List var4) throws HttpException, IOException {
      Args.notNull(var0, "Session input buffer");
      Args.notNull(var3, "Line parser");
      Args.notNull(var4, "Header line list");
      CharArrayBuffer var8 = null;
      CharArrayBuffer var9 = null;

      while(true) {
         CharArrayBuffer var7;
         if(var8 == null) {
            var7 = new CharArrayBuffer(64);
         } else {
            var8.clear();
            var7 = var8;
         }

         if(var0.readLine(var7) == -1 || var7.length() < 1) {
            Header[] var12 = new Header[var4.size()];

            for(var1 = 0; var1 < var4.size(); ++var1) {
               var7 = (CharArrayBuffer)var4.get(var1);

               try {
                  var12[var1] = var3.parseHeader(var7);
               } catch (ParseException var11) {
                  throw new ProtocolException(var11.getMessage());
               }
            }

            return var12;
         }

         CharArrayBuffer var10;
         if((var7.charAt(0) == 32 || var7.charAt(0) == 9) && var9 != null) {
            int var5;
            for(var5 = 0; var5 < var7.length(); ++var5) {
               char var6 = var7.charAt(var5);
               if(var6 != 32 && var6 != 9) {
                  break;
               }
            }

            if(var2 > 0 && var9.length() + 1 + var7.length() - var5 > var2) {
               throw new MessageConstraintException("Maximum line length limit exceeded");
            }

            var9.append(' ');
            var9.append(var7, var5, var7.length() - var5);
            var10 = var9;
         } else {
            var4.add(var7);
            var10 = var7;
            var7 = null;
         }

         var8 = var7;
         var9 = var10;
         if(var1 > 0) {
            var8 = var7;
            var9 = var10;
            if(var4.size() >= var1) {
               throw new MessageConstraintException("Maximum header count exceeded");
            }
         }
      }
   }

   public HttpMessage parse() throws IOException, HttpException {
      switch(this.state) {
      case 0:
         try {
            this.message = this.parseHead(this.sessionBuffer);
         } catch (ParseException var2) {
            throw new ProtocolException(var2.getMessage(), var2);
         }

         this.state = 1;
      case 1:
         Header[] var1 = parseHeaders(this.sessionBuffer, this.messageConstraints.getMaxHeaderCount(), this.messageConstraints.getMaxLineLength(), this.lineParser, this.headerLines);
         this.message.setHeaders(var1);
         HttpMessage var3 = this.message;
         this.message = null;
         this.headerLines.clear();
         this.state = 0;
         return var3;
      default:
         throw new IllegalStateException("Inconsistent parser state");
      }
   }

   protected abstract HttpMessage parseHead(SessionInputBuffer var1) throws IOException, HttpException, ParseException;
}
