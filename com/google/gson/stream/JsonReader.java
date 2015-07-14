package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class JsonReader implements Closeable {
   private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
   private static final char[] NON_EXECUTE_PREFIX = ")]}\'\n".toCharArray();
   private static final int NUMBER_CHAR_DECIMAL = 3;
   private static final int NUMBER_CHAR_DIGIT = 2;
   private static final int NUMBER_CHAR_EXP_DIGIT = 7;
   private static final int NUMBER_CHAR_EXP_E = 5;
   private static final int NUMBER_CHAR_EXP_SIGN = 6;
   private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
   private static final int NUMBER_CHAR_NONE = 0;
   private static final int NUMBER_CHAR_SIGN = 1;
   private static final int PEEKED_BEGIN_ARRAY = 3;
   private static final int PEEKED_BEGIN_OBJECT = 1;
   private static final int PEEKED_BUFFERED = 11;
   private static final int PEEKED_DOUBLE_QUOTED = 9;
   private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
   private static final int PEEKED_END_ARRAY = 4;
   private static final int PEEKED_END_OBJECT = 2;
   private static final int PEEKED_EOF = 17;
   private static final int PEEKED_FALSE = 6;
   private static final int PEEKED_LONG = 15;
   private static final int PEEKED_NONE = 0;
   private static final int PEEKED_NULL = 7;
   private static final int PEEKED_NUMBER = 16;
   private static final int PEEKED_SINGLE_QUOTED = 8;
   private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
   private static final int PEEKED_TRUE = 5;
   private static final int PEEKED_UNQUOTED = 10;
   private static final int PEEKED_UNQUOTED_NAME = 14;
   private final char[] buffer = new char[1024];
   private final Reader in;
   private boolean lenient = false;
   private int limit = 0;
   private int lineNumber = 0;
   private int lineStart = 0;
   private int[] pathIndices;
   private String[] pathNames;
   private int peeked = 0;
   private long peekedLong;
   private int peekedNumberLength;
   private String peekedString;
   private int pos = 0;
   private int[] stack = new int[32];
   private int stackSize = 0;

   static {
      JsonReaderInternalAccess.INSTANCE = new JsonReaderInternalAccess() {
         public void promoteNameToValue(JsonReader var1) throws IOException {
            if(var1 instanceof JsonTreeReader) {
               ((JsonTreeReader)var1).promoteNameToValue();
            } else {
               int var3 = var1.peeked;
               int var2 = var3;
               if(var3 == 0) {
                  var2 = var1.doPeek();
               }

               if(var2 == 13) {
                  var1.peeked = 9;
               } else if(var2 == 12) {
                  var1.peeked = 8;
               } else if(var2 == 14) {
                  var1.peeked = 10;
               } else {
                  throw new IllegalStateException("Expected a name but was " + var1.peek() + " " + " at line " + var1.getLineNumber() + " column " + var1.getColumnNumber() + " path " + var1.getPath());
               }
            }
         }
      };
   }

   public JsonReader(Reader var1) {
      int[] var3 = this.stack;
      int var2 = this.stackSize;
      this.stackSize = var2 + 1;
      var3[var2] = 6;
      this.pathNames = new String[32];
      this.pathIndices = new int[32];
      if(var1 == null) {
         throw new NullPointerException("in == null");
      } else {
         this.in = var1;
      }
   }

   private void checkLenient() throws IOException {
      if(!this.lenient) {
         throw this.syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
      }
   }

   private void consumeNonExecutePrefix() throws IOException {
      this.nextNonWhitespace(true);
      --this.pos;
      if(this.pos + NON_EXECUTE_PREFIX.length <= this.limit || this.fillBuffer(NON_EXECUTE_PREFIX.length)) {
         int var1 = 0;

         while(true) {
            if(var1 >= NON_EXECUTE_PREFIX.length) {
               this.pos += NON_EXECUTE_PREFIX.length;
               return;
            }

            if(this.buffer[this.pos + var1] != NON_EXECUTE_PREFIX[var1]) {
               break;
            }

            ++var1;
         }
      }

   }

   private int doPeek() throws IOException {
      int var1 = this.stack[this.stackSize - 1];
      int var2;
      if(var1 == 1) {
         this.stack[this.stackSize - 1] = 2;
      } else if(var1 == 2) {
         switch(this.nextNonWhitespace(true)) {
         case 44:
            break;
         case 59:
            this.checkLenient();
            break;
         case 93:
            this.peeked = 4;
            return 4;
         default:
            throw this.syntaxError("Unterminated array");
         }
      } else {
         if(var1 == 3 || var1 == 5) {
            this.stack[this.stackSize - 1] = 4;
            if(var1 == 5) {
               switch(this.nextNonWhitespace(true)) {
               case 44:
                  break;
               case 59:
                  this.checkLenient();
                  break;
               case 125:
                  this.peeked = 2;
                  return 2;
               default:
                  throw this.syntaxError("Unterminated object");
               }
            }

            var2 = this.nextNonWhitespace(true);
            switch(var2) {
            case 34:
               this.peeked = 13;
               return 13;
            case 39:
               this.checkLenient();
               this.peeked = 12;
               return 12;
            case 125:
               if(var1 != 5) {
                  this.peeked = 2;
                  return 2;
               }

               throw this.syntaxError("Expected name");
            default:
               this.checkLenient();
               --this.pos;
               if(this.isLiteral((char)var2)) {
                  this.peeked = 14;
                  return 14;
               }

               throw this.syntaxError("Expected name");
            }
         }

         if(var1 == 4) {
            this.stack[this.stackSize - 1] = 5;
            switch(this.nextNonWhitespace(true)) {
            case 58:
               break;
            case 59:
            case 60:
            default:
               throw this.syntaxError("Expected \':\'");
            case 61:
               this.checkLenient();
               if((this.pos < this.limit || this.fillBuffer(1)) && this.buffer[this.pos] == 62) {
                  ++this.pos;
               }
            }
         } else if(var1 == 6) {
            if(this.lenient) {
               this.consumeNonExecutePrefix();
            }

            this.stack[this.stackSize - 1] = 7;
         } else if(var1 == 7) {
            if(this.nextNonWhitespace(false) == -1) {
               this.peeked = 17;
               return 17;
            }

            this.checkLenient();
            --this.pos;
         } else if(var1 == 8) {
            throw new IllegalStateException("JsonReader is closed");
         }
      }

      switch(this.nextNonWhitespace(true)) {
      case 34:
         if(this.stackSize == 1) {
            this.checkLenient();
         }

         this.peeked = 9;
         return 9;
      case 39:
         this.checkLenient();
         this.peeked = 8;
         return 8;
      case 91:
         this.peeked = 3;
         return 3;
      case 93:
         if(var1 == 1) {
            this.peeked = 4;
            return 4;
         }
      case 44:
      case 59:
         if(var1 != 1 && var1 != 2) {
            throw this.syntaxError("Unexpected value");
         }

         this.checkLenient();
         --this.pos;
         this.peeked = 7;
         return 7;
      case 123:
         this.peeked = 1;
         return 1;
      default:
         --this.pos;
         if(this.stackSize == 1) {
            this.checkLenient();
         }

         var1 = this.peekKeyword();
         if(var1 == 0) {
            var2 = this.peekNumber();
            var1 = var2;
            if(var2 == 0) {
               if(!this.isLiteral(this.buffer[this.pos])) {
                  throw this.syntaxError("Expected value");
               }

               this.checkLenient();
               this.peeked = 10;
               return 10;
            }
         }

         return var1;
      }
   }

   private boolean fillBuffer(int var1) throws IOException {
      boolean var4 = false;
      char[] var5 = this.buffer;
      this.lineStart -= this.pos;
      if(this.limit != this.pos) {
         this.limit -= this.pos;
         System.arraycopy(var5, this.pos, var5, 0, this.limit);
      } else {
         this.limit = 0;
      }

      this.pos = 0;

      boolean var3;
      while(true) {
         int var2 = this.in.read(var5, this.limit, var5.length - this.limit);
         var3 = var4;
         if(var2 == -1) {
            break;
         }

         this.limit += var2;
         var2 = var1;
         if(this.lineNumber == 0) {
            var2 = var1;
            if(this.lineStart == 0) {
               var2 = var1;
               if(this.limit > 0) {
                  var2 = var1;
                  if(var5[0] == '\ufeff') {
                     ++this.pos;
                     ++this.lineStart;
                     var2 = var1 + 1;
                  }
               }
            }
         }

         var1 = var2;
         if(this.limit >= var2) {
            var3 = true;
            break;
         }
      }

      return var3;
   }

   private int getColumnNumber() {
      return this.pos - this.lineStart + 1;
   }

   private int getLineNumber() {
      return this.lineNumber + 1;
   }

   private boolean isLiteral(char var1) throws IOException {
      switch(var1) {
      case '#':
      case '/':
      case ';':
      case '=':
      case '\\':
         this.checkLenient();
      case '\t':
      case '\n':
      case '\f':
      case '\r':
      case ' ':
      case ',':
      case ':':
      case '[':
      case ']':
      case '{':
      case '}':
         return false;
      default:
         return true;
      }
   }

   private int nextNonWhitespace(boolean var1) throws IOException {
      char[] var7 = this.buffer;
      int var2 = this.pos;
      int var3 = this.limit;

      while(true) {
         int var4 = var3;
         int var5 = var2;
         if(var2 == var3) {
            this.pos = var2;
            if(!this.fillBuffer(1)) {
               if(var1) {
                  throw new EOFException("End of input at line " + this.getLineNumber() + " column " + this.getColumnNumber());
               }

               return -1;
            }

            var5 = this.pos;
            var4 = this.limit;
         }

         var2 = var5 + 1;
         char var8 = var7[var5];
         if(var8 == 10) {
            ++this.lineNumber;
            this.lineStart = var2;
            var3 = var4;
         } else if(var8 != 32 && var8 != 13) {
            if(var8 == 9) {
               var3 = var4;
            } else if(var8 == 47) {
               this.pos = var2;
               if(var2 == var4) {
                  --this.pos;
                  boolean var6 = this.fillBuffer(2);
                  ++this.pos;
                  if(!var6) {
                     return var8;
                  }
               }

               this.checkLenient();
               switch(var7[this.pos]) {
               case '*':
                  ++this.pos;
                  if(!this.skipTo("*/")) {
                     throw this.syntaxError("Unterminated comment");
                  }

                  var2 = this.pos + 2;
                  var3 = this.limit;
                  break;
               case '/':
                  ++this.pos;
                  this.skipToEndOfLine();
                  var2 = this.pos;
                  var3 = this.limit;
                  break;
               default:
                  return var8;
               }
            } else {
               if(var8 != 35) {
                  this.pos = var2;
                  return var8;
               }

               this.pos = var2;
               this.checkLenient();
               this.skipToEndOfLine();
               var2 = this.pos;
               var3 = this.limit;
            }
         } else {
            var3 = var4;
         }
      }
   }

   private String nextQuotedValue(char var1) throws IOException {
      char[] var9 = this.buffer;
      StringBuilder var10 = new StringBuilder();

      do {
         int var2 = this.pos;
         int var5 = this.limit;

         int var3;
         int var4;
         for(var4 = var2; var2 < var5; var4 = var3) {
            int var7 = var2 + 1;
            char var8 = var9[var2];
            if(var8 == var1) {
               this.pos = var7;
               var10.append(var9, var4, var7 - var4 - 1);
               return var10.toString();
            }

            int var6;
            if(var8 == 92) {
               this.pos = var7;
               var10.append(var9, var4, var7 - var4 - 1);
               var10.append(this.readEscapeCharacter());
               var2 = this.pos;
               var6 = this.limit;
               var3 = var2;
            } else {
               var6 = var5;
               var2 = var7;
               var3 = var4;
               if(var8 == 10) {
                  ++this.lineNumber;
                  this.lineStart = var7;
                  var6 = var5;
                  var2 = var7;
                  var3 = var4;
               }
            }

            var5 = var6;
         }

         var10.append(var9, var4, var2 - var4);
         this.pos = var2;
      } while(this.fillBuffer(1));

      throw this.syntaxError("Unterminated string");
   }

   private String nextUnquotedValue() throws IOException {
      StringBuilder var3 = null;
      int var1 = 0;

      int var2;
      StringBuilder var4;
      label34:
      while(true) {
         if(this.pos + var1 < this.limit) {
            var4 = var3;
            var2 = var1;
            switch(this.buffer[this.pos + var1]) {
            case '\t':
            case '\n':
            case '\f':
            case '\r':
            case ' ':
            case ',':
            case ':':
            case '[':
            case ']':
            case '{':
            case '}':
               break label34;
            case '#':
            case '/':
            case ';':
            case '=':
            case '\\':
               this.checkLenient();
               var2 = var1;
               var4 = var3;
               break label34;
            default:
               ++var1;
            }
         } else if(var1 < this.buffer.length) {
            var4 = var3;
            var2 = var1;
            if(this.fillBuffer(var1 + 1)) {
               continue;
            }
            break;
         } else {
            var4 = var3;
            if(var3 == null) {
               var4 = new StringBuilder();
            }

            var4.append(this.buffer, this.pos, var1);
            this.pos += var1;
            var2 = 0;
            var1 = 0;
            var3 = var4;
            if(!this.fillBuffer(1)) {
               break;
            }
         }
      }

      String var5;
      if(var4 == null) {
         var5 = new String(this.buffer, this.pos, var2);
      } else {
         var4.append(this.buffer, this.pos, var2);
         var5 = var4.toString();
      }

      this.pos += var2;
      return var5;
   }

   private int peekKeyword() throws IOException {
      char var1 = this.buffer[this.pos];
      String var5;
      String var6;
      byte var7;
      if(var1 != 116 && var1 != 84) {
         if(var1 != 102 && var1 != 70) {
            if(var1 != 110 && var1 != 78) {
               return 0;
            }

            var5 = "null";
            var6 = "NULL";
            var7 = 7;
         } else {
            var5 = "false";
            var6 = "FALSE";
            var7 = 6;
         }
      } else {
         var5 = "true";
         var6 = "TRUE";
         var7 = 5;
      }

      int var3 = var5.length();

      for(int var2 = 1; var2 < var3; ++var2) {
         if(this.pos + var2 >= this.limit && !this.fillBuffer(var2 + 1)) {
            return 0;
         }

         char var4 = this.buffer[this.pos + var2];
         if(var4 != var5.charAt(var2) && var4 != var6.charAt(var2)) {
            return 0;
         }
      }

      if((this.pos + var3 < this.limit || this.fillBuffer(var3 + 1)) && this.isLiteral(this.buffer[this.pos + var3])) {
         return 0;
      } else {
         this.pos += var3;
         this.peeked = var7;
         return var7;
      }
   }

   private int peekNumber() throws IOException {
      char[] var15 = this.buffer;
      int var2 = this.pos;
      int var9 = this.limit;
      long var11 = 0L;
      boolean var3 = false;
      boolean var5 = true;
      byte var8 = 0;
      int var4 = 0;

      label119:
      while(true) {
         int var7 = var9;
         int var6 = var2;
         if(var2 + var4 == var9) {
            if(var4 == var15.length) {
               return 0;
            }

            if(!this.fillBuffer(var4 + 1)) {
               break;
            }

            var6 = this.pos;
            var7 = this.limit;
         }

         char var1 = var15[var6 + var4];
         boolean var10;
         long var13;
         byte var16;
         boolean var18;
         switch(var1) {
         case '+':
            if(var8 != 5) {
               return 0;
            }

            var16 = 6;
            var18 = var5;
            var10 = var3;
            var13 = var11;
            break;
         case '-':
            if(var8 == 0) {
               var10 = true;
               var16 = 1;
               var13 = var11;
               var18 = var5;
            } else {
               if(var8 != 5) {
                  return 0;
               }

               var16 = 6;
               var18 = var5;
               var10 = var3;
               var13 = var11;
            }
            break;
         case '.':
            if(var8 != 2) {
               return 0;
            }

            var16 = 3;
            var18 = var5;
            var10 = var3;
            var13 = var11;
            break;
         case 'E':
         case 'e':
            if(var8 != 2 && var8 != 4) {
               return 0;
            }

            var16 = 5;
            var18 = var5;
            var10 = var3;
            var13 = var11;
            break;
         default:
            if(var1 < 48 || var1 > 57) {
               if(this.isLiteral(var1)) {
                  return 0;
               }
               break label119;
            }

            if(var8 != 1 && var8 != 0) {
               if(var8 == 2) {
                  if(var11 == 0L) {
                     return 0;
                  }

                  var13 = 10L * var11 - (long)(var1 - 48);
                  boolean var17;
                  if(var11 <= -922337203685477580L && (var11 != -922337203685477580L || var13 >= var11)) {
                     var17 = false;
                  } else {
                     var17 = true;
                  }

                  var18 = var5 & var17;
                  var16 = var8;
                  var10 = var3;
               } else if(var8 == 3) {
                  var16 = 4;
                  var18 = var5;
                  var10 = var3;
                  var13 = var11;
               } else {
                  label95: {
                     if(var8 != 5) {
                        var18 = var5;
                        var16 = var8;
                        var10 = var3;
                        var13 = var11;
                        if(var8 != 6) {
                           break label95;
                        }
                     }

                     var16 = 7;
                     var18 = var5;
                     var10 = var3;
                     var13 = var11;
                  }
               }
            } else {
               var13 = (long)(-(var1 - 48));
               var16 = 2;
               var18 = var5;
               var10 = var3;
            }
         }

         ++var4;
         var5 = var18;
         var9 = var7;
         var8 = var16;
         var3 = var10;
         var2 = var6;
         var11 = var13;
      }

      if(var8 == 2 && var5 && (var11 != Long.MIN_VALUE || var3)) {
         if(!var3) {
            var11 = -var11;
         }

         this.peekedLong = var11;
         this.pos += var4;
         this.peeked = 15;
         return 15;
      } else if(var8 != 2 && var8 != 4 && var8 != 7) {
         return 0;
      } else {
         this.peekedNumberLength = var4;
         this.peeked = 16;
         return 16;
      }
   }

   private void push(int var1) {
      int[] var3;
      if(this.stackSize == this.stack.length) {
         var3 = new int[this.stackSize * 2];
         int[] var4 = new int[this.stackSize * 2];
         String[] var5 = new String[this.stackSize * 2];
         System.arraycopy(this.stack, 0, var3, 0, this.stackSize);
         System.arraycopy(this.pathIndices, 0, var4, 0, this.stackSize);
         System.arraycopy(this.pathNames, 0, var5, 0, this.stackSize);
         this.stack = var3;
         this.pathIndices = var4;
         this.pathNames = var5;
      }

      var3 = this.stack;
      int var2 = this.stackSize;
      this.stackSize = var2 + 1;
      var3[var2] = var1;
   }

   private char readEscapeCharacter() throws IOException {
      if(this.pos == this.limit && !this.fillBuffer(1)) {
         throw this.syntaxError("Unterminated escape sequence");
      } else {
         char[] var6 = this.buffer;
         int var2 = this.pos;
         this.pos = var2 + 1;
         char var1 = var6[var2];
         switch(var1) {
         case '\n':
            ++this.lineNumber;
            this.lineStart = this.pos;
         default:
            return var1;
         case 'b':
            return '\b';
         case 'f':
            return '\f';
         case 'n':
            return '\n';
         case 'r':
            return '\r';
         case 't':
            return '\t';
         case 'u':
            if(this.pos + 4 > this.limit && !this.fillBuffer(4)) {
               throw this.syntaxError("Unterminated escape sequence");
            } else {
               var1 = 0;
               int var3 = this.pos;

               for(var2 = var3; var2 < var3 + 4; ++var2) {
                  char var4 = this.buffer[var2];
                  char var5 = (char)(var1 << 4);
                  if(var4 >= 48 && var4 <= 57) {
                     var1 = (char)(var4 - 48 + var5);
                  } else if(var4 >= 97 && var4 <= 102) {
                     var1 = (char)(var4 - 97 + 10 + var5);
                  } else {
                     if(var4 < 65 || var4 > 70) {
                        throw new NumberFormatException("\\u" + new String(this.buffer, this.pos, 4));
                     }

                     var1 = (char)(var4 - 65 + 10 + var5);
                  }
               }

               this.pos += 4;
               return var1;
            }
         }
      }
   }

   private void skipQuotedValue(char var1) throws IOException {
      char[] var7 = this.buffer;

      do {
         int var2 = this.pos;

         int var4;
         for(int var3 = this.limit; var2 < var3; var3 = var4) {
            int var5 = var2 + 1;
            char var6 = var7[var2];
            if(var6 == var1) {
               this.pos = var5;
               return;
            }

            if(var6 == 92) {
               this.pos = var5;
               this.readEscapeCharacter();
               var2 = this.pos;
               var4 = this.limit;
            } else {
               var4 = var3;
               var2 = var5;
               if(var6 == 10) {
                  ++this.lineNumber;
                  this.lineStart = var5;
                  var4 = var3;
                  var2 = var5;
               }
            }
         }

         this.pos = var2;
      } while(this.fillBuffer(1));

      throw this.syntaxError("Unterminated string");
   }

   private boolean skipTo(String var1) throws IOException {
      label27:
      for(; this.pos + var1.length() <= this.limit || this.fillBuffer(var1.length()); ++this.pos) {
         if(this.buffer[this.pos] == 10) {
            ++this.lineNumber;
            this.lineStart = this.pos + 1;
         } else {
            for(int var2 = 0; var2 < var1.length(); ++var2) {
               if(this.buffer[this.pos + var2] != var1.charAt(var2)) {
                  continue label27;
               }
            }

            return true;
         }
      }

      return false;
   }

   private void skipToEndOfLine() throws IOException {
      while(this.pos < this.limit || this.fillBuffer(1)) {
         char[] var2 = this.buffer;
         int var1 = this.pos;
         this.pos = var1 + 1;
         char var3 = var2[var1];
         if(var3 != 10) {
            if(var3 != 13) {
               continue;
            }

            return;
         }

         ++this.lineNumber;
         this.lineStart = this.pos;
         break;
      }

   }

   private void skipUnquotedValue() throws IOException {
      do {
         int var1 = 0;

         while(this.pos + var1 < this.limit) {
            switch(this.buffer[this.pos + var1]) {
            case '#':
            case '/':
            case ';':
            case '=':
            case '\\':
               this.checkLenient();
            case '\t':
            case '\n':
            case '\f':
            case '\r':
            case ' ':
            case ',':
            case ':':
            case '[':
            case ']':
            case '{':
            case '}':
               this.pos += var1;
               return;
            default:
               ++var1;
            }
         }

         this.pos += var1;
      } while(this.fillBuffer(1));

   }

   private IOException syntaxError(String var1) throws IOException {
      throw new MalformedJsonException(var1 + " at line " + this.getLineNumber() + " column " + this.getColumnNumber() + " path " + this.getPath());
   }

   public void beginArray() throws IOException {
      int var2 = this.peeked;
      int var1 = var2;
      if(var2 == 0) {
         var1 = this.doPeek();
      }

      if(var1 == 3) {
         this.push(1);
         this.pathIndices[this.stackSize - 1] = 0;
         this.peeked = 0;
      } else {
         throw new IllegalStateException("Expected BEGIN_ARRAY but was " + this.peek() + " at line " + this.getLineNumber() + " column " + this.getColumnNumber() + " path " + this.getPath());
      }
   }

   public void beginObject() throws IOException {
      int var2 = this.peeked;
      int var1 = var2;
      if(var2 == 0) {
         var1 = this.doPeek();
      }

      if(var1 == 1) {
         this.push(3);
         this.peeked = 0;
      } else {
         throw new IllegalStateException("Expected BEGIN_OBJECT but was " + this.peek() + " at line " + this.getLineNumber() + " column " + this.getColumnNumber() + " path " + this.getPath());
      }
   }

   public void close() throws IOException {
      this.peeked = 0;
      this.stack[0] = 8;
      this.stackSize = 1;
      this.in.close();
   }

   public void endArray() throws IOException {
      int var2 = this.peeked;
      int var1 = var2;
      if(var2 == 0) {
         var1 = this.doPeek();
      }

      if(var1 == 4) {
         --this.stackSize;
         int[] var3 = this.pathIndices;
         var1 = this.stackSize - 1;
         ++var3[var1];
         this.peeked = 0;
      } else {
         throw new IllegalStateException("Expected END_ARRAY but was " + this.peek() + " at line " + this.getLineNumber() + " column " + this.getColumnNumber() + " path " + this.getPath());
      }
   }

   public void endObject() throws IOException {
      int var2 = this.peeked;
      int var1 = var2;
      if(var2 == 0) {
         var1 = this.doPeek();
      }

      if(var1 == 2) {
         --this.stackSize;
         this.pathNames[this.stackSize] = null;
         int[] var3 = this.pathIndices;
         var1 = this.stackSize - 1;
         ++var3[var1];
         this.peeked = 0;
      } else {
         throw new IllegalStateException("Expected END_OBJECT but was " + this.peek() + " at line " + this.getLineNumber() + " column " + this.getColumnNumber() + " path " + this.getPath());
      }
   }

   public String getPath() {
      StringBuilder var3 = (new StringBuilder()).append('$');
      int var1 = 0;

      for(int var2 = this.stackSize; var1 < var2; ++var1) {
         switch(this.stack[var1]) {
         case 1:
         case 2:
            var3.append('[').append(this.pathIndices[var1]).append(']');
            break;
         case 3:
         case 4:
         case 5:
            var3.append('.');
            if(this.pathNames[var1] != null) {
               var3.append(this.pathNames[var1]);
            }
         }
      }

      return var3.toString();
   }

   public boolean hasNext() throws IOException {
      int var2 = this.peeked;
      int var1 = var2;
      if(var2 == 0) {
         var1 = this.doPeek();
      }

      return var1 != 2 && var1 != 4;
   }

   public final boolean isLenient() {
      return this.lenient;
   }

   public boolean nextBoolean() throws IOException {
      int var2 = this.peeked;
      int var1 = var2;
      if(var2 == 0) {
         var1 = this.doPeek();
      }

      int[] var3;
      if(var1 == 5) {
         this.peeked = 0;
         var3 = this.pathIndices;
         var1 = this.stackSize - 1;
         ++var3[var1];
         return true;
      } else if(var1 == 6) {
         this.peeked = 0;
         var3 = this.pathIndices;
         var1 = this.stackSize - 1;
         ++var3[var1];
         return false;
      } else {
         throw new IllegalStateException("Expected a boolean but was " + this.peek() + " at line " + this.getLineNumber() + " column " + this.getColumnNumber() + " path " + this.getPath());
      }
   }

   public double nextDouble() throws IOException {
      int var5 = this.peeked;
      int var4 = var5;
      if(var5 == 0) {
         var4 = this.doPeek();
      }

      int[] var6;
      if(var4 == 15) {
         this.peeked = 0;
         var6 = this.pathIndices;
         var4 = this.stackSize - 1;
         ++var6[var4];
         return (double)this.peekedLong;
      } else {
         if(var4 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
         } else if(var4 != 8 && var4 != 9) {
            if(var4 == 10) {
               this.peekedString = this.nextUnquotedValue();
            } else if(var4 != 11) {
               throw new IllegalStateException("Expected a double but was " + this.peek() + " at line " + this.getLineNumber() + " column " + this.getColumnNumber() + " path " + this.getPath());
            }
         } else {
            char var1;
            if(var4 == 8) {
               var1 = 39;
            } else {
               var1 = 34;
            }

            this.peekedString = this.nextQuotedValue(var1);
         }

         this.peeked = 11;
         double var2 = Double.parseDouble(this.peekedString);
         if(!this.lenient && (Double.isNaN(var2) || Double.isInfinite(var2))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + var2 + " at line " + this.getLineNumber() + " column " + this.getColumnNumber() + " path " + this.getPath());
         } else {
            this.peekedString = null;
            this.peeked = 0;
            var6 = this.pathIndices;
            var4 = this.stackSize - 1;
            ++var6[var4];
            return var2;
         }
      }
   }

   public int nextInt() throws IOException {
      int var5 = this.peeked;
      int var4 = var5;
      if(var5 == 0) {
         var4 = this.doPeek();
      }

      int[] var6;
      if(var4 == 15) {
         var4 = (int)this.peekedLong;
         if(this.peekedLong != (long)var4) {
            throw new NumberFormatException("Expected an int but was " + this.peekedLong + " at line " + this.getLineNumber() + " column " + this.getColumnNumber() + " path " + this.getPath());
         } else {
            this.peeked = 0;
            var6 = this.pathIndices;
            var5 = this.stackSize - 1;
            ++var6[var5];
            return var4;
         }
      } else {
         if(var4 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
         } else {
            label52: {
               if(var4 != 8 && var4 != 9) {
                  throw new IllegalStateException("Expected an int but was " + this.peek() + " at line " + this.getLineNumber() + " column " + this.getColumnNumber() + " path " + this.getPath());
               }

               char var1;
               if(var4 == 8) {
                  var1 = 39;
               } else {
                  var1 = 34;
               }

               this.peekedString = this.nextQuotedValue(var1);

               try {
                  var4 = Integer.parseInt(this.peekedString);
                  this.peeked = 0;
                  var6 = this.pathIndices;
                  var5 = this.stackSize - 1;
               } catch (NumberFormatException var7) {
                  break label52;
               }

               ++var6[var5];
               return var4;
            }
         }

         this.peeked = 11;
         double var2 = Double.parseDouble(this.peekedString);
         var4 = (int)var2;
         if((double)var4 != var2) {
            throw new NumberFormatException("Expected an int but was " + this.peekedString + " at line " + this.getLineNumber() + " column " + this.getColumnNumber() + " path " + this.getPath());
         } else {
            this.peekedString = null;
            this.peeked = 0;
            var6 = this.pathIndices;
            var5 = this.stackSize - 1;
            ++var6[var5];
            return var4;
         }
      }
   }

   public long nextLong() throws IOException {
      int var5 = this.peeked;
      int var4 = var5;
      if(var5 == 0) {
         var4 = this.doPeek();
      }

      int[] var8;
      if(var4 == 15) {
         this.peeked = 0;
         var8 = this.pathIndices;
         var4 = this.stackSize - 1;
         ++var8[var4];
         return this.peekedLong;
      } else {
         long var6;
         if(var4 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
         } else {
            label48: {
               if(var4 != 8 && var4 != 9) {
                  throw new IllegalStateException("Expected a long but was " + this.peek() + " at line " + this.getLineNumber() + " column " + this.getColumnNumber() + " path " + this.getPath());
               }

               char var1;
               if(var4 == 8) {
                  var1 = 39;
               } else {
                  var1 = 34;
               }

               this.peekedString = this.nextQuotedValue(var1);

               try {
                  var6 = Long.parseLong(this.peekedString);
                  this.peeked = 0;
                  var8 = this.pathIndices;
                  var4 = this.stackSize - 1;
               } catch (NumberFormatException var9) {
                  break label48;
               }

               ++var8[var4];
               return var6;
            }
         }

         this.peeked = 11;
         double var2 = Double.parseDouble(this.peekedString);
         var6 = (long)var2;
         if((double)var6 != var2) {
            throw new NumberFormatException("Expected a long but was " + this.peekedString + " at line " + this.getLineNumber() + " column " + this.getColumnNumber() + " path " + this.getPath());
         } else {
            this.peekedString = null;
            this.peeked = 0;
            var8 = this.pathIndices;
            var4 = this.stackSize - 1;
            ++var8[var4];
            return var6;
         }
      }
   }

   public String nextName() throws IOException {
      int var2 = this.peeked;
      int var1 = var2;
      if(var2 == 0) {
         var1 = this.doPeek();
      }

      String var3;
      if(var1 == 14) {
         var3 = this.nextUnquotedValue();
      } else if(var1 == 12) {
         var3 = this.nextQuotedValue('\'');
      } else {
         if(var1 != 13) {
            throw new IllegalStateException("Expected a name but was " + this.peek() + " at line " + this.getLineNumber() + " column " + this.getColumnNumber() + " path " + this.getPath());
         }

         var3 = this.nextQuotedValue('\"');
      }

      this.peeked = 0;
      this.pathNames[this.stackSize - 1] = var3;
      return var3;
   }

   public void nextNull() throws IOException {
      int var2 = this.peeked;
      int var1 = var2;
      if(var2 == 0) {
         var1 = this.doPeek();
      }

      if(var1 == 7) {
         this.peeked = 0;
         int[] var3 = this.pathIndices;
         var1 = this.stackSize - 1;
         ++var3[var1];
      } else {
         throw new IllegalStateException("Expected null but was " + this.peek() + " at line " + this.getLineNumber() + " column " + this.getColumnNumber() + " path " + this.getPath());
      }
   }

   public String nextString() throws IOException {
      int var2 = this.peeked;
      int var1 = var2;
      if(var2 == 0) {
         var1 = this.doPeek();
      }

      String var3;
      if(var1 == 10) {
         var3 = this.nextUnquotedValue();
      } else if(var1 == 8) {
         var3 = this.nextQuotedValue('\'');
      } else if(var1 == 9) {
         var3 = this.nextQuotedValue('\"');
      } else if(var1 == 11) {
         var3 = this.peekedString;
         this.peekedString = null;
      } else if(var1 == 15) {
         var3 = Long.toString(this.peekedLong);
      } else {
         if(var1 != 16) {
            throw new IllegalStateException("Expected a string but was " + this.peek() + " at line " + this.getLineNumber() + " column " + this.getColumnNumber() + " path " + this.getPath());
         }

         var3 = new String(this.buffer, this.pos, this.peekedNumberLength);
         this.pos += this.peekedNumberLength;
      }

      this.peeked = 0;
      int[] var4 = this.pathIndices;
      var1 = this.stackSize - 1;
      ++var4[var1];
      return var3;
   }

   public JsonToken peek() throws IOException {
      int var2 = this.peeked;
      int var1 = var2;
      if(var2 == 0) {
         var1 = this.doPeek();
      }

      switch(var1) {
      case 1:
         return JsonToken.BEGIN_OBJECT;
      case 2:
         return JsonToken.END_OBJECT;
      case 3:
         return JsonToken.BEGIN_ARRAY;
      case 4:
         return JsonToken.END_ARRAY;
      case 5:
      case 6:
         return JsonToken.BOOLEAN;
      case 7:
         return JsonToken.NULL;
      case 8:
      case 9:
      case 10:
      case 11:
         return JsonToken.STRING;
      case 12:
      case 13:
      case 14:
         return JsonToken.NAME;
      case 15:
      case 16:
         return JsonToken.NUMBER;
      case 17:
         return JsonToken.END_DOCUMENT;
      default:
         throw new AssertionError();
      }
   }

   public final void setLenient(boolean var1) {
      this.lenient = var1;
   }

   public void skipValue() throws IOException {
      int var2 = 0;

      int var1;
      do {
         var1 = this.peeked;
         int var3 = var1;
         if(var1 == 0) {
            var3 = this.doPeek();
         }

         if(var3 == 3) {
            this.push(1);
            var1 = var2 + 1;
         } else if(var3 == 1) {
            this.push(3);
            var1 = var2 + 1;
         } else if(var3 == 4) {
            --this.stackSize;
            var1 = var2 - 1;
         } else if(var3 == 2) {
            --this.stackSize;
            var1 = var2 - 1;
         } else if(var3 != 14 && var3 != 10) {
            if(var3 != 8 && var3 != 12) {
               if(var3 != 9 && var3 != 13) {
                  var1 = var2;
                  if(var3 == 16) {
                     this.pos += this.peekedNumberLength;
                     var1 = var2;
                  }
               } else {
                  this.skipQuotedValue('\"');
                  var1 = var2;
               }
            } else {
               this.skipQuotedValue('\'');
               var1 = var2;
            }
         } else {
            this.skipUnquotedValue();
            var1 = var2;
         }

         this.peeked = 0;
         var2 = var1;
      } while(var1 != 0);

      int[] var4 = this.pathIndices;
      var1 = this.stackSize - 1;
      ++var4[var1];
      this.pathNames[this.stackSize - 1] = "null";
   }

   public String toString() {
      return this.getClass().getSimpleName() + " at line " + this.getLineNumber() + " column " + this.getColumnNumber();
   }
}
