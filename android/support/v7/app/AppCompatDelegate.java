package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegateImplV11;
import android.support.v7.app.AppCompatDelegateImplV7;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public abstract class AppCompatDelegate {
   static final String TAG = "AppCompatDelegate";

   public static AppCompatDelegate create(Activity var0, AppCompatCallback var1) {
      return (AppCompatDelegate)(VERSION.SDK_INT >= 11?new AppCompatDelegateImplV11(var0, var0.getWindow(), var1):new AppCompatDelegateImplV7(var0, var0.getWindow(), var1));
   }

   public static AppCompatDelegate create(Dialog var0, AppCompatCallback var1) {
      return (AppCompatDelegate)(VERSION.SDK_INT >= 11?new AppCompatDelegateImplV11(var0.getContext(), var0.getWindow(), var1):new AppCompatDelegateImplV7(var0.getContext(), var0.getWindow(), var1));
   }

   public abstract void addContentView(View var1, LayoutParams var2);

   public abstract View createView(View var1, String var2, @NonNull Context var3, @NonNull AttributeSet var4);

   public abstract ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();

   public abstract MenuInflater getMenuInflater();

   public abstract ActionBar getSupportActionBar();

   public abstract void installViewFactory();

   public abstract void invalidateOptionsMenu();

   public abstract void onConfigurationChanged(Configuration var1);

   public abstract void onCreate(Bundle var1);

   public abstract void onDestroy();

   public abstract void onPostCreate(Bundle var1);

   public abstract void onPostResume();

   public abstract void onStop();

   public abstract boolean requestWindowFeature(int var1);

   public abstract void setContentView(int var1);

   public abstract void setContentView(View var1);

   public abstract void setContentView(View var1, LayoutParams var2);

   public abstract void setSupportActionBar(Toolbar var1);

   public abstract void setTitle(CharSequence var1);

   public abstract ActionMode startSupportActionMode(ActionMode.Callback var1);
}
