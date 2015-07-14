package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.media.session.PlaybackState.Builder;

class PlaybackStateCompatApi21 {
   public static long getActions(Object var0) {
      return ((PlaybackState)var0).getActions();
   }

   public static long getBufferedPosition(Object var0) {
      return ((PlaybackState)var0).getBufferedPosition();
   }

   public static CharSequence getErrorMessage(Object var0) {
      return ((PlaybackState)var0).getErrorMessage();
   }

   public static long getLastPositionUpdateTime(Object var0) {
      return ((PlaybackState)var0).getLastPositionUpdateTime();
   }

   public static float getPlaybackSpeed(Object var0) {
      return ((PlaybackState)var0).getPlaybackSpeed();
   }

   public static long getPosition(Object var0) {
      return ((PlaybackState)var0).getPosition();
   }

   public static int getState(Object var0) {
      return ((PlaybackState)var0).getState();
   }

   public static Object newInstance(int var0, long var1, long var3, float var5, long var6, CharSequence var8, long var9) {
      Builder var11 = new Builder();
      var11.setState(var0, var1, var5, var9);
      var11.setBufferedPosition(var3);
      var11.setActions(var6);
      var11.setErrorMessage(var8);
      return var11.build();
   }
}
