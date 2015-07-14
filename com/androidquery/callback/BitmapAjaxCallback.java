package com.androidquery.callback;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.media.ExifInterface;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.androidquery.AQuery;
import com.androidquery.auth.AccountHandle;
import com.androidquery.callback.AbstractAjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.callback.ImageOptions;
import com.androidquery.util.AQUtility;
import com.androidquery.util.BitmapCache;
import com.androidquery.util.Common;
import com.androidquery.util.RatioDrawable;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.http.HttpHost;

public class BitmapAjaxCallback extends AbstractAjaxCallback {
   private static int BIG_MAX = 20;
   private static int BIG_PIXELS = 160000;
   private static int BIG_TPIXELS = 1000000;
   private static boolean DELAY_WRITE = false;
   private static final int FADE_DUR = 300;
   private static int SMALL_MAX = 20;
   private static int SMALL_PIXELS = 2500;
   private static Map bigCache;
   private static Bitmap dummy;
   private static Bitmap empty;
   private static Map invalidCache;
   private static HashMap queueMap = new HashMap();
   private static Map smallCache;
   private float anchor = Float.MAX_VALUE;
   private int animation;
   private Bitmap bm;
   private int fallback;
   private File imageFile;
   private boolean invalid;
   private Bitmap preset;
   private float ratio;
   private boolean rotate;
   private int round;
   private boolean targetDim = true;
   private int targetWidth;
   private WeakReference v;

   static {
      empty = Bitmap.createBitmap(1, 1, Config.ALPHA_8);
      dummy = Bitmap.createBitmap(1, 1, Config.ALPHA_8);
   }

   public BitmapAjaxCallback() {
      ((BitmapAjaxCallback)((BitmapAjaxCallback)((BitmapAjaxCallback)this.type(Bitmap.class)).memCache(true)).fileCache(true)).url("");
   }

   private void addQueue(String var1, ImageView var2) {
      WeakHashMap var3 = (WeakHashMap)queueMap.get(var1);
      if(var3 == null) {
         if(queueMap.containsKey(var1)) {
            var3 = new WeakHashMap();
            var3.put(var2, this);
            queueMap.put(var1, var3);
         } else {
            queueMap.put(var1, (Object)null);
         }
      } else {
         var3.put(var2, this);
      }
   }

   public static void async(Activity var0, Context var1, ImageView var2, String var3, Object var4, AccountHandle var5, ImageOptions var6, HttpHost var7, String var8) {
      async(var0, var1, var2, var3, var6.memCache, var6.fileCache, var6.targetWidth, var6.fallback, var6.preset, var6.animation, var6.ratio, var6.anchor, var4, var5, var6.policy, var6.round, var7, var8);
   }

   public static void async(Activity var0, Context var1, ImageView var2, String var3, boolean var4, boolean var5, int var6, int var7, Bitmap var8, int var9, float var10, float var11, Object var12, AccountHandle var13, int var14, int var15, HttpHost var16, String var17) {
      Bitmap var18 = null;
      if(var4) {
         var18 = memGet(var3, var6, var15);
      }

      if(var18 != null) {
         var2.setTag(1090453505, var3);
         Common.showProgress(var12, var3, false);
         setBmAnimate(var2, var18, var8, var7, var9, var10, var11, 4);
      } else {
         BitmapAjaxCallback var19 = new BitmapAjaxCallback();
         ((BitmapAjaxCallback)((BitmapAjaxCallback)((BitmapAjaxCallback)((BitmapAjaxCallback)((BitmapAjaxCallback)((BitmapAjaxCallback)var19.url(var3)).imageView(var2).memCache(var4)).fileCache(var5)).targetWidth(var6).fallback(var7).preset(var8).animation(var9).ratio(var10).anchor(var11).progress(var12)).auth(var13)).policy(var14)).round(var15).networkUrl(var17);
         if(var16 != null) {
            var19.proxy(var16.getHostName(), var16.getPort());
         }

         if(var0 != null) {
            var19.async(var0);
         } else {
            var19.async(var1);
         }
      }
   }

   private Bitmap bmGet(String var1, byte[] var2) {
      return getResizedImage(var1, var2, this.targetWidth, this.targetDim, this.round, this.rotate);
   }

   private void checkCb(BitmapAjaxCallback var1, String var2, ImageView var3, Bitmap var4, AjaxStatus var5) {
      if(var3 != null && var1 != null) {
         if(var2.equals(var3.getTag(1090453505))) {
            if(var3 instanceof ImageView) {
               var1.callback(var2, var3, var4, var5);
            } else {
               var1.setBitmap(var2, var3, var4, false);
            }
         }

         var1.showProgress(false);
      }
   }

   public static void clearCache() {
      bigCache = null;
      smallCache = null;
      invalidCache = null;
   }

   protected static void clearTasks() {
      queueMap.clear();
   }

   private static Bitmap decode(String var0, byte[] var1, Options var2, boolean var3) {
      Bitmap var4 = null;
      if(var0 != null) {
         var4 = decodeFile(var0, var2, var3);
      } else if(var1 != null) {
         var4 = BitmapFactory.decodeByteArray(var1, 0, var1.length, var2);
      }

      if(var4 == null && var2 != null && !var2.inJustDecodeBounds) {
         AQUtility.debug("decode image failed", var0);
      }

      return var4;
   }

   private static Bitmap decodeFile(String param0, Options param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   private static boolean fadeIn(int var0, int var1) {
      boolean var3 = true;
      boolean var2 = var3;
      switch(var0) {
      case -3:
         var2 = var3;
         if(var1 == 3) {
            break;
         }
      case -2:
         if(var1 == 1) {
            return true;
         }
      default:
         var2 = false;
      case -1:
      }

      return var2;
   }

   private static Bitmap filter(View var0, Bitmap var1, int var2) {
      Bitmap var3 = var1;
      if(var1 != null) {
         var3 = var1;
         if(var1.getWidth() == 1) {
            var3 = var1;
            if(var1.getHeight() == 1) {
               var3 = var1;
               if(var1 != empty) {
                  var3 = null;
               }
            }
         }
      }

      if(var3 != null) {
         var0.setVisibility(0);
      } else {
         if(var2 == -2) {
            var0.setVisibility(8);
            return var3;
         }

         if(var2 == -1) {
            var0.setVisibility(4);
            return var3;
         }
      }

      return var3;
   }

   private static Map getBCache() {
      if(bigCache == null) {
         bigCache = Collections.synchronizedMap(new BitmapCache(BIG_MAX, BIG_PIXELS, BIG_TPIXELS));
      }

      return bigCache;
   }

   public static Bitmap getEmptyBitmap() {
      return empty;
   }

   private Bitmap getFallback() {
      Bitmap var1 = null;
      View var3 = (View)this.v.get();
      if(var3 != null) {
         String var4 = Integer.toString(this.fallback);
         Bitmap var2 = this.memGet(var4);
         var1 = var2;
         if(var2 == null) {
            var2 = BitmapFactory.decodeResource(var3.getResources(), this.fallback);
            var1 = var2;
            if(var2 != null) {
               this.memPut(var4, var2);
               var1 = var2;
            }
         }
      }

      return var1;
   }

   private static Map getICache() {
      if(invalidCache == null) {
         invalidCache = Collections.synchronizedMap(new BitmapCache(100, BIG_PIXELS, 250000));
      }

      return invalidCache;
   }

   private static String getKey(String var0, int var1, int var2) {
      String var3 = var0;
      if(var1 > 0) {
         var3 = var0 + "#" + var1;
      }

      var0 = var3;
      if(var2 > 0) {
         var0 = var3 + "#" + var2;
      }

      return var0;
   }

   public static Bitmap getMemoryCached(Context var0, int var1) {
      String var4 = Integer.toString(var1);
      Bitmap var3 = memGet(var4, 0, 0);
      Bitmap var2 = var3;
      if(var3 == null) {
         Bitmap var5 = BitmapFactory.decodeResource(var0.getResources(), var1);
         var2 = var5;
         if(var5 != null) {
            memPut(var4, 0, 0, var5, false);
            var2 = var5;
         }
      }

      return var2;
   }

   public static Bitmap getMemoryCached(String var0, int var1) {
      return memGet(var0, var1, 0);
   }

   public static Bitmap getResizedImage(String var0, byte[] var1, int var2, boolean var3, int var4) {
      return getResizedImage(var0, var1, var2, var3, var4, false);
   }

   public static Bitmap getResizedImage(String var0, byte[] var1, int var2, boolean var3, int var4, boolean var5) {
      Bitmap var12;
      if(var0 == null && var1 == null) {
         var12 = null;
      } else {
         Options var8 = null;
         if(var2 > 0) {
            var8 = new Options();
            var8.inJustDecodeBounds = true;
            decode(var0, var1, var8, var5);
            int var7 = var8.outWidth;
            int var6 = var7;
            if(!var3) {
               var6 = Math.max(var7, var8.outHeight);
            }

            var2 = sampleSize(var6, var2);
            var8 = new Options();
            var8.inSampleSize = var2;
         }

         Object var9 = null;

         Bitmap var11;
         try {
            var11 = decode(var0, var1, var8, var5);
         } catch (OutOfMemoryError var10) {
            clearCache();
            AQUtility.report(var10);
            var11 = (Bitmap)var9;
         }

         var12 = var11;
         if(var4 > 0) {
            return getRoundedCornerBitmap(var11, var4);
         }
      }

      return var12;
   }

   private static Matrix getRotateMatrix(int var0) {
      Matrix var1 = new Matrix();
      switch(var0) {
      case 2:
         var1.setScale(-1.0F, 1.0F);
         return var1;
      case 3:
         var1.setRotate(180.0F);
         return var1;
      case 4:
         var1.setRotate(180.0F);
         var1.postScale(-1.0F, 1.0F);
         return var1;
      case 5:
         var1.setRotate(90.0F);
         var1.postScale(-1.0F, 1.0F);
         return var1;
      case 6:
         var1.setRotate(90.0F);
         return var1;
      case 7:
         var1.setRotate(-90.0F);
         var1.postScale(-1.0F, 1.0F);
         return var1;
      case 8:
         var1.setRotate(-90.0F);
         return var1;
      default:
         return var1;
      }
   }

   private static Bitmap getRoundedCornerBitmap(Bitmap var0, int var1) {
      Bitmap var3 = Bitmap.createBitmap(var0.getWidth(), var0.getHeight(), Config.ARGB_8888);
      Canvas var4 = new Canvas(var3);
      Paint var5 = new Paint();
      Rect var6 = new Rect(0, 0, var0.getWidth(), var0.getHeight());
      RectF var7 = new RectF(var6);
      float var2 = (float)var1;
      var5.setAntiAlias(true);
      var4.drawARGB(0, 0, 0, 0);
      var5.setColor(-12434878);
      var4.drawRoundRect(var7, var2, var2, var5);
      var5.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
      var4.drawBitmap(var0, var6, var6, var5);
      return var3;
   }

   private static Map getSCache() {
      if(smallCache == null) {
         smallCache = Collections.synchronizedMap(new BitmapCache(SMALL_MAX, SMALL_PIXELS, 250000));
      }

      return smallCache;
   }

   private static boolean isInputSharable() {
      AQUtility.debug("level", Integer.valueOf(AQuery.SDK_INT));
      return AQuery.SDK_INT < 19;
   }

   public static boolean isMemoryCached(String var0) {
      return getBCache().containsKey(var0) || getSCache().containsKey(var0) || getICache().containsKey(var0);
   }

   private static Drawable makeDrawable(ImageView var0, Bitmap var1, float var2, float var3) {
      return (Drawable)(var2 > 0.0F?new RatioDrawable(var0.getResources(), var1, var0, var2, var3):new BitmapDrawable(var0.getResources(), var1));
   }

   private static Bitmap memGet(String var0, int var1, int var2) {
      String var4 = getKey(var0, var1, var2);
      Bitmap var3 = (Bitmap)getBCache().get(var4);
      Bitmap var5 = var3;
      if(var3 == null) {
         var5 = (Bitmap)getSCache().get(var4);
      }

      var3 = var5;
      if(var5 == null) {
         var5 = (Bitmap)getICache().get(var4);
         var3 = var5;
         if(var5 != null) {
            var3 = var5;
            if(getLastStatus() == 200) {
               invalidCache = null;
               var3 = null;
            }
         }
      }

      return var3;
   }

   private static void memPut(String var0, int var1, int var2, Bitmap var3, boolean var4) {
      if(var3 != null) {
         int var5 = var3.getWidth();
         int var6 = var3.getHeight();
         Map var7;
         if(var4) {
            var7 = getICache();
         } else if(var5 * var6 <= SMALL_PIXELS) {
            var7 = getSCache();
         } else {
            var7 = getBCache();
         }

         if(var1 <= 0 && var2 <= 0) {
            var7.put(var0, var3);
            return;
         }

         var7.put(getKey(var0, var1, var2), var3);
         if(!var7.containsKey(var0)) {
            var7.put(var0, (Object)null);
            return;
         }
      }

   }

   private void presetBitmap(String var1, ImageView var2) {
      if(!var1.equals(var2.getTag(1090453505)) || this.preset != null) {
         var2.setTag(1090453505, var1);
         if(this.preset == null || this.cacheAvailable(var2.getContext())) {
            this.setBitmap(var1, var2, (Bitmap)null, true);
            return;
         }

         this.setBitmap(var1, var2, this.preset, true);
      }

   }

   private static Bitmap rotate(String var0, Bitmap var1) {
      Bitmap var6;
      if(var1 == null) {
         var6 = null;
      } else {
         int var2 = 1;

         label20: {
            int var3;
            try {
               var3 = (new ExifInterface(var0)).getAttributeInt("Orientation", 1);
            } catch (Exception var5) {
               AQUtility.debug((Throwable)var5);
               break label20;
            }

            var2 = var3;
         }

         var6 = var1;
         if(var2 > 0) {
            Matrix var7 = getRotateMatrix(var2);
            Bitmap var4 = Bitmap.createBitmap(var1, 0, 0, var1.getWidth(), var1.getHeight(), var7, true);
            AQUtility.debug("before", var1.getWidth() + ":" + var1.getHeight());
            AQUtility.debug("after", var4.getWidth() + ":" + var4.getHeight());
            var6 = var4;
            if(var1 != var4) {
               var1.recycle();
               return var4;
            }
         }
      }

      return var6;
   }

   private static int sampleSize(int var0, int var1) {
      int var2 = 1;
      byte var4 = 0;
      int var3 = var0;

      for(var0 = var4; var0 < 10 && var3 >= var1 * 2; ++var0) {
         var3 /= 2;
         var2 *= 2;
      }

      return var2;
   }

   private void setBitmap(String var1, ImageView var2, Bitmap var3, boolean var4) {
      if(var3 == null) {
         var2.setImageDrawable((Drawable)null);
      } else {
         if(var4) {
            var2.setImageDrawable(makeDrawable(var2, var3, this.ratio, this.anchor));
            return;
         }

         if(this.status != null) {
            setBmAnimate(var2, var3, this.preset, this.fallback, this.animation, this.ratio, this.anchor, this.status.getSource());
            return;
         }
      }

   }

   private static void setBmAnimate(ImageView var0, Bitmap var1, Bitmap var2, int var3, int var4, float var5, float var6, int var7) {
      var1 = filter(var0, var1, var3);
      if(var1 == null) {
         var0.setImageBitmap((Bitmap)null);
      } else {
         Drawable var8 = makeDrawable(var0, var1, var5, var6);
         Object var9 = null;
         Object var10;
         if(fadeIn(var4, var7)) {
            if(var2 == null) {
               var9 = new AlphaAnimation(0.0F, 1.0F);
               ((Animation)var9).setInterpolator(new DecelerateInterpolator());
               ((Animation)var9).setDuration(300L);
               var10 = var8;
            } else {
               var10 = new TransitionDrawable(new Drawable[]{makeDrawable(var0, var2, var5, var6), var8});
               ((TransitionDrawable)var10).setCrossFadeEnabled(true);
               ((TransitionDrawable)var10).startTransition(300);
            }
         } else {
            var10 = var8;
            if(var4 > 0) {
               var9 = AnimationUtils.loadAnimation(var0.getContext(), var4);
               var10 = var8;
            }
         }

         var0.setImageDrawable((Drawable)var10);
         if(var9 != null) {
            ((Animation)var9).setStartTime(AnimationUtils.currentAnimationTimeMillis());
            var0.startAnimation((Animation)var9);
         } else {
            var0.setAnimation((Animation)null);
         }
      }
   }

   public static void setCacheLimit(int var0) {
      BIG_MAX = var0;
      clearCache();
   }

   public static void setDelayWrite(boolean var0) {
      DELAY_WRITE = var0;
   }

   public static void setIconCacheLimit(int var0) {
      SMALL_MAX = var0;
      clearCache();
   }

   public static void setMaxPixelLimit(int var0) {
      BIG_TPIXELS = var0;
      clearCache();
   }

   public static void setPixelLimit(int var0) {
      BIG_PIXELS = var0;
      clearCache();
   }

   public static void setSmallPixel(int var0) {
      SMALL_PIXELS = var0;
      clearCache();
   }

   protected File accessFile(File var1, String var2) {
      return this.imageFile != null && this.imageFile.exists()?this.imageFile:super.accessFile(var1, var2);
   }

   public BitmapAjaxCallback anchor(float var1) {
      this.anchor = var1;
      return this;
   }

   public BitmapAjaxCallback animation(int var1) {
      this.animation = var1;
      return this;
   }

   public void async(Context var1) {
      String var4 = this.getUrl();
      ImageView var2 = (ImageView)this.v.get();
      if(var4 == null) {
         this.showProgress(false);
         this.setBitmap(var4, var2, (Bitmap)null, false);
      } else {
         Bitmap var3 = this.memGet(var4);
         if(var3 != null) {
            var2.setTag(1090453505, var4);
            this.status = (new AjaxStatus()).source(4).done();
            this.callback(var4, var3, this.status);
         } else {
            this.presetBitmap(var4, var2);
            if(!queueMap.containsKey(var4)) {
               this.addQueue(var4, var2);
               super.async(var2.getContext());
            } else {
               this.showProgress(true);
               this.addQueue(var4, var2);
            }
         }
      }
   }

   public BitmapAjaxCallback bitmap(Bitmap var1) {
      this.bm = var1;
      return this;
   }

   public final void callback(String var1, Bitmap var2, AjaxStatus var3) {
      ImageView var5 = (ImageView)this.v.get();
      WeakHashMap var4 = (WeakHashMap)queueMap.remove(var1);
      if(var4 == null || !var4.containsKey(var5)) {
         this.checkCb(this, var1, var5, var2, var3);
      }

      if(var4 != null) {
         Iterator var8 = var4.keySet().iterator();

         while(var8.hasNext()) {
            ImageView var6 = (ImageView)var8.next();
            BitmapAjaxCallback var7 = (BitmapAjaxCallback)var4.get(var6);
            var7.status = var3;
            this.checkCb(var7, var1, var6, var2, var3);
         }
      }

   }

   protected void callback(String var1, ImageView var2, Bitmap var3, AjaxStatus var4) {
      this.setBitmap(var1, var2, var3, false);
   }

   public BitmapAjaxCallback fallback(int var1) {
      this.fallback = var1;
      return this;
   }

   public BitmapAjaxCallback file(File var1) {
      this.imageFile = var1;
      return this;
   }

   protected Bitmap fileGet(String var1, File var2, AjaxStatus var3) {
      return this.bmGet(var2.getAbsolutePath(), (byte[])null);
   }

   public BitmapAjaxCallback imageView(ImageView var1) {
      this.v = new WeakReference(var1);
      return this;
   }

   protected boolean isStreamingContent() {
      return !DELAY_WRITE;
   }

   protected Bitmap memGet(String var1) {
      return this.bm != null?this.bm:(!this.memCache?null:memGet(var1, this.targetWidth, this.round));
   }

   protected void memPut(String var1, Bitmap var2) {
      memPut(var1, this.targetWidth, this.round, var2, this.invalid);
   }

   public BitmapAjaxCallback preset(Bitmap var1) {
      this.preset = var1;
      return this;
   }

   public BitmapAjaxCallback ratio(float var1) {
      this.ratio = var1;
      return this;
   }

   public BitmapAjaxCallback rotate(boolean var1) {
      this.rotate = var1;
      return this;
   }

   public BitmapAjaxCallback round(int var1) {
      this.round = var1;
      return this;
   }

   protected void skip(String var1, Bitmap var2, AjaxStatus var3) {
      queueMap.remove(var1);
   }

   public BitmapAjaxCallback targetWidth(int var1) {
      this.targetWidth = var1;
      return this;
   }

   public Bitmap transform(String var1, byte[] var2, AjaxStatus var3) {
      var1 = null;
      File var4 = var3.getFile();
      if(var4 != null) {
         var1 = var4.getAbsolutePath();
      }

      Bitmap var5 = this.bmGet(var1, var2);
      Bitmap var6 = var5;
      if(var5 == null) {
         if(this.fallback > 0) {
            var5 = this.getFallback();
         } else if(this.fallback != -2 && this.fallback != -1) {
            if(this.fallback == -3) {
               var5 = this.preset;
            }
         } else {
            var5 = dummy;
         }

         if(var3.getCode() != 200) {
            this.invalid = true;
         }

         var6 = var5;
         if(var3.getSource() == 1) {
            var6 = var5;
            if(var4 != null) {
               AQUtility.debug((Object)"invalid bm from net");
               var4.delete();
               var6 = var5;
            }
         }
      }

      return var6;
   }
}
