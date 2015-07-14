package org.apache.http.protocol;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
final class ChainBuilder {
   private final LinkedList list = new LinkedList();
   private final Map uniqueClasses = new HashMap();

   private void ensureUnique(Object var1) {
      Object var2 = this.uniqueClasses.remove(var1.getClass());
      if(var2 != null) {
         this.list.remove(var2);
      }

      this.uniqueClasses.put(var1.getClass(), var1);
   }

   public ChainBuilder addAllFirst(Collection var1) {
      if(var1 != null) {
         Iterator var2 = var1.iterator();

         while(var2.hasNext()) {
            this.addFirst(var2.next());
         }
      }

      return this;
   }

   public ChainBuilder addAllFirst(Object... var1) {
      if(var1 != null) {
         int var3 = var1.length;

         for(int var2 = 0; var2 < var3; ++var2) {
            this.addFirst(var1[var2]);
         }
      }

      return this;
   }

   public ChainBuilder addAllLast(Collection var1) {
      if(var1 != null) {
         Iterator var2 = var1.iterator();

         while(var2.hasNext()) {
            this.addLast(var2.next());
         }
      }

      return this;
   }

   public ChainBuilder addAllLast(Object... var1) {
      if(var1 != null) {
         int var3 = var1.length;

         for(int var2 = 0; var2 < var3; ++var2) {
            this.addLast(var1[var2]);
         }
      }

      return this;
   }

   public ChainBuilder addFirst(Object var1) {
      if(var1 == null) {
         return this;
      } else {
         this.ensureUnique(var1);
         this.list.addFirst(var1);
         return this;
      }
   }

   public ChainBuilder addLast(Object var1) {
      if(var1 == null) {
         return this;
      } else {
         this.ensureUnique(var1);
         this.list.addLast(var1);
         return this;
      }
   }

   public LinkedList build() {
      return new LinkedList(this.list);
   }
}
