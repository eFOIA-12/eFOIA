package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.ae;
import com.google.android.gms.analytics.an;
import com.google.android.gms.analytics.s;
import com.google.android.gms.analytics.y;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HitBuilders {
   @Deprecated
   public static class AppViewBuilder extends HitBuilders.HitBuilder {
      public AppViewBuilder() {
         y.eK().a(y.a.Bg);
         this.set("&t", "screenview");
      }
   }

   public static class EventBuilder extends HitBuilders.HitBuilder {
      public EventBuilder() {
         y.eK().a(y.a.AU);
         this.set("&t", "event");
      }

      public EventBuilder(String var1, String var2) {
         this();
         this.setCategory(var1);
         this.setAction(var2);
      }

      public HitBuilders.EventBuilder setAction(String var1) {
         this.set("&ea", var1);
         return this;
      }

      public HitBuilders.EventBuilder setCategory(String var1) {
         this.set("&ec", var1);
         return this;
      }

      public HitBuilders.EventBuilder setLabel(String var1) {
         this.set("&el", var1);
         return this;
      }

      public HitBuilders.EventBuilder setValue(long var1) {
         this.set("&ev", Long.toString(var1));
         return this;
      }
   }

   public static class ExceptionBuilder extends HitBuilders.HitBuilder {
      public ExceptionBuilder() {
         y.eK().a(y.a.AD);
         this.set("&t", "exception");
      }

      public HitBuilders.ExceptionBuilder setDescription(String var1) {
         this.set("&exd", var1);
         return this;
      }

      public HitBuilders.ExceptionBuilder setFatal(boolean var1) {
         this.set("&exf", an.E(var1));
         return this;
      }
   }

   protected static class HitBuilder {
      private Map BA = new HashMap();
      ProductAction BB;
      Map BC = new HashMap();
      List BD = new ArrayList();
      List BE = new ArrayList();

      public HitBuilders.HitBuilder addImpression(Product var1, String var2) {
         if(var1 == null) {
            ae.W("product should be non-null");
            return this;
         } else {
            String var3 = var2;
            if(var2 == null) {
               var3 = "";
            }

            if(!this.BC.containsKey(var3)) {
               this.BC.put(var3, new ArrayList());
            }

            ((List)this.BC.get(var3)).add(var1);
            return this;
         }
      }

      public HitBuilders.HitBuilder addProduct(Product var1) {
         if(var1 == null) {
            ae.W("product should be non-null");
            return this;
         } else {
            this.BE.add(var1);
            return this;
         }
      }

      public HitBuilders.HitBuilder addPromotion(Promotion var1) {
         if(var1 == null) {
            ae.W("promotion should be non-null");
            return this;
         } else {
            this.BD.add(var1);
            return this;
         }
      }

      public Map build() {
         HashMap var3 = new HashMap(this.BA);
         if(this.BB != null) {
            var3.putAll(this.BB.build());
         }

         Iterator var4 = this.BD.iterator();

         int var1;
         for(var1 = 1; var4.hasNext(); ++var1) {
            var3.putAll(((Promotion)var4.next()).aq(s.B(var1)));
         }

         var4 = this.BE.iterator();

         for(var1 = 1; var4.hasNext(); ++var1) {
            var3.putAll(((Product)var4.next()).aq(s.A(var1)));
         }

         var4 = this.BC.entrySet().iterator();

         for(var1 = 1; var4.hasNext(); ++var1) {
            Entry var5 = (Entry)var4.next();
            List var7 = (List)var5.getValue();
            String var6 = s.D(var1);
            Iterator var8 = var7.iterator();

            for(int var2 = 1; var8.hasNext(); ++var2) {
               var3.putAll(((Product)var8.next()).aq(var6 + s.C(var2)));
            }

            if(!TextUtils.isEmpty((CharSequence)var5.getKey())) {
               var3.put(var6 + "nm", var5.getKey());
            }
         }

         return var3;
      }

      protected String get(String var1) {
         return (String)this.BA.get(var1);
      }

      public final HitBuilders.HitBuilder set(String var1, String var2) {
         y.eK().a(y.a.zW);
         if(var1 != null) {
            this.BA.put(var1, var2);
            return this;
         } else {
            ae.W(" HitBuilder.set() called with a null paramName.");
            return this;
         }
      }

      public final HitBuilders.HitBuilder setAll(Map var1) {
         y.eK().a(y.a.zX);
         if(var1 == null) {
            return this;
         } else {
            this.BA.putAll(new HashMap(var1));
            return this;
         }
      }

      public HitBuilders.HitBuilder setCampaignParamsFromUrl(String var1) {
         y.eK().a(y.a.zZ);
         var1 = an.ao(var1);
         if(TextUtils.isEmpty(var1)) {
            return this;
         } else {
            Map var2 = an.an(var1);
            this.set("&cc", (String)var2.get("utm_content"));
            this.set("&cm", (String)var2.get("utm_medium"));
            this.set("&cn", (String)var2.get("utm_campaign"));
            this.set("&cs", (String)var2.get("utm_source"));
            this.set("&ck", (String)var2.get("utm_term"));
            this.set("&ci", (String)var2.get("utm_id"));
            this.set("&gclid", (String)var2.get("gclid"));
            this.set("&dclid", (String)var2.get("dclid"));
            this.set("&gmob_t", (String)var2.get("gmob_t"));
            return this;
         }
      }

      public HitBuilders.HitBuilder setCustomDimension(int var1, String var2) {
         this.set(s.y(var1), var2);
         return this;
      }

      public HitBuilders.HitBuilder setCustomMetric(int var1, float var2) {
         this.set(s.z(var1), Float.toString(var2));
         return this;
      }

      protected HitBuilders.HitBuilder setHitType(String var1) {
         this.set("&t", var1);
         return this;
      }

      public HitBuilders.HitBuilder setNewSession() {
         this.set("&sc", "start");
         return this;
      }

      public HitBuilders.HitBuilder setNonInteraction(boolean var1) {
         this.set("&ni", an.E(var1));
         return this;
      }

      public HitBuilders.HitBuilder setProductAction(ProductAction var1) {
         this.BB = var1;
         return this;
      }

      public HitBuilders.HitBuilder setPromotionAction(String var1) {
         this.BA.put("&promoa", var1);
         return this;
      }
   }

   @Deprecated
   public static class ItemBuilder extends HitBuilders.HitBuilder {
      public ItemBuilder() {
         y.eK().a(y.a.AV);
         this.set("&t", "item");
      }

      public HitBuilders.ItemBuilder setCategory(String var1) {
         this.set("&iv", var1);
         return this;
      }

      public HitBuilders.ItemBuilder setCurrencyCode(String var1) {
         this.set("&cu", var1);
         return this;
      }

      public HitBuilders.ItemBuilder setName(String var1) {
         this.set("&in", var1);
         return this;
      }

      public HitBuilders.ItemBuilder setPrice(double var1) {
         this.set("&ip", Double.toString(var1));
         return this;
      }

      public HitBuilders.ItemBuilder setQuantity(long var1) {
         this.set("&iq", Long.toString(var1));
         return this;
      }

      public HitBuilders.ItemBuilder setSku(String var1) {
         this.set("&ic", var1);
         return this;
      }

      public HitBuilders.ItemBuilder setTransactionId(String var1) {
         this.set("&ti", var1);
         return this;
      }
   }

   public static class ScreenViewBuilder extends HitBuilders.HitBuilder {
      public ScreenViewBuilder() {
         y.eK().a(y.a.Bg);
         this.set("&t", "screenview");
      }
   }

   public static class SocialBuilder extends HitBuilders.HitBuilder {
      public SocialBuilder() {
         y.eK().a(y.a.AG);
         this.set("&t", "social");
      }

      public HitBuilders.SocialBuilder setAction(String var1) {
         this.set("&sa", var1);
         return this;
      }

      public HitBuilders.SocialBuilder setNetwork(String var1) {
         this.set("&sn", var1);
         return this;
      }

      public HitBuilders.SocialBuilder setTarget(String var1) {
         this.set("&st", var1);
         return this;
      }
   }

   public static class TimingBuilder extends HitBuilders.HitBuilder {
      public TimingBuilder() {
         y.eK().a(y.a.AF);
         this.set("&t", "timing");
      }

      public TimingBuilder(String var1, String var2, long var3) {
         this();
         this.setVariable(var2);
         this.setValue(var3);
         this.setCategory(var1);
      }

      public HitBuilders.TimingBuilder setCategory(String var1) {
         this.set("&utc", var1);
         return this;
      }

      public HitBuilders.TimingBuilder setLabel(String var1) {
         this.set("&utl", var1);
         return this;
      }

      public HitBuilders.TimingBuilder setValue(long var1) {
         this.set("&utt", Long.toString(var1));
         return this;
      }

      public HitBuilders.TimingBuilder setVariable(String var1) {
         this.set("&utv", var1);
         return this;
      }
   }

   @Deprecated
   public static class TransactionBuilder extends HitBuilders.HitBuilder {
      public TransactionBuilder() {
         y.eK().a(y.a.AC);
         this.set("&t", "transaction");
      }

      public HitBuilders.TransactionBuilder setAffiliation(String var1) {
         this.set("&ta", var1);
         return this;
      }

      public HitBuilders.TransactionBuilder setCurrencyCode(String var1) {
         this.set("&cu", var1);
         return this;
      }

      public HitBuilders.TransactionBuilder setRevenue(double var1) {
         this.set("&tr", Double.toString(var1));
         return this;
      }

      public HitBuilders.TransactionBuilder setShipping(double var1) {
         this.set("&ts", Double.toString(var1));
         return this;
      }

      public HitBuilders.TransactionBuilder setTax(double var1) {
         this.set("&tt", Double.toString(var1));
         return this;
      }

      public HitBuilders.TransactionBuilder setTransactionId(String var1) {
         this.set("&ti", var1);
         return this;
      }
   }
}
