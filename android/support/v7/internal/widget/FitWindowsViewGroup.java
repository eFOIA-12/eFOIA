package android.support.v7.internal.widget;

import android.graphics.Rect;

public interface FitWindowsViewGroup {
   void setOnFitSystemWindowsListener(FitWindowsViewGroup.OnFitSystemWindowsListener var1);

   public interface OnFitSystemWindowsListener {
      void onFitSystemWindows(Rect var1);
   }
}
