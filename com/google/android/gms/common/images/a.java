package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.internal.iz;
import com.google.android.gms.internal.ja;
import com.google.android.gms.internal.jb;
import com.google.android.gms.internal.jc;
import com.google.android.gms.internal.je;
import com.google.android.gms.internal.jv;
import java.lang.ref.WeakReference;

public abstract class a {
   final a.a LJ;
   protected int LK = 0;
   protected int LL = 0;
   protected boolean LM = false;
   protected ImageManager.OnImageLoadedListener LN;
   private boolean LO = true;
   private boolean LP = false;
   private boolean LQ = true;
   protected int LR;

   public a(Uri var1, int var2) {
      this.LJ = new a.a(var1);
      this.LL = var2;
   }

   private Drawable a(Context var1, jc var2, int var3) {
      Resources var6 = var1.getResources();
      if(this.LR > 0) {
         jc.a var5 = new jc.a(var3, this.LR);
         Drawable var4 = (Drawable)var2.get(var5);
         Drawable var7 = var4;
         if(var4 == null) {
            var4 = var6.getDrawable(var3);
            var7 = var4;
            if((this.LR & 1) != 0) {
               var7 = this.a(var6, var4);
            }

            var2.put(var5, var7);
         }

         return var7;
      } else {
         return var6.getDrawable(var3);
      }
   }

   protected Drawable a(Resources var1, Drawable var2) {
      return ja.a(var1, var2);
   }

   protected iz a(Drawable var1, Drawable var2) {
      Drawable var3;
      if(var1 != null) {
         var3 = var1;
         if(var1 instanceof iz) {
            var3 = ((iz)var1).hh();
         }
      } else {
         var3 = null;
      }

      return new iz(var3, var2);
   }

   void a(Context var1, Bitmap var2, boolean var3) {
      je.f(var2);
      Bitmap var4 = var2;
      if((this.LR & 1) != 0) {
         var4 = ja.a(var2);
      }

      BitmapDrawable var5 = new BitmapDrawable(var1.getResources(), var4);
      if(this.LN != null) {
         this.LN.onImageLoaded(this.LJ.uri, var5, true);
      }

      this.a(var5, var3, false, true);
   }

   void a(Context var1, jc var2) {
      if(this.LQ) {
         Drawable var3 = null;
         if(this.LK != 0) {
            var3 = this.a(var1, var2, this.LK);
         }

         this.a(var3, false, true, false);
      }

   }

   void a(Context var1, jc var2, boolean var3) {
      Drawable var4 = null;
      if(this.LL != 0) {
         var4 = this.a(var1, var2, this.LL);
      }

      if(this.LN != null) {
         this.LN.onImageLoaded(this.LJ.uri, var4, false);
      }

      this.a(var4, var3, false, false);
   }

   protected abstract void a(Drawable var1, boolean var2, boolean var3, boolean var4);

   public void az(int var1) {
      this.LL = var1;
   }

   protected boolean b(boolean var1, boolean var2) {
      return this.LO && !var2 && (!var1 || this.LP);
   }

   static final class a {
      public final Uri uri;

      public a(Uri var1) {
         this.uri = var1;
      }

      public boolean equals(Object var1) {
         return !(var1 instanceof a.a)?false:(this == var1?true:jv.equal(((a.a)var1).uri, this.uri));
      }

      public int hashCode() {
         return jv.hashCode(new Object[]{this.uri});
      }
   }

   public static final class b extends a {
      private WeakReference LS;

      public b(ImageView var1, int var2) {
         super((Uri)null, var2);
         je.f(var1);
         this.LS = new WeakReference(var1);
      }

      public b(ImageView var1, Uri var2) {
         super(var2, 0);
         je.f(var1);
         this.LS = new WeakReference(var1);
      }

      private void a(ImageView var1, Drawable var2, boolean var3, boolean var4, boolean var5) {
         boolean var6;
         if(!var4 && !var5) {
            var6 = true;
         } else {
            var6 = false;
         }

         if(var6 && var1 instanceof jb) {
            int var7 = ((jb)var1).hj();
            if(this.LL != 0 && var7 == this.LL) {
               return;
            }
         }

         var3 = this.b(var3, var4);
         if(this.LM && var2 != null) {
            var2 = var2.getConstantState().newDrawable();
         }

         Object var8 = var2;
         if(var3) {
            var8 = this.a(var1.getDrawable(), var2);
         }

         var1.setImageDrawable((Drawable)var8);
         if(var1 instanceof jb) {
            jb var10 = (jb)var1;
            Uri var9;
            if(var5) {
               var9 = this.LJ.uri;
            } else {
               var9 = null;
            }

            var10.g(var9);
            int var11;
            if(var6) {
               var11 = this.LL;
            } else {
               var11 = 0;
            }

            var10.aB(var11);
         }

         if(var3) {
            ((iz)var8).startTransition(250);
         }
      }

      protected void a(Drawable var1, boolean var2, boolean var3, boolean var4) {
         ImageView var5 = (ImageView)this.LS.get();
         if(var5 != null) {
            this.a(var5, var1, var2, var3, var4);
         }

      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof a.b)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            a.b var3 = (a.b)var1;
            ImageView var4 = (ImageView)this.LS.get();
            ImageView var5 = (ImageView)var3.LS.get();
            boolean var2;
            if(var5 != null && var4 != null && jv.equal(var5, var4)) {
               var2 = true;
            } else {
               var2 = false;
            }

            return var2;
         }
      }

      public int hashCode() {
         return 0;
      }
   }

   public static final class c extends a {
      private WeakReference LT;

      public c(ImageManager.OnImageLoadedListener var1, Uri var2) {
         super(var2, 0);
         je.f(var1);
         this.LT = new WeakReference(var1);
      }

      protected void a(Drawable var1, boolean var2, boolean var3, boolean var4) {
         if(!var3) {
            ImageManager.OnImageLoadedListener var5 = (ImageManager.OnImageLoadedListener)this.LT.get();
            if(var5 != null) {
               var5.onImageLoaded(this.LJ.uri, var1, var4);
            }
         }

      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof a.c)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            a.c var5 = (a.c)var1;
            ImageManager.OnImageLoadedListener var3 = (ImageManager.OnImageLoadedListener)this.LT.get();
            ImageManager.OnImageLoadedListener var4 = (ImageManager.OnImageLoadedListener)var5.LT.get();
            boolean var2;
            if(var4 != null && var3 != null && jv.equal(var4, var3) && jv.equal(var5.LJ, this.LJ)) {
               var2 = true;
            } else {
               var2 = false;
            }

            return var2;
         }
      }

      public int hashCode() {
         return jv.hashCode(new Object[]{this.LJ});
      }
   }
}
