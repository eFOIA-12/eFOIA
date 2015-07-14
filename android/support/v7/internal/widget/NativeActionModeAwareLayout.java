package android.support.v7.internal.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v7.internal.widget.ContentFrameLayout;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.ActionMode.Callback;

@TargetApi(11)
public class NativeActionModeAwareLayout extends ContentFrameLayout {
   private NativeActionModeAwareLayout.OnActionModeForChildListener mActionModeForChildListener;

   public NativeActionModeAwareLayout(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public void setActionModeForChildListener(NativeActionModeAwareLayout.OnActionModeForChildListener var1) {
      this.mActionModeForChildListener = var1;
   }

   public ActionMode startActionModeForChild(View var1, Callback var2) {
      return this.mActionModeForChildListener != null?this.mActionModeForChildListener.startActionModeForChild(var1, var2):super.startActionModeForChild(var1, var2);
   }

   public interface OnActionModeForChildListener {
      ActionMode startActionModeForChild(View var1, Callback var2);
   }
}
