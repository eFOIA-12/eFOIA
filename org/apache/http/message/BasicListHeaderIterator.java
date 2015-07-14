package org.apache.http.message;

import java.util.List;
import java.util.NoSuchElementException;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@NotThreadSafe
public class BasicListHeaderIterator implements HeaderIterator {
   protected final List allHeaders;
   protected int currentIndex;
   protected String headerName;
   protected int lastIndex;

   public BasicListHeaderIterator(List var1, String var2) {
      this.allHeaders = (List)Args.notNull(var1, "Header list");
      this.headerName = var2;
      this.currentIndex = this.findNext(-1);
      this.lastIndex = -1;
   }

   protected boolean filterHeader(int var1) {
      if(this.headerName == null) {
         return true;
      } else {
         String var2 = ((Header)this.allHeaders.get(var1)).getName();
         return this.headerName.equalsIgnoreCase(var2);
      }
   }

   protected int findNext(int var1) {
      if(var1 >= -1) {
         int var2 = this.allHeaders.size();

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
         this.lastIndex = var1;
         this.currentIndex = this.findNext(var1);
         return (Header)this.allHeaders.get(var1);
      }
   }

   public void remove() throws UnsupportedOperationException {
      boolean var1;
      if(this.lastIndex >= 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      Asserts.check(var1, "No header to remove");
      this.allHeaders.remove(this.lastIndex);
      this.lastIndex = -1;
      --this.currentIndex;
   }
}
