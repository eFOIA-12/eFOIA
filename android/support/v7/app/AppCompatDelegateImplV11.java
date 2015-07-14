package android.support.v7.app;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegateImplV7;
import android.support.v7.internal.view.SupportActionModeWrapper;
import android.support.v7.internal.widget.NativeActionModeAwareLayout;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.ActionMode.Callback;
import android.view.LayoutInflater.Factory2;

@TargetApi(11)
class AppCompatDelegateImplV11 extends AppCompatDelegateImplV7 implements NativeActionModeAwareLayout.OnActionModeForChildListener {
   private NativeActionModeAwareLayout mNativeActionModeAwareLayout;

   AppCompatDelegateImplV11(Context var1, Window var2, AppCompatCallback var3) {
      super(var1, var2, var3);
   }

   View callActivityOnCreateView(View var1, String var2, Context var3, AttributeSet var4) {
      View var5 = super.callActivityOnCreateView(var1, var2, var3, var4);
      return var5 != null?var5:(this.mOriginalWindowCallback instanceof Factory2?((Factory2)this.mOriginalWindowCallback).onCreateView(var1, var2, var3, var4):null);
   }

   void onSubDecorInstalled(ViewGroup var1) {
      this.mNativeActionModeAwareLayout = (NativeActionModeAwareLayout)var1.findViewById(16908290);
      if(this.mNativeActionModeAwareLayout != null) {
         this.mNativeActionModeAwareLayout.setActionModeForChildListener(this);
      }

   }

   public ActionMode startActionModeForChild(View var1, Callback var2) {
      android.support.v7.view.ActionMode var3 = this.startSupportActionMode(new SupportActionModeWrapper.CallbackWrapper(var1.getContext(), var2));
      return var3 != null?new SupportActionModeWrapper(this.mContext, var3):null;
   }
}
