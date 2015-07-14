package com.google.android.gms.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.VideoView;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gq;
import com.google.android.gms.internal.gu;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

@ey
public final class dt extends FrameLayout implements OnCompletionListener, OnErrorListener, OnPreparedListener {
   private final gu mo;
   private final MediaController so;
   private final dt.a sp;
   private final VideoView sq;
   private long sr;
   private String ss;

   public dt(Context var1, gu var2) {
      super(var1);
      this.mo = var2;
      this.sq = new VideoView(var1);
      LayoutParams var3 = new LayoutParams(-1, -1, 17);
      this.addView(this.sq, var3);
      this.so = new MediaController(var1);
      this.sp = new dt.a(this);
      this.sp.cs();
      this.sq.setOnCompletionListener(this);
      this.sq.setOnPreparedListener(this);
      this.sq.setOnErrorListener(this);
   }

   private static void a(gu var0, String var1) {
      a(var0, var1, (Map)(new HashMap(1)));
   }

   public static void a(gu var0, String var1, String var2) {
      boolean var3;
      if(var2 == null) {
         var3 = true;
      } else {
         var3 = false;
      }

      byte var4;
      if(var3) {
         var4 = 2;
      } else {
         var4 = 3;
      }

      HashMap var5 = new HashMap(var4);
      var5.put("what", var1);
      if(!var3) {
         var5.put("extra", var2);
      }

      a(var0, "error", (Map)var5);
   }

   private static void a(gu var0, String var1, String var2, String var3) {
      HashMap var4 = new HashMap(2);
      var4.put(var2, var3);
      a(var0, var1, (Map)var4);
   }

   private static void a(gu var0, String var1, Map var2) {
      var2.put("event", var1);
      var0.a("onVideoEvent", var2);
   }

   public void C(String var1) {
      this.ss = var1;
   }

   public void b(MotionEvent var1) {
      this.sq.dispatchTouchEvent(var1);
   }

   public void cq() {
      if(!TextUtils.isEmpty(this.ss)) {
         this.sq.setVideoPath(this.ss);
      } else {
         a(this.mo, "no_src", (String)null);
      }
   }

   public void cr() {
      long var2 = (long)this.sq.getCurrentPosition();
      if(this.sr != var2) {
         float var1 = (float)var2 / 1000.0F;
         a(this.mo, "timeupdate", "time", String.valueOf(var1));
         this.sr = var2;
      }

   }

   public void destroy() {
      this.sp.cancel();
      this.sq.stopPlayback();
   }

   public void onCompletion(MediaPlayer var1) {
      a(this.mo, "ended");
   }

   public boolean onError(MediaPlayer var1, int var2, int var3) {
      a(this.mo, String.valueOf(var2), String.valueOf(var3));
      return true;
   }

   public void onPrepared(MediaPlayer var1) {
      float var2 = (float)this.sq.getDuration() / 1000.0F;
      a(this.mo, "canplaythrough", "duration", String.valueOf(var2));
   }

   public void pause() {
      this.sq.pause();
   }

   public void play() {
      this.sq.start();
   }

   public void s(boolean var1) {
      if(var1) {
         this.sq.setMediaController(this.so);
      } else {
         this.so.hide();
         this.sq.setMediaController((MediaController)null);
      }
   }

   public void seekTo(int var1) {
      this.sq.seekTo(var1);
   }

   private static final class a {
      private final Runnable mv;
      private volatile boolean st = false;

      public a(final dt var1) {
         this.mv = new Runnable() {
            private final WeakReference su = new WeakReference(var1);

            public void run() {
               dt var1x = (dt)this.su.get();
               if(!a.this.st && var1x != null) {
                  var1x.cr();
                  a.this.cs();
               }

            }
         };
      }

      public void cancel() {
         this.st = true;
         gq.wR.removeCallbacks(this.mv);
      }

      public void cs() {
         gq.wR.postDelayed(this.mv, 250L);
      }
   }
}
