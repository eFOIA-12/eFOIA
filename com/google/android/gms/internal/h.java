package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.internal.f;
import com.google.android.gms.internal.g;
import com.google.android.gms.internal.m;
import com.google.android.gms.internal.n;
import com.google.android.gms.internal.qn;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public abstract class h implements g {
   protected MotionEvent kw;
   protected DisplayMetrics kx;
   protected m ky;
   private n kz;

   protected h(Context var1, m var2, n var3) {
      this.ky = var2;
      this.kz = var3;

      try {
         this.kx = var1.getResources().getDisplayMetrics();
      } catch (UnsupportedOperationException var4) {
         this.kx = new DisplayMetrics();
         this.kx.density = 1.0F;
      }
   }

   private String a(Context param1, String param2, boolean param3) {
      // $FF: Couldn't be decompiled
   }

   private void t() {
      this.kz.reset();
   }

   private byte[] u() throws IOException {
      return this.kz.D();
   }

   public String a(Context var1) {
      return this.a(var1, (String)null, false);
   }

   public String a(Context var1, String var2) {
      return this.a(var1, var2, true);
   }

   String a(byte[] var1, String var2) throws NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
      byte[] var3 = var1;
      if(var1.length > 239) {
         this.t();
         this.a(20, 1L);
         var3 = this.u();
      }

      if(var3.length < 239) {
         var1 = new byte[239 - var3.length];
         (new SecureRandom()).nextBytes(var1);
         var1 = ByteBuffer.allocate(240).put((byte)var3.length).put(var3).put(var1).array();
      } else {
         var1 = ByteBuffer.allocate(240).put((byte)var3.length).put(var3).array();
      }

      MessageDigest var4 = MessageDigest.getInstance("MD5");
      var4.update(var1);
      var3 = var4.digest();
      var1 = ByteBuffer.allocate(256).put(var3).put(var1).array();
      var3 = new byte[256];
      (new f()).a(var1, var3);
      if(var2 != null && var2.length() > 0) {
         this.a(var2, var3);
      }

      return this.ky.a(var3, true);
   }

   public void a(int var1, int var2, int var3) {
      if(this.kw != null) {
         this.kw.recycle();
      }

      this.kw = MotionEvent.obtain(0L, (long)var3, 1, (float)var1 * this.kx.density, (float)var2 * this.kx.density, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
   }

   protected void a(int var1, long var2) throws IOException {
      this.kz.b(var1, var2);
   }

   protected void a(int var1, String var2) throws IOException {
      this.kz.b(var1, var2);
   }

   public void a(MotionEvent var1) {
      if(var1.getAction() == 1) {
         if(this.kw != null) {
            this.kw.recycle();
         }

         this.kw = MotionEvent.obtain(var1);
      }

   }

   void a(String var1, byte[] var2) throws UnsupportedEncodingException {
      String var3 = var1;
      if(var1.length() > 32) {
         var3 = var1.substring(0, 32);
      }

      (new qn(var3.getBytes("UTF-8"))).o(var2);
   }

   protected abstract void b(Context var1);

   protected abstract void c(Context var1);
}
