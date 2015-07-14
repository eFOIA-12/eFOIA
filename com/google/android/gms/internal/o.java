package com.google.android.gms.internal;

import com.google.android.gms.internal.m;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class o {
   private final SecureRandom kZ;
   private final m ky;

   public o(m var1, SecureRandom var2) {
      this.ky = var1;
      this.kZ = var2;
   }

   static void c(byte[] var0) {
      for(int var1 = 0; var1 < var0.length; ++var1) {
         var0[var1] = (byte)(var0[var1] ^ 68);
      }

   }

   public byte[] b(String var1) throws o.a {
      try {
         byte[] var4 = this.ky.a(var1, false);
         if(var4.length != 32) {
            throw new o.a();
         } else {
            ByteBuffer var5 = ByteBuffer.wrap(var4, 4, 16);
            byte[] var2 = new byte[16];
            var5.get(var2);
            c(var2);
            return var2;
         }
      } catch (IllegalArgumentException var3) {
         throw new o.a(var3);
      }
   }

   public byte[] c(byte[] var1, String var2) throws o.a {
      if(var1.length != 16) {
         throw new o.a();
      } else {
         try {
            byte[] var3 = this.ky.a(var2, false);
            if(var3.length <= 16) {
               throw new o.a();
            } else {
               ByteBuffer var4 = ByteBuffer.allocate(var3.length);
               var4.put(var3);
               var4.flip();
               byte[] var13 = new byte[16];
               var3 = new byte[var3.length - 16];
               var4.get(var13);
               var4.get(var3);
               SecretKeySpec var12 = new SecretKeySpec(var1, "AES");
               Cipher var14 = Cipher.getInstance("AES/CBC/PKCS5Padding");
               var14.init(2, var12, new IvParameterSpec(var13));
               var1 = var14.doFinal(var3);
               return var1;
            }
         } catch (NoSuchAlgorithmException var5) {
            throw new o.a(var5);
         } catch (InvalidKeyException var6) {
            throw new o.a(var6);
         } catch (IllegalBlockSizeException var7) {
            throw new o.a(var7);
         } catch (NoSuchPaddingException var8) {
            throw new o.a(var8);
         } catch (BadPaddingException var9) {
            throw new o.a(var9);
         } catch (InvalidAlgorithmParameterException var10) {
            throw new o.a(var10);
         } catch (IllegalArgumentException var11) {
            throw new o.a(var11);
         }
      }
   }

   public class a extends Exception {
      public a() {
      }

      public a(Throwable var2) {
         super(var2);
      }
   }
}
