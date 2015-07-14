package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Map.Entry;

public final class LinkedHashTreeMap extends AbstractMap implements Serializable {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   private static final Comparator NATURAL_ORDER;
   Comparator comparator;
   private LinkedHashTreeMap.EntrySet entrySet;
   final LinkedHashTreeMap.Node header;
   private LinkedHashTreeMap.KeySet keySet;
   int modCount;
   int size;
   LinkedHashTreeMap.Node[] table;
   int threshold;

   static {
      boolean var0;
      if(!LinkedHashTreeMap.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
      NATURAL_ORDER = new Comparator() {
         public int compare(Comparable var1, Comparable var2) {
            return var1.compareTo(var2);
         }
      };
   }

   public LinkedHashTreeMap() {
      this(NATURAL_ORDER);
   }

   public LinkedHashTreeMap(Comparator var1) {
      this.size = 0;
      this.modCount = 0;
      if(var1 == null) {
         var1 = NATURAL_ORDER;
      }

      this.comparator = var1;
      this.header = new LinkedHashTreeMap.Node();
      this.table = new LinkedHashTreeMap.Node[16];
      this.threshold = this.table.length / 2 + this.table.length / 4;
   }

   private void doubleCapacity() {
      this.table = doubleCapacity(this.table);
      this.threshold = this.table.length / 2 + this.table.length / 4;
   }

   static LinkedHashTreeMap.Node[] doubleCapacity(LinkedHashTreeMap.Node[] var0) {
      int var4 = var0.length;
      LinkedHashTreeMap.Node[] var6 = new LinkedHashTreeMap.Node[var4 * 2];
      LinkedHashTreeMap.AvlIterator var7 = new LinkedHashTreeMap.AvlIterator();
      LinkedHashTreeMap.AvlBuilder var8 = new LinkedHashTreeMap.AvlBuilder();
      LinkedHashTreeMap.AvlBuilder var9 = new LinkedHashTreeMap.AvlBuilder();

      label48:
      for(int var1 = 0; var1 < var4; ++var1) {
         LinkedHashTreeMap.Node var5 = var0[var1];
         if(var5 != null) {
            var7.reset(var5);
            int var3 = 0;
            int var2 = 0;

            while(true) {
               LinkedHashTreeMap.Node var10 = var7.next();
               if(var10 == null) {
                  var8.reset(var3);
                  var9.reset(var2);
                  var7.reset(var5);

                  while(true) {
                     var5 = var7.next();
                     if(var5 == null) {
                        if(var3 > 0) {
                           var5 = var8.root();
                        } else {
                           var5 = null;
                        }

                        var6[var1] = var5;
                        if(var2 > 0) {
                           var5 = var9.root();
                        } else {
                           var5 = null;
                        }

                        var6[var1 + var4] = var5;
                        continue label48;
                     }

                     if((var5.hash & var4) == 0) {
                        var8.add(var5);
                     } else {
                        var9.add(var5);
                     }
                  }
               }

               if((var10.hash & var4) == 0) {
                  ++var3;
               } else {
                  ++var2;
               }
            }
         }
      }

      return var6;
   }

   private boolean equal(Object var1, Object var2) {
      return var1 == var2 || var1 != null && var1.equals(var2);
   }

   private void rebalance(LinkedHashTreeMap.Node var1, boolean var2) {
      for(; var1 != null; var1 = var1.parent) {
         LinkedHashTreeMap.Node var6 = var1.left;
         LinkedHashTreeMap.Node var7 = var1.right;
         int var3;
         if(var6 != null) {
            var3 = var6.height;
         } else {
            var3 = 0;
         }

         int var4;
         if(var7 != null) {
            var4 = var7.height;
         } else {
            var4 = 0;
         }

         int var5 = var3 - var4;
         LinkedHashTreeMap.Node var8;
         if(var5 == -2) {
            var6 = var7.left;
            var8 = var7.right;
            if(var8 != null) {
               var3 = var8.height;
            } else {
               var3 = 0;
            }

            if(var6 != null) {
               var4 = var6.height;
            } else {
               var4 = 0;
            }

            var3 = var4 - var3;
            if(var3 != -1 && (var3 != 0 || var2)) {
               if(!$assertionsDisabled && var3 != 1) {
                  throw new AssertionError();
               }

               this.rotateRight(var7);
               this.rotateLeft(var1);
            } else {
               this.rotateLeft(var1);
            }

            if(var2) {
               return;
            }
         } else if(var5 == 2) {
            var7 = var6.left;
            var8 = var6.right;
            if(var8 != null) {
               var3 = var8.height;
            } else {
               var3 = 0;
            }

            if(var7 != null) {
               var4 = var7.height;
            } else {
               var4 = 0;
            }

            var3 = var4 - var3;
            if(var3 != 1 && (var3 != 0 || var2)) {
               if(!$assertionsDisabled && var3 != -1) {
                  throw new AssertionError();
               }

               this.rotateLeft(var6);
               this.rotateRight(var1);
            } else {
               this.rotateRight(var1);
            }

            if(var2) {
               return;
            }
         } else if(var5 == 0) {
            var1.height = var3 + 1;
            if(var2) {
               return;
            }
         } else {
            if(!$assertionsDisabled && var5 != -1 && var5 != 1) {
               throw new AssertionError();
            }

            var1.height = Math.max(var3, var4) + 1;
            if(!var2) {
               return;
            }
         }
      }

   }

   private void replaceInParent(LinkedHashTreeMap.Node var1, LinkedHashTreeMap.Node var2) {
      LinkedHashTreeMap.Node var5 = var1.parent;
      var1.parent = null;
      if(var2 != null) {
         var2.parent = var5;
      }

      if(var5 != null) {
         if(var5.left == var1) {
            var5.left = var2;
         } else if(!$assertionsDisabled && var5.right != var1) {
            throw new AssertionError();
         } else {
            var5.right = var2;
         }
      } else {
         int var3 = var1.hash;
         int var4 = this.table.length;
         this.table[var3 & var4 - 1] = var2;
      }
   }

   private void rotateLeft(LinkedHashTreeMap.Node var1) {
      byte var4 = 0;
      LinkedHashTreeMap.Node var5 = var1.left;
      LinkedHashTreeMap.Node var6 = var1.right;
      LinkedHashTreeMap.Node var7 = var6.left;
      LinkedHashTreeMap.Node var8 = var6.right;
      var1.right = var7;
      if(var7 != null) {
         var7.parent = var1;
      }

      this.replaceInParent(var1, var6);
      var6.left = var1;
      var1.parent = var6;
      int var2;
      if(var5 != null) {
         var2 = var5.height;
      } else {
         var2 = 0;
      }

      int var3;
      if(var7 != null) {
         var3 = var7.height;
      } else {
         var3 = 0;
      }

      var1.height = Math.max(var2, var3) + 1;
      var3 = var1.height;
      var2 = var4;
      if(var8 != null) {
         var2 = var8.height;
      }

      var6.height = Math.max(var3, var2) + 1;
   }

   private void rotateRight(LinkedHashTreeMap.Node var1) {
      byte var4 = 0;
      LinkedHashTreeMap.Node var5 = var1.left;
      LinkedHashTreeMap.Node var6 = var1.right;
      LinkedHashTreeMap.Node var7 = var5.left;
      LinkedHashTreeMap.Node var8 = var5.right;
      var1.left = var8;
      if(var8 != null) {
         var8.parent = var1;
      }

      this.replaceInParent(var1, var5);
      var5.right = var1;
      var1.parent = var5;
      int var2;
      if(var6 != null) {
         var2 = var6.height;
      } else {
         var2 = 0;
      }

      int var3;
      if(var8 != null) {
         var3 = var8.height;
      } else {
         var3 = 0;
      }

      var1.height = Math.max(var2, var3) + 1;
      var3 = var1.height;
      var2 = var4;
      if(var7 != null) {
         var2 = var7.height;
      }

      var5.height = Math.max(var3, var2) + 1;
   }

   private static int secondaryHash(int var0) {
      var0 ^= var0 >>> 20 ^ var0 >>> 12;
      return var0 >>> 7 ^ var0 ^ var0 >>> 4;
   }

   private Object writeReplace() throws ObjectStreamException {
      return new LinkedHashMap(this);
   }

   public void clear() {
      Arrays.fill(this.table, (Object)null);
      this.size = 0;
      ++this.modCount;
      LinkedHashTreeMap.Node var3 = this.header;

      LinkedHashTreeMap.Node var2;
      for(LinkedHashTreeMap.Node var1 = var3.next; var1 != var3; var1 = var2) {
         var2 = var1.next;
         var1.prev = null;
         var1.next = null;
      }

      var3.prev = var3;
      var3.next = var3;
   }

   public boolean containsKey(Object var1) {
      return this.findByObject(var1) != null;
   }

   public Set entrySet() {
      LinkedHashTreeMap.EntrySet var1 = this.entrySet;
      if(var1 != null) {
         return var1;
      } else {
         var1 = new LinkedHashTreeMap.EntrySet();
         this.entrySet = var1;
         return var1;
      }
   }

   LinkedHashTreeMap.Node find(Object var1, boolean var2) {
      Object var9 = null;
      Comparator var11 = this.comparator;
      LinkedHashTreeMap.Node[] var10 = this.table;
      int var4 = secondaryHash(var1.hashCode());
      int var5 = var4 & var10.length - 1;
      LinkedHashTreeMap.Node var6 = var10[var5];
      int var3 = 0;
      LinkedHashTreeMap.Node var7 = var6;
      if(var6 != null) {
         Comparable var8;
         if(var11 == NATURAL_ORDER) {
            var8 = (Comparable)var1;
         } else {
            var8 = null;
         }

         while(true) {
            if(var8 != null) {
               var3 = var8.compareTo(var6.key);
            } else {
               var3 = var11.compare(var1, var6.key);
            }

            if(var3 == 0) {
               return var6;
            }

            if(var3 < 0) {
               var7 = var6.left;
            } else {
               var7 = var6.right;
            }

            if(var7 == null) {
               var7 = var6;
               break;
            }

            var6 = var7;
         }
      }

      var6 = (LinkedHashTreeMap.Node)var9;
      if(var2) {
         var6 = this.header;
         LinkedHashTreeMap.Node var12;
         if(var7 == null) {
            if(var11 == NATURAL_ORDER && !(var1 instanceof Comparable)) {
               throw new ClassCastException(var1.getClass().getName() + " is not Comparable");
            }

            var12 = new LinkedHashTreeMap.Node(var7, var1, var4, var6, var6.prev);
            var10[var5] = var12;
         } else {
            var12 = new LinkedHashTreeMap.Node(var7, var1, var4, var6, var6.prev);
            if(var3 < 0) {
               var7.left = var12;
            } else {
               var7.right = var12;
            }

            this.rebalance(var7, true);
         }

         var3 = this.size;
         this.size = var3 + 1;
         if(var3 > this.threshold) {
            this.doubleCapacity();
         }

         ++this.modCount;
         return var12;
      } else {
         return var6;
      }
   }

   LinkedHashTreeMap.Node findByEntry(Entry var1) {
      LinkedHashTreeMap.Node var3 = this.findByObject(var1.getKey());
      boolean var2;
      if(var3 != null && this.equal(var3.value, var1.getValue())) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2?var3:null;
   }

   LinkedHashTreeMap.Node findByObject(Object var1) {
      LinkedHashTreeMap.Node var2 = null;
      if(var1 != null) {
         try {
            var2 = this.find(var1, false);
         } catch (ClassCastException var3) {
            return null;
         }
      }

      return var2;
   }

   public Object get(Object var1) {
      LinkedHashTreeMap.Node var2 = this.findByObject(var1);
      return var2 != null?var2.value:null;
   }

   public Set keySet() {
      LinkedHashTreeMap.KeySet var1 = this.keySet;
      if(var1 != null) {
         return var1;
      } else {
         var1 = new LinkedHashTreeMap.KeySet();
         this.keySet = var1;
         return var1;
      }
   }

   public Object put(Object var1, Object var2) {
      if(var1 == null) {
         throw new NullPointerException("key == null");
      } else {
         LinkedHashTreeMap.Node var4 = this.find(var1, true);
         Object var3 = var4.value;
         var4.value = var2;
         return var3;
      }
   }

   public Object remove(Object var1) {
      LinkedHashTreeMap.Node var2 = this.removeInternalByKey(var1);
      return var2 != null?var2.value:null;
   }

   void removeInternal(LinkedHashTreeMap.Node var1, boolean var2) {
      if(var2) {
         var1.prev.next = var1.next;
         var1.next.prev = var1.prev;
         var1.prev = null;
         var1.next = null;
      }

      LinkedHashTreeMap.Node var5 = var1.left;
      LinkedHashTreeMap.Node var6 = var1.right;
      LinkedHashTreeMap.Node var7 = var1.parent;
      if(var5 != null && var6 != null) {
         if(var5.height > var6.height) {
            var5 = var5.last();
         } else {
            var5 = var6.first();
         }

         this.removeInternal(var5, false);
         int var3 = 0;
         var6 = var1.left;
         if(var6 != null) {
            var3 = var6.height;
            var5.left = var6;
            var6.parent = var5;
            var1.left = null;
         }

         int var4 = 0;
         var6 = var1.right;
         if(var6 != null) {
            var4 = var6.height;
            var5.right = var6;
            var6.parent = var5;
            var1.right = null;
         }

         var5.height = Math.max(var3, var4) + 1;
         this.replaceInParent(var1, var5);
      } else {
         if(var5 != null) {
            this.replaceInParent(var1, var5);
            var1.left = null;
         } else if(var6 != null) {
            this.replaceInParent(var1, var6);
            var1.right = null;
         } else {
            this.replaceInParent(var1, (LinkedHashTreeMap.Node)null);
         }

         this.rebalance(var7, false);
         --this.size;
         ++this.modCount;
      }
   }

   LinkedHashTreeMap.Node removeInternalByKey(Object var1) {
      LinkedHashTreeMap.Node var2 = this.findByObject(var1);
      if(var2 != null) {
         this.removeInternal(var2, true);
      }

      return var2;
   }

   public int size() {
      return this.size;
   }

   static final class AvlBuilder {
      private int leavesSkipped;
      private int leavesToSkip;
      private int size;
      private LinkedHashTreeMap.Node stack;

      void add(LinkedHashTreeMap.Node var1) {
         var1.right = null;
         var1.parent = null;
         var1.left = null;
         var1.height = 1;
         if(this.leavesToSkip > 0 && (this.size & 1) == 0) {
            ++this.size;
            --this.leavesToSkip;
            ++this.leavesSkipped;
         }

         var1.parent = this.stack;
         this.stack = var1;
         ++this.size;
         if(this.leavesToSkip > 0 && (this.size & 1) == 0) {
            ++this.size;
            --this.leavesToSkip;
            ++this.leavesSkipped;
         }

         for(int var2 = 4; (this.size & var2 - 1) == var2 - 1; var2 *= 2) {
            LinkedHashTreeMap.Node var3;
            if(this.leavesSkipped == 0) {
               var1 = this.stack;
               var3 = var1.parent;
               LinkedHashTreeMap.Node var4 = var3.parent;
               var3.parent = var4.parent;
               this.stack = var3;
               var3.left = var4;
               var3.right = var1;
               var3.height = var1.height + 1;
               var4.parent = var3;
               var1.parent = var3;
            } else if(this.leavesSkipped == 1) {
               var1 = this.stack;
               var3 = var1.parent;
               this.stack = var3;
               var3.right = var1;
               var3.height = var1.height + 1;
               var1.parent = var3;
               this.leavesSkipped = 0;
            } else if(this.leavesSkipped == 2) {
               this.leavesSkipped = 0;
            }
         }

      }

      void reset(int var1) {
         this.leavesToSkip = Integer.highestOneBit(var1) * 2 - 1 - var1;
         this.size = 0;
         this.leavesSkipped = 0;
         this.stack = null;
      }

      LinkedHashTreeMap.Node root() {
         LinkedHashTreeMap.Node var1 = this.stack;
         if(var1.parent != null) {
            throw new IllegalStateException();
         } else {
            return var1;
         }
      }
   }

   static class AvlIterator {
      private LinkedHashTreeMap.Node stackTop;

      public LinkedHashTreeMap.Node next() {
         LinkedHashTreeMap.Node var3 = this.stackTop;
         if(var3 == null) {
            return null;
         } else {
            LinkedHashTreeMap.Node var2 = var3.parent;
            var3.parent = null;

            for(LinkedHashTreeMap.Node var1 = var3.right; var1 != null; var1 = var1.left) {
               var1.parent = var2;
               var2 = var1;
            }

            this.stackTop = var2;
            return var3;
         }
      }

      void reset(LinkedHashTreeMap.Node var1) {
         LinkedHashTreeMap.Node var2;
         for(var2 = null; var1 != null; var1 = var1.left) {
            var1.parent = var2;
            var2 = var1;
         }

         this.stackTop = var2;
      }
   }

   final class EntrySet extends AbstractSet {
      public void clear() {
         LinkedHashTreeMap.this.clear();
      }

      public boolean contains(Object var1) {
         return var1 instanceof Entry && LinkedHashTreeMap.this.findByEntry((Entry)var1) != null;
      }

      public Iterator iterator() {
         return new LinkedHashTreeMap.LinkedTreeMapIterator(null) {
            public Entry next() {
               return this.nextNode();
            }
         };
      }

      public boolean remove(Object var1) {
         if(var1 instanceof Entry) {
            LinkedHashTreeMap.Node var2 = LinkedHashTreeMap.this.findByEntry((Entry)var1);
            if(var2 != null) {
               LinkedHashTreeMap.this.removeInternal(var2, true);
               return true;
            }
         }

         return false;
      }

      public int size() {
         return LinkedHashTreeMap.this.size;
      }
   }

   final class KeySet extends AbstractSet {
      public void clear() {
         LinkedHashTreeMap.this.clear();
      }

      public boolean contains(Object var1) {
         return LinkedHashTreeMap.this.containsKey(var1);
      }

      public Iterator iterator() {
         return new LinkedHashTreeMap.LinkedTreeMapIterator(null) {
            public Object next() {
               return this.nextNode().key;
            }
         };
      }

      public boolean remove(Object var1) {
         return LinkedHashTreeMap.this.removeInternalByKey(var1) != null;
      }

      public int size() {
         return LinkedHashTreeMap.this.size;
      }
   }

   private abstract class LinkedTreeMapIterator implements Iterator {
      int expectedModCount;
      LinkedHashTreeMap.Node lastReturned;
      LinkedHashTreeMap.Node next;

      private LinkedTreeMapIterator() {
         this.next = LinkedHashTreeMap.this.header.next;
         this.lastReturned = null;
         this.expectedModCount = LinkedHashTreeMap.this.modCount;
      }

      // $FF: synthetic method
      LinkedTreeMapIterator(Object var2) {
         this();
      }

      public final boolean hasNext() {
         return this.next != LinkedHashTreeMap.this.header;
      }

      final LinkedHashTreeMap.Node nextNode() {
         LinkedHashTreeMap.Node var1 = this.next;
         if(var1 == LinkedHashTreeMap.this.header) {
            throw new NoSuchElementException();
         } else if(LinkedHashTreeMap.this.modCount != this.expectedModCount) {
            throw new ConcurrentModificationException();
         } else {
            this.next = var1.next;
            this.lastReturned = var1;
            return var1;
         }
      }

      public final void remove() {
         if(this.lastReturned == null) {
            throw new IllegalStateException();
         } else {
            LinkedHashTreeMap.this.removeInternal(this.lastReturned, true);
            this.lastReturned = null;
            this.expectedModCount = LinkedHashTreeMap.this.modCount;
         }
      }
   }

   static final class Node implements Entry {
      final int hash;
      int height;
      final Object key;
      LinkedHashTreeMap.Node left;
      LinkedHashTreeMap.Node next;
      LinkedHashTreeMap.Node parent;
      LinkedHashTreeMap.Node prev;
      LinkedHashTreeMap.Node right;
      Object value;

      Node() {
         this.key = null;
         this.hash = -1;
         this.prev = this;
         this.next = this;
      }

      Node(LinkedHashTreeMap.Node var1, Object var2, int var3, LinkedHashTreeMap.Node var4, LinkedHashTreeMap.Node var5) {
         this.parent = var1;
         this.key = var2;
         this.hash = var3;
         this.height = 1;
         this.next = var4;
         this.prev = var5;
         var5.next = this;
         var4.prev = this;
      }

      public boolean equals(Object var1) {
         boolean var3 = false;
         boolean var2 = var3;
         if(var1 instanceof Entry) {
            Entry var4 = (Entry)var1;
            if(this.key == null) {
               var2 = var3;
               if(var4.getKey() != null) {
                  return var2;
               }
            } else {
               var2 = var3;
               if(!this.key.equals(var4.getKey())) {
                  return var2;
               }
            }

            if(this.value == null) {
               var2 = var3;
               if(var4.getValue() != null) {
                  return var2;
               }
            } else {
               var2 = var3;
               if(!this.value.equals(var4.getValue())) {
                  return var2;
               }
            }

            var2 = true;
         }

         return var2;
      }

      public LinkedHashTreeMap.Node first() {
         LinkedHashTreeMap.Node var2 = this;

         for(LinkedHashTreeMap.Node var1 = this.left; var1 != null; var1 = var1.left) {
            var2 = var1;
         }

         return var2;
      }

      public Object getKey() {
         return this.key;
      }

      public Object getValue() {
         return this.value;
      }

      public int hashCode() {
         int var2 = 0;
         int var1;
         if(this.key == null) {
            var1 = 0;
         } else {
            var1 = this.key.hashCode();
         }

         if(this.value != null) {
            var2 = this.value.hashCode();
         }

         return var1 ^ var2;
      }

      public LinkedHashTreeMap.Node last() {
         LinkedHashTreeMap.Node var2 = this;

         for(LinkedHashTreeMap.Node var1 = this.right; var1 != null; var1 = var1.right) {
            var2 = var1;
         }

         return var2;
      }

      public Object setValue(Object var1) {
         Object var2 = this.value;
         this.value = var1;
         return var2;
      }

      public String toString() {
         return this.key + "=" + this.value;
      }
   }
}
