package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Map.Entry;

public final class LinkedTreeMap extends AbstractMap implements Serializable {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   private static final Comparator NATURAL_ORDER;
   Comparator comparator;
   private LinkedTreeMap.EntrySet entrySet;
   final LinkedTreeMap.Node header;
   private LinkedTreeMap.KeySet keySet;
   int modCount;
   LinkedTreeMap.Node root;
   int size;

   static {
      boolean var0;
      if(!LinkedTreeMap.class.desiredAssertionStatus()) {
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

   public LinkedTreeMap() {
      this(NATURAL_ORDER);
   }

   public LinkedTreeMap(Comparator var1) {
      this.size = 0;
      this.modCount = 0;
      this.header = new LinkedTreeMap.Node();
      if(var1 == null) {
         var1 = NATURAL_ORDER;
      }

      this.comparator = var1;
   }

   private boolean equal(Object var1, Object var2) {
      return var1 == var2 || var1 != null && var1.equals(var2);
   }

   private void rebalance(LinkedTreeMap.Node var1, boolean var2) {
      for(; var1 != null; var1 = var1.parent) {
         LinkedTreeMap.Node var6 = var1.left;
         LinkedTreeMap.Node var7 = var1.right;
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
         LinkedTreeMap.Node var8;
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

   private void replaceInParent(LinkedTreeMap.Node var1, LinkedTreeMap.Node var2) {
      LinkedTreeMap.Node var3 = var1.parent;
      var1.parent = null;
      if(var2 != null) {
         var2.parent = var3;
      }

      if(var3 != null) {
         if(var3.left == var1) {
            var3.left = var2;
         } else if(!$assertionsDisabled && var3.right != var1) {
            throw new AssertionError();
         } else {
            var3.right = var2;
         }
      } else {
         this.root = var2;
      }
   }

   private void rotateLeft(LinkedTreeMap.Node var1) {
      byte var4 = 0;
      LinkedTreeMap.Node var5 = var1.left;
      LinkedTreeMap.Node var6 = var1.right;
      LinkedTreeMap.Node var7 = var6.left;
      LinkedTreeMap.Node var8 = var6.right;
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

   private void rotateRight(LinkedTreeMap.Node var1) {
      byte var4 = 0;
      LinkedTreeMap.Node var5 = var1.left;
      LinkedTreeMap.Node var6 = var1.right;
      LinkedTreeMap.Node var7 = var5.left;
      LinkedTreeMap.Node var8 = var5.right;
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

   private Object writeReplace() throws ObjectStreamException {
      return new LinkedHashMap(this);
   }

   public void clear() {
      this.root = null;
      this.size = 0;
      ++this.modCount;
      LinkedTreeMap.Node var1 = this.header;
      var1.prev = var1;
      var1.next = var1;
   }

   public boolean containsKey(Object var1) {
      return this.findByObject(var1) != null;
   }

   public Set entrySet() {
      LinkedTreeMap.EntrySet var1 = this.entrySet;
      if(var1 != null) {
         return var1;
      } else {
         var1 = new LinkedTreeMap.EntrySet();
         this.entrySet = var1;
         return var1;
      }
   }

   LinkedTreeMap.Node find(Object var1, boolean var2) {
      Object var7 = null;
      Comparator var8 = this.comparator;
      LinkedTreeMap.Node var4 = this.root;
      int var3 = 0;
      LinkedTreeMap.Node var5 = var4;
      if(var4 != null) {
         Comparable var6;
         if(var8 == NATURAL_ORDER) {
            var6 = (Comparable)var1;
         } else {
            var6 = null;
         }

         while(true) {
            if(var6 != null) {
               var3 = var6.compareTo(var4.key);
            } else {
               var3 = var8.compare(var1, var4.key);
            }

            if(var3 == 0) {
               return var4;
            }

            if(var3 < 0) {
               var5 = var4.left;
            } else {
               var5 = var4.right;
            }

            if(var5 == null) {
               var5 = var4;
               break;
            }

            var4 = var5;
         }
      }

      var4 = (LinkedTreeMap.Node)var7;
      if(var2) {
         var4 = this.header;
         LinkedTreeMap.Node var9;
         if(var5 == null) {
            if(var8 == NATURAL_ORDER && !(var1 instanceof Comparable)) {
               throw new ClassCastException(var1.getClass().getName() + " is not Comparable");
            }

            var9 = new LinkedTreeMap.Node(var5, var1, var4, var4.prev);
            this.root = var9;
         } else {
            var9 = new LinkedTreeMap.Node(var5, var1, var4, var4.prev);
            if(var3 < 0) {
               var5.left = var9;
            } else {
               var5.right = var9;
            }

            this.rebalance(var5, true);
         }

         ++this.size;
         ++this.modCount;
         return var9;
      } else {
         return var4;
      }
   }

   LinkedTreeMap.Node findByEntry(Entry var1) {
      LinkedTreeMap.Node var3 = this.findByObject(var1.getKey());
      boolean var2;
      if(var3 != null && this.equal(var3.value, var1.getValue())) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2?var3:null;
   }

   LinkedTreeMap.Node findByObject(Object var1) {
      LinkedTreeMap.Node var2 = null;
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
      LinkedTreeMap.Node var2 = this.findByObject(var1);
      return var2 != null?var2.value:null;
   }

   public Set keySet() {
      LinkedTreeMap.KeySet var1 = this.keySet;
      if(var1 != null) {
         return var1;
      } else {
         var1 = new LinkedTreeMap.KeySet();
         this.keySet = var1;
         return var1;
      }
   }

   public Object put(Object var1, Object var2) {
      if(var1 == null) {
         throw new NullPointerException("key == null");
      } else {
         LinkedTreeMap.Node var4 = this.find(var1, true);
         Object var3 = var4.value;
         var4.value = var2;
         return var3;
      }
   }

   public Object remove(Object var1) {
      LinkedTreeMap.Node var2 = this.removeInternalByKey(var1);
      return var2 != null?var2.value:null;
   }

   void removeInternal(LinkedTreeMap.Node var1, boolean var2) {
      if(var2) {
         var1.prev.next = var1.next;
         var1.next.prev = var1.prev;
      }

      LinkedTreeMap.Node var5 = var1.left;
      LinkedTreeMap.Node var6 = var1.right;
      LinkedTreeMap.Node var7 = var1.parent;
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
            this.replaceInParent(var1, (LinkedTreeMap.Node)null);
         }

         this.rebalance(var7, false);
         --this.size;
         ++this.modCount;
      }
   }

   LinkedTreeMap.Node removeInternalByKey(Object var1) {
      LinkedTreeMap.Node var2 = this.findByObject(var1);
      if(var2 != null) {
         this.removeInternal(var2, true);
      }

      return var2;
   }

   public int size() {
      return this.size;
   }

   class EntrySet extends AbstractSet {
      public void clear() {
         LinkedTreeMap.this.clear();
      }

      public boolean contains(Object var1) {
         return var1 instanceof Entry && LinkedTreeMap.this.findByEntry((Entry)var1) != null;
      }

      public Iterator iterator() {
         return new LinkedTreeMap.LinkedTreeMapIterator(null) {
            public Entry next() {
               return this.nextNode();
            }
         };
      }

      public boolean remove(Object var1) {
         if(var1 instanceof Entry) {
            LinkedTreeMap.Node var2 = LinkedTreeMap.this.findByEntry((Entry)var1);
            if(var2 != null) {
               LinkedTreeMap.this.removeInternal(var2, true);
               return true;
            }
         }

         return false;
      }

      public int size() {
         return LinkedTreeMap.this.size;
      }
   }

   final class KeySet extends AbstractSet {
      public void clear() {
         LinkedTreeMap.this.clear();
      }

      public boolean contains(Object var1) {
         return LinkedTreeMap.this.containsKey(var1);
      }

      public Iterator iterator() {
         return new LinkedTreeMap.LinkedTreeMapIterator(null) {
            public Object next() {
               return this.nextNode().key;
            }
         };
      }

      public boolean remove(Object var1) {
         return LinkedTreeMap.this.removeInternalByKey(var1) != null;
      }

      public int size() {
         return LinkedTreeMap.this.size;
      }
   }

   private abstract class LinkedTreeMapIterator implements Iterator {
      int expectedModCount;
      LinkedTreeMap.Node lastReturned;
      LinkedTreeMap.Node next;

      private LinkedTreeMapIterator() {
         this.next = LinkedTreeMap.this.header.next;
         this.lastReturned = null;
         this.expectedModCount = LinkedTreeMap.this.modCount;
      }

      // $FF: synthetic method
      LinkedTreeMapIterator(Object var2) {
         this();
      }

      public final boolean hasNext() {
         return this.next != LinkedTreeMap.this.header;
      }

      final LinkedTreeMap.Node nextNode() {
         LinkedTreeMap.Node var1 = this.next;
         if(var1 == LinkedTreeMap.this.header) {
            throw new NoSuchElementException();
         } else if(LinkedTreeMap.this.modCount != this.expectedModCount) {
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
            LinkedTreeMap.this.removeInternal(this.lastReturned, true);
            this.lastReturned = null;
            this.expectedModCount = LinkedTreeMap.this.modCount;
         }
      }
   }

   static final class Node implements Entry {
      int height;
      final Object key;
      LinkedTreeMap.Node left;
      LinkedTreeMap.Node next;
      LinkedTreeMap.Node parent;
      LinkedTreeMap.Node prev;
      LinkedTreeMap.Node right;
      Object value;

      Node() {
         this.key = null;
         this.prev = this;
         this.next = this;
      }

      Node(LinkedTreeMap.Node var1, Object var2, LinkedTreeMap.Node var3, LinkedTreeMap.Node var4) {
         this.parent = var1;
         this.key = var2;
         this.height = 1;
         this.next = var3;
         this.prev = var4;
         var4.next = this;
         var3.prev = this;
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

      public LinkedTreeMap.Node first() {
         LinkedTreeMap.Node var2 = this;

         for(LinkedTreeMap.Node var1 = this.left; var1 != null; var1 = var1.left) {
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

      public LinkedTreeMap.Node last() {
         LinkedTreeMap.Node var2 = this;

         for(LinkedTreeMap.Node var1 = this.right; var1 != null; var1 = var1.right) {
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
