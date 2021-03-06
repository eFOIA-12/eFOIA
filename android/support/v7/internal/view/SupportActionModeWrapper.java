package android.support.v7.internal.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.util.SimpleArrayMap;
import android.support.v7.internal.view.menu.MenuWrapperFactory;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ActionMode.Callback;

@TargetApi(11)
public class SupportActionModeWrapper extends ActionMode {
   final Context mContext;
   final android.support.v7.view.ActionMode mWrappedObject;

   public SupportActionModeWrapper(Context var1, android.support.v7.view.ActionMode var2) {
      this.mContext = var1;
      this.mWrappedObject = var2;
   }

   public void finish() {
      this.mWrappedObject.finish();
   }

   public View getCustomView() {
      return this.mWrappedObject.getCustomView();
   }

   public Menu getMenu() {
      return MenuWrapperFactory.wrapSupportMenu(this.mContext, (SupportMenu)this.mWrappedObject.getMenu());
   }

   public MenuInflater getMenuInflater() {
      return this.mWrappedObject.getMenuInflater();
   }

   public CharSequence getSubtitle() {
      return this.mWrappedObject.getSubtitle();
   }

   public Object getTag() {
      return this.mWrappedObject.getTag();
   }

   public CharSequence getTitle() {
      return this.mWrappedObject.getTitle();
   }

   public boolean getTitleOptionalHint() {
      return this.mWrappedObject.getTitleOptionalHint();
   }

   public void invalidate() {
      this.mWrappedObject.invalidate();
   }

   public boolean isTitleOptional() {
      return this.mWrappedObject.isTitleOptional();
   }

   public void setCustomView(View var1) {
      this.mWrappedObject.setCustomView(var1);
   }

   public void setSubtitle(int var1) {
      this.mWrappedObject.setSubtitle(var1);
   }

   public void setSubtitle(CharSequence var1) {
      this.mWrappedObject.setSubtitle(var1);
   }

   public void setTag(Object var1) {
      this.mWrappedObject.setTag(var1);
   }

   public void setTitle(int var1) {
      this.mWrappedObject.setTitle(var1);
   }

   public void setTitle(CharSequence var1) {
      this.mWrappedObject.setTitle(var1);
   }

   public void setTitleOptionalHint(boolean var1) {
      this.mWrappedObject.setTitleOptionalHint(var1);
   }

   public static class CallbackWrapper implements android.support.v7.view.ActionMode {
      final SimpleArrayMap mActionModes;
      final Context mContext;
      final SimpleArrayMap mMenus;
      final Callback mWrappedCallback;

      public CallbackWrapper(Context var1, Callback var2) {
         this.mContext = var1;
         this.mWrappedCallback = var2;
         this.mActionModes = new SimpleArrayMap();
         this.mMenus = new SimpleArrayMap();
      }

      private ActionMode getActionModeWrapper(android.support.v7.view.ActionMode var1) {
         SupportActionModeWrapper var2 = (SupportActionModeWrapper)this.mActionModes.get(var1);
         if(var2 != null) {
            return var2;
         } else {
            var2 = new SupportActionModeWrapper(this.mContext, var1);
            this.mActionModes.put(var1, var2);
            return var2;
         }
      }

      private Menu getMenuWrapper(Menu var1) {
         Menu var3 = (Menu)this.mMenus.get(var1);
         Menu var2 = var3;
         if(var3 == null) {
            var2 = MenuWrapperFactory.wrapSupportMenu(this.mContext, (SupportMenu)var1);
            this.mMenus.put(var1, var2);
         }

         return var2;
      }

      public boolean onActionItemClicked(android.support.v7.view.ActionMode var1, MenuItem var2) {
         return this.mWrappedCallback.onActionItemClicked(this.getActionModeWrapper(var1), MenuWrapperFactory.wrapSupportMenuItem(this.mContext, (SupportMenuItem)var2));
      }

      public boolean onCreateActionMode(android.support.v7.view.ActionMode var1, Menu var2) {
         return this.mWrappedCallback.onCreateActionMode(this.getActionModeWrapper(var1), this.getMenuWrapper(var2));
      }

      public void onDestroyActionMode(android.support.v7.view.ActionMode var1) {
         this.mWrappedCallback.onDestroyActionMode(this.getActionModeWrapper(var1));
      }

      public boolean onPrepareActionMode(android.support.v7.view.ActionMode var1, Menu var2) {
         return this.mWrappedCallback.onPrepareActionMode(this.getActionModeWrapper(var1), this.getMenuWrapper(var2));
      }
   }
}
