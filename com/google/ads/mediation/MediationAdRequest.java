package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Deprecated
public final class MediationAdRequest {
   private final Date d;
   private final AdRequest.Gender e;
   private final Set f;
   private final boolean g;
   private final Location h;

   public MediationAdRequest(Date var1, AdRequest.Gender var2, Set var3, boolean var4, Location var5) {
      this.d = var1;
      this.e = var2;
      this.f = var3;
      this.g = var4;
      this.h = var5;
   }

   public Integer getAgeInYears() {
      if(this.d == null) {
         return null;
      } else {
         Calendar var3 = Calendar.getInstance();
         Calendar var4 = Calendar.getInstance();
         var3.setTime(this.d);
         Integer var2 = Integer.valueOf(var4.get(1) - var3.get(1));
         Integer var1;
         if(var4.get(2) >= var3.get(2)) {
            var1 = var2;
            if(var4.get(2) != var3.get(2)) {
               return var1;
            }

            var1 = var2;
            if(var4.get(5) >= var3.get(5)) {
               return var1;
            }
         }

         var1 = Integer.valueOf(var2.intValue() - 1);
         return var1;
      }
   }

   public Date getBirthday() {
      return this.d;
   }

   public AdRequest.Gender getGender() {
      return this.e;
   }

   public Set getKeywords() {
      return this.f;
   }

   public Location getLocation() {
      return this.h;
   }

   public boolean isTesting() {
      return this.g;
   }
}
