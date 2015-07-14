package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Base64;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gr;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

@ey
public class el {
   public static PublicKey F(String var0) {
      try {
         byte[] var3 = Base64.decode(var0, 0);
         PublicKey var4 = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(var3));
         return var4;
      } catch (NoSuchAlgorithmException var1) {
         throw new RuntimeException(var1);
      } catch (InvalidKeySpecException var2) {
         gr.T("Invalid key specification.");
         throw new IllegalArgumentException(var2);
      }
   }

   public static boolean a(PublicKey var0, String var1, String var2) {
      try {
         Signature var3 = Signature.getInstance("SHA1withRSA");
         var3.initVerify(var0);
         var3.update(var1.getBytes());
         if(!var3.verify(Base64.decode(var2, 0))) {
            gr.T("Signature verification failed.");
            return false;
         } else {
            return true;
         }
      } catch (NoSuchAlgorithmException var4) {
         gr.T("NoSuchAlgorithmException.");
         return false;
      } catch (InvalidKeyException var5) {
         gr.T("Invalid key specification.");
         return false;
      } catch (SignatureException var6) {
         gr.T("Signature exception.");
         return false;
      }
   }

   public static boolean b(String var0, String var1, String var2) {
      if(!TextUtils.isEmpty(var1) && !TextUtils.isEmpty(var0) && !TextUtils.isEmpty(var2)) {
         return a(F(var0), var1, var2);
      } else {
         gr.T("Purchase verification failed: missing data.");
         return false;
      }
   }
}
