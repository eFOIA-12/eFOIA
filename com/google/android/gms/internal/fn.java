package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.google.android.gms.internal.ah;
import com.google.android.gms.internal.ai;
import com.google.android.gms.internal.bv;
import com.google.android.gms.internal.cd;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.fp;
import com.google.android.gms.internal.fy;
import com.google.android.gms.internal.gj;
import com.google.android.gms.internal.gk;
import com.google.android.gms.internal.gn;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.gu;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.lh;
import com.google.android.gms.internal.u;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public class fn implements Callable {
   private final Context mContext;
   private final Object mH = new Object();
   private final u pM;
   private final fy.a tB;
   private int tq;
   private final gn ul;
   private final ai um;
   private boolean un;
   private List uo;

   public fn(Context var1, u var2, ai var3, gn var4, fy.a var5) {
      this.mContext = var1;
      this.pM = var2;
      this.ul = var4;
      this.um = var3;
      this.tB = var5;
      this.un = false;
      this.tq = -2;
      this.uo = null;
   }

   private bv.a a(ah var1, fn.a var2, JSONObject var3) throws ExecutionException, InterruptedException, JSONException {
      if(this.cO()) {
         return null;
      } else {
         String[] var4 = this.b(var3.getJSONObject("tracking_urls_and_actions"), "impression_tracking_urls");
         List var6;
         if(var4 == null) {
            var6 = null;
         } else {
            var6 = Arrays.asList(var4);
         }

         this.uo = var6;
         bv.a var5 = var2.a(this, var3);
         if(var5 == null) {
            gr.T("Failed to retrieve ad assets.");
            return null;
         } else {
            var5.a(new bv(this.pM, var1, var3));
            return var5;
         }
      }
   }

   private fy a(bv.a param1) {
      // $FF: Couldn't be decompiled
   }

   private String[] b(JSONObject var1, String var2) throws JSONException {
      JSONArray var4 = var1.optJSONArray(var2);
      if(var4 == null) {
         return null;
      } else {
         String[] var5 = new String[var4.length()];

         for(int var3 = 0; var3 < var4.length(); ++var3) {
            var5[var3] = var4.getString(var3);
         }

         return var5;
      }
   }

   private JSONObject c(final ah var1) throws TimeoutException, JSONException {
      if(this.cO()) {
         return null;
      } else {
         final gj var2 = new gj();
         var1.a("/nativeAdPreProcess", new cd() {
            public void a(gu var1x, Map var2x) {
               var1.g("/nativeAdPreProcess");

               try {
                  String var4 = (String)var2x.get("success");
                  if(!TextUtils.isEmpty(var4)) {
                     var2.a((new JSONObject(var4)).getJSONArray("ads").getJSONObject(0));
                     return;
                  }
               } catch (JSONException var3) {
                  gr.b("Malformed native JSON response.", var3);
               }

               fn.this.t(0);
               jx.a(fn.this.cO(), "Unable to set the ad state error!");
               var2.a((Object)null);
            }
         });
         var1.a("google.afma.nativeAds.preProcessJsonGmsg", new JSONObject(this.tB.vK.tU));
         return (JSONObject)var2.get();
      }
   }

   private ah cN() throws CancellationException, ExecutionException, InterruptedException, TimeoutException {
      if(this.cO()) {
         return null;
      } else {
         ah var1 = (ah)this.um.a(this.mContext, this.tB.vJ.lO, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/native_ads.html").get();
         var1.a(this.pM, this.pM, this.pM, this.pM, false, this.pM);
         return var1;
      }
   }

   public Future a(JSONObject var1, String var2, final boolean var3) throws JSONException {
      if(var3) {
         var1 = var1.getJSONObject(var2);
      } else {
         var1 = var1.optJSONObject(var2);
      }

      JSONObject var4 = var1;
      if(var1 == null) {
         var4 = new JSONObject();
      }

      String var5;
      if(var3) {
         var5 = var4.getString("url");
      } else {
         var5 = var4.optString("url");
      }

      if(TextUtils.isEmpty(var5)) {
         this.a(0, var3);
         return new gk((Object)null);
      } else {
         return this.ul.a(var5, new gn.a() {
            public Drawable a(InputStream var1) {
               byte[] var3x;
               try {
                  var3x = lh.d(var1);
               } catch (IOException var2) {
                  var3x = null;
               }

               if(var3x == null) {
                  fn.this.a(2, var3);
                  return null;
               } else {
                  Bitmap var4 = BitmapFactory.decodeByteArray(var3x, 0, var3x.length);
                  if(var4 == null) {
                     fn.this.a(2, var3);
                     return null;
                  } else {
                     return new BitmapDrawable(Resources.getSystem(), var4);
                  }
               }
            }

            // $FF: synthetic method
            public Object b(InputStream var1) {
               return this.a(var1);
            }

            public Drawable cP() {
               fn.this.a(2, var3);
               return null;
            }

            // $FF: synthetic method
            public Object cQ() {
               return this.cP();
            }
         });
      }
   }

   public void a(int var1, boolean var2) {
      if(var2) {
         this.t(var1);
      }

   }

   protected fn.a b(JSONObject var1) throws JSONException {
      if(this.cO()) {
         return null;
      } else {
         String var2 = var1.getString("template_id");
         if("2".equals(var2)) {
            return new fo();
         } else if("1".equals(var2)) {
            return new fp();
         } else {
            this.t(0);
            return null;
         }
      }
   }

   public fy cM() {
      try {
         ah var1 = this.cN();
         JSONObject var2 = this.c(var1);
         fy var8 = this.a(this.a(var1, this.b(var2), var2));
         return var8;
      } catch (CancellationException var3) {
         ;
      } catch (ExecutionException var4) {
         ;
      } catch (InterruptedException var5) {
         ;
      } catch (JSONException var6) {
         gr.d("Malformed native JSON response.", var6);
      } catch (TimeoutException var7) {
         gr.d("Timeout when loading native ad.", var7);
      }

      if(!this.un) {
         this.t(0);
      }

      return this.a((bv.a)null);
   }

   public boolean cO() {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   public Object call() throws Exception {
      return this.cM();
   }

   public void t(int param1) {
      // $FF: Couldn't be decompiled
   }

   public interface a {
      bv.a a(fn var1, JSONObject var2) throws JSONException, InterruptedException, ExecutionException;
   }
}
