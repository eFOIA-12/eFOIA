package org.apache.http.message;

import java.util.NoSuchElementException;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;

@NotThreadSafe
public class BasicHeaderIterator implements HeaderIterator {
   protected final Header[] allHeaders;
   protected int currentIndex;
   protected String headerName;

   public BasicHeaderIterator(Header[] var1, String var2) {
      this.allHeaders = (Header[])Args.notNull(var1, "Header array");
      this.headerName = var2;
      this.currentIndex = this.findNext(-1);
   }

   protected boolean filterHeader(int var1) {
      return this.headerName == null || this.headerName.equalsIgnoreCase(this.allHeaders[var1].getName());
   }

   protected int findNext(int var1) {
      if(var1 >= -1) {
         int var2 = this.allHeaders.length;

         boolean var3;
         for(var3 = false; !var3 && var1 < var2 - 1; var3 = this.filterHeader(var1)) {
            ++var1;
         }

         if(var3) {
            return var1;
         }
      }

      return -1;
   }

   public boolean hasNext() {
      return this.currentIndex >= 0;
   }

   public final Object next() throws NoSuchElementException {
      return this.nextHeader();
   }

   public Header nextHeader() throws NoSuchElementException {
      int var1 = this.currentIndex;
      if(var1 < 0) {
         throw new NoSuchElementException("Iteration already finished.");
      } else {
         this.currentIndex = this.findNext(var1);
         return this.allHeaders[var1];
      }
   }

   public void remove() throws UnsupportedOperationException {
      throw new UnsupportedOperationException("Removing headers is not supported.");
   }
}
