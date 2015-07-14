package com.google.android.gms.internal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.internal.hd;
import com.google.android.gms.internal.hh;
import com.google.android.gms.internal.hp;
import com.google.android.gms.internal.hr;
import com.google.android.gms.internal.hz;
import com.google.android.gms.internal.mv;
import com.google.android.gms.internal.qw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class hy {
   private static hh a(String var0, mv.c var1) {
      hp var2 = (new hp.a(var0)).G(true).au(var0).at("blob").fG();
      return new hh(qw.f(var1), var2);
   }

   public static hr a(Action var0, String var1, long var2, String var4, int var5) {
      Bundle var6 = new Bundle();
      var6.putAll(var0.fI());
      Bundle var7 = var6.getBundle("object");
      Uri var10;
      if(var7.containsKey("id")) {
         var10 = Uri.parse(var7.getString("id"));
      } else {
         var10 = null;
      }

      String var8 = var7.getString("name");
      String var9 = var7.getString("type");
      Intent var11 = hz.a(var4, Uri.parse(var7.getString("url")));
      hd.a var12 = hr.a(var11, var8, var10, var9, (List)null);
      var12.a(a(".private:action", d(var0.fI())));
      var12.a(aw(var1));
      return new hr(hr.a(var4, var11), var2, var5, (String)null, var12.fD());
   }

   private static hh aw(String var0) {
      return new hh(var0, (new hp.a(".private:actionId")).G(true).au(".private:actionId").at("blob").fG());
   }

   static mv.c d(Bundle var0) {
      mv.c var1 = new mv.c();
      ArrayList var2 = new ArrayList();

      mv.b var6;
      for(Iterator var3 = var0.keySet().iterator(); var3.hasNext(); var2.add(var6)) {
         String var4 = (String)var3.next();
         Object var5 = var0.get(var4);
         var6 = new mv.b();
         var6.name = var4;
         var6.afz = new mv.d();
         if(var5 instanceof String) {
            var6.afz.NJ = (String)var5;
         } else if(var5 instanceof Bundle) {
            var6.afz.afE = d((Bundle)var5);
         } else {
            Log.e("AppDataSearchClient", "Unsupported value: " + var5);
         }
      }

      if(var0.containsKey("type")) {
         var1.type = var0.getString("type");
      }

      var1.afA = (mv.b[])var2.toArray(new mv.b[var2.size()]);
      return var1;
   }
}
