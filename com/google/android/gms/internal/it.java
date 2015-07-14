package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.internal.il;
import com.google.android.gms.internal.in;
import com.google.android.gms.internal.iv;
import com.google.android.gms.internal.iw;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class it extends il {
   private static final long HR;
   private static final long HS;
   private static final long HT;
   private static final long HU;
   private static final String NAMESPACE = in.aG("com.google.cast.media");
   private long HV;
   private MediaStatus HW;
   private final iw HX;
   private final iw HY;
   private final iw HZ;
   private final iw Ia;
   private final iw Ib;
   private final iw Ic;
   private final iw Id;
   private final iw Ie;
   private final iw If;
   private final iw Ig;
   private final List Ih;
   private final Runnable Ii;
   private boolean Ij;
   private final Handler mHandler;

   static {
      HR = TimeUnit.HOURS.toMillis(24L);
      HS = TimeUnit.HOURS.toMillis(24L);
      HT = TimeUnit.HOURS.toMillis(24L);
      HU = TimeUnit.SECONDS.toMillis(1L);
   }

   public it() {
      this((String)null);
   }

   public it(String var1) {
      super(NAMESPACE, "MediaControlChannel", var1);
      this.mHandler = new Handler(Looper.getMainLooper());
      this.Ii = new it.a(null);
      this.Ih = new ArrayList();
      this.HX = new iw(HS);
      this.Ih.add(this.HX);
      this.HY = new iw(HR);
      this.Ih.add(this.HY);
      this.HZ = new iw(HR);
      this.Ih.add(this.HZ);
      this.Ia = new iw(HR);
      this.Ih.add(this.Ia);
      this.Ib = new iw(HT);
      this.Ih.add(this.Ib);
      this.Ic = new iw(HR);
      this.Ih.add(this.Ic);
      this.Id = new iw(HR);
      this.Ih.add(this.Id);
      this.Ie = new iw(HR);
      this.Ih.add(this.Ie);
      this.If = new iw(HR);
      this.Ih.add(this.If);
      this.Ig = new iw(HR);
      this.Ih.add(this.Ig);
      this.gp();
   }

   private void J(boolean var1) {
      if(this.Ij != var1) {
         this.Ij = var1;
         if(!var1) {
            this.mHandler.removeCallbacks(this.Ii);
            return;
         }

         this.mHandler.postDelayed(this.Ii, HU);
      }

   }

   // $FF: synthetic method
   static List a(it var0) {
      return var0.Ih;
   }

   private void a(long var1, JSONObject var3) throws JSONException {
      boolean var6 = true;
      boolean var7 = this.HX.p(var1);
      boolean var4;
      if(this.Ib.gr() && !this.Ib.p(var1)) {
         var4 = true;
      } else {
         var4 = false;
      }

      boolean var5;
      label69: {
         if(this.Ic.gr()) {
            var5 = var6;
            if(!this.Ic.p(var1)) {
               break label69;
            }
         }

         if(this.Id.gr() && !this.Id.p(var1)) {
            var5 = var6;
         } else {
            var5 = false;
         }
      }

      byte var9;
      if(var4) {
         var9 = 2;
      } else {
         var9 = 0;
      }

      int var11 = var9;
      if(var5) {
         var11 = var9 | 1;
      }

      int var10;
      if(!var7 && this.HW != null) {
         var10 = this.HW.a(var3, var11);
      } else {
         this.HW = new MediaStatus(var3);
         this.HV = SystemClock.elapsedRealtime();
         var10 = 7;
      }

      if((var10 & 1) != 0) {
         this.HV = SystemClock.elapsedRealtime();
         this.onStatusUpdated();
      }

      if((var10 & 2) != 0) {
         this.HV = SystemClock.elapsedRealtime();
         this.onStatusUpdated();
      }

      if((var10 & 4) != 0) {
         this.onMetadataUpdated();
      }

      Iterator var8 = this.Ih.iterator();

      while(var8.hasNext()) {
         ((iw)var8.next()).d(var1, 0);
      }

   }

   // $FF: synthetic method
   static boolean a(it var0, boolean var1) {
      var0.Ij = var1;
      return var1;
   }

   // $FF: synthetic method
   static void b(it var0, boolean var1) {
      var0.J(var1);
   }

   private void gp() {
      this.J(false);
      this.HV = 0L;
      this.HW = null;
      this.HX.clear();
      this.Ib.clear();
      this.Ic.clear();
   }

   public long a(iv var1) throws IOException {
      JSONObject var4 = new JSONObject();
      long var2 = this.fU();
      this.Ie.a(var2, var1);
      this.J(true);

      try {
         var4.put("requestId", var2);
         var4.put("type", "GET_STATUS");
         if(this.HW != null) {
            var4.put("mediaSessionId", this.HW.fR());
         }
      } catch (JSONException var5) {
         ;
      }

      this.a(var4.toString(), var2, (String)null);
      return var2;
   }

   public long a(iv param1, double param2, JSONObject param4) throws IOException, IllegalStateException, IllegalArgumentException {
      // $FF: Couldn't be decompiled
   }

   public long a(iv param1, long param2, int param4, JSONObject param5) throws IOException, IllegalStateException {
      // $FF: Couldn't be decompiled
   }

   public long a(iv param1, MediaInfo param2, boolean param3, long param4, long[] param6, JSONObject param7) throws IOException {
      // $FF: Couldn't be decompiled
   }

   public long a(iv param1, TextTrackStyle param2) throws IOException {
      // $FF: Couldn't be decompiled
   }

   public long a(iv param1, JSONObject param2) throws IOException {
      // $FF: Couldn't be decompiled
   }

   public long a(iv param1, boolean param2, JSONObject param3) throws IOException, IllegalStateException {
      // $FF: Couldn't be decompiled
   }

   public long a(iv param1, long[] param2) throws IOException {
      // $FF: Couldn't be decompiled
   }

   public final void aD(String param1) {
      // $FF: Couldn't be decompiled
   }

   public long b(iv param1, JSONObject param2) throws IOException {
      // $FF: Couldn't be decompiled
   }

   public void b(long var1, int var3) {
      Iterator var4 = this.Ih.iterator();

      while(var4.hasNext()) {
         ((iw)var4.next()).d(var1, var3);
      }

   }

   public long c(iv param1, JSONObject param2) throws IOException, IllegalStateException {
      // $FF: Couldn't be decompiled
   }

   public long fR() throws IllegalStateException {
      if(this.HW == null) {
         throw new IllegalStateException("No current media session");
      } else {
         return this.HW.fR();
      }
   }

   public void fV() {
      this.gp();
   }

   public long getApproximateStreamPosition() {
      MediaInfo var10 = this.getMediaInfo();
      if(var10 != null && this.HV != 0L) {
         double var1 = this.HW.getPlaybackRate();
         long var8 = this.HW.getStreamPosition();
         int var3 = this.HW.getPlayerState();
         if(var1 != 0.0D && var3 == 2) {
            long var4 = SystemClock.elapsedRealtime() - this.HV;
            if(var4 < 0L) {
               var4 = 0L;
            }

            if(var4 == 0L) {
               return var8;
            } else {
               long var6 = var10.getStreamDuration();
               var4 = var8 + (long)((double)var4 * var1);
               if(var6 > 0L && var4 > var6) {
                  var4 = var6;
               } else if(var4 < 0L) {
                  var4 = 0L;
               }

               return var4;
            }
         } else {
            return var8;
         }
      } else {
         return 0L;
      }
   }

   public MediaInfo getMediaInfo() {
      return this.HW == null?null:this.HW.getMediaInfo();
   }

   public MediaStatus getMediaStatus() {
      return this.HW;
   }

   public long getStreamDuration() {
      MediaInfo var1 = this.getMediaInfo();
      return var1 != null?var1.getStreamDuration():0L;
   }

   protected void onMetadataUpdated() {
   }

   protected void onStatusUpdated() {
   }

   private class a implements Runnable {
      private a() {
      }

      // $FF: synthetic method
      a(Object var2) {
         this();
      }

      public void run() {
         // $FF: Couldn't be decompiled
      }
   }
}
