package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.internal.ey;
import java.util.Date;
import java.util.Set;

@ey
public final class db implements MediationAdRequest {
   private final Date d;
   private final Set f;
   private final boolean g;
   private final Location h;
   private final int ow;
   private final int qU;

   public db(Date var1, int var2, Set var3, Location var4, boolean var5, int var6) {
      this.d = var1;
      this.ow = var2;
      this.f = var3;
      this.h = var4;
      this.g = var5;
      this.qU = var6;
   }

   public Date getBirthday() {
      return this.d;
   }

   public int getGender() {
      return this.ow;
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

   public int taggedForChildDirectedTreatment() {
      return this.qU;
   }
}
