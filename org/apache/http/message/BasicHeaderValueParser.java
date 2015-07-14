package org.apache.http.message;

import java.util.ArrayList;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.annotation.Immutable;
import org.apache.http.message.BasicHeaderElement;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.HeaderValueParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@Immutable
public class BasicHeaderValueParser implements HeaderValueParser {
   private static final char[] ALL_DELIMITERS = new char[]{';', ','};
   @Deprecated
   public static final BasicHeaderValueParser DEFAULT = new BasicHeaderValueParser();
   private static final char ELEM_DELIMITER = ',';
   public static final BasicHeaderValueParser INSTANCE = new BasicHeaderValueParser();
   private static final char PARAM_DELIMITER = ';';

   private static boolean isOneOf(char var0, char[] var1) {
      if(var1 != null) {
         int var3 = var1.length;

         for(int var2 = 0; var2 < var3; ++var2) {
            if(var0 == var1[var2]) {
               return true;
            }
         }
      }

      return false;
   }

   public static HeaderElement[] parseElements(String var0, HeaderValueParser var1) throws ParseException {
      Args.notNull(var0, "Value");
      CharArrayBuffer var2 = new CharArrayBuffer(var0.length());
      var2.append(var0);
      ParserCursor var3 = new ParserCursor(0, var0.length());
      if(var1 == null) {
         var1 = INSTANCE;
      }

      return ((HeaderValueParser)var1).parseElements(var2, var3);
   }

   public static HeaderElement parseHeaderElement(String var0, HeaderValueParser var1) throws ParseException {
      Args.notNull(var0, "Value");
      CharArrayBuffer var2 = new CharArrayBuffer(var0.length());
      var2.append(var0);
      ParserCursor var3 = new ParserCursor(0, var0.length());
      if(var1 == null) {
         var1 = INSTANCE;
      }

      return ((HeaderValueParser)var1).parseHeaderElement(var2, var3);
   }

   public static NameValuePair parseNameValuePair(String var0, HeaderValueParser var1) throws ParseException {
      Args.notNull(var0, "Value");
      CharArrayBuffer var2 = new CharArrayBuffer(var0.length());
      var2.append(var0);
      ParserCursor var3 = new ParserCursor(0, var0.length());
      if(var1 == null) {
         var1 = INSTANCE;
      }

      return ((HeaderValueParser)var1).parseNameValuePair(var2, var3);
   }

   public static NameValuePair[] parseParameters(String var0, HeaderValueParser var1) throws ParseException {
      Args.notNull(var0, "Value");
      CharArrayBuffer var2 = new CharArrayBuffer(var0.length());
      var2.append(var0);
      ParserCursor var3 = new ParserCursor(0, var0.length());
      if(var1 == null) {
         var1 = INSTANCE;
      }

      return ((HeaderValueParser)var1).parseParameters(var2, var3);
   }

   protected HeaderElement createHeaderElement(String var1, String var2, NameValuePair[] var3) {
      return new BasicHeaderElement(var1, var2, var3);
   }

   protected NameValuePair createNameValuePair(String var1, String var2) {
      return new BasicNameValuePair(var1, var2);
   }

   public HeaderElement[] parseElements(CharArrayBuffer var1, ParserCursor var2) {
      Args.notNull(var1, "Char array buffer");
      Args.notNull(var2, "Parser cursor");
      ArrayList var3 = new ArrayList();

      while(!var2.atEnd()) {
         HeaderElement var4 = this.parseHeaderElement(var1, var2);
         if(var4.getName().length() != 0 || var4.getValue() != null) {
            var3.add(var4);
         }
      }

      return (HeaderElement[])var3.toArray(new HeaderElement[var3.size()]);
   }

   public HeaderElement parseHeaderElement(CharArrayBuffer var1, ParserCursor var2) {
      Args.notNull(var1, "Char array buffer");
      Args.notNull(var2, "Parser cursor");
      NameValuePair var5 = this.parseNameValuePair(var1, var2);
      Object var4 = null;
      NameValuePair[] var3 = (NameValuePair[])var4;
      if(!var2.atEnd()) {
         var3 = (NameValuePair[])var4;
         if(var1.charAt(var2.getPos() - 1) != 44) {
            var3 = this.parseParameters(var1, var2);
         }
      }

      return this.createHeaderElement(var5.getName(), var5.getValue(), var3);
   }

   public NameValuePair parseNameValuePair(CharArrayBuffer var1, ParserCursor var2) {
      return this.parseNameValuePair(var1, var2, ALL_DELIMITERS);
   }

   public NameValuePair parseNameValuePair(CharArrayBuffer var1, ParserCursor var2, char[] var3) {
      Args.notNull(var1, "Char array buffer");
      Args.notNull(var2, "Parser cursor");
      boolean var7 = false;
      int var5 = var2.getPos();
      int var8 = var2.getPos();
      int var12 = var2.getUpperBound();

      char var4;
      boolean var6;
      while(true) {
         var6 = var7;
         if(var5 >= var12) {
            break;
         }

         var4 = var1.charAt(var5);
         if(var4 == 61) {
            var6 = var7;
            break;
         }

         if(isOneOf(var4, var3)) {
            var6 = true;
            break;
         }

         ++var5;
      }

      String var13;
      if(var5 == var12) {
         var6 = true;
         var13 = var1.substringTrimmed(var8, var12);
      } else {
         var13 = var1.substringTrimmed(var8, var5);
         ++var5;
      }

      if(var6) {
         var2.updatePos(var5);
         return this.createNameValuePair(var13, (String)null);
      } else {
         int var9 = var5;
         boolean var11 = false;
         boolean var10 = false;

         boolean var16;
         while(true) {
            var16 = var6;
            if(var5 >= var12) {
               break;
            }

            var4 = var1.charAt(var5);
            var7 = var11;
            if(var4 == 34) {
               var7 = var11;
               if(!var10) {
                  if(!var11) {
                     var7 = true;
                  } else {
                     var7 = false;
                  }
               }
            }

            if(!var7 && !var10 && isOneOf(var4, var3)) {
               var16 = true;
               break;
            }

            if(var10) {
               var16 = false;
            } else if(var7 && var4 == 92) {
               var16 = true;
            } else {
               var16 = false;
            }

            ++var5;
            var10 = var16;
            var11 = var7;
         }

         int var18 = var5;
         int var15 = var9;

         int var17;
         while(true) {
            var17 = var18;
            if(var15 >= var18) {
               break;
            }

            var17 = var18;
            if(!HTTP.isWhitespace(var1.charAt(var15))) {
               break;
            }

            ++var15;
         }

         while(var17 > var15 && HTTP.isWhitespace(var1.charAt(var17 - 1))) {
            --var17;
         }

         var18 = var15;
         var9 = var17;
         if(var17 - var15 >= 2) {
            var18 = var15;
            var9 = var17;
            if(var1.charAt(var15) == 34) {
               var18 = var15;
               var9 = var17;
               if(var1.charAt(var17 - 1) == 34) {
                  var18 = var15 + 1;
                  var9 = var17 - 1;
               }
            }
         }

         String var14 = var1.substring(var18, var9);
         var15 = var5;
         if(var16) {
            var15 = var5 + 1;
         }

         var2.updatePos(var15);
         return this.createNameValuePair(var13, var14);
      }
   }

   public NameValuePair[] parseParameters(CharArrayBuffer var1, ParserCursor var2) {
      Args.notNull(var1, "Char array buffer");
      Args.notNull(var2, "Parser cursor");
      int var3 = var2.getPos();

      for(int var4 = var2.getUpperBound(); var3 < var4 && HTTP.isWhitespace(var1.charAt(var3)); ++var3) {
         ;
      }

      var2.updatePos(var3);
      if(var2.atEnd()) {
         return new NameValuePair[0];
      } else {
         ArrayList var5 = new ArrayList();

         while(!var2.atEnd()) {
            var5.add(this.parseNameValuePair(var1, var2));
            if(var1.charAt(var2.getPos() - 1) == 44) {
               break;
            }
         }

         return (NameValuePair[])var5.toArray(new NameValuePair[var5.size()]);
      }
   }
}
