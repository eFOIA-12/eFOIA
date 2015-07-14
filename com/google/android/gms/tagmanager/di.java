package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.bh;
import com.google.android.gms.tagmanager.dh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

class di {
   private static final Object auc = null;
   private static Long aud = new Long(0L);
   private static Double aue = new Double(0.0D);
   private static dh auf = dh.z(0L);
   private static String aug = new String("");
   private static Boolean auh = new Boolean(false);
   private static List aui = new ArrayList(0);
   private static Map auj = new HashMap();
   private static com.google.android.gms.internal.d auk;

   static {
      auk = u(aug);
   }

   public static com.google.android.gms.internal.d cZ(String var0) {
      com.google.android.gms.internal.d var1 = new com.google.android.gms.internal.d();
      var1.type = 5;
      var1.gA = var0;
      return var1;
   }

   private static dh da(String var0) {
      try {
         dh var1 = dh.cY(var0);
         return var1;
      } catch (NumberFormatException var2) {
         bh.T("Failed to convert \'" + var0 + "\' to a number.");
         return auf;
      }
   }

   private static Long db(String var0) {
      dh var1 = da(var0);
      return var1 == auf?aud:Long.valueOf(var1.longValue());
   }

   private static Double dc(String var0) {
      dh var1 = da(var0);
      return var1 == auf?aue:Double.valueOf(var1.doubleValue());
   }

   private static Boolean dd(String var0) {
      return "true".equalsIgnoreCase(var0)?Boolean.TRUE:("false".equalsIgnoreCase(var0)?Boolean.FALSE:auh);
   }

   private static double getDouble(Object var0) {
      if(var0 instanceof Number) {
         return ((Number)var0).doubleValue();
      } else {
         bh.T("getDouble received non-Number");
         return 0.0D;
      }
   }

   public static String j(com.google.android.gms.internal.d var0) {
      return p(o(var0));
   }

   public static dh k(com.google.android.gms.internal.d var0) {
      return q(o(var0));
   }

   public static Long l(com.google.android.gms.internal.d var0) {
      return r(o(var0));
   }

   public static Double m(com.google.android.gms.internal.d var0) {
      return s(o(var0));
   }

   public static Boolean n(com.google.android.gms.internal.d var0) {
      return t(o(var0));
   }

   public static Object o(com.google.android.gms.internal.d var0) {
      byte var3 = 0;
      byte var2 = 0;
      int var1 = 0;
      if(var0 == null) {
         return auc;
      } else {
         com.google.android.gms.internal.d[] var7;
         Object var12;
         switch(var0.type) {
         case 1:
            return var0.gv;
         case 2:
            ArrayList var11 = new ArrayList(var0.gw.length);
            var7 = var0.gw;

            for(int var8 = var7.length; var1 < var8; ++var1) {
               var12 = o(var7[var1]);
               if(var12 == auc) {
                  return auc;
               }

               var11.add(var12);
            }

            return var11;
         case 3:
            if(var0.gx.length != var0.gy.length) {
               bh.T("Converting an invalid value to object: " + var0.toString());
               return auc;
            } else {
               HashMap var10 = new HashMap(var0.gy.length);

               for(var1 = var3; var1 < var0.gx.length; ++var1) {
                  var12 = o(var0.gx[var1]);
                  Object var6 = o(var0.gy[var1]);
                  if(var12 == auc || var6 == auc) {
                     return auc;
                  }

                  var10.put(var12, var6);
               }

               return var10;
            }
         case 4:
            bh.T("Trying to convert a macro reference to object");
            return auc;
         case 5:
            bh.T("Trying to convert a function id to object");
            return auc;
         case 6:
            return Long.valueOf(var0.gB);
         case 7:
            StringBuffer var4 = new StringBuffer();
            var7 = var0.gD;
            int var9 = var7.length;

            for(var1 = var2; var1 < var9; ++var1) {
               String var5 = j(var7[var1]);
               if(var5 == aug) {
                  return auc;
               }

               var4.append(var5);
            }

            return var4.toString();
         case 8:
            return Boolean.valueOf(var0.gC);
         default:
            bh.T("Failed to convert a value of type: " + var0.type);
            return auc;
         }
      }
   }

   public static String p(Object var0) {
      return var0 == null?aug:var0.toString();
   }

   public static dh q(Object var0) {
      return var0 instanceof dh?(dh)var0:(w(var0)?dh.z(x(var0)):(v(var0)?dh.a(Double.valueOf(getDouble(var0))):da(p(var0))));
   }

   public static Object qV() {
      return auc;
   }

   public static Long qW() {
      return aud;
   }

   public static Double qX() {
      return aue;
   }

   public static Boolean qY() {
      return auh;
   }

   public static dh qZ() {
      return auf;
   }

   public static Long r(Object var0) {
      return w(var0)?Long.valueOf(x(var0)):db(p(var0));
   }

   public static String ra() {
      return aug;
   }

   public static com.google.android.gms.internal.d rb() {
      return auk;
   }

   public static Double s(Object var0) {
      return v(var0)?Double.valueOf(getDouble(var0)):dc(p(var0));
   }

   public static Boolean t(Object var0) {
      return var0 instanceof Boolean?(Boolean)var0:dd(p(var0));
   }

   public static com.google.android.gms.internal.d u(Object var0) {
      boolean var1 = false;
      com.google.android.gms.internal.d var2 = new com.google.android.gms.internal.d();
      if(var0 instanceof com.google.android.gms.internal.d) {
         return (com.google.android.gms.internal.d)var0;
      } else {
         if(var0 instanceof String) {
            var2.type = 1;
            var2.gv = (String)var0;
         } else {
            ArrayList var7;
            if(var0 instanceof List) {
               var2.type = 2;
               List var3 = (List)var0;
               var7 = new ArrayList(var3.size());
               Iterator var10 = var3.iterator();

               com.google.android.gms.internal.d var4;
               for(var1 = false; var10.hasNext(); var7.add(var4)) {
                  var4 = u(var10.next());
                  if(var4 == auk) {
                     return auk;
                  }

                  if(!var1 && !var4.gF) {
                     var1 = false;
                  } else {
                     var1 = true;
                  }
               }

               var2.gw = (com.google.android.gms.internal.d[])var7.toArray(new com.google.android.gms.internal.d[0]);
            } else if(var0 instanceof Map) {
               var2.type = 3;
               Set var12 = ((Map)var0).entrySet();
               var7 = new ArrayList(var12.size());
               ArrayList var11 = new ArrayList(var12.size());
               Iterator var13 = var12.iterator();
               var1 = false;

               while(true) {
                  if(var13.hasNext()) {
                     Entry var6 = (Entry)var13.next();
                     com.google.android.gms.internal.d var5 = u(var6.getKey());
                     com.google.android.gms.internal.d var14 = u(var6.getValue());
                     if(var5 != auk && var14 != auk) {
                        if(!var1 && !var5.gF && !var14.gF) {
                           var1 = false;
                        } else {
                           var1 = true;
                        }

                        var7.add(var5);
                        var11.add(var14);
                        continue;
                     }

                     return auk;
                  }

                  var2.gx = (com.google.android.gms.internal.d[])var7.toArray(new com.google.android.gms.internal.d[0]);
                  var2.gy = (com.google.android.gms.internal.d[])var11.toArray(new com.google.android.gms.internal.d[0]);
                  break;
               }
            } else if(v(var0)) {
               var2.type = 1;
               var2.gv = var0.toString();
            } else if(w(var0)) {
               var2.type = 6;
               var2.gB = x(var0);
            } else {
               if(!(var0 instanceof Boolean)) {
                  StringBuilder var9 = (new StringBuilder()).append("Converting to Value from unknown object type: ");
                  String var8;
                  if(var0 == null) {
                     var8 = "null";
                  } else {
                     var8 = var0.getClass().toString();
                  }

                  bh.T(var9.append(var8).toString());
                  return auk;
               }

               var2.type = 8;
               var2.gC = ((Boolean)var0).booleanValue();
            }
         }

         var2.gF = var1;
         return var2;
      }
   }

   private static boolean v(Object var0) {
      return var0 instanceof Double || var0 instanceof Float || var0 instanceof dh && ((dh)var0).qQ();
   }

   private static boolean w(Object var0) {
      return var0 instanceof Byte || var0 instanceof Short || var0 instanceof Integer || var0 instanceof Long || var0 instanceof dh && ((dh)var0).qR();
   }

   private static long x(Object var0) {
      if(var0 instanceof Number) {
         return ((Number)var0).longValue();
      } else {
         bh.T("getInt64 received non-Number");
         return 0L;
      }
   }
}
