package org.apache.http.message;

import java.util.NoSuchElementException;
import org.apache.http.HeaderIterator;
import org.apache.http.ParseException;
import org.apache.http.TokenIterator;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;

@NotThreadSafe
public class BasicTokenIterator implements TokenIterator {
   public static final String HTTP_SEPARATORS = " ,;=()<>@:\\\"/[]?{}\t";
   protected String currentHeader;
   protected String currentToken;
   protected final HeaderIterator headerIt;
   protected int searchPos;

   public BasicTokenIterator(HeaderIterator var1) {
      this.headerIt = (HeaderIterator)Args.notNull(var1, "Header iterator");
      this.searchPos = this.findNext(-1);
   }

   protected String createToken(String var1, int var2, int var3) {
      return var1.substring(var2, var3);
   }

   protected int findNext(int var1) throws ParseException {
      if(var1 < 0) {
         if(!this.headerIt.hasNext()) {
            return -1;
         }

         this.currentHeader = this.headerIt.nextHeader().getValue();
         var1 = 0;
      } else {
         var1 = this.findTokenSeparator(var1);
      }

      var1 = this.findTokenStart(var1);
      if(var1 < 0) {
         this.currentToken = null;
         return -1;
      } else {
         int var2 = this.findTokenEnd(var1);
         this.currentToken = this.createToken(this.currentHeader, var1, var2);
         return var2;
      }
   }

   protected int findTokenEnd(int var1) {
      Args.notNegative(var1, "Search position");
      int var2 = this.currentHeader.length();
      ++var1;

      while(var1 < var2 && this.isTokenChar(this.currentHeader.charAt(var1))) {
         ++var1;
      }

      return var1;
   }

   protected int findTokenSeparator(int var1) {
      var1 = Args.notNegative(var1, "Search position");
      boolean var3 = false;
      int var4 = this.currentHeader.length();

      while(!var3 && var1 < var4) {
         char var2 = this.currentHeader.charAt(var1);
         if(this.isTokenSeparator(var2)) {
            var3 = true;
         } else {
            if(!this.isWhitespace(var2)) {
               if(this.isTokenChar(var2)) {
                  throw new ParseException("Tokens without separator (pos " + var1 + "): " + this.currentHeader);
               }

               throw new ParseException("Invalid character after token (pos " + var1 + "): " + this.currentHeader);
            }

            ++var1;
         }
      }

      return var1;
   }

   protected int findTokenStart(int var1) {
      var1 = Args.notNegative(var1, "Search position");
      boolean var4 = false;

      while(!var4 && this.currentHeader != null) {
         int var6 = this.currentHeader.length();
         int var5 = var1;
         boolean var3 = var4;

         while(!var3 && var5 < var6) {
            char var2 = this.currentHeader.charAt(var5);
            if(!this.isTokenSeparator(var2) && !this.isWhitespace(var2)) {
               if(!this.isTokenChar(this.currentHeader.charAt(var5))) {
                  throw new ParseException("Invalid character before token (pos " + var5 + "): " + this.currentHeader);
               }

               var3 = true;
            } else {
               ++var5;
            }
         }

         var4 = var3;
         var1 = var5;
         if(!var3) {
            if(this.headerIt.hasNext()) {
               this.currentHeader = this.headerIt.nextHeader().getValue();
               var1 = 0;
               var4 = var3;
            } else {
               this.currentHeader = null;
               var4 = var3;
               var1 = var5;
            }
         }
      }

      return var4?var1:-1;
   }

   public boolean hasNext() {
      return this.currentToken != null;
   }

   protected boolean isHttpSeparator(char var1) {
      return " ,;=()<>@:\\\"/[]?{}\t".indexOf(var1) >= 0;
   }

   protected boolean isTokenChar(char var1) {
      if(!Character.isLetterOrDigit(var1)) {
         if(Character.isISOControl(var1)) {
            return false;
         }

         if(this.isHttpSeparator(var1)) {
            return false;
         }
      }

      return true;
   }

   protected boolean isTokenSeparator(char var1) {
      return var1 == 44;
   }

   protected boolean isWhitespace(char var1) {
      return var1 == 9 || Character.isSpaceChar(var1);
   }

   public final Object next() throws NoSuchElementException, ParseException {
      return this.nextToken();
   }

   public String nextToken() throws NoSuchElementException, ParseException {
      if(this.currentToken == null) {
         throw new NoSuchElementException("Iteration already finished.");
      } else {
         String var1 = this.currentToken;
         this.searchPos = this.findNext(this.searchPos);
         return var1;
      }
   }

   public final void remove() throws UnsupportedOperationException {
      throw new UnsupportedOperationException("Removing tokens is not supported.");
   }
}
