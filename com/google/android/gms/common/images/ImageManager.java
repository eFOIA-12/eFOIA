package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.images.a;
import com.google.android.gms.internal.jc;
import com.google.android.gms.internal.je;
import com.google.android.gms.internal.kj;
import com.google.android.gms.internal.ll;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
   private static final Object Lu = new Object();
   private static HashSet Lv = new HashSet();
   private static ImageManager Lw;
   private static ImageManager Lx;
   private final jc LA;
   private final Map LB;
   private final Map LC;
   private final Map LD;
   private final ExecutorService Ly;
   private final ImageManager.b Lz;
   private final Context mContext;
   private final Handler mHandler;

   private ImageManager(Context var1, boolean var2) {
      this.mContext = var1.getApplicationContext();
      this.mHandler = new Handler(Looper.getMainLooper());
      this.Ly = Executors.newFixedThreadPool(4);
      if(var2) {
         this.Lz = new ImageManager.b(this.mContext);
         if(ll.ij()) {
            this.hd();
         }
      } else {
         this.Lz = null;
      }

      this.LA = new jc();
      this.LB = new HashMap();
      this.LC = new HashMap();
      this.LD = new HashMap();
   }

   // $FF: synthetic method
   static Bitmap a(ImageManager var0, a.a var1) {
      return var0.a(var1);
   }

   private Bitmap a(a.a var1) {
      return this.Lz == null?null:(Bitmap)this.Lz.get(var1);
   }

   public static ImageManager c(Context var0, boolean var1) {
      if(var1) {
         if(Lx == null) {
            Lx = new ImageManager(var0, true);
         }

         return Lx;
      } else {
         if(Lw == null) {
            Lw = new ImageManager(var0, false);
         }

         return Lw;
      }
   }

   public static ImageManager create(Context var0) {
      return c(var0, false);
   }

   // $FF: synthetic method
   static Map e(ImageManager var0) {
      return var0.LC;
   }

   // $FF: synthetic method
   static ImageManager.b h(ImageManager var0) {
      return var0.Lz;
   }

   private void hd() {
      this.mContext.registerComponentCallbacks(new ImageManager.e(this.Lz));
   }

   // $FF: synthetic method
   static Object he() {
      return Lu;
   }

   // $FF: synthetic method
   static HashSet hf() {
      return Lv;
   }

   public void a(a var1) {
      je.aU("ImageManager.loadImage() must be called in the main thread");
      (new ImageManager.d(var1)).run();
   }

   public void loadImage(ImageView var1, int var2) {
      this.a((a)(new a.b(var1, var2)));
   }

   public void loadImage(ImageView var1, Uri var2) {
      this.a((a)(new a.b(var1, var2)));
   }

   public void loadImage(ImageView var1, Uri var2, int var3) {
      a.b var4 = new a.b(var1, var2);
      var4.az(var3);
      this.a((a)var4);
   }

   public void loadImage(ImageManager.OnImageLoadedListener var1, Uri var2) {
      this.a((a)(new a.c(var1, var2)));
   }

   public void loadImage(ImageManager.OnImageLoadedListener var1, Uri var2, int var3) {
      a.c var4 = new a.c(var1, var2);
      var4.az(var3);
      this.a((a)var4);
   }

   private final class ImageReceiver extends ResultReceiver {
      private final ArrayList LE;
      private final Uri mUri;

      ImageReceiver(Uri var2) {
         super(new Handler(Looper.getMainLooper()));
         this.mUri = var2;
         this.LE = new ArrayList();
      }

      public void b(a var1) {
         je.aU("ImageReceiver.addImageRequest() must be called in the main thread");
         this.LE.add(var1);
      }

      public void c(a var1) {
         je.aU("ImageReceiver.removeImageRequest() must be called in the main thread");
         this.LE.remove(var1);
      }

      public void hg() {
         Intent var1 = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
         var1.putExtra("com.google.android.gms.extras.uri", this.mUri);
         var1.putExtra("com.google.android.gms.extras.resultReceiver", this);
         var1.putExtra("com.google.android.gms.extras.priority", 3);
         ImageManager.this.mContext.sendBroadcast(var1);
      }

      public void onReceiveResult(int var1, Bundle var2) {
         ParcelFileDescriptor var3 = (ParcelFileDescriptor)var2.getParcelable("com.google.android.gms.extra.fileDescriptor");
         ImageManager.this.Ly.execute(ImageManager.this.new c(this.mUri, var3));
      }
   }

   public interface OnImageLoadedListener {
      void onImageLoaded(Uri var1, Drawable var2, boolean var3);
   }

   private static final class a {
      static int a(ActivityManager var0) {
         return var0.getLargeMemoryClass();
      }
   }

   private static final class b extends kj {
      public b(Context var1) {
         super(I(var1));
      }

      private static int I(Context var0) {
         ActivityManager var2 = (ActivityManager)var0.getSystemService("activity");
         boolean var1;
         if((var0.getApplicationInfo().flags & 1048576) != 0) {
            var1 = true;
         } else {
            var1 = false;
         }

         int var3;
         if(var1 && ll.ig()) {
            var3 = var2.getLargeMemoryClass();
         } else {
            var3 = var2.getMemoryClass();
         }

         return (int)((float)(var3 * 1048576) * 0.33F);
      }

      protected int a(a.a var1, Bitmap var2) {
         return var2.getHeight() * var2.getRowBytes();
      }

      protected void a(boolean var1, a.a var2, Bitmap var3, Bitmap var4) {
         super.entryRemoved(var1, var2, var3, var4);
      }

      // $FF: synthetic method
      protected void entryRemoved(boolean var1, Object var2, Object var3, Object var4) {
         this.a(var1, (a.a)var2, (Bitmap)var3, (Bitmap)var4);
      }

      // $FF: synthetic method
      protected int sizeOf(Object var1, Object var2) {
         return this.a((a.a)var1, (Bitmap)var2);
      }
   }

   private final class c implements Runnable {
      private final ParcelFileDescriptor LG;
      private final Uri mUri;

      public c(Uri var2, ParcelFileDescriptor var3) {
         this.mUri = var2;
         this.LG = var3;
      }

      public void run() {
         je.aV("LoadBitmapFromDiskRunnable can\'t be executed in the main thread");
         boolean var1 = false;
         boolean var2 = false;
         Bitmap var3 = null;
         CountDownLatch var4 = null;
         if(this.LG != null) {
            label23: {
               try {
                  var3 = BitmapFactory.decodeFileDescriptor(this.LG.getFileDescriptor());
               } catch (OutOfMemoryError var7) {
                  Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, var7);
                  var1 = true;
                  var3 = var4;
                  break label23;
               }

               var1 = var2;
            }

            try {
               this.LG.close();
            } catch (IOException var6) {
               Log.e("ImageManager", "closed failed", var6);
            }
         }

         var4 = new CountDownLatch(1);
         ImageManager.this.mHandler.post(ImageManager.this.new f(this.mUri, var3, var1, var4));

         try {
            var4.await();
         } catch (InterruptedException var5) {
            Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
         }
      }
   }

   private final class d implements Runnable {
      private final a LH;

      public d(a var2) {
         this.LH = var2;
      }

      public void run() {
         // $FF: Couldn't be decompiled
      }
   }

   private static final class e implements ComponentCallbacks2 {
      private final ImageManager.b Lz;

      public e(ImageManager.b var1) {
         this.Lz = var1;
      }

      public void onConfigurationChanged(Configuration var1) {
      }

      public void onLowMemory() {
         this.Lz.evictAll();
      }

      public void onTrimMemory(int var1) {
         if(var1 >= 60) {
            this.Lz.evictAll();
         } else if(var1 >= 20) {
            this.Lz.trimToSize(this.Lz.size() / 2);
            return;
         }

      }
   }

   private final class f implements Runnable {
      private boolean LI;
      private final Bitmap mBitmap;
      private final Uri mUri;
      private final CountDownLatch mr;

      public f(Uri var2, Bitmap var3, boolean var4, CountDownLatch var5) {
         this.mUri = var2;
         this.mBitmap = var3;
         this.LI = var4;
         this.mr = var5;
      }

      private void a(ImageManager.ImageReceiver var1, boolean var2) {
         ArrayList var6 = var1.LE;
         int var4 = var6.size();

         for(int var3 = 0; var3 < var4; ++var3) {
            a var5 = (a)var6.get(var3);
            if(var2) {
               var5.a(ImageManager.this.mContext, this.mBitmap, false);
            } else {
               ImageManager.this.LD.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
               var5.a(ImageManager.this.mContext, ImageManager.this.LA, false);
            }

            if(!(var5 instanceof a.c)) {
               ImageManager.this.LB.remove(var5);
            }
         }

      }

      public void run() {
         // $FF: Couldn't be decompiled
      }
   }
}
