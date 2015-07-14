package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.bg;
import com.google.android.gms.internal.bj;
import com.google.android.gms.internal.ey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

@ey
public class ax {
   public static final ax oo = new ax();

   public static ax bg() {
      return oo;
   }

   public av a(Context var1, bg var2) {
      Date var9 = var2.getBirthday();
      long var5;
      if(var9 != null) {
         var5 = var9.getTime();
      } else {
         var5 = -1L;
      }

      String var10 = var2.getContentUrl();
      int var3 = var2.getGender();
      Set var16 = var2.getKeywords();
      List var17;
      if(!var16.isEmpty()) {
         var17 = Collections.unmodifiableList(new ArrayList(var16));
      } else {
         var17 = null;
      }

      boolean var7 = var2.isTestDevice(var1);
      int var4 = var2.bl();
      Location var11 = var2.getLocation();
      Bundle var12 = var2.getNetworkExtrasBundle(AdMobAdapter.class);
      boolean var8 = var2.getManualImpressionsEnabled();
      String var13 = var2.getPublisherProvidedId();
      SearchAdRequest var14 = var2.bi();
      bj var15;
      if(var14 != null) {
         var15 = new bj(var14);
      } else {
         var15 = null;
      }

      return new av(4, var5, var12, var3, var17, var7, var4, var8, var13, var15, var11, var10, var2.bk());
   }
}
