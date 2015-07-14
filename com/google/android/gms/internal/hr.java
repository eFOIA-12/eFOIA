package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hd;
import com.google.android.gms.internal.hf;
import com.google.android.gms.internal.hh;
import com.google.android.gms.internal.hp;
import com.google.android.gms.internal.hs;
import com.google.android.gms.internal.mv;
import com.google.android.gms.internal.qw;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.zip.CRC32;

public class hr implements SafeParcelable {
   public static final hs CREATOR = new hs();
   final int CK;
   final hf Dw;
   final long Dx;
   final int Dy;
   final hd Dz;
   public final String pc;

   hr(int var1, hf var2, long var3, int var5, String var6, hd var7) {
      this.CK = var1;
      this.Dw = var2;
      this.Dx = var3;
      this.Dy = var5;
      this.pc = var6;
      this.Dz = var7;
   }

   public hr(hf var1, long var2, int var4) {
      this(1, var1, var2, var4, (String)null, (hd)null);
   }

   public hr(hf var1, long var2, int var4, String var5, hd var6) {
      this(1, var1, var2, var4, var5, var6);
   }

   public hr(String var1, Intent var2, String var3, Uri var4, String var5, List var6) {
      this(1, a(var1, var2), System.currentTimeMillis(), 0, (String)null, a(var2, var3, var4, var5, var6).fD());
   }

   public static hd.a a(Intent var0, String var1, Uri var2, String var3, List var4) {
      hd.a var5 = new hd.a();
      var5.a(av(var1));
      if(var2 != null) {
         var5.a(f(var2));
      }

      if(var4 != null) {
         var5.a(b(var4));
      }

      var1 = var0.getAction();
      if(var1 != null) {
         var5.a(i("intent_action", var1));
      }

      var1 = var0.getDataString();
      if(var1 != null) {
         var5.a(i("intent_data", var1));
      }

      ComponentName var8 = var0.getComponent();
      if(var8 != null) {
         var5.a(i("intent_activity", var8.getClassName()));
      }

      Bundle var6 = var0.getExtras();
      if(var6 != null) {
         String var7 = var6.getString("intent_extra_data_key");
         if(var7 != null) {
            var5.a(i("intent_extra_data", var7));
         }
      }

      return var5.ar(var3).F(true);
   }

   public static hf a(String var0, Intent var1) {
      return h(var0, g(var1));
   }

   private static hh av(String var0) {
      return new hh(var0, (new hp.a("title")).Q(1).H(true).au("name").fG(), "text1");
   }

   private static hh b(List var0) {
      mv.a var2 = new mv.a();
      mv.a[] var3 = new mv.a[var0.size()];

      for(int var1 = 0; var1 < var3.length; ++var1) {
         var3[var1] = new mv.a();
         AppIndexApi.AppIndexingLink var4 = (AppIndexApi.AppIndexingLink)var0.get(var1);
         var3[var1].afw = var4.appIndexingUrl.toString();
         var3[var1].viewId = var4.viewId;
         if(var4.webUrl != null) {
            var3[var1].afx = var4.webUrl.toString();
         }
      }

      var2.afu = var3;
      return new hh(qw.f(var2), (new hp.a("outlinks")).G(true).au(".private:outLinks").at("blob").fG());
   }

   private static hh f(Uri var0) {
      return new hh(var0.toString(), (new hp.a("web_url")).Q(4).G(true).au("url").fG());
   }

   private static String g(Intent var0) {
      String var3 = var0.toUri(1);
      CRC32 var1 = new CRC32();

      try {
         var1.update(var3.getBytes("UTF-8"));
      } catch (UnsupportedEncodingException var2) {
         throw new IllegalStateException(var2);
      }

      return Long.toHexString(var1.getValue());
   }

   private static hf h(String var0, String var1) {
      return new hf(var0, "", var1);
   }

   private static hh i(String var0, String var1) {
      return new hh(var1, (new hp.a(var0)).G(true).fG(), var0);
   }

   public int describeContents() {
      hs var1 = CREATOR;
      return 0;
   }

   public String toString() {
      return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d]", new Object[]{this.Dw, Long.valueOf(this.Dx), Integer.valueOf(this.Dy)});
   }

   public void writeToParcel(Parcel var1, int var2) {
      hs var3 = CREATOR;
      hs.a(this, var1, var2);
   }
}
