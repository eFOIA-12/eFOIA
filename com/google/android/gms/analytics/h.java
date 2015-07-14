package com.google.android.gms.analytics;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.analytics.ab;
import com.google.android.gms.analytics.ac;
import com.google.android.gms.analytics.ae;
import com.google.android.gms.analytics.af;
import com.google.android.gms.analytics.an;
import com.google.android.gms.analytics.i;
import com.google.android.gms.analytics.l;
import com.google.android.gms.analytics.o;
import com.google.android.gms.analytics.r;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

public class h implements r {
   private final Context mContext;
   private final String wl;
   private final HttpClient yf;
   private URL yg;
   private int yh;
   private int yi;
   private int yj;
   private String yk;
   private String yl;
   private i ym;
   private l yn;
   private Set yo = new HashSet();
   private boolean yp = false;
   private long yq;
   private long yr;
   private o ys;
   private volatile boolean yt = false;

   h(HttpClient var1, Context var2, o var3) {
      this.mContext = var2.getApplicationContext();
      this.ys = var3;
      this.wl = this.a("GoogleAnalytics", "4.0", VERSION.RELEASE, an.a(Locale.getDefault()), Build.MODEL, Build.ID);
      this.yf = var1;
   }

   private String a(ab var1, List var2, i var3) {
      String var8;
      if(var3 != i.yw) {
         String var7 = "";
         Iterator var9 = var2.iterator();

         while(var9.hasNext()) {
            String var6 = (String)var9.next();
            if(var6.length() != 0) {
               var8 = var7;
               if(var7.length() != 0) {
                  var8 = var7 + "\n";
               }

               var7 = var8 + var6;
            }
         }

         return var7;
      } else {
         if(var1.fa() != null && var1.fa().length() != 0) {
            var8 = var1.fa();
         } else {
            var8 = "";
         }

         long var4 = System.currentTimeMillis();
         return TextUtils.isEmpty(var8)?"":ac.a(var1, var4);
      }
   }

   private URL a(ab param1) {
      // $FF: Couldn't be decompiled
   }

   private void a(af var1, HttpHost var2, i var3, l var4) {
      var1.g("_bs", var3.toString());
      var1.g("_cs", var4.toString());
      String var7 = var1.fg();
      if(!TextUtils.isEmpty(var7)) {
         if(var2 == null) {
            try {
               URL var6 = new URL("https://ssl.google-analytics.com");
               var2 = new HttpHost(var6.getHost(), var6.getPort(), var6.getProtocol());
            } catch (MalformedURLException var5) {
               return;
            }
         }

         this.a(var7, var2, 1, var1, l.yI);
      }
   }

   private void a(HttpEntityEnclosingRequest param1) {
      // $FF: Couldn't be decompiled
   }

   private boolean a(String param1, HttpHost param2, int param3, af param4, l param5) {
      // $FF: Couldn't be decompiled
   }

   private HttpEntityEnclosingRequest d(String var1, boolean var2) {
      if(TextUtils.isEmpty(var1)) {
         System.out.println("Empty hit, discarding.");
         return null;
      } else {
         var1 = this.yk + "?" + var1;
         BasicHttpEntityEnclosingRequest var3;
         if(var1.length() < this.yh && !var2) {
            var3 = new BasicHttpEntityEnclosingRequest("GET", var1);
         } else if(var2) {
            var3 = new BasicHttpEntityEnclosingRequest("POST", this.yl);
         } else {
            var3 = new BasicHttpEntityEnclosingRequest("POST", this.yk);
         }

         var3.addHeader("User-Agent", this.wl);
         return var3;
      }
   }

   int a(List var1, int var2) {
      int var4;
      if(var1.isEmpty()) {
         var4 = 0;
      } else {
         int var3 = var2;
         if(var2 > var1.size()) {
            var3 = var1.size();
         }

         var4 = var3 - 1;
         long var5 = 0L;
         var2 = var3;
         var3 = var4;

         while(true) {
            var4 = var2;
            if(var3 <= 0) {
               break;
            }

            ab var11 = (ab)var1.get(var3 - 1);
            ab var12 = (ab)var1.get(var3);
            long var7 = var11.fc();
            long var9 = var12.fc();
            if(var7 != 0L && var9 != 0L && var9 - var7 > var5) {
               var5 = var9 - var7;
               var2 = var3;
            }

            --var3;
         }
      }

      return var4;
   }

   public int a(List var1, af var2, boolean var3) {
      this.yh = this.ys.eb();
      this.yi = this.ys.ec();
      this.yj = this.ys.ed();
      int var4 = this.ys.ee();
      this.yk = this.ys.eg();
      this.yl = this.ys.eh();
      this.ym = this.ys.ei();
      this.yn = this.ys.ej();
      this.yo.clear();
      this.yo.addAll(this.ys.ek());
      this.yr = this.ys.ef();
      if(!this.yp && this.yo.isEmpty()) {
         this.yp = true;
         this.yq = System.currentTimeMillis();
      }

      if(this.yp && System.currentTimeMillis() - this.yq > 1000L * this.yr) {
         this.yp = false;
      }

      l var16;
      i var17;
      if(this.yp) {
         var17 = i.yw;
         var16 = l.yI;
      } else {
         var17 = this.ym;
         var16 = this.yn;
      }

      byte var8 = 0;
      int var6 = Math.min(var1.size(), var4);
      var2.e("_hr", var1.size());
      long var13 = System.currentTimeMillis();
      ArrayList var19 = new ArrayList();
      ArrayList var20 = new ArrayList();
      long var9 = 0L;
      int var5;
      int var7;
      String var24;
      if(var17 != i.yw) {
         Iterator var21 = var1.iterator();
         var5 = 0;

         while(true) {
            if(!var21.hasNext()) {
               var6 = 1;
               break;
            }

            ab var15 = (ab)var21.next();
            if(TextUtils.isEmpty(var15.fa())) {
               var24 = "";
            } else {
               var24 = ac.a(var15, var13);
            }

            String var18 = var24;
            if(var24.getBytes().length > this.yi) {
               var18 = "";
            }

            var19.add(var18);
            long var11 = var9;
            if(!TextUtils.isEmpty(var18)) {
               var7 = var18.getBytes().length;
               byte var22;
               if(var5 == 0) {
                  var22 = 0;
               } else {
                  var22 = 1;
               }

               var11 = var9 + (long)(var22 + var7);
            }

            var20.add(Long.valueOf(var11));
            if(var11 <= (long)this.yj) {
               var4 = var5 + 1;
            } else {
               var4 = var5;
            }

            if(var4 == var6) {
               var6 = 1;
               var9 = var11;
               var5 = var4;
               break;
            }

            var5 = var4;
            var9 = var11;
         }
      } else {
         var5 = 0;
      }

      while(var5 > 1 && ((Long)var20.get(var5 - 1)).longValue() > (long)this.yj) {
         --var5;
      }

      Object var25;
      label114: {
         if(var9 > (long)this.yj) {
            label109:
            switch(null.yv[var17.ordinal()]) {
            case 1:
               var7 = var19.size() / 2;
               var4 = var7;
               if(var5 <= var7) {
                  var4 = var5;
               }
               break;
            case 2:
               var4 = this.a(var1, var5);
               break;
            case 3:
               var4 = this.b(var1, var5);
               break;
            case 4:
               if(var9 < (long)(this.yj * 2)) {
                  var4 = var20.size() - 1;

                  while(true) {
                     if(var4 <= 0 || ((Long)var20.get(var4)).longValue() <= var9 / 2L) {
                        break label109;
                     }

                     --var4;
                  }
               } else {
                  var4 = var5;
                  break;
               }
            case 5:
               var4 = var5;
               break;
            default:
               ae.W("Unexpected batching strategy encountered; sending a single hit.");
               var24 = (String)var19.get(0);
               var19.clear();
               var19.add(var24);
               var4 = 1;
            }

            if(var4 < var19.size()) {
               var25 = var19.subList(0, var4);
               break label114;
            }
         }

         var25 = var19;
      }

      var4 = 0;
      HttpHost var26 = null;
      var7 = 0;

      for(var5 = var8; var7 < var6; ++var7) {
         ab var27 = (ab)var1.get(var7);
         URL var29 = this.a(var27);
         int var23 = Math.max(1, ((List)var25).size());
         if(var29 == null) {
            ae.W("No destination: discarding hit.");
            var4 += var23;
            var5 += var23;
         } else {
            var26 = new HttpHost(var29.getHost(), var29.getPort(), var29.getProtocol());
            if(!this.a(this.a(var27, (List)var25, var17), var26, var23, var2, var16)) {
               var2.e("_de", 1);
               var2.e("_hd", var4);
               var2.e("_hs", var5);
               this.a(var2, var26, var17, var16);
               return var5;
            }

            Iterator var28 = ((List)var25).iterator();

            while(var28.hasNext()) {
               if(TextUtils.isEmpty((String)var28.next())) {
                  ++var4;
               }
            }

            var2.e("_rs", 1);
            var5 += var23;
         }
      }

      var2.e("_hd", var4);
      var2.e("_hs", var5);
      if(var3) {
         this.a(var2, var26, var17, var16);
      }

      return var5;
   }

   String a(String var1, String var2, String var3, String var4, String var5, String var6) {
      return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{var1, var2, var3, var4, var5, var6});
   }

   public void ad(String var1) {
      try {
         this.yg = new URL(var1);
      } catch (MalformedURLException var2) {
         this.yg = null;
      }
   }

   int b(List var1, int var2) {
      int var3;
      if(var1.isEmpty()) {
         var3 = 0;
      } else {
         int var4 = var2 - 1;

         while(true) {
            var3 = var2;
            if(var4 <= 0) {
               break;
            }

            String var5 = ((ab)var1.get(var4)).fa();
            if(!TextUtils.isEmpty(var5)) {
               if(var5.contains("sc=start")) {
                  return var4;
               }

               if(var5.contains("sc=end")) {
                  return var4 + 1;
               }
            }

            --var4;
         }
      }

      return var3;
   }

   public boolean ea() {
      NetworkInfo var1 = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if(var1 != null && var1.isConnected()) {
         return true;
      } else {
         ae.V("...no network connectivity");
         return false;
      }
   }

   public void setDryRun(boolean var1) {
      this.yt = var1;
   }
}
