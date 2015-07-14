package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.bh;
import com.google.android.gms.tagmanager.df;
import com.google.android.gms.tagmanager.dg;
import com.google.android.gms.tagmanager.di;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class dj extends dg {
   private static final String ID;
   private static final String aul;
   private static final String aum;
   private static final String aun;
   private static final String auo;
   private static final String aup;
   private static final String auq;
   private static final String aur;
   private static final String aus;
   private static final String aut;
   private static final List auu;
   private static final Pattern auv;
   private static final Pattern auw;
   private static Map aux;
   private static Map auy;
   private final DataLayer aqn;
   private final df auA;
   private final Set auz;

   static {
      ID = com.google.android.gms.internal.a.aO.toString();
      aul = com.google.android.gms.internal.b.bj.toString();
      aum = com.google.android.gms.internal.b.bs.toString();
      aun = com.google.android.gms.internal.b.cE.toString();
      auo = com.google.android.gms.internal.b.cz.toString();
      aup = com.google.android.gms.internal.b.cy.toString();
      auq = com.google.android.gms.internal.b.br.toString();
      aur = com.google.android.gms.internal.b.eN.toString();
      aus = com.google.android.gms.internal.b.eQ.toString();
      aut = com.google.android.gms.internal.b.eS.toString();
      auu = Arrays.asList(new String[]{"detail", "checkout", "checkout_option", "click", "add", "remove", "purchase", "refund"});
      auv = Pattern.compile("dimension(\\d+)");
      auw = Pattern.compile("metric(\\d+)");
   }

   public dj(Context var1, DataLayer var2) {
      this(var1, var2, new df(var1));
   }

   dj(Context var1, DataLayer var2, df var3) {
      super(ID, new String[0]);
      this.aqn = var2;
      this.auA = var3;
      this.auz = new HashSet();
      this.auz.add("");
      this.auz.add("0");
      this.auz.add("false");
   }

   private Promotion L(Map var1) {
      Promotion var2 = new Promotion();
      String var3 = (String)var1.get("id");
      if(var3 != null) {
         var2.setId(String.valueOf(var3));
      }

      var3 = (String)var1.get("name");
      if(var3 != null) {
         var2.setName(String.valueOf(var3));
      }

      var3 = (String)var1.get("creative");
      if(var3 != null) {
         var2.setCreative(String.valueOf(var3));
      }

      String var4 = (String)var1.get("position");
      if(var4 != null) {
         var2.setPosition(String.valueOf(var4));
      }

      return var2;
   }

   private Product M(Map var1) {
      Product var3 = new Product();
      Object var4 = var1.get("id");
      if(var4 != null) {
         var3.setId(String.valueOf(var4));
      }

      var4 = var1.get("name");
      if(var4 != null) {
         var3.setName(String.valueOf(var4));
      }

      var4 = var1.get("brand");
      if(var4 != null) {
         var3.setBrand(String.valueOf(var4));
      }

      var4 = var1.get("category");
      if(var4 != null) {
         var3.setCategory(String.valueOf(var4));
      }

      var4 = var1.get("variant");
      if(var4 != null) {
         var3.setVariant(String.valueOf(var4));
      }

      var4 = var1.get("coupon");
      if(var4 != null) {
         var3.setCouponCode(String.valueOf(var4));
      }

      var4 = var1.get("position");
      if(var4 != null) {
         var3.setPosition(this.z(var4).intValue());
      }

      var4 = var1.get("price");
      if(var4 != null) {
         var3.setPrice(this.y(var4).doubleValue());
      }

      var4 = var1.get("quantity");
      if(var4 != null) {
         var3.setQuantity(this.z(var4).intValue());
      }

      Iterator var9 = var1.keySet().iterator();

      while(var9.hasNext()) {
         String var5 = (String)var9.next();
         Matcher var6 = auv.matcher(var5);
         int var2;
         if(var6.matches()) {
            try {
               var2 = Integer.parseInt(var6.group(1));
            } catch (NumberFormatException var7) {
               bh.W("illegal number in custom dimension value: " + var5);
               continue;
            }

            var3.setCustomDimension(var2, String.valueOf(var1.get(var5)));
         } else {
            var6 = auw.matcher(var5);
            if(var6.matches()) {
               try {
                  var2 = Integer.parseInt(var6.group(1));
               } catch (NumberFormatException var8) {
                  bh.W("illegal number in custom metric value: " + var5);
                  continue;
               }

               var3.setCustomMetric(var2, this.z(var1.get(var5)).intValue());
            }
         }
      }

      return var3;
   }

   private Map N(Map var1) {
      com.google.android.gms.internal.d var2 = (com.google.android.gms.internal.d)var1.get(aus);
      if(var2 != null) {
         return this.c(var2);
      } else {
         if(aux == null) {
            HashMap var3 = new HashMap();
            var3.put("transactionId", "&ti");
            var3.put("transactionAffiliation", "&ta");
            var3.put("transactionTax", "&tt");
            var3.put("transactionShipping", "&ts");
            var3.put("transactionTotal", "&tr");
            var3.put("transactionCurrency", "&cu");
            aux = var3;
         }

         return aux;
      }
   }

   private Map O(Map var1) {
      com.google.android.gms.internal.d var2 = (com.google.android.gms.internal.d)var1.get(aut);
      if(var2 != null) {
         return this.c(var2);
      } else {
         if(auy == null) {
            HashMap var3 = new HashMap();
            var3.put("name", "&in");
            var3.put("sku", "&ic");
            var3.put("category", "&iv");
            var3.put("price", "&ip");
            var3.put("quantity", "&iq");
            var3.put("currency", "&cu");
            auy = var3;
         }

         return auy;
      }
   }

   private void a(Tracker param1, Map param2) {
      // $FF: Couldn't be decompiled
   }

   private void b(Tracker param1, Map param2) {
      // $FF: Couldn't be decompiled
   }

   private void b(Map var1, String var2, String var3) {
      if(var3 != null) {
         var1.put(var2, var3);
      }

   }

   private ProductAction c(String var1, Map var2) {
      ProductAction var4 = new ProductAction(var1);
      Object var3 = var2.get("id");
      if(var3 != null) {
         var4.setTransactionId(String.valueOf(var3));
      }

      var3 = var2.get("affiliation");
      if(var3 != null) {
         var4.setTransactionAffiliation(String.valueOf(var3));
      }

      var3 = var2.get("coupon");
      if(var3 != null) {
         var4.setTransactionCouponCode(String.valueOf(var3));
      }

      var3 = var2.get("list");
      if(var3 != null) {
         var4.setProductActionList(String.valueOf(var3));
      }

      var3 = var2.get("option");
      if(var3 != null) {
         var4.setCheckoutOptions(String.valueOf(var3));
      }

      var3 = var2.get("revenue");
      if(var3 != null) {
         var4.setTransactionRevenue(this.y(var3).doubleValue());
      }

      var3 = var2.get("tax");
      if(var3 != null) {
         var4.setTransactionTax(this.y(var3).doubleValue());
      }

      var3 = var2.get("shipping");
      if(var3 != null) {
         var4.setTransactionShipping(this.y(var3).doubleValue());
      }

      Object var5 = var2.get("step");
      if(var5 != null) {
         var4.setCheckoutStep(this.z(var5).intValue());
      }

      return var4;
   }

   private Map c(com.google.android.gms.internal.d var1) {
      Object var4 = di.o(var1);
      if(!(var4 instanceof Map)) {
         return null;
      } else {
         Map var2 = (Map)var4;
         LinkedHashMap var5 = new LinkedHashMap();
         Iterator var6 = var2.entrySet().iterator();

         while(var6.hasNext()) {
            Entry var3 = (Entry)var6.next();
            var5.put(var3.getKey().toString(), var3.getValue().toString());
         }

         return var5;
      }
   }

   private String de(String var1) {
      Object var2 = this.aqn.get(var1);
      return var2 == null?null:var2.toString();
   }

   private List df(String var1) {
      Object var3 = this.aqn.get(var1);
      if(var3 == null) {
         return null;
      } else if(!(var3 instanceof List)) {
         throw new IllegalArgumentException("transactionProducts should be of type List.");
      } else {
         Iterator var2 = ((List)var3).iterator();

         do {
            if(!var2.hasNext()) {
               return (List)var3;
            }
         } while(var2.next() instanceof Map);

         throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
      }
   }

   private boolean f(Map var1, String var2) {
      com.google.android.gms.internal.d var3 = (com.google.android.gms.internal.d)var1.get(var2);
      return var3 == null?false:di.n(var3).booleanValue();
   }

   private Map p(com.google.android.gms.internal.d var1) {
      if(var1 == null) {
         return new HashMap();
      } else {
         Map var3 = this.c(var1);
         if(var3 == null) {
            return new HashMap();
         } else {
            String var2 = (String)var3.get("&aip");
            if(var2 != null && this.auz.contains(var2.toLowerCase())) {
               var3.remove("&aip");
            }

            return var3;
         }
      }
   }

   private Double y(Object var1) {
      if(var1 instanceof String) {
         try {
            Double var3 = Double.valueOf((String)var1);
            return var3;
         } catch (NumberFormatException var2) {
            throw new RuntimeException("Cannot convert the object to Double: " + var2.getMessage());
         }
      } else if(var1 instanceof Integer) {
         return Double.valueOf(((Integer)var1).doubleValue());
      } else if(var1 instanceof Double) {
         return (Double)var1;
      } else {
         throw new RuntimeException("Cannot convert the object to Double: " + var1.toString());
      }
   }

   private Integer z(Object var1) {
      if(var1 instanceof String) {
         try {
            Integer var3 = Integer.valueOf((String)var1);
            return var3;
         } catch (NumberFormatException var2) {
            throw new RuntimeException("Cannot convert the object to Integer: " + var2.getMessage());
         }
      } else if(var1 instanceof Double) {
         return Integer.valueOf(((Double)var1).intValue());
      } else if(var1 instanceof Integer) {
         return (Integer)var1;
      } else {
         throw new RuntimeException("Cannot convert the object to Integer: " + var1.toString());
      }
   }

   public void D(Map var1) {
      Tracker var2 = this.auA.cW("_GTM_DEFAULT_TRACKER_");
      var2.enableAdvertisingIdCollection(this.f(var1, "collect_adid"));
      if(this.f(var1, aun)) {
         this.b(var2, var1);
      } else if(this.f(var1, aum)) {
         var2.send(this.p((com.google.android.gms.internal.d)var1.get(auq)));
      } else if(this.f(var1, aur)) {
         this.a(var2, var1);
      } else {
         bh.W("Ignoring unknown tag.");
      }
   }
}
