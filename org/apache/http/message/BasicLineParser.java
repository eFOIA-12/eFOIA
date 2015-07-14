package org.apache.http.message;

import org.apache.http.Header;
import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.annotation.Immutable;
import org.apache.http.message.BasicRequestLine;
import org.apache.http.message.BasicStatusLine;
import org.apache.http.message.BufferedHeader;
import org.apache.http.message.LineParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@Immutable
public class BasicLineParser implements LineParser {
   @Deprecated
   public static final BasicLineParser DEFAULT = new BasicLineParser();
   public static final BasicLineParser INSTANCE = new BasicLineParser();
   protected final ProtocolVersion protocol;

   public BasicLineParser() {
      this((ProtocolVersion)null);
   }

   public BasicLineParser(ProtocolVersion var1) {
      if(var1 == null) {
         var1 = HttpVersion.HTTP_1_1;
      }

      this.protocol = (ProtocolVersion)var1;
   }

   public static Header parseHeader(String var0, LineParser var1) throws ParseException {
      Args.notNull(var0, "Value");
      CharArrayBuffer var2 = new CharArrayBuffer(var0.length());
      var2.append(var0);
      if(var1 == null) {
         var1 = INSTANCE;
      }

      return ((LineParser)var1).parseHeader(var2);
   }

   public static ProtocolVersion parseProtocolVersion(String var0, LineParser var1) throws ParseException {
      Args.notNull(var0, "Value");
      CharArrayBuffer var2 = new CharArrayBuffer(var0.length());
      var2.append(var0);
      ParserCursor var3 = new ParserCursor(0, var0.length());
      if(var1 == null) {
         var1 = INSTANCE;
      }

      return ((LineParser)var1).parseProtocolVersion(var2, var3);
   }

   public static RequestLine parseRequestLine(String var0, LineParser var1) throws ParseException {
      Args.notNull(var0, "Value");
      CharArrayBuffer var2 = new CharArrayBuffer(var0.length());
      var2.append(var0);
      ParserCursor var3 = new ParserCursor(0, var0.length());
      if(var1 == null) {
         var1 = INSTANCE;
      }

      return ((LineParser)var1).parseRequestLine(var2, var3);
   }

   public static StatusLine parseStatusLine(String var0, LineParser var1) throws ParseException {
      Args.notNull(var0, "Value");
      CharArrayBuffer var2 = new CharArrayBuffer(var0.length());
      var2.append(var0);
      ParserCursor var3 = new ParserCursor(0, var0.length());
      if(var1 == null) {
         var1 = INSTANCE;
      }

      return ((LineParser)var1).parseStatusLine(var2, var3);
   }

   protected ProtocolVersion createProtocolVersion(int var1, int var2) {
      return this.protocol.forVersion(var1, var2);
   }

   protected RequestLine createRequestLine(String var1, String var2, ProtocolVersion var3) {
      return new BasicRequestLine(var1, var2, var3);
   }

   protected StatusLine createStatusLine(ProtocolVersion var1, int var2, String var3) {
      return new BasicStatusLine(var1, var2, var3);
   }

   public boolean hasProtocolVersion(CharArrayBuffer var1, ParserCursor var2) {
      Args.notNull(var1, "Char array buffer");
      Args.notNull(var2, "Parser cursor");
      int var4 = var2.getPos();
      String var8 = this.protocol.getProtocol();
      int var5 = var8.length();
      if(var1.length() >= var5 + 4) {
         int var3;
         if(var4 < 0) {
            var3 = var1.length() - 4 - var5;
         } else {
            var3 = var4;
            if(var4 == 0) {
               while(true) {
                  var3 = var4;
                  if(var4 >= var1.length()) {
                     break;
                  }

                  var3 = var4;
                  if(!HTTP.isWhitespace(var1.charAt(var4))) {
                     break;
                  }

                  ++var4;
               }
            }
         }

         if(var3 + var5 + 4 <= var1.length()) {
            boolean var6 = true;

            for(var4 = 0; var6 && var4 < var5; ++var4) {
               if(var1.charAt(var3 + var4) == var8.charAt(var4)) {
                  var6 = true;
               } else {
                  var6 = false;
               }
            }

            boolean var7 = var6;
            if(var6) {
               if(var1.charAt(var3 + var5) == 47) {
                  var7 = true;
               } else {
                  var7 = false;
               }
            }

            return var7;
         }
      }

      return false;
   }

   public Header parseHeader(CharArrayBuffer var1) throws ParseException {
      return new BufferedHeader(var1);
   }

   public ProtocolVersion parseProtocolVersion(CharArrayBuffer var1, ParserCursor var2) throws ParseException {
      Args.notNull(var1, "Char array buffer");
      Args.notNull(var2, "Parser cursor");
      String var9 = this.protocol.getProtocol();
      int var7 = var9.length();
      int var6 = var2.getPos();
      int var5 = var2.getUpperBound();
      this.skipWhitespace(var1, var2);
      int var8 = var2.getPos();
      if(var8 + var7 + 4 > var5) {
         throw new ParseException("Not a valid protocol version: " + var1.substring(var6, var5));
      } else {
         boolean var3 = true;

         int var4;
         for(var4 = 0; var3 && var4 < var7; ++var4) {
            if(var1.charAt(var8 + var4) == var9.charAt(var4)) {
               var3 = true;
            } else {
               var3 = false;
            }
         }

         boolean var13 = var3;
         if(var3) {
            if(var1.charAt(var8 + var7) == 47) {
               var13 = true;
            } else {
               var13 = false;
            }
         }

         if(!var13) {
            throw new ParseException("Not a valid protocol version: " + var1.substring(var6, var5));
         } else {
            var4 = var8 + var7 + 1;
            int var12 = var1.indexOf(46, var4, var5);
            if(var12 == -1) {
               throw new ParseException("Invalid protocol version number: " + var1.substring(var6, var5));
            } else {
               try {
                  var7 = Integer.parseInt(var1.substringTrimmed(var4, var12));
               } catch (NumberFormatException var11) {
                  throw new ParseException("Invalid protocol major version number: " + var1.substring(var6, var5));
               }

               var8 = var12 + 1;
               var4 = var1.indexOf(32, var8, var5);
               var12 = var4;
               if(var4 == -1) {
                  var12 = var5;
               }

               try {
                  var4 = Integer.parseInt(var1.substringTrimmed(var8, var12));
               } catch (NumberFormatException var10) {
                  throw new ParseException("Invalid protocol minor version number: " + var1.substring(var6, var5));
               }

               var2.updatePos(var12);
               return this.createProtocolVersion(var7, var4);
            }
         }
      }
   }

   public RequestLine parseRequestLine(CharArrayBuffer param1, ParserCursor param2) throws ParseException {
      // $FF: Couldn't be decompiled
   }

   public StatusLine parseStatusLine(CharArrayBuffer param1, ParserCursor param2) throws ParseException {
      // $FF: Couldn't be decompiled
   }

   protected void skipWhitespace(CharArrayBuffer var1, ParserCursor var2) {
      int var3 = var2.getPos();

      for(int var4 = var2.getUpperBound(); var3 < var4 && HTTP.isWhitespace(var1.charAt(var3)); ++var3) {
         ;
      }

      var2.updatePos(var3);
   }
}
