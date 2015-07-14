package com.google.android.gms.analytics;

import com.google.android.gms.analytics.i;
import com.google.android.gms.analytics.l;
import com.google.android.gms.analytics.o;
import java.util.HashSet;
import java.util.Set;

public class j implements o {
   private final Set yo = new HashSet();

   j() {
      this.yo.add(Integer.valueOf(302));
      this.yo.add(Integer.valueOf(404));
      this.yo.add(Integer.valueOf(502));
   }

   public int eb() {
      return 2036;
   }

   public int ec() {
      return 8192;
   }

   public int ed() {
      return 8192;
   }

   public int ee() {
      return 20;
   }

   public long ef() {
      return 3600L;
   }

   public String eg() {
      return "/collect";
   }

   public String eh() {
      return "/batch";
   }

   public i ei() {
      return i.yx;
   }

   public l ej() {
      return l.yJ;
   }

   public Set ek() {
      return this.yo;
   }
}
