package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.bh;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataLayer {
   public static final String EVENT_KEY = "event";
   public static final Object OBJECT_NOT_PRESENT = new Object();
   static final String[] aqQ = "gtm.lifetime".toString().split("\\.");
   private static final Pattern aqR = Pattern.compile("(\\d+)\\s*([smhd]?)");
   private final ConcurrentHashMap aqS;
   private final Map aqT;
   private final ReentrantLock aqU;
   private final LinkedList aqV;
   private final DataLayer.c aqW;
   private final CountDownLatch aqX;

   DataLayer() {
      this(new DataLayer.c() {
         public void a(DataLayer.a var1) {
            var1.h(new ArrayList());
         }

         public void a(List var1, long var2) {
         }

         public void cz(String var1) {
         }
      });
   }

   DataLayer(DataLayer.c var1) {
      this.aqW = var1;
      this.aqS = new ConcurrentHashMap();
      this.aqT = new HashMap();
      this.aqU = new ReentrantLock();
      this.aqV = new LinkedList();
      this.aqX = new CountDownLatch(1);
      this.pv();
   }

   private void E(Map var1) {
      this.aqU.lock();

      try {
         this.aqV.offer(var1);
         if(this.aqU.getHoldCount() == 1) {
            this.pw();
         }

         this.F(var1);
      } finally {
         this.aqU.unlock();
      }

   }

   private void F(Map var1) {
      Long var2 = this.G(var1);
      if(var2 != null) {
         List var3 = this.I(var1);
         var3.remove("gtm.lifetime");
         this.aqW.a(var3, var2.longValue());
      }
   }

   private Long G(Map var1) {
      Object var2 = this.H(var1);
      return var2 == null?null:cy(var2.toString());
   }

   private Object H(Map var1) {
      String[] var5 = aqQ;
      int var3 = var5.length;
      int var2 = 0;

      Object var4;
      while(true) {
         var4 = var1;
         if(var2 >= var3) {
            break;
         }

         String var6 = var5[var2];
         if(!(var1 instanceof Map)) {
            var4 = null;
            break;
         }

         var1 = ((Map)var1).get(var6);
         ++var2;
      }

      return var4;
   }

   private List I(Map var1) {
      ArrayList var2 = new ArrayList();
      this.a(var1, "", var2);
      return var2;
   }

   private void J(Map param1) {
      // $FF: Couldn't be decompiled
   }

   private void K(Map var1) {
      Iterator var2 = this.aqS.keySet().iterator();

      while(var2.hasNext()) {
         ((DataLayer.b)var2.next()).C(var1);
      }

   }

   private void a(Map var1, String var2, Collection var3) {
      Iterator var4 = var1.entrySet().iterator();

      while(var4.hasNext()) {
         Entry var5 = (Entry)var4.next();
         StringBuilder var6 = (new StringBuilder()).append(var2);
         String var7;
         if(var2.length() == 0) {
            var7 = "";
         } else {
            var7 = ".";
         }

         var7 = var6.append(var7).append((String)var5.getKey()).toString();
         if(var5.getValue() instanceof Map) {
            this.a((Map)var5.getValue(), var7, var3);
         } else if(!var7.equals("gtm.lifetime")) {
            var3.add(new DataLayer.a(var7, var5.getValue()));
         }
      }

   }

   static Long cy(String var0) {
      Matcher var3 = aqR.matcher(var0);
      if(!var3.matches()) {
         bh.U("unknown _lifetime: " + var0);
         return null;
      } else {
         long var1;
         try {
            var1 = Long.parseLong(var3.group(1));
         } catch (NumberFormatException var5) {
            bh.W("illegal number in _lifetime value: " + var0);
            var1 = 0L;
         }

         if(var1 <= 0L) {
            bh.U("non-positive _lifetime: " + var0);
            return null;
         } else {
            String var6 = var3.group(2);
            if(var6.length() == 0) {
               return Long.valueOf(var1);
            } else {
               switch(var6.charAt(0)) {
               case 'd':
                  return Long.valueOf(var1 * 1000L * 60L * 60L * 24L);
               case 'h':
                  return Long.valueOf(var1 * 1000L * 60L * 60L);
               case 'm':
                  return Long.valueOf(var1 * 1000L * 60L);
               case 's':
                  return Long.valueOf(var1 * 1000L);
               default:
                  bh.W("unknown units in _lifetime: " + var0);
                  return null;
               }
            }
         }
      }
   }

   public static List listOf(Object... var0) {
      ArrayList var2 = new ArrayList();

      for(int var1 = 0; var1 < var0.length; ++var1) {
         var2.add(var0[var1]);
      }

      return var2;
   }

   public static Map mapOf(Object... var0) {
      if(var0.length % 2 != 0) {
         throw new IllegalArgumentException("expected even number of key-value pairs");
      } else {
         HashMap var2 = new HashMap();

         for(int var1 = 0; var1 < var0.length; var1 += 2) {
            if(!(var0[var1] instanceof String)) {
               throw new IllegalArgumentException("key is not a string: " + var0[var1]);
            }

            var2.put((String)var0[var1], var0[var1 + 1]);
         }

         return var2;
      }
   }

   private void pv() {
      this.aqW.a(new DataLayer.a() {
         public void h(List var1) {
            Iterator var3 = var1.iterator();

            while(var3.hasNext()) {
               DataLayer.a var2 = (DataLayer.a)var3.next();
               DataLayer.this.E(DataLayer.this.c(var2.KP, var2.wF));
            }

            DataLayer.this.aqX.countDown();
         }
      });
   }

   private void pw() {
      int var1 = 0;

      do {
         Map var2 = (Map)this.aqV.poll();
         if(var2 == null) {
            return;
         }

         this.J(var2);
         ++var1;
      } while(var1 <= 500);

      this.aqV.clear();
      throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
   }

   void a(DataLayer.b var1) {
      this.aqS.put(var1, Integer.valueOf(0));
   }

   void a(Map var1, Map var2) {
      Iterator var3 = var1.keySet().iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         Object var5 = var1.get(var4);
         if(var5 instanceof List) {
            if(!(var2.get(var4) instanceof List)) {
               var2.put(var4, new ArrayList());
            }

            this.b((List)var5, (List)var2.get(var4));
         } else if(var5 instanceof Map) {
            if(!(var2.get(var4) instanceof Map)) {
               var2.put(var4, new HashMap());
            }

            this.a((Map)var5, (Map)var2.get(var4));
         } else {
            var2.put(var4, var5);
         }
      }

   }

   void b(List var1, List var2) {
      while(var2.size() < var1.size()) {
         var2.add((Object)null);
      }

      for(int var3 = 0; var3 < var1.size(); ++var3) {
         Object var4 = var1.get(var3);
         if(var4 instanceof List) {
            if(!(var2.get(var3) instanceof List)) {
               var2.set(var3, new ArrayList());
            }

            this.b((List)var4, (List)var2.get(var3));
         } else if(var4 instanceof Map) {
            if(!(var2.get(var3) instanceof Map)) {
               var2.set(var3, new HashMap());
            }

            this.a((Map)var4, (Map)var2.get(var3));
         } else if(var4 != OBJECT_NOT_PRESENT) {
            var2.set(var3, var4);
         }
      }

   }

   Map c(String var1, Object var2) {
      HashMap var4 = new HashMap();
      String[] var6 = var1.toString().split("\\.");
      int var3 = 0;

      HashMap var5;
      HashMap var7;
      for(var7 = var4; var3 < var6.length - 1; var7 = var5) {
         var5 = new HashMap();
         var7.put(var6[var3], var5);
         ++var3;
      }

      var7.put(var6[var6.length - 1], var2);
      return var4;
   }

   void cx(String var1) {
      this.push(var1, (Object)null);
      this.aqW.cz(var1);
   }

   public Object get(String param1) {
      // $FF: Couldn't be decompiled
   }

   public void push(String var1, Object var2) {
      this.push(this.c(var1, var2));
   }

   public void push(Map var1) {
      try {
         this.aqX.await();
      } catch (InterruptedException var3) {
         bh.W("DataLayer.push: unexpected InterruptedException");
      }

      this.E(var1);
   }

   public void pushEvent(String var1, Map var2) {
      HashMap var3 = new HashMap(var2);
      var3.put("event", var1);
      this.push(var3);
   }

   public String toString() {
      // $FF: Couldn't be decompiled
   }

   static final class a {
      public final String KP;
      public final Object wF;

      a(String var1, Object var2) {
         this.KP = var1;
         this.wF = var2;
      }

      public boolean equals(Object var1) {
         if(var1 instanceof DataLayer.a) {
            DataLayer.a var2 = (DataLayer.a)var1;
            if(this.KP.equals(var2.KP) && this.wF.equals(var2.wF)) {
               return true;
            }
         }

         return false;
      }

      public int hashCode() {
         return Arrays.hashCode(new Integer[]{Integer.valueOf(this.KP.hashCode()), Integer.valueOf(this.wF.hashCode())});
      }

      public String toString() {
         return "Key: " + this.KP + " value: " + this.wF.toString();
      }
   }

   interface b {
      void C(Map var1);
   }

   interface c {
      void a(DataLayer.a var1);

      void a(List var1, long var2);

      void cz(String var1);
   }

   public interface a {
      void h(List var1);
   }
}
