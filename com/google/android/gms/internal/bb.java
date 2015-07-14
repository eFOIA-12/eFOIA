package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.R;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.ey;

@ey
public final class bb {
   private final AdSize[] ot;
   private final String ou;

   public bb(Context var1, AttributeSet var2) {
      boolean var4 = true;
      super();
      TypedArray var6 = var1.getResources().obtainAttributes(var2, R.styleable.AdsAttrs);
      String var7 = var6.getString(R.styleable.AdsAttrs_adSize);
      String var5 = var6.getString(R.styleable.AdsAttrs_adSizes);
      boolean var3;
      if(!TextUtils.isEmpty(var7)) {
         var3 = true;
      } else {
         var3 = false;
      }

      if(TextUtils.isEmpty(var5)) {
         var4 = false;
      }

      if(var3 && !var4) {
         this.ot = q(var7);
      } else {
         if(var3 || !var4) {
            if(var3 && var4) {
               throw new IllegalArgumentException("Either XML attribute \"adSize\" or XML attribute \"supportedAdSizes\" should be specified, but not both.");
            }

            throw new IllegalArgumentException("Required XML attribute \"adSize\" was missing.");
         }

         this.ot = q(var5);
      }

      this.ou = var6.getString(R.styleable.AdsAttrs_adUnitId);
      if(TextUtils.isEmpty(this.ou)) {
         throw new IllegalArgumentException("Required XML attribute \"adUnitId\" was missing.");
      }
   }

   private static AdSize[] q(String param0) {
      // $FF: Couldn't be decompiled
   }

   public String getAdUnitId() {
      return this.ou;
   }

   public AdSize[] h(boolean var1) {
      if(!var1 && this.ot.length != 1) {
         throw new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
      } else {
         return this.ot;
      }
   }
}
