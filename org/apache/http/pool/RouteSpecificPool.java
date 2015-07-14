package org.apache.http.pool;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.pool.PoolEntry;
import org.apache.http.pool.PoolEntryFuture;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@NotThreadSafe
abstract class RouteSpecificPool {
   private final LinkedList available;
   private final Set leased;
   private final LinkedList pending;
   private final Object route;

   RouteSpecificPool(Object var1) {
      this.route = var1;
      this.leased = new HashSet();
      this.available = new LinkedList();
      this.pending = new LinkedList();
   }

   public PoolEntry add(Object var1) {
      PoolEntry var2 = this.createEntry(var1);
      this.leased.add(var2);
      return var2;
   }

   protected abstract PoolEntry createEntry(Object var1);

   public void free(PoolEntry var1, boolean var2) {
      Args.notNull(var1, "Pool entry");
      Asserts.check(this.leased.remove(var1), "Entry %s has not been leased from this pool", new Object[]{var1});
      if(var2) {
         this.available.addFirst(var1);
      }

   }

   public int getAllocatedCount() {
      return this.available.size() + this.leased.size();
   }

   public int getAvailableCount() {
      return this.available.size();
   }

   public PoolEntry getFree(Object var1) {
      if(!this.available.isEmpty()) {
         if(var1 != null) {
            Iterator var2 = this.available.iterator();

            while(var2.hasNext()) {
               PoolEntry var3 = (PoolEntry)var2.next();
               if(var1.equals(var3.getState())) {
                  var2.remove();
                  this.leased.add(var3);
                  return var3;
               }
            }
         }

         Iterator var4 = this.available.iterator();

         while(var4.hasNext()) {
            PoolEntry var5 = (PoolEntry)var4.next();
            if(var5.getState() == null) {
               var4.remove();
               this.leased.add(var5);
               return var5;
            }
         }
      }

      return null;
   }

   public PoolEntry getLastUsed() {
      return !this.available.isEmpty()?(PoolEntry)this.available.getLast():null;
   }

   public int getLeasedCount() {
      return this.leased.size();
   }

   public int getPendingCount() {
      return this.pending.size();
   }

   public final Object getRoute() {
      return this.route;
   }

   public PoolEntryFuture nextPending() {
      return (PoolEntryFuture)this.pending.poll();
   }

   public void queue(PoolEntryFuture var1) {
      if(var1 != null) {
         this.pending.add(var1);
      }
   }

   public boolean remove(PoolEntry var1) {
      Args.notNull(var1, "Pool entry");
      return this.available.remove(var1) || this.leased.remove(var1);
   }

   public void shutdown() {
      Iterator var1 = this.pending.iterator();

      while(var1.hasNext()) {
         ((PoolEntryFuture)var1.next()).cancel(true);
      }

      this.pending.clear();
      var1 = this.available.iterator();

      while(var1.hasNext()) {
         ((PoolEntry)var1.next()).close();
      }

      this.available.clear();
      var1 = this.leased.iterator();

      while(var1.hasNext()) {
         ((PoolEntry)var1.next()).close();
      }

      this.leased.clear();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("[route: ");
      var1.append(this.route);
      var1.append("][leased: ");
      var1.append(this.leased.size());
      var1.append("][available: ");
      var1.append(this.available.size());
      var1.append("][pending: ");
      var1.append(this.pending.size());
      var1.append("]");
      return var1.toString();
   }

   public void unqueue(PoolEntryFuture var1) {
      if(var1 != null) {
         this.pending.remove(var1);
      }
   }
}
